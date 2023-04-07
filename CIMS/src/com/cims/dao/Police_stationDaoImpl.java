package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

import com.cims.Ui.Colors;
import com.cims.Util.Dbutil;

public class Police_stationDaoImpl implements Police_StationDao {
	
	Colors color=new Colors();

	@Override
	public String psLogin(String user, String password) {
		// TODO Auto-generated method stub
		String login="Invalid User Or Password try again please ";
		try(Connection conn=Dbutil.connectToDb())
		{
			String query="select email,pass,name from users";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				if(rs.getString("email").equalsIgnoreCase(user) && rs.getString("pass").equalsIgnoreCase( hashSHA256(password))) {
					login="Welcome "+rs.getString("name");
					
					break;
				}
			}
		}catch(SQLException ex)
		{
			System.err.println(ex.getMessage());
			
		}
		
		return login;
	}

	@Override
	public String AdminLogin(String user, String password) {
		// TODO Auto-generated method stub
		String login="Invalid user or password";
		if(user.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin") ) {
			login="Login Suscessfull ";
		}
		return login;
	}

	@Override
	public void NewUserRegistration(String name, int age, String email, String pass) {
		// TODO Auto-generated method stub
			pass=hashSHA256(pass);
		String sql = "INSERT INTO users (name, age, email, pass) VALUES (?, ?, ?, ?)";
	    try (Connection conn = Dbutil.connectToDb();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, name);
	        stmt.setInt(2, age);
	        stmt.setString(3, email);
	        stmt.setString(4, pass);
	        int rowsInserted = stmt.executeUpdate();
	       if(rowsInserted>0)
	       {
	    	   System.out.println();
	    	   System.out.println(color.GREEN+color.WHITE_BACKGROUND+"Registration Successfull "+color.RESET);
	    	   System.out.println();
	       }
	    } catch (SQLException e) {
	        System.err.println("Error: " + e.getMessage());
	    }
		
	}
	//this method use generate SHA256 hash of input password string  string 
	 public static String hashSHA256(String input) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
	            StringBuilder hexString = new StringBuilder();

	            for (byte b : hash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }

	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }

}

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
	
	/**

    Authenticate the police station user by checking the provided username and password against the database.
    @param username the username of the police station user
    @param password the password of the police station user
    @return the status message of the authentication process, either "success" or an error message
    */
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
					
					
					login="Login Suscessfull";
					System.out.println(color.PURPLE+"Welcome"+" "+rs.getString("name")+color.RESET);
					
					break;
				}
			}
		}catch(SQLException ex)
		{
			System.err.println(ex.getMessage());
			
		}
		
		return login;
	}

	/**

    Authenticate the admin user by checking the provided username and password against the database.
    @param username the username of the admin user
    @param password the password of the admin user
    @return the status message of the authentication process, either "success" or an error message
    */

	@Override
	public String AdminLogin(String user, String password) {
		// TODO Auto-generated method stub
		String login="Invalid User Or Password try again please ";
		//hold the email   for further compression
		
		// database connection provider
		try(Connection conn=Dbutil.connectToDb())
		{
			String query="select email,pass from users";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
						
			while(rs.next()) {
				
				if(rs.getString("email").equalsIgnoreCase(user) && rs.getString("pass").equalsIgnoreCase( hashSHA256(password))) {
					
					login="Login Suscessfull";
					
					break;
				}
			}
		}catch(SQLException ex)
		{
			System.err.println(ex.getMessage());
			
		}
		
		
		return login;
	}
	/**

    Register a new user by inserting a new record into the user table in the database.
    @param name the name of the new user
    @param age the age of the new user
    @param email the email address of the new user
    @param pass the password of the new user
    */
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
	/**
	 * convert plain text to SHA2 hash 
	 @param  password 
	 @return hashed format string 
	 */
	 public static String hashSHA256(String password) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
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

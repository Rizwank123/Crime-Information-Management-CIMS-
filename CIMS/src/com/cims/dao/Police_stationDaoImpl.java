package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cims.Util.Dbutil;

public class Police_stationDaoImpl implements Police_StationDao {

	@Override
	public String psLogin(String user, String pass) {
		// TODO Auto-generated method stub
		String login="Invalid User Or Password try again please ";
		try(Connection conn=Dbutil.connectToDb())
		{
			String query="select email,pass,name from users";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("email").equalsIgnoreCase(user) && rs.getString("pass").equalsIgnoreCase(pass)) {
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
	    	   System.out.println("Registration Successfull ");
	    	   System.out.println();
	       }
	    } catch (SQLException e) {
	        System.err.println("Error: " + e.getMessage());
	    }
		
	}

}

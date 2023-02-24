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
			String query="select username,password,name from police_station";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("username").equalsIgnoreCase(user) && rs.getString("password").equalsIgnoreCase(pass)) {
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

}

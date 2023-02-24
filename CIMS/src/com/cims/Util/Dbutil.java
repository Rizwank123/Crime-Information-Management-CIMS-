package com.cims.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Dbutil {
	final static String URL;
	final static String username;
	final static String password;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.err.println("Fatal Error ! Unable to start Application");
			System.exit(1);
		}
		ResourceBundle db=ResourceBundle.getBundle("DBdetails");
		URL=db.getString("url");
		username=db.getString("username");
		password=db.getString("password");
	}
	public static Connection connectToDb() throws SQLException{
		return DriverManager.getConnection(URL,username,password);
	}
	public static void closeConnection(Connection conn) throws SQLException{
		if(conn!=null) {
			conn.close();
		}
	}

}

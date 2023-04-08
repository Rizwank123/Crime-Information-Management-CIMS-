package com.cims.dao;

public interface Police_StationDao {
	
	/**

    Authenticate the police station user by checking the provided username and password against the database.
    @param username the username of the police station user
    @param password the password of the police station user
    @return the status message of the authentication process, either "success" or an error message
    */
	public String psLogin(String username,String password);
	/**

    Authenticate the admin user by checking the provided username and password against the database.
    @param username the username of the admin user
    @param password the password of the admin user
    @return the status message of the authentication process, either "success" or an error message
    */
	public String AdminLogin(String username, String password);
	
	/**

    Register a new user by inserting a new record into the user table in the database.
    @param name the name of the new user
    @param age the age of the new user
    @param email the email address of the new user
    @param pass the password of the new user
    */
	public void NewUserRegistration(String name,int age,String email,String pass);

}

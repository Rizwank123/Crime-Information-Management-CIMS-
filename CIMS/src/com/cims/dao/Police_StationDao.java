package com.cims.dao;

public interface Police_StationDao {
	public String psLogin(String username,String password);
	public String AdminLogin(String username, String password);
	public void NewUserRegistration(String name,int age,String email,String pass);

}

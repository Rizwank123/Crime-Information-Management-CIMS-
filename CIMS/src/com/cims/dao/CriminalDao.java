package com.cims.dao;

import java.util.List;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dto.Criminal;
import com.cims.dto.Crime;

public interface CriminalDao {
	/* This method searches for all the crimes committed by a particular criminal whose name is given.
	 It takes a String parameter "name" which represents the criminal's name and throws a NoCrimeRecord exception 
	 if there is no criminal record found for the given name. */
	public List<Crime> SearchCriminalByName(String name) throws NoCrimeRecord;
	
	
	/*
	 * This method searches for all the criminals who have committed a particular crime whose id is given.
	 It takes an int parameter "id" which represents the crime id and throws a NoCrimeRecord exception 
	 if there is no criminal record found for the given crime id.
	 * */
	public List<Criminal> SearchCriminalByCrimeId(int id) throws NoCrimeRecord;
	
	

}

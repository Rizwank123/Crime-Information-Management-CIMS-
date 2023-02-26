package com.cims.dao;

import java.util.List;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dto.Criminal;
import com.cims.dto.Crime;

public interface CriminalDao {
	public List<Crime> SearchCriminalByName(String name) throws NoCrimeRecord;
	public List<Criminal> SearchCriminalByCrimeId(int id) throws NoCrimeRecord;
	
	

}

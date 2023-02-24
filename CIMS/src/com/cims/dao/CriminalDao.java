package com.cims.dao;

import java.util.List;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dto.Criminal;
import com.cims.dto.Crime;

public interface CriminalDao {
	public List<Crime> SearchCriminalByName() throws NoCrimeRecord;
	public List<Criminal> SearchCriminalByCrimeId(String name) throws NoCrimeRecord;
	
	

}

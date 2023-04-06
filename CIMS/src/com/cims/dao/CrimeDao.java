package com.cims.dao;

import java.sql.SQLException;
import java.util.List;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dto.Crime;

public interface CrimeDao {
	// Returns a list of crimes with the specified crime type.
	public List<Crime> findByCrimeType(String crimeType) throws NoCrimeRecord;

	// Returns a list of crimes that occurred in the current month.
	public List<Crime> findByCurrentMonth() throws NoCrimeRecord;

	// Returns a list of all crimes.
	public List<Crime> showCrimes() throws NoCrimeRecord;

	// Returns the crime with the specified victim name.
	public Crime findbyVictimName(String vName) throws NoCrimeRecord ;

	// Returns a list of solved crimes.
	public List<Crime> noOfSolvedCrime() throws NoCrimeRecord;

	// Returns a list of unsolved crimes.
	public List<Crime> noOfUnsolvedCrime() throws NoCrimeRecord;
	public void solvedIt(int crimeId) throws NoCrimeRecord;
	// void NewCrime(int crime_id,int CriminalId,String crime_type,String crime_desc,String location,int psId,String criminal,String victim,String Status,int age,String gender,String identityingMark,String address ) throws NoCrimeRecord;

	void newCrime(String crime_type, String crime_desc, String location, int psId, String criminal, String victim,
			String status, int age, String gender, String identifyingMark, String address) throws SQLException;

}

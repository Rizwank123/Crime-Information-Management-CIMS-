package com.cims.dao;

import java.util.List;

import com.cims.dto.Crime;

public interface CrimeDao {
	// Returns a list of crimes with the specified crime type.
	public List<Crime> findByCrimeType(String crimeType);

	// Returns a list of crimes that occurred in the current month.
	public List<Crime> findByCurrentMonth(String cMonth);

	// Returns a list of all crimes.
	public List<Crime> showCrimes();

	// Returns the crime with the specified victim name.
	public Crime findbyVictimName(String vName);

	// Returns a list of solved crimes.
	public List<Crime> noOfSolvedCrime();

	// Returns a list of unsolved crimes.
	public List<Crime> noOfUnsolvedCrime();

}

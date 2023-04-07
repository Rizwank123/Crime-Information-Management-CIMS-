package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.Util.Dbutil;
import com.cims.dto.Crime;
import com.mysql.cj.xdevapi.Statement;

public class CrimeDaoImpl implements CrimeDao {

	@Override
	public List<Crime> findByCrimeType(String crimeType) {
		
		// TODO Auto-generated method stub
		List<Crime>list=new ArrayList<>();
		String select_Query = "SELECT * FROM crime WHERE crime_type = ?  ";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			ps.setString(1, crimeType);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int crimId=rs.getInt("crime_id");
				String type=rs.getString("crime_type");
				Timestamp dateTime=rs.getTimestamp("date_time");
				String desc=rs.getString("crime_desc");
				String location=rs.getString("location");
				int psId=rs.getInt("ps_id");
				String crimnal=rs.getString("criminal");
				String victim=rs.getString("victim");
				String status=rs.getString("status");
				
				
				list.add(new Crime(crimId,location,type,dateTime,status,psId));
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return list;
			}

	@Override
	public List<Crime> findByCurrentMonth() {
		// TODO Auto-generated method stub
		String select_Query = "SELECT * FROM crime WHERE MONTH(date_time) = MONTH(CURRENT_DATE()) AND YEAR(date_time) = YEAR(CURRENT_DATE())";
		List<Crime>list=new ArrayList<>();
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int crimId=rs.getInt("crime_id");
				String type=rs.getString("crime_type");
				Timestamp dateTime=rs.getTimestamp("date_time");
				String desc=rs.getString("crime_desc");
				String location=rs.getString("location");
				int psId=rs.getInt("ps_id");
				String crimnal=rs.getString("criminal");
				String victim=rs.getString("victim");
				String status=rs.getString("status");
				
				
				list.add(new Crime(crimId,location,type,dateTime,status,psId));
			
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Crime> showCrimes() {
		// TODO Auto-generated method stub
		List<Crime>list=new ArrayList<>();
		String select_Query = "SELECT * FROM crime   ";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int crimId=rs.getInt("crime_id");
				String type=rs.getString("crime_type");
				Timestamp dateTime=rs.getTimestamp("date_time");
				String desc=rs.getString("crime_desc");
				String location=rs.getString("location");
				int psId=rs.getInt("ps_id");
				String crimnal=rs.getString("criminal");
				String victim=rs.getString("victim");
				String status=rs.getString("status");
				
				
				list.add(new Crime(crimId,location,type,dateTime,status,psId));
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return list;
		
	}

	//findbyVictimName method use find list of crime 
	@Override
	public Crime findbyVictimName(String vName) {
		
		Crime c=null;
		
		String select_Query = "SELECT * FROM crime WHERE victim = ?  ";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			ps.setString(1, vName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int crimId=rs.getInt("crime_id");
				String type=rs.getString("crime_type");
				Timestamp dateTime=rs.getTimestamp("date_time");
				String desc=rs.getString("crime_desc");
				String location=rs.getString("location");
				int psId=rs.getInt("ps_id");
				String crimnal=rs.getString("criminal");
				String victim=rs.getString("victim");
				String status=rs.getString("status");
				
				
				 c=new Crime(crimId,location,type,dateTime,status,psId);
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return c;
	}

	//noOfSolvedCrime method return the list of crime which status is solved
	@Override
	public List<Crime> noOfSolvedCrime() {
		List<Crime>list=new ArrayList<>();
		String select_Query = "SELECT * FROM crime WHERE status = 'solved'";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int crimId=rs.getInt("crime_id");
				String type=rs.getString("crime_type");
				Timestamp dateTime=rs.getTimestamp("date_time");
				String desc=rs.getString("crime_desc");
				String location=rs.getString("location");
				int psId=rs.getInt("ps_id");
				String crimnal=rs.getString("criminal");
				String victim=rs.getString("victim");
				String status=rs.getString("status");
				
				
				list.add(new Crime(crimId,location,type,dateTime,status,psId));
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return list;
		
	}

	
	//noOfUnSolvedCrime method return the list of crime which status is Unsolved
	@Override
	public List<Crime> noOfUnsolvedCrime() {
		// TODO Auto-generated method stub
		List<Crime>list=new ArrayList<>();
		String select_Query = "SELECT * FROM crime WHERE status = 'unsolved'";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int crimId=rs.getInt("crime_id");
				String type=rs.getString("crime_type");
				Timestamp dateTime=rs.getTimestamp("date_time");
				String desc=rs.getString("crime_desc");
				String location=rs.getString("location");
				int psId=rs.getInt("ps_id");
				String crimnal=rs.getString("criminal");
				String victim=rs.getString("victim");
				String status=rs.getString("status");
				
				
				list.add(new Crime(crimId,location,type,dateTime,status,psId));
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return list;
		
		
	}

	@Override
	public void solvedIt(int crimeId) throws NoCrimeRecord  {
		// TODO Auto-generated method stub
		String query="UPDATE crime SET status = 'Solved' WHERE crime_id = ?";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,crimeId);
			if(ps.executeUpdate()>0)
			{
				System.out.println("\033[0;92m"+"Case is Solved ");
			}
			else throw new NoCrimeRecord("No Record Found");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	
	
	
	public void newCrime(String crime_type, String crime_desc, String location, int psId, String criminal,
		    String victim, String status, int age, String gender, String identifyingMark, String address) throws SQLException {

		    Connection conn = null;
		    PreparedStatement stmt = null;

		    try {
		        conn = Dbutil.connectToDb();
		        conn.setAutoCommit(false);

		        // Insert new crime record
		        String insertCrimeQuery = "INSERT INTO crime (crime_type, date_time, crime_desc, location, ps_id, criminal, victim, status) "
		            + "VALUES (?, NOW(), ?, ?, ?, ?, ?, ?)";
		        stmt = conn.prepareStatement(insertCrimeQuery,stmt.RETURN_GENERATED_KEYS);

		        stmt.setString(1, crime_type);
		        stmt.setString(2, crime_desc);
		        stmt.setString(3, location);
		        stmt.setInt(4, psId);
		        stmt.setString(5, criminal);
		        stmt.setString(6, victim);
		        stmt.setString(7, status);

		        int affectedRows = stmt.executeUpdate();

		        if (affectedRows == 0) {
		            throw new SQLException("Failed to insert new crime record");
		        }

		        // Get the generated crime_id value for the new crime record
		        int crimeId;
		        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                crimeId = generatedKeys.getInt(1);
		            } else {
		                throw new SQLException("Failed to insert new crime record, no ID obtained.");
		            }
		        }

		        // Insert new criminal record
		        String insertCriminalQuery = "INSERT INTO criminal (crime_id, cr_name, cr_age, gender, identifying_mark, cr_address) "
		            + "VALUES (?, ?, ?, ?, ?, ?)";
		        stmt = conn.prepareStatement(insertCriminalQuery);

		        stmt.setInt(1, crimeId);
		        stmt.setString(2, criminal);
		        stmt.setInt(3, age);
		        stmt.setString(4, gender);
		        stmt.setString(5, identifyingMark);
		        stmt.setString(6, address);

		        stmt.executeUpdate();

		        conn.commit();
		    } catch (SQLException e) {
		        if (conn != null) {
		            try {
		                conn.rollback();
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		        throw e;
		    } finally {
		        conn.close();
		        stmt.close();
		    }
		}


	

	

}

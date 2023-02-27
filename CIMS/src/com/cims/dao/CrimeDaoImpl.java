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
				System.out.println("Case is Solved ");
			}
			else throw new NoCrimeRecord("No Record Found");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void NewCrime(int cr_id,String crime_type, String crime_desc, String location, int psId, String criminal,
			String victim, String Status ,int age,String gender,String identityingMark,String address ) throws NoCrimeRecord {
		// TODO Auto-generated method stub
		try(Connection conn=Dbutil.connectToDb())
		{
			 String sql = "INSERT INTO crime (crime_type, date_time, crime_desc, location, ps_id, criminal, victim, status) VALUES (?,?, NOW(), ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql);

	            // Set the values for the parameters of the SQL statement
	            
	            statement.setInt(1, cr_id);
	            statement.setString(2, crime_type);
	            statement.setString(3, crime_desc);
	            statement.setString(4,location);
	            statement.setInt(5, psId); // assuming police station id is 1
	            statement.setString(6, criminal);
	            statement.setString(7, victim);
	            statement.setString(8, Status);

	            // Execute the SQL statement
	            //int rowsInserted = statement.executeUpdate();
	            
	            String criminalQuery = "INSERT INTO criminal (crime_id, cr_name, cr_age,gender,identifying_mark,cr_address) VALUES ( ?, ?, ?,?,?,?)";
	            PreparedStatement criminalStatement = conn.prepareStatement(criminalQuery);
	            // replace with the actual criminal ID
	            criminalStatement.setInt(1, cr_id); // replace with the actual crime ID from the previous insert
	            criminalStatement.setString(2, criminal); // replace with the actual criminal name
	            criminalStatement.setInt(3, age); // replace with the actual criminal age
	            

	            if (statement.executeUpdate() > 0 &&criminalStatement.executeUpdate()>0 ) {
	                System.out.println("A new crime was inserted successfully!");
	            } else {
	               throw new NoCrimeRecord("Some Thing is Wrong Please Check Your Query");
	            }
	            {
	            	
	            }
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	

	

}

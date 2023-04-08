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
import com.cims.dto.Criminal;


public class CriminalDaoImpl implements CriminalDao {

	
	/**
	 * This method searches the database for all the crimes committed by a criminal with the given name.
	 * 
	 * @param name The name of the criminal to search for.
	 * @return A list of all the crimes committed by the criminal with the given name.
	 * @throws NoCrimeRecord If no criminal records matching the given name are found in the database.
	 */
	@Override
	public List<Crime> SearchCriminalByName(String name) throws NoCrimeRecord {
		// TODO Auto-generated method stub
		List<Crime>list=new ArrayList<>();
		String select_Query = "select * from crime c inner join criminal cm  on c.criminal=cm.cr_name where cm.cr_name=? ";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			ps.setString(1, name);
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

	/**
	 * This method searches the database for all the criminals who committed the crime with the given ID.
	 * 
	 * @param id The ID of the crime to search for.
	 * @return A list of all the criminals who committed the crime with the given ID.
	 * @throws NoCrimeRecord If no criminal records matching the given ID are found in the database.
	 */
	@Override
	public List<Criminal> SearchCriminalByCrimeId(int crimeId) throws NoCrimeRecord {
		// TODO Auto-generated method stub
		
		List<Criminal>list=new ArrayList<>();
		String select_Query="SELECT * FROM criminal c JOIN crime cr ON c.crime_id = cr.crime_id WHERE c.crime_id = ?";
				
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			ps.setInt(1, crimeId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("cr_id");
				String name1=rs.getString("cr_name");
				int age=rs.getInt("cr_age");
				String cr_add=rs.getString("cr_address");
				int crim_id=rs.getInt("crim_id");
				String gender=rs.getString("gende");
				String identifying_mark=rs.getString("identifying_mark");
				String crime_name=rs.getString("crime_type");
				String location=rs.getString("location");
				
				list.add(new Criminal(id,name1,age,gender,cr_add,identifying_mark,crime_name,location));
				
				
				
			}
			
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return list;
	}

	

}

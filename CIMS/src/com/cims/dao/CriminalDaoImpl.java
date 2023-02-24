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

	@Override
	public List<Crime> SearchCriminalByName() throws NoCrimeRecord {
		// TODO Auto-generated method stub
		List<Crime>list=new ArrayList<>();
		String select_Query = "select * from crime";
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

	private void getint(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Criminal> SearchCriminalByCrimeId(String name) throws NoCrimeRecord {
		// TODO Auto-generated method stub
		List<Criminal>list=new ArrayList<>();
		String select_Query="select * from crime where cr_name=?";
		try(Connection conn=Dbutil.connectToDb()){
			PreparedStatement ps=conn.prepareStatement(select_Query);
			ResultSet rs=ps.executeQuery();
			
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	

}

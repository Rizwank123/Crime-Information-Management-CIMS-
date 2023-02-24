package com.cims.Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dao.CriminalDao;
import com.cims.dao.CriminalDaoImpl;
import com.cims.dto.Crime;
import com.cims.dto.Criminal;

public class DashBoard {
	public void printAdminMenu(Scanner sc)  {
		String s="===================================\n"
				+ "==     Enter your Choice      ====\n"
				+ "==                            ====\n"
				+ "==================================\n";
		CriminalDao crm=new CriminalDaoImpl();
		int i=0;
		do {
		System.out.println(s);
		System.out.println("1. For search crime in Area");
		System.out.println("2. For search criminal ");
		System.out.println("3. For search  crime record in particular Police Statation ");
		System.out.println("4. Change the satus of the crime  ");
		System.out.println("5. New Record register   ");
		System.out.println("10. Logout   ");
		System.out.println("0. exit   ");
		
		 i=sc.nextInt();
		 switch(i)
		 {
		 case 1 : 
			 List<Crime>list=new ArrayList<>();
						 
			try {
				list= crm.SearchCriminalByName();
			} catch (NoCrimeRecord e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			list.forEach(e->System.out.println(e));
		 }
		
		}while(i!=0);
				
	}
	public void printUserMenu(Scanner sc) {
		int i=0;
		
		
	}
	

}

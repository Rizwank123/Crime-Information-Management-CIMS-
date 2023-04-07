package com.cims.Ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dao.CrimeDao;
import com.cims.dao.CrimeDaoImpl;
import com.cims.dao.CriminalDao;
import com.cims.dao.CriminalDaoImpl;
import com.cims.dao.Police_StationDao;
import com.cims.dao.Police_stationDaoImpl;
import com.cims.dto.Crime;
import com.cims.dto.Criminal;

public class DashBoard {
	Colors color=new Colors();
	CriminalDao crm=new CriminalDaoImpl();
	CrimeDao crime=new CrimeDaoImpl();
	Police_StationDao ps=new Police_stationDaoImpl();
	public void printAdminMenu(Scanner sc) throws SQLException, NoCrimeRecord  {
		String s="===================================\n"
				+ "*     Admin Menu   		      *\n"
				+ "*   Enter your Choice          *\n"
				+"===================================\n";
		
		int i=0;
		do {
		System.out.println(color.YELLOW_BRIGHT+s+color.RESET);
		System.out.println(color.YELLOW_BRIGHT+"1. For search crime ");
		System.out.println("2. For search crime of Criminal ");
		System.out.println("3. All Crime in  Current month ");
		System.out.println("4. Serch Crime by type ");
		System.out.println("5. Show all solved crimes   ");
		System.out.println("6. Show all Unsolved crimes   ");
		System.out.println("7. Search Crimnal by CrimeId   ");
		System.out.println("8. Search crime by victim   ");
		System.out.println("9. Make it Solved   ");
		System.out.println("10. Register new Crime   ");
		System.out.println("99. Logout   "+color.RESET);
		System.out.println(color.RED+"0. exit   "+color.RESET);
		
		 i=sc.nextInt();
		 switch(i)
		 {
		 case 1: 
			 List<Criminal>list1=new ArrayList<>();
			 List<Crime>list=new ArrayList<>();
						 
			 System.out.println(color.PURPLE+"Enter Criminal name: "+color.RESET);
			 sc.nextLine();
			 String st=sc.nextLine();
			try {
				
				list= crm.SearchCriminalByName(st);
				
				
			} catch (NoCrimeRecord e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getLocalizedMessage()+"No Record Found");;
			}
			System.out.println(color.PURPLE+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+color.RESET);
			list.forEach(e->System.out.println(color.BLUE+e+color.RESET));
			System.out.println(color.PURPLE+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+color.RESET);
			break;
		 case 2: 
			 
			 System.out.println("Enter Criminal name: ");
			 sc.nextLine();
			 String str=sc.nextLine();
			try {
				
				list= crm.SearchCriminalByName(str);
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				list.forEach(e->System.out.println(e));
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				
				
			} catch (NoCrimeRecord e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getLocalizedMessage()+"No Record Found");;
			}
			
		 	break;
		 	
		 	
		 case 3:  try {
			 
				list=crime.findByCurrentMonth(); //current month crime
				System.out.println(color.PURPLE+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+color.RESET);
				list.forEach(l->System.out.println(color.BLACK+color.WHITE_BACKGROUND+l+color.RESET));
				System.out.println(color.PURPLE+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+color.RESET);
			} catch (NoCrimeRecord e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage()+"No record found");
			}
		 	break;
		 case 4:
			 System.out.println(color.CYAN+"Enter Crime type: "+color.RESET);
			 try {
				list=crime.findByCrimeType(sc.next());
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				list.forEach(l->System.out.println(color.YELLOW+l+color.RESET));
				System.out.println(color.PURPLE+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+color.RESET);
			} catch (NoCrimeRecord e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getLocalizedMessage()+"No record found");
			}
			 break;
		 case 5: try {
				list=crime.noOfSolvedCrime();
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				list.forEach(l->System.out.println(l));
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			} catch (NoCrimeRecord e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 	break;
		 case 6:
			 try {
					list=crime.noOfUnsolvedCrime();
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					list.forEach(l->System.out.println(l));
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				} catch (NoCrimeRecord e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 break;

		 case 7:
			 try {
				 System.out.println("Enter crime Id ");
				 		int id=sc.nextInt();
				 
					list1=crm.SearchCriminalByCrimeId(id);
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					list1.forEach(l->System.out.println(l));
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				} catch (NoCrimeRecord e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 	break;
		 case 8:
			 try {
				 sc.nextLine();
				 System.out.println("Enter Victim name ");
				 		String id=sc.nextLine();
				 
					Crime c=crime.findbyVictimName(id);
					if(c==null) {
						throw new NoCrimeRecord("No Record Found");
					}
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					System.out.println(c);
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				} catch (NoCrimeRecord e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 	break;
		 case 9:
			 System.out.println("Crime Id ");
			 int crimeId=sc.nextInt();
			 crime.solvedIt(crimeId);
			 break;
			 
		 case 10:
			 System.out.println("Enter Crime Id ");
			 int cid=sc.nextInt();
			 sc.nextLine();
			 System.out.println("Enter Crime Type: ");
			 String crimeType=sc.nextLine();
			 System.out.println("Enter Crime Detail: ");
			 String crimeDes=sc.nextLine();
			 System.out.println("Enter Crime Location: ");
			 String Location=sc.nextLine();
			 System.out.println("Enter Criminal Name: ");
			 String criminal_name=sc.nextLine();
			 System.out.println("Enter Victim  Name: ");
			 String victim_name=sc.nextLine();
			 System.out.println("Enter Status  : ");
			 String status=sc.nextLine();
			 System.out.println("Enter gender ");
			 String gender=sc.nextLine();
			 System.out.println("Enter Address ");
			 String addr=sc.nextLine();
			 System.out.println("Enter Identification Mark ");
			 String idnt=sc.nextLine();
			 System.out.println("Enter Crime Police Station Id: ");
			 int psId=sc.nextInt();
			 System.out.println("Enter the age ");
			 int age=sc.nextInt();
			 crime.newCrime(crimeDes, crimeDes, Location, psId, criminal_name, victim_name, status, age, gender, idnt, addr);
			 break;
			 
			
		 case 99:
			 Main.main(null);
			 break;
			 
			 
		 }
			 
		
		}while(i!=0);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=->Thanks For visiting <-=-=-==-=-=-=-=-=-=-=-=-=-=-=");

				
	}
	public void printUserMenu(Scanner sc) throws NoCrimeRecord {
		String s="===================================\n"
				+ "*     User Menu   		      *\n"
				+ "*   Enter your Choice            *\n"
				+ "==================================\n";
		List<Crime>list=new ArrayList<>();
		int i=0;
		do {
			System.out.println(s);
			System.out.println("1. All Crimes ");
			System.out.println("10. Logout   ");
			System.out.println("0. exit   ");
			
			 i=sc.nextInt();
			 switch(i) {
			 case 1:try {
					list=crime.showCrimes();
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					list.forEach(l->System.out.println(l));
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				} catch (NoCrimeRecord e) {
					// TODO Auto-generated catch block
					throw new NoCrimeRecord(s+"No Rccord found");
				}
			 break;
			 case 10:
				 try {
					Main.main(null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoCrimeRecord e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 break;
			 }
		}while(i!=0);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=->Thanks For visiting <-=-=-==-=-=-=-=-=-=-=-=-=-=-=");

		
		
	}
	

}

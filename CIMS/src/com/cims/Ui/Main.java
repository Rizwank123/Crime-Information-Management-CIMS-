package com.cims.Ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dao.Police_StationDao;
import com.cims.dao.Police_stationDaoImpl;

public class Main {
	public static void main(String[] args) throws SQLException, NoCrimeRecord {
String banner = " ========================================================================================================================\n"
				+ "=  ====  ====  =========  ==========================================================     ===    ==  =====  ===      ==\n"
				+ "=  ====  ====  =========  =========================================================  ===  ===  ===   ===   ==  ====  =\n"
				+ "=  ====  ====  =========  =======================================  ===============  =========  ===  =   =  ==  ====  =\n"
				+ "=  ====  ====  ===   ===  ===   ====   ===  =  = ====   ========    ===   ========  =========  ===  == ==  ===  ======\n"
				+ "=   ==    ==  ===  =  ==  ==  =  ==     ==        ==  =  ========  ===     =======  =========  ===  =====  =====  ====\n"
				+ "==  ==    ==  ===     ==  ==  =====  =  ==  =  =  ==     ========  ===  =  =======  =========  ===  =====  =======  ==\n"
				+ "==  ==    ==  ===  =====  ==  =====  =  ==  =  =  ==  ===========  ===  =  =======  =========  ===  =====  ==  ====  =\n"
				+ "===    ==    ====  =  ==  ==  =  ==  =  ==  =  =  ==  =  ========  ===  =  ========  ===  ===  ===  =====  ==  ====  =\n"
				+ "====  ====  ======   ===  ===   ====   ===  =  =  ===   =========   ===   ==========     ===    ==  =====  ===      ==\n"
				+ "======================================================================================================================\n";
String[] colors = {"\033[0;31m", "\033[0;32m", "\033[0;33m", "\033[0;34m", "\033[0;35m", "\033[0;36m"};
String[] messages = {"Developed ", "By", "Mohammad ", "Rizwan!"};

StringBuilder sb = new StringBuilder();
for (String message : messages) {
    sb.append(colors[(int) (Math.random() * colors.length)]);
    sb.append(message);
    sb.append(" ");
}
sb.append("\033[0m");

System.out.println(colors[(int) (Math.random() * colors.length)]+banner);
System.out.println(sb.toString());
System.out.println();
		DashBoard dbs=new DashBoard();
		Police_StationDao ps=new Police_stationDaoImpl();
		
		Scanner sc=new Scanner(System.in);
			int i=0;
			do {
				System.out.println("1. For login Already Register user");
				System.out.println("2. For New  User  Register ");
				System.out.println("0. For Exit ");
				try {
					i=sc.nextInt();
				}catch(InputMismatchException ex )
				{
					System.out.println("Enter Integer Only");
					Main.main(args);
				}
				if(i==0 ||i==1 || i==2) {
				switch(i) {
				case 1: ps=new Police_stationDaoImpl();
						System.out.println("Please Enter the username: ");
						String uname=sc.next();
						System.out.println("Please Enter password: ");
						String pass=sc.next();
						
						
						if(uname.equalsIgnoreCase("admin")&& pass.equalsIgnoreCase("admin"))
						{
							String crd=ps.AdminLogin(uname, pass);
							System.out.println(crd);
							if(crd.equals("Invalid user or password"))
							{
								System.out.println("hi");
								Main.main(args);
							}
							else {
							dbs.printAdminMenu(sc);
							}
							
						}
						else if(!uname.equalsIgnoreCase("admin")) {
							String crd=ps.psLogin(uname, pass);

							System.out.println(crd);
							if(crd.equals("Invalid User Or Password try again please")) {
								System.out.println("hello");
								Main.main(args);
							}
							else {
							dbs.printUserMenu(sc);
							}
						}
						break;
						
				case 2:
					
					 System.out.println("Enter Name: ");
					 		String name=sc.next();
					 		System.out.println("User Age: ");
					 		int age=sc.nextInt();
					 		System.out.println("Enter Email: ");
					 		String email=sc.next();
					 		System.out.println("Enter password");
					 		String pswd=sc.next();
					 
						ps.NewUserRegistration(name,age,email,pswd);
							
						break;
				}
			}
				else System.out.println("Invalid Input\n");
				
			}while(i!=0);
			System.out.println("\033[092m"+"=-=-=-=-=-=-=-=-=-=-=-=-=->Thanks For visiting <-=-=-==-=-=-=-=-=-=-=-=-=-=-=");
			
			
			
					
	
	}
	

}

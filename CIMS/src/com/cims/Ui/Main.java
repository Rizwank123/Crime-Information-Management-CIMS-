package com.cims.Ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cims.Exceptions.NoCrimeRecord;
import com.cims.dao.Police_StationDao;
import com.cims.dao.Police_stationDaoImpl;

public class Main {
	public static void main(String[] args) throws SQLException, NoCrimeRecord {
		Colors color=new Colors(); //color library 
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
				System.out.println(color.GREEN+"1. For login Already Register user"+color.RESET);
				System.out.println(color.PURPLE+"2. For New  User  Register "+color.RESET);
				System.out.println(color.RED+"0. For Exit "+color.RESET);
				try {
					i=sc.nextInt();
				}catch(InputMismatchException ex )
				{
					System.out.println(color.BLUE_BOLD+"Enter Integer Only"+color.RESET);
					Main.main(args);
				}
				if(i==0 ||i==1 || i==2) {
				switch(i) {
				case 1: ps=new Police_stationDaoImpl();
						System.out.println(color.GREEN_BRIGHT+"Please Enter the user Email: "+color.RESET);
						String uname=sc.next();
						
						String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; //regex for validating email

				 		Pattern pattern = Pattern.compile(regex);

				 	
				 			Matcher matcher = pattern.matcher(uname);
				 			if(!matcher.matches()) {
				 				System.out.println(color.RED+color.CYAN_BACKGROUND+"Please Enter valid email ex= eg@example.com "+color.RESET);
				 				uname=sc.next();
				 			}
						System.out.println(color.BLUE+"Please Enter password: "+color.RESET);
						String pass=sc.next();
						
						
						if(uname.equalsIgnoreCase("admin")&& pass.equalsIgnoreCase("admin"))
						{
							String crd=ps.AdminLogin(uname, pass);
							System.out.println(crd);
							if(crd.equals(color.RED_BRIGHT+"Invalid user or password"+color.RESET))
							{
//								System.out.println("hi");
								Main.main(args);
							}
							else {
							dbs.printAdminMenu(sc);
							}
							
						}
						else if(!uname.equalsIgnoreCase("admin")) {
							String crd=ps.psLogin(uname, pass);

							System.out.println(crd);
							if(crd.equals(color.RED_BOLD+"Invalid User Or Password try again please"+color.RESET)) {
//								System.out.println("hello");
								Main.main(args);
							}
							else {
							dbs.printUserMenu(sc);
							}
						}
						break;
						
				case 2:
					
					 System.out.println(color.BLUE+"Enter Name: "+color.RESET);
					 		String name=sc.next();
					 		System.out.println(color.BLUE+"User Age: "+color.RESET);
					 		int age=sc.nextInt();
					 		System.out.println(color.GREEN+"Enter Email: "+color.RESET);
					 		String email=sc.next();
			
					 		String regex1 = "^[A-Za-z0-9+_.-]+@(.+)$";

					 		Pattern pattern1 = Pattern.compile(regex1);

					 	
					 			Matcher matcher1 = pattern1.matcher(email);
					 			if(!matcher1.matches()) {
					 				System.out.println(color.RED+color.PURPLE_BACKGROUND+"Please Enter valid email ex= eg@example.com "+color.RESET);
					 				email=sc.next();
					 			}
					 		
					 		System.out.println(color.YELLOW_BRIGHT+"Enter password"+color.RESET);
					 		String pswd=sc.next();
					 
						ps.NewUserRegistration(name,age,email,pswd);
							
						break;
				}
			}
				else System.out.println(color.RED_BOLD_BRIGHT+"Invalid Input\n"+color.RESET);
				
			}while(i!=0);
			System.out.println(color.GREEN+color.WHITE+"=-=-=-=-=-=-=-=-=-=-=-=-=->Thanks For visiting <-=-=-==-=-=-=-=-=-=-=-=-=-=-="+color.RESET);
			
			
			
					
	
	}
	

}

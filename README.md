<h1 align="center">Crime Information Management System</h1>

<p>This is a Crime Information Management System (CIMS) built using Java and MySQL.<br> It provides a platform for police departments to manage crime data, including criminal information, crime types, and police station information.</p>

<h3>Features</h3>

The system includes the following features:
<ul>
<li>Add, edit, and delete crime types</li>

   <li> Add, edit, and delete police stations</li>
    <li>Add, edit, and delete criminals</li>
   <li> Add new crimes and associate them with relevant data such as criminals, victims, police stations, and crime types</li>
    <li> View crime data including crime statistics and details of specific crimes</li>

</ul>
<h3>Getting Started</h3>
Prerequisites

To run this project, you will need:

    Java Development Kit (JDK) 8 or later
    MySQL server

<h3>Installation</h3>

    Clone the repository:

git clone https://github.com/username/CIMS.git

    Set up the MySQL database using the mysql.sql file included in the repository:

mysql -u root -p cims < mysql.sql

    Update the database.properties file with your MySQL credentials.

    Compile the project:

javac \*.java

    Run the project:

java Main

Usage

The system is menu-driven and user-friendly. Simply follow the prompts to navigate the different options and perform various operations.
Contributing
<h3 align="center">Sql Queries</h3>
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=
select email,pass,name from users<br>
INSERT INTO users (name, age, email, pass) VALUES (?, ?, ?, ?)";<br>
Query for finding crime in current Month ->  "SELECT * FROM crime WHERE MONTH(date_time) = MONTH(CURRENT_DATE()) AND YEAR(date_time) = YEAR(CURRENT_DATE())";<br>

Query for finding all solved crime->   "SELECT * FROM crime WHERE status = 'solved'"<br>
Query for finding all Unsolved crime->   "SELECT * FROM crime WHERE status = 'Unsolved'"<br>
Query for solved the crime->  UPDATE crime SET status = 'Solved' WHERE crime_id = ?"<br>
Query for register new crime -> "INSERT INTO crime (crime_type, date_time, crime_desc, location, ps_id, criminal, victim, status) "
		            + "VALUES (?, NOW(), ?, ?, ?, ?, ?, ?)";<br>
                    
                    "INSERT INTO criminal (crime_id, cr_name, cr_age, gender, identifying_mark, cr_address) "
		            + "VALUES (?, ?, ?, ?, ?, ?)";
-=-=-=-=-=--==--=-==---=-=-=-==-=-=-=-=--==--=-=-=-=-=-==-=-=-=--=-=-==-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=

Contributions to the project are welcome. Please submit a pull request with your proposed changes.

<h1 align=center>ER Diagram</h1>
<img src="https://raw.githubusercontent.com/Rizwank123/third-ice-7307/day_5/img/sql.png">

<h3 align="center" style="color:red;">Project Presentation  video</h3>



[![Video](https://raw.githubusercontent.com/Rizwank123/third-ice-7307/main/img/1.png)](https://drive.google.com/file/d/1bXQJJSzBqwyWkQ0vn1YF2tO94c5ZQG7x/view?usp=share_link)



insert into users(name,age,email,pass)values("venom",24,"expert@gmail.com,SHA2("rizwan",256));
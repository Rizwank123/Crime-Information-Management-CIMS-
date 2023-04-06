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

    <b>Java Development Kit (JDK) 8 or later
    MySQL server</b>

<h3>Installation</h3>

    Clone the repository:
git clone https://github.com/username/CIMS.git

    Set up the MySQL database using the mysql.sql file included in the repository:



mysql -u root -p cims < mysql.sql

    Update the database.properties file with your MySQL credentials.

    Compile the project:

javac *.java

    Run the project:



java Main

Usage

The system is menu-driven and user-friendly. Simply follow the prompts to navigate the different options and perform various operations.
Contributing

Contributions to the project are welcome. Please submit a pull request with your proposed changes.
<h1 align=center>ER Diagram</h1>
<img src="https://raw.githubusercontent.com/Rizwank123/third-ice-7307/day_5/img/sql.png">

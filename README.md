Crime Information Management System

This is a Crime Information Management System (CIMS) built using Java and MySQL. It provides a platform for police departments to manage crime data, including criminal information, crime types, and police station information.
Features

The system includes the following features:

    Add, edit, and delete crime types
    Add, edit, and delete police stations
    Add, edit, and delete criminals
    Add new crimes and associate them with relevant data such as criminals, victims, police stations, and crime types
    View crime data including crime statistics and details of specific crimes

Getting Started
Prerequisites

To run this project, you will need:

    Java Development Kit (JDK) 8 or later
    MySQL server

Installation

    Clone the repository:
git clone https://github.com/username/CIMS.git

    Set up the MySQL database using the mysql.sql file included in the repository:

css

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

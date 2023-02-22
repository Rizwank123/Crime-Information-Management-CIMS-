-- Table 1 crime_Table
CREATE TABLE Crime (
    crime_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    crime_type VARCHAR(250) NOT NULL,
    date_time DATETIME NOT NULL,
    crime_desc VARCHAR(250) NOT NULL,
    location VARCHAR(50) NOT NULL,
    ps_id INT NOT NULl
);
-- Table 2 victem_table
create table Victim(
    victim_id INT not NULL AUTO_INCREMENT PRIMARY KEY,
    v_name varchar(25) not null,
    v_age int not null,
    v_address varchar(55) not null,
    crime_id int not null,
    FOREIGN key(crime_id) REFERENCES Crime(crime_id)
);
-- Table 3 Suspect table 
create table Suspect(
    s_id int not null PRIMARY KEY auto_increment,
    s_name varchar(30) not null,
    s_age int not null,
    gender varchar(20),
    identifying_marks varchar(100) not null,
    crime_id int not null,
    FOREIGN KEY(crime_id) REFERENCES Crime(crime_id)
);
-- Table 4 police_station 
create table police_station(
    ps_id int not null PRIMARY KEY auto_increment,
    ps_name varchar(30) not null,
    ps_address varchar(250) not null,
    phone varchar(20) not null
);

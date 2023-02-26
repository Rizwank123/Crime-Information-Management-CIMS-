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

-- Table 3 Suspect table 

-- Table 4 police_station 
create table police_station(
    ps_id int not null PRIMARY KEY auto_increment,
    ps_name varchar(30) not null,
    ps_address varchar(250) not null,
    phone varchar(20) not null
);

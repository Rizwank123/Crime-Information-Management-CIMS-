-- MySQL dump 10.13  Distrib 8.0.32, for macos11.7 (x86_64)
--
-- Host: localhost    Database: cims
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crime`
--

DROP TABLE IF EXISTS `crime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime` (
  `crime_id` int NOT NULL AUTO_INCREMENT,
  `crime_type` varchar(250) NOT NULL,
  `date_time` datetime NOT NULL,
  `crime_desc` varchar(250) NOT NULL,
  `location` varchar(50) NOT NULL,
  `ps_id` int NOT NULL,
  `criminal` varchar(30) NOT NULL,
  `victim` varchar(25) NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`crime_id`),
  KEY `ps_id` (`ps_id`),
  CONSTRAINT `crime_ibfk_1` FOREIGN KEY (`ps_id`) REFERENCES `police_station` (`ps_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime`
--

LOCK TABLES `crime` WRITE;
/*!40000 ALTER TABLE `crime` DISABLE KEYS */;
INSERT INTO `crime` VALUES (4,'Robbery','2022-12-15 18:30:00','A shop was robbed at gunpoint','New York',1,'John Doe','Jane Smith','Under Investigation'),(5,'Burglary','2023-02-21 12:00:00','Stole jewelry from residence','456 Oak Ave, Anytown USA',1,'John Doe','Jane Doe','Under Investigation'),(6,'Theft','2022-02-21 10:00:00','Stole a laptop','Main Street',1,'John Doe','Jane Smith','Under Investigation'),(7,'Robbery','2022-12-12 18:30:00','Robbery at a local store','Main Street',1,'John Doe','Jane Doe','Investigation ongoing'),(8,'Robbery','2022-12-12 18:30:00','Robbery at a local store','Main Street',1,'John Doe','Jane Doe','Investigation ongoing'),(13,'Robbery','2022-12-15 18:30:00','A shop was robbed at gunpoint','New York',1,'John Doe','Jane Smith','Solved'),(19,'Robbery','2022-12-15 18:30:00','A shop was robbed at gunpoint','New York',1,'John Doe','Jane Smith','Solved'),(20,'Burglary','2023-02-21 12:00:00','Stole jewelry from residence','456 Oak Ave, Anytown USA',1,'John Doe','Jane Doe','Solved'),(21,'Theft','2022-02-21 10:00:00','Stole a laptop','Main Street',1,'John Doe','Jane Smith','Solved'),(22,'Robbery','2022-12-12 18:30:00','Robbery at a local store','Main Street',1,'John Doe','Jane Doe','Solved'),(23,'Robbery','2022-12-12 18:30:00','Robbery at a local store','Main Street',1,'John Doe','Jane Doe','Solved'),(24,'Assault','2023-02-20 14:30:00','Assaulted a person in a public park','Central Park, New York',1,'John Doe','Jane Smith','unsolved'),(25,'Theft','2023-02-19 09:00:00','Stole a purse from a woman in a subway','Grand Central Station, New York',1,'John Doe','Amy Lee','unsolved'),(26,'Robbery','2023-02-18 20:00:00','Robbed a convenience store at gunpoint','123 Main Street, New York',1,'John Doe','Mike Brown','unsolved'),(27,'Burglary','2023-02-26 17:17:24','Stole electronics from a residence','123 Main St, Anytown USA',1,'John Doe','Jane Smith','Under Investigation'),(28,'Burglary','2023-02-26 17:22:14','Stole electronics from a residence','123 Main St, Anytown USA',1,'John Doe','Jane Smith','Under Investigation'),(29,'identity theft owership theft','2023-02-26 17:33:45','identity theft owership theft','lucknow',1,'Mark devid','hcl corp','under investigation');
/*!40000 ALTER TABLE `crime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criminal`
--

DROP TABLE IF EXISTS `criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criminal` (
  `cr_id` int NOT NULL AUTO_INCREMENT,
  `cr_name` varchar(25) NOT NULL,
  `cr_age` int NOT NULL,
  `cr_address` varchar(55) NOT NULL,
  `crime_id` int NOT NULL,
  `gender` varchar(15) NOT NULL,
  `identifying_mark` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cr_id`),
  KEY `crime_id` (`crime_id`),
  CONSTRAINT `criminal_ibfk_1` FOREIGN KEY (`crime_id`) REFERENCES `Crime` (`crime_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criminal`
--

LOCK TABLES `criminal` WRITE;
/*!40000 ALTER TABLE `criminal` DISABLE KEYS */;
INSERT INTO `criminal` VALUES (4,'Mark Johnson',30,'1234 Elm Street',6,'Male',NULL),(5,'John Doe',30,'123 Main St.',7,'Male',NULL),(6,'John Doe',30,'123 Main St.',8,'Male',NULL);
/*!40000 ALTER TABLE `criminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `police_station`
--

DROP TABLE IF EXISTS `police_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `police_station` (
  `ps_id` int NOT NULL AUTO_INCREMENT,
  `ps_name` varchar(30) NOT NULL,
  `ps_address` varchar(250) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`ps_id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `police_station`
--

LOCK TABLES `police_station` WRITE;
/*!40000 ALTER TABLE `police_station` DISABLE KEYS */;
INSERT INTO `police_station` VALUES (1,'City Police Station','123 Main St','555-1234','rizwan','rizwan1212','Mohammad Rizwan');
/*!40000 ALTER TABLE `police_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Rizwan',25,'rizwan@gmail.com','password123'),(2,'venom',25,'v@gmail.com','12345'),(3,'Tabraj',10,'t@gmail.com','t12345'),(4,'hack',20,'hack@gmail.com','12345'),(5,'Imran',25,'ftg@gmail.com','i12345');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-26 23:24:01

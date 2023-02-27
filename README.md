

Enter Integer Only
 ========================================================================================================================
=  ====  ====  =========  ==========================================================     ===    ==  =====  ===      ==
=  ====  ====  =========  =========================================================  ===  ===  ===   ===   ==  ====  =
=  ====  ====  =========  =======================================  ===============  =========  ===  =   =  ==  ====  =
=  ====  ====  ===   ===  ===   ====   ===  =  = ====   ========    ===   ========  =========  ===  == ==  ===  ======
=   ==    ==  ===  =  ==  ==  =  ==     ==        ==  =  ========  ===     =======  =========  ===  =====  =====  ====
==  ==    ==  ===     ==  ==  =====  =  ==  =  =  ==     ========  ===  =  =======  =========  ===  =====  =======  ==
==  ==    ==  ===  =====  ==  =====  =  ==  =  =  ==  ===========  ===  =  =======  =========  ===  =====  ==  ====  =
===    ==    ====  =  ==  ==  =  ==  =  ==  =  =  ==  =  ========  ===  =  ========  ===  ===  ===  =====  ==  ====  =
====  ====  ======   ===  ===   ====   ===  =  =  ===   =========   ===   ==========     ===    ==  =====  ===      ==
======================================================================================================================



1. For login Already Register user
2. For New  User  Register 
0. For Exit 

Login Suscessfull 
===================================
*     Admin Menu   		      	 *
*   Enter your Choice            *
===================================

1. For search crime in Area
2. For search crime of Criminal 
3. All Crime in  Current month 
4. Serch Crime by type 
5. Show all solved crimes   
6. Show all Unsolved crimes   
7. Search Crimnal by CrimeId   
8. Search crime by victim   
9. Make it Solved   
10. Register new Crime   
99. Logout   
0. exit   

mysql> desc crime;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| crime_id   | int          | NO   | PRI | NULL    | auto_increment |
| crime_type | varchar(250) | NO   |     | NULL    |                |
| date_time  | datetime     | NO   |     | NULL    |                |
| crime_desc | varchar(250) | NO   |     | NULL    |                |
| location   | varchar(50)  | NO   |     | NULL    |                |
| ps_id      | int          | NO   | MUL | NULL    |                |
| criminal   | varchar(30)  | NO   |     | NULL    |                |
| victim     | varchar(25)  | NO   |     | NULL    |                |
| status     | varchar(25)  | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+

mysql> desc criminal;
+------------------+-------------+------+-----+---------+----------------+
| Field            | Type        | Null | Key | Default | Extra          |
+------------------+-------------+------+-----+---------+----------------+
| cr_id            | int         | NO   | PRI | NULL    | auto_increment |
| cr_name          | varchar(25) | NO   |     | NULL    |                |
| cr_age           | int         | NO   |     | NULL    |                |
| cr_address       | varchar(55) | NO   |     | NULL    |                |
| crime_id         | int         | NO   | MUL | NULL    |                |
| gender           | varchar(15) | NO   |     | NULL    |                |
| identifying_mark | varchar(30) | YES  |     | NULL    |                |
+------------------+-------------+------+-----+---------+----------------+

+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| ps_id      | int          | NO   | PRI | NULL    | auto_increment |
| ps_name    | varchar(30)  | NO   |     | NULL    |                |
| ps_address | varchar(250) | NO   |     | NULL    |                |
| phone      | varchar(12)  | NO   | UNI | NULL    |                |
| username   | varchar(20)  | YES  |     | NULL    |                |
| password   | varchar(20)  | YES  |     | NULL    |                |
| name       | varchar(25)  | YES  |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
<img src="/img/1.png" alt="" align="center">
<img src="/img/2.png" alt=" " align="center">
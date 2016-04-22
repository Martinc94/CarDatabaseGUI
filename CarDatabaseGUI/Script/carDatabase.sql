  /*drop database  */
Drop database if exists carDB;
Show databases;
create database carDB CHARACTER SET utf8 COLLATE UTF8_GENERAL_CI ;
Use carDB;
Show tables;
Drop table if exists car;
  
 /* create table*/
  create table car (
	id 		int unsigned NOT NULL auto_increment,
	reg 	Varchar(30),
	make 	Varchar(30),
	model 	Varchar(30),
	colour 	Varchar(30),
	price   DECIMAL(7,2) unsigned,
	description Varchar(100),
	
	PRIMARY KEY (Id)
  ) DATA DIRECTORY='c:/wamp';
  
  /*insert into table*/
  Insert into car (id,reg,make,model,colour,price,description) values ('0','12-G-1234','Toyota','Corolla','Red','15000.00','Excellent Condition');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','10-SO-43991','Ford','Focus','Blue','11000.00','Taxed and NCT');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','131-G-149','Skoda','Octavia','Maroon','16000.00','Like New');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','96-D-752','Skoda','Fabia','Green','900.00','Needs Slight Work');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','00-C-37','Honda','Civic','White','1200.00','Four New Tyres');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','03-MO-9452','Hyundai','Accent','Gold','2100.00','One Owner from new');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','07-G-6823','Nissan','Primastar','White','3700.00','New Sliding Door');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','08-D-8275','Citroen','C4','Red','5600.00','Snall dent on right side');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','08-D-432','Renault','Laguna','Black','4000.00','New Engine');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','02-K-3723','Honda','Civic','Red','1500.00','New Seats');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','06-D-82343','Toyota','Avensis','Blue','6000.00','Needs new clutch ');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','131-DL-4431','Audi','A6','Silver','28000.00','Like New');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','02-G-7623','Peugeot','206','Blue','1200.00','Needs new rear bumper');
  Insert into car (id,reg,make,model,colour,price,description) values ('0','00-C-37','Volkswagen','Passat','Silver','12500.00','NCT until July');
  
  
  /*display table*/
  Select * from car;
  
   
  
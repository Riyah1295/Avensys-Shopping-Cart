create database Shopping;

use Shopping;

CREATE TABLE `shopping`.`user` (
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Firstname` VARCHAR(45) NOT NULL,
  `Lastname` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL UNIQUE,
  `Gender` VARCHAR(45) NOT NULL,
  `Dob` DATE NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Contact` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Username`));
  
DROP TABLE `shopping`.`user`;
SELECT * FROM shopping.user;
  
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('chewes0', 'Z66ETbOZ', 'Chauncey', 'Hewes', 'chewes0@instagram.com', 'Male', '1980-12-09', '83358 Nelson Lane', '227-759-9990');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('hsunman1', 'gykeI38I', 'Hugibert', 'Sunman', 'hsunman1@nature.com', 'Male', '1961-05-23', '30560 Northridge Circle', '115-731-8097');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('jbarrim2', '7PGb8A2', 'Jedediah', 'Barrim', 'jbarrim2@vkontakte.ru', 'Male', '2013-11-23', '3 Green Street', '558-371-7471');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('rsolomon3', 'dNqTYA', 'Renell', 'Solomon', 'rsolomon3@eventbrite.com', 'Female', '1979-02-18', '7 Hoffman Pass', '725-908-9435');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('wcleator4', 'SzJH8BLJpol', 'Weber', 'Cleator', 'wcleator4@who.int', 'Male', '1986-05-17', '23334 Kim Court', '746-168-2269');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('gaustins5', 'xIv20MRBYsl', 'Georas', 'Austins', 'gaustins5@whitehouse.gov', 'Male', '1971-02-21', '30 Ohio Plaza', '203-299-3371');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('blandon6', 'bKSfjgphFjYe', 'Barbi', 'Landon', 'blandon6@google.com.au', 'Female', '2006-08-10', '815 Anzinger Avenue', '484-760-8020');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('kkeavy7', '50Ns8Ix1KgS', 'Klarrisa', 'Keavy', 'kkeavy7@flickr.com', 'Female', '1988-11-25', '63 Lakewood Way', '674-124-0858');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('amarvin8', 'zuF2qBou5Fml', 'Alice', 'Marvin', 'amarvin8@mac.com', 'Female', '2003-03-20', '87675 Springview Place', '496-341-4861');
insert into shopping.user (Username, Password, Firstname, Lastname, Email, Gender, Dob, Address, Contact) values ('klloyds9', 'CU1nMT', 'Katleen', 'Lloyds', 'klloyds9@gnu.org', 'Female', '2007-02-15', '3 Sachs Parkway', '432-943-0928');

  
  
  
  CREATE TABLE `shopping`.`product` (
  `Product_Id` INT NOT NULL,
  `Product_Name` VARCHAR(45) NOT NULL,
  `Product_Desc` VARCHAR(45) NOT NULL,
  `Product_Price` DOUBLE NOT NULL,
  PRIMARY KEY (`Product_Id`));

DROP TABLE `shopping`.`product`;
SELECT * FROM shopping.user;

insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (1, 'Shirt', 'Insertion of Spacer', 23.24);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (2, 'Shorts', 'Insertion of Single Array Stimulator', 35.23);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (3, 'T-Shirt', 'Dilation of Left Lesser', 33.00);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (4, 'Pants', 'Dilation of Right Pulmonary Vein', 41.34);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (5, 'Jacket', 'Resection of Left Metatarsal', 500.12);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (6, 'Windbreaker', 'Dilation of Left Large Intestine', 61.23);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (7, 'Socks', 'Replacement of Right Greater', 73.15);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (8, 'Cap', 'Alteration of Bilateral External Ear', 0.10);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (9, 'Underwear', 'Revision of Nonautologous Tissue', 90.00);
insert into shopping.product (Product_Id, Product_Name, Product_Desc, Product_Price) values (10, 'Belt', 'Bypass Superior Vena Cava', 0.59);




CREATE TABLE `shopping`.`cart` (
  `Username` VARCHAR(45) NOT NULL,
  `Product_Id` INT NOT NULL,
  `Quantity` INT NOT NULL,
  INDEX `Username_idx` (`Username` ASC),
  INDEX `Product_Id_idx` (`Product_Id` ASC),
  CONSTRAINT `Username`
    FOREIGN KEY (`Username`)
    REFERENCES `shopping`.`user` (`Username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Product_Id`
    FOREIGN KEY (`Product_Id`)
    REFERENCES `shopping`.`product` (`Product_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

  DROP TABLE `shopping`.`cart`;

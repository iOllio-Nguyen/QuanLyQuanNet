 create database project3;
 use project3;

CREATE TABLE Customer (
	username varchar(50) not null,
	password varchar(255) not null,
    currentState bit default 0, 
    currentMoney float not null default 5000,
	fullName varchar(50) null,
	phone varchar(11) null,
    createdAt timestamp not null default now(),
	Primary Key (username)
);

CREATE TABLE Staff (
	username varchar(50) not null,
	password varchar(255) not null,
	role bit not null, 
    fullName varchar(50) not null,
	phone varchar(11) not null,
    address varchar(50) not null,
    createdAt timestamp not null default now(),
	Primary Key (username)
);

Create TABLE Computer(
	idComputer varchar(10) not null,
    currentState bit default 1, 
    Primary Key (idComputer)
);

Create TABLE LogHistory(
	idHistory int AUTO_INCREMENT not null,
	usernameOfCustomer varchar(50) not null,
	idComputer varchar(10) not null,
	logState bit not null, 
    createdAt timestamp not null default now(),
	Primary Key (idHistory)
);

Create TABLE RechargeHistory(
	idHistory int AUTO_INCREMENT not null,
	usernameOfStaff varchar(50) not null,
    usernameOfCustomer varchar(50) not null,
    totalMoney float not null,
    createdAt timestamp not null default now(),
    Primary Key (idHistory)
);

Create TABLE Service(
	idService varchar(20) not null, 
	nameOfService varchar(50) not null,     
	tyoeOfService varchar(50) not null,
	priceOfService float not null,
    totalAmount int not null,
    avaiable bit not null,
    Primary Key (idService)
);

Create TABLE PurchaseHistory(
	idHistory int AUTO_INCREMENT not null,
    idService varchar(20) not null, 
    priceOfService float not null,
    totalAmount int null,
	outputAmount int not null,
	createdAt timestamp not null default now(),
    Primary Key (idHistory)
);

Create TABLE ImportHistory(
	idHistory int AUTO_INCREMENT not null,
	idService varchar(20) not null, 
    totalAmount int not null,
	inputAmount int not null,
	createdAt timestamp not null default now(),
    Primary Key (idHistory)
);


Create Table Shift(
	id int AUTO_INCREMENT not null,
	staffUsername varchar(50) not null,
    startTime timestamp not null default now(),
    endTime timestamp not null default now(),
    totalMoney float not null,
    Primary Key (id)
);

Create Table ShiftDetail(
	id int not null,
	idService  varchar(20) not null,
    totalAmount int not null
);

######################################## FOREIGN KEY ########################################

# Lich Su Dang Nhap
Alter Table LogHistory 
Add Constraint FK_Log_Customer Foreign Key (usernameOfCustomer)
References Customer(username);

Alter Table LogHistory 
Add Constraint FK_Log_Computer Foreign Key (idComputer)
References Computer(idComputer);

# Lich Su Nap Tien
Alter Table RechargeHistory 
Add Constraint FK_Recharge_Customer Foreign Key (usernameOfCustomer)
References Customer(username);

Alter Table RechargeHistory 
Add Constraint FK_Recharge_Staff Foreign Key (usernameOfStaff)
References Staff(username);

# Lich Su Mua Hang
Alter Table PurchaseHistory 
Add Constraint FK_Purchase_Service Foreign Key (idService)
References Service(idService);

# Lich Su Nhap Kho
Alter Table ImportHistory 
Add Constraint FK_Import_Service2 Foreign Key (idService)
References Service(idService);

Alter Table Shift 
Add Constraint FK_Staff Foreign Key (staffUsername)
References Staff(username);

Alter Table ShiftDetail 
Add Constraint FK_ShiftID Foreign Key (id)
References Shift(id);

Alter Table ShiftDetail 
Add Constraint FK_idService_ShiftDetail Foreign Key (idService)
References service(idService);


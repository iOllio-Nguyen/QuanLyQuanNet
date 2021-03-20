-- logout / Login
DROP PROCEDURE IF EXISTS Logout;
Delimiter //
CREATE PROCEDURE Logout (customerUsername varchar(50), idComputer varchar(20))
BEGIN
	update customer set currentState = 0 where username = customerUsername;
    insert into LogHistory (usernameOfCustomer, idComputer, logState) values
	(customerUsername, idComputer, 0);
END;    

-------------------------------
DROP PROCEDURE IF EXISTS Login;
Delimiter //
CREATE PROCEDURE Login (customerUsername varchar(50), idComputer varchar(20))
BEGIN
	update customer set currentState = 1 where username = customerUsername;
    insert into LogHistory (usernameOfCustomer, idComputer, logState) values
	(customerUsername, idComputer, 1);
END;    

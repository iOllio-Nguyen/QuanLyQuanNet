USE PROJECT4;

-- -------------------- New shift
DROP PROCEDURE IF EXISTS NewShift;
Delimiter //
CREATE PROCEDURE NewShift(IN username varchar(50))
BEGIN
if((select count(*) from shift) > 0) then
    IF (username not like  (SELECT staffUsername FROM shift ORDER BY id DESC LIMIT 1)) THEN		
        insert into shift (staffUsername, totalmoney) values (username,  0);                   
    END IF;
else
	insert into shift (staffUsername, totalmoney) values (username, 0);                
end if;
END;
--------------------------------------- Tiền net
DROP PROCEDURE IF EXISTS SumRechargeHistory;
Delimiter //
CREATE PROCEDURE SumRechargeHistory(IN loginDate varchar(30), IN shiftID int)
BEGIN
	Declare SumRechargeMoney float default 0;
	declare moneyIndex int default 1;
    declare money float;

	DROP TEMPORARY TABLE IF EXISTS RechargeHistoryTemp;
	CREATE TEMPORARY TABLE RechargeHistoryTemp
	select ROW_NUMBER() OVER (ORDER BY totalmoney) as IndexOfMoney, totalmoney from rechargehistory where createdat >= "2020-08-13 08:42:01" and createdat < now();

	if ((SELECT count(*) from RechargeHistoryTemp) >= 0 ) then 
		WHILE moneyIndex <= (SELECT count(*) from RechargeHistoryTemp) do
					set money = (select totalmoney from RechargeHistoryTemp where IndexOfMoney = moneyIndex);
					set SumRechargeMoney = SumRechargeMoney + money;
					set moneyIndex = moneyIndex + 1;
		end while;
		update shift set totalMoney = totalMoney + SumRechargeMoney where id = shiftID; 
	end if;
END;

-- -------------------- Bán ra
DROP PROCEDURE IF EXISTS SumOutput;
Delimiter //
CREATE PROCEDURE SumOutput(IN loginDate varchar(30), IN shiftID int)
BEGIN
	Declare SumOutPut float default 0;
	declare moneyIndex int default 1;
    declare money float default 0;
    declare quantity int default 0;
    
	DROP TEMPORARY Table IF EXISTS purchasehistorytemp;
	CREATE TEMPORARY TABLE purchasehistorytemp
	select ROW_NUMBER() OVER (ORDER BY priceOfService) as IndexOfMoney, priceOfService, outputAmount 
    from purchasehistory where createdat >= loginDate and createdat < now();
    
    if((select count(*) from purchasehistorytemp) >= 0) then -- xet theo bang ban ra temp
		WHILE moneyIndex <= (select count(*) from purchasehistorytemp) do
					set quantity = (select outputAmount from purchasehistorytemp where IndexOfMoney = moneyIndex);
					set money = (select priceOfService from purchasehistorytemp where IndexOfMoney = moneyIndex);
					set SumOutPut = SumOutPut + (money * quantity);
					set moneyIndex = moneyIndex + 1;
		end while;
		update shift set totalMoney = sumoutput where id = shiftID;
    end if;
END;

-- -------------------- Chốt ca
DROP PROCEDURE IF EXISTS FinalShift;
Delimiter //
CREATE PROCEDURE FinalShift()
BEGIN
	declare shiftID int;
	declare indexRow int default 1;
	declare ServiceID varchar(20);
	declare quanity int;
    declare loginDate varchar(30);
		
	set shiftID = (SELECT id FROM shift ORDER BY id DESC LIMIT 1);
	set loginDate = (SELECT starttime FROM shift where id = shiftID);

	DROP VIEW IF EXISTS temp1;
	CREATE VIEW temp1
	AS Select ROW_NUMBER() OVER (ORDER BY idService) as rowIndex, idService, totalAmount from Service;

	if not exists (SELECT * FROM shiftdetail where id = shiftID) then
			WHILE indexRow <= (SELECT count(*) from temp1) do        
				set ServiceID = (Select idService from temp1 where rowIndex = indexRow);
				set quanity = (Select totalAmount from temp1 where rowIndex = indexRow);
				insert into ShiftDetail values
				(shiftID, ServiceID, quanity);
				set indexRow = indexRow + 1;			
			end while;
	else 		
			WHILE indexRow <= (SELECT count(*) from temp1) do        
				set ServiceID = (Select idService from temp1 where rowIndex = indexRow);
				set quanity = (Select totalAmount from temp1 where rowIndex = indexRow);
				
				Update ShiftDetail set totalAmount = (select totalAmount from service where idService in (select idService from temp1 where rowIndex = indexRow ))
				Where idService Like (select idService from temp1 where rowIndex = indexRow );
				set indexRow = indexRow + 1;
			end while;
    end if;
    call sumoutput(loginDate, shiftID);
    call SumRechargeHistory(loginDate, shiftID);
    update shift set endtime = now() where id = shiftid;
END;

-- ----------------------- SetBudget
DROP PROCEDURE IF EXISTS SetCustomerBudget;
Delimiter //
CREATE PROCEDURE SetCustomerBudget(IN staffUsername varchar(30), IN customerUsername varchar(30), IN money float)
BEGIN
	update customer set currentmoney = currentmoney+money where username = customerUsername;
    insert into RechargeHistory (usernameOfStaff, usernameOfCustomer , totalMoney) values
    (staffUsername, customerUsername, money);
END;
-- ---------------------- New Customer
DROP PROCEDURE IF EXISTS NewCustomer;
Delimiter //
CREATE PROCEDURE NewCustomer(username varchar(50), password varchar(255), money float, staffname varchar(50))
BEGIN
	insert into customer(username, password, currentMoney) values (username, password, money);
    insert into RechargeHistory(usernameofstaff, usernameofcustomer, totalmoney) values (staffname , username, money);
END;
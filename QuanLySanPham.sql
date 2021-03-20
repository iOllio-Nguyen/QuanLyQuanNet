USE PROJECT4;
-------------------------------
DROP PROCEDURE IF EXISTS InputStock;
Delimiter //
CREATE PROCEDURE inputStock(IN id varchar(20), IN inputStock INT)
BEGIN			
		declare currentStock INT;
        	SET currentStock = (Select totalAmount from service where idservice = id);
	
		insert into ImportHistory(idService, totalAmount, inputAmount) values    
		(id, currentStock, inputStock);
       
        	UPDATE service SET totalamount= totalamount + inputStock where idservice = id;    
END;

-------------------------------
DROP PROCEDURE IF EXISTS OutputStock;
Delimiter //
CREATE PROCEDURE OutputStock(IN Id varchar(20), IN outputStock INT)
BEGIN			
		declare currentStock INT;
        	declare price float;
        	SET currentStock = (Select totalAmount from service where idservice = id);
		SET price = (select priceOfService  from service where idservice = id);
        	insert into PurchaseHistory(idService, priceOfService, totalAmount, outputAmount) values    
		(Id, price, currentStock, outputStock);
       	     
        UPDATE service SET totalamount= totalamount - outputStock where idservice = id;     
END;	

-------------------------------ban ra/ nhap vao
DROP PROCEDURE IF EXISTS chitietbanra;
Delimiter //
CREATE PROCEDURE chitietbanra (IN employeeLoginTime varchar(30))
BEGIN		
	select 	
		service.idservice,
		service.nameOfService, 
		PurchaseHistory.outputamount,
		PurchaseHistory.priceofservice, 
		PurchaseHistory.priceofservice*PurchaseHistory.outputamount,
		PurchaseHistory.createdat 
	from PurchaseHistory join service on PurchaseHistory.idservice = service.idservice
	where PurchaseHistory.createdAt >= employeeLoginTime AND PurchaseHistory.createdAt < now();
END;

DROP PROCEDURE IF EXISTS thongkebanra;
Delimiter //
CREATE PROCEDURE thongkebanra (IN employeeLoginTime varchar(30))
BEGIN		
	select 	
		service.idservice,
		service.nameOfService, 
		sum(PurchaseHistory.outputamount),
		PurchaseHistory.priceofservice, 
		PurchaseHistory.priceofservice*sum(PurchaseHistory.outputamount),
		PurchaseHistory.createdat 
	from PurchaseHistory join service on PurchaseHistory.idservice = service.idservice
	where PurchaseHistory.createdAt >= employeeLoginTime AND PurchaseHistory.createdAt < now()
	group by service.nameOfService;
END;    

DROP PROCEDURE IF EXISTS chitietnhapvao;
Delimiter //
CREATE PROCEDURE chitietnhapvao(IN employeeLoginTime varchar(50))
BEGIN
	select 
		importhistory.idhistory,
		service.nameOfService,
        importhistory.inputaMOUNT,
        importhistory.createdAt
    from importhistory join service 
    where importhistory.idservice = service.idservice
    and  importhistory.createdAt >= employeeLoginTime and importhistory.createdAt < now();
END;


-------------------------------
DROP PROCEDURE IF EXISTS GetPreviousShiftDetail;
Delimiter //
CREATE PROCEDURE GetPreviousShiftDetail()
BEGIN
    select 
		shiftDetail.id,
        service.nameofservice,
		shiftdetail.totalamount, 
		staffusername, 
		starttime, 
		endtime ,
        shift.totalmoney
    from shiftDetail join shift on shiftDetail.id = shift.id 
    join service on service.idservice = shiftDetail.idservice
    where shiftDetail.id = (select id from shift order by id DESC LIMIT 1);
END;

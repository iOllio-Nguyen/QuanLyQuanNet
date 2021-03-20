------------------------------------- Time Series
DROP PROCEDURE IF EXISTS getDataTimeSeries;
Delimiter //
CREATE PROCEDURE getDataTimeSeries(startTime varchar(50), endTime varchar(50))
BEGIN 
	DECLARE totalProduct int;
    Select count(*) into totalProduct
    from service;
    
	select service.nameOfService,sum(purchasehistory.outputAmount), DATE_FORMAT(purchasehistory.createdAt, "%Y-%m-%d"), totalProduct as total
	from purchasehistory join service on purchasehistory.idService = service.idService
	Where (DATE_FORMAT(purchasehistory.createdAt, "%Y-%m-%d") BETWEEN startTime  and endTime) 
    Group By purchasehistory.idService, DATE_FORMAT(purchasehistory.createdAt, "%Y-%m-%d")
    Order by DATE_FORMAT(purchasehistory.createdAt, "%Y-%m-%d") ASC;
    COMMIT;
END;
Call getDataTimeSeries("2020-08-15","2021-08-15");
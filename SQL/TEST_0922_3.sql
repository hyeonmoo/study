DROP SCHEMA IF EXISTS test_db;
CREATE SCHEMA test_db;
USE test_db;

DROP PROCEDURE IF EXISTS one_to_hundred;
DELIMITER //
CREATE PROCEDURE one_to_hundred()
BEGIN
	DECLARE num INT DEFAULT 1;
    DECLARE sum INT DEFAULT 0;
    
    WHILE num<=100 DO
		SET sum=sum+num;
        SET num=num+1;
	END WHILE;
    SELECT sum AS '1~100까지의 합';
END//
DELIMITER ;
CALL one_to_hundred();

DROP PROCEDURE IF EXISTS today;
DELIMITER //
CREATE PROCEDURE today(IN to_day DATE)
BEGIN
	SELECT YEAR(to_day) AS 년, MONTH(to_day) AS 월, DAY(to_day) AS 일;
END//
DELIMITER ;
CALL today(CURDATE());

SELECT DATEDIFF(CURRENT_DATE(),'2022-02-21') AS '지나간 일수';

DROP FUNCTION IF EXISTS plus_2;
DELIMITER //
CREATE FUNCTION plus_2(num1 INT,num2 INT) RETURNS INT
BEGIN
	RETURN num1+num2;
END//
DELIMITER ;
SELECT plus_2(100,200) AS '두 수의 합';

DROP TABLE IF EXISTS buy;
CREATE TABLE buy(SELECT mem_id, prod_name, price, amount FROM market_db.buy);
SELECT * FROM buy;
SELECT mem_id AS 아이디, SUM(price*amount) AS 총구매액 FROM buy GROUP BY 아이디;
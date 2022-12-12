DROP SCHEMA IF EXISTS exercise3_db;
CREATE SCHEMA exercise3_db;
USE exercise3_db;

#########################################################
DROP TABLE IF EXISTS 사원;
CREATE TABLE 사원(
	이름 CHAR(3) NOT NULL,
    부서 CHAR(4) NOT NULL,
    생일 DATE NOT NULL,
    주소 CHAR(3) NULL,
    기본급 SMALLINT UNSIGNED NOT NULL
);
INSERT INTO 사원 VALUES
	('홍길동','기획','1961-05-04','망원동',120),
    ('임꺽정','인터넷','1969-09-01','서교동',80),
    ('황진이','편집','1975-07-21','합정동',100),
    ('김선달','편집','1973-10-22','망원동',90),
    ('성춘향','기획','1964-02-20','대흥동',100),
    ('장길산','편집','1967-03-11','상암동',120),
    ('일지매','기획','1978-04-29','연남동',110),
    ('김건달','인터넷','1980-12-21',NULL,90);
#########################################################
ALTER TABLE 사원 ADD PRIMARY KEY(이름);
#########################################################
SELECT DISTINCT 주소 FROM 사원;
#########################################################
SELECT CONCAT(부서,'부서의') AS 부서, CONCAT(이름,'이름의 월급: ',(기본급+10)) AS 월급, 기본급 FROM 사원;
#########################################################
SELECT * FROM 사원 WHERE 부서='기획'; #기획부 모든 튜플 검색
SELECT * FROM 사원 WHERE 부서='기획' AND 기본급>110; #기획부에서 기본급이 110 초과인 튜플 검색
SELECT * FROM 사원 WHERE 부서 IN('기획','인터넷'); #기획부와 인터넷부 튜플 검색
SELECT * FROM 사원 WHERE 이름 LIKE '김%'; #김씨 사원 튜플검색
SELECT * FROM 사원 WHERE 주소 IS NULL; #주소가 NULL인 튜플 검색
SELECT * FROM 사원 ORDER BY 주소 DESC LIMIT 0,2; #주소를 내림차순해 상위 2개 튜플 검색
SELECT * FROM 사원 ORDER BY 부서 ASC, 이름 DESC; #튜플을 부서별 오름차순, 이름별 내림차순 정렬
#########################################################
DROP TABLE IF EXISTS 여가활동;
CREATE TABLE 여가활동(
	이름 CHAR(5),
    취미 CHAR(10),
    경력 INT,
    FOREIGN KEY(이름) REFERENCES 사원(이름)
);
INSERT INTO 여가활동 VALUES('김선달','당구',10);
INSERT INTO 여가활동 VALUES('성춘향','나이트댄스',5);
INSERT INTO 여가활동 VALUES('일지매','씨름',15);
INSERT INTO 여가활동 VALUES('임꺽정','피아노',9);

#취미가 나이트댄스인 사원의 이름과 주소 조회
SELECT 사원.이름, 사원.주소 FROM 사원 INNER JOIN 여가활동 ON 사원.이름=여가활동.이름
	WHERE 여가활동.취미='나이트댄스';    
    
#외부조인을 이용한 취미활동 없는 튜플 조회
SELECT * FROM 사원 LEFT OUTER JOIN 여가활동 ON 사원.이름=여가활동.이름 
	WHERE 여가활동.이름 IS NULL; 

#NOT IN 이용
SELECT * FROM 사원 WHERE 이름 NOT IN(SELECT 이름 FROM 여가활동);

#여가활동 경력이 10년 이상인 사원의 튜플 조회
SELECT 사원.이름, 사원.부서, 여가활동.취미, 여가활동.경력
	FROM 사원 INNER JOIN 여가활동 ON 사원.이름=여가활동.이름
    WHERE 여가활동.경력>=10;
    
#########################################################
DROP TABLE IF EXISTS 수강;
CREATE TABLE 수강(
	학번 CHAR(5),
    과목명 CHAR(10),
    중간성적 CHAR(2),
    기말성적 CHAR(2)
);
SELECT * FROM 수강 WHERE 과목명='DB' ORDER BY 기말성적 DESC, 중간성적 ASC;

SELECT CONCAT(DATEDIFF(CURRENT_DATE(),'2022-06-23'),'일 째') AS 개강한지;

#########################################################
DROP PROCEDURE IF EXISTS OTH;
DELIMITER //
CREATE PROCEDURE OTH()
BEGIN
	DECLARE cnt INT DEFAULT 1;
    DECLARE sum INT DEFAULT 0;
    WHILE cnt<=100 DO
		SET sum=sum+cnt;
		SET cnt=cnt+1;
	END WHILE;
    SELECT sum AS '1부터 100까지의 합';
END//
DELIMITER ;
CALL OTH();
#########################################################
DROP FUNCTION IF EXISTS plus;
DELIMITER //
CREATE FUNCTION plus(num1 INT, num2 INT) RETURNS INT
BEGIN
	RETURN num1+num2;
END//
DELIMITER ;
SELECT plus(6,23) AS '두 수의 합';
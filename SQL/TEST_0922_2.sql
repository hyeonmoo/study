DROP SCHEMA IF EXISTS 회사;
CREATE SCHEMA 회사;
USE 회사;
DROP TABLE IF EXISTS 사원;
CREATE TABLE 사원(
	이름 CHAR(3),
    부서 VARCHAR(5),
    생일 DATE,
    주소 CHAR(4),
    기본급 SMALLINT UNSIGNED
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
SELECT * FROM 사원;
ALTER TABLE 사원 ADD PRIMARY KEY(이름);
SELECT DISTINCT 주소 FROM 사원;
SELECT * FROM 사원 WHERE 부서='기획';
SELECT * FROM 사원 WHERE 주소 IS NULL;
SELECT * FROM 사원 ORDER BY 주소 DESC LIMIT 2;
SELECT * FROM 사원 ORDER BY 부서 ASC, 이름 DESC;
SELECT * FROM 사원 WHERE 부서='기획' AND 기본급>110;
SELECT * FROM 사원 WHERE 부서 IN('기획','인터넷');
SELECT * FROM 사원 WHERE 이름 LIKE '김%';
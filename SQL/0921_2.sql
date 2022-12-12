DROP SCHEMA IF EXISTS exercise2_db;
CREATE SCHEMA exercise2_db;
USE exercise2_db;
######################################################
#다음 처리조건에 부합하는 sql문을 작성하시오.
DROP TABLE IF EXISTS 학생;
CREATE TABLE 학생(
	학번 INT PRIMARY KEY,
    성명 VARCHAR(20),
    학년 INT,
    과목 VARCHAR(20),
    연락처 VARCHAR(20)
);
INSERT INTO 학생 VALUES(98170823,'한국산',3,'경영학개론','?-1234-1234');

######################################################
#다음 처리조건에 부합하는 SQL문을 작성하시오.
INSERT INTO 학생 VALUES(2013038018,'Scott',4,'전자공학부','010-9876-5432');
DELETE FROM 학생 WHERE 성명='Scott';

######################################################
#다음 처리조건에 부합하는 SQL문을 작성하시오.
DROP TABLE IF EXISTS 사원;
CREATE TABLE 사원(
	사원번호 VARCHAR(10) PRIMARY KEY,
    이름 VARCHAR(20),
    직급 VARCHAR(10),
    연봉 INT,
    연락처 VARCHAR(11),
    주소 VARCHAR(30)
);
INSERT INTO 사원 VALUES('123456','홍길동','차장',25000000,'01012341234','충북 청주시');
UPDATE 사원 SET 연봉=연봉+100000 WHERE 직급='차장';

######################################################
#다음 처리조건에 부합하도록 SQL문을 작성하시오.
DROP TABLE IF EXISTS 학부생;
CREATE TABLE 학부생(
	학부 CHAR(4) NOT NULL,
    학과번호 SMALLINT UNSIGNED NOT NULL,
    입학생수 SMALLINT UNSIGNED NOT NULL,
    담당관 CHAR(5)
);
INSERT INTO 학부생 VALUES
	('정경대학',110,300,'김해율'),
    ('공과대학',310,250,'이성관'),
    ('인문대학',120,400,'김해율'),
    ('정경대학',120,300,'김성수'),
    ('인문대학',420,180,'이율해');

UPDATE 학부생 SET 학과번호=999 WHERE 담당관 LIKE '이%';

######################################################
#<사원>테이블에 있는 자료 중 '부서'가 '기획'인 자료를 검색해 <기획부(성명, 경력, 주소, 기본급)>테이블에 삽입하는 SQL문을 작성하시오.
DROP TABLE IF EXISTS 기획부,사원;
CREATE TABLE 사원(
	성명 CHAR(4),
    부서 CHAR(10),
    경력 CHAR(30),
    주소 CHAR(30),
    기본급 INT UNSIGNED
);
INSERT INTO 사원 VALUES('강현무','기획','없음','충북 청주시',3000);
INSERT INTO 사원 VALUES('홍길동','영업','없음','충북 충주시',3000);
CREATE TABLE 기획부(SELECT 성명,경력,주소,기본급 FROM 사원 WHERE 부서='기획');
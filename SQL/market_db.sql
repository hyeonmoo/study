DROP DATABASE IF EXISTS market_db;
CREATE DATABASE market_db;
USE market_db;
CREATE TABLE member
(	mem_id		CHAR(8) NOT NULL PRIMARY KEY,
	mem_name	VARCHAR(10) NOT NULL,
	mem_number	INT NOT NULL,
    addr		CHAR(2) NOT NULL,
    phone1		CHAR(3),
    phone2		CHAR(8),
    height		SMALLINT,
    debut_date	DATE
);
CREATE TABLE buy
(	num			INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	mem_id		CHAR(8) NOT NULL,
	prod_name	CHAR(6) NOT NULL,
    group_name	CHAR(4),
    price		INT NOT NULL,
    amount		SMALLINT NOT NULL,
    FOREIGN KEY (mem_id) REFERENCES member(mem_id)
);
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

CREATE TABLE emp_table (emp CHAR(4), manager CHAR(4), phone VARCHAR(8));
INSERT INTO emp_table VALUES
	('대표',NULL,'0000'),
	('영업이사','대표','1111'),
	('관리이사','대표','2222'),
	('정보이사','대표','3333'),
	('영업과장','영업이사','1111-1'),
	('경리부장','관리이사','2222-1'),
	('인사부장','관리이사','2222-2'),
	('개발팀장','정보이사','3333-1'),
	('개발주임','정보이사','3333-1-1');
    
CREATE TABLE gate_table(
	id INT AUTO_INCREMENT PRIMARY KEY,
    entry_time DATETIME);
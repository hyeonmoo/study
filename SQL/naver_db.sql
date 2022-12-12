drop database if exists naver_db;
create database naver_db;
use naver_db;
create table member(
	mem_id		char(3) not null primary key,
    mem_name	varchar(4) not null,
    mem_number	tinyint not null,
    addr		char(2) not null,
    phone1		char(3),
    phone2		char(8),
    height		tinyint unsigned,
    debut_date	date
);
create table buy(
	num			int auto_increment primary key,
    mem_id		char(3) not null,
    prod_name	varchar(6) not null,
    group_name	varchar(4),
    price		int unsigned not null,
    amount		smallint unsigned not null,
    foreign key(mem_id) references member(mem_id)
);
insert into member values
	('TWC','트와이스','9','서울','02','11111111','167','2015.10.19'),
    ('BLK','블랙핑크','4','경남','055','22222222','163','2016.08.08'),
    ('WMN','여자친구','6','경기','031','33333333','166','2015.01.15'),
    ('OMY','오마이걸','7','서울',null,null,'160','2015.04.21'),
    ('GRL','소녀시대','8','서울','02','44444444','168','2007.08.02'),
    ('ITZ','잇지','5','경남',null,null,'167','2019.02.12'),
    ('RED','레드벨벳','5','경북','054','55555555','161','2014.08.01'),
    ('APN','에이핑크','6','경기','031','77777777','164','2011.02.10'),
    ('SPC','우주소녀','13','서울','02','88888888','162','2016.02.25'),
    ('MMU','마마무','4','전남','061','99999999','165','2014.06.19');

insert into buy values
	(null,'BLK','지갑',null,30,2),
    (null,'BLK','맥북프로','디지털',1000,1),
    (null,'APN','아이폰','디지털',200,1),
    (null,'MMU','아이폰','디지털',200,5),
    (null,'BLK','청바지','패션',50,3),
    (null,'MMU','에어팟','디지털',80,10),
    (null,'GRL','혼공SQL','서적',15,5),
    (null,'APN','혼공SQL','서적',15,2),
    (null,'APN','청바지','패션',50,1),
    (null,'MMU','지갑',null,30,1),
    (null,'APN','혼공SQL','서적',15,1),
    (null,'MMU','지갑',null,30,4);
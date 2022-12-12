########## INDEX ##########
use naver_db;
drop table if exists table1;
create table table1(
	col1 int primary key, #기본키로 설정된 열에 클러스터형 인덱스가 자동 생성됨
    col2 int unique, #고유키로 설정된 열에 보조 인덱스가 생성됨
    col3 int unique #Key_name에 고유키로 선언된 열 이름이 기입됨
);
show index from table1; #테이블의 인덱스 확인
drop table if exists buy, member;
create table member(
	mem_id char(8),
    mem_name varchar(10),
    mem_number int,
    addr char(2)
);

insert into member values
	('TWC','트와이스',9,'서울'),
    ('BLK','블랙핑크',4,'경남'),
    ('WMN','여자친구',6,'경기'),
    ('OMY','오마이걸',7,'서울');
select * from member; #기본키가 없는 테이블이기에 데이터가 입력된 순서대로 출력됨
alter table member add constraint primary key(mem_id); #mem_id를 기본키로 설정
select * from member; #기본키가 설정되어 생성된 클러스터형 인덱스 기준으로 데이터 자동정렬
alter table member drop primary key; #member테이블의 기본키 제거
alter table member add constraint primary key(mem_name); #member테이블의 mem_name열을 기본키로 설정
select * from member; #mem_name열에 생성된 클러스터형 인덱스 기준으로 데이터 자동정렬
insert into member values('GRL','소녀시대',8,'서울');
select * from member; #데이터가 추가되는 경우 역시 자동정렬됨

drop table if exists buy, member;
create table member(
	mem_id char(8),
    mem_name varchar(10),
    mem_number int,
    addr char(2)
);

insert into member values
	('TWC','트와이스',9,'서울'),
    ('BLK','블랙핑크',4,'경남'),
    ('WMN','여자친구',6,'경기'),
    ('OMY','오마이걸',7,'서울');
alter table member add constraint unique(mem_id); #고유키를 지정해 보조 인덱스를 생성
select * from member; #보조 인덱스는 데이터 정렬에 영향을 주지 못함(입력 순서대로 정렬)

drop table if exists cluster_index;
create table cluster_index(mem_id char(8),mem_name varchar(10),members tinyint unsigned);
insert into cluster_index values
	('TWC','트와이스',9),('BLK','블랙핑크',4),('WMN','여자친구',6),('OMY','오마이걸',7),('SPC','우주소녀',10),
    ('GRL','소녀시대',8),('ITZ','잇지',5),('RED','레드벨벳',5),('APN','에이핑크',6),('MMU','마마무',4);
select * from cluster_index; #기본키가 없으므로 입력한 순서대로 정렬
alter table cluster_index add constraint primary key(mem_id); #기본키 설정->클러스터형 인덱스 생성
select * from cluster_index; #클러스터형 인덱스가 있는 열(기본키) 기준으로 데이터 정렬

drop table if exists unique_index;
create table unique_index(mem_id char(8),mem_name varchar(10),members tinyint unsigned);
insert into unique_index values
	('TWC','트와이스',9),('BLK','블랙핑크',4),('WMN','여자친구',6),('OMY','오마이걸',7),('SPC','우주소녀',10),
    ('GRL','소녀시대',8),('ITZ','잇지',5),('RED','레드벨벳',5),('APN','에이핑크',6),('MMU','마마무',4);
select * from unique_index; #기본키가 없으므로 입력한 순서대로 정렬
alter table unique_index add constraint unique(mem_id); #고유키 설정->보조 인덱스 생성
select * from unique_index; #보조 인덱스는 데이터 정렬 순서에 영향을 주지 않으므로 입력한 순서대로 정렬

use market_db;
select * from member;
select * from buy;
show index from member; #인덱스 정보 호출
show table status like 'member'; #인덱스 크기정보 호출
create index idx_member_addr on member(addr); #addr열에 인덱스 생성
show index from member; #인덱스가 하나 추가된 걸 볼 수 있음
analyze table member; #테이블 분석처리->인덱스 생성을 적용
show table status like 'member'; #index_length 열에 1페이지가 추가됐음을 확인할 수 있음
create unique index idx_member_mem_name on member(mem_name); #mem_name속성에 고유 인덱스 생성
show index from member; #mem_name열에 고유 인덱스가 생성되었음을 확인(Non_unique:0)
#insert into member values('MOO','마마무',2,'태국','001','12341234',155,'2020.10.10'); #mem_name에 고유 인덱스가 생성됨에 따라 중복된 값을 쓸 수 없음(에러)
analyze table member;
show index from member;
select * from member;
select mem_id, mem_name, addr from member where mem_name='에이핑크'; #Execution Plan 에서 인덱스를 사용해서 결과를 얻었음을 확인, where절에 열 이름이 들어있어야 인덱스 사용
create index idx_mem_number on member(mem_number);
analyze table member;
select mem_name, mem_number from member where mem_number>=7; #인덱스를 사용해서 결과를 얻음
select mem_name, mem_number from member where mem_number>=1; #인덱스 검색보다 전체 테이블 검색이 더 효율적이라 판단되면 인덱스를 사용하지 않음
select mem_name, mem_number from member where mem_number*2>=14; #where문에 연산이 가해지면 인덱스를 사용하지 않음
select mem_name, mem_number from member where mem_number>=14/2; #연산식이 아니므로 인덱스 사용

select * from information_schema.referential_constraints where constraint_schema='market_db'; #스키마의 외래키 조회
# show index from member;
# drop index idx_member_mem_name on member; #모든 보조 인덱스 제거
# drop index idx_member_addr on member;
# drop index idx_mem_number on member;

# alter table buy drop foreign key buy_ibfk_1; #외래키 제거
# alter table member drop primary key; #기본키 제거->클러스터형 인덱스 제거
# show index from member; #아무고토 안 뜬 것을 확인할 수 있음
use google_db;
drop table if exists buy, member;
#기본 키 설정법
create table member(
	mem_id char(8) not null,
    mem_name varchar(10) not null,
    height tinyint unsigned null check(height>=100) default 165, #체크 제약 조건 설정, 기본값 정의
    email char(30) null unique, #고유키 제약 조건 설정
    phone1 char(3) null,
    primary key(mem_id)
);

#buy테이블의 외래키 설정
create table buy(
	num int auto_increment not null primary key,
	mem_id char(8) not null,
    prod_name char(6) not null,
    price int unsigned not null,
    amount smallint unsigned not null,
    foreign key(mem_id) references member(mem_id)
);
#체크 제약 조건 추가
alter table member add constraint p_ch check(phone1 in('02','031','032','054','055','061'));
#체크 제약 조건 해제
alter table member drop constraint p_ch;
#기본값 추가
alter table member alter column phone1 set default '02';
#member테이블에 데이터 추가
insert into member values
	('IVE','아이브',170,'dive@gmail.com',default),
    ('PINK','블랙핑크',default,'blackpink@gmail.com','031'),
    ('STC','스테이씨',164,'stayc@gmail.com','055'),
    ('ASP','에스파',default,null,'010'), #체크 제약 조건을 해제했기에 체크 제약조건에서 벗어나는 국번을 입력해도 오류가 발생하지 않음
    ('IDL','아이들',161,null,'061'),
    ('APN','에이핑크',160,null,'032');
#buy테이블에 데이터 추가
insert into buy values
	(null,'IVE','아이폰',1500,6),
	(null,'PINK','에어팟',300,4),
    (null,'PINK','맥북',2000,4),
	(null,'STC','헤드셋',150,7),
	(null,'IVE','에어팟',300,6),
    (null,'APN','청바지',50,6);
select * from member;
select * from buy;

#제약 조건 이름 확인
select * from information_schema.table_constraints where table_schema='google_db';
#외래 키 제약 조건 삭제
alter table buy drop foreign key buy_ibfk_1;
select * from information_schema.table_constraints where table_schema='google_db'; #외래 키 조건이 정상적으로 삭제됐음을 확인

#기본 키 제약 조건 삭제
alter table member drop primary key;
desc member;

#기본 키 제약 조건 추가
alter table member #member테이블을 변경하겠다
	add constraint #제약 조건을 추가하겠다
    primary key(mem_id); #기본 키를 mem_id로 하겠다
desc member;

#제약 조건에 이름을 설정해서 추가
alter table buy
	add constraint fk_mem_id #제약 조건 이름을 fk_mem_id로 설정
    foreign key(mem_id) references member(mem_id)
    on update cascade #기준테이블의 기본키가 변경될 때 참조테이블의 외래키도 자동으로 변경되도록
    on delete cascade; #기준테이블의 기본키가 삭제되면 참조테이블의 외래키가 있는 데이터도 자동으로 삭제되도록
select * from information_schema.table_constraints where table_schema='google_db'; #외래 키 제약 조건 이름이 정상적으로 설정됐음을 확인

#기준테이블의 기본키 변경/삭제 시 참조테이블에 변경사항 반영
update member set mem_id='BPK' where mem_id='PINK'; #member테이블의 아이디가 BLK인 데이터 아이디를 PINK로 변경
select M.mem_id, M.mem_name, B.mem_id, B.prod_name from buy B inner join member M on B.mem_id=M.mem_id; #member테이블의 기본키가 변경됨에 따라 buy테이블의 외래키도 변경되었음을 확인
delete from member where mem_id='APN'; #member테이블의 아이디가 APN인 데이터를 삭제
select * from buy; #member테이블의 APN데이터가 삭제됨에 따라 buy테이블에 있는 APN데이터도 삭제되었음을 확인

############################### VIEW #################################
use market_db;
drop view if exists v_member;
#뷰 생성, 생성된 뷰는 table처럼 사용할 수 있음
create view v_member as select mem_id, mem_name, addr from member;
select * from v_member;
select mem_name, addr from v_member where addr in('서울','경기');
drop view if exists v_memberbuy;
create view v_memberbuy
	as select B.mem_id '아이디', M.mem_name as '그룹 이름', B.prod_name "상품명", M.addr as 주소, concat(M.phone1,'-',M.phone2) '연락처'
    from buy B inner join member M on B.mem_id=M.mem_id;
select DISTINCT `아이디`,`그룹 이름` from v_memberbuy; #별명으로 뷰의 속성을 찾을 때는 `(백틱)으로 표시
#뷰의 구조 출력
describe v_member;
desc v_member;
#뷰를 통한 데이터의 수정
update v_member set addr='부산' where mem_id='BLK';
select * from member where mem_id='BLK';
#뷰를 통한 데이터의 삽입
# insert into v_member values('BTS','방탄소년단','경기'); #member테이블의 다른 not null속성에 값을 지정할 수 없으므로 데이터를 생성할 수 없음
create or replace view v_height167 as select * from member where height>=167; #따로 drop하지 않아도 알아서 덮어씀
select * from v_height167;
delete from member where mem_id='ASP';
insert into v_height167 values('ASP','에스파',4,'서울',null,null,165,'2020-11-17'); #키가 167미만이어도 뷰에만 보이지 않을 뿐 member테이블에는 입력됨
alter view v_height167 as select * from member where height>=167 with check option; #뷰의 조건에 맞지 않는 데이터 추가 시 오류가 발생하도록 체크제약조건 설정
#insert into v_height167 values('TRA','티아라',6,'서울',null,null,159,'2005-01-01'); #데이터 추가 시도시 오류가 발생하는 것을 확인 가능(member테이블에 입력되지 않음)

#drop table if exists buy, member; #테이블은 뷰가 참조한다 해도 테이블을 삭제할 수 있으나 현재 buy테이블이 member테이블을 참조하기에 buy테이블 먼저 삭제
select * from v_height167; #member테이블이 삭제되었기에 뷰로 데이터를 검색할 수 없음

#뷰의 소스코드 확인
show create view v_memberbuy;
check table v_memberbuy; #뷰의 상태를 확인할 수 있음
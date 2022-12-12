drop schema if exists exercise_db;
create schema exercise_db;
use exercise_db;
###################################################################
#요구사항을 만족하는 테이블 <patient>를 정의하는 sql문을 작성하시오.
drop table if exists patient, doctor;
create table doctor(doc_id char(5) primary key);
create table patient(
	id char(5),
    name char(10),
    sex char(1),
    phone char(20),
    primary key(id)
);
alter table patient add constraint sex_ck check(sex='f' or sex='m');
alter table patient add constraint id_fk foreign key(id) references doctor(doc_id);

#<patient>테이블에 데이터 타입이 문자 20자리인 'job'속성을 추가하는 sql문을 작성하시오.
alter table patient add job char(20);

###################################################################
#아래의 요구사항을 만족하는 테이블 <instructor>를 정의하는 sql문을 작성하시오.
drop table if exists instructor, Department;
create table Department(dept char(15) primary key);
create table instructor(
	id char(5) primary key,
    name char(15) not null,
    dept char(15),
    foreign key(dept) references Department(dept) on update cascade on delete set null
);

###################################################################
#요구사항을 만족하는 뷰 <cc>를 정의하는 sql문을 작성하시오.
drop table if exists Course;
create table Course(
    id char(5) primary key,
    name char(15),
	instructor char(5)
);
create or replace view cc
	as select C.id as ccid, C.name as ccname, I.name as instname
	from Course C inner join instructor I on C.instructor=I.id;

###################################################################
#<Student> 테이블의 ssn속성에 대해 중복을 허용하지 않도록 Stud_ 이름으로 오름차순 인덱스를 정의하는 sql문을 작성하시오.
drop table if exists Student;
create table Student(ssn char(14));
create unique index Stud_ on Student(ssn asc);
analyze table Student;

###################################################################
#요구사항을 만족하는 <사원>테이블을 정의하는 sql문을 작성하시오.
drop table if exists 근무지,사원;
create table 근무지(근무지번호 int primary key);
create table 사원(
	사원번호 int primary key,
    사원명 char(10),
    근무지번호 int,
    foreign key(근무지번호) references 근무지(근무지번호) on delete cascade
);

###################################################################
#<직원>테이블에 대해 '이름' 속성으로 '직원_name'이라는 인덱스를 정의하는 sql문을 작성하시오.
drop table if exists 직원;
create table 직원(이름 char(10));
create index 직원_name on 직원(이름);
analyze table 직원;

###################################################################
#다음 처리조건에 부합하는 sql문을 작성하시오.
drop table if exists 학생;

###################################################################
#다음 <employee>테이블의 구조를 참고하여 sql문을 완성하시오.
drop table if exists employee;
create table employee(
	직원코드 int not null,
    성명 char(10) unique,
    직책 char(10) not null,
    연봉 int unsigned
);
alter table employee add constraint 직책_binary check(직책 in ('사원','대리','과장','팀장'));
insert into employee values
	(161353,'김미나','대리',2300),
    (181323,'최영락','사원',1900),
    (151453,'홍진호','과장',2800),
    (135485,'구준표','과장',3000),
    (104895,'강나래','팀장',3600),
    (165484,'김하늘','대리',2400);
    

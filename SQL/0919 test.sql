drop schema if exists school_db;
create schema school_db;
use school_db;
drop table if exists 학생, 학과;
create table 학과(전공 char(5) primary key);
create table 학생(
	이름 varchar(15) not null,
    학번 char(8) not null,
    전공 char(5),
    성별 char(1),
    생년월일 date,
    primary key(학번),
    foreign key(전공) references 학과(전공) on update cascade on delete cascade
);
alter table 학생 add constraint 생년월일제약 check(생년월일>'1980-01-01');
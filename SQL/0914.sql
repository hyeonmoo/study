USE shop_db;
DROP TABLE IF EXISTS person; -- person테이블이 이미 있다면 지워라
DROP TABLE IF EXISTS person2; -- person2테이블이 이미 있다면 지워라
CREATE TABLE person( -- person 테이블 생성
	toy_id INT AUTO_INCREMENT PRIMARY KEY, -- 1부터 선형적으로 증가하도록
	toy_name CHAR(4),
    age INT);
INSERT INTO person VALUES(NULL,'춘식',25); -- auto_increment되는 부분은 null로 채움
INSERT INTO person VALUES(NULL,'라이언',22);
INSERT INTO person VALUES(NULL,'어피치',21);
SELECT * FROM person;
SELECT LAST_INSERT_ID(); -- auto_increment가 몇 번까지 생성했는지?
ALTER TABLE person AUTO_INCREMENT=100; -- auto_increment가 100부터 시작하도록 테이블 변경
INSERT INTO person VALUES(NULL,'재남',35); -- 데이터 추가 -> 앞서 auto_increment가 100부터 시작하기 때문에 재남의 아이디는 100이 됨
SELECT * FROM person;

CREATE TABLE person2( -- person2테이블 생성
	toy_id INT AUTO_INCREMENT PRIMARY KEY,
	toy_name CHAR(4),
    age INT);
ALTER TABLE person2 AUTO_INCREMENT=1000; -- 순번이 1000부터 시작하도록 변경
SET @@auto_increment_increment=3; -- 숫자 증가폭을 3으로 변경
INSERT INTO person2 VALUES -- 추가되는 데이터들은 1000, 1003, 1006 ... 처럼 id가 생성됨
	(NULL,'죠르디',20),
	(NULL,'키티',25),
	(NULL,'코난',30);
SELECT * FROM person2;

DESC person; -- person 테이블의 구조를 출력

update person set toy_name='재식' where toy_name='재남'; -- 이름이 재남인 행을 찾아 이름을 재식으로 변경
select * from person where toy_name='재식';
drop table if exists person3;
create table person3(
	tinyint_col tinyint, -- -128~127
    smallint_col smallint, -- -32768~32767
    int_col int, -- -2147483648~2147483647
    bigint_col bigint); -- -9223372036854775808~9223372036854775807
    
insert into person3 values(127,32767,2147483647,9223372036854775807);
select * from person3;

use market_db;
set @@auto_increment_increment=1;
set @MyVar1=5;
set @MyVar2=4.25;
set @txt='가수이름->';
set @height=166;
select @MyVar1, @MyVar2, @txt, mem_name from member where height>@height; -- 변수 생성 및 활용
set @count=3;
prepare mySQL from 'select mem_name, height from member order by height limit ?';
execute mySQL using @count; -- limit문에선 변수의 사용이 제한되므로 prepare-excute문을 이용해 변수 사용(using 뒤의 변수가 준비된 sql문의 ? 자리에 들어감)

select avg(price) as 가격 from buy;
select cast(avg(price) as signed)as 평균가격cast, convert(avg(price), signed) as 평균가격convert from buy; -- cast와 convert를 이용한 형변환
select '100'+'200', concat(100,'200'), 100+'200'; -- 자동 형변환

select * from buy inner join member on buy.mem_id=member.mem_id where buy.mem_id='GRL'; -- 내부조인-GRL아이디를 가진 행에 대해서 아이디값이 일치하는 buy테이블 데이터와 member테이블 데이터를 합침
select B.mem_id, A.mem_name, B.prod_name, A.addr, concat(A.phone1,'-',A.phone2) from buy B inner join member A on B.mem_id=A.mem_id; -- 내부조인-별명을 설정해 열 지정에서의 편의성 확보
select A.mem_id, A.mem_name, B.prod_name, A.addr from member A left outer join buy B on B.mem_id=A.mem_id order by A.mem_id; -- 외부조인- member테이블 기준으로 아이디값이 일치하는 buy테이블 조인
select A.mem_id, A.mem_name, B.prod_name, A.addr from member A right outer join buy B on B.mem_id=A.mem_id order by A.mem_id; -- 외부조인- buy테이블 기준으로 아이디값이 일치하는 member테이블 조인
select A.mem_id as 아이디, A.mem_name as 그룹명, B.prod_name as 상품, A.addr as 주소 from member A left outer join buy B on B.mem_id=A.mem_id where B.prod_name is null order by A.mem_id;
-- 외부조인- member테이블 기준으로 아이디값이 일치하는 buy테이블 중 prod_name값이 null인 행만 조인
select * from buy cross join member; -- 카티션 곱 - buy테이블의 각 행마다 member테이블의 모든 행을 조인

select A.emp '직원', B.emp '직속상관', B.phone '직속상관연락처' from emp_table A inner join emp_table B on A.manager = B.emp where A.emp='경리부장';

select * from member;
select * from buy;
select * from emp_table;
USE market_db;
-- 스토어드 프로시저 선언 및 호출
DROP PROCEDURE IF EXISTS ifProc2;
DELIMITER $$
CREATE PROCEDURE ifProc2()
BEGIN
	DECLARE intVar INT;
    SET intVar=200;
	IF intVar=100 THEN SELECT 'intVar는 100입니다.' AS RESULT;
	ELSE SELECT 'intVar는 100이 아닙니다.' AS RESULT;
	END IF;
END $$
DELIMITER ;
CALL ifProc2();

-- 조건문 IF
DROP PROCEDURE IF EXISTS DEBUTDATE;
DELIMITER $$
CREATE PROCEDURE DEBUTDATE()
BEGIN
	DECLARE debut_day DATE;
    DECLARE current_day DATE;
    DECLARE days INT;
    
    SELECT debut_date INTO debut_day FROM market_db.member WHERE mem_id='APN';
    SET current_day=CURRENT_DATE();
    SET days=DATEDIFF(current_day, debut_day);
    
    IF (days/365)>=5 THEN SELECT CONCAT('데뷔한 지 ',days,'일이나 지났습니다. 축하합니다!')'축하합니다';
    ELSE SELECT CONCAT('데뷔한 지 ',days,'일 지났습니다. 힘내세요!')'힘내세요!';
    END IF;
END$$
DELIMITER ;
CALL DEBUTDATE();

-- 현재시간 출력
select current_timestamp(), current_date(), datediff('2022/12/31','2022/09/15');

-- 조건문 CASE
drop procedure if exists caseProc;
delimiter $$
create procedure caseProc()
begin
	declare point int;
    declare credit char(1);
    set point=88;
    case
		when point>=90 then set credit='A';
        when point>=80 then set credit='B';
        when point>=70 then set credit='C';
        when point>=60 then set credit='D';
        else set credit='F';
	end case;
    select point as 점수, credit as 학점;
end$$
delimiter ;
call caseProc();

drop procedure if exists func;
delimiter $$
create procedure func()
begin
	declare intVar int default 1;
    case intVar
		when 2 then select '일치' as 번호;
		when 3 then select '일치' as 번호;
        else select '불일치' as 번호;
	end case;
end$$
delimiter ;
call func();

-- SQL에서의 CASE 조건문 활용
select M.mem_name as 그룹명, M.mem_id as 아이디, sum(B.price*B.amount) as 총구매액,
		(case
			when(sum(B.price*B.amount)>=1500) then '최우수고객'
            when(sum(B.price*B.amount)>=1000) then '우수고객'
            when(sum(B.price*B.amount)>=1) then '일반고객'
            else '유령고객'
		end) '회원등급'
	from buy B right outer join member M on M.mem_id=B.mem_id
    group by M.mem_id
    order by 총구매액 desc;

-- 반복문 WHILE
drop procedure if exists whileProc;
delimiter $$
create procedure whileProc()
begin
	declare i int default 0;
    declare sum int default 0;
    myWhile: while(i<=100) do
        set i=i+1;
        if i%4=0 then iterate myWhile;
        end if;
		set sum=sum+i;
        if sum>1000 then leave myWhile;
        end if;
	end while;
    select '1~100까지의 합(4의 배수 제외, 합계가 1000을 넘기면 종료)' as 문제,sum;
end$$
delimiter ;
call whileProc();

-- PREPARE-EXECUTE문
set @cutDate=current_timestamp();
prepare myQ from 'insert into gate_table values(null,?)';
execute myQ using @cutDate;
deallocate prepare myQ;
select * from gate_table;
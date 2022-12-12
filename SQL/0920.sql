######################### Stored Procedure #########################
use market_db;
drop procedure if exists user_proc;
delimiter $$
create procedure user_proc(in userName varchar(10)) #"in|out 매개변수이름 매개변수타입"으로 매개변수 설정
begin
	select * from member where mem_name=userName; #칼럼이 매개변수이름과 같은 로우를 출력
end$$
delimiter ;
call user_proc('에이핑크');
# 구분자 변경, 복원 줄에는 주석을 쓰면 안됨!!!
drop procedure if exists user_proc1;
delimiter $$
create procedure user_proc1(in userNumber int, in userHeight int) #매개변수 두 개
begin
	select * from member where mem_number>userNumber and height>userHeight;
end$$
delimiter ;
call user_proc1(6,165);

drop procedure if exists user_proc2;
delimiter $$
create procedure user_proc2(in txtValue char(10), out outValue int) #문자형 입력 매개변수, 정수형 출력 매개변수
begin
	insert into noTable values(null, txtValue); #없는 테이블이어도 스토어드 프로시저 선언부에선 문제가 없음
    select max(id) into outValue from noTable; #조회 결과를 outValue 변수에 저장
end$$
delimiter ;
#call user_proc2('테스트',@myValue); #호출할 때도 테이블이 없으면 에러 발생

drop table if exists noTable;
create table noTable(id int auto_increment primary key,txt char(10)); #스토어드 프로시저 선언부에서 호출한 테이블 생성
call user_proc2('테스트',@myValue); #@myValue에 함수의 연산이 저장됨
select @myValue as '입력된 id값'; #@myValue값 호출

drop procedure if exists user_proc3;
delimiter $$
create procedure user_proc3(in memberName varchar(8)) #varchar형 입력 매개변수 설정
begin
	declare debutYear int; #정수형 변수 선언
    select year(debut_date) into debutYear from member where mem_name=memberName; #매개변수와 같은 mem_name속성 로우의 debut_date의 연도 부분을 변수에 저장
    if debutYear>=2015 then select '신인가수네요 화이팅하세요' as '메시지';
    else select '고참가수네요 그동안 수고하셨어요' as '메시지';
    end if;
end$$
delimiter ;
call user_proc3('에이핑크');

select curdate(), #오늘 날짜 호출
	year(curdate()), #날짜형의 연도 추출
    month(curdate()), #날짜형의 월 추출
    day(curdate()); #날짜형의 일 추출
    
drop procedure if exists user_proc4;
delimiter $$
create procedure user_proc4()
begin
	declare num int default 1; #초기값 1의 정수형 변수 num 선언
    declare sum int default 0;
    while num<=100 do #num이 100 이하임을 만족할 동안 반복문 실행
		set sum=sum+num;
        set num=num+1;
    end while;
    select sum as '1부터 100까지의 합';
end$$
delimiter ;
call user_proc4();

#동적 SQL
drop procedure if exists dynamic_proc;
delimiter $$
create procedure dynamic_proc(in tableName char(20))
begin
	set @sqlQuery=concat('select * from ', tableName); #sql문을 변수에 저장
    prepare myQuery from @sqlQuery; #sql문을 실행준비
    execute myQuery; #준비된 sql문을 실행
    deallocate prepare myQuery; #sql문을 해제
end$$
delimiter ;
call dynamic_proc('member'); #select * from member와 같은 동작 수행
call dynamic_proc('buy'); #select * from buy와 같은 동작 수행

######################### Stored Function #########################
#set global log_bin_trust_function_creators=1; #스토어드 함수 생성 권한 허용(딱 한번만 하면 됨)

drop function if exists sumFunc; #해당 함수가 이미 존재할 경우 삭제
delimiter //
create function sumFunc(num1 int, num2 int) #함수 선언
	returns int #리턴타입 설정
begin
	return num1+num2; #정수형 결과 리턴
end // #함수 종료
delimiter ;
select sumFunc(100,200) as 합계; #함수 호출

drop function if exists calcYear;
delimiter //
create function calcYear(dYear int) returns int #정수값을 리턴하는 함수 선언
begin
	declare runYear int;
    set runYear=year(curdate())-dYear;
    return runYear;
end//
delimiter ;
select calcYear(2010) as '활동기간(년)'; #함수의 리턴을 출력
select calcYear(2007) into @debut2007; #함수의 리턴을 변수에 저장
select calcYear(2013) into @debut2013;
select @debut2007-@debut2013 as '2007~2013'; #저장된 변수끼리의 연산도 가능
select mem_id, mem_name, calcYear(Year(debut_date)) as '활동기간' from member; #함수 사용

show create function calcYear; #스토어드 함수의 내용 확인
show create procedure dynamic_proc; #스토어드 프로시저의 내용 확인

############################ 커서 ###########################
drop procedure if exists memberAvg_proc;
delimiter //
create procedure memberAvg_proc()
begin
	declare memNumber int;
    declare cnt int default 0;
    declare totNumber int default 0;
    declare endOfRow boolean default false; #사용할 변수들 선언
    
    declare memberCursor cursor for select mem_number from member; #커서를 이동해 데이터를 가져올 행의 속성에 커서 선언
    declare continue handler for not found set endOfRow=true; #반복 조건 선언: 남은 행이 없을 때 set문을 실행
    open memberCursor; #커서 열기
    cursor_loop: loop #반복문 시작
		fetch memberCursor into memNumber; #fetch: 한 행씩 읽어옴 -> 한 행씩 읽어와서 변수에 저장함
		if endOfRow then leave cursor_loop; #루프의 종료 조건 설정(endOfRow가 참이면 루프를 떠나라)
        end if;
        set cnt=cnt+1;
        set totNumber=totNumber+memNumber; #각 행의 모든 mem_number속성값을 더함
	end loop cursor_loop; #반복문의 끝
    select totNumber/cnt as '회원의 평균 인원수';
    close memberCursor; #커서 닫기
end//
delimiter ;
call memberAvg_proc();

###########트리거###########
create table if not exists trigger_table(id int, txt varchar(10)); #테이블이 존재하지 않으면 생성
insert into trigger_table values(1,'레드벨벳');
insert into trigger_table values(2,'잇지');
insert into trigger_table values(3,'블랙핑크');

drop trigger if exists myTrigger;
delimiter //
create trigger myTrigger after delete on trigger_table for each row #트리거 선언(trigger_table에서 delete문이 실행될 때 각 행마다 실행되는)
begin
	set @msg='가수 그룹이 삭제됨'; #트리거 실행문
end//
delimiter ;

set @msg='';
insert into trigger_table values(4,'마마무');
select @msg;
update trigger_table set txt='아이브' where id=4;
select @msg;
delete from trigger_table where id=4;
select @msg; #delete가 실행될 때만 트리거가 발생하는 것을 확인할 수 있음

drop table if exists backup_singer, singer;
create table singer(select mem_id, mem_name, mem_number, addr from member); #기존 테이블을 복사해 새로운 테이블 생성
create table backup_singer( #백업 테이블 생성
	mem_id char(8) not null,
    mem_name varchar(10) not null,
    mem_number int not null,
    addr char(2) not null,
    modType char(2),
    modDate date,
    modUser varchar(30));
drop trigger if exists singer_updateTrg;
delimiter //
create trigger singer_updateTrg after update on singer for each row
begin
	insert into backup_singer values(old.mem_id,old.mem_name,old.mem_number,old.addr,'수정',curdate(),current_user());
end //
delimiter ;
drop trigger if exists singer_deleteTrg;
delimiter //
create trigger singer_deleteTrg after delete on singer for each row
begin
	insert into backup_singer values(old.mem_id,old.mem_name,old.mem_number,old.addr,'삭제',curdate(),current_user());
end//
delimiter ;

update singer set addr='영국' where mem_id='BLK';
delete from singer where mem_number>=7;
select * from backup_singer;
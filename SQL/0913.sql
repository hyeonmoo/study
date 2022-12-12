USE market_db;

SELECT * FROM member WHERE mem_name='블랙핑크'; #mem_name이 블랙핑크인 튜플 조회
SELECT * FROM member WHERE mem_number=4; #멤버 수가 4명인 튜플 조회

SELECT mem_id, height, mem_name FROM member WHERE height>=165 AND mem_number>6; 
SELECT mem_name, height, mem_number FROM member WHERE height>=165 OR mem_number>6;
SELECT mem_name, height FROM member WHERE height BETWEEN 163 AND 165;
SELECT mem_name, addr FROM member WHERE addr IN ('경기', '전남', '경남');
SELECT * FROM member WHERE mem_name LIKE '우%';
SELECT * FROM member WHERE mem_name LIKE '__핑크';
SELECT mem_name, height FROM member WHERE height>(SELECT height FROM member WHERE mem_name='에이핑크'); #그룹명이 에이핑크인 튜플의 평균키보다 큰 평균키를 가진 튜플의 이름, 평균키 조회
SELECT mem_id, mem_name, debut_date FROM member ORDER BY debut_date; #데뷔일 기준으로 오름차순 정렬
SELECT mem_id, mem_name, debut_date, height FROM member WHERE height>=164 ORDER BY height DESC, debut_date ASC; #평균키가 164 이상인 튜플을 키 내림차순, 데뷔일 오름차순으로 정렬
SELECT mem_name, debut_date FROM member ORDER BY debut_date LIMIT 3; #데뷔일 기준 오름차순 정렬 후 상위 3개 튜플 조회
SELECT mem_name, debut_date FROM member ORDER BY height DESC LIMIT 3,2; #평균 키 기준 내림차순 정렬 후 3번째부터 2개 튜플 조회
SELECT DISTINCT addr FROM member; #주소 중복없이 조회
-- 뷰 생성
drop view if exists member_view;
create view member_view as select * from member;
select * from member_view;

SELECT * FROM buy;
SELECT mem_id "회원 아이디", sum(amount) "총 구매 개수" FROM buy GROUP BY mem_id;
SELECT mem_id "회원 아이디", sum(price*amount) "총 구매 금액" FROM buy GROUP BY mem_id;
SELECT mem_id "회원 아이디", avg(amount) "평균구매개수" FROM buy GROUP BY mem_id;
SELECT COUNT(*) FROM MEMBER;
SELECT COUNT(phone1) FROM MEMBER;
SELECT COUNT(phone2) FROM MEMBER;
SELECT COUNT(mem_id) FROM buy WHERE mem_id="MMU";

SELECT mem_id "회원 아이디", sum(price*amount) "총 구매금액" FROM buy GROUP BY mem_id HAVING sum(price*amount)>1000;

insert into 
	delivery_mst
values (0, '대한통운', '김준일','부산광역시 연제구 중앙대로 1001 부산광역시청', '김춘식', '010-8282-5353','안전하게 배송해주세요');

select 
	delivery_id,
    delivery_company,
    delivery_man,
    delivery_address,
	consignee_name,
    consignee_phone,
    consignee_message
from
	delivery_mst;
    
#=====================================================

show databases;
use delivery_db;
show tables;
describe delivery_mst;

#=========================================
# 학생이름 입력
insert into student_mst values(0,'김춘식');
insert into student_mst values(0,'손흥민');

select * from student_mst;

insert into subject_mst values(0,'컴퓨터 구조');
insert into subject_mst values(0,'데이터베이스');
insert into subject_mst values(0,'인공지능');

select * from subject_mst;

insert into 
	grade_mst 
values
	(0, 1, 1, '95'),
    (0, 2, 1, '84'),
    (0,1,2,'89'),
    (0,2,2,'92'),
    (0,1,3,'100'),
    (0,2,3,'88');

select * from grade_mst;

select 
	gm.grade_id as 순번,
    sm.student_id as 학번,
    sm.student_name as 이름,
    sbm.subject_id as 과목번호,
    sbm.subject_name as 과목이름,
    gm.grade_score as 점수
from
	grade_mst gm
    left outer join student_mst sm on (sm.student_id = gm.student_id)
    left outer join subject_mst sbm on (sbm.subject_id = gm.subject_id);
		
#====================================================

insert into 
	상품
values
	(0, '딸기사탕', 50),
    (0, '누룽지사탕', 100);
    
select * from 상품;

start transaction;

insert into 상품
values(0,'오렌지사탕',20);

update 상품
set
	수량 = 200
where
	상품코드 = 2;
    
delete
from
	상품
where
	상품코드 = 2;
    
commit;

select * from 상품;

START TRANSACTION;

INSERT INTO 상품
VALUES (3, '오렌지사탕', 20);

UPDATE 상품 
SET 
	수량 = 200 
WHERE 
	상품코드 = 1;

DELETE
FROM 
	상품 
WHERE 
	상품명 = '누룽지사탕';

ROLLBACK;
#=========================================================
create index student_id ON student_mst (student_code);
show index from student_mst;

#===========================================================
	
SELECT
    ID,
    USERNAME,
    PASSWORD,
    NAME,
    EMAIL
FROM
    USER_MST
WHERE
    ID BETWEEN 1 AND 200;

create view user_view as
select
	USERNAME
from
	user_mst;
    
select 
	* 
from 
	user_view
where
	USERNAME like 'a%';
    
#=============================================

create index student_id ON student_mst (student_code);
show index from student_mst;

show databases;
use student_db;
show tables;
describe user_view;
#====================================================
show indexes from student_mst;

select table_name, table_type 
from information_schema.tables 
where table_schema = 'student_db' and table_type = 'VIEW';



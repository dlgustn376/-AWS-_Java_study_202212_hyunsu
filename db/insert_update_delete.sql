/*

DML
C : insert  /into  데이터 추가

R : select / from  데이터 추출

U : update / set  데이터 수정

D : delete / from  데이터 삭제

*/

/*==========================< insert >===============================*/
/*
입력 방법
1.
insert into 
	`db_study2_explain`.`student_mst`
	(`student_id`,`student_name`)
values (4, '손지호');

2.
insert into student_mst(student_id, student_name) values(5, '손지호');

3.
insert into student_mst
	(student_id,	student_name,	mentor_id)
values
	(5, 			'이강용', 			10),
	(6, 			'김준경', 			10),
	(7, 			'이현수', 			10),
	(8, 			'정의현', 			10);

*/




    
/* 대학교 */

insert into university_mst
	(university_id,			university_name)
values
	(4,						'연세대'),
    (5,						'고려대'),
    (6,						'경희대'),
    (7,						'인제대'),
    (8,						'카이스트');
    
insert into `db_study2_explain`.`university_mst`
	(university_id, university_name)
values
	(1, '서울대'),
	(2, '부산대'),
	(3, '경상대');
    
insert into university_mst values(11, '신라대');    
    
select * from university_mst;



/*===========================< update >============================*/

update student_mst
set 
	student_name = '김재영',
	mentor_id = 15
where
	student_id = 5;

select * from student_mst;

/* 멘토 아이디가 10인 학생들의 멘토 아이디를 1로 바꿔라 */
update student_mst
set
	mentor_id = 2
where
	mentor_id = null;

select * from student_mst;


/*============================< delete >====================================*/

delete from 
	student_mst 
where 
	student_id = 4
and student_name = '손지호';

delete from
	university_mst
where
	university_id = 7
and university_name = '인제대';

select * from university_mst;

delete from university_mst;





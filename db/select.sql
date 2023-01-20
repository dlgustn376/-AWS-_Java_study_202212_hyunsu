/*===================< select >=========================*/

/* 전체 컬럼 조회 */
select
	*
from
	student_mst;
    
/* 지정 컬럼 조회 */
select
	student_id,
    student_name,
    mentor_id
from
	student_mst;

/* 임시 컬럼 추가 */
/*
	단순 출력
    select 결과가 1개인 컬럼만 되는 것을 표현
*/

select
	1 as num,
    '김준일' as name;

select 
	student_id,
    student_name,
    '김준일' as instructor_name
from
	student_mst;


    
/* 컬럼명을 임시로 바꾸는 방법 as(alias) 알리아스 */
/*
	자바에서는 카멜 표기법을 이용하기 때문에 바꾸어 줘야함.
    컬럼에서는 잘 안하고, 테이블에서는 함.
*/
select
	student_id as studentId
from
	student_mst sm;
    
select
	student_mst.student_id studentID
from
	student_mst;
    
select
	sm.student_id studentID
from
	student_mst sm;


/* 조회조건 where  */
select		/*6*/
	*
from		/*4*/
	student_mst
where		/*5*/
	mentor_id = (select		/*3*/
					mentor_id
				from		/*1*/
					mentor_mst
				where		/*2*/
					mentor_name = '문자영');
                    
/*
	select를 한 타당한 이유를 제시하여야 한다.
    2개 이상 사용시, 성능과 직결되므로...
    
    select 문에서 실행순서가 있다.
    1. from 
    2. where
    3. select
    순서대로 실행됨.
*/
    
select
	student_id,
    student_name,
    mentor_id,
    (select 
		mentor_name 
	from 
		mentor_mst 
	where 
		mentor_id = student_mst.mentor_id) as mentor_name
from
	student_mst;

/* 그룹으로 묶어서 조회하기 */
select
	count(mentor_id), 	# 그룹으로 묶인 것의 갯수 
    min(student_id), 	# 그룹으로 묶인 것 중에서 최소
    max(student_id), 	# 그룹으로 묶인 것 중에서 최대
    avg(student_id),	# 그룹으로 묶인 것 중에서 평균
    sum(student_id),	# 그룹으로 묶인 것 합
	mentor_id
from
	student_mst
group by    
    mentor_id;
    
/* 그룹으로 조회한 결과에 조건주는 방법 */
select
	count(mentor_id) as mentor_count, 	# 그룹으로 묶인 것의 갯수 
    min(student_id), 	# 그룹으로 묶인 것 중에서 최소
    max(student_id), 	# 그룹으로 묶인 것 중에서 최대
    avg(student_id),	# 그룹으로 묶인 것 중에서 평균
    sum(student_id),	# 그룹으로 묶인 것 합
	mentor_id
from
	student_mst
group by    
    mentor_id
having
	mentor_count = 5;
  
/* 중복 제거 distinct 사용 */
select distinct
	mentor_id
from
	student_mst;
    
    
/* 정렬 */
# 기본 오름차순
# desc 내림차순

select
	*
from
	student_mst
order by
	mentor_id,			#오름차순
    student_id desc;	#내림차순
    
/* 전체 조합 실습 */
select							# 5
	count(*) as student_count,
    mentor_id
from							# 1
	student_mst
where							# 2
	student_id > 2				# 테이블에서 조건
group by						# 3
	mentor_id
having							# 4 
	student_count = 1			# group by로 묶었을 때, 조건
order by						#6
	mentor_id desc;
    
    
    
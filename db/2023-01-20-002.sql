/*===========================<< select >>=================================*/

select * from student_mst;

# 전체 컬럼 조회

select
	*
from
	student_mst;
    
# 지정 컬럼 조회

select
	student_id,
    student_name,
    mentor_id
from
	student_mst;

# 임시 컬럼 추가

select
	1 as num,
    '김준일' as name;
    
select 
	student_id,
    student_name,
    '김준일' as instructor_name
from
	student_mst;

# 컬럼명을 임시로 바꾸는 방법 as(alias) 알리아스
select
	student_id as studentId
from
	student_mst sm;
    
select
	sm.student_id  StudentId #보통 알리아스를 사용한다.
from
	student_mst sm;
    
# 조회조건 where
# 쿼리의 실행순서는 from이 우선순위 select가 제일 마지막이다.

select
	*
from
	student_mst  
where
	mentor_id = (select
					mentor_id
				from
					mentor_mst
				where
					mentor_name = '문자영');  

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
    
# 그룹으로 묶어서 조회하기
# group by는 중복 제거로 사용하면 안 된다.
    
select
	count(mentor_id), # 그룹으로 묶인 대상 수
    min(student_id), #그룹으로 묶인 애들중에 제일 낮은 번호
    max(student_id), #그룹으로 묶인 애들중에서 가장 높은 번호
    avg(student_id), # 평균
    sum(student_id), #합계
    
    mentor_id
from
	student_mst
group by
	mentor_id;
    
# 그룹으로 조회한 결과에 주건주는 방법
    
select
	count(mentor_id) as mentor_count, # 그룹으로 묶인 대상 수
    min(student_id) as student_min, #그룹으로 묶인 애들중에 제일 낮은 번호
    max(student_id), #그룹으로 묶인 애들중에서 가장 높은 번호
    avg(student_id), # 평균
    sum(student_id), #합계
    
    mentor_id
from
	student_mst
group by
	mentor_id
having # 그룹의 결과를 뽑아낸 것, group by를 사용하고 나서 쓴다.
	mentor_count = 5;
   
#  중복제거 
select distinct	
	mentor_id
from
	student_mst;

# 정렬

select 
	*
from
	student_mst
order by
	mentor_id, # 내림차순은 mentor_id desc;
    student_id desc;
    
# 전체 조합 실습

select
	count(*) as student_count, # 5.
    mentor_id
from
	student_mst # 1. 조회해라
where
	student_id > 2 # 2. student_id가 2보다 크면
group by
	mentor_id # 3. mentor_id끼리
having
	student_count = 1 # 4. 조건 검사(group by필수)
order by
	mentor_id desc; # 6.


select 
	*
from 
	library_mst
where
	#도서명 like '나를%'; # %나를% -> 아무곳이나, %나를 -> 나를로 끝나는 것, 나를%-> 나를로 시작하는 것
	저작자 in('채사장 지음', '최인철 지음');
    # like와 in을 같이 쓰기 위해서는 or을 사용해야 한다.
    
#====================================<<select insert>>>>>>>>>============================================
insert into author_mst
	(author_name)
select distinct
	저작자
from	
	library_mst
order by 
	저작자;
    
select *
from 
	author_mst;
    
insert into publisher_mst
	(publisher_name)
select distinct
	출판사
from 
	library_mst
order by
	출판사;
    
select * from publisher_mst;
    
# ===================================<< select update >>============================
update library_mst lm
set lm.저작자 = (select
					am.author_id
				from
					author_mst am
				where
					am.author_name = lm.저작자);
			
update library_mst, author_mst
set
	저작자 = author_id
where
	저작자 = author_name;
    
select
	*
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
order by
	am.author_id;

select * from library_mst;

update library_mst, publisher_mst
set
	출판사 = publisher_mst.publisher_id
where 
	출판사 = publisher_name;

delete
from
	library_mst
where
	순번 > 1000;
    

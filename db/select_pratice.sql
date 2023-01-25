select
	*
from
	library_mst
where
	순번 < 50
and 출판사 = '웨일북';


select
	*
from
	library_mst
where
	도서명 like '%나를%';			#'%나를%' : '나를'이 포함된 도서 검색. %나를 : '나를'로 끝나는 것만 검색. 나를% : '나를'로 시작하는 것만 검색.

select
	*
from
	library_mst
where
	도서명 like '%지적%' and 저작자 in('채사장 지음', '최인철 지음');

# like와 in을 같이 쓸수 없다. or를 사용한 경우 가능.

/*============================================<< select insert >>=================================================*/

# 저작자 테이블에 저자이름 넣기
insert into author_mst 
	(author_name) 
select distinct
	저작자
from
	library_mst
order by
	저작자;
    
    
# 출판사 테이블에 이름 넣기
insert into publisher_mst 
	(publisher_name)
select distinct
	출판사
from
	library_mst
order by
	출판사;

select 
	*
from
	author_mst;

select 
	*
from
	publisher_mst;
    

/*============================================<< select update >>=================================================*/
/*
update 
	library_mst lm
set 
	lm.저작자 = (select
					author_id
				from
					author_mst am
				where
					am.author_name = lm.저작자);
*/


update library_mst, author_mst
set
	저작자 = author_id
where
	저작자 = author_name;
    
update library_mst, publisher_mst
set
	출판사 = publisher_id
where
	출판사 = publisher_name;
    
select
	순번, 도서관명, 구분, 도서명, author_name as 저자, publisher_name as 출판, 발행연도, 청구기호
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자) 
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사);
    
select
	*
from
	library_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자) 
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사);


delete
from
	library_mst
where
	순번 > 1000;

SELECT * FROM library_mst;
select * from author_mst;
select * from publisher_mst;

/* 김주 입력되어서 김주라는 이름을 가진 사람의 책이 나와야 함 */

set profiling = 1;
set profiling_history_size = 30;

show profiles;

select
	도서관명,
    도서명
from
	library_mst
where
	 저작자 in (select author_id from author_mst where author_name like '%김주%');


select
	도서관명,
    도서명
from
	library_mst
where
	저작자 > 100
and 저작자 < 110;
# ; 없애고 union
# union all

select
	도서관명,
    도서명
from
	library_mst
where
	출판사 in(select publisher_id from publisher_mst where publisher_name like ('%위즈덤%'));
show profiles;

select
	도서관명,
	도서명
from
	library_mst lm
    left outer join author_mst am on (am.author_id = lm.저작자)
where
	am.author_name like '%김주%' or am.author_name like '%김민%';



select author_id
from 
	author_mst
where 
	author_name like('김주%');
    



    
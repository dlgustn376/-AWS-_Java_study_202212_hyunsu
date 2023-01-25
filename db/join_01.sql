#join
select
	*
from 
	library_mst;

select
	*
from
	author_mst;
    
select
	*
from
	publisher_mst;
    
select
	순번,
    도서관명, 
    구분, 
    도서명, 
    저작자,
    (select author_name from author_mst where author_id = 저작자) as 저작자명,
    출판사, 
    (select publisher_name from publisher_mst where publisher_id = 출판사) as 출판사명,
    (select publisher_year from publisher_mst where publisher_id = 출판사) as 출판사설립일,
    발행연도, 
    청구기호
from
	library_mst;
    
    
/*=======================================================================================*/
insert into library_mst
values (0,'테스트도서관','999(테스트)','테스트도서명', '9999', '9999', '2023', '999.9-테99ㅌ');

# 모든 경우의 수 결과가 출력됨.

# outer 조합	바깥쪽 left, rignt가 존재.
# left outer 왼쪽을 기준으로 출력.
# right outer 오른쪽을 기준으로 출력.

# inner join
# inner 조합 안쪽 A 테이블과 B 테이블 양쪽다 있는 컬럼, on을 기준으로 붙인다.
SELECT * FROM db_study3.library_mst order by 순번 desc;

select
	*
from
	library_mst lm #마스터 테이블로 마스터 테이블을 기준으로 붙어준다.
	left outer join publisher_mst pm on (pm.publisher_id = lm.출판사)
order by
	lm.순번 desc;
    
    
select
	lm.순번,
    lm.도서관명,
    lm.구분,
    lm.도서명,
    lm.출판사,
    pm.publisher_name,
    pm.publisher_year
from
	library_mst lm 
	left outer join publisher_mst pm on (pm.publisher_id = lm.출판사) # on이 기준이 됨.
where    
	pm.publisher_id is null; # pk와 외래키, publisher_id는 외래키이면서 pk.
order by
	lm.순번 desc;
    
set profiling = 1;
set profiling_history_size = 1000;
select
	lm.순번,
    lm.도서관명,
    lm.구분,
    lm.도서명,
    lm.출판사,
    pm.publisher_name,
    pm.publisher_year
from
	library_mst lm 
	left outer join publisher_mst pm on (pm.publisher_id = lm.출판사) # on이 기준이 됨.
order by
	lm.순번 desc;

show profiles;

#self join : 자신에게 자신을 join 한 번 더 join 것. sub 쿼리랑 같이 사용함.   
    
# book_mst 자료 넣기



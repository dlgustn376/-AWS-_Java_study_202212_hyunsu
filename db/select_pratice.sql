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

    
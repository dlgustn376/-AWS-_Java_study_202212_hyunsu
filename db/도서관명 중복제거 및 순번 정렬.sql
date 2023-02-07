create view library_view as
select
	row_number() over(order by 도서관명) as 도서관순번,
	도서관명
from
	library_mst
group by
	도서관명;
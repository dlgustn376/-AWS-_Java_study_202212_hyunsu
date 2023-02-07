
# index
create index product_id on product_mst(product_code); 

show index from product_mst;

# alter
alter table product_mst 
add unique product_name(product_name); # 키값을 넣어줌. 유니크 키값

alter table product_mst 
drop index product_id1; # 키값 지우기


SELECT
	*
FROM 
	product_mst;
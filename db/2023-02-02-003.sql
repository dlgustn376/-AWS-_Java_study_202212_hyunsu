CREATE INDEX product_id on product_mst(product_code);

show index from product_mst;

alter table product_mst
add unique product_name(product_name); # 유니크 키 추가

alter table product_mst 
drop index product_id1; # 삭제

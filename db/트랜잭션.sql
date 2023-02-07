show variables like 'AUROCOMMIT';
set autocommit = 0;

# 트랜잭션이 열린 상태
start transaction;

# 지금부터 저장을 할 것이라는 의미.
savepoint sp2;

insert into user_mst
values (0, 'qwerasdf', '1234', '김준일', 'qwerasdf@gmail.com');
 
select * from user_mst;

rollback to sp2;

# commit을 해야 트랜잭션이 닫힘.
commit;
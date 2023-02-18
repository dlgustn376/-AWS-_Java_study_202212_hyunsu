show variables like 'AUTOCOMMIT';
set autocommit = 0;

start transaction; #트랜잭션 시작

savepoint sp3; # 세이브 포인트, 지금부터 시작

insert into user_mst
values (0, 'jjj', '1234', '김준일','jjj@gmail.com');

select 
	*
from
	user_mst;
    
rollback to sp1; --  되돌리기, 시작 지점으로 복구

commit; 
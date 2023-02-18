select 
	um.user_id, 
	um.username, 
    um.password, 
    um.name, 
    um.email,
    rd.role_dtl_id,
    rd.role_id,
    rd.user_id,
    rm.role_id,
    rm.role_name
from 
	user_mst  um
    left outer join role_dtl rd on(rd.user_id = um.user_id)
    left outer join role_mst user_mstrm on(rm.role_id = rd.role_id)
where 
	username = 'aaa';
    

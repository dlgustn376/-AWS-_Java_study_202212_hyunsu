insert into user_mst
values (0, 'test', '1234', 'test', 'test@gamil.com');

delete
from
	user_mst
where
	username = 'test';


call show_all_user_mst('안녕하세요'); # 함수 호출show_all_user_mstshow_all_user_mstinsert_product
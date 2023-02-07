CREATE TABLE sales ( 
    customer VARCHAR(255), 
    amount INT
);

INSERT INTO sales (customer, amount)
VALUES 
    ('John', 100), 
    ('Jane', 200), 
    ('John', 150), 
    ('Jane', 50), 
    ('Jim', 300);
    
select * from sales;

select distinct customer from sales;

select
	s.customer,
    t. totaLsales,
    case
		when totaLsales > 250 then 1
        else 2
	end as sales_rank
from
	(select 
		customer, 
        sum(amount) as totaLsales 
        from 
			sales 
        group by 
			customer) t
	join (select distinct customer from sales) s on t.customer = s.customer;
    
    
WITH customer_totals AS (
SELECT
customer,
SUM(amount) AS total_amount
FROM
sales
GROUP BY
customer
)
SELECT
customer,
total_amount,
CASE
WHEN total_amount > 250 THEN 1
ELSE 2
END AS sale_rank
FROM
customer_totals;


SELECT
s.customer,
t.total_amount,
CASE
WHEN t.total_amount > 250 THEN 1
ELSE 2
END AS sale_rank
FROM
(SELECT customer, SUM(amount) AS total_amount FROM sales GROUP BY customer) t
JOIN (SELECT DISTINCT customer FROM sales) s ON t.customer = s.customer;


#==================================================================
#CREATE GROUP admin_group;
#CREATE USER new_user;
#ALTER GROUP admin_group ADD USER new_user;
#GRANT SELECT, INSERT, UPDATE ON . TO admin_group;

#CREATE USER 'new_user'@'localhost';
#GRANT SELECT, INSERT, UPDATE ON . TO 'new_user'@'localhost';
#CREATE USER 'new_user'@'localhost' IDENTIFIED BY 'password';
#CREATE GROUP admin_group;
#GRANT SELECT, INSERT, UPDATE ON database.* TO 'new_user'@'localhost';
#ADD USER 'new_user'@'localhost' TO GROUP admin_group;



#==================================================================


insert into 
	user_mst
values
	(0,'JOHN','JOHN@gamil.com'),
	(0,'JANE','JANE@gamil.com'),
	(0,'JIM','JIM@gamil.com');
    
select * from user_mst;

insert into 
	user_dtl
values
	(0,1,'010-1111-2222','MALE'),
	(0,2,'010-3333-4444','FEMALE'),
	(0,3,'010-5555-6666','MALE');

select * from user_dtl;

call FIND_USER_BY_USERNAME('JHON');

#=====================================================

delete
from
	user_mst
where
	user_id = 18;
    
delete
from
	user_dtl
where
	user_dtl_id = 21;


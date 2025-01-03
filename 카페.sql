
--drop table customers purge;
Create table customers (
	id VARCHAR2(30) not null PRIMARY KEY,
	name VARCHAR2(10),
	password VARCHAR2(50),
	hphone VARCHAR2(20),
	balance NUMBER
);

--drop SEQUENCE SEQMENU;
CREATE SEQUENCE seqmenu;

--drop table menu purge;
create table menu (
  cid number not null primary key,
  cname varchar(255),
  image varchar(255),
  price number,
  kcal number
);

--drop SEQUENCE SEQORDER;
CREATE SEQUENCE seqorder;

--drop table orders purge;
create table orders (
  oid number PRIMARY KEY,
  id varchar2(30),
  cid number
);

-- customers의 id를 order에 외래키로 설정
alter TABLE orders ADD CONSTRAINT orders_id_fk
FOREIGN KEY(id) REFERENCES customers(id) ON DELETE SET NULL;

-- menu의 cid를 order에 외래키로 설정
alter TABLE orders ADD CONSTRAINT orders_cid_fk
FOREIGN KEY(cid) REFERENCES menu(cid) ON DELETE SET NULL;

select * from CUSTOMERS;

select * from menu;

select * from orders;

-- 별칭 꼭 쓰기, 미니 빈(string, 정수형 변수 가지고 있는 걸 만들어)
SELECT CUSTOMERS.ID as idcheck, SUM(MENU.PRICE) as total FROM MENU
INNER JOIN ORDERS ON MENU.CID = ORDERS.CID
INNER JOIN CUSTOMERS ON ORDERS.ID = CUSTOMERS.ID
WHERE CUSTOMERS.ID='cafe1'
GROUP BY CUSTOMERS.ID;

SELECT MENU.CID, MENU.CNAME, count(*) as cnt, SUM(MENU.PRICE) as total FROM MENU
INNER JOIN ORDERS ON MENU.CID = ORDERS.CID
INNER JOIN CUSTOMERS ON ORDERS.ID = CUSTOMERS.ID
WHERE CUSTOMERS.ID='cafe1'
GROUP BY MENU.CID, MENU.CNAME;

SELECT CUSTOMERS.ID, MENU.CNAME FROM MENU
INNER JOIN ORDERS ON MENU.CID = ORDERS.CID
INNER JOIN CUSTOMERS ON ORDERS.ID = CUSTOMERS.ID
WHERE CUSTOMERS.ID='cafe1';

SELECT ID FROM ORDERS WHERE ID = 'cafe1' GROUP BY ID;
commit;

update CUSTOMERS SET BALANCE = 50000 where id = 'cafe1';

select balance from CUSTOMERS where id='cafe1';

rollback;
delete from orders where id = 'cafe1';
select * from orders where cid = '?';

delete FROM orders
where exists (
select * from menu where menu.cid=order.cid
);
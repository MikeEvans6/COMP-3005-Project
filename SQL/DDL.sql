The DDL statements for the creation of all the tables

create table publisher
(p_name varchar(40),
address varchar(50),
phone_num numeric(10,0),
email varchar(40),
bank_account numeric(8,2),
primary key (p_name)
);

create table book
(ISBN numeric(13,0),
title varchar(60),
genre varchar(20),
year numeric(4,0),
price numeric(5,2),
pages numeric(4,0),
p_name varchar(40),
primary key (ISBN),
foreign key (p_name) references publisher
);

create table warehouse
(warehouse_id numeric(2,0),
address varchar(50),
phone_num numeric(10,0),
primary key (warehouse_id)
);

create table author
(a_name varchar(40),
address varchar(50),
phone_num numeric(10,0),
primary key (a_name)
);

create table written_by
(ISBN numeric(13,0),
a_name varchar(40),
primary key (ISBN, a_name),
foreign key (ISBN) references book,
foreign key (a_name) references author
);

create table storage
(warehouse_id numeric(2,0),
ISBN numeric(13,0),
quantity numeric(3,0),
primary key (warehouse_id, ISBN),
foreign key (ISBN) references book,
foreign key (warehouse_id) references warehouse
);

create table checkout_basket
(checkout_id numeric(4,0),
ISBN numeric(13,0),
quantity numeric(3,0),
primary key (checkout_id),
foreign key (ISBN) references book
);

create table customer
(email varchar(40),
name varchar(20),
address varchar(50),
phone_num numeric(10,0),
password varchar(20),
checkout_id numeric(4,0),
primary key (email),
foreign key (checkout_id) references checkout_basket
);

create table orders
(order_num numeric (4,0),
shipping_info varchar(70),
billing_info varchar(70),
total_price numeric(6,2),
email varchar(40),
primary key (order_num),
foreign key (email) references customer
);

create table track
(order_num numeric (4,0),
warehouse_id numeric(2,0),
location varchar(50),
primary key (order_num, warehouse_id),
foreign key (order_num) references orders,
foreign key (warehouse_id) references warehouse
);
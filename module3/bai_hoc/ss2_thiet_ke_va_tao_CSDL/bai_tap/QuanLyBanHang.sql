drop database if exists quan_ly_ban_hang;
create database if not exists quan_ly_ban_hang;
use quan_ly_ban_hang;	
create table customer (
c_id int,
c_name varchar(255),
c_age int,
primary key(c_id)
);
create table product (
p_id int,
p_name varchar(255),
p_price int,
primary key(p_id)
);
create table orde (
o_id int,
c_id int,
o_date date,
o_total_price int,
primary key(o_id),
foreign key(c_id) references customer(c_id)
);
create table order_detail(
o_id int,
p_id int,
odQTY int,
primary key(o_id,p_id),
foreign key(o_id) references orde (o_id),
foreign key(p_id) references product(p_id)
);
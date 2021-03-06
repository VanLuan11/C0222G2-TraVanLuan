drop database if exists furama;
create database if not exists furama;
use furama;  

create table if not exists position (
position_id int auto_increment,
position_name varchar(255),
`status` bit(1) default 0,
primary key(position_id)
);

create table if not exists education_degree (
education_degree_id int auto_increment,
education_degree_name varchar(255),
`status` bit(1) default 0,
primary key(education_degree_id)
);

create table if not exists division(
division_id int auto_increment,
division_name varchar(255),
`status` bit(1) default 0,
primary key(division_id)
);

create table if not exists customer_type(
customer_type_id int auto_increment,
customer_type_name varchar(255),
`status` bit(1) default 0,
primary key(customer_type_id)
);

create table if not exists facility_type(
facility_type_id int auto_increment,
facility_type_name varchar(255),
`status` bit(1) default 0,
primary key(facility_type_id)
);

create table if not exists rent_type(
rent_type_id int auto_increment,
rent_type_name varchar(255),
rent_type_cost double,
`status` bit(1) default 0,
primary key(rent_type_id)
);

create table if not exists attach_facility(
attach_facility_id int auto_increment,
attach_facility_name varchar(255),
attach_facility_cost double,
attach_facility_unit int,
attach_facility_status varchar(255),
`status` bit(1) default 0,
primary key(attach_facility_id)
);

create table if not exists role(
role_id int auto_increment,
role_name varchar(255),
`status` bit(1) default 0,
primary key(role_id)
);

create table if not exists `user`(
user_name varchar(255),
password varchar(255),
`status` bit(1) default 0,
primary key(user_name)
);

create table if not exists user_role(
role_id int,
user_name varchar(255),
`status` bit(1) default 0,
foreign key(role_id) references role(role_id),
foreign key(user_name) references `user`(user_name)
);

create table if not exists employee(
employee_id int auto_increment,
employee_name varchar(255),
employee_birthday varchar(255),
employee_id_card varchar(255),
employee_salary double,
employee_phone varchar(255),
employee_email varchar(255),
employee_address varchar(255),
position_id int,
education_degree_id int,
division_id int,
user_name varchar(255),
foreign key(position_id) references position (position_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key(division_id) references division(division_id),
foreign key(user_name) references user(user_name),
`status` bit(1) default 0,
primary key(employee_id)
);

create table if not exists customer(
customer_id int auto_increment,
customer_type_id int,
customer_name varchar(255),
customer_birthday varchar(255),
customer_gender int,
customer_id_card varchar(255),
customer_phone varchar(255),
customer_email varchar(255),
customer_address varchar(255),
`status` bit(1) default 0,
foreign key(customer_type_id) references customer_type(customer_type_id),
primary key(customer_id)
);

create table if not exists facility(
facility_id int auto_increment,
facility_name varchar(255),
facility_area int,
facilitye_cost double,
facility_max_people int,
rent_type_id int,
facility_type_id int,
standard_room varchar(255),
description_other_convenience varchar(255),
pool_area double,
number_of_floors int,
`status` bit(1) default 0,
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(facility_type_id) references facility_type(facility_type_id),
primary key(facility_id)
);

create table if not exists contract(
contract_id int auto_increment,
contract_start_date varchar(255),
contract_end_date varchar(255),
contract_deposit double,
contract_total_money double,
employee_id int,
customer_id int,
facility_id int,
`status` bit(1) default 0,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(facility_id) references facility(facility_id),
primary key(contract_id)
);

create table if not exists contract_detail(
contract_detail_id int auto_increment,
contract_id int,
attach_facility_id int,
quantity int,
`status` bit(1) default 0,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_facility_id) references attach_facility(attach_facility_id),
primary key(contract_detail_id)
);

insert into customer_type (customer_type_name)
values ("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");

insert into customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) 
values (5,'Nguy???n Th??? H??o','1970-11-07',0,643431213,0945423362,'thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng'),
(3,'Ph???m Xu??n Di???u','1992-08-08',1,865342123,0954333333,'xuandieu92@gmail.com','K77/22 Th??i Phi??n, Qu???ng Tr???'),
(1,'Tr????ng ????nh Ngh???','1990-02-27',1,488645199,0373213122,'nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh'),
(1,'D????ng V??n Quan','1981-07-08',1,543432111,0490039241,'duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng'),
(4,'Ho??ng Tr???n Nhi Nhi','1995-12-09',0,795453345,0312345678,'nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai'),
(4,'T??n N??? M???c Ch??u','2005-12-06',0,732434215,0988888844,'tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng'),
(1,'Nguy???n M??? Kim','1984-04-08',0,856453123,0912345698,'kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh'),
(3,'Nguy???n Th??? H??o','1999-04-08',0,965656433,0763212345,'haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum'),
(1,'Tr???n ?????i Danh','1994-07-01',1,432341235,0643343433,'danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
(2,'Nguy???n T??m ?????c','1989-07-01',1,344343432,0987654321,'dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng');

insert into position (position_name)
values("Qu???n L??"),
("Nh??n Vi??n");

insert into education_degree (education_degree_name)
values ("Trung C???p"),
("Cao ?????ng"),
("?????i H???c"),
("Sau ?????i H???c");

insert into division (division_name)
values ("Sale-Marketing"),
("H??nh ch??nh"),
("Ph???c v???"),
("Qu???n l??");

insert into user(user_name,password) 
value("vanluan1",123123),
("vanluan2",123123),
("vanluan3",123123),
("vanluan4",123123),
("vanluan5",123123),
("vanluan6",123123),
("vanluan7",123123),
("vanluan8",123123),
("vanluan9",123123),
("vanluan10",123123);

insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id,user_name)
values ('Nguy???n V??n An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguy???n T???t Th??nh, ???? N???ng',1,3,1,'vanluan1'),
('L?? V??n B??nh','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','22 Y??n B??i, ???? N???ng',1,2,2,'vanluan2'),
('H??? Th??? Y???n','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 ??i???n Bi??n Ph???, Gia Lai',1,3,2,'vanluan3'),
('V?? C??ng To???n','1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com','77 Ho??ng Di???u, Qu???ng Tr???',1,4,4,'vanluan4'),
('Nguy???n B???nh Ph??t','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com','43 Y??n B??i, ???? N???ng',2,1,1,'vanluan5'),
('Kh??c Nguy???n An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguy???n T???t Th??nh, ???? N???ng',2,2,3,'vanluan6'),
('Nguy???n H???u H??','1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com','4 Nguy???n Ch?? Thanh, Hu???',2,3,2,'vanluan7'),
('Nguy???n H?? ????ng','1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com','111 H??ng V????ng, H?? N???i',2,4,4,'vanluan8'),
('T??ng Hoang','1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com','213 H??m Nghi, ???? N???ng',2,4,4,'vanluan9'),
('Nguy???n C??ng ?????o','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Ho?? Kh??nh, ?????ng Nai',2,3,2,'vanluan10');

insert into facility_type (facility_type_name)
values ("Villa"),("House"),("Room");

insert into rent_type (rent_type_name, rent_type_cost)
values ("year",100000),
("month",10000),
("day",1000),
("hour",100); 

insert into facility (facility_name, facility_area, facility_cost, facility_max_people,rent_type_id,facilitytype_id, standard_room, description_other_convenience, pool_area, number_of_floors)
values ('Villa Beach Front',25000,10000000,10,3,1,'vip','C?? h??? b??i',500,3),
('House Princess 01',14000,5000000,7,1,2,'normal','C?? th??m b???p n?????ng',NULL,2),
('Room Twin 01',5000,1000000,2,4,3,'vip','C?? tivi',NULL,1),
('Villa No Beach Front',22000,9000000,8,3,1,'vip','C?? h??? b??i',300,2),
('House Princess 02',10000,4000000,5,2,2,'normal','C?? th??m b???p n?????ng',NULL,2),
('Room Twin 02',3000,900000,2,3,3,'normal','C?? tivi',NULL,1);

insert into contract (contract_start_date, contract_end_date, contract_deposit,contract_total_money, employee_id, customer_id, facility_id)
values 
('2020-12-08','2020-12-08',3000,50000,1,3,1),
('2020-07-14','2020-07-21',2000,70000,3,1,4),
('2021-03-15','2021-03-17',5000,30000,4,2,6),
('2021-01-14','2021-01-18',1000,50000,5,5,3),
('2021-07-14','2021-07-15',3000,40000,2,6,2),
('2021-06-01','2021-06-03',5000,30000,7,6,5);

insert into attach_facility (attach_facility_name, attach_facility_cost, attach_facility_unit, attach_facility_status)
values ("Karaoke",10000,3,"ti???n nghi, hi???n ?????i"),
("Thu?? xe m??y",10000,2,"h???ng 1 xe"),
("Thu?? xe ?????p",20000,3,"t???t"),
("Buffet bu???i s??ng",15000,1,"?????y ????? ????? ??n, tr??ng mi???ng"),
("Buffet bu???i tr??a",90000,1,"?????y ????? ????? ??n, tr??ng mi???ng"),
("Buffet bu???i t???i",16000,1,"?????y ????? ????? ??n, tr??ng mi???ng");

insert into contract_detail (contract_id,attach_facility_id,quantity)
values (5,2,4),
(6,1,5),
(3,2,6),
(1,1,1),
(4,3,2),
(1,5,3),
(2,6,2),
(2,3,2);

select * from employee where employee_name like ? and employee_address like ? and `status` = 0;


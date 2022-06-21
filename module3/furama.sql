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

create table if not exists service_type(
service_type_id int auto_increment,
service_type_name varchar(255),
`status` bit(1) default 0,
primary key(service_type_id)
);

create table if not exists rent_type(
rent_type_id int auto_increment,
rent_type_name varchar(255),
rent_type_cost double,
`status` bit(1) default 0,
primary key(rent_type_id)
);

create table if not exists attach_service(
attach_service_id int auto_increment,
attach_service_name varchar(255),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(255),
`status` bit(1) default 0,
primary key(attach_service_id)
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

create table if not exists service(
service_id int auto_increment,
service_name varchar(255),
service_area int,
service_cost double,
service_max_people int,
rent_type_id int,
service_type_id int,
standard_room varchar(255),
description_other_convenience varchar(255),
pool_area double,
number_of_floors int,
`status` bit(1) default 0,
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(service_type_id) references service_type(service_type_id),
primary key(service_id)
);

create table if not exists contract(
contract_id int auto_increment,
contract_start_date varchar(255),
contract_end_date varchar(255),
contract_deposit double,
contract_total_money double,
employee_id int,
customer_id int,
service_id int,
`status` bit(1) default 0,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(service_id) references service(service_id),
primary key(contract_id)
);

create table if not exists contract_detail(
contract_detail_id int auto_increment,
contract_id int,
attach_service_id int,
quantity int,
`status` bit(1) default 0,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_service_id) references attach_service(attach_service_id),
primary key(contract_detail_id)
);

insert into customer_type (customer_type_name)
values ("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");

insert into customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) 
values (5,'Nguyễn Thị Hào','1970-11-07',0,643431213,0945423362,'thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng'),
(3,'Phạm Xuân Diệu','1992-08-08',1,865342123,0954333333,'xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị'),
(1,'Trương Đình Nghệ','1990-02-27',1,488645199,0373213122,'nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh'),
(1,'Dương Văn Quan','1981-07-08',1,543432111,0490039241,'duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng'),
(4,'Hoàng Trần Nhi Nhi','1995-12-09',0,795453345,0312345678,'nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai'),
(4,'Tôn Nữ Mộc Châu','2005-12-06',0,732434215,0988888844,'tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng'),
(1,'Nguyễn Mỹ Kim','1984-04-08',0,856453123,0912345698,'kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh'),
(3,'Nguyễn Thị Hào','1999-04-08',0,965656433,0763212345,'haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum'),
(1,'Trần Đại Danh','1994-07-01',1,432341235,0643343433,'danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi'),
(2,'Nguyễn Tâm Đắc','1989-07-01',1,344343432,0987654321,'dactam@gmail.com','22 Ngô Quyền, Đà Nẵng');

insert into position (position_name)
values("Quản Lý"),
("Nhân Viên");

insert into education_degree (education_degree_name)
values ("Trung Cấp"),
("Cao Đẳng"),
("Đại Học"),
("Sau Đại Học");

insert into division (division_name)
values ("Sale-Marketing"),
("Hành chính"),
("Phục vụ"),
("Quản lý");

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
values ('Nguyễn Văn An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1,'vanluan1'),
('Lê Văn Bình','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2,'vanluan2'),
('Hồ Thị Yến','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2,'vanluan3'),
('Võ Công Toản','1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4,'vanluan4'),
('Nguyễn Bỉnh Phát','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1,'vanluan5'),
('Khúc Nguyễn An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3,'vanluan6'),
('Nguyễn Hữu Hà','1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2,'vanluan7'),
('Nguyễn Hà Đông','1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4,'vanluan8'),
('Tòng Hoang','1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4,'vanluan9'),
('Nguyễn Công Đạo','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2,'vanluan10');

insert into service_type (service_type_name)
values ("Villa"),("House"),("Room");

insert into rent_type (rent_type_name, rent_type_cost)
values ("year",100000),
("month",10000),
("day",1000),
("hour",100); 

insert into service (service_name, service_area, service_cost, service_max_people,rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)
values ('Villa Beach Front',25000,10000000,10,3,1,'vip','Có hồ bơi',500,3),
('House Princess 01',14000,5000000,7,1,2,'normal','Có thêm bếp nướng',NULL,2),
('Room Twin 01',5000,1000000,2,4,3,'vip','Có tivi',NULL,1),
('Villa No Beach Front',22000,9000000,8,3,1,'vip','Có hồ bơi',300,2),
('House Princess 02',10000,4000000,5,2,2,'normal','Có thêm bếp nướng',NULL,2),
('Room Twin 02',3000,900000,2,3,3,'normal','Có tivi',NULL,1);

insert into contract (contract_start_date, contract_end_date, contract_deposit,contract_total_money, employee_id, customer_id, service_id)
values 
('2020-12-08','2020-12-08',3000,50000,1,3,1),
('2020-07-14','2020-07-21',2000,70000,3,1,4),
('2021-03-15','2021-03-17',5000,30000,4,2,6),
('2021-01-14','2021-01-18',1000,50000,5,5,3),
('2021-07-14','2021-07-15',3000,40000,2,6,2),
('2021-06-01','2021-06-03',5000,30000,7,6,5);

insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values ("Karaoke",10000,3,"tiện nghi, hiện đại"),
("Thuê xe máy",10000,2,"hỏng 1 xe"),
("Thuê xe đạp",20000,3,"tốt"),
("Buffet buổi sáng",15000,1,"đầy đủ đồ ăn, tráng miệng"),
("Buffet buổi trưa",90000,1,"đầy đủ đồ ăn, tráng miệng"),
("Buffet buổi tối",16000,1,"đầy đủ đồ ăn, tráng miệng");

insert into contract_detail (contract_id,attach_service_id,quantity)
values (5,2,4),
(6,1,5),
(3,2,6),
(1,1,1),
(4,3,2),
(1,5,3),
(2,6,2),
(2,3,2);

select * from employee where employee_name like ? and employee_address like ? and `status` = 0;


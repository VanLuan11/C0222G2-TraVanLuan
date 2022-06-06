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

create table if not exists user(
user_name varchar(255),
password varchar(255),
`status` bit(1) default 0,
primary key(user_name)
);

create table if not exists user_role(
role_id int auto_increment,
user_name varchar(255),
`status` bit(1) default 0,
foreign key(role_id) references role(role_id),
foreign key(user_name) references user(user_name)
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
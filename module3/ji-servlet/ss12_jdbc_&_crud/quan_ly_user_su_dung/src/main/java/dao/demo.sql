drop database if exists demo;
CREATE DATABASE if not exists demo;
USE demo;

create table if not exists users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into users(name, email, country) values('tai','kante@che.uk','Viet Nam');
insert into users(name, email, country) values('phuong','kante@che.uk','My');
insert into users(name, email, country) values('hoan','kante@che.uk','Viet Nam');
insert into users(name, email, country) values('hau','kante@che.uk','Kenia');
insert into users(name, email, country) values('diep','kante@che.uk','Viet Nam');
insert into users(name, email, country) values('tri','kante@che.uk','My');
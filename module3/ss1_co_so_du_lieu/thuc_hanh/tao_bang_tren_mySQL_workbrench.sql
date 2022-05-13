create database if not exists `student-managemnet`;
use `student-managemnet`;
create table if not exists `stundent`(
`id` int,
`name` varchar(45),
`age` int,
`country` varchar(45),
primary key(`id`)
);
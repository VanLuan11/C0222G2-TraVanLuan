drop database if exists van_dung;
create database if not exists van_dung;
use van_dung;

create table product(
id int auto_increment,
product_code int not null,
product_name varchar(255),
product_price double,
product_amount int,
product_description text,
product_status bit(1) default 0,
primary key(id)
);
INSERT INTO `van_dung`.`product` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`) 
VALUES ( '1', 'Tam', '100', '1', 'asdf'),
( '2', 'Hoa', '200', '2', 'asdf'),
( '3', 'Phuong', '300', '3', 'asdf'),
( '4', 'Tai', '400', '4', 'asdf'),
( '5', 'Tri', '500', '5', 'asdf'),
( '6', 'Diep', '600', '6', 'asdf'),
( '7', 'Hung', '700', '7', 'asdf');

explain select * from product
where product_code = 23;

CREATE UNIQUE INDEX uniue_index
ON `van_dung`.`product` (`product_code`);

CREATE INDEX composite_index
ON `van_dung`.`product` (`product_name`, `product_price`);

explain select * from product
where product_code = 23;

create view v_product as
select product_name, product_code, product_price, product_status from product;

SET SQL_SAFE_UPDATES = 0;
update v_product
set product_name = 'Ghe'
where product_code = 86;
SET SQL_SAFE_UPDATES = 1;

drop view if exists v_product;

delimiter //
create procedure get_all_product()
  begin
    select * from product
    where product_status = 0;
  end //
delimiter ;

call get_all_product();

delimiter //
create procedure add_new_product(`p_code` int, `p_name` varchar(255), `p_price` double, `p_amount` int, `p_description` text)
  begin
    INSERT INTO `van_dung`.`product` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`)
    VALUES (`p_code`, `p_name`, `p_price`, `p_amount`, `p_description`);
  end //
delimiter ;

call add_new_product( '8', 'Doi', '800', '8', 'hello');

delimiter //
create procedure edit_product_by_id(p_id int, p_name varchar(255))
  begin
    update product
    set product_name = p_name
    where id = p_id;
  end //
delimiter ;

call edit_product_by_id(2,"luan");

delimiter //
create procedure delete_product_by_id(p_id int)
  begin
    update product
    set product_status = 1
    where id = p_id;
  end //
delimiter ;

call delete_product_by_id(5);
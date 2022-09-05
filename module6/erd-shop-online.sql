use shop_online;
-- App Role
INSERT INTO app_role (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO app_role (role_name) VALUES ('ROLE_USER');
-- App User
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'manager', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'admin', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'travanluan', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'levantai', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'tranducphuong', '2022-09-04');
-- admin account
INSERT INTO user_role (role_id, user_id) VALUES ('1', '1');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '1');
INSERT INTO user_role (role_id, user_id) VALUES ('1', '2');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '2');
-- user account
INSERT INTO user_role (role_id, user_id) VALUES ('2', '3');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '4');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '5');
-- category
INSERT INTO `category` ( `name_category`) VALUES ('Laptop gaming');
INSERT INTO `category` (`name_category`) VALUES ('Laptop văn phòng ');
INSERT INTO `category` (`name_category`) VALUES ('Bàn Phím');
INSERT INTO `category` (`name_category`) VALUES ('Chuột');
INSERT INTO `category` (`name_category`) VALUES ('Phụ kiện');
-- product
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('AMD R5 5500U', 'Màu: Đen', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2021/08/R4XX-2-600x600.jpg', 0, 'Laptop Acer Aspire 7 A715 42G R4XX', 15450000, '8G', '15.6 inch FHD', '256GB SSD', 'NVIDIA GTX1650 4G', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('Intel® Core™ i5-1155G7 (tối đa 4.50 GHz, 8MB)', 'Tính năng: Đèn nền bàn phím', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/07/2VN-600x600.jpg', 0, 'Laptop MSI Modern 15 A11MU 1022VN', 15490000, '8GB(8GBx1)DDR4 3200MHz (2 Khe, tối đa 64GB)', '15.6 inch FHD (1920*1080), 60Hz 45%NTSC IPS-Leve', ' 512GB NVMe PCIe Gen3x4 SSD', ' Intel® Iris® Xe Graphics', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('Ryzen 5 5600H', 'Màu: Đen', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/03/BBVN-600x600.png', 0, 'Laptop Lenovo IdeaPad Gaming 3 15ACH6 (82K201BBVN)', 15950000, '8GB DDR4 3200MHz', '15.6Inch FHD', '512GB M.2 NVMe', 'NVIDIA GeForce GTX1650 4G', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('RYZEN 4600H', 'Bàn phím:  Backlit Chiclet Led RG', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/02/hn019w-1-300x300.jpg', 0, 'Laptop Asus Gaming TUF FA506IHR-HN019W', 16450000, '8GB DDR4 3200MHz (2 x SO-DIMM slots, up to 32GB)', '15.6inch FHD IPS 144Hz Anti glare, Adaptive-Sync, 250nits', '512GB M.2 NVMe™ PCIe® 3.0', ' NVIDIA GeForce GTX 1650 4GB GDDR6', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('Intel Core i5-11400H', 'Trọng lượng: 1.86 kg', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/03/664vn.jpg-600x600.png', 0, 'Laptop MSI GF63 Thin 11SC 664VN', 16450000, '8GB DDR4 3200MHz', '15.6 inch FHD IPS 144Hz', '512GB NVMe M.2 PCIe Gen 3 x 4', 'GTX1650 Max-Q 4GB GDDR6', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('AMD Ryzen R5-5500U (8MB, up to 4.00GHz)', 'Trọng lượng: 2.1 kg', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2021/11/R05G-2-300x300.jpg', 0, 'Acer Aspire 7 A715-42G-R05G', 16490000, '8G', '15.6\" IPS 144Hz', '512GB PCIe NVMe', 'GTX 1650 4G', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('Intel® Core™ I5-11300H (2.70 GHz upto 3.10 GHz, 12 MB)', 'Bàn phím: RGB K', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/07/78VN-300x300.jpg', 0, 'Laptop Lenovo Ideapad Gaming 3 15IHU6 (82K10178VN)', 16750000, '8GB(1x 8GB) SO-DIMM DDR4-3200Mhz (2 khe, tối đa 16GB)', '15.6 inch FHD (1920x1080) IPS 250nits Anti-glare, 120Hz, 45% NTSC, DC dimmer', '512GB SSD M.2 2242 PCIe 3.0x4 NVMe', 'NVIDIA GeForce GTX 1650 4GB GDDR6', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('AMD R5 5500U  (6 nhân/ 12 luồng,tối đa 4.10 GHz, 8MB)', 'Màu: Carbon Gray', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/09/234vn-300x300.png', 0, 'Laptop MSI Modern 15 A5M 236VN', 16990000, '8GB(8GBx1)DDR4 3200MHz (2 Khe, tối đa 64GB)', '15.6 inch FHD (1920*1080), 60Hz 45%NTSC IPS-Leve', '512GB NVMe PCIe Gen3x4 SSD', 'Intel® Iris® Xe Graphics', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('Intel® Core™ i5-1155G7 (2.50GHz upto 4.50 GHz, 8MB)', 'Trọng lượng: 990g', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/06/3s0-300x300.jpg', 0, 'Laptop GIGABYTE U4 UD-50S1823SO', 17150000, '16GB(8GBx2)DDR4 3200Mhz ( 2 khe)', '14.0 inch Thin Bezel FHD (1920x1080) IPS-level Anti-glare Display LCD', '512GB M.2 NVMe PCIe', 'Intel® Iris® Xe graphics', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('INTEL CORE I5 10300H', 'Bàn phím: Backlit Chiclet Led RG', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/02/TUF-FX506LH-HN188W-300x300.png', 0, 'Laptop Asus Gaming TUF FX506LH-HN188W', 17690000, '8GB DDR4 3200MHz (2 x SO-DIMM slots, up to 32GB)', '15.6inch FHD IPS 144Hz Anti glare, Adaptive-Sync, 250nits', '512GB M.2 NVMe™ PCIe® 3.0', ' NVIDIA GeForce GTX 1650 4GB GDDR6 + AMD Radeon™ Graphics', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('AMD Ryzen 7-5800H 3.20GHz upto 4.40GHz, 8 cores 16 threads', 'Trọng lượng : 2.35 kg', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/01/138-300x300.jpg', 0, 'LAPTOP GAMING MSI BRAVO 15 B5DD 275VN', 17890000, 'DDR4 8GB (1 x 8GB) 3200MHz; 2 slots, Up to 64G', '15.6 inch FHD (1920*1080), 60Hz 45%NTSC IPS-Level', '512GB NVMe PCIe Gen3x4 SSD', 'Radeon RX5500M 4G', 1);
INSERT INTO `shop_online`.`product` (`cpu`, `description`, `hdh`, `image`, `is_deleted`, `name_product`, `price`, `ram`, `screen`, `ssd`, `vga`, `category_id`) VALUES ('AMD Ryzen R7-5700U (1.80GHz Up to 4.30 GHz, 8 Cores, 16 Threads, 8M', 'Tính năng: Đèn nền bàn phím', 'Windows 11 Home', 'https://sp-one.vn/Content/uploads/2022/09/237vn-300x300.png', 0, 'Laptop MSI Modern 15 A5M 237VN', 17980000, '8GB(8GBx1)DDR4 3200MHz (2 Khe, tối đa 64GB)', '15.6 inch FHD (1920*1080), 60Hz 45%NTSC IPS-Leve', '512GB NVMe PCIe Gen3x4 SSD', ' Intel® Iris® Xe Graphics', 1);
 

-- 8:33
create database shop_online;
use shop_online;
CREATE TABLE `app_role` (
  `id` int auto_increment primary key,
  `is_deleted` bit(1) default 0,
  `role_name` varchar(255) not null
);
CREATE TABLE `app_user` (
  `id` int auto_increment primary key,
  `creation_date` date default null,
  `is_deleted` bit(1) default 0,
  `password` varchar(255) not null,
  `user_name` varchar(255) not null
);
CREATE TABLE `user_role` (
  `id` int auto_increment primary key,
  `is_deleted` bit(1) default 0,
  `role_id` int default null,
  `user_id` int default null,
  foreign key (`user_id`) references `app_user` (`id`),
  foreign key (`role_id`) references `app_role` (`id`)
);
create table customer (
id int auto_increment primary key,
name varchar(255),
email varchar(255),
`is_deleted` bit(1) default 0,
`user_id` int default null,
foreign key (`user_id`) references `app_user` (`id`)
);
create table category (
id int auto_increment primary key,
name varchar(255)
);
create table product (
id int auto_increment primary key,
name varchar(255),
image varchar(255),
description text,
price double,
`is_deleted` bit(1) default 0,
`category_id` int default null,
foreign key (`category_id`) references `category` (`id`)
);
create table feedback (
id int auto_increment primary key,
content text,
feedback_date date,
rating int NOT NULL,
`is_deleted` bit(1) default 0,
`customer_id` int default null,
foreign key (`customer_id`) references `customer` (`id`)
);

create table `order` (
id int auto_increment primary key,
creation_date date,
quantity int,
`is_deleted` bit(1) default 0,
`product_id` int default null,
`customer_id` int default null,
foreign key (`product_id`) references `product` (`id`),
foreign key (`customer_id`) references `customer` (`id`)
);
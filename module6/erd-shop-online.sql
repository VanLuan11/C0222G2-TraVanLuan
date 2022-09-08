drop database if exists shop_online;
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
name_category varchar(255)
);
create table product (
id int auto_increment primary key,
name_product varchar(255),
image varchar(255),
cpu varchar(255),
hdh varchar(255),
ram varchar(255),
screen varchar(255),
ssd varchar(255),
vga varchar(255),
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

create table `order_service` (
id int auto_increment primary key,
creation_date date,
quantity int,
`is_deleted` bit(1) default 0,
`product_id` int default null,
`customer_id` int default null,
foreign key (`product_id`) references `product` (`id`),
foreign key (`customer_id`) references `customer` (`id`)
);

-- App Role
INSERT INTO app_role (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO app_role (role_name) VALUES ('ROLE_USER');
-- App User
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$LWC6G/uWcvQplFvnSfKYruMLKeMJ.QvX34xL4fhKQhsmBeOS0nAEW', 'manager', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$LWC6G/uWcvQplFvnSfKYruMLKeMJ.QvX34xL4fhKQhsmBeOS0nAEW', 'admin', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$LWC6G/uWcvQplFvnSfKYruMLKeMJ.QvX34xL4fhKQhsmBeOS0nAEW', 'travanluan', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$LWC6G/uWcvQplFvnSfKYruMLKeMJ.QvX34xL4fhKQhsmBeOS0nAEW', 'levantai', '2022-09-04');
INSERT INTO app_user (`password`, user_name, creation_date)
VALUES ('$2a$10$LWC6G/uWcvQplFvnSfKYruMLKeMJ.QvX34xL4fhKQhsmBeOS0nAEW', 'tranducphuong', '2022-09-04');
-- admin account
INSERT INTO user_role (role_id, user_id) VALUES ('1', '1');
INSERT INTO user_role (role_id, user_id) VALUES (2, '1');
INSERT INTO user_role (role_id, user_id) VALUES ('1', 2);
INSERT INTO user_role (role_id, user_id) VALUES (2, 2);
-- user account
INSERT INTO user_role (role_id, user_id) VALUES (2, '3');
INSERT INTO user_role (role_id, user_id) VALUES (2, '4');
INSERT INTO user_role (role_id, user_id) VALUES (2, '5');
-- category
INSERT INTO `category` (id,`name_category`) VALUES (1,'Laptop gaming');
INSERT INTO `category` (id,`name_category`) VALUES (2,'Laptop văn phòng ');

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
INSERT INTO `shop_online`.`product` (`name_product`, `image`, `cpu`, `hdh`, `ram`, `screen`, `ssd`, `vga`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('LENOVO V15 IGL 82C30080VN', 'https://sp-one.vn/Content/uploads/2022/07/20.1-600x600.jpg', 'Intel® Pentium® Silver N5030 (1.10GHz up to 3.10GHz, 4MB Cache)', 'Windows 11 Home', '4GB Soldered DDR4-2400Mhz', '15.6 inch HD (1366x768) TN 220nits Anti-glare', '256GB M.2 2242 PCIe 3.0x2 NVMe SSD', 'Intel UHD Graphics', 'Trọng Lượng: 1.85 kg', '8880000', 0, 2);
INSERT INTO `shop_online`.`product` (`name_product`, `image`, `cpu`, `hdh`, `ram`, `screen`, `ssd`, `vga`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('Laptop Lenovo V14 G2 ITL 82KA00RXVN', 'https://sp-one.vn/Content/uploads/2022/09/1223-600x600.png', 'Intel Core i3-1115G4 (6MB Cache, upto 4.10GHz)', 'Windows 11 Home', '8GB DDR4-3200Mhz Onboard', '14.0Inch FHD TN 250nits Anti-glare, 45% NTSC', '512GB M.2 2242 PCIe 3.0x4 NVMe', 'Integrated Intel UHD Graphics', 'Trọng Lượng: 1.65 kg', '10500000', 0, 2);
INSERT INTO `shop_online`.`product` (`name_product`, `image`, `cpu`, `hdh`, `ram`, `screen`, `ssd`, `vga`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('Lenovo V14 G2 ITL (82KA00RTVN)', 'https://sp-one.vn/Content/uploads/2022/07/tvn-600x600.jpg', 'Intel Core i3-1115G4 3.0Ghz up to 4.1Ghz, 6M', 'Windows 11 Home', '4GB DDR4 3200Mhz Onboard, 1 khe cắm Ram rời, hỗ trợ tối đa 12G', '14\" FHD (1920x1080) TN 250nits Anti-glare, 45% NTSC', '512GB SSD PCIe NVMe', 'Intel UHD Graphics', 'Trọng Lượng: 1.60 kg', '10589000', 0, 2);
INSERT INTO `shop_online`.`product` (`name_product`, `image`, `cpu`, `hdh`, `ram`, `screen`, `ssd`, `vga`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('Laptop Lenovo V15 G2 ITL 82KB00QRVN', 'https://sp-one.vn/Content/uploads/2022/07/20.2-600x600.jpg', 'I3-1115G4', 'Windows 11 Home', '4GB DDR4', '15.6″ FHD', '256GB NVMe', 'Intel UHD Graphics', 'Trọng lượng: 1.7 kg', '11280000', 0, 2);
INSERT INTO `shop_online`.`product` (`name_product`, `image`, `cpu`, `hdh`, `ram`, `screen`, `ssd`, `vga`, `description`, `price`, `is_deleted`, `category_id`) VALUES ('Laptop Acer Aspire 3 A315 58 35AG', 'https://sp-one.vn/Content/uploads/2022/04/LLLLLLL-600x600.jpg', 'Intel Core i3-1115G4', 'Windows 11 Home', '4GB DDR4 2666MHz Onboard', '15.6\" FHD (1920 x 1080) Acer ComfyView LCD, Anti-Glare', '256GB SSD M.2 PCIE, 1x slot SATA3 2.5\"', 'Intel UHD Graphics', 'Trọng Lượng: 1,38 kg,Màu sắc: Bạc', '11490000', 0, 2);


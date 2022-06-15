drop database if exists exam_module3;
create database if not exists  exam_module3;
use exam_module3;

create table if not exists benh_nhan (
ma_benh_nhan varchar(255),
ten_benh_nhan varchar(255),
`status` bit(1) default 0,
primary key(ma_benh_nhan)
);


create table if not exists benh_an(
ma_benh_an varchar(255),
ma_benh_nhan varchar(255),
ngay_nhap_vien date,
ngay_xuat_vien date,
ly_do varchar(255),
`status` bit(1) default 0,
foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan),
primary key(ma_benh_an)
);

insert into benh_nhan(ma_benh_nhan,ten_benh_nhan)
value ('BN-001','Lệ Thị Tài'),
('BN-002','Lệ Thị Hoàn'),
('BN-003','Lệ Thị Trí'),
('BN-004','Lệ Thị Phúc'),
('BN-005','Lệ Thị Phương');

insert into benh_an(ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_xuat_vien,ly_do) 
value ('BA-001','BN-001','2021-3-4','2021-3-9','Bị đánh do quá láo'),
 ('BA-002','BN-004','2021-1-4','2021-2-3','Vấp con kiến bị té gãy răng'),
 ('BA-003','BN-002','2022-3-4','2022-3-8','covid'),
 ('BA-004','BN-005','2020-4-4','2020-4-9','Sống bất cần '),
 ('BA-005','BN-003','2022-6-2','2022-6-11','Bị chó cắn');

select benh_an.ma_benh_an, benh_nhan.ma_benh_nhan, benh_an.ngay_nhap_vien, benh_an.ngay_xuat_vien, benh_an.ly_do from benh_an 
join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan where benh_an.`status` =0;

update benh_an set `status` = 0 where ma_benh_an = 'BA-004' ;

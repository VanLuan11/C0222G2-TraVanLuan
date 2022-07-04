drop database if exists exam_module3;
create database if not exists  exam_module3;
use exam_module3;

create table if not exists `trang_thai`(
id_trang_thai int auto_increment,
trang_thai varchar(255),
`status` bit(1) default 0,
primary key(id_trang_thai)
);

create table if not exists loai_mat_bang(
id_loai_mat_bang int auto_increment,
loai varchar(255),
`status` bit(1) default 0,
primary key(id_loai_mat_bang)
);

create table if not exists mat_bang(
ma_mat_bang varchar(255),
dien_tich double,
id_trang_thai int,
tang int,
id_loai_mat_bang int,
mo_ta_chi_tiet varchar(255),
gia_cho_thue double,
ngay_bat_dau varchar(255),
ngay_ket_thuc varchar(255),
`status` bit(1) default 0,
foreign key(id_trang_thai) references `trang_thai`(id_trang_thai),
foreign key(id_loai_mat_bang) references loai_mat_bang(id_loai_mat_bang),
primary key(ma_mat_bang)
);
 insert into `trang_thai` (trang_thai) 
 value('Trống'),('Hạ Tầng'),('Đầy đủ');
 
 insert into loai_mat_bang (loai)
 value('Văn phòng chia sẻ'),('Văn phòng trọ gói');
 
 insert into mat_bang(ma_mat_bang,dien_tich,id_trang_thai,tang,id_loai_mat_bang,mo_ta_chi_tiet,gia_cho_thue,ngay_bat_dau,ngay_ket_thuc) 
 value ('MB-00-01',34,1,2,1,'Sạch sẻ',1000,'2022-04-05','2022-12-05'),
 ('MB-00-02',44,2,1,1,'Sạch sẻ',2000,2021-01-05,2022-08-05),
 ('MB-00-03',56,2,3,2,'có hồ bơi',45000,2022-05-05,2022-12-05),
 ('MB-00-04',34,3,2,2,'có phòng tập',8000,2022-01-05,2022-07-03);

select *  from `trang_thai` where `status` = 0 ;
select *  from loai_mat_bang where `status` = 0 ;

select * from mat_bang where id_loai_mat_bang like ? or gia_cho_thue like ? or tang like ? and `status` = 0;

-- select benh_an.ma_benh_an, benh_nhan.ma_benh_nhan, benh_an.ngay_nhap_vien, benh_an.ngay_xuat_vien, benh_an.ly_do from benh_an 
-- join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan where benh_an.`status` =0;

-- select * from benh_an where ma_benh_an = ? ;

-- SET SQL_SAFE_UPDATES = 0;
-- update benh_an set benh_nhan.t
-- SET SQL_SAFE_UPDATES = 1;

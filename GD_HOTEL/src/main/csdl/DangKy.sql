DROP DATABASE IF EXISTS DangKy;
create database DangKy;
use DangKy;

create table SaveTT(
	sdt VarChar(10) primary key,
    mk varchar(20),
    userName varchar(50)
);

insert into SaveTT values('0922222222','0922222222','Trần Thu Hương');
insert into SaveTT values('0911111111','0911111111','Lý Hải Đăng');
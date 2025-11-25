-- ================================
--  CREATE TABLES FOR HOTEL SYSTEM
-- ================================

DROP DATABASE IF EXISTS HOTEL;
CREATE DATABASE HOTEL CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE HOTEL;

-- 1. Bảng KHACHHANG
CREATE TABLE KHACHHANG (
    MaKH        VARCHAR(10) PRIMARY KEY,
    HoTen       VARCHAR(100) NOT NULL,
    SDT         VARCHAR(15),
    CCCD        VARCHAR(15) UNIQUE NOT NULL,
    Email 		VARCHAR(200),
    DiaChi      VARCHAR(100),
    GioiTinh    VARCHAR(5)
);

-- 2. DATPHONG
CREATE TABLE DATPHONG (
    MaKH        VARCHAR(10) PRIMARY KEY,
    LoaiPhong   VARCHAR(20)
);



-- 1. KHACHHANG
INSERT INTO KHACHHANG VALUES 
('KH001', 'Nguyễn Văn A', '0686868686', '0909123456','nguyenvana@gmail.com', 'Hà Nội','Nam'),
('KH002', 'Trần Thị B', '0123456789', '0911222333','tranthib@gmail.com', 'Đà Nẵng', 'Nữ');
('KH003', 'Lý Thị C', '0989898989', '0911222433','lythic@gmail.com', 'TP HCM', 'Nữ');

-- 2. DATPHONG
INSERT INTO DATPHONG VALUES 
('KH001', 'Vip'),
('KH002', 'Thường');


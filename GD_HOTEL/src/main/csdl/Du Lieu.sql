USE BOOK_HOTEL;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE ChiTietHoaDon;
TRUNCATE TABLE HoaDon;
TRUNCATE TABLE SD_DichVu;
TRUNCATE TABLE NguoiDiCung;
TRUNCATE TABLE ChiTietDatPhong;
TRUNCATE TABLE DatPhong;
TRUNCATE TABLE Phong;
TRUNCATE TABLE DichVu;
TRUNCATE TABLE LoaiPhong;
TRUNCATE TABLE NhanVien;
TRUNCATE TABLE KhachHang;

SET FOREIGN_KEY_CHECKS = 1;


-- =============================================
-- 1. LOẠI PHÒNG
-- =============================================
INSERT INTO LoaiPhong (MaLP, TenLP, GiaLP, SucChua, MoTa) VALUES
('LP01', 'Standard Single', 400000, 1, 'Phòng đơn tiêu chuẩn'),
('LP02', 'Standard Double', 600000, 2, 'Phòng đôi tiêu chuẩn'),
('LP03', 'Deluxe City View', 900000, 2, 'Phòng cao cấp hướng phố'),
('LP04', 'Deluxe Ocean View', 1200000, 2, 'Phòng cao cấp hướng biển'),
('LP05', 'Family Suite', 2000000, 4, 'Căn hộ gia đình 2 phòng ngủ'),
('LP06', 'Executive Suite', 3500000, 2, 'Phòng hạng sang cho doanh nhân'),
('LP07', 'Presidential', 15000000, 4, 'Phòng Tổng thống sang trọng nhất'); 

-- =============================================
-- 2. DỊCH VỤ
-- =============================================
INSERT INTO DichVu (MaDV, TenDV, GiaDV, MoTa) VALUES
('DV01', 'Giặt ủi thường', 30000, 'Tính theo kg'),
('DV02', 'Giặt hấp cao cấp', 100000, 'Tính theo bộ'),
('DV03', 'Ăn sáng Buffet', 150000, 'Vé người lớn'),
('DV04', 'Ăn sáng trẻ em', 80000, 'Vé trẻ em dưới 1.2m'),
('DV05', 'Thuê xe máy tay ga', 150000, 'Tính theo ngày'),
('DV06', 'Đón tiễn sân bay', 300000, 'Xe 4 chỗ/lượt'),
('DV07', 'Massage Body', 450000, 'Vé 60 phút'),
('DV08', 'Sauna & Steam', 200000, 'Vé xông hơi'),
('DV09', 'MiniBar - Bia', 40000, 'Lon 330ml'),
('DV10', 'MiniBar - Nước suối', 20000, 'Chai 500ml');

-- =============================================
-- 3. NHÂN VIÊN (2)
-- =============================================
INSERT INTO NhanVien (MaNV, Ho, TenLot, Ten, ChucVu, SDT) VALUES
('NV01', 'Nguyễn', 'Thị', 'Mai', 'Lễ tân trưởng', '0901111222'),
('NV02', 'Trần', 'Văn', 'Hùng', 'Bảo vệ', '0902222333'),
('NV03', 'Lê', 'Thị', 'Thu', 'Buồng phòng', '0903333444'),
('NV04', 'Phạm', 'Minh', 'Tuấn', 'Quản lý', '0904444555'),
('NV05', 'Hoàng', 'Ngọc', 'Hà', 'Kế toán', '0905555666'),
('NV06', 'Đỗ', 'Văn', 'Nam', 'Bellman', '0906666777'),
('NV07', 'Vũ', 'Thị', 'Yến', 'Lễ tân', '0907777888'),
('NV08', 'Bùi', 'Quang', 'Huy', 'IT Support', '0908888999'),
('NV09', 'Đặng', 'Thị', 'Hoa', 'Buồng phòng', '0909999000'),
('NV10', 'Ngô', 'Văn', 'Quyền', 'Bếp trưởng', '0910000111');

-- =============================================
-- 4. KHÁCH HÀNG (1)
-- =============================================
INSERT INTO KhachHang (MaKH, Ho, TenLot, Ten, CCCD, SDT, NamSinh, DiaChi, GioiTinh) VALUES
('KH01', 'Lý', 'Hải', 'Đăng', '001090000001', '0911111111', 1990, 'Quận 1, TPHCM', 'Nam'),
('KH02', 'Trần', 'Thu', 'Hương', '001090000002', '0922222222', 1995, 'Cầu Giấy, Hà Nội', 'Nữ'),
('KH03', 'John', NULL, 'Smith', 'P12345678', '0933333333', 1985, 'USA', 'Nam'),
('KH04', 'Nguyễn', 'Bá', 'Thắng', '001090000004', '0944444444', 1980, 'Đà Nẵng', 'Nam'),
('KH05', 'Phạm', 'Thanh', 'Thảo', '001090000005', '0955555555', 1998, 'Cần Thơ', 'Nữ'),
('KH06', 'Lê', 'Văn', 'Sơn', '001090000006', '0966666666', 1992, 'Hải Phòng', 'Nam'),
('KH07', 'Hoàng', 'Thị', 'Lan', '001090000007', '0977777777', 1988, 'Nha Trang', 'Nữ'),
('KH08', 'Vũ', 'Trọng', 'Phụng', '001090000008', '0988888888', 2000, 'Huế', 'Nam'),
('KH09', 'Đặng', 'Thu', 'Thủy', '001090000009', '0999999999', 1993, 'Đà Lạt', 'Nữ'),
('KH10', 'Yamada', NULL, 'Taro', 'JP87654321', '0910101010', 1982, 'Japan', 'Nam'),
('KH11', 'Trương', 'Vô', 'Kỵ', '001090000011', '0912121212', 1996, 'Bình Dương', 'Nam'),
('KH12', 'Triệu', NULL, 'Mẫn', '001090000012', '0913131313', 1997, 'Đồng Nai', 'Nữ');

-- =============================================
-- 5. PHÒNG 
-- =============================================
INSERT INTO Phong (MaPhong, SoPhong, Tang, TrangThai, MaLP, MaNVQL) VALUES
('P101', '101', 1, 'Trống', 'LP01', 'NV03'),
('P102', '102', 1, 'Đang ở', 'LP01', 'NV03'),
('P103', '103', 1, 'Trống', 'LP02', 'NV03'),
('P201', '201', 2, 'Đang dọn dẹp', 'LP02', 'NV09'),
('P202', '202', 2, 'Đang ở', 'LP03', 'NV09'),
('P203', '203', 2, 'Đang ở', 'LP03', 'NV09'),
('P301', '301', 3, 'Trống', 'LP04', 'NV03'),
('P302', '302', 3, 'Đang sửa', 'LP04', 'NV03'),
('P401', '401', 4, 'Đang ở', 'LP05', 'NV09'),
('P402', '402', 4, 'Trống', 'LP05', 'NV09'),
('P501', '501', 5, 'Đang ở', 'LP06', 'NV03'),
('P601', '601', 6, 'Trống', 'LP07', 'NV09'),
('P104', '104', 1, 'Trống', 'LP01', 'NV03'),
('P105', '105', 1, 'Trống', 'LP02', 'NV03'),
('P204', '204', 2, 'Đang ở', 'LP03', 'NV09');

-- =============================================
-- 6. ĐẶT PHÒNG (3)
-- =============================================
INSERT INTO DatPhong (MaDP, MaKH, MaNV, NgayDat, NgayNhan, NgayTra, TrangThai) VALUES
('DP01', 'KH01', 'NV01', '2025-10-01', '2025-10-05', '2025-10-07', 'Đã trả phòng'),
('DP02', 'KH02', 'NV07', '2025-10-02', '2025-10-10', '2025-10-15', 'Đã trả phòng'),
('DP03', 'KH03', 'NV01', '2025-11-01', '2025-11-20', '2025-11-22', 'Đã trả phòng'),
('DP04', 'KH04', 'NV07', '2025-11-15', '2025-11-21', '2025-11-25', 'Đang ở'),
('DP05', 'KH05', 'NV01', '2025-11-16', '2025-11-21', '2025-11-24', 'Đang ở'),
('DP06', 'KH06', 'NV07', '2025-11-18', '2025-11-21', '2025-11-23', 'Đang ở'),
('DP07', 'KH11', 'NV01', '2025-11-19', '2025-11-21', '2025-11-26', 'Đang ở'),
('DP08', 'KH10', 'NV07', '2025-11-20', '2025-11-21', '2025-11-30', 'Đang ở'),
('DP09', 'KH07', 'NV01', '2025-11-21', '2025-12-01', '2025-12-05', 'Đã xác nhận'),
('DP10', 'KH08', 'NV07', '2025-11-21', '2025-12-10', '2025-12-12', 'Đã xác nhận');

-- =============================================
-- 7. CHI TIẾT ĐẶT PHÒNG (3)
-- =============================================
INSERT INTO ChiTietDatPhong (MaDP, MaP, GiaDP) VALUES
('DP01', 'P101', 400000),
('DP02', 'P401', 2000000),
('DP03', 'P102', 400000),
('DP04', 'P102', 400000),
('DP05', 'P202', 900000),
('DP06', 'P203', 900000),
('DP07', 'P401', 2000000),
('DP08', 'P501', 3500000),
('DP09', 'P101', 400000),
('DP10', 'P301', 1200000);

-- =============================================
-- 8. NGƯỜI ĐI CÙNG
-- =============================================
INSERT INTO NguoiDiCung (MaNDD, CCCD, HoTen, GioiTinh, NamSinh, MoiQuanHe, MaDP) VALUES
('ND01', '001090999999', 'Nguyễn Văn Con', 'Nam', 2015, 'Con', 'DP02'),
('ND02', '001090888888', 'Trần Thị Mẹ', 'Nữ', 1960, 'Mẹ', 'DP02'),
('ND03', NULL, 'Baby Shark', 'Nam', 2022, 'Con', 'DP02'),
('ND04', '001090777777', 'Lê Thị Vợ', 'Nữ', 1993, 'Vợ', 'DP06'),
('ND05', '001090000012', 'Triệu Mẫn', 'Nữ', 1997, 'Vợ', 'DP07'),
('ND06', NULL, 'Trương Vô Hối', 'Nam', 2020, 'Con', 'DP07'),
('ND07', 'JP12345678', 'Yamada Hanako', 'Nữ', 1985, 'Vợ', 'DP08'),
('ND08', '001090111222', 'Bạn Gái', 'Nữ', 1998, 'Bạn', 'DP05'),
('ND09', '001090333444', 'Đồng Nghiệp A', 'Nam', 1990, 'Đồng nghiệp', 'DP09'),
('ND10', '001090555666', 'Đồng Nghiệp B', 'Nữ', 1992, 'Đồng nghiệp', 'DP09');

-- =============================================
-- 9. SỬ DỤNG DỊCH VỤ
-- =============================================
INSERT INTO SD_DichVu (MaDP, MaDV, NgaySD, SoLuong) VALUES
('DP01', 'DV01', '2025-10-06', 2),
('DP01', 'DV10', '2025-10-05', 1),
('DP02', 'DV06', '2025-10-02', 1),
('DP02', 'DV03', '2025-10-11', 3),
('DP02', 'DV03', '2025-10-12', 3),
('DP02', 'DV06', '2025-10-15', 1),
('DP03', 'DV09', '2025-11-21', 2),
('DP04', 'DV05', '2025-11-22', 1),
('DP07', 'DV07', '2025-11-22', 2),
('DP07', 'DV08', '2025-11-22', 2),
('DP08', 'DV06', '2025-11-20', 1),
('DP08', 'DV03', '2025-11-21', 2),
('DP08', 'DV01', '2025-11-22', 5),
('DP05', 'DV10', '2025-11-21', 1),
('DP06', 'DV09', '2025-11-21', 4);

-- =============================================
-- 10. HÓA ĐƠN
-- =============================================
INSERT INTO HoaDon (MaHD, NgayLap, MaNV, MaDP) VALUES
('HD01', '2025-10-07', 'NV01', 'DP01'),
('HD02', '2025-10-15', 'NV07', 'DP02'),
('HD03', '2025-11-22', 'NV01', 'DP03');

-- =============================================
-- 11. BẢNG CHI TIẾT HÓA ĐƠN (Nhập liệu dựa trên tính toán thực tế)
-- =============================================

-- >>> Chi tiết cho HD01 (DP01): 2 đêm (400k) + Giặt 2kg (30k) + 1 Nước (20k)
INSERT INTO ChiTietHoaDon (MaHD, SoThuTu, NoiDung, SoLuong, DonGia) VALUES
('HD01', 1, 'Tiền phòng P101 (2 đêm)', 2, 400000),
('HD01', 2, 'Dịch vụ Giặt ủi thường', 2, 30000),
('HD01', 3, 'MiniBar - Nước suối', 1, 20000);


-- >>> Chi tiết cho HD02 (DP02): 5 đêm (2tr) + 2 lượt xe (300k) + 6 vé ăn sáng (150k)
INSERT INTO ChiTietHoaDon (MaHD, SoThuTu, NoiDung, SoLuong, DonGia) VALUES
('HD02', 1, 'Tiền phòng P401 (5 đêm)', 5, 2000000),
('HD02', 2, 'Đón tiễn sân bay', 2, 300000),
('HD02', 3, 'Ăn sáng Buffet', 6, 150000);

-- >>> Chi tiết cho HD03 (DP03): 2 đêm (400k) + 2 bia (40k)
INSERT INTO ChiTietHoaDon (MaHD, SoThuTu, NoiDung, SoLuong, DonGia) VALUES
('HD03', 1, 'Tiền phòng P102 (2 đêm)', 2, 400000),
('HD03', 2, 'MiniBar - Bia', 2, 40000);


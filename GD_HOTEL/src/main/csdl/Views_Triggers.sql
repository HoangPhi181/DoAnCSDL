USE BOOK_HOTEL;

-- ============================================
-- 1. VIEW: Lịch phòng tổng hợp
-- ============================================
DROP VIEW IF EXISTS vw_LichPhong;

CREATE VIEW vw_LichPhong AS
SELECT 
    p.MaPhong,
    p.SoPhong,
    p.Tang,
    p.TrangThai AS TrangThaiPhong,
    lp.TenLP AS TenLoaiPhong,
    lp.GiaLP AS GiaCoBan,
    dp.MaDP,
    dp.NgayDat,
    dp.NgayNhan,
    dp.NgayTra,
    dp.TrangThai AS TrangThaiDat,
    kh.MaKH,
    CONCAT(kh.Ho, ' ', IFNULL(kh.TenLot, ''), ' ', kh.Ten) AS TenKhachHang
FROM Phong p
JOIN LoaiPhong lp ON p.MaLP = lp.MaLP
LEFT JOIN ChiTietDatPhong ctdp ON p.MaPhong = ctdp.MaP
LEFT JOIN DatPhong dp ON dp.MaDP = ctdp.MaDP
LEFT JOIN KhachHang kh ON kh.MaKH = dp.MaKH;



-- ============================================
-- 2. VIEW: Doanh thu theo tháng
-- ============================================
DROP VIEW IF EXISTS vw_DoanhThuThang;

CREATE VIEW vw_DoanhThuThang AS
SELECT 
    YEAR(hd.NgayLap) AS Nam,
    MONTH(hd.NgayLap) AS Thang,
    SUM(ct.SoLuong * ct.DonGia) AS TongDoanhThu
FROM HoaDon hd
JOIN ChiTietHoaDon ct ON hd.MaHD = ct.MaHD
GROUP BY YEAR(hd.NgayLap), MONTH(hd.NgayLap);



-- ============================================
-- 3. VIEW: Thống kê dịch vụ
-- ============================================
DROP VIEW IF EXISTS vw_ThongKeDichVu;

CREATE VIEW vw_ThongKeDichVu AS
SELECT 
    dv.MaDV,
    dv.TenDV,
    SUM(sd.SoLuong) AS TongSoLuong,
    SUM(sd.SoLuong * dv.GiaDV) AS TongDoanhThu
FROM DichVu dv
JOIN SD_DichVu sd ON dv.MaDV = sd.MaDV
GROUP BY dv.MaDV, dv.TenDV;



-- ============================================
-- 4. TRIGGER: Khi thêm ChiTietDatPhong → cập nhật phòng -> Đang ở
-- ============================================
DROP TRIGGER IF EXISTS trg_ChiTietDatPhong_Insert;

DELIMITER $$
CREATE TRIGGER trg_ChiTietDatPhong_Insert
AFTER INSERT ON ChiTietDatPhong
FOR EACH ROW
BEGIN
    UPDATE Phong
    SET TrangThai = 'Đang ở'
    WHERE MaPhong = NEW.MaP
      AND TrangThai = 'Trống';
END$$
DELIMITER ;



-- ============================================
-- 5. TRIGGER: Khi tạo hóa đơn → phòng trở về Trống
-- ============================================
DROP TRIGGER IF EXISTS trg_HoaDon_Insert;

DELIMITER $$
CREATE TRIGGER trg_HoaDon_Insert
AFTER INSERT ON HoaDon
FOR EACH ROW
BEGIN
    UPDATE Phong p
    JOIN ChiTietDatPhong ctdp ON p.MaPhong = ctdp.MaP
    SET p.TrangThai = 'Trống'
    WHERE ctdp.MaDP = NEW.MaDP;
END$$
DELIMITER ;

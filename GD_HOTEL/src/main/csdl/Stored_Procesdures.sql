USE BOOK_HOTEL;

-- ===========================================
-- 1. FUNCTION: Tính tổng tiền hóa đơn
-- ===========================================
DROP FUNCTION IF EXISTS fn_TinhTongTienHoaDon;

DELIMITER $$
CREATE FUNCTION fn_TinhTongTienHoaDon(
    MaHD VARCHAR(10)
)
RETURNS DECIMAL(18,2)
DETERMINISTIC
BEGIN
    DECLARE Tong DECIMAL(18,2);

    SELECT SUM(SoLuong * DonGia) INTO Tong
    FROM ChiTietHoaDon
    WHERE ChiTietHoaDon.MaHD = MaHD;

    RETURN IFNULL(Tong, 0);
END$$
DELIMITER ;



-- ===========================================
-- 2. PROC: Trả về tổng tiền hóa đơn
-- ===========================================
DROP PROCEDURE IF EXISTS sp_TinhTongTienHoaDon;

DELIMITER $$
CREATE PROCEDURE sp_TinhTongTienHoaDon(
    IN MaHD VARCHAR(10)
)
BEGIN
    SELECT 
        MaHD AS MaHD,
        fn_TinhTongTienHoaDon(MaHD) AS TongTien;
END$$
DELIMITER ;



-- ===========================================
-- 3. PROC: Kiểm tra phòng trống cho khoảng ngày
--    OUT KQ: 1 = đặt được, 0 = không đặt được
-- ===========================================
DROP PROCEDURE IF EXISTS sp_KiemTraPhongTrong;

DELIMITER $$
CREATE PROCEDURE sp_KiemTraPhongTrong(
    IN MaPhong VARCHAR(10),
    IN NgayNhanMoi DATETIME,
    IN NgayTraMoi DATETIME,
    OUT KetQua INT
)
BEGIN
    -- Mặc định = 1
    SET KetQua = 1;

    -- 1. Kiểm tra phòng có trạng thái Trống không
    IF NOT EXISTS (
        SELECT 1 FROM Phong 
        WHERE Phong.MaPhong = MaPhong
          AND TrangThai = 'Trống'
    ) THEN
        SET KetQua = 0;
        SELECT 'Phòng hiện không ở trạng thái Trống.' AS ThongBao;
        LEAVE proc_end;
    END IF;

    -- 2. Kiểm tra trùng ngày đặt
    IF EXISTS (
        SELECT 1
        FROM ChiTietDatPhong ctdp
        JOIN DatPhong dp ON dp.MaDP = ctdp.MaDP
        WHERE ctdp.MaP = MaPhong
          AND dp.TrangThai <> 'Đã hủy'
          AND NgayNhanMoi < dp.NgayTra
          AND NgayTraMoi  > dp.NgayNhan
    ) THEN
        SET KetQua = 0;
        SELECT 'Phòng đã có người đặt trùng khoảng thời gian này.' AS ThongBao;
        LEAVE proc_end;
    END IF;

    SELECT 'Phòng TRỐNG, có thể đặt.' AS ThongBao;

proc_end:
END$$
DELIMITER ;



-- ===========================================
-- 4. PROC: Hủy đặt phòng
-- ===========================================
DROP PROCEDURE IF EXISTS sp_HuyDatPhong;

DELIMITER $$
CREATE PROCEDURE sp_HuyDatPhong(
    IN MaDP VARCHAR(10)
)
BEGIN
    -- Kiểm tra mã DP tồn tại
    IF NOT EXISTS (SELECT 1 FROM DatPhong WHERE DatPhong.MaDP = MaDP) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Mã đặt phòng không tồn tại.';
    END IF;

    UPDATE DatPhong
    SET TrangThai = 'Đã hủy'
    WHERE DatPhong.MaDP = MaDP;

    SELECT 'Đã hủy đặt phòng thành công.' AS ThongBao;
END$$
DELIMITER ;

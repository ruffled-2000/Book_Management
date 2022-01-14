CREATE DATABASE QLBienSoan
GO
USE QLBienSoan
GO
-----------------------------------------------------------------------------------------------------------------------------
CREATE TABLE TAIKHOAN
(
	TenDangNhap varchar(20) primary key,
	MatKhau varchar(20) not null,
	TenNguoiDung nvarchar(30),
	loaiTaiKhoan int
)

CREATE TABLE DANHMUC
(
	MaDanhMuc int identity primary key,
	TenDanhMuc nvarchar(30),
)

CREATE TABLE NHAXUATBAN
(
	MaNXB int identity primary key,
	TenNXB nvarchar(30),
	DiaChi nvarchar(50),
	SoDT varchar(12),
)

CREATE TABLE SINHVIEN
(
	MaSV varchar(20) primary key,
	TenSV nvarchar(30),
	GioiTinh int,
	DiaChi nvarchar(50),
	Email varchar(40),
)

CREATE TABLE GIAOTRINH
(
	MaGT int identity primary key,
	TenGT nvarchar(50),
	TacGia nvarchar(30),
	MaNXB int,
	MaDanhMuc int,
	NamXB datetime,
	LanXB int,
	SoLuong int,
	GiaBan int,
	constraint FK_NXB foreign key(MaNXB) references NHAXUATBAN(MaNXB) on update cascade on delete cascade,
	constraint FK_DANHMUC foreign key(MaDanhMuc) references DANHMUC(MaDanhMuc) on update cascade on delete cascade
)

CREATE TABLE PHIEUMUON
(
	SoPhieuMuon int identity primary key,
	MaSV varchar(20),
	TinhTrang int default(0),
	constraint FK_SINHVIEN foreign key(MaSV) references SINHVIEN(MaSV) on update cascade on delete cascade
)

CREATE TABLE CHITIETPHIEUMUON
(
	SoPhieuMuon int,
	MaGT int,
	NgayMuon datetime,
	NgayTra datetime,
	constraint PK_CHITIETPHIEUMUON primary key(SoPhieuMuon, MaGT),
	constraint FK_PHIEUMUON foreign key(SoPhieuMuon) references PHIEUMUON(SoPhieuMuon) on update cascade on delete cascade,
	constraint FK_GIAOTRINH foreign key(MaGT) references GIAOTRINH(MaGT) on update cascade on delete cascade
)

CREATE TABLE HOADON
(
	SoHoaDon int identity primary key,
	MaSV varchar(20),
	constraint FK_SINHVIEN_HOADOn foreign key(MaSV) references SINHVIEN(MaSV) on update cascade on delete cascade
)

CREATE TABLE CHITIETHOADON
(
	SoHoaDon int,
	MaGT int,
	SoLuongBan int,
	NgayBan datetime,
	constraint FK_HOADON foreign key(SoHoaDon) references HOADON(SoHoaDon) on update cascade on delete cascade,
	constraint FK_GIAOTRINH_CHITIETHOADON foreign key(MaGT) references GIAOTRINH(MaGT) on update cascade on delete cascade
)
-----------------------------------------------------------------------------------------------------------------------------
INSERT INTO TAIKHOAN VALUES('admin', 'admin', N'Admin', 1)
INSERT INTO TAIKHOAN VALUES('levulong', '123456', N'Lê Vũ Long', 0)
INSERT INTO TAIKHOAN VALUES('lonhatlong', '123456', N'Lò Nhật Long', 0)

INSERT INTO DANHMUC VALUES(N'Công nghệ thông tin')
INSERT INTO DANHMUC VALUES(N'Điện tử')
INSERT INTO DANHMUC VALUES(N'Thương mại')

INSERT INTO NHAXUATBAN VALUES(N'Kim Đồng', N'Hà Nội', '0147852369')
INSERT INTO NHAXUATBAN VALUES(N'Giáo dục', N'Phú Thọ', '0123658974')
INSERT INTO NHAXUATBAN VALUES(N'Tuổi trẻ', N'Hải Phòng', '0951268743')

INSERT INTO SINHVIEN VALUES('2018601099', N'Lê Thanh Long', 0, N'Hà Nội', 'lethanhlong@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600904', N'Lê Vũ Long', 0, N'Phú Thọ', 'levulong@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600329', N'Lò Nhật Long', 0, N'Điện Biên', 'lonhatlong@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600626', N'Phùng Thanh Long', 0, N'Bắc Giang', 'phungthanhlong@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600596', N'Vũ Thế Long', 0, N'Hải Dương', 'vuthelong@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600157', N'Phạm Duy Hưng', 0, N'Hà Nội', 'phamduyhung@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600519', N'Đỗ Bá Hoàn', 0, N'Hà Nội', 'dobahoan@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600769', N'Quách Phương Thảo', 1, N'Hà Nội', 'quachphuongthao@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600855', N'Lê Thị Thanh Mỹ', 1, N'Thanh Hóa', 'lethithanhmy@gmail.com')
INSERT INTO SINHVIEN VALUES('2018600160', N'Phạm Hồng Phúc', 0, N'Thái Bình', 'phamhongphuc@gmail.com')

INSERT INTO GIAOTRINH VALUES(N'Giáo trình Java', N'Nguyễn Văn A', 2, 1, '05/15/2021', 1, 100, 50000)
INSERT INTO GIAOTRINH VALUES(N'Lập trình hướng đối tượng', N'Đỗ Văn B', 1, 1, '05/16/2021', 2, 150, 45000)
INSERT INTO GIAOTRINH VALUES(N'Lập trình Windows', N'Phạm Văn Hà', 2, 1, '05/17/2021', 1, 100, 40000)
INSERT INTO GIAOTRINH VALUES(N'Tiếng Anh Điện tử', N'Lê Thị C', 3, 2, '05/15/2021', 2, 60, 33000)
INSERT INTO GIAOTRINH VALUES(N'Điện tử hóa', N'Đào Văn D', 1, 2, '05/16/2021', 1, 160, 46000)
INSERT INTO GIAOTRINH VALUES(N'Kỹ thuật CAD', N'Đào Văn D', 2, 2, '05/17/2021', 1, 100, 30000)
INSERT INTO GIAOTRINH VALUES(N'Tiếng Anh Thương mại', N'Lê Thị Thanh D', 1, 3, '05/15/2021', 1, 200, 25000)
INSERT INTO GIAOTRINH VALUES(N'Kỹ năng giao tiếp', N'Lê Thị Thanh E', 2, 3, '05/16/2021', 1, 180, 35000)
INSERT INTO GIAOTRINH VALUES(N'Phong cách ứng xử', N'Lê Thị D', 3, 3, '05/17/2021', 2, 200, 30000)

SELECT * FROM TAIKHOAN
SELECT * FROM DANHMUC
SELECT * FROM NHAXUATBAN
SELECT * FROM SINHVIEN
SELECT * FROM GIAOTRINH
SELECT * FROM HOADON
SELECT * FROM PHIEUMUON
SELECT * FROM CHITIETHOADON
SELECT * FROM CHITIETPHIEUMUON
-----------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_MUAGT
on CHITIETHOADON
for INSERT
as
	BEGIN
		declare @SoLuong int
		declare @SoLuongBan int
		select @SoLuong = SoLuong from GIAOTRINH inner join inserted on GIAOTRINH.MaGT=inserted.MaGT
		select @SoLuongBan = inserted.SoLuongBan from inserted

		update GIAOTRINH set SoLuong=@SoLuong-@SoLuongBan
		from GIAOTRINH inner join inserted on GIAOTRINH.MaGT=inserted.MaGT
	END

CREATE TRIGGER TRG_UPDATEGT
on CHITIETHOADON
for UPDATE
as
	BEGIN
		declare @SoLuongTruoc int
		declare @SoLuongSau int
		select @SoLuongTruoc = deleted.SoLuongBan from deleted
		select @SoLuongSau = inserted.SoLuongBan from inserted

		update GIAOTRINH set SoLuong=SoLuong-(@SoLuongSau-@SoLuongTruoc)
		from GIAOTRINH inner join inserted on GIAOTRINH.MaGT=inserted.MaGT
					   inner join deleted on GIAOTRINH.MaGT=deleted.MaGT
	END

CREATE TRIGGER TRG_MUONGT
on CHITIETPHIEUMUON
for INSERT
as
	BEGIN
		declare @SoLuong int
		select @SoLuong = SoLuong from GIAOTRINH inner join inserted on GIAOTRINH.MaGT=inserted.MaGT
		update GIAOTRINH set SoLuong=@SoLuong-1
		from GIAOTRINH inner join inserted on GIAOTRINH.MaGT=inserted.MaGT
	END

CREATE TRIGGER TRG_XOAMUONGT
on CHITIETPHIEUMUON
for DELETE
as
	BEGIN
		declare @SoLuong int
		select @SoLuong = SoLuong from GIAOTRINH inner join deleted on GIAOTRINH.MaGT=deleted.MaGT
		update GIAOTRINH set SoLuong=@SoLuong+1
		from GIAOTRINH inner join inserted on GIAOTRINH.MaGT=inserted.MaGT
	END
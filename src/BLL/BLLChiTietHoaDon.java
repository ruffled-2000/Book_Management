/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LongTienSinh
 */
public class BLLChiTietHoaDon {
    DBConnect connect;
    
    public BLLChiTietHoaDon() {
        connect = new DBConnect();
    }
    
    public ResultSet ShowChiTietHoaDon() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM CHITIETHOADON");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public int insertChiTietHoaDon(int soHD, int maGT, int soLuongBan, String ngayBan){
        try {
            connect.getConnection();
            int reult = connect.executeUpdate("INSERT INTO CHITIETHOADON values("+soHD+", "+maGT+", "+soLuongBan+", '"+ngayBan+"')");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deleteChiTietHoaDon(int soHD, int maGT){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM CHITIETHOADON WHERE MaNXB = "+soHD+" AND MaGT = "+maGT);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateChiTietHoaDon(int soHD, int maGT, int soLuongBan, String ngayBan){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE CHITIETHOADON SET SoLuongBan = "+soLuongBan+", NgayBan = '"+ngayBan+ "' WHERE SoHoaDon = "+soHD+" AND MaGT = " + maGT);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    public ResultSet SearchChiTietHoaDon(String ngayBan){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM CHITIETHOADON WHERE NgayBan = N'" +ngayBan+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet getChiTietHoaDon(int soHD){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM CHITIETHOADON WHERE SoHoaDon = " +soHD + "");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet getChiTietHoaDon(int soHD, int maGT){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM CHITIETHOADON WHERE SoHoaDon = " +soHD + " AND MaGT = "+maGT);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ResultSet getSoLuongCacGTBan(String ngayBD, String ngayKT){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("select TenGT, SUM(SoLuongBan) as 'SoLuongDaBan' from CHITIETHOADON "
                    + "inner join GIAOTRINH on CHITIETHOADON.MaGT=GIAOTRINH.MaGT where NgayBan BETWEEN '"+ngayBD+"' and '"+ngayKT+"' group by TenGT");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ResultSet ThongKeSoLuongBanTienBan(String ngayBD, String ngayKT){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("select SUM(SoLuongBan) as 'SoLuongDaBan', SUM(SoLuongBan*GiaBan) as 'TienThuDuoc' from CHITIETHOADON inner join GIAOTRINH on CHITIETHOADON.MaGT=GIAOTRINH.MaGT where NgayBan BETWEEN '"+ngayBD+"' and '"+ngayKT+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ResultSet TinhTien(int soHD){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT SUM(SoLuongBan*GiaBan) as 'TongTien' FROM CHITIETHOADON inner join GIAOTRINH on CHITIETHOADON.MaGT=GIAOTRINH.MaGT WHERE SoHoaDon = "+soHD+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
}

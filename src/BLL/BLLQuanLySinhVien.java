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
public class BLLQuanLySinhVien {
    DBConnect connect;
    
    public BLLQuanLySinhVien(){
        connect = new DBConnect();
    }
    
     public ResultSet ShowSinhVien() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM SINHVIEN");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public int insertSinhVien(String MaSV, String TenSV, int gioiTinh, String diaChi, String email){
        try {
            connect.getConnection();
            int reult = connect.executeUpdate("INSERT INTO SINHVIEN values('"+MaSV+"', N'"+TenSV+"', "+gioiTinh+", N'"+diaChi+"', '"+email+"')");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deleteSinhVien(String maSV){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM SINHVIEN WHERE MaSV = "+maSV+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateSinhVien(String maSV, String tenSV, int gioiTinh, String diaChi, String email){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE SINHVIEN SET TenSV = N'"+tenSV+"', GioiTinh = "+gioiTinh+", DiaChi = N'"+diaChi+ "', Email = '"+email+"' WHERE MaSV = '"+maSV+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    public ResultSet SearchSinhVienTheoTen(String tenSV){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM SINHVIEN WHERE TenSV like N'%" +tenSV+"%'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet getThongTinSinhVien(String maSV){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM SINHVIEN WHERE MaSV = '" +maSV+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    
    
    public ResultSet searchThongTinSinhVienTheoDiaChi(String diaChi){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM SINHVIEN WHERE DiaChi = " +diaChi);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
}

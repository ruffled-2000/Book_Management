/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DBConnect;
import DTO.DTOTaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

/**
 *
 * @author LongTienSinh
 */
public class BLLTaiKhoan {
    DBConnect connect;
    public BLLTaiKhoan(){
        this.connect = new DBConnect();
    }
    
    public ResultSet ShowTaiKhoan() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM TAIKHOAN");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public ResultSet ShowLoaiTK(int loai) throws Exception{
        try{
            connect.getConnection();
            return connect.executeQuery("SELECT * FROM TAIKHOAN WHERE loaiTaiKhoan = "+loai+"");
        }
        catch(SQLException e){
        }
        return null;
    }
    
    public int insertTaiKhoan(String tenDangNhap, String matKhau, String tenNguoiDung, int loaiTK){
        try {
            connect.getConnection();
            int reult = connect.executeUpdate("INSERT INTO TAIKHOAN values('"+tenDangNhap+"', '"+matKhau+"', N'"+tenNguoiDung+"', "+loaiTK+")");
            connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deleteTaiKhoan(String tenDangNhap){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM TAIKHOAN WHERE TenDangNhap = '"+tenDangNhap+"'");
            connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public ResultSet DangNhap(String tenDangNhap, String matKhau) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM TAIKHOAN WHERE TenDangNhap = '"+tenDangNhap+"' AND MatKhau = '"+matKhau+"'" );
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public ResultSet ShowThongTinTK(String tenDangNhap) throws Exception{
        try{
            connect.getConnection();
            return connect.executeQuery("SELECT * FROM TAIKHOAN WHERE TenDangNhap = '"+tenDangNhap+"'");
        }
        catch(SQLException e){
        }
        return null;
    }
    
    public ResultSet TimKiemTaiKhoan(String tenDangNhap) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM TAIKHOAN WHERE TenDangNhap like '%" +tenDangNhap+ "%'");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public int updateTaiKhoan(String tenDangNhap, String matKhau, String tenNguoiDung, int loai){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE TAIKHOAN SET MatKhau = '"+matKhau+"', TenNguoiDung = N'"+tenNguoiDung+"', loaiTaiKhoan = '"+loai+"' WHERE TenDangNhap = '"+tenDangNhap+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public ResultSet KiemTraTaiKhoan(String tenDangNhap, String matKhau) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM TAIKHOAN WHERE TenDangNhap = '" +tenDangNhap+ "' AND MatKhau = '"+matKhau+"'");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public int updateMatKhau(String tenDangNhap, String matKhau){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE TAIKHOAN SET MatKhau = '"+matKhau+"' WHERE TenDangNhap = '"+tenDangNhap+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
}

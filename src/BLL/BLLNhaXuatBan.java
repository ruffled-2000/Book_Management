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
public class BLLNhaXuatBan {
    
    DBConnect connect;

    public BLLNhaXuatBan() {
        connect = new DBConnect();
    }
    
    public ResultSet ShowNhaXuatBan() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM NHAXUATBAN");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public int insertNhaXuatBan(String tenNXB, String diaChi, String soDT){
        try {
            connect.getConnection();
            int reult = connect.executeUpdate("INSERT INTO NHAXUATBAN values(N'"+tenNXB+"', N'"+diaChi+"', '"+soDT+"')");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deleteNhaXuatBan(int maNXB){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM NHAXUATBAN WHERE MaNXB = "+maNXB+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateNhaXuatBan(int maNXB, String tenNXB, String diaChi, String soDT){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE NHAXUATBAN SET TenNXB = N'"+tenNXB+"', DiaChi = N'"+diaChi+ "', SoDT = '"+soDT+"' WHERE MaNXB = "+maNXB+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    public ResultSet SearchNhaXuatBan(String tenNXB){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM NHAXUATBAN WHERE TenNXB like N'%" +tenNXB+"%'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet getTenNhaXuatBan(int maNXB){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM NHAXUATBAN WHERE MaNXB = " +maNXB);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
}

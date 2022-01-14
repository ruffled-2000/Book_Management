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
public class BLLHoaDon {
    DBConnect connect = new DBConnect();
    
    public BLLHoaDon() {
        connect = new DBConnect();
    }
    
    public ResultSet ShowHoaDon() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM HOADON");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        
        return null;
    }
    public int insertHoaDon(String maSV){
        try {
            connect.getConnection();
            //int reult = connect.executeUpdate("INSERT INTO DANHMUC values('"+tenDM+"')");
            int reult = connect.executeUpdate("insert into HOADON values('"+maSV+"')");
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deleteHoaDon(int soHoaDon){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM HOADON WHERE SoHoaDon = "+soHoaDon+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateHoaDon(int soHoaDon, String maSV){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE HOADON SET MaSV = '"+maSV+"' WHERE SoHoaDon = "+soHoaDon+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public ResultSet LayMaHoaDonTiepTheo(){
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT IDENT_CURRENT('HOADON')");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet SearchHoaDonWithSoPM(int soHD){
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM HOADON WHERE SoHoaDon = "+soHD+"");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return null;
    }
}

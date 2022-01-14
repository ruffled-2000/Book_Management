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
public class BLLDanhMuc {
    DBConnect connect;

    public BLLDanhMuc() {
        connect = new DBConnect();
    }
    
    public ResultSet ShowDanhMuc() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM DANHMUC");
            return reult;
        } catch (SQLException e) {
        }
//        finally{
//            connect.closeConnect();
//        }
        
        return null;
    }
    public int insertDanhMuc(String tenDM){
        try {
            connect.getConnection();
            //int reult = connect.executeUpdate("INSERT INTO DANHMUC values('"+tenDM+"')");
            int reult = connect.executeUpdate("insert into DANHMUC values(N'"+tenDM+"')");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deleteDanhMuc(int maDM){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM DANHMUC WHERE MaDanhMuc = "+maDM+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateDanhMuc(int maDM, String tenDM){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE DANHMUC SET TenDanhMuc = N'"+tenDM+"' WHERE MaDanhMuc = "+maDM+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public ResultSet getTenDanhMuc(int maDM) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM DANHMUC WHERE MaDanhMuc = "+maDM);
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public ResultSet TimKiemDanhMuc(String tenDM) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM DANHMUC WHERE TenDanhMuc like N'%"+tenDM+"%'");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
}

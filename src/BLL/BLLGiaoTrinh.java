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
public class BLLGiaoTrinh {
    DBConnect connect;

    public BLLGiaoTrinh() {
        connect = new DBConnect();
    }
    
    public ResultSet ShowGiaoTrinh() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM GIAOTRINH");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        
        return null;
    }
    public int insertGiaoTrinh(String tenGT, String tacGia, int maNXB, int maDanhMuc, String namXB, int lanXB, int soLuong, int giaBan){
        try {
            connect.getConnection();
            int reult = connect.executeUpdate("insert into GIAOTRINH values(N'"+tenGT+"', N'"+tacGia+"', "+maNXB+", "+maDanhMuc+", CONVERT(VARCHAR(10), CONVERT(date, '"+namXB+"', 103), 23) , "+lanXB+", "+soLuong+", "+giaBan+")");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
            System.out.println("Vào catch");
        }
        return 0;
    }
    public int deleteGiaoTrinh(int maGT){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM GIAOTRINH WHERE MaGT = "+maGT+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateGiaoTrinh(int maGT, String tenGT, String tacGia, int maNXB, int maDanhMuc, String namXB, int lanXB, int soLuong, int giaBan){
        try {
            connect.getConnection();
            
            
            int result = connect.executeUpdate("UPDATE GIAOTRINH SET TenGT = N'"+tenGT+"', TacGia = N'"+tacGia+"', MaNXB = "+maNXB+", MaDanhMuc = "+maDanhMuc+", NamXB = CONVERT(VARCHAR(10), CONVERT(date, '"+namXB+"', 103), 23), LanXB = "+lanXB+", SoLuong = "+soLuong+", GiaBan = "+giaBan+" WHERE MaGT = "+maGT);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
            System.out.println("Vào catch");
        }
        return 0;
    }
    
    public int updateGiaoTrinh(int maGT, int soLuong){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE DANHMUC SET SoLuong = "+soLuong+" WHERE MaGT = "+maGT+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public ResultSet getGiaoTrinhByID(int maGT) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM GIAOTRINH WHERE MaGT = " + maGT);
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public ResultSet ShowGiaoTrinhWithDanhMuc(int maDM) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM GIAOTRINH WHERE MaDanhMuc = "+maDM);
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public ResultSet SearchGiaoTrinhWithMa(int maGT) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM GIAOTRINH WHERE MaGT = "+maGT);
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public ResultSet SearchGiaoTrinhWithTenGT(String tenGT) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM GIAOTRINH WHERE TenGT like N'%"+tenGT+"%'");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public ResultSet SearchGiaoTrinhWithTacGia(String tacGia) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM GIAOTRINH WHERE TacGia like N'%"+tacGia+"%'");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public ResultSet getGiaoTrinhByWithSoPM(int soPM) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM GIAOTRINH inner join CHITIETPHIEUMUON on GIAOTRINH.MaGT=CHITIETPHIEUMUON.MaGT WHERE SoPhieuMuon = " + soPM);
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
}

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
public class BLLPhieuMuon {
    DBConnect connect = new DBConnect();
    
    public BLLPhieuMuon() {
        connect = new DBConnect();
    }
    
    public ResultSet ShowPhieuMuon() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("select * from PHIEUMUON");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        
        return null;
    }
    public int insertPhieuMuon(String maSV){
        try {
            connect.getConnection();
            //int reult = connect.executeUpdate("INSERT INTO DANHMUC values('"+tenDM+"')");
            int reult = connect.executeUpdate("insert into PHIEUMUON values('"+maSV+"', 0)");
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deletePhieuMuon(int soPhieuMuon){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM PHIEUMUON WHERE SoPhieuMuon = "+soPhieuMuon+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
        public int updateTinhTrangPhieuMuon(int soPM, int tinhTrang){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE PHIEUMUON SET TinhTrang = "+ tinhTrang +" WHERE SoPhieuMuon = "+soPM);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updatePhieuMuon(int soPhieuMuon, String maSV){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE PHIEUMUON SET MaSV = '"+maSV+"' WHERE soPhieuMuon = "+soPhieuMuon+"");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public ResultSet LayMaPhieuMuonTiepTheo(){
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT IDENT_CURRENT('PHIEUMUON')");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ResultSet SearchPhieuMuonWithTinhTrang(int tinhTrang){
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("select PHIEUMUON.SoPhieuMuon, MaSV from PHIEUMUON inner join CHITIETPHIEUMUON on PHIEUMUON.SoPhieuMuon = CHITIETPHIEUMUON.SoPhieuMuon where TinhTrang = "+tinhTrang+" group by PHIEUMUON.SoPhieuMuon, MaSV");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet DemSoLuongGTChuaTra(String maSV,int tinhTrang){
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("select COUNT(*) from PHIEUMUON inner join CHITIETPHIEUMUON on PHIEUMUON.SoPhieuMuon=CHITIETPHIEUMUON.SoPhieuMuon\n" +
                                                                                 " inner join SINHVIEN on PHIEUMUON.MaSV = SINHVIEN.MaSV\n" +
                                                    "where SINHVIEN.MaSV='"+maSV+"' and TinhTrang="+tinhTrang);
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ResultSet SearchPhieuMuonWithMaSV(String maSV){
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM PHIEUMUON WHERE MaSV = '"+maSV+"'");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ResultSet SearchPhieuMuonWithSoPM(int soPM){
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM PHIEUMUON WHERE SoPhieuMuon = "+soPM+"");
            //connect.closeConnect();
            return reult;
        } catch (Exception e) {
        }
        return null;
    }
}

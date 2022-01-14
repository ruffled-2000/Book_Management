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
public class BLLChiTietPhieuMuon {
    DBConnect connect;
    
    public BLLChiTietPhieuMuon() {
        connect = new DBConnect();
    }
    
    public ResultSet ShowChiTietPhieuMuon() throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM CHITIETPHIEUMUON");
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public ResultSet ShowChiTietPhieuMuonWithSoPM(int soPM) throws Exception{
        try {
            connect.getConnection();
            ResultSet reult = connect.executeQuery("SELECT * FROM CHITIETPHIEUMUON WHERE SoPhieuMuon = "+soPM);
            //connect.closeConnect();
            return reult;
        } catch (SQLException e) {
        }
        return null;
    }
    public int insertChiTietPhieuMuon(int soPM, int maGT, String ngayMuon, String ngayTra){
        try {
            connect.getConnection();
            //int reult = connect.executeUpdate("INSERT INTO CHITIETPHIEUMUON values("+soPM+", "+maGT+", 0, '"+ngayMuon+"', '"+ngayTra+"')");
            int reult = connect.executeUpdate("INSERT INTO CHITIETPHIEUMUON values("+soPM+", "+maGT+", '"+ngayMuon+"', '"+ngayTra+"')");
            //connect.closeConnect();
            System.out.println("sql");
            return reult;
        } catch (Exception e) {
        }
        return 0;
    }
    public int deleteChiTietPhieuMuon(int soPM, int maGT){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM CHITIETPHIEUMUON WHERE MaNXB = "+soPM+" AND MaGT = "+maGT);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
     public int deleteChiTietPhieuMuon(int soPM){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("DELETE FROM CHITIETPHIEUMUON WHERE MaNXB = "+soPM);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateChiTietPhieuMuon(int soPM, int maGT, String ngayMuon, String ngayTra){
        try {
            connect.getConnection();
            int result = connect.executeUpdate("UPDATE CHITIETPHIEUMUON SET TinhTrang = "+ 1 +", NgayMuon = '"+ngayMuon+ "', NgayTra = '"+ ngayTra +"' WHERE SoPhieuMuon = "+soPM+" AND MaGT = " + maGT);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
    public ResultSet SearchChiTietPhieuMuon(String ngayMuon){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM CHITIETPHIEUMUON WHERE NgayMuon = N'" +ngayMuon+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet getChiTietPhieuMuon(int soPM){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM CHITIETPHIEUMUON WHERE SoPhieuMuon = " +soPM + "");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    public ResultSet getChiTietPhieuMuon(int soPM, int maGT){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("SELECT * FROM CHITIETPHIEUMUON WHERE SoPhieuMuon = " +soPM + " AND MaGT = "+maGT);
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    
//    public int updateTinhTrangPhieuMuon(int soPM, int tinhTrang){
//        try {
//            connect.getConnection();
//            int result = connect.executeUpdate("UPDATE CHITIETPHIEUMUON SET TinhTrang = "+ tinhTrang +" WHERE SoPhieuMuon = "+soPM);
//            //connect.closeConnect();;
//            return result;
//        } catch (Exception e) {
//        }
//        return 0;
//    }
    
    public ResultSet getSoLuongCacGTMuon(String ngayBD, String ngayKT){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("select TenGT, COUNT(*) as 'SoLuongDaMuon' from CHITIETPHIEUMUON inner join GIAOTRINH on CHITIETPHIEUMUON.MaGT=GIAOTRINH.MaGT where NgayMuon BETWEEN '"+ngayBD+"' and '"+ngayKT+"' group by TenGT");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ResultSet ThongKeSoGTDaMuon(String ngayBD, String ngayKT){
        try {
            connect.getConnection();
            ResultSet result = connect.executeQuery("select COUNT(*) as 'SoLuongDaMuon' from CHITIETPHIEUMUON inner join GIAOTRINH on CHITIETPHIEUMUON.MaGT=GIAOTRINH.MaGT where NgayMuon BETWEEN '"+ngayBD+"' and '"+ngayKT+"'");
            //connect.closeConnect();;
            return result;
        } catch (Exception e) {
        }
        return null;
    }
}

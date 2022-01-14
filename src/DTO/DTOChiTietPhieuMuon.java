/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LongTienSinh
 */
public class DTOChiTietPhieuMuon {
    private int soPhieuMuon;
    private int maGT;
    private String ngayMuon;
    private String ngayTra;

    public DTOChiTietPhieuMuon(int soPhieuMuon, int maGT, String ngayMuon, String ngayTra) {
        this.soPhieuMuon = soPhieuMuon;
        this.maGT = maGT;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public DTOChiTietPhieuMuon() {
    }

    public int getSoPhieuMuon() {
        return soPhieuMuon;
    }

    public int getMaGT() {
        return maGT;
    }


    public String getNgayMuon() {
        return ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setSoPhieuMuon(int soPhieuMuon) {
        this.soPhieuMuon = soPhieuMuon;
    }

    public void setMaGT(int maGT) {
        this.maGT = maGT;
    }


    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}

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
public class DTOPhieuMuon {
    private int soPhieuMuon;
    private String maSV;
    private int tinhTrang;

    public DTOPhieuMuon(int soPhieuMuon, String maSV, int tinhTrang) {
        this.soPhieuMuon = soPhieuMuon;
        this.maSV = maSV;
        this.tinhTrang=tinhTrang;
    }

    public DTOPhieuMuon() {
    }

    public int getSoPhieuMuon() {
        return soPhieuMuon;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setSoPhieuMuon(int soPhieuMuon) {
        this.soPhieuMuon = soPhieuMuon;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}

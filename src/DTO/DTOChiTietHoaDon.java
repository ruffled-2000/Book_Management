/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author LongTienSinh
 */
public class DTOChiTietHoaDon {
    private int soHD;
    private int maGT;
    private int soLuongBan;
    private String ngayBan;

    public DTOChiTietHoaDon(int soHD, int maGT, int soLuongBan, String ngayBan) {
        this.soHD = soHD;
        this.maGT = maGT;
        this.soLuongBan = soLuongBan;
        this.ngayBan = ngayBan;
    }

    public DTOChiTietHoaDon() {
    }

    public int getSoHD() {
        return soHD;
    }

    public int getMaGT() {
        return maGT;
    }
    
    public int getSoLuongBan() {
        return soLuongBan;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public void setMaGT(int maGT) {
        this.maGT = maGT;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }
}

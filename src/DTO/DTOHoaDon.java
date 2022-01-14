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
public class DTOHoaDon {
    private int soHoaDon;
    private String maSV;

    public DTOHoaDon(int soHoaDon, String maSV) {
        this.soHoaDon = soHoaDon;
        this.maSV = maSV;
    }

    public DTOHoaDon() {
    }

    public String getMaSV() {
        return maSV;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    
    
}

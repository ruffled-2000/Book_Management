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
public class DTOGiaoTrinh {
    private int maGT;
    private String tenGT;
    private String tacGia;
    private int maNXB;
    private int maDanhMuc;
    private String namXB;
    private int lanXB;
    private int soLuong;
    private int giaBan;

    public DTOGiaoTrinh(int maGT, String tenGT, String tacGia, int maNXB, int maDanhMuc, String namXB, int lanXB, int soLuong, int giaBan) {
        this.maGT = maGT;
        this.tenGT = tenGT;
        this.tacGia = tacGia;
        this.maNXB = maNXB;
        this.maDanhMuc = maDanhMuc;
        this.namXB = namXB;
        this.lanXB = lanXB;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public DTOGiaoTrinh() {
    }
    
    public int getMaNXB() {
        return maNXB;
    }

    
    public int getMaGT() {
        return maGT;
    }

    public String getTenGT() {
        return tenGT;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getNamXB() {
        return namXB;
    }

    public int getLanXB() {
        return lanXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }
    

    public void setMaGT(int maGT) {
        this.maGT = maGT;
    }

    public void setTenGT(String tenGT) {
        this.tenGT = tenGT;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }


    public void setNamXB(String namXB) {
        this.namXB = namXB;
    }

    public void setLanXB(int lanXB) {
        this.lanXB = lanXB;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setMaNXB(int maNXB) {
        this.maNXB = maNXB;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }
    
    
}

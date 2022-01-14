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
public class DTOTaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String tenNguoiDung;
    private int loaiTK;

    public DTOTaiKhoan() {
    }

    public DTOTaiKhoan(String tenDangNhap, String matKhau, String tenNguoiDung, int loaiTK) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.tenNguoiDung = tenNguoiDung;
        this.loaiTK = loaiTK;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public int getLoaiTK() {
        return loaiTK;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public void setLoaiTK(int loaiTK) {
        this.loaiTK = loaiTK;
    }
    
    
}

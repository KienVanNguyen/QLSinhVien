package kiennv.example.mob201_ps11892_asm.Model;

import java.util.Date;

public class DangKiHoc<IgnoreExtraProperties> {
    private String maDKH;
    private String hoTen;
    private String tenMon;
    private String ngaySinh;
    private String phone;
    private String email;

    public DangKiHoc(){
    }

    public DangKiHoc(String maDKH, String hoTen, String tenMon, String ngaySinh, String phone, String email) {
        this.maDKH = maDKH;
        this.hoTen = hoTen;
        this.tenMon = tenMon;
        this.ngaySinh = ngaySinh;
        this.phone = phone;
        this.email = email;
    }

    public String getMaDKH() {
        return maDKH;
    }
    public void setMaDKH(String maDKH) {
        this.maDKH = maDKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}

package kiennv.example.mob201_ps11892_asm.Model;

public class Web {
    String mPhong,mGiangDuong,mMaMon,mLop,mgiangVien,mThoiGian;
    String mNgay;

    public Web(String mPhong, String mGiangDuong, String mMaMon, String mLop, String mgiangVien, String mThoiGian, String mNgay) {
        this.mPhong = mPhong;
        this.mGiangDuong = mGiangDuong;
        this.mMaMon = mMaMon;
        this.mLop = mLop;
        this.mgiangVien = mgiangVien;
        this.mThoiGian = mThoiGian;
        this.mNgay = mNgay;
    }

    public String getmPhong() {
        return mPhong;
    }

    public void setmPhong(String mPhong) {
        this.mPhong = mPhong;
    }

    public String getmGiangDuong() {
        return mGiangDuong;
    }

    public void setmGiangDuong(String mGiangDuong) {
        this.mGiangDuong = mGiangDuong;
    }

    public String getmMaMon() {
        return mMaMon;
    }

    public void setmMaMon(String mMaMon) {
        this.mMaMon = mMaMon;
    }

    public String getmLop() {
        return mLop;
    }

    public void setmLop(String mLop) {
        this.mLop = mLop;
    }

    public String getMgiangVien() {
        return mgiangVien;
    }

    public void setMgiangVien(String mgiangVien) {
        this.mgiangVien = mgiangVien;
    }

    public String getmThoiGian() {
        return mThoiGian;
    }

    public void setmThoiGian(String mThoiGian) {
        this.mThoiGian = mThoiGian;
    }

    public String getmNgay() {
        return mNgay;
    }

    public void setmNgay(String mNgay) {
        this.mNgay = mNgay;
    }


    public Web() {
    }

    @Override
    public String toString() {
        return "web{" +
                "mPhong='" + mPhong + '\'' +
                ", mGiangDuong='" + mGiangDuong + '\'' +
                ", mMaMon='" + mMaMon + '\'' +
                ", mLop='" + mLop + '\'' +
                ", mgiangVien='" + mgiangVien + '\'' +
                ", mThoiGian='" + mThoiGian + '\'' +
                ", mNgay='" + mNgay + '\'' +
                '}';
    }
}

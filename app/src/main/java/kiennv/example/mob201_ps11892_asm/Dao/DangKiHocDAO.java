package kiennv.example.mob201_ps11892_asm.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import kiennv.example.mob201_ps11892_asm.Database.DatabaseHelper;
import kiennv.example.mob201_ps11892_asm.Model.DangKiHoc;


public class DangKiHocDAO {
    public static final String TABLE_NAME = "DangKiHoc";
    public static final String SQL_DANGKIHOC = "CREATE TABLE DangKiHoc (maDKH text primary key, hoTen text, tenMon text, ngaySinh text,  phone text, email text);";
    public static final String TAG = "DangKiHocDAO";

    //SQLite database
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DangKiHocDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int insertDangKiHoc(DangKiHoc dkh) {
        ContentValues values = new ContentValues();
        values.put("maDKH", dkh.getMaDKH());
        values.put("hoTen", dkh.getHoTen());
        values.put("tenMon",dkh.getTenMon());
        values.put("ngaySinh",dkh.getNgaySinh());
        values.put("phone", dkh.getPhone());
        values.put("email", dkh.getEmail());

        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    //getAll
    public List<DangKiHoc> getAllDangKiHoc(){
        List<DangKiHoc> dsDKH = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            DangKiHoc dkh = new DangKiHoc();
            dkh.setMaDKH(c.getString(0));
            dkh.setHoTen(c.getString(1));
            dkh.setTenMon(c.getString(2));
            dkh.setNgaySinh(c.getString(3));
            dkh.setPhone(c.getString(4));
            dkh.setEmail(c.getString(5));
            dsDKH.add(dkh);
            Log.d("//=====", dkh.toString());
            c.moveToNext();
        }
        c.close();
        return dsDKH;
    }

    //delete
    public int deleteDangKiHocByID(String maDKH) {
        int result = db.delete(TABLE_NAME, "maDKH=?", new String[]{maDKH});
        if (result == 0)
            return -1;
        return 1;
    }
    //update

    public int updateDangKiHoc(String maDKH, String masosua, String hoten, String tenmon, String ngaysinh, String phone, String email) {
        ContentValues values = new ContentValues();
        values.put("maDKH", masosua);
        values.put("hoTen", hoten);
        values.put("tenMon",tenmon);
        values.put("ngaySinh", ngaysinh);
        values.put("phone", phone);
        values.put("email", email);
        int result = db.update(TABLE_NAME, values, "maDKH=?", new
                String[]{maDKH});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}



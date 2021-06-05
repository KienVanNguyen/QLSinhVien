package kiennv.example.mob201_ps11892_asm.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import kiennv.example.mob201_ps11892_asm.Dao.DangKiHocDAO;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbHoTroHocTap";
    public static final int VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DangKiHocDAO.SQL_DANGKIHOC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + DangKiHocDAO.TABLE_NAME);

        onCreate(db);
    }
}
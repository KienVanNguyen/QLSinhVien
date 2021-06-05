package kiennv.example.mob201_ps11892_asm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kiennv.example.mob201_ps11892_asm.Adapter.DangKiHocAdapter;
import kiennv.example.mob201_ps11892_asm.Dao.DangKiHocDAO;
import kiennv.example.mob201_ps11892_asm.Model.DangKiHoc;
import kiennv.example.mob201_ps11892_asm.R;

public class DangKyHocActivity extends AppCompatActivity {
   RecyclerView rcvDKHoc;
   FloatingActionButton fabDKHoc;
   public static List<DangKiHoc> dsDangKiHoc = new ArrayList<>();
   DangKiHocAdapter adapter = null;
   DangKiHocDAO dangKiHocDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("ĐĂNG KÝ HỌC");
        setContentView(R.layout.activity_dang_ky_hoc);
        rcvDKHoc = findViewById(R.id.rcvDKHoc);
        fabDKHoc = findViewById(R.id.fabDKHoc);
        rcvDKHoc = findViewById(R.id.rcvDKHoc);
        dangKiHocDAO = new DangKiHocDAO(DangKyHocActivity.this);
        dsDangKiHoc = dangKiHocDAO.getAllDangKiHoc();
        adapter = new DangKiHocAdapter(this, dsDangKiHoc);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDKHoc.setLayoutManager(linearLayoutManager);
        rcvDKHoc.setAdapter(adapter);

//        fabDKHoc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Dialog dialog=new Dialog(DangKyHocActivity.this);
//                dialog.setContentView(R.layout.dialog_dkhoc);
//                dialog.show();
//            }
//        });
        fabDKHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKyHocActivity.this, Dialog_DKHoc.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        dsDangKiHoc.clear();
        dsDangKiHoc = dangKiHocDAO.getAllDangKiHoc();
        adapter.changeDataset(dangKiHocDAO.getAllDangKiHoc());
    }
}
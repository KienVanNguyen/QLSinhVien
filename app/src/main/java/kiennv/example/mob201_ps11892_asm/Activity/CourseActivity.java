package kiennv.example.mob201_ps11892_asm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kiennv.example.mob201_ps11892_asm.R;

public class CourseActivity extends AppCompatActivity {
    Button btnDKHoc, btnLichHoc, btnLichThi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Course");
        setContentView(R.layout.activity_course);
        btnDKHoc = findViewById(R.id.btnDKHoc);
        btnLichHoc = findViewById(R.id.btnLichHoc);
        btnLichThi = findViewById(R.id.btnLichThi);

        btnDKHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, DangKyHocActivity.class);
                startActivity(intent);
            }
        });
        btnLichHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, LichHocActivity.class);
                startActivity(intent);
            }
        });
        btnLichThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, LichThiActivity.class);
                startActivity(intent);
            }
        });
    }
}
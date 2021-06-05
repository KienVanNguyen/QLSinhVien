package kiennv.example.mob201_ps11892_asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import kiennv.example.mob201_ps11892_asm.Activity.CourseActivity;
import kiennv.example.mob201_ps11892_asm.Activity.MapsActivity;
import kiennv.example.mob201_ps11892_asm.Activity.NewsActivityMain;
import kiennv.example.mob201_ps11892_asm.Activity.SocialActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgCourse, imgMaps, imgNews, imgSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCourse = findViewById(R.id.imgCourse);
        imgMaps = findViewById(R.id.imgMaps);
        imgNews = findViewById(R.id.imgNews);
        imgSocial = findViewById(R.id.imgSocial);

        imgCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CourseActivity.class);
                startActivity(intent);
            }
        });
        imgMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        imgNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewsActivityMain.class);
                startActivity(intent);
            }
        });
        imgSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SocialActivity.class);
                startActivity(intent);
            }
        });
    }
}
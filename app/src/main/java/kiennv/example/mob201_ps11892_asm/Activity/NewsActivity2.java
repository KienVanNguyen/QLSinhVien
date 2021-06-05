package kiennv.example.mob201_ps11892_asm.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import kiennv.example.mob201_ps11892_asm.R;

public class NewsActivity2 extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2);
        webView  = findViewById(R.id.webView);
        Intent intent = getIntent();
        String link = intent.getStringExtra("Link");

        webView.loadUrl(link);
        //xem trong dt
        webView.setWebViewClient(new WebViewClient());
    }
}
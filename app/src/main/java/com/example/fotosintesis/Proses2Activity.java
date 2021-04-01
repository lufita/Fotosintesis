package com.example.fotosintesis;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Proses2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses2);

        Button btnkanan = (Button)findViewById(R.id.btn_kanan);
        TextView tProses2 = (TextView)findViewById(R.id.txtproses2);
        TextView tProses22 = (TextView)findViewById(R.id.txtproses22);
        TextView tSumber = (TextView)findViewById(R.id.txtsumber);

        btnkanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Proses2Activity.this, Proses3Activity.class);
                startActivity(intent);
            }
        });

        Typeface proses2 = Typeface.createFromAsset(getAssets(), "font/AddisAbaba.ttf");
        tProses2.setTypeface(proses2);

        Typeface proses22 = Typeface.createFromAsset(getAssets(), "font/AddisAbaba.ttf");
        tProses22.setTypeface(proses22);

        Typeface sumber = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tSumber.setTypeface(sumber);

    }

    public void close(View view)
    {
        super.onBackPressed();
    }

    public void back(View view)
    {
        super.onBackPressed();
    }

}
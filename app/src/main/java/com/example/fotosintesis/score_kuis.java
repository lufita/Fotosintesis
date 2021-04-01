package com.example.fotosintesis;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class score_kuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_kuis);

        //Kamus + Deskripsi:
        TextView hasil = (TextView) findViewById(R.id.hasil);
        TextView nilai = (TextView) findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar\t: " + kuis_soal.benar + "\nJawaban Salah\t  : " + kuis_soal.salah);
        nilai.setText("" + kuis_soal.hasil);

        Typeface proses3 = Typeface.createFromAsset(getAssets(), "font/Bubble_Bobble.ttf");
        hasil.setTypeface(proses3);

        Typeface sumber = Typeface.createFromAsset(getAssets(), "font/Bubble_Bobble.ttf");
        nilai.setTypeface(sumber);
    }

    public void ulangi(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), kuis_soal.class);
        startActivity(intent);
    }

    public void close(View view) {
        finish();
    }

}

package com.example.fotosintesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class kuis_intruksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_intruksi);

    }

    public void next(View view) {
        finish();
        Intent intent = new Intent(kuis_intruksi.this, kuis_soal.class);
        startActivity(intent);
    }

    public void close(View view) {
        finish();
    }
}

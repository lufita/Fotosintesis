package com.example.fotosintesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Bantuan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Button bNext = (Button) findViewById(R.id.next);

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent in = new Intent(Bantuan.this, Bantuan1Activity.class);
                startActivity(in);
            }
        });
    }

    public void close(View view) {
        super.onBackPressed();
    }

}


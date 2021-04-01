package com.example.fotosintesis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Bantuan2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan2);

        Button bNext = (Button) findViewById(R.id.next);
        Button bBack = (Button) findViewById(R.id.back);

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent in = new Intent(Bantuan2Activity.this, Bantuan1Activity.class);
                startActivity(in);
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent in = new Intent(Bantuan2Activity.this, Bantuan3Activity.class);
                startActivity(in);
            }
        });

    }

    public void close(View view) {
        super.onBackPressed();
    }

}

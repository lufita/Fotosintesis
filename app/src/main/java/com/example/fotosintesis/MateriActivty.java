package com.example.fotosintesis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MateriActivty extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

//        mp = MediaPlayer.create(this, R.raw.backsound);
//        mp.setLooping(true);
//        mp.setVolume(1,1);
//        mp.start();

        Button btnFoto = (Button)findViewById(R.id.btn_fotosintesis);
        Button btnJenis = (Button)findViewById(R.id.btn_jenis);
        Button btnProses = (Button)findViewById(R.id.btn_proses);
        Button btnFaktor = (Button)findViewById(R.id.btn_faktor);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mp.pause();
                Intent intent = new Intent(MateriActivty.this, FotoActivity.class);
                startActivity(intent);
            }
        });

        btnJenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentjenis, new Jenis()).addToBackStack(null).commit();
            }
        });

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MateriActivty.this, ProsesActivity.class);
                startActivity(intent);
            }
        });

        btnFaktor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MateriActivty.this, FaktorActivity.class);
                startActivity(intent);
            }
        });

    }

    public void close(View view)
    {
        super.onBackPressed();
    }

}
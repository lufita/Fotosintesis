package com.example.fotosintesis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Button btnMute;
    private static MainActivity intance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intance = this;
        init();

        btnMute = (Button)findViewById(R.id.btn_mute);
        Button btnInfo = (Button)findViewById(R.id.btn_info);
        Button btnMateri = (Button)findViewById(R.id.btn_materi);
        Button btnKom = (Button)findViewById(R.id.btn_kompetensi);
        Button btnEval = (Button)findViewById(R.id.btn_evaluasi);
        Button btnHelp = (Button)findViewById(R.id.btn_help);

//        mp = MediaPlayer.create(this, R.raw.backsound);
//        mp.setLooping(true);
//        mp.setVolume(1,1);
//        mp.start();
//
        btnMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Play();
            }
        });

        btnMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mp.pause();
                Intent intent = new Intent(MainActivity.this, MateriActivty.class);
                //Intent intent = new Intent(MainActivity.this, FotoActivity.class);
                startActivity(intent);
            }
        });

        btnKom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KompetensiActivity.class);
                startActivity(intent);
            }
        });

        btnEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, kuis_intruksi.class);
                startActivity(intent);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bantuan.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentinfo, new Info()).addToBackStack(null).commit();
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this,"On start", Toast.LENGTH_SHORT).show();
//        mp = MediaPlayer.create(this, R.raw.backsound);
//        mp.setLooping(true);
//        mp.setVolume(1,1);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"On start", Toast.LENGTH_SHORT).show();
        if (mp == null){
            mp = MediaPlayer.create(this, R.raw.backsound);
            mp.setLooping(true);
            mp.setVolume(1,1);
        }

    }

    public void init(){
        mp = MediaPlayer.create(this, R.raw.backsound);
        mp.setLooping(true);
        mp.setVolume(1,1);
        mp.start();
    }

    public void Play(){
        if(mp.isPlaying()){
            stop();
//            mp.pause();
//            btnMute.setBackgroundResource(R.drawable.bnosounds);
        }else{
            mp.start();;
            btnMute.setBackgroundResource(R.drawable.bsounds);
        }

//        if (mp == null){
//            mp = MediaPlayer.create(this, R.raw.backsound);
//            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                   stopPlayer();
//                }
//            });
//        }
//        mp.setLooping(true);
//        mp.setVolume(1,1);
//        mp.start();
    }

    public static MainActivity getInstance(){
        return  intance;
    }

    public void stop(){
        mp.pause();
        btnMute.setBackgroundResource(R.drawable.bnosounds);
    }

    public void stopPlayer(){
        if(mp != null){
//            mp.stop();
            mp.release();
            mp = null;
            btnMute.setBackgroundResource(R.drawable.bnosounds);
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        stopPlayer();
//    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa Anda ingin keluar dari aplikasi ini?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                        mp.stop();
//                        stopPlayer();
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }



}
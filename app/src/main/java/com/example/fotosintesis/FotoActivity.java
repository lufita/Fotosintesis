package com.example.fotosintesis;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class FotoActivity extends AppCompatActivity {

    WebView webYutub;
//    MediaPlayer mp;
//    Button btnMute;
    MainActivity jajal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

//        mp = MediaPlayer.create(this, R.raw.backsound);
//        mp.setLooping(true);
//        mp.setVolume(1,1);
//        mp.start();

//        btnMute = (Button)findViewById(R.id.btn_mute);
        jajal = new MainActivity();

        webYutub = (WebView) findViewById(R.id.webyutub);
        TextView tFoto = (TextView) findViewById(R.id.txtfoto);
        TextView tSumber = (TextView) findViewById(R.id.txtsumber);

        webYutub.setWebViewClient(new WebViewClient());
        webYutub.setWebChromeClient(new ChromeClient());
        webYutub.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webYutub.getSettings().setJavaScriptEnabled(true);
        webYutub.getSettings().setPluginState(WebSettings.PluginState.ON);
        webYutub.getSettings().setDefaultFontSize(10);

        Typeface foto = Typeface.createFromAsset(getAssets(), "font/CandyCake-gxEyP.ttf");
        tFoto.setTypeface(foto);

        Typeface sumber = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tSumber.setTypeface(sumber);

//        btnMute.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(FotoActivity.this,"Test tombol btnMute",Toast.LENGTH_SHORT).show();
//                if(mp.isPlaying()){
//                    mp.pause();
//                    muatVideo("XB59RChG_Tk");
//                }else{
//                    mp.start();
//
//                }
//
//            }
//        });

    }

    public void Play(View view) {

//        if (jajal.mp.isPlaying()){
//            MainActivity.getInstance().stopPlayer();
//            Toast.makeText(this,"OFF", Toast.LENGTH_SHORT).show();
//            muatVideo("XB59RChG_Tk");
//        }
        MainActivity.getInstance().stopPlayer();
//        Toast.makeText(this,"OFF", Toast.LENGTH_SHORT).show();
        muatVideo("XB59RChG_Tk");
    }

    public void close(View view)
    {
        super.onBackPressed();
//        jajal.stop(view);
//        jajal.btnMute.setBackgroundResource(R.drawable.bsounds);
//        mp.reset();
    }

    private void muatVideo(String kode_youtube){
        String kodeHTML = "<head></head><body>" +
                "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/" +
                kode_youtube +
                "\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen=\"allowfullscreen\""+
                "webkitallowfullscreen=\"true\" mozallowfullscreen=\"true\"></iframe>" +
                "</body>";
        webYutub.loadData(kodeHTML,"text/html; charset=utf-8",null);
    }

    private class ChromeClient extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        ChromeClient() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

}
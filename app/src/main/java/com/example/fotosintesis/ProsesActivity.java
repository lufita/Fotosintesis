package com.example.fotosintesis;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProsesActivity extends AppCompatActivity {

    WebView webYutub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses);

        webYutub = (WebView) findViewById(R.id.webyutub);
        Button btnKanan = (Button)findViewById(R.id.btn_kanan);
        TextView tProses = (TextView)findViewById(R.id.txtproses);
        TextView tProsess = (TextView)findViewById(R.id.txtprosess);
        TextView tSumber = (TextView)findViewById(R.id.txtsumber);

        webYutub.setWebViewClient(new WebViewClient());
        webYutub.setWebChromeClient(new ChromeClient());
        webYutub.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webYutub.getSettings().setJavaScriptEnabled(true);
        webYutub.getSettings().setPluginState(WebSettings.PluginState.ON);
        webYutub.getSettings().setDefaultFontSize(18);

        btnKanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProsesActivity.this, Proses2Activity.class);
                startActivity(intent);
            }
        });

        Typeface proses = Typeface.createFromAsset(getAssets(), "font/AddisAbaba.ttf");
        tProses.setTypeface(proses);

        Typeface prosess = Typeface.createFromAsset(getAssets(), "font/AddisAbaba.ttf");
        tProsess.setTypeface(prosess);

        Typeface sumber = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tSumber.setTypeface(sumber);

    }

    public void close(View view)
    {
        super.onBackPressed();
    }

    private void muatVideo(String kode_youtube){
        String kodeHTML = "<head></head><body>" +
                "<iframe width=\"330\" height=\"180\" src=\"https://www.youtube.com/embed/" +
                kode_youtube +
                "\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>" +
                "</body>";
        webYutub.loadData(kodeHTML,"text/html; charset=utf-8",null);
    }

    public void Play(View view) {
        muatVideo("vF8uWdrVorg");
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
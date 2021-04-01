package com.example.fotosintesis;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JenisActivity extends AppCompatActivity {

    WebView webYutub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis);

        webYutub = (WebView)findViewById(R.id.webyutub);
        TextView tJenis = (TextView)findViewById(R.id.txtjenis);
        TextView tJenis2 = (TextView)findViewById(R.id.txtjenis2);

        webYutub.setWebViewClient(new WebViewClient());
        webYutub.setWebChromeClient(new ChromeClient());
        webYutub.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webYutub.getSettings().setJavaScriptEnabled(true);
        webYutub.getSettings().setPluginState(WebSettings.PluginState.ON);
        webYutub.getSettings().setDefaultFontSize(10);

        Typeface jenis = Typeface.createFromAsset(getAssets(), "font/CandyCake-gxEyP.ttf");
        tJenis.setTypeface(jenis);

        Typeface jenis2 = Typeface.createFromAsset(getAssets(), "font/MyKidsHandwritten.otf");
        tJenis2.setTypeface(jenis2);

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
        muatVideo("S_VyzbIlT0g");
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
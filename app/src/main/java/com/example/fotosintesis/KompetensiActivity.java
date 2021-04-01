package com.example.fotosintesis;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KompetensiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensi);

        TextView tKom = (TextView)findViewById(R.id.txtkom);
        TextView tKom2 = (TextView)findViewById(R.id.txtkom2);
        TextView tKom3 = (TextView)findViewById(R.id.txtkom3);
        TextView tKom4 = (TextView)findViewById(R.id.txtkom4);
        TextView tKom5 = (TextView)findViewById(R.id.txtkom5);
        TextView tKom6 = (TextView)findViewById(R.id.txtkom6);
        TextView tKom7 = (TextView)findViewById(R.id.txtkom7);
        TextView tKom8 = (TextView)findViewById(R.id.txtkom8);
        TextView tKom9 = (TextView)findViewById(R.id.txtkom9);
        TextView tKom10 = (TextView)findViewById(R.id.txtkom10);

        Typeface kom = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom.setTypeface(kom);

        Typeface kom2 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom2.setTypeface(kom2);

        Typeface kom3 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom3.setTypeface(kom3);

        Typeface kom4 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom4.setTypeface(kom4);

        Typeface kom5 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom5.setTypeface(kom5);

        Typeface kom6 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom6.setTypeface(kom6);

        Typeface kom7 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom7.setTypeface(kom7);

        Typeface kom8 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom8.setTypeface(kom8);

        Typeface kom9 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom9.setTypeface(kom9);

        Typeface kom10 = Typeface.createFromAsset(getAssets(), "font/Hansville.ttf");
        tKom10.setTypeface(kom10);

    }

    public void close(View view)
    {
        super.onBackPressed();
    }

}
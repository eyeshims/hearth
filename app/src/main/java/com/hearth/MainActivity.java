package com.hearth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean toogle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onYesOrNoButtonClick(View view) {
        ImageView propertyPreview = (ImageView) findViewById(R.id.propertyPreview);

        if (toogle) {
            propertyPreview.setImageResource(R.drawable.modern_apartment);
            toogle = false;
        }
        else {
            propertyPreview.setImageResource(R.drawable.modern_apartment_2);
            toogle = true;
        }
    }
}

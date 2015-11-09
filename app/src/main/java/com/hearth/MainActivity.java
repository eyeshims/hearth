package com.hearth;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    PropertyCollection properties;
    GestureDetectorCompat isFling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isFling = new GestureDetectorCompat(this, new FlingGesture());

        ImageView propertyPreview = (ImageView) findViewById(R.id.propertyPreview);
        TextView progressText = (TextView) findViewById(R.id.progressText);
        properties = new PropertyCollection(propertyPreview, progressText);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isFling.onTouchEvent(event)) {
            properties.showNextProperty();
        }

        return super.onTouchEvent(event);
    }

    public void onYesOrNoButtonClick(View view) {
        properties.showNextProperty();
    }
}

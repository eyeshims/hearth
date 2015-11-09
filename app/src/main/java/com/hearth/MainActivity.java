package com.hearth;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    GestureDetectorCompat mDetector;
    Integer[] images;
    Integer currentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        images = new Integer[] {
            R.drawable.modern_apartment,
            R.drawable.modern_apartment_2
        };
        currentImage = 0;
        displayNextRentalProperty();
    }

    public void onYesOrNoButtonClick(View view) {
        displayNextRentalProperty();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Boolean wasFlingGesture = mDetector.onTouchEvent(event);

        if (wasFlingGesture) {
            displayNextRentalProperty();
        }

        return super.onTouchEvent(event);
    }

    private void displayNextRentalProperty() {
        ImageView propertyPreview = (ImageView) findViewById(R.id.propertyPreview);

        currentImage++;
        if (currentImage == images.length) {
            currentImage = 0;
        }

        propertyPreview.setImageResource(images[currentImage]);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return true;
        }
    }
}

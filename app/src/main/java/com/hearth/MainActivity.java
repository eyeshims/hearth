package com.hearth;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    PropertyCollection properties;
    GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        ImageView propertyPreview = (ImageView) findViewById(R.id.propertyPreview);
        TextView progressText = (TextView) findViewById(R.id.progressText);
        properties = new PropertyCollection(propertyPreview, progressText);
    }

    public void onYesOrNoButtonClick(View view) {
        properties.showNextProperty();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Boolean wasFlingGesture = mDetector.onTouchEvent(event);

        if (wasFlingGesture) {
            properties.showNextProperty();
        }

        return super.onTouchEvent(event);
    }

    class PropertyCollection {
        ImageView propertyPreview;
        TextView progressText;

        Integer[] images;
        Integer imageIndex;

        public PropertyCollection(ImageView propertyPreview, TextView progressText) {
            this.propertyPreview = propertyPreview;
            this.progressText = progressText;
            images = new Integer[] {
                    R.drawable.modern_apartment,
                    R.drawable.modern_apartment_2
            };
            imageIndex = 0;
            showNextProperty();
        }

        // Creates a string that displays how the current image number
        // out of the total images e.g. 10/31.
        void updateProgressText() {
            progressText.setText("10/31");
        }

        public void showNextProperty() {
            ImageView propertyPreview = (ImageView) findViewById(R.id.propertyPreview);

            imageIndex++;
            if (imageIndex == images.length) {
                imageIndex = 0;
            }

            propertyPreview.setImageResource(images[imageIndex]);
            updateProgressText();
        }

    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return true;
        }
    }
}

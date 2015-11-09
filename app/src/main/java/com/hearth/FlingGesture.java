package com.hearth;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class FlingGesture extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return true;
    }
}
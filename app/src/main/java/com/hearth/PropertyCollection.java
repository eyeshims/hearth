package com.hearth;

import android.widget.ImageView;
import android.widget.TextView;

public class PropertyCollection {
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
        propertyPreview.setImageResource(images[imageIndex]);
        updateProgressText();
    }

    // Creates a string that displays how the current image number
    // out of the total images e.g. 10/31.
    void updateProgressText() {
        StringBuilder progress = new StringBuilder();

        progress.append(imageIndex + 1);
        progress.append(" / ");
        progress.append(images.length);

        progressText.setText(progress);
    }

    public void showNextProperty() {
        imageIndex++;
        if (imageIndex == images.length) {
            imageIndex = 0;
        }

        propertyPreview.setImageResource(images[imageIndex]);
        updateProgressText();
    }

}
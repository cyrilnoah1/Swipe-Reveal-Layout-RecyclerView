package com.cyril.training.dayseventeen;

import android.graphics.drawable.Drawable;

/**
 * Data to be populated in the RecyclerView.
 */
public class RecyclerData {
    private String textData; // Text data.

    public RecyclerData(String genre) {
        this.textData = genre;
    }

    /*
    * GETTERS AND SETTERS
    */

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

}

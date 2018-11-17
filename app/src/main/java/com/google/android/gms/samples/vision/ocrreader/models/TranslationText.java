package com.google.android.gms.samples.vision.ocrreader.models;

import com.google.gson.annotations.SerializedName;

public class TranslationText {
    @SerializedName("translatedText")
    private String translatedText;

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}

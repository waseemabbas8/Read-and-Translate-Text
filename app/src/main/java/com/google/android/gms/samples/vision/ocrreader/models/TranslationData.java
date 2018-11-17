package com.google.android.gms.samples.vision.ocrreader.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TranslationData {
    @SerializedName("translations")
    private List<TranslationText> translationTexts;

    public List<TranslationText> getTranslationTexts() {
        return translationTexts;
    }

    public void setTranslationTexts(List<TranslationText> translationTexts) {
        this.translationTexts = translationTexts;
    }
}

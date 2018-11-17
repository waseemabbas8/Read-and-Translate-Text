package com.google.android.gms.samples.vision.ocrreader.models;

import com.google.gson.annotations.SerializedName;

public class TranslationApiResp {
    @SerializedName("data")
    private TranslationData translationData;

    public TranslationData getTranslationData() {
        return translationData;
    }

    public void setTranslationData(TranslationData translationData) {
        this.translationData = translationData;
    }
}

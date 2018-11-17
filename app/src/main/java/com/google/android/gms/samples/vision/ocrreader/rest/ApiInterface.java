package com.google.android.gms.samples.vision.ocrreader.rest;

import com.google.android.gms.samples.vision.ocrreader.models.TranslationApiResp;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("language/translate/v2")
    Call<TranslationApiResp> translate(@Query("key") String apiKey, @Query("q") String text,@Query("target") String tgtLang,@Query("source") String srcLang);

}

package com.google.android.gms.samples.vision.ocrreader.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
// Imports the Google Cloud client library
import com.google.android.gms.samples.vision.ocrreader.R;
import com.google.android.gms.samples.vision.ocrreader.constants.SharedData;
import com.google.android.gms.samples.vision.ocrreader.models.TranslationApiResp;
import com.google.android.gms.samples.vision.ocrreader.models.TranslationText;
import com.google.android.gms.samples.vision.ocrreader.rest.ApiClient;
import com.google.android.gms.samples.vision.ocrreader.rest.ApiInterface;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import com.google.android.gms.vision.text.TextBlock;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.samples.vision.ocrreader.constants.SharedData.API_KEY;

public class TranslateActivity extends AppCompatActivity {

    TextView txtSource,txtTranslated;
    String sourceText="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        bindViews();

        for (int i = 0; i < SharedData.items.size(); ++i) {
            TextBlock item = SharedData.items.valueAt(i);
            if (item != null && item.getValue() != null) {
                Log.d("Processor", "Text detected! " + item.getValue());
                sourceText+=item.getValue()+"\n";
            }
        }

        txtSource.setText(sourceText);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<TranslationApiResp> call = apiService.translate(API_KEY,sourceText,"ru","en");
        call.enqueue(new HttpCallback());
    }

    void bindViews(){
        txtSource=findViewById(R.id.txt_source);
        txtTranslated=findViewById(R.id.txt_translated);
    }

    public class HttpCallback implements Callback<TranslationApiResp> {

        @Override
        public void onResponse(Call<TranslationApiResp> call, Response<TranslationApiResp> response) {
            int statusCode = response.code();
            List<TranslationText> translations = response.body().getTranslationData().getTranslationTexts();
            txtTranslated.setText(translations.get(0).getTranslatedText());
        }

        @Override
        public void onFailure(Call<TranslationApiResp> call, Throwable t) {
            Toast.makeText(getApplication(), "Sorry! Error while processing", Toast.LENGTH_SHORT).show();
        }
    }
}

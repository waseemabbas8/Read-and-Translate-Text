package com.google.android.gms.samples.vision.ocrreader;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
// Imports the Google Cloud client library
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import com.google.android.gms.vision.text.TextBlock;

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
        //new TranlationAsync().execute();
    }

    void bindViews(){
        txtSource=findViewById(R.id.txt_source);
        txtTranslated=findViewById(R.id.txt_translated);
    }

    public class TranlationAsync extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            txtTranslated.setText(getTranslation(sourceText,"en","ru"));
            return null;
        }
    }

    String getTranslation(String sourceText, String sourcelanguage, String targetLanguage){
        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // Translates some text into Russian
        Translation translation =
                translate.translate(
                        sourceText,
                        TranslateOption.sourceLanguage(sourcelanguage),
                        TranslateOption.targetLanguage(targetLanguage));
        return translation.getTranslatedText();
    }
}

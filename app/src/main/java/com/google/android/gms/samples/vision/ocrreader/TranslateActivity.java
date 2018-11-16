package com.google.android.gms.samples.vision.ocrreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TranslateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        Toast.makeText(this, ""+getIntent().getExtras().getString("text"), Toast.LENGTH_SHORT).show();
    }
}

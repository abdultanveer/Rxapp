package com.example.rxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class FlavoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_flavours);
        Toast.makeText(this, BuildConfig.BASE_URL, Toast.LENGTH_LONG).show();
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}

package com.example.rxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.rxapp.databinding.ActivityDataBindingBinding;

public class DataBndingAct extends AppCompatActivity {

    ActivityDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_binding);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        
        binding.tvHeading.setText("Welcome to JournalDev.com");
        binding.tvSubHeading.setText("Welcome to this Android Tutorial on DataBinding");


    }
}

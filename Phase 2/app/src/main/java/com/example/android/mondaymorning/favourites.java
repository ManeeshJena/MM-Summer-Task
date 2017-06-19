package com.example.android.mondaymorning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class favourites extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.favourites);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }


}
package com.example.android.mondaymorning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Maneesh Kumar Jena on 6/16/2017.
 */

public class upcoming_events extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcoming_events);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

}

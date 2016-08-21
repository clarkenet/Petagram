package com.kenneth.android.petagram.com.kenneth.android.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.kenneth.android.petagram.R;

public class AboutActivity extends AppCompatActivity {

    Toolbar toolbarGral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbarGral = (Toolbar) findViewById(R.id.toolbarGral);
        if (toolbarGral != null) {
            setSupportActionBar(toolbarGral);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
}

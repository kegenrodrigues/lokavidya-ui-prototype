package com.example.melroy.lokavidya;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class EditingModuleActivity extends AppCompatActivity {

    //Variable declarations
    String selectedProjectTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_module);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_editing_module);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedProjectTitle = getIntent().getStringExtra("Selected Project");
        setTitle(selectedProjectTitle);
    }

}

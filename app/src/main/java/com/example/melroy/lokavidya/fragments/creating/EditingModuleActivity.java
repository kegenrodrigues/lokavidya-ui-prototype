package com.example.melroy.lokavidya.fragments.creating;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.melroy.lokavidya.R;

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

    //This method handles the Up-Navigation
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        getSupportFragmentManager().popBackStack();
        return true;
    }
}

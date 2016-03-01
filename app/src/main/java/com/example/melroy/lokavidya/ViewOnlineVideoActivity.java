package com.example.melroy.lokavidya;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ViewOnlineVideoActivity extends AppCompatActivity {

    //Variable declarations
    Toolbar toolbarViewOnlineVideos;
    String activityTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_online_video);
        toolbarViewOnlineVideos = (Toolbar) findViewById(R.id.toolbar_activity_video_player);
        setSupportActionBar(toolbarViewOnlineVideos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityTitle = getIntent().getStringExtra("Selected Video");
        setTitle(activityTitle);
        getSupportFragmentManager().popBackStack();
    }

}

package com.example.melroy.lokavidya.fragments.browsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.melroy.lokavidya.R;

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
    }

    //This method handles the Up-Navigation
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        getSupportFragmentManager().popBackStack();
        return true;
    }
}

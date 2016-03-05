package com.example.melroy.lokavidya.fragments.creating;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.melroy.lokavidya.R;
import com.example.melroy.lokavidya.fragments.browsing.ViewOnlineVideoActivity;

import java.util.ArrayList;

/**
 This class handles calls to the Create Videos Fragment.
 **/
public class CreatingVideosFragment extends Fragment {
    //Handle all the variable declarations here
    FloatingActionButton fabForCreateVideos;
    View rootView;
    ListView listViewCreateVideos;
    String[] projectName = {
            "Biogas",
            "River",
            "Forests"
    };
    String[] projectLanguage = {
            "English",
            "Hindi",
            "German"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create_videos, container, false);
        getActivity().setTitle(R.string.title_creating);

        //Code for ListView
        listViewCreateVideos = (ListView) rootView.findViewById(R.id.listView_create_projects);
        CreateVideosAdapterActivity adapterActivity = new CreateVideosAdapterActivity(getContext(), projectName, projectLanguage);
        listViewCreateVideos.setAdapter(adapterActivity);
        listViewCreateVideos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Opening " + projectName[+position] + "...", Toast.LENGTH_LONG).show();
            }
        });
        listViewCreateVideos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });

        fabForCreateVideos = (FloatingActionButton) rootView.findViewById(R.id.fab_create_project);
        fabForCreateVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

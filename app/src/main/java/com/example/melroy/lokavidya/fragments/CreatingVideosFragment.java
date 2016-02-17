package com.example.melroy.lokavidya.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.melroy.lokavidya.R;

import java.util.ArrayList;

/**
 This class handles calls to the Create Videos Fragment.
 **/
public class CreatingVideosFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    //Handle all the variable declarations here
    FloatingActionButton fabForCreateVideos;
    View rootView;
    ArrayList<String> projectName;
    ArrayList<String> projectLanguage;
    ListView listViewCreateVideos;
    Intent intentGoToEditingModule;

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create_videos, container, false);
        getActivity().setTitle(R.string.title_creating);

        listViewCreateVideos = (ListView) rootView.findViewById(R.id.listView_create_projects);
        listViewCreateVideos.setOnItemClickListener(this);
        listViewCreateVideos.setOnItemLongClickListener(this);

        fabForCreateVideos = (FloatingActionButton) rootView.findViewById(R.id.fab_create_project);
        fabForCreateVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                createFabSelected();
            }
        });
        //Code for ListView
        projectName = new ArrayList<String>();
        projectName.add("There is a great stuff in this ListItem");
        projectName.add("Done");
        projectName.add("Here");
        projectName.add("There");
        projectName.add("Done");
        projectName.add("Here");
        projectName.add("There");
        projectName.add("Done");
        projectName.add("Here");
        projectName.add("There");
        projectName.add("Done");
        projectName.add("Here");
        projectName.add("There");
        projectName.add("Done");
        projectName.add("Here");
        projectName.add("There");
        projectName.add("Done");
        projectName.add("Here");
        System.out.println(projectName);

        projectLanguage = new ArrayList<String>();
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        projectLanguage.add("English");
        System.out.println(projectLanguage);

        ArrayAdapter<String> arrayAdapterProjectName = new ArrayAdapter<String>(getActivity(), R.layout.content_for_create_videos, R.id.textView_project_name, projectName);
        listViewCreateVideos.setAdapter(arrayAdapterProjectName);

//        ArrayAdapter<String> arrayAdapterLanguage = new ArrayAdapter<String>(getActivity(), R.layout.content_for_create_videos, R.id.textView_language, projectLanguage);
//        listViewCreateVideos.setAdapter(arrayAdapterLanguage);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {}

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}

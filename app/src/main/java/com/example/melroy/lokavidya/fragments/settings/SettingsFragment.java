package com.example.melroy.lokavidya.fragments.settings;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.melroy.lokavidya.R;
import com.example.melroy.lokavidya.fragments.settings.SettingsAdapterActivity;

/**
 This class handles calls to the Settings Fragment.
 **/
public class SettingsFragment extends Fragment {

    //Handle all the variable declarations here
    ListView listViewPrimarySettings;
    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    } ;
    Integer[] imageId = {
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_share,
            R.drawable.ic_menu_camera,
            R.drawable.ic_info_black_24dp,
            R.drawable.ic_menu_send,
            R.drawable.ic_menu_manage,
            R.drawable.ic_menu_slideshow

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        getActivity().setTitle(R.string.title_settings);


        //Listview for Showing Settings Type
        SettingsAdapterActivity adapter = new SettingsAdapterActivity(getContext(), web, imageId);
        listViewPrimarySettings=(ListView)rootView.findViewById(R.id.listView_settings);
        listViewPrimarySettings.setAdapter(adapter);
        listViewPrimarySettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

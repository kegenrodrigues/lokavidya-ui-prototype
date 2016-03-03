package com.example.melroy.lokavidya.fragments.browsing;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.Toast;

import com.example.melroy.lokavidya.R;

/**
 This class handles calls to the Browsing Videos Fragment.
 **/
public class BrowsingVideosFragment extends Fragment {

    Gallery videoContent;
    String[] web = {
            "Google",
            "Github",
            "Instagram",
            "Facebook",
            "Flickr",
            "Pinterest",
            "Quora",
            "Twitter",
            "Vimeo",
            "WordPress",
            "Youtube",
            "Stumbleupon",
            "SoundCloud",
            "Reddit",
            "Blogger"

    };
    int[] imageId = {
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_share,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_share,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_share,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_share,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_share,
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_browse_videos, container, false);
        getActivity().setTitle(R.string.title_viewing);

        videoContent = (Gallery) rootView.findViewById(R.id.gallery_image_thumbnails);
        videoContent.setSpacing(0);
        final BrowsingVideosAdapterActivity galleryImageAdapter= new BrowsingVideosAdapterActivity(getActivity(), web, imageId);
        videoContent.setAdapter(galleryImageAdapter);
        videoContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String selectedVideo = web[+position];
                Log.i("GalleryView item id",selectedVideo);
                Toast.makeText(getActivity(), "Playing " + web[+position] + "...", Toast.LENGTH_SHORT).show();
                goToVideoView(selectedVideo);

            }
        });
        return rootView;
    }

    private void goToVideoView(String selectedVideoName) {
        Intent gotoViewOnlineVideo = new Intent(getActivity(), ViewOnlineVideoActivity.class);
        gotoViewOnlineVideo.putExtra("Selected Video", selectedVideoName);
        startActivity(gotoViewOnlineVideo);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

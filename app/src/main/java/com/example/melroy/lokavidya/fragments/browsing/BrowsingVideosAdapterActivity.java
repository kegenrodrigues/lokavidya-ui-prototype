package com.example.melroy.lokavidya.fragments.browsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melroy.lokavidya.R;

/*
This is a base class adapter to fetch and inflate the browsing video functionality
*/
public class BrowsingVideosAdapterActivity extends BaseAdapter {
    private Context mContext;
    private final String[] videoNames;
    private final int[] Imageid;
    View videoItems;

    public BrowsingVideosAdapterActivity(Context c, String[] videoNames, int[] Imageid) {
        mContext = c;
        this.Imageid = Imageid;
        this.videoNames = videoNames;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return videoNames.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            videoItems = new View(mContext);
            videoItems = inflater.inflate(R.layout.content_for_browse_videos, null);
            TextView textView = (TextView) videoItems.findViewById(R.id.textView_video_title);
            ImageView imageView = (ImageView)videoItems.findViewById(R.id.imageView_video_thumbnail);
            textView.setText(videoNames[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            videoItems = (View) convertView;
        }

        return videoItems;
    }
}

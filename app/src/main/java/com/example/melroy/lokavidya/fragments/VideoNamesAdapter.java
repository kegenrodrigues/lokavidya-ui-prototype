package com.example.melroy.lokavidya.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melroy.lokavidya.R;

public class VideoNamesAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public VideoNamesAdapter(Context c, String[] web, int[] Imageid) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
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
        View videoItems;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            videoItems = new View(mContext);
            videoItems = inflater.inflate(R.layout.content_for_browse_videos, null);
            TextView textView = (TextView) videoItems.findViewById(R.id.textView_video_title);
            ImageView imageView = (ImageView)videoItems.findViewById(R.id.imageView_video_thumbnail);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            videoItems = (View) convertView;
        }

        return videoItems;
    }
}

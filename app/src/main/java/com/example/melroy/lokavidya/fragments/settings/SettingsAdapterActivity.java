package com.example.melroy.lokavidya.fragments.settings;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melroy.lokavidya.R;

/**
 This class handles the ArrayAdapter for Settings Fragment
 */
public class SettingsAdapterActivity extends ArrayAdapter<String> {

    //Variable declarations
    private final Context context;
    private final String[] web;
    private final Integer[] imageId;
    public SettingsAdapterActivity(Context context, String[] web, Integer[] imageId) {
        super(context, R.layout.fragment_settings, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView= inflater.inflate(R.layout.content_for_settings, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView_settings_item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView_settings_item);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}

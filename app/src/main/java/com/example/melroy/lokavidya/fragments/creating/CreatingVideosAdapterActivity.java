package com.example.melroy.lokavidya.fragments.creating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.melroy.lokavidya.R;

/**
 This activity handles the data to be supplied to the Project Name and Language
 **/
public class CreatingVideosAdapterActivity extends ArrayAdapter<String>{

    private final Context context;
    private final String[] projectName;
    private final String[] projectLanguage;

    public CreatingVideosAdapterActivity(Context context, String[] projectName, String[] projectLanguage) {
        super(context, R.layout.fragment_create_videos, projectName);
        this.context = context;
        this.projectName = projectName;
        this.projectLanguage = projectLanguage;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView= layoutInflater.inflate(R.layout.content_for_create_videos, null, true);
        TextView textViewProjectName = (TextView) rowView.findViewById(R.id.textView_project_name);
        textViewProjectName.setText(projectName[position]);
        TextView textViewProjectLanguage = (TextView) rowView.findViewById(R.id.textView_project_language);
        textViewProjectLanguage.setText(projectLanguage[position]);
        return rowView;
    }
}

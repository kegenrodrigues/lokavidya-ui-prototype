package com.example.melroy.lokavidya.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.melroy.lokavidya.R;

import org.w3c.dom.Text;

/**
 This class handles calls to the Help & Feedback Fragment.
 **/
public class HelpFeedbackFragment extends Fragment {

    //Handle all the declarations here

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_help_feedback, container, false);
        getActivity().setTitle(R.string.title_help_feedback);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

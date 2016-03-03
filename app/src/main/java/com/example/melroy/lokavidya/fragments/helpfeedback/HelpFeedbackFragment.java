package com.example.melroy.lokavidya.fragments.helpfeedback;


import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.melroy.lokavidya.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 This class handles all the functionality of the Help & Feedback Fragment.
 **/
public class HelpFeedbackFragment extends Fragment implements TextView.OnEditorActionListener {

    //Handle all the declarations here
    AppCompatSpinner spinnerFeedbackType;
    ArrayList<String> arrayListFeedbackContent;
    EditText editTextDescription;
    Button buttonSubmitFeedback;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_help_feedback, container, false);
        getActivity().setTitle(R.string.title_help_feedback);

        //Code for RAM Usage
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager)getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        final long availableMegs = mi.availMem / 1048576L;

        spinnerFeedbackType = (AppCompatSpinner) rootView.findViewById(R.id.spinner_feedback);

        arrayListFeedbackContent = new ArrayList<String>();
        arrayListFeedbackContent.add("Select One");
        arrayListFeedbackContent.add("Feedback");
        arrayListFeedbackContent.add("Complaint");
        arrayListFeedbackContent.add("Bug Report");
        arrayListFeedbackContent.add("Suggestion");

        ArrayAdapter<String> arrayAdapterSpinner = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayListFeedbackContent);
        arrayAdapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFeedbackType.setAdapter(arrayAdapterSpinner);

        editTextDescription = (EditText) rootView.findViewById(R.id.editText_feedback_description);
        editTextDescription.setOnEditorActionListener(this);

        buttonSubmitFeedback = (Button) rootView.findViewById(R.id.button_submit_feedback);
        buttonSubmitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerFeedbackType.getSelectedItem().toString().trim().equals("Select One")) {
                    Toast.makeText(getActivity(), "Please choose one feedback type!", Toast.LENGTH_SHORT).show();

                } else if (editTextDescription.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill in the description!", Toast.LENGTH_SHORT).show();
                } else {
                    //TODO The Data Binding and sending to the Feedback & Complaint Database on Server
                    Toast.makeText(getActivity(), "Thank You for your " + spinnerFeedbackType.getSelectedItem().toString() + "! We will act on it shortly!", Toast.LENGTH_LONG).show();

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("Spinner Feedback Type", spinnerFeedbackType.getSelectedItem().toString());
                        jsonObject.put("Description", editTextDescription.getText().toString().trim());
                        jsonObject.put("Brand", Build.BRAND);
                        jsonObject.put("Bootloader", Build.BOOTLOADER);
                        jsonObject.put("Device", Build.DEVICE);
                        jsonObject.put("Display", Build.DISPLAY);
                        jsonObject.put("Board", Build.BOARD);
                        jsonObject.put("Hardware", Build.HARDWARE);
                        jsonObject.put("Host", Build.HOST);
                        jsonObject.put("ID", Build.ID);
                        jsonObject.put("Manufacturer", Build.MANUFACTURER);
                        jsonObject.put("Model", Build.MODEL);
                        jsonObject.put("Product", Build.PRODUCT);
                        jsonObject.put("User", Build.USER);
                        jsonObject.put("Serial Number", Build.SERIAL);
                        jsonObject.put("Time", Build.TIME);
                        jsonObject.put("Unknown Values", Build.UNKNOWN);
                        jsonObject.put("Type", Build.TYPE);
                        jsonObject.put("CPU Usage", readUsage());
                        jsonObject.put("RAM Usage", availableMegs);
                    } catch (JSONException d) {
                        d.printStackTrace();
                    }
                    Log.d("Feedback Data", jsonObject.toString());
                }
            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    //Code for fetching the CPU Usage
    private float readUsage() {
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();

            String[] toks = load.split(" +");  // Split on one or more spaces

            long idle1 = Long.parseLong(toks[4]);
            long cpu1 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[5])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

            try {
                Thread.sleep(360);
            } catch (Exception e) {}

            reader.seek(0);
            load = reader.readLine();
            reader.close();

            toks = load.split(" +");

            long idle2 = Long.parseLong(toks[4]);
            long cpu2 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[5])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

            return (float)(cpu2 - cpu1) / ((cpu2 + idle2) - (cpu1 + idle1));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH){
            return true;
        }
        return false;
    }
}

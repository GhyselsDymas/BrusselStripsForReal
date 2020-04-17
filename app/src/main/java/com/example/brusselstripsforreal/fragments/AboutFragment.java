package com.example.brusselstripsforreal.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brusselstripsforreal.R;
// Seppe Alpaerts
/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private View rootview;
    private TextView textView;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_about, container, false);
        textView = rootview.findViewById(R.id.textView);
        textView.setText("Brussels loves comic strips so much it has invited its heroes to take possession of its walls and gables. Discover all the details and mysteries here! ….  Go ahead and hunt them down, walk the Brussels streets and raise your eyes! A joyful stroll for enthusiasts and the inquisitive from 7 to 77 years of age.  The brochure « Brussels, the comic strip capital » will help you to find all the murals. On sale at the visit.brussels information desks (2.5€).");
        return rootview;
    }
}
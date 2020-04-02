package com.example.brusselstripsforreal.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.brusselstripsforreal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    private ImageView imageViewMap, imageViewList, imageViewAbout, imageViewPreferences;
    public View rootView;

    private View.OnTouchListener mapListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
            int color = bmp.getPixel((int) event.getX(), (int) event.getY());
            if (color == Color.TRANSPARENT)
                return false;
            else {
                Navigation.findNavController(v).navigate(R.id.action_startFragment_to_mapFragment3);
                return true;}
        }
    };

    private View.OnTouchListener listListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
            int color = bmp.getPixel((int) event.getX(), (int) event.getY());
            if (color == Color.TRANSPARENT)
                return false;
            else {
                Navigation.findNavController(v).navigate(R.id.action_startFragment_to_listFragment2);
                return true;}

        }
    };

    private View.OnTouchListener aboutListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
            int color = bmp.getPixel((int) event.getX(), (int) event.getY());
            if (color == Color.TRANSPARENT)
                return false;
            else {
                Navigation.findNavController(v).navigate(R.id.action_startFragment_to_aboutFragment2);
                return true;}

        }
    };

    private View.OnTouchListener preferenceListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
            int color = bmp.getPixel((int) event.getX(), (int) event.getY());
            if (color == Color.TRANSPARENT)
                return false;
            else {

                return true;}

        }
    };

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_start, container, false);

        imageViewMap = rootView.findViewById(R.id.btn_maps);
        imageViewMap.setDrawingCacheEnabled(true);
        imageViewMap.setOnTouchListener(mapListener);

        imageViewList = rootView.findViewById(R.id.btn_list);
        imageViewList.setDrawingCacheEnabled(true);
        imageViewList.setOnTouchListener(listListener);

        imageViewAbout = rootView.findViewById(R.id.btn_about);
        imageViewAbout.setDrawingCacheEnabled(true);
        imageViewAbout.setOnTouchListener(aboutListener);

        imageViewPreferences = rootView.findViewById(R.id.btn_setting);
        imageViewPreferences.setDrawingCacheEnabled(true);
        imageViewPreferences.setOnTouchListener(preferenceListener);

        return rootView;
    }
}

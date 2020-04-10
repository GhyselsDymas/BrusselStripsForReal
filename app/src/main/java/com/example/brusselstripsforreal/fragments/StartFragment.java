package com.example.brusselstripsforreal.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.brusselstripsforreal.DAO.ArtDatabase;
import com.example.brusselstripsforreal.DAO.ComicArtDAO;
import com.example.brusselstripsforreal.R;
import com.example.brusselstripsforreal.model.ArtViewModel;
import com.example.brusselstripsforreal.model.ComicArt;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {


    private ImageView imageViewMap;
    public View rootView;

    private View.OnTouchListener imageListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
            int colorpref = bmp.getPixel((int) event.getX(), (int) event.getY());

            if (colorpref == Color.RED){
                performNav(v,R.id.action_startFragment_to_listFragment2, null );
                return true;
            }

            else if(colorpref == Color.GREEN){
                performNav(v,R.id.action_startFragment_to_settingsFrangment, null );
                return true;
            }

            else if(colorpref == Color.YELLOW){
                performNav(v,R.id.action_startFragment_to_mapFragment3, null );
                return true;
            }

            else if(colorpref == Color.BLUE){
                performNav(v,R.id.action_startFragment_to_aboutFragment2, null );
                return true;
            }

            else {return false;}
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

        imageViewMap = rootView.findViewById(R.id.color_img);
        imageViewMap.setDrawingCacheEnabled(true);
        imageViewMap.setOnTouchListener(imageListener);



        return rootView;
    }

    public void performNav(View v, int id, Bundle data) {
        try {
            Navigation.findNavController(v).navigate(id, data);
        }catch (Exception e) {
            Log.e("Navigation", "navigatie crash, TODO");
            Log.e("Navigation", e.getMessage());
        }
    }
}

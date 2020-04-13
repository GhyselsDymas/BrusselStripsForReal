package com.example.brusselstripsforreal.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brusselstripsforreal.DAO.ArtDatabase;
import com.example.brusselstripsforreal.R;
import com.example.brusselstripsforreal.model.ArtViewModel;
import com.example.brusselstripsforreal.model.ComicArt;
import com.example.brusselstripsforreal.util.ComicAdapter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {
    private MapView mapView;
    private GoogleMap myMap;
    private View rootview;
    private ComicAdapter adapter;
    private AppCompatActivity context;
    private ArtViewModel artViewModel;

    private OnMapReadyCallback onMapReady = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            myMap = googleMap;

            LatLng coordBrussel = new LatLng(50.858712, 4.347446);

            myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            CameraUpdate moveToBrussel = CameraUpdateFactory.newLatLngZoom(coordBrussel, 16);
            myMap.animateCamera(moveToBrussel);

            drawMarkers();

        }
    };

    //stackoverflow

     private void drawMarkers(){
         myMap.addMarker(new MarkerOptions()
                 .position(new LatLng(50.858712, 4.347446))
                 .title("Kaaitheater")
                 .snippet("Dit is een theater"));}

       /**  ArtViewModel model = new ViewModelProvider(context).get(ArtViewModel.class);
         model.getComicArt().observe(context, new Observer<List<ComicArt>>() {
             @Override
             public void onChanged(List<ComicArt> comicArts) {
                 for (ComicArt comicArt : comicArts) {
                     String[] latLng = comicArt.getCoordinate().split(",");
                     double longitude = Double.parseDouble(latLng[0]);
                     double latitude = Double.parseDouble(latLng[1]);
                     //stond omgekeerd in de api

                     Marker m = myMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)));

                     m.setTitle(comicArt.getArtTitle());
                     m.setSnippet(comicArt.getArtAuthor());
                     m.setTag(comicArt);
                 }
             }
         });
    }*/





    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_map, container, false);

        mapView = rootview.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(onMapReady);


        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}


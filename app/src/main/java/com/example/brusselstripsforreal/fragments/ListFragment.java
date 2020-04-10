package com.example.brusselstripsforreal.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brusselstripsforreal.R;
import com.example.brusselstripsforreal.model.ArtViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    public ListFragment() {

    }

   // private ComicAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView rvArt  = rootView.findViewById(R.id.comicArt_rv);

        rvArt.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

      //  adapter = new ComicAdapter(getActivity());
      //  rvArt.setAdapter(adapter);

        ArtViewModel model = new ViewModelProvider(this).get(ArtViewModel.class);
        Log.d("DATA", ""+model.getAllArt().size());

        return rootView;

    }


}

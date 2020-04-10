package com.example.brusselstripsforreal.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brusselstripsforreal.R;
import com.example.brusselstripsforreal.model.ArtViewModel;
import com.example.brusselstripsforreal.model.ComicArt;
import com.example.brusselstripsforreal.util.ComicAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private AppCompatActivity context;

    public ListFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = (AppCompatActivity) context;
    }

    private ComicAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView rvArt  = rootView.findViewById(R.id.comicArt_rv);

        rvArt.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        adapter = new ComicAdapter(getActivity());
        rvArt.setAdapter(adapter);

        ArtViewModel model = new ViewModelProvider(context).get(ArtViewModel.class);
        model.getComicArt().observe(context, new Observer<List<ComicArt>>() {
            @Override
            public void onChanged(List<ComicArt> comicArts) {
                //TODO pass list to adapter
                adapter.notifyDataSetChanged();
            }
        });


        return rootView;

    }


}

package com.example.brusselstripsforreal.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brusselstripsforreal.R;
import com.example.brusselstripsforreal.model.ComicArt;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView titleTv, authorTV;
    private ImageView photoIv;
    private FragmentActivity mContext;
    private ComicArt selectedComicArt;
    private Bundle data;
    public DetailFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity) context;
    }

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

       titleTv = rootView.findViewById(R.id.title_detail_tv);
       authorTV = rootView.findViewById(R.id.author_details_tv);
       photoIv = rootView.findViewById(R.id.details_iv);

        if(selectedComicArt != null){

            titleTv.setText(selectedComicArt.getArtTitle());
            authorTV.setText(selectedComicArt.getArtAuthor());

            Picasso.get().load("https://opendata.brussel.be/explore/dataset/comic-book-route/files/"+selectedComicArt.getComicArtId()+"/300").into(photoIv);
        }

    return rootView;
    }
}


























// selectedComicArt = (ComicArt) data.getSerializable("passedComicArt");

// public static DetailFragment newInstance(Bundle artData) {
//  DetailFragment detailFragment = new DetailFragment();
//   detailFragment.setArguments(artData);
//   return detailFragment;

// }


// Bundle data = getArguments();


//  public boolean selectedComicArt(){
//   data = getArguments();
//     if (data != null){
//        if (data.containsKey("passedComicArt")){
//           return true;
//        }
//        }
//    return false;
// }
//
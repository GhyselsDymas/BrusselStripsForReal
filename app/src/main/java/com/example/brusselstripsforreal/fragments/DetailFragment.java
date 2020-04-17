package com.example.brusselstripsforreal.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brusselstripsforreal.R;
import com.example.brusselstripsforreal.model.ComicArt;
import com.squareup.picasso.Picasso;

//Author: Jochem Petit
/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView titleTv, authorTV, yearTV;
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
        selectedComicArt = (ComicArt) getArguments().getSerializable("passedComicArt");

       titleTv = rootView.findViewById(R.id.title_detail_tv);
       authorTV = rootView.findViewById(R.id.author_details_tv);
       photoIv = rootView.findViewById(R.id.detail_iv);
       yearTV =  rootView.findViewById(+ R.id.year_detail_tv);


        if(selectedComicArt != null){

            titleTv.setText(selectedComicArt.getArtTitle());
            authorTV.setText(selectedComicArt.getArtAuthor());
            yearTV.setText("Created in : "+selectedComicArt.getArtAnnee());

            Log.d("Image", selectedComicArt.getImageURL());

            Picasso.get()
                    .load("https://opendata.brussel.be/explore/dataset/striproute0/files/"+selectedComicArt.getImageURL()+"/download")
                    .centerCrop()
                    .resize(200, 200)
                    .into(photoIv);
            //https://opendata.brussel.be/explore/dataset/striproute0/files/109079c2f860b91d84cf463f1ff9a8535a0b7f0a/download
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
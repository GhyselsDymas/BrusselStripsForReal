 package com.example.brusselstripsforreal.util;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import com.example.brusselstripsforreal.R;
import com.example.brusselstripsforreal.model.ComicArt;

import java.util.ArrayList;
import java.util.List;

 public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {


    public class ComicViewHolder extends RecyclerView.ViewHolder {
        final TextView tvArtTitle, tvArtAuthor;
        final ImageView ivArt;
        final View.OnClickListener ArtDetailListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                Bundle data = new Bundle();
                data.putSerializable("passedComicArt", items.get(position));
                Navigation.findNavController(view).navigate(R.id.action_listFragment_to_detailFragment, data);
            }
        };

        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvArtTitle = itemView.findViewById(R.id.art_title_tv);
            tvArtAuthor = itemView.findViewById(R.id.art_author_tv);
            ivArt = itemView.findViewById(R.id.art_iv);
        }
    }
    private  ArrayList<ComicArt> itemsComics;
    private ArrayList<ComicArt> items;

    public ComicAdapter (FragmentActivity fragmentActivity) {
        itemsComics = new ArrayList<>();
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
       Context context = parent.getContext();
     LayoutInflater layoutInflater = LayoutInflater.from(context);
    View card = layoutInflater.inflate(R.layout.comic_art_card, parent, false);
      return new ComicViewHolder(card);
}

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        //TODO Rijen opvullen
        ComicArt c = items.get(position);
        holder.tvArtAuthor.setText(c.getArtAuthor());
        holder.tvArtTitle.setText(c.getArtTitle());
       // holder.ivArt.setImageU();
        //Picasso.get().load("https://opendata.brussel.be/explore/dataset/striproute0/files/"+c.getImageURL()+"/download").into(holder.ivArt);
    }


    @Override
    public int getItemCount(){
        int ComicArtSize = items.size();
        return  ComicArtSize;
}
    public ComicAdapter(){
        items = new ArrayList<>();
    }
    public void addItems(List<ComicArt> comicart ){
        items.clear();
        items.addAll(comicart);

    }

}



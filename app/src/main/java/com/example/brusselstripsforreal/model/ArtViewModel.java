package com.example.brusselstripsforreal.model;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.brusselstripsforreal.DAO.ArtDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//Author: Dymas Ghysels & Jochem Petit
public class ArtViewModel extends AndroidViewModel {

    public ExecutorService threadExecutor= Executors.newFixedThreadPool(4);
    Context context;

    public ArtViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }

    public LiveData<List<ComicArt>> getComicArt() {
        fetchart();
        return ArtDatabase.getSharedInstance(getApplication()).comicArtDAO().getAllComicArt();
    }

    public void insertAllArt(ComicArt comicArt) {
        ArtDatabase.getSharedInstance(getApplication()).comicArtDAO().insertComicArt(comicArt);
    }

    public void updateAllArt(ComicArt comicArt) {
        ArtDatabase.getSharedInstance(getApplication()).comicArtDAO().updateComicArt(comicArt);
    }
    public ComicArt findArtById(String id) {
        return ArtDatabase.getSharedInstance(getApplication()).comicArtDAO().findById(id);
    }


    private void fetchart() {
        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://bruxellesdata.opendatasoft.com/api/records/1.0/search/?dataset=comic-book-route&rows=58")
                        .get()
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    String artData = response.body().string();
                    JSONObject rawData = new JSONObject(artData);
                    JSONArray jsonArray = rawData.getJSONArray("records");

                    int arraySize = jsonArray.length();
                    int i = 0;

                    while (i < arraySize){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        JSONObject fields = jsonObject.getJSONObject("fields");
                        JSONObject geometry = jsonObject.getJSONObject("geometry");
                        JSONObject photo = (fields.has("photo"))?fields.getJSONObject("photo"):new JSONObject();


                        ComicArt currentArt = new ComicArt(
                                (photo.has("id"))?photo.getString("id"):"unknown",
                                (fields.has("personnage_s"))?fields.getString("personnage_s"):"unknown",
                                (fields.has("auteur_s"))?fields.getString("auteur_s"):"unknown",
                                (geometry.has("coordinates"))?geometry.getString("coordinates"):"unknown",
                                (jsonObject.has("recordid"))?jsonObject.getString("recordid"):"unknown",
                                (fields.has("annee"))?fields.getString("annee"):"unknown"


                        );

                        if(ArtDatabase.getSharedInstance(getApplication()).comicArtDAO().findById(currentArt.getComicArtId()) == null)
                            insertAllArt(currentArt);
                        i++;
                    }


                } catch (IOException e) {
                    e.printStackTrace();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

package com.example.brusselstripsforreal.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ArtViewModel extends AndroidViewModel {
    private MutableLiveData<ComicArt> comicArtList;
    public ExecutorService threadExecutor= Executors.newFixedThreadPool(4);

    public ArtViewModel(@NonNull Application application) {
        super(application);
        this.comicArtList = new MutableLiveData<>();
    }
    public MutableLiveData<ComicArt> getComicArtList() {
        fetchart();
        return comicArtList;
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
                        JSONObject photo = fields.getJSONObject("photo");

                        //TODO moet overeenkomen met JSON
                        ComicArt currentArt = new ComicArt(
                                (photo.has("id"))?photo.getString("id"):"unknown",
                                (fields.has("personnage_s"))?fields.getString("personnage_s"):"unknown",
                                (fields.has("auteur_s"))?fields.getString("auteur_s"):"unknown",
                                (geometry.has("coordinates"))?geometry.getString("coordinates"):"unknown",
                                (jsonObject.has("recordid"))?jsonObject.getString("recordid"):"unknown"
                        );

                        //TODO insert in database

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

package com.example.brusselstripsforreal.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//TODO Extend AndroidViewModel instead
public class ArtViewModel extends ViewModel {
    private MutableLiveData<ComicArt> comicArtList;
    public ExecutorService threadExecutor= Executors.newFixedThreadPool(4);

    public ArtViewModel(){this.comicArtList = new MutableLiveData<>();
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

                        //TODO moet overeenkomen met JSON
                        ComicArt currentArt = new ComicArt(
                                jsonObject.getString("Photo"),
                                (fields.has("personnage_s"))?fields.getString("personnage_s"):"unknown",
                                jsonObject.getString("Author_s"),
                                jsonObject.getString("Geocoordinates")
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

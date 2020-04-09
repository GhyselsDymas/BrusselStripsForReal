package com.example.brusselstripsforreal.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version = 1, entities = {ComicArt.class}, exportSchema = false)
public abstract class ArtDatabase extends RoomDatabase {

    private static final String DB_NAME = "artDatabase.db";
    private static ArtDatabase instance;
    //static final ExecutorService databasewriteExecutor =
            //Executors.newFixedThreadPool(4);

    public static ArtDatabase getInstance(Context context){
        if(instance == null) {
            instance = create(context);
        }return instance;
    }
    //allowmainThreadqueries is enkel om te testen, vana
    private static ArtDatabase create( final Context context) {
        return Room.databaseBuilder(context, ArtDatabase.class,DB_NAME).allowMainThreadQueries().build();

    }
    //public abstract ArtDao getRepoDao
}
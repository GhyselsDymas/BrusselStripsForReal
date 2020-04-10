package com.example.brusselstripsforreal.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.brusselstripsforreal.model.ComicArt;

import java.util.List;

@Dao
public interface ComicArtDAO {

    @Insert
    void insertComicArt(ComicArt comicart);

    @Update
    void updateComicArt(ComicArt comicArt);

    @Query("SELECT * FROM ComicArt")
    List<ComicArt> getAllComicArt();

    @Query("SELECT * FROM ComicArt WHERE id LIKE :id")
    ComicArt findById(String id);
}

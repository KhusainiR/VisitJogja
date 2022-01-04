package com.example.visitapp.database.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.visitapp.database.dao.UlasanDao;
import com.example.visitapp.database.dao.WisataDao;
import com.example.visitapp.database.entity.Ulasan;
import com.example.visitapp.database.entity.Wisata;

@Database(entities = {Wisata.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WisataDao userDao();
}

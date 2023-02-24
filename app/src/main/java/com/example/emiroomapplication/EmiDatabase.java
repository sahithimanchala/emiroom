package com.example.emiroomapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = EmiEntity.class,version = 1,exportSchema = false)
public abstract class EmiDatabase extends RoomDatabase {
    public abstract EmiDao emiDao();
}

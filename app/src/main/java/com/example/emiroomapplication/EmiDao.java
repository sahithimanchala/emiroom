package com.example.emiroomapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmiDao {
    @Insert
    public void insert(EmiEntity emiEntity);
    @Update
    public void update(EmiEntity emiEntity);
    @Delete
    public void delete(EmiEntity emiEntity);
    @Query("select * from emientity")
    public List<EmiEntity>fetchdata();

}

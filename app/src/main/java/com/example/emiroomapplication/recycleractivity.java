package com.example.emiroomapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class recycleractivity extends AppCompatActivity {
    RecyclerView recyclerView;
    static EmiDatabase database;
    FAdapter adapter;
    EmiEntity entity;
    List<EmiEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleractivity);
        recyclerView=findViewById(R.id.re);
        database= Room.databaseBuilder(this,EmiDatabase.class,"rdb").allowMainThreadQueries().build();
        list = database.emiDao().fetchdata();
        adapter = new FAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
     }
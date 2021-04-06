package com.example.navigationtest.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.navigationtest.model.data_model;

@Database(entities = data_model.class , version = 1 , exportSchema = false)
public abstract class person_info extends RoomDatabase {
    public abstract dbDao dbdao();
    public static person_info info;

    public static person_info getInstance(Context context){
        if (info == null){
            info = Room.databaseBuilder(context.getApplicationContext() , person_info.class , "main_dataBase").build();
        }
        return info;
    }

}

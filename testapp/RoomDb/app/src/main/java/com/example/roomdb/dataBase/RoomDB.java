package com.example.roomdb.dataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdb.model.RoomColumn;

@Database(entities = RoomColumn.class , version = 1 , exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public static RoomDB roomDB;
    public static RoomDB getInstance(Context context){
        if (roomDB == null){
            roomDB = Room.databaseBuilder(context.getApplicationContext() , RoomDB.class , "DataBaseAhmad").build();
        }
        return roomDB;
    }
}

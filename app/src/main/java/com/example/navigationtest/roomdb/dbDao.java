package com.example.navigationtest.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.navigationtest.model.data_model;

@Dao
public interface dbDao {

    @Query("SELECT * FROM data_model")
    LiveData<data_model> getallInformaion();

    @Insert
    void insert_data(data_model data);

    @Update
    void Update_data(data_model data);

    @Delete
    void Delete_data(data_model data);


}

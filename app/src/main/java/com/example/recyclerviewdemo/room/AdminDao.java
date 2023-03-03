package com.example.recyclerviewdemo.room;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.recyclerviewdemo.models.Admin;

@Dao
public interface AdminDao {
    @Insert
    void add(Admin adminDao);

    // DB Connection->Dao-Model-> DB Access
}

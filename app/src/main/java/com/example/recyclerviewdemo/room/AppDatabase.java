package com.example.recyclerviewdemo.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recyclerviewdemo.models.Admin;
import com.example.recyclerviewdemo.models.User;


@Database(entities = {User.class, Admin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract AdminDao adminDao();

}



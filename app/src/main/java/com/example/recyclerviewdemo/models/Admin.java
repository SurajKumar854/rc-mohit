package com.example.recyclerviewdemo.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class Admin {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name, password;

}

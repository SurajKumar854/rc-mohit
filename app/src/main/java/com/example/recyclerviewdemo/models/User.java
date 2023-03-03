package com.example.recyclerviewdemo.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String age;
    public String password;

    public User() {

    }

    public User(String name, String age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

}


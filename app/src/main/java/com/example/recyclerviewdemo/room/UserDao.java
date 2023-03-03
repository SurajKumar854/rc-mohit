package com.example.recyclerviewdemo.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.recyclerviewdemo.models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select * from User")
    List<User> getUserList();

    @Query("select * from User where name =:user_name")
    List<User> findUser(String user_name);

    @Query("delete from User where name =:user_name")
    void deleteUser(String user_name);

    @Query("select * from User where name =:name AND password=:password")
    List<User> loginUser(String name, String password);


}

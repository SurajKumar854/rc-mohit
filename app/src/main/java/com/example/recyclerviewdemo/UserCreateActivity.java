package com.example.recyclerviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.recyclerviewdemo.models.Admin;
import com.example.recyclerviewdemo.room.AdminDao;
import com.example.recyclerviewdemo.room.AppDatabase;


public class UserCreateActivity extends AppCompatActivity{

    AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_create);
        appDatabase = Room.databaseBuilder(UserCreateActivity.this, AppDatabase.class, "room_db").allowMainThreadQueries().build();


        EditText name = findViewById(R.id.name);
        EditText pass = findViewById(R.id.password);
        Button send = findViewById(R.id.send);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Admin admin = new Admin();
                admin.name = name.getText().toString();
                admin.password = pass.getText().toString();
                appDatabase.adminDao().add(admin);

            }
        });


    }

}
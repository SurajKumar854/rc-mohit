package com.example.recyclerviewdemo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.adapters.UsersAdapter;
import com.example.recyclerviewdemo.models.User;
import com.example.recyclerviewdemo.room.AppDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<User> usersList;
    UsersAdapter usersAdapter;
    EditText nameEdt, ageEdt, passwordEdt;
    Button addUserBtn, deleteUserBtn, findUser, login;

    AppDatabase app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersList = new ArrayList<>();
        recyclerView = findViewById(R.id.rvlist);
        nameEdt = findViewById(R.id.edtName);
        ageEdt = findViewById(R.id.edtAge);
        passwordEdt = findViewById(R.id.edtPassword);
        addUserBtn = findViewById(R.id.addUser);
        deleteUserBtn = findViewById(R.id.delete);
        findUser = findViewById(R.id.find);
        login = findViewById(R.id.login);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        app = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_db").allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();


        usersList = (ArrayList<User>) app.userDao().getUserList();

        usersAdapter = new UsersAdapter(this, usersList);
        recyclerView.setAdapter(usersAdapter);


        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nameEdt.getText().toString().isEmpty() && !ageEdt.getText().toString().isEmpty()) {

                    String userNameStr = nameEdt.getText().toString();
                    String ageStr = ageEdt.getText().toString();
                    String password = passwordEdt.getText().toString();
                    app.userDao().insertUser(new User(userNameStr, ageStr, password));
                    usersList.clear();
                    usersList.addAll((ArrayList<User>) app.userDao().getUserList());
                    // usersList.add(new User(userNameStr, ageStr));
                    usersAdapter.notifyDataSetChanged();
                }
            }
        });

        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameStr = nameEdt.getText().toString();
                app.userDao().deleteUser(userNameStr);
                usersList.clear();
                usersList.addAll((ArrayList<User>) app.userDao().getUserList());

                usersAdapter.notifyDataSetChanged();

            }
        });

        findUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameStr = nameEdt.getText().toString();

                usersList.clear();
                usersList.addAll((ArrayList<User>) app.userDao().findUser(userNameStr));
                usersAdapter.notifyDataSetChanged();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameStr = nameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                boolean isUserExist = app.userDao().loginUser(userNameStr, password).isEmpty();
                if (!isUserExist) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    // Hello
    // Hello Suraj mohit
    //Message from Suraj
}
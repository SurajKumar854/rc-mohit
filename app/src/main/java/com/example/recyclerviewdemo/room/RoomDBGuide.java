package com.example.recyclerviewdemo.room;

public class RoomDBGuide {

    /*
    0. add  def room_version = "2.5.0"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"

    in dependencies{} => app build gradle module level

    1. Create an Entity{ it represent table, columns } by using @Entity in the top of your model class then it will get convert into table with columns
    2. Create DAO interface Class that will include Create | Update || Read| Delete methods
    3. Create DataBase  abstract class that will inherit Room DatabaseClass their you will your DAO Abstract functions
    4. Call Database Connection by using method databaseBuilder(context, Yourdatabase.class,"db_name").allowMainThreadQueries().build();
    5. Rest class your dao function from database object and perform your relevant functions




     */
}

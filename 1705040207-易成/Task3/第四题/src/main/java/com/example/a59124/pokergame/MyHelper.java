package com.example.a59124.pokergame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 59124 on 2019/10/7.
 */

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){
        super(context, "yicheng1.db", null, 2);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE infor(id integer primary key autoincrement, type1 varchar(20), point1 varchar(20), type2 varchar(20), point2 varchar(20), type3 varchar(20), point3 varchar(20),type4 varchar(20), point4 varchar(20), type5 varchar(20), point5 varchar(20), type6 varchar(20), point6 varchar(20), pointA1 INTEGER, pointA2 INTEGER, pointA3 INTEGER, pointB1 INTEGER, pointB2 INTEGER, pointB3 INTEGER)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
}

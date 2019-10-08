package com.example.a59124.wageadjustmentsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 59124 on 2019/10/5.
 */

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){
        super(context, "yicheng.db", null, 1);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE information(id integer primary key autoincrement, name varchar(20), now_wage varchar(20), family_num varchar(20), work_year varchar(20), future_wage varchar(20))");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
}

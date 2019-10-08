package com.example.a59124.wageadjustmentsystem;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Query_PI extends AppCompatActivity {
    MyHelper myHelper =  new MyHelper(this);
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query__pi);

        TextView tv_show = (TextView) findViewById(R.id.show_datas);
        db = myHelper.getReadableDatabase();
        Cursor cursor = db.query("information", null, null, null, null, null, null);
        if (cursor.getCount() == 0){
            tv_show.setText("");
            Toast.makeText(this, "There is no data at present, please add teacher's information first!", Toast.LENGTH_SHORT).show();
        }else{
            cursor.moveToFirst();
            tv_show.setText(cursor.getString(0)+ "    " + cursor.getString(1)+ "          " + cursor.getString(2)+ "                              " + cursor.getString(3)+ "                              " +cursor.getString(4));
        }

        while (cursor.moveToNext()) {
            tv_show.append("\n" + cursor.getString(0)+ "    " + cursor.getString(1)+ "          " + cursor.getString(2)+ "                              " + cursor.getString(3)+ "                              " +cursor.getString(4));
        }
        cursor.close();
        db.close();
    }
}

package com.example.a59124.wageadjustmentsystem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_PI extends AppCompatActivity {
    MyHelper myHelper =  new MyHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__pi);
        Intent intent = getIntent();
        Button bt_add = (Button) findViewById(R.id.bt_add);
        final EditText edt_name = (EditText) findViewById(R.id.edt_name);
        final EditText edt_nowwage = (EditText) findViewById(R.id.edt_now_wage);
        final EditText edt_supportnumber = (EditText) findViewById(R.id.edt_supportnumber);
        final EditText edt_workyears = (EditText) findViewById(R.id.edt_workyears);

        bt_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = edt_name.getText().toString();
                String n_wage = edt_nowwage.getText().toString();
                String s_number = edt_supportnumber.getText().toString();
                String w_year = edt_workyears.getText().toString();
                addSomething(name, n_wage, s_number, w_year);
            }
        });
    }

    public void addSomething(String name, String now_wage, String support_num, String work_years){
        SQLiteDatabase db;
        ContentValues values;
        db =  myHelper.getWritableDatabase();
        values = new ContentValues();
        values.put("name", name);
        values.put("now_wage", now_wage);
        values.put("family_num",support_num);
        values.put("work_year", work_years);
        //values.put("future_wage", "-");
        db.insert("information", null, values);
        Toast.makeText(this, "Add information successful!", Toast.LENGTH_SHORT).show();
        db.close();
    }
}

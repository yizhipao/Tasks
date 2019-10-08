package com.example.a59124.wageadjustmentsystem;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mAdd  = (Button) findViewById(R.id.add_infor);
        Button mQuery = (Button) findViewById(R.id.query);
        Button mUpdate = (Button) findViewById(R.id.update);

        mAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, add_PI.class);
                startActivity(intent);
            }
        });

        mQuery.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Query_PI.class);
                startActivity(intent);
            }
        });

        mUpdate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Update_PI.class);
                startActivity(intent);
            }
        });
    }
}


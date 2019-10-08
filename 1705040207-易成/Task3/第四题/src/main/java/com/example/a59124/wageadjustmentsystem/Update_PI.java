package com.example.a59124.wageadjustmentsystem;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Update_PI extends AppCompatActivity {
    MyHelper myHelper =  new MyHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__pi);
        TextView tv_updated = (TextView) findViewById(R.id.show_updateddatas);

        SQLiteDatabase db = myHelper.getWritableDatabase();
        Cursor cursor = db.query("information", null, null, null, null, null, null);

        if (cursor.getCount() == 0){
            Toast.makeText(this, "There is no data at present, please add teacher's information first!", Toast.LENGTH_SHORT).show();
        }else{
            cursor.moveToFirst();
            int now_wage = transform(cursor.getString(2));
            int family_number = transform((cursor.getString(3)));
            int working_years = transform(cursor.getString(4));
            int updatedatas = updatedssalary(now_wage, family_number, working_years);
            Integer temp1 = updatedatas;
            String updates1 = temp1.toString();
            db.execSQL("update information set future_wage = ? where id = ?", new Object[]{updates1, cursor.getString(0)});
            tv_updated.setText(cursor.getString(0)+ "        " + cursor.getString(1)+ "              " + cursor.getString(2)+ "                                    " + updates1);
        }

        while (cursor.moveToNext()) {
            int now_wage = transform(cursor.getString(2));
            int family_number = transform((cursor.getString(3)));
            int working_years = transform(cursor.getString(4));
            int updatedatas = updatedssalary(now_wage, family_number, working_years);
            Integer temp2 = updatedatas;
            String updates2 = temp2.toString();
            db.execSQL("update information set future_wage = ? where id = ?", new Object[]{updates2, cursor.getString(0)});
            tv_updated.append("\n" + cursor.getString(0)+ "        " + cursor.getString(1)+ "              " + cursor.getString(2)+ "                                    " + updates2);
        }
        cursor.close();
        db.close();
    }

    public int transform(String str){
        int number;
        number = Integer.parseInt(str);
        return number;
    }

    public int updatedssalary(int n_wage, int f_number, int w_years){
        int updated;
        if(n_wage < 26000){
            if(f_number > 0 || w_years >= 1){
                updated = n_wage + f_number*100 + w_years * 50;
                if(updated > 26000){
                    updated = 26000;
                }
            }else{
                updated = n_wage;
            }
        }else{
            updated = n_wage;
        }
        return updated;
    }
}

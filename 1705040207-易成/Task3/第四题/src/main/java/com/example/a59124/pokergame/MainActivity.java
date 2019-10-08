package com.example.a59124.pokergame;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private EditText edt_number;
    private int number;
    private Button ensure;

    MyHelper myHelper =  new MyHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start_game);
        ensure = (Button) findViewById(R.id.ensure);
        edt_number = (EditText) findViewById(R.id.number_of_games);



       ensure.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str = edt_number.getText().toString();
                if(str.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter all information to calculate! ", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!(isNumber(str.trim()))){
                    Toast.makeText(MainActivity.this, "Please enter a valid number! ", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    number = Integer.parseInt(edt_number.getText().toString().trim());
                }

                for(int i=0; i<number; i++) {

                    String typesA[] = new String[3];
                    int pointsA[] = new int[3];
                    String pA[] = new String[3];
                    String typesB[] = new String[3];
                    int pointsB[] = new int[3];
                    String pB[] = new String[3];


                    typesA = gen_types();
                    pointsA = gen_points();
                    pA = gen_temppoint(pointsA);

                    typesB = gen_types();
                    pointsB = gen_points();
                    pB = gen_temppoint(pointsB);


                    Toast.makeText(MainActivity.this, "Succesfully!", Toast.LENGTH_SHORT).show();

                    addSomething(typesA, pA, pointsA, typesB, pB, pointsB);
                }


                    //addSomething("字符","6",6, "字符","6",6, "字符","6",6, "字符","6",6, "字符","6",6, "字符","6",6);

                    //addSomething(typesA[0], pA[0], pointsA[0],typesA[1], pA[1], pointsA[1],typesA[2], pA[2], pointsA[2], typesB[0], pB[0], pointsB[0],typesB[1], pB[1], pointsB[1], typesB[2], pB[2], pointsB[2] );

            }
        });


        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent  = new Intent(MainActivity.this, GameInterface.class);
                Bundle bundle = new Bundle();
                bundle.putInt("game_numbers", number);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    public void addSomething(String typeA[], String PA[], int pointA[],  String typeB[], String PB[], int pointB[]){
    //public void addSomething(String type1, String point1, int pointA1, String type2, String point2, int pointA2, String type3, String point3, int pointA3, String type4, String point4, int pointB1,String type5, String point5, int pointB2,String type6, String point6, int pointB3){
        SQLiteDatabase db;
        ContentValues values;
        int count = 0;
        count++;
        db =  myHelper.getWritableDatabase();
        db.execSQL("insert into infor(type1,point1,pointA1,type2,point2,pointA2,type3,point3,pointA3,type4,point4,pointB1,type5,point5,pointB2,type6,point6,pointB3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{typeA[0],PA[0],pointA[0],typeA[1],PA[1],pointA[1],typeA[2],PA[2],pointA[2],typeB[0],PB[0],pointB[0],typeB[1],PB[1],pointB[1],typeB[2],PB[2],pointB[2]});
        /*values = new ContentValues();
        values.put("type1",typeA[0]);
        values.put("point1",PA[0]);
        values.put("pointA1",pointA[0]);
        values.put("type2",typeA[1]);
        values.put("point2",PA[1]);
        values.put("pointA2",pointA[1]);
        values.put("type3",typeA[2]);
        values.put("point3",PA[2]);
        values.put("pointA3",pointA[2]);
        values.put("type4",typeB[0]);
        values.put("point4",PB[0]);
        values.put("pointB1",pointB[0]);
        values.put("type5",typeB[1]);
        values.put("point5",PB[1]);
        values.put("pointB2",pointB[1]);
        values.put("type6",typeB[2]);
        values.put("point6",PB[2]);
        values.put("pointB3",pointB[2]);
        db.insert("infor", null, values);**/

            db.close();


    }

    public String[] gen_types() {
        String temp_types[] = new String[3];
        String type[] = {"方块", "梅花", "红桃", "黑桃"};
        for (int i = 0; i < 3; i++) {
            int ran_num = genRandom();
            temp_types[i] = type[ran_num / 13];
        }
        return temp_types;
    }

    public int[] gen_points() {
        int temp_points[] = new int[3];
        int points[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        for (int i = 0; i < 3; i++) {
            int ran_num = genRandom();
            temp_points[i] = points[ran_num % 13];
        }
        return temp_points;
    }

    public String[] gen_temppoint(int [] args){
        String trans_point[] = new String[3];
        String t_point[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A"};
        for(int i=0; i<3; i++){
            trans_point[i] = t_point[args[i]];
        }
        return trans_point;
    }

    public int genRandom() {
        int n = 51;
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int randInt = 0;
        do {
            randInt = rand.nextInt(n);
        } while (bool[randInt]);
        bool[randInt] = true;
        return randInt;
    }
}

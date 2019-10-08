package com.example.a59124.pokergame;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import java.util.logging.LogRecord;

import static java.sql.Types.NULL;


public class GameInterface extends AppCompatActivity {
    public int number_of_games;
    private TextView tv_result1;
    private TextView tv_result2;
    private TextView tv_card1;
    private TextView tv_card2;
    private TextView tv_card3;
    private TextView tv_card4;
    private TextView tv_card5;
    private TextView tv_card6;
    private Button bt_update;
    private Handler handler;
    private Intent intent;
    private Bundle bundle;

    MyHelper myHelper = new MyHelper(this);
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_interface);

        intent = this.getIntent();
        bundle = intent.getExtras();
        number_of_games = bundle.getInt("game_numbers");


        tv_result1 = (TextView) findViewById(R.id.result1);
        tv_result2 = (TextView) findViewById(R.id.result2);
        tv_card1 = (TextView) findViewById(R.id.card1);
        tv_card2 = (TextView) findViewById(R.id.card2);
        tv_card3 = (TextView) findViewById(R.id.card3);
        tv_card4 = (TextView) findViewById(R.id.card4);
        tv_card5 = (TextView) findViewById(R.id.card5);
        tv_card6 = (TextView) findViewById(R.id.card6);
        bt_update = (Button) findViewById(R.id.update);
        //handler  = new MyHandler();
        bt_update = (Button) findViewById(R.id.update);
        bt_update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //new Thread(new MyThread()).start();
                db = myHelper.getReadableDatabase();
                Cursor cursor = db.query("infor", null, null, null, null, null, null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(GameInterface.this, "Please start the game!", Toast.LENGTH_SHORT).show();
                }
                if( cursor.moveToNext()){
                    tv_card1.setText(cursor.getString(1) + cursor.getString(2));
                    tv_card2.setText(cursor.getString(3) + cursor.getString(4));
                    tv_card3.setText(cursor.getString(5) + cursor.getString(6));
                    tv_card4.setText(cursor.getString(7) + cursor.getString(8));
                    tv_card5.setText(cursor.getString(9) + cursor.getString(10));
                    tv_card6.setText(cursor.getString(11) + cursor.getString(12));


                    String typesA[] = {cursor.getString(1), cursor.getString(3),cursor.getString(5)};
                    int pointsA[] = {cursor.getInt(13),cursor.getInt(14), cursor.getInt(15)};
                    String typesB[] = {cursor.getString(7), cursor.getString(9), cursor.getString(11)};
                    int pointsB[] = {cursor.getInt(16),cursor.getInt(17), cursor.getInt(18)};

                    int levelA = judgement(typesA, pointsA);
                    int levelB = judgement(typesB, pointsB);
                    result(levelA, levelB, pointsA, pointsB);
                }
                cursor.close();
                db.close();
            }
        });
    }


    public int judgement(String[] type, int[] point) {
        int level = 0;
        if ((type[0] == type[1]) && (type[1] == type[2])) {
            level = 5;
        } else if (max(point) - min(point) == 2) {
            level = 4;
        } else if ((point[0] == point[1]) && (point[1] == point[2])) {
            level = 3;
        } else if ((point[0] == point[1]) || (point[1] == point[2]) || point[2] == point[0]) {
            level = 2;
        } else {
            level = 1;
        }
        return level;
    }

    public int max(int args[]) {
        Arrays.sort(args);
        return args[2];
    }

    public int min(int args[]) {
        Arrays.sort(args);
        return args[0];
    }

    public void result(int levelA, int levelB, int pointA[], int pointB[]) {
        int kind1 = 0;
        int kind2 = 0;
        int kind3 = 0;
        int kind4 = 0;
        int kind5 = 0;
        int kind6 = 0;
        int count = 0;
        count++;
        if (levelA > levelB) {
            switch (levelA) {
                case 5:
                    tv_result1.setText("本局结果为A赢，赢牌类型为同花");
                    kind1 += 1;
                    break;
                case 4:
                    tv_result1.setText("本局结果为A赢，赢牌类型为顺子");
                    kind2 += 1;
                    break;
                case 3:
                    tv_result1.setText("本局结果为A赢，赢牌类型为同点");
                    kind3 += 1;
                    break;
                case 2:
                    tv_result1.setText("本局结果为A赢，赢牌类型为对子");
                    kind4 += 1;
                    break;
                case 1:
                    tv_result1.setText("本局结果为A赢，赢牌类型为杂牌");
                    kind5 += 1;
                    break;
            }
        } else if (levelA < levelB) {
            switch (levelB) {
                case 5:
                    tv_result1.setText("本局结果为B赢，赢牌类型为同花");
                    kind1 += 1;
                    break;
                case 4:
                    tv_result1.setText("本局结果为B赢，赢牌类型为顺子");
                    kind2 += 1;
                    break;
                case 3:
                    tv_result1.setText("本局结果为B赢，赢牌类型为同点");
                    kind3 += 1;
                    break;
                case 2:
                    tv_result1.setText("本局结果为B赢，赢牌类型为对子");
                    kind4 += 1;
                    break;
                case 1:
                    tv_result1.setText("本局结果为B赢，赢牌类型为杂牌");
                    kind5 += 1;
                    break;
            }
        } else {
            if ((pointA[0] + pointA[1] + pointA[2]) > (pointB[0] + pointB[1] + pointB[2])) {
                tv_result1.setText("本局结果为A赢，赢牌类型为杂牌");
                kind5 += 1;
            } else if ((pointA[0] + pointA[1] + pointA[2]) < (pointB[0] + pointB[1] + pointB[2])) {
                tv_result1.setText("本局结果为B赢，赢牌类型为杂牌");
                kind5 += 1;
            } else {
                tv_result1.setText("本局结果为平局");
                kind6 += 1;
            }
        }
        tv_result2.setText("游戏共进行" + number_of_games + "次，当前已进行" + count+ "次，同花概率：" + kind1 / number_of_games + "，顺子概率：" + kind2 / number_of_games + "，同点概率：" + kind3 / number_of_games + "，对子概率：" + kind4 / number_of_games + "，杂牌概率：" + kind5 / number_of_games + "， 平局概率：" + kind6 / number_of_games + "。");

    }
}

   /* public void gen(){


        int levelA = judgement(typesA, pointsA);
        int levelB = judgement(typesB, pointsB);

        result(levelA, levelB, pointsA, pointsB);
    }

}**/



/*
public class MyThread implements Runnable {
    int count = 0;
    public void run() {
        while (count <= number_of_games) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //从消息池中获得消息，如果没有消息，创建一个消息，如果有，则取出来，由handler发送
            Message message = Message.obtain();
            message.arg1 = count;
            //message.obj = "jack";
            handler.sendMessage(message);
            count++;
        }
    }


class MyHandler extends Handler{
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        int arg1 = msg.arg1;
        //String name = (String)msg.obj;
        if(arg1 != number_of_games) {
            gen();
        }else{
            Toast.makeText(GameInterface.this, "The game stops", Toast.LENGTH_SHORT).show();
        }
    }
}**/



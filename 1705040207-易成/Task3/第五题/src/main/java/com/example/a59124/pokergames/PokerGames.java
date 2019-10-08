package com.example.a59124.pokergames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class PokerGames extends AppCompatActivity {
    private TextView tv_result1;
    private TextView tv_result2;
    private TextView tv_card1;
    private TextView tv_card2;
    private TextView tv_card3;
    private TextView tv_card4;
    private TextView tv_card5;
    private TextView tv_card6;
    private Button bt_update;
    private Button bt_clear;
    int kind1 = 0;
    int kind2 = 0;
    int kind3 = 0;
    int kind4 = 0;
    int kind5 = 0;
    int kind6 = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker_games);

        tv_result1 = (TextView) findViewById(R.id.result1);
        tv_result2 = (TextView) findViewById(R.id.result2);
        tv_card1 = (TextView) findViewById(R.id.card1);
        tv_card2 = (TextView) findViewById(R.id.card2);
        tv_card3 = (TextView) findViewById(R.id.card3);
        tv_card4 = (TextView) findViewById(R.id.card4);
        tv_card5 = (TextView) findViewById(R.id.card5);
        tv_card6 = (TextView) findViewById(R.id.card6);

        bt_update = (Button) findViewById(R.id.update);
        bt_clear = (Button) findViewById(R.id.clear);

            bt_update.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    String typessA[] = gen_types();
                    int pointssA[] = gen_points();
                    String pA[] = gen_temppoint(pointssA);

                    String typessB[] = gen_types();
                    int pointssB[] = gen_points();
                    String pB[] = gen_temppoint(pointssB);

                    tv_card1.setText(typessA[0] + pA[0]);
                    tv_card2.setText(typessA[1] + pA[1]);
                    tv_card3.setText(typessA[2] + pA[2]);
                    tv_card4.setText(typessB[0] + pB[0]);
                    tv_card5.setText(typessB[1] + pB[1]);
                    tv_card6.setText(typessB[2] + pB[2]);

                    int levelA = judgement(typessA, pointssA);
                    int levelB = judgement(typessB, pointssB);
                    result(levelA, levelB, pointssA, pointssB);
                }
            });

            bt_clear.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    tv_card1.setText("Start   ");
                    tv_card2.setText("Start   ");
                    tv_card3.setText("Start   ");
                    tv_card4.setText("Start   ");
                    tv_card5.setText("Start   ");
                    tv_card6.setText("Start   ");
                    tv_result1.setText("      ");
                    tv_result2.setText("      ");
                    kind1 = 0;
                    kind2 = 0;
                    kind3 = 0;
                    kind4 = 0;
                    kind5 = 0;
                    kind6 = 0;
                    count = 0;
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
        count++;
        if (levelA > levelB) {
            switch (levelA) {
                case 5:
                    tv_result1.setText("本局结果为A赢，赢牌类型为同花");
                    kind1 ++;
                    break;
                case 4:
                    tv_result1.setText("本局结果为A赢，赢牌类型为顺子");
                    kind2 ++;
                    break;
                case 3:
                    tv_result1.setText("本局结果为A赢，赢牌类型为同点");
                    kind3 ++;
                    break;
                case 2:
                    tv_result1.setText("本局结果为A赢，赢牌类型为对子");
                    kind4 ++;
                    break;
                case 1:
                    tv_result1.setText("本局结果为A赢，赢牌类型为杂牌");
                    kind5 ++;
                    break;
            }
        } else if (levelA < levelB) {
            switch (levelB) {
                case 5:
                    tv_result1.setText("本局结果为B赢，赢牌类型为同花");
                    kind1 ++;
                    break;
                case 4:
                    tv_result1.setText("本局结果为B赢，赢牌类型为顺子");
                    kind2 ++;
                    break;
                case 3:
                    tv_result1.setText("本局结果为B赢，赢牌类型为同点");
                    kind3 ++;
                    break;
                case 2:
                    tv_result1.setText("本局结果为B赢，赢牌类型为对子");
                    kind4++;
                    break;
                case 1:
                    tv_result1.setText("本局结果为B赢，赢牌类型为杂牌");
                    kind5++;
                    break;
            }
        } else {
            if ((pointA[0] + pointA[1] + pointA[2]) > (pointB[0] + pointB[1] + pointB[2])) {
                tv_result1.setText("本局结果为A赢，赢牌类型为杂牌");
                kind5 ++;
            } else if ((pointA[0] + pointA[1] + pointA[2]) < (pointB[0] + pointB[1] + pointB[2])) {
                tv_result1.setText("本局结果为B赢，赢牌类型为杂牌");
                kind5 ++;
            } else {
                tv_result1.setText("本局结果为平局");
                kind6++;
            }
        }
        tv_result2.setText("当前已进行" + count+ "次，同花概率：" + 1.0*(kind1/count) + "，顺子概率：" + 1.0*(kind2/count)  + "，同点概率：" + 1.0*(kind3/count) + "，对子概率：" + 1.0*(kind4/count) + "，杂牌概率：" + 1.0*(kind5/count) + "， 平局概率：" + 1.0*(kind6/count) + "。");
        tv_result2.append("其中，同花次数：" + kind1 + "，顺子次数：" + kind2 + "，同点次数：" + kind3 + "，对子次数：" + kind4 + "，杂牌次数：" + kind5 + "， 平局次数：" + kind6 + "。");
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
            temp_points[i] = points[ran_num % 13 ];
        }
        return temp_points;
    }

    public String[] gen_temppoint(int [] args){
        String trans_point[] = new String[3];
        String t_point[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A"};
        for(int i=0; i<3; i++){
            trans_point[i] = t_point[args[i]- 2];
        }
        return trans_point;
    }

    public int genRandom() {
        /*int n = 51;
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int randInt = 0;
        do {
            randInt = rand.nextInt(n);
        } while (bool[randInt]);
        bool[randInt] = true;**/
        Random rand = new Random();
        int randInt = rand.nextInt(52);
        return randInt;
    }
}

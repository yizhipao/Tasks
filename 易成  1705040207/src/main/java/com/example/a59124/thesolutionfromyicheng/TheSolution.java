package com.example.a59124.thesolutionfromyicheng;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TheSolution extends AppCompatActivity {
    private TextView result;
    private Button back;

    private int year;
    private int bits;
    private Double number;
    private Double wage;
    private Intent intent;
    private Bundle bundle;
    public Double price;
    public Double cost;
    public Double capacity;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_solution);

        result = (TextView) findViewById(R.id.result);
        back = (Button) findViewById(R.id.back);

        intent = this.getIntent();
        bundle = intent.getExtras();
        year = bundle.getInt("year");
        bits = bundle.getInt("bits");
        number = bundle.getDouble("number");
        wage = bundle.getDouble("wage");

        calculateResult();
        disPlayAndBack();
    }

    public void calculateResult() {
        capacity = 4080 * Math.pow(Math.E, 0.28 * (year - 1960));
        if(bits == 16){
            price = 0.3 * Math.pow(0.72, year - 1974) * capacity;
        }else{
            price = 0.048 * bits * Math.pow(0.72, year - 1974) * capacity;
        }
        cost = wage * capacity / (number * 20);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void disPlayAndBack(){
        result.setText("    By calculation, In { " + year + " }, the demand for computer storage capacity was { " + formatting(capacity) + " } bytes. If the byte length was { "
                + bits + " }, the price of memory would be { $ " + formatting(price) + " }. " + "Assuming that a programmer could develop { " + number + " } instructions a day " +
                "and his average salary was { $ " + wage + " }, " + "the cost of filling a program with memory would be { $ " + formatting(cost) +" }.");

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String formatting(Double num){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");//格式化设置
        String  num1 = decimalFormat.format(num);
        return num1;
    }
}
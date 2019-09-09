package com.example.a59124.thesolutionfromyicheng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class ProblemDescription extends AppCompatActivity {
    private EditText year;
    private EditText bits;
    private EditText number;
    private EditText wage;
    private Button calculate;
    private Button clear;
    private int year1;
    private int bits1;
    private Double number1;
    private Double wage1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_description);
        year = (EditText) findViewById(R.id.year);
        bits = (EditText) findViewById(R.id.bits);
        number =  (EditText) findViewById(R.id.number);
        wage = (EditText) findViewById(R.id.wage);

        calculate = (Button) findViewById(R.id.calculate);
        clear = (Button) findViewById(R.id.clear);

        intentTheSolution();

    }

    private void intentTheSolution(){
        calculate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str1 = year.getText().toString();
                String str2 = bits.getText().toString();
                String str3 = number.getText().toString();
                String str4 = wage.getText().toString();

                if(str1.equals("")||str2.equals("")||str3.equals("")||str4.equals("")){
                    Toast.makeText(ProblemDescription.this, "Please enter all information to calculate! ", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!(isNumber(str1.trim())&&isNumber(str2.trim())&&isNumber(str3.trim())&&isNumber(str4.trim()))){
                    Toast.makeText(ProblemDescription.this, "Please enter a valid number! ", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                        year1 = Integer.parseInt(year.getText().toString().trim());
                        bits1 = Integer.parseInt(bits.getText().toString().trim());
                        number1 = Double.parseDouble(number.getText().toString().trim());
                        wage1 = Double.parseDouble(wage.getText().toString().trim());
                    }

                Intent intent = new Intent(ProblemDescription.this, TheSolution.class);
                Bundle bundle = new Bundle();
                bundle.putInt("year", year1);
                bundle.putInt("bits", bits1);
                bundle.putDouble("number", number1);
                bundle.putDouble("wage", wage1);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                year.setText("");
                bits.setText("");
                number.setText("");
                wage.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            year1 = bundle.getInt("year");
            bits1 = bundle.getInt("bits");
            number1 = bundle.getDouble("number");
            wage1 = bundle.getDouble("wage");

            String anumber = number1.toString();
            String awage = wage1.toString();
            year.setText(year1);
            bits.setText(bits1);
            number.setText(anumber);
            wage.setText(awage);
        }
    }

    public boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
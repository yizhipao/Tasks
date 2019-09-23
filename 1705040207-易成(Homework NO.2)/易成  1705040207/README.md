## 开发工具及编程语言
	本次开发的是一个小型App，我采用的开发工具为Android Studio, 运用的编程语言是Java。
  
## 运行环境
	不低于Android 4.0 版本的Android手机或者Android模拟器

## 功能描述
	用户可通过本App输入年份、字长位数、程序员每天可以开发的指令数和他们的平均工资来计算在当时对计算机存储容量的需求以及存储器的价格，和使存储器装满程序所需的成本。

## 源代码说明
### 1、activity_problem_description.xml，进入程序的主页面显示，里面主要包含的是TextView，ImageView，Button，EditText组件，采用的是LinearLayout布局。
```activity_problem_description.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_problem_description"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.a59124.thesolutionfromyicheng.ProblemDescription">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:weightSum="1">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:paddingTop="5dp"
            android:text="    According to historical data, the following assumptions can be made (where Y represents year, M represents storage capacity, PA and PB represent price) :"
            android:layout_alignParentLeft="true"
            android:layout_alignParentStart="true"
            android:layout_gravity="center"
            android:id="@+id/text1"
            android:layout_alignParentTop="true"
            android:lineSpacingMultiplier="1.2"/>

        <TextView
            android:id="@+id/text2"
            android:paddingTop="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="    1. The demand for computer storage capacity increases year by year according to the following formula:"
            android:layout_weight="0.05" />

        <ImageView
            android:id="@+id/pic1"
            android:paddingTop="5dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:src="@drawable/img_1"
            />

        <TextView
            android:id="@+id/text3"
            android:paddingTop="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="    2. The price of memory decreases year by year according to the following formula:"
            android:layout_weight="0.05"
            android:lineSpacingMultiplier="1.2"/>

        <ImageView
            android:id="@+id/pic2"
            android:paddingTop="5dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:src="@drawable/img_2"
            />

        <TextView
            android:id="@+id/text4"
            android:paddingTop="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="    If the computer word length is 16 bits, the trend of memory price decline is:"
            android:layout_weight="0.05"
            android:lineSpacingMultiplier="1.2"/>

        <ImageView
            android:id="@+id/pic3"
            android:paddingTop="5dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:src="@drawable/img_3"
            />

        <TextView
            android:id="@+id/text5"
            android:paddingTop="15dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="    If you enter the year(Year), the number of digits of memory word length(Bits), the number of instructions programmers can develop per day(Number), and their average salary(Wage), this program can help you calculate the demand and price of computer storage capacity, and the cost of filling up the program with memory in a given year."
            android:layout_weight="0.05"
            android:lineSpacingMultiplier="1.2"/>
    </LinearLayout>

    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingTop="15dp">

        <TextView
            android:id="@+id/text6"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="40dp"
            android:text="Year : "/>

        <EditText
            android:id="@+id/year"
            android:layout_width="81dp"
            android:layout_height="wrap_content"
            android:background="@android:color/darker_gray"
            android:hint=""
            android:selectAllOnFocus="false"
            tools:background="?android:attr/actionModeBackground" />

        <TextView
            android:id="@+id/text7"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="51dp"
            android:text="Bits : "/>

        <EditText
            android:id="@+id/bits"
            android:layout_width="72dp"
            android:layout_height="wrap_content"
            android:background="@android:color/darker_gray"
            android:selectAllOnFocus="false"
            tools:background="?android:attr/actionModeBackground" />
    </LinearLayout>

    <LinearLayout
        android:orientation="horizontal"
        android:paddingTop="10dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/text8"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="40dp"
            android:text="Number : "/>

        <EditText
            android:id="@+id/number"
            android:layout_width="60dp"
            android:layout_height="wrap_content"
            android:background="@android:color/darker_gray"
            android:hint=""
            android:selectAllOnFocus="false"
            tools:background="?android:attr/actionModeBackground" />

        <TextView
            android:id="@+id/text9"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="50dp"
            android:text="Wage : "/>

        <EditText
            android:id="@+id/wage"
            android:layout_width="60dp"
            android:layout_height="wrap_content"
            android:background="@android:color/darker_gray"
            android:selectAllOnFocus="false"
            tools:background="?android:attr/actionModeBackground" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="347dp"
        android:layout_height="wrap_content"
        android:paddingTop="25dp"
        android:orientation="horizontal">

        <Button
            android:id="@+id/calculate"
            android:layout_width="wrap_content"
            android:layout_height="36dp"
            android:layout_marginLeft="50dp"
            android:text="Calculate"
            android:textAllCaps="false"
            android:background="#00CD00"/>

        <Button
            android:id="@+id/clear"
            android:layout_width="wrap_content"
            android:layout_height="36dp"
            android:layout_marginLeft="70dp"
            android:text="Clear All"
            android:textAllCaps="false"
            android:background="#CD2626"/>
    </LinearLayout>
</LinearLayout>


```
### 2、ProblemDescription.Java, 对应于activity_problem_description.xml所显示的页面，用于显示问题的描述以及获取用户的输入
``` ProblemDescription.Java
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
    //实例化各个组件
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
		
        //使创建的对象对应相应的文本编辑框
		year = (EditText) findViewById(R.id.year);
        bits = (EditText) findViewById(R.id.bits);
        number =  (EditText) findViewById(R.id.number);
        wage = (EditText) findViewById(R.id.wage);

        calculate = (Button) findViewById(R.id.calculate);
        clear = (Button) findViewById(R.id.clear);
		
		//跳转到TheSolution活动中去，并传递相关值
        intentTheSolution();

    }

    private void intentTheSolution(){
        calculate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
			
			//获取用户的输入，并将其转换为String类型，便于后续处理
                String str1 = year.getText().toString();
                String str2 = bits.getText().toString();
                String str3 = number.getText().toString();
                String str4 = wage.getText().toString();
				
				// 判断输入是否为空，如果为空，应用Toast提示用户
                if(str1.equals("")||str2.equals("")||str3.equals("")||str4.equals("")){
                    Toast.makeText(ProblemDescription.this, "Please enter all information to calculate! ", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!(isNumber(str1.trim())&&isNumber(str2.trim())&&isNumber(str3.trim())&&isNumber(str4.trim()))){
                   // 去除用户在输入的过程中可能输入的空格，防止程序崩溃
				   Toast.makeText(ProblemDescription.this, "Please enter a valid number! ", Toast.LENGTH_SHORT).show();
                    return;
                }else{
						// 判断完毕后，在将String类型的数据转换为Integer或Double类型
                        year1 = Integer.parseInt(year.getText().toString().trim());
                        bits1 = Integer.parseInt(bits.getText().toString().trim());
                        number1 = Double.parseDouble(number.getText().toString().trim());
                        wage1 = Double.parseDouble(wage.getText().toString().trim());
                    }
				// 利用Bundle将要传递的数据进行捆绑，再传递给Intent让其传给下一活动
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
		// Clear All 按钮的功能实现，将所有输入的数据清空
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
		
		// 利用onActivityResult( )方法可以让从第二个活动返回至第一个活动时输入的数据不会丢失
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
	
	// 判断输入的数据是否为数字，防止因非法输入导致出现崩溃
    public boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
```

### 3、activity_the_solution.xml，本界面较为简单，采用的仍然是LinearLayout布局方式，主要控件为TextView（用于实时显示计算结果）和Button（用于退出程序）。
```activity_the_solution.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_the_solution"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.a59124.thesolutionfromyicheng.TheSolution">

    <TextView
        android:id="@+id/result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:lineSpacingMultiplier="1.5"/>

    <LinearLayout
        android:layout_marginTop="480dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <Button
            android:id="@+id/back"
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:layout_marginLeft="85dp"
            android:text="Exit The Application"
            android:textAllCaps="false"
            android:background="#CD2626"/>

    </LinearLayout>

</LinearLayout>

```

### 4、TheSolution.java，对应activity_the_solution.xml所显示的界面，用于处理数据并将计算的结果返回给界面，还给予一个可供用户直接退出程序的按钮。
```TheSolution.java
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
    //实例化各个组件
	private TextView result;
    private Button back;
	//定义一些用于计算的变量
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
		// 获取从第一个活动传递过来的数据
        intent = this.getIntent();
        bundle = intent.getExtras();
        year = bundle.getInt("year");
        bits = bundle.getInt("bits");
        number = bundle.getDouble("number");
        wage = bundle.getDouble("wage");

        calculateResult();//用于处理数据
        disPlayAndBack();//用于将结果反馈给用户以及退出程序
    }

    public void calculateResult() {//具体的计算公式
        capacity = 4080 * Math.pow(Math.E, 0.28 * (year - 1960));
        if(bits == 16){
            price = 0.3 * Math.pow(0.72, year - 1974) * capacity;
        }else{
            price = 0.048 * bits * Math.pow(0.72, year - 1974) * capacity;
        }
        cost = wage * capacity / (number * 20);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)//兼容低版本Android
    public void disPlayAndBack(){
        result.setText("    By calculation, In { " + year + " }, the demand for computer storage capacity was { " + formatting(capacity) + " } bytes. If the byte length was { "
                + bits + " }, the price of memory would be { $ " + formatting(price) + " }. " + "Assuming that a programmer could develop { " + number + " } instructions a day " +
                "and his average salary was { $ " + wage + " }, " + "the cost of filling a program with memory would be { $ " + formatting(cost) +" }.");

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setResult(RESULT_OK, intent);//从第二个活动返回至第一个活动时,输入的数据不会丢失
                finish();// 摧毁活动，退出程序
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String formatting(Double num){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");//格式化相关数据
        String  num1 = decimalFormat.format(num);
        return num1;
    }
}
```
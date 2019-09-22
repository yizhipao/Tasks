## HomeWork总分析
***

1、开发工具、语言及运行环境
```
这个界面是用 android studio工具开发出来的，其中主要语言用的是Java，运行时环境

就是Dalvik虚拟机和核心库了
```
2、功能描述
```
主要功能就是实现软件工程导论第一章第5题的功能，即根据历史数据实现计算机存储

容量及存储器价格的估计，主要是代公式，也没太多要求。
```
3、源代码及文件说明（主要是java代码，功能也没有，就别看了）

（1）MainActivity

```
package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_year;
    private EditText edt_length;
    private EditText edt_salary;
    private EditText edt_order;
    private Button btn_range;
    private Button btn_price;
    private Button btn_cost;
    private TextView tv_range;
    private TextView tv_price;
    private TextView tv_cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_year=(EditText)findViewById(R.id.edt_year);
        btn_range=(Button)findViewById(R.id.btn_range);
        tv_range=(TextView)findViewById(R.id.tv_range);
        edt_length=(EditText)findViewById(R.id.edt_length);
        btn_price=(Button)findViewById(R.id.btn_price);
        tv_price=(TextView)findViewById(R.id.tv_price);
        edt_salary=(EditText)findViewById(R.id.edt_salary);
        edt_order=(EditText)findViewById(R.id.edt_order);
        btn_cost=(Button)findViewById(R.id.btn_cost);
        tv_cost=(TextView)findViewById(R.id.tv_cost);

        btn_range.setOnClickListener(this);
        btn_price.setOnClickListener(this);
        btn_cost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btn_range){
            int inputYear=Integer.parseInt(edt_year.getText().toString());
            int out=(int)(4080*Math.pow(Math.E,0.28*(inputYear-1960)));
            tv_range.setText(out+"");
        }
        else if(view==btn_price){
            int inputYear=Integer.parseInt(edt_year.getText().toString());
            int inputLength=Integer.parseInt(edt_length.getText().toString());
            int out=(int)(4080*Math.pow(Math.E,0.28*(inputYear-1960)));
            int out1=(int)(0.003*inputLength*out*Math.pow(0.72,(inputYear-1974)));
            tv_price.setText(out1+"");
        }else if(view==btn_cost){
            int year=Integer.parseInt(edt_year.getText().toString());
            double m=(4080*Math.pow(Math.E,0.28*(year-1960)));
            int order=Integer.parseInt(edt_order.getText().toString());
            int salary=Integer.parseInt(edt_salary.getText().toString());
            int cost=(int)((m/(order*20))*salary);
            tv_cost.setText(cost+"");
        }
    }
}

```

(2)activity_main

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:text="计算机容量及成本估计分析"
        android:textColor="#F1D960"
        android:background="#465CE6"
        android:textSize="20sp"
        android:gravity="center"/>

    <TextView
        android:layout_marginTop="10dp"
        android:layout_marginLeft="10dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="计算机存储器容量需求随年份逐渐增加："/>

        <TextView
            android:layout_marginTop="5dp"
            android:layout_marginLeft="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/range"
            android:textColor="#EFD346"/>

    <TextView
        android:layout_marginTop="10dp"
        android:layout_marginLeft="10dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="存储器价格按如下趋势逐年下降："/>

    <TextView
        android:layout_marginTop="5dp"
        android:layout_marginLeft="10dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/price1"
        android:textColor="#EFD346"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:orientation="horizontal"
        android:layout_height="20dp"
        android:layout_marginTop="5dp"
        android:layout_marginLeft="10dp">

        <TextView
            android:gravity="left"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/price2"
            android:textColor="#EFD346"/>

    <TextView
        android:layout_marginLeft="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="(当计算机字长为16位时)"/>

    </LinearLayout>
    <LinearLayout
        android:layout_marginTop="20dp"
        android:layout_marginLeft="10dp"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    <TextView
        android:gravity="left"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="请输入您要估计的年份："/>
        <EditText
            android:id="@+id/edt_year"
            android:layout_marginLeft="5dp"
            android:layout_width="100dp"
            android:layout_height="wrap_content" />
        <Button
            android:id="@+id/btn_range"
            android:layout_marginLeft="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="查询容量"/>

        <TextView
            android:layout_marginLeft="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="程序员一天可发出指令：（条）"/>
        <EditText
            android:id="@+id/edt_order"
            android:layout_marginLeft="5dp"
            android:layout_width="100dp"
            android:layout_height="wrap_content" />


    </LinearLayout>
    <TextView
        android:layout_marginLeft="150dp"
        android:layout_marginTop="5dp"
        android:id="@+id/tv_range"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
    <LinearLayout
        android:layout_marginTop="10dp"
        android:layout_marginLeft="10dp"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="left"
        android:text="机器字长为："/>
        <EditText
            android:id="@+id/edt_length"
            android:layout_marginLeft="10dp"
            android:layout_width="100dp"
            android:layout_height="wrap_content" />
        <Button
            android:id="@+id/btn_price"
            android:layout_marginLeft="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="查询价格"/>
        <TextView
            android:layout_marginLeft="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="程序员月平均工资为："/>
        <EditText
            android:id="@+id/edt_salary"
            android:layout_marginLeft="5dp"
            android:layout_width="100dp"
            android:layout_height="wrap_content" />
        <Button
            android:id="@+id/btn_cost"
            android:layout_marginLeft="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="查询成本"/>

    </LinearLayout>
    <LinearLayout
        android:layout_marginTop="15dp"
        android:layout_marginLeft="10dp"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    <TextView
        android:id="@+id/tv_price"
        android:paddingLeft="70dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    <TextView
        android:id="@+id/tv_cost"
        android:paddingLeft="400dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    </LinearLayout>
</LinearLayout>
```

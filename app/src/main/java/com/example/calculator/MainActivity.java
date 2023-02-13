package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import kotlin.reflect.KProperty;

public class MainActivity extends AppCompatActivity {


    int[] a={R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.buttonCong,R.id.buttonTru,R.id.buttonNhan,R.id.buttonChia};
    TextView textView1;
    TextView textView2;
    char Operator[] = {'+','-','*','/'};
    Intent intent ;


    //    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        for (int i = 1; i <= intent.getIntExtra("đếm",1); i++) {
//Bundle a= new Bundle();
//String[] b= intent.getStringArrayExtra(""+(i-1));
//a.putString("1",b[0]);
//a.putString("2",b[1]);
//            outState.putBundle(""+(i-1),a);
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        intent= new Intent(this,MainActivity2.class);
        intent.putExtra("đếm",0);
        for (int i = 0; i < a.length ; i++) {

            int temp= i;
            findViewById(a[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView textView = findViewById(a[temp]);
                    textView1.setText(textView1.getText()+textView.getText().toString());
                }
            });
        }
        findViewById(R.id.buttonBang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < Operator.length; i++) {
                    if (textView1.getText().toString().contains(String.valueOf(Operator[i])) ) {
                        String[] c= new String[2];
                        c[0]=  textView1.getText().toString().substring(0,textView1.getText().toString().indexOf(String.valueOf(Operator[i])));
                        c[1]=textView1.getText().toString().substring(textView1.getText().toString().indexOf(String.valueOf(Operator[i]))+1);
                        double a= Integer.parseInt(c[0]);
                        double b =Integer.parseInt(c[1]);
                        double kq=0;
                        switch (i){
                            case 0:
                                kq= a+b;
                                break;
                            case 1:
                                kq= a-b;
                                break;
                            case 2:
                                kq= a*b;
                                break;
                            case 3:
                                kq= a/b ;
                                break;
                        }

                        textView2.setText(String.valueOf(kq));
                        intent.putExtra(""+intent.getIntExtra("đếm",1),new String[]{textView1.getText().toString(),textView2.getText().toString()});
                        intent.putExtra("đếm",intent.getIntExtra("đếm",1)+1);
                        break;

                    }

                }
            }
        });
        findViewById(R.id.buttonAC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("");
            }
        });
        findViewById(R.id.buttonDEL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(textView1.getText().toString().substring(0,textView1.getText().length()-1));
            }
        });

        findViewById(R.id.buttonList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);
            }
        });

    }

}

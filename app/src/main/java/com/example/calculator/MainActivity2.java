package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
ArrayList<Calc> listKq;
    ListView list;
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent= getIntent();
        listKq = new ArrayList<>();
list= findViewById(R.id.list);



//        Log.d("aaa1", "onCreate: "+ a1.length);
int a= intent.getIntExtra("đếm",1);

        for (int i = 0; i < a; i++) {
     String[] a1= intent.getStringArrayExtra(""+i);
     listKq.add(new Calc(a1[0],a1[1]));
        }
        ArrayAdapter<Calc> arrayAdapter= new ArrayAdapter<Calc>(this,android.R.layout.simple_list_item_1,listKq);
        list.setAdapter(arrayAdapter);
    }

}
class Calc{
    String a,b;
    Calc(String a, String b){
        this.a= a;
        this.b=b;
    }

    @NonNull
    @Override
    public String toString() {
        return a+" = "+ b;
    }
}
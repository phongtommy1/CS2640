package com.example.cs2640project;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.AppCompatButton;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.Arrays;

import java.util.Collections;

import static com.example.cs2640project.MainActivity.*;

public class MainActivity2 extends AppCompatActivity {
    public int UserInput;
    AppCompatButton btn;
    AppCompatButton btn1;
    AppCompatButton btn2;
    AppCompatButton btn3;
    AppCompatButton btn4;
    AppCompatButton btn5;
    AppCompatButton btn6;
    AppCompatButton btn7;
    AppCompatButton btn8;
    AppCompatButton btn9;
    AppCompatButton btn10;
    AppCompatButton btn11;
    AppCompatButton btn12;
    AppCompatButton btn13;
    AppCompatButton btn14;
    AppCompatButton btn15;
    AppCompatButton btn16;
    AppCompatButton btn17;
    AppCompatButton btn18;
    AppCompatButton btn19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        btn15 = findViewById(R.id.btn15);
        btn16 = findViewById(R.id.btn16);
        btn17 = findViewById(R.id.btn17);
        btn18 = findViewById(R.id.btn18);
        btn19 = findViewById(R.id.btn19);

        UserInput = getIntent().getIntExtra(USER_INPUT, 0);
        Log.i("MainActivity2", "The enter value is:" + UserInput);

        AppCompatButton[] buttonArray = { btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19};
        String[] words = {"poop", "baka", "onnichan", "pineapple", "anime", "pikachu", "bunny", "senpai", "sensei", "goku"};
        String[] wordChosen = new String[UserInput];

        for (int i = 0; i < UserInput; i++) {
            wordChosen[i] = words[i];
            buttonArray[i].setVisibility(View.VISIBLE);

        }

        String[] a = duplicateWord(wordChosen);
        Collections.shuffle(Arrays.asList(a));

        for(int j = 0; j < UserInput; j++ ){

        }


    }

    private String[] duplicateWord(String[] a) {
        String[] b = a;
        int length = a.length * 2;
        String result[] = new String[length];
        int pos = 0;

       for(String element : a){
           result[pos] = element;
           pos++;
       }

       for(String element : b){
           result[pos] = element;
           pos++;
       }

       return result;
    }
}
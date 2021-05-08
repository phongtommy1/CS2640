package com.example.cs2640project;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.AppCompatButton;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import static com.example.cs2640project.MainActivity.*;

public class MainActivity2 extends AppCompatActivity {
    public int UserInput;
    public final String TAG = "mainactivity2";
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
    AppCompatButton btnGame;
    AppCompatButton btnTry;
    AppCompatButton btnEnd;


    private int clicked = 0;
    private boolean turnOver = false;
    private int previous = -1;

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
        btnEnd = findViewById(R.id.btnEnd);
        btnGame = findViewById(R.id.btnGame);
        btnTry = findViewById(R.id.btnTry);

        UserInput = getIntent().getIntExtra(USER_INPUT, 0);
        Log.i("MainActivity2", "The enter value is:" + UserInput);

        AppCompatButton[] buttonArray = { btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19};
        List<Integer> words = (Arrays.asList(R.drawable.goku_1, R.drawable.poo, R.drawable.anime, R.drawable.bunny, R.drawable.mask, R.drawable.music, R.drawable.pineapple, R.drawable.pizza, R.drawable.pokemon, R.drawable.snake));
        List<Integer> wordChosen = new ArrayList<>();

        // randomize the picture that is going to be drawn
        Collections.shuffle(words);

        for (int i = 0; i < UserInput ; i++) {
            buttonArray[i].setVisibility(View.VISIBLE);
        }

        // loop to load picture
        for (int x = 0; x < UserInput /2; x++){
            wordChosen.add(words.get(x));
        }

        List<Integer> a = duplicateWord(wordChosen);
        Collections.shuffle(a);

        runGame(buttonArray, a);


        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int z = 0; z < UserInput; z++) {
                    buttonArray[z].setBackgroundResource(a.get(z));
                }
            }
        });

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // randomize the picture that is going to be drawn
                List<Integer> wordChosen2 = new ArrayList<>();
                Collections.shuffle(words);
                for (int x = 0; x < UserInput /2; x++){
                    wordChosen2.add(words.get(x));
                }

                List<Integer> c = duplicateWord(wordChosen2);
                Collections.shuffle(c);

                for(int b = 0; b < UserInput; b++){
                    buttonArray[b].setBackgroundResource(R.drawable.cardblack);
                    buttonArray[b].setEnabled(true);
                }
                clicked = 0;
                turnOver = false;
                previous = -1;
                runGame(buttonArray, c);
            }
        });


    }

    private void runGame(AppCompatButton[] buttonArray, List<Integer> a ) {
        for(int j = 0; j< UserInput; j++ ){
            buttonArray[j].setText("back");
            buttonArray[j].setTextSize(0.0F);
            final int increment = j;
            buttonArray[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(buttonArray[increment].getText() == ("back") && !turnOver){
                        buttonArray[increment].setBackgroundResource(a.get(increment));
                        buttonArray[increment].setText(a.get(increment));
                        if(clicked == 0){
                            previous = increment;
                        }
                        clicked++;
                    }
                    else if(buttonArray[increment].getText() != "back"){
                        buttonArray[increment].setBackgroundResource(R.drawable.cardblack);
                        buttonArray[increment].setText("back");
                        clicked--;
                        Log.i(TAG, "Clicked is " + clicked);
                    }
                    if(clicked == 2) {
                        turnOver = true;
                        if (buttonArray[increment].getText() == buttonArray[previous].getText()) {
                            buttonArray[increment].setEnabled(false);
                            buttonArray[previous].setEnabled(false);
                            turnOver = false;
                            clicked = 0;
                        }
                        else {
                            btnTry.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    buttonArray[increment].setBackgroundResource(R.drawable.cardblack);
                                    buttonArray[increment].setText("back");
                                    buttonArray[previous].setBackgroundResource(R.drawable.cardblack);
                                    buttonArray[previous].setText("back");
                                    clicked = 0;
                                    turnOver = false;
                                }
                            });

                            Log.i(TAG, "Clicked is " + clicked);
                        }
                    }


                }
            });
        }
    }

    private List<Integer> duplicateWord(List<Integer> a) {
        List<Integer> b = a;
        List<Integer> result = new ArrayList<>();

       for(int element : a){
           result.add(element);
       }

       for(int element : b){
          result.add(element);
       }

       return result;
    }
}
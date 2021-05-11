package com.example.cs2640project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import static com.example.cs2640project.MainActivity.*;

public class MainActivity2 extends AppCompatActivity {
    public static int UserInput;
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

    AppCompatButton backButton;  //to return to home menu

    //score text labels for the different card game options
    TextView score4CardsLabel;
    TextView score6CardsLabel;
    TextView score8CardsLabel;
    TextView score10CardsLabel;
    TextView score12CardsLabel;
    TextView score14CardsLabel;
    TextView score16CardsLabel;
    TextView score18CardsLabel;
    TextView score20CardsLabel;

    //initializations for card game scores
    static int score4 = 0;
    static int score6 = 0;
    static int score8 = 0;
    static int score10 = 0;
    static int score12 = 0;
    static int score14 = 0;
    static int score16 = 0;
    static int score18 = 0;
    static int score20 = 0;

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

        backButton = findViewById(R.id.backButton);  //back to main menu


        //find view by ID for the score text fields to link them to the android XML widgets
        score4CardsLabel = (TextView)findViewById(R.id.fourCardScore);
        score6CardsLabel = (TextView)findViewById(R.id.sixCardScore);
        score8CardsLabel = (TextView)findViewById(R.id.eightCardScore);
        score10CardsLabel = (TextView)findViewById(R.id.tenCardScore);
        score12CardsLabel = (TextView)findViewById(R.id.twelveCardScore);
        score14CardsLabel = (TextView)findViewById(R.id.fourteenCardScore);
        score16CardsLabel = (TextView)findViewById(R.id.sixteenCardScore);
        score18CardsLabel = (TextView)findViewById(R.id.eighteenCardScore);
        score20CardsLabel = (TextView)findViewById(R.id.twentyCardScore);


        UserInput = getIntent().getIntExtra(USER_INPUT, 0);
        Log.i("MainActivity2", "The enter value is:" + UserInput);

        AppCompatButton[] buttonArray = { btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19};
        List<Integer> words = (Arrays.asList(R.drawable.goku_1, R.drawable.poo, R.drawable.anime, R.drawable.bunny, R.drawable.mask, R.drawable.music, R.drawable.pineapple, R.drawable.pizza, R.drawable.pokemon, R.drawable.snake));
        List<Integer> wordChosen = new ArrayList<>();

        // randomize the picture that is going to be drawn
        Collections.shuffle(words);

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //THIS SECTION OF CODE DEALS WITH SCORE LABELING (NEEDS WORK)
        if(UserInput == 4) //if user chooses 4 cards
        {
            score4CardsLabel.setVisibility(View.VISIBLE);  //only set the score4CardsLabel textField to visible
            score4CardsLabel.setText("Score: " + score4);  //show the score

            //set all other card score labels to invisible
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 6) //if user chooses 6 cards
        {
            score6CardsLabel.setVisibility(View.VISIBLE); //only set the score8CardsLabel textField to visible
            score6CardsLabel.setText("Score: " + score6); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 8) //if user chooses 8 cards
        {
            score8CardsLabel.setVisibility(View.VISIBLE); //only set the score8CardsLabel textField to visible
            score8CardsLabel.setText("Score: " + score8); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 10) //if user chooses 10 cards
        {
            score10CardsLabel.setVisibility(View.VISIBLE); //only set the score10CardsLabel textField to visible
            score10CardsLabel.setText("Score: " + score10); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 12) //if user chooses 12 cards
        {
            score12CardsLabel.setVisibility(View.VISIBLE); //only set the score12CardsLabel textField to visible
            score12CardsLabel.setText("Score: " + score12); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 14) //if user chooses 14 cards
        {
            score14CardsLabel.setVisibility(View.VISIBLE); //only set the score14CardsLabel textField to visible
            score14CardsLabel.setText("Score: " + score14); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 16) //if user chooses 16 cards
        {
            score16CardsLabel.setVisibility(View.VISIBLE); //only set the score16CardsLabel textField to visible
            score16CardsLabel.setText("Score: " + score16); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 18) //if user chooses 18 cards
        {
            score18CardsLabel.setVisibility(View.VISIBLE); //only set the score18CardsLabel textField to visible
            score18CardsLabel.setText("Score: " + score18); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score20CardsLabel.setVisibility(View.INVISIBLE);
        }
        else if(UserInput == 20) //if user chooses 20 cards
        {
            score20CardsLabel.setVisibility(View.VISIBLE); //only set the score20CardsLabel textField to visible
            score20CardsLabel.setText("Score: " + score20); //show the score

            //set all other card score labels to invisible
            score4CardsLabel.setVisibility(View.INVISIBLE);
            score6CardsLabel.setVisibility(View.INVISIBLE);
            score8CardsLabel.setVisibility(View.INVISIBLE);
            score10CardsLabel.setVisibility(View.INVISIBLE);
            score12CardsLabel.setVisibility(View.INVISIBLE);
            score14CardsLabel.setVisibility(View.INVISIBLE);
            score16CardsLabel.setVisibility(View.INVISIBLE);
            score18CardsLabel.setVisibility(View.INVISIBLE);
        }

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------

        for (int i = 0; i < UserInput ; i++) {
            buttonArray[i].setVisibility(View.VISIBLE);
        }

        // loop to load picture
        for (int x = 0; x < UserInput /2; x++){
            wordChosen.add(words.get(x));
        }

        List<Integer> a = duplicateWord(wordChosen);
        Collections.shuffle(a);

        //reset the score to 0 and run the game
        if(UserInput == 4)
        {
            score4 = 0;
            score4CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score4CardsLabel);
        }
        else if(UserInput == 6)
        {
            score6 = 0;
            score6CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score6CardsLabel);
        }
        else if(UserInput == 8)
        {
            score8 = 0;
            score8CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score8CardsLabel);
        }
        else if(UserInput == 10)
        {
            score10 = 0;
            score10CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score10CardsLabel);
        }
        else if(UserInput == 12)
        {
            score12 = 0;
            score12CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score12CardsLabel);
        }
        else if(UserInput == 14)
        {
            score14 = 0;
            score14CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score14CardsLabel);
        }
        else if(UserInput == 16)
        {
            score16 = 0;
            score16CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score16CardsLabel);
        }
        else if(UserInput == 18)
        {
            score18 = 0;
            score18CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score18CardsLabel);
        }
        else if(UserInput == 20)
        {
            score20 = 0;
            score20CardsLabel.setText("Score: " + 0);
            runGame(buttonArray, a, score20CardsLabel);
        }



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

                //reset scores upon new game
                if(UserInput == 4)
                {
                    score4 = 0;
                    score4CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score4CardsLabel);
                }
                else if(UserInput == 6)
                {
                    score6 = 0;
                    score6CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score6CardsLabel);
                }
                else if(UserInput == 8)
                {
                    score8 = 0;
                    score8CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score8CardsLabel);
                }
                else if(UserInput == 10)
                {
                    score10 = 0;
                    score10CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score10CardsLabel);
                }
                else if(UserInput == 12)
                {
                    score12 = 0;
                    score12CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score12CardsLabel);
                }
                else if(UserInput == 14)
                {
                    score14 = 0;
                    score14CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score14CardsLabel);
                }
                else if(UserInput == 16)
                {
                    score16 = 0;
                    score16CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score16CardsLabel);
                }
                else if(UserInput == 18)
                {
                    score18 = 0;
                    score18CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score18CardsLabel);
                }
                else if(UserInput == 20)
                {
                    score20 = 0;
                    score20CardsLabel.setText("Score: " + 0);
                    runGame(buttonArray, c, score20CardsLabel);
                }


            }
        });

        //Listener for end game button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //just reset all scores upon going back to main menu
                score4 = 0;
                score6 = 0;
                score8 = 0;
                score10 = 0;
                score12 = 0;
                score14 = 0;
                score16 = 0;
                score18 = 0;
                score20 = 0;

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);  //create a new intent using this and MainActivity
                startActivity(intent); //start the activity using intent (will send you to MainActivity)
            }
        });


    }

    private void runGame(AppCompatButton[] buttonArray, List<Integer> a, TextView label) {
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
                        //if user matches 2 cards
                        if (buttonArray[increment].getText() == buttonArray[previous].getText()) {
                            btnTry.setEnabled(false);  //disable the "try again" button until the next flip so that none of the matches can get overwritten
                            buttonArray[increment].setEnabled(false);
                            buttonArray[previous].setEnabled(false);

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                            //MORE SCORING LOGIC (for correct match)

                            if(UserInput == 4)
                            {
                                score4 += 2;
                                score4CardsLabel.setText("Score: " + score4);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and MainEndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
                            else if(UserInput == 6)
                            {
                                score6 += 2;
                                score6CardsLabel.setText("Score: " + score6);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
                            else if(UserInput == 8)
                            {
                                score8 += 2;
                                score8CardsLabel.setText("Score: " + score8);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
                            else if(UserInput == 10)
                            {
                                score10 += 2;
                                score10CardsLabel.setText("Score: " + score10);//update scoreLabel text here
                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }

                            }
                            else if(UserInput == 12)
                            {
                                score12 += 2;
                                score12CardsLabel.setText("Score: " + score12);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
                            else if(UserInput == 14)
                            {
                                score14 += 2;
                                score14CardsLabel.setText("Score: " + score14);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
                            else if(UserInput == 16)
                            {
                                score16 += 2;
                                score16CardsLabel.setText("Score: " + score16);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
                            else if(UserInput == 18)
                            {
                                score18 += 2;
                                score18CardsLabel.setText("Score: " + score18);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
                            else if(UserInput == 20)
                            {
                                score20 += 2;
                                score20CardsLabel.setText("Score: " + score20);//update scoreLabel text here

                                //end game logic goes here
                                int cardsFlipped = 0;
                                for(int i = 0; i < UserInput; i++)
                                {
                                    //iterate through every card in the array, and if a card is not showing it's back, increment cardsFlipped
                                    if (buttonArray[i].getText() != "back")
                                    {
                                        cardsFlipped++;

                                        if (cardsFlipped == UserInput)  //if cardsFlipped = amount of card in the game, it means game is over and we can go to end screen
                                        {
                                            Intent intent = new Intent(MainActivity2.this, EndScreen4.class);  //create a new intent using this and EndScreen
                                            startActivity(intent); //start the activity using intent (will send you to EndScreen)
                                        }
                                    }
                                }
                            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                            turnOver = false;
                            clicked = 0;
                        }
                        else {  //if user does not make a correct match
                            btnTry.setEnabled(true);
                            btnTry.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    buttonArray[increment].setBackgroundResource(R.drawable.cardblack);
                                    buttonArray[increment].setText("back");
                                    buttonArray[previous].setBackgroundResource(R.drawable.cardblack);
                                    buttonArray[previous].setText("back");
                                    clicked = 0;
                                    turnOver = false;
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                    //MORE SCORING LOGIC (for incorrect match)

                                    //update scoreLabel text here
                                    if(UserInput == 4)
                                    {
                                        if(score4 > 0)
                                        {
                                            score4 -= 1;
                                            score4CardsLabel.setText("Score: " + score4);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 6)
                                    {
                                        if(score6 > 0)
                                        {
                                            score6 -= 1;
                                            score6CardsLabel.setText("Score: " + score6);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 8)
                                    {
                                        if(score8 > 0)
                                        {
                                            score8 -= 1;
                                            score8CardsLabel.setText("Score: " + score8);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 10)
                                    {
                                        if(score10 > 0)
                                        {
                                            score10 -= 1;
                                            score10CardsLabel.setText("Score: " + score10);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 12)
                                    {
                                        if(score12 > 0)
                                        {
                                            score12 -= 1;
                                            score12CardsLabel.setText("Score: " + score12);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 14)
                                    {
                                        if(score14 > 0)
                                        {
                                            score14 -= 1;
                                            score14CardsLabel.setText("Score: " + score14);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 16)
                                    {
                                        if(score16 > 0)
                                        {
                                            score16 -= 1;
                                            score16CardsLabel.setText("Score: " + score16);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 18)
                                    {
                                        if(score18 > 0)
                                        {
                                            score18 -= 1;
                                            score18CardsLabel.setText("Score: " + score18);//update scoreLabel text here
                                        }
                                    }
                                    else if(UserInput == 20)
                                    {
                                        if(score20 > 0)
                                        {
                                            score20 -= 1;
                                            score20CardsLabel.setText("Score: " + score20);//update scoreLabel text here
                                        }
                                    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
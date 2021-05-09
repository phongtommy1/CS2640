package com.example.cs2640project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EndScreen4 extends AppCompatActivity {

    Button backButton;
    TextView endLabel;
    TextView scoreLabel;
    TextView highScore1Label;
    TextView highScore2Label;
    TextView highScore3Label;
    private static String fileName = "";
    static int highScore1 = 0;
    static int highScore2 = 0;
    static int highScore3 = 0;
    String highScore1Initial;
    String highScore2Initial;
    String highScore3Initial;

    private String highScore1Tracker;
    private String highScore2Tracker;
    private String highScore3Tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen4);

        backButton = findViewById(R.id.exitToMenuButton);
        endLabel = findViewById(R.id.gameOverLabel);
        scoreLabel = findViewById(R.id.scoreLabel);
        highScore1Label = findViewById(R.id.highScore1Label);
        highScore2Label = findViewById(R.id.highScore2Label);
        highScore3Label = findViewById(R.id.highScore3Label);

        //int highScore1 = 0;
        //int highScore2 = 0;
        //int highScore3  = 0;

        if(MainActivity2.UserInput == 4)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score4);

            //high score implementation
            fileName = "HighScores_4Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 6)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score6);

            //high score implementation
            fileName = "HighScores_6Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 8)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score8);

            //high score implementation
            fileName = "HighScores_8Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 10)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score10);

            //high score implementation
            fileName = "HighScores_10Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 12)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score12);

            //high score implementation
            fileName = "HighScores_12Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 14)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score14);

            //high score implementation
            fileName = "HighScores_14Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 16)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score16);

            //high score implementation
            fileName = "HighScores_16Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 18)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score18);

            //high score implementation
            fileName = "HighScores_18Cards.txt";
            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 20)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score20);

            //high score implementation
            fileName = "HighScores_20Cards.txt";
            showHighScores(fileName);
        }


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndScreen4.this, MainActivity.class);  //create a new intent using this and MainActivity
                startActivity(intent); //start the activity using intent (will send you to MainActivity)
            }
        });

    }

    //THIS WORKS FOR ONLY NUMBERS (FIGURE OUT HOW TO ALSO ADD INITIALS)
    public void showHighScores(String fileName)
    {
        try {
            DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format(fileName)));
            Scanner inputFile = new Scanner(textFileStream);
            while(inputFile.hasNextLine())
            {
                highScore1 = Integer.parseInt(inputFile.nextLine().split(" ")[0]);
                highScore2 = Integer.parseInt(inputFile.nextLine().split(" ")[0]);
                highScore3 = Integer.parseInt(inputFile.nextLine().split(" ")[0]);

                //highScore1Label.setText(String.valueOf(highScore1));
                //highScore2Label.setText(String.valueOf(highScore2));
                //highScore3Label.setText(String.valueOf(highScore3));
            }
            inputFile.close();

            //experimenting code below until catch block
            textFileStream = new DataInputStream(getAssets().open(String.format(fileName)));
            inputFile = new Scanner(textFileStream);
            while(inputFile.hasNextLine())
            {
                highScore1Initial = inputFile.nextLine().split(" ")[1];
                highScore2Initial = inputFile.nextLine().split(" ")[1];
                highScore3Initial = inputFile.nextLine().split(" ")[1];
            }
            inputFile.close();

            highScore1Label.setText(String.valueOf(highScore1) + "\t" + highScore1Initial);
            highScore2Label.setText(String.valueOf(highScore2) + "\t" + highScore2Initial);
            highScore3Label.setText(String.valueOf(highScore3) + "\t" + highScore3Initial);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
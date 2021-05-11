package com.example.cs2640project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HighScoresPage extends AppCompatActivity {

    Button menuButton;  //back to menu button

    //TextViews to be the labels to show each respective high score
    TextView highScoreLabel4;
    TextView highScoreLabel6;
    TextView highScoreLabel8;
    TextView highScoreLabel10;
    TextView highScoreLabel12;
    TextView highScoreLabel14;
    TextView highScoreLabel16;
    TextView highScoreLabel18;
    TextView highScoreLabel20;

    public String fileName = "";  //for reading the file for high scores

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores_page);

        menuButton = findViewById(R.id.exitToMenuButton);
        highScoreLabel4 = findViewById(R.id.highScoreLabel4);
        highScoreLabel6 = findViewById(R.id.highScoreLabel6);
        highScoreLabel8 = findViewById(R.id.highScoreLabel8);
        highScoreLabel10 = findViewById(R.id.highScoreLabel10);
        highScoreLabel12 = findViewById(R.id.highScoreLabel12);
        highScoreLabel14 = findViewById(R.id.highScoreLabel14);
        highScoreLabel16 = findViewById(R.id.highScoreLabel16);
        highScoreLabel18 = findViewById(R.id.highScoreLabel18);
        highScoreLabel20 = findViewById(R.id.highScoreLabel20);


        //listener for the back to menu button
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HighScoresPage.this, MainActivity.class);  //create a new intent using this and MainActivity
                startActivity(intent); //start the activity using intent (will send you to MainActivity)
            }
        });

        //based on the user input, perform the correct task for the high score by setting all other labels to invisible and only showing the relevant high score label
        if(MainActivity.resultOfInput == 4)
        {
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_4_Cards.txt";

            try {
                showHighScores(fileName, highScoreLabel4);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 6)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_6_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel6);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 8)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_8_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel8);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 10)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_10_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel10);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 12)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_12_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel12);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 14)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_14_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel14);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 16)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_16_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel16);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 18)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel20.setVisibility(View.INVISIBLE);

            fileName = "HighScores_18_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel18);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity.resultOfInput == 20)
        {
            highScoreLabel4.setVisibility(View.INVISIBLE);
            highScoreLabel6.setVisibility(View.INVISIBLE);
            highScoreLabel8.setVisibility(View.INVISIBLE);
            highScoreLabel10.setVisibility(View.INVISIBLE);
            highScoreLabel12.setVisibility(View.INVISIBLE);
            highScoreLabel14.setVisibility(View.INVISIBLE);
            highScoreLabel16.setVisibility(View.INVISIBLE);
            highScoreLabel18.setVisibility(View.INVISIBLE);

            fileName = "HighScores_20_Cards.txt";
            try {
                showHighScores(fileName, highScoreLabel20);  //call the method to read from the proper file and display to the proper TextView label
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //THIS METHOD IS FOR READING SCORES FROM FILE
    public void showHighScores(String fileName, TextView label) throws IOException {
        //fileName = "D:\\CS2450_AndroidStudioProject\\app\\src\\main\\java\\File.txt";

        FileInputStream inputStream = null;
        try {

            inputStream = openFileInput(fileName);  //create a FileInputStream object to open the proper file given the fileName
            InputStreamReader streamReader = new InputStreamReader(inputStream);  //create an InputStreamReader object and give it the FileInputStream object to be able to read that from binary

            BufferedReader bufferedReader = new BufferedReader(streamReader);  //create an BufferedReader object and give it the InputStreamReader object to be able to read binary lines as a String
            StringBuffer stringBuffer = new StringBuffer();

            String line;  //current line in the file

            //while the current line exists (is not empty)
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line + "\n");  //read that line and create a new line (will keep going until end of file is reached)
            }

            label.setText(stringBuffer.toString());  //set the text of the label to be the content read from the file

            System.out.println("High score string is: " + stringBuffer.toString());  //print to the console to make sure we collected the right data (can be seen in the "Run" tab at the bottom)

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally {
            inputStream.close();  //close the stream when done
        }
    }
}
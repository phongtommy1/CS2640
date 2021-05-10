package com.example.cs2640project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Scanner;

public class EndScreen4 extends AppCompatActivity {

    Button backButton;
    TextView endLabel;
    TextView scoreLabel;
    TextView highScore1Label;
    TextView highScore2Label;
    TextView highScore3Label;
    EditText input;
    private static String fileName = "";

    /*
    //for the high score functionality
    private int high1;
    private int high2;
    private int high3;
    private String highScore1Initial;
    private String highScore2Initial;
    private String highScore3Initial;
    */

    static int highScore1 = 0;
    static int highScore2 = 0;
    static int highScore3 = 0;
    private String playerInitials;
    String highScore1Initial;
    String highScore2Initial;
    String highScore3Initial;


    //NEED VARIABLES FOR NEW HIGH SCORE VALUES (AND HIGH SCORE CHECKER METHOD IMPLEMENTATION)

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



        if(MainActivity2.UserInput == 4)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score4);

            //high score implementation
            fileName = "HighScores_4Cards.txt";


            try {
                checkScore(MainActivity2.score4, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 6)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score6);

            //high score implementation
            fileName = "HighScores_6Cards.txt";

            try {
                checkScore(MainActivity2.score6, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 8)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score8);

            //high score implementation
            fileName = "HighScores_8Cards.txt";

            try {
                checkScore(MainActivity2.score8, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 10)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score10);

            //high score implementation
            fileName = "HighScores_10Cards.txt";

            try {
                checkScore(MainActivity2.score10, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 12)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score12);

            //high score implementation
            fileName = "HighScores_12Cards.txt";

            try {
                checkScore(MainActivity2.score12, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 14)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score14);

            //high score implementation
            fileName = "HighScores_14Cards.txt";

            try {
                checkScore(MainActivity2.score14, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 16)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score16);

            //high score implementation
            fileName = "HighScores_16Cards.txt";


            try {
                checkScore(MainActivity2.score16, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 18)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score18);

            //high score implementation
            fileName = "HighScores_18Cards.txt";

            try {
                checkScore(MainActivity2.score18, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            showHighScores(fileName);
        }
        else if(MainActivity2.UserInput == 20)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score20);

            //high score implementation
            fileName = "HighScores_20Cards.txt";

            try {
                checkScore(MainActivity2.score20, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

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

    //THIS WORKS FOR READING FROM FILE
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
            textFileStream = new DataInputStream(getAssets().open(String.format(fileName)));  //CLOSE AND REOPEN THE STREAMS TO START FROM BEGINNING OF FILE AGAIN
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

    private void checkScore(int playerScore, String fileName) throws IOException
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("NEW HIGH SCORE");
        builder.setMessage("ENTER YOUR INITIALS");

        input = new EditText(this);
        builder.setView(input);

        //set POSITIVE (confirm/submit) button
        builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                playerInitials = input.getText().toString();
                Toast.makeText(getApplicationContext(), playerInitials, Toast.LENGTH_LONG).show();
            }
        });


        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();

        DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format(fileName)));
        Scanner inputFile = new Scanner(textFileStream);  //use Scanner to create an inputFile variable that will use the File object we just created
        while(inputFile.hasNextLine())  //search through the entire file
        {
            highScore1 = Integer.parseInt(inputFile.nextLine().split(" ")[0]);  //use Integer.ParseInt to extract the integer values from the file (using whitespace as a delimiter and field 0)
            highScore2 = Integer.parseInt(inputFile.nextLine().split(" ")[0]);
            highScore3 = Integer.parseInt(inputFile.nextLine().split(" ")[0]);
        }
        inputFile.close(); //close the file

        textFileStream = new DataInputStream(getAssets().open(String.format(fileName)));  //CLOSE AND REOPEN THE STREAMS TO START FROM BEGINNING OF FILE AGAIN
        inputFile = new Scanner(textFileStream); //reopen the file to start reading from the beginning again
        while(inputFile.hasNextLine())
        {
            highScore1Initial = inputFile.nextLine().split(" ")[1];  //read the initials from the file using split (with whitespace as delimiter) ([1] means 2nd field)
            highScore2Initial = inputFile.nextLine().split(" ")[1];
            highScore3Initial = inputFile.nextLine().split(" ")[1];
        }
        inputFile.close();   //close the file again


        //if the player score qualifies as a high score
        if(playerScore > highScore1)
        {

            dialog.show(); //show the AlertDialog to allow player to enter initials
            highScore3Initial = highScore2Initial;  //modify the existing high score positions and initials to allow the new high score to be properly placed
            highScore2Initial= highScore1Initial;
            highScore1Initial = playerInitials;
            highScore3 = highScore2;
            highScore2 = highScore1;
            highScore1 = playerScore;

            saveHighScores(highScore1, highScore2, highScore3, highScore1Initial, highScore2Initial, highScore3Initial, fileName);
        }
        else if(playerScore > highScore2 && playerScore < highScore1)
        {
            dialog.show(); //show the AlertDialog to allow player to enter initials
            highScore3Initial = highScore2Initial;
            highScore2Initial = playerInitials;
            highScore3 = highScore2;
            highScore2 = playerScore;

            saveHighScores(highScore1, highScore2, highScore3, highScore1Initial, highScore2Initial, highScore3Initial, fileName);
        }
        else if(playerScore > highScore3 && playerScore < highScore2)
        {
            dialog.show(); //show the AlertDialog to allow player to enter initials
            highScore3Initial = playerInitials;
            highScore3 = playerScore;
            saveHighScores(highScore1, highScore2, highScore3, highScore1Initial, highScore2Initial, highScore3Initial, fileName);
        }
    }

    //FIX THIS!!!
    public void saveHighScores(int high1, int high2, int high3, String initial1, String initial2, String initial3, String fileName) throws FileNotFoundException, IOException
    {

        FileWriter fw = new FileWriter(fileName,true); //use FileWriter and give a file name to create and set parameter to true so that you can append the file

        //File file = new File(String.valueOf(context.getAssets().open(String.format(fileName))));//Environment.getExternalStorageDirectory() + "\\" + fileName);

        try {
            fw.write(Integer.toString(high1) + " " + initial1);// + "\n"); //write the high scores data to the file (using whitespace as delimiter)
            fw.write(Integer.toString(high2) + " " + initial2);// + "\n");
            fw.write(Integer.toString(high3) + " " + initial3);// + "\n");
            fw.flush();  //flush and close the file
            fw.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        /*
        PrintWriter scoresFile = new PrintWriter(fileName); //give fw to PrintWriter to write to file
        scoresFile.println(Integer.toString(high1) + " " + initial1);
        scoresFile.println(Integer.toString(high2) + " " + initial2);
        scoresFile.println(Integer.toString(high3) + " " + initial3);
        scoresFile.close();
         */
    }
}
package com.example.cs2640project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndScreen4 extends AppCompatActivity implements Custom_Dialog.Custom_DialogInterface{

    Button backButton;
    TextView endLabel;
    TextView scoreLabel;
    EditText input;
    public String fileName = "";

    //variables for the various high score info
    static int highScore1 = 0;
    static int highScore2 = 0;
    static int highScore3 = 0;
    public static String playerInitials;
    static String highScore1Initial;
    static String highScore2Initial;
    static String highScore3Initial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen4);

        //link the buttons and labels to their XML counerparts
        backButton = findViewById(R.id.backToMenuButton);
        endLabel = findViewById(R.id.gameOverLabel);
        scoreLabel = findViewById(R.id.scoreLabel);


        //depending on the user input (# of cards to play), show the proper final score, and check the score using the method and giving it the correct score and file name
        if(MainActivity2.UserInput == 4)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score4);

            //high score implementation
            fileName = "HighScores_4_Cards.txt";

            try {
                checkScore(MainActivity2.score4, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 6)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score6);

            //high score implementation
            fileName = "HighScores_6_Cards.txt";

            try {
                checkScore(MainActivity2.score6, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 8)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score8);

            //high score implementation
            fileName = "HighScores_8_Cards.txt";

            try {
                checkScore(MainActivity2.score8, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 10)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score10);

            //high score implementation
            fileName = "HighScores_10_Cards.txt";

            try {
                checkScore(MainActivity2.score10, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 12)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score12);

            //high score implementation
            fileName = "HighScores_12_Cards.txt";

            try {
                checkScore(MainActivity2.score12, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 14)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score14);

            //high score implementation
            fileName = "HighScores_14_Cards.txt";

            try {
                checkScore(MainActivity2.score14, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 16)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score16);

            //high score implementation
            fileName = "HighScores_16_Cards.txt";

            try {
                checkScore(MainActivity2.score16, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 18)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score18);

            //high score implementation
            fileName = "HighScores_18_Cards.txt";

            try {
                checkScore(MainActivity2.score18, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(MainActivity2.UserInput == 20)
        {
            scoreLabel.setText("SCORE: " + MainActivity2.score20);

            //high score implementation
            fileName = "HighScores_20_Cards.txt";

            try {
                checkScore(MainActivity2.score20, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //listener for back to menu button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndScreen4.this, MainActivity.class);  //create a new intent using this and MainActivity
                startActivity(intent); //start the activity using intent (will send you to MainActivity)
            }
        });

    }

    private void checkScore(int playerScore, String fileName) throws IOException {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("NEW HIGH SCORE");
        builder.setMessage("ENTER YOUR INITIALS");

        EditText input = new EditText(this);
        //View view  = LayoutInflater.from(this).inflate(R.layout.activity_end_screen4, null);
        builder.setView(input);

        //set POSITIVE (confirm/submit) button
        builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                playerInitials = input.getText().toString();
                Toast.makeText(getApplicationContext(), "Saved User: " + playerInitials, Toast.LENGTH_LONG).show();  //toast the saved user to the screen to make sure it works

                //if player has qualifying high score, modify the existing high score positions and initials to allow the new high score to be properly placed
                if(playerScore > highScore1)
                {
                    System.out.println(playerInitials + " added");
                    highScore3Initial = highScore2Initial;
                    highScore2Initial = highScore1Initial;
                    highScore1Initial = playerInitials;
                    highScore3 = highScore2;
                    highScore2 = highScore1;
                    highScore1 = playerScore;
                }
                else if (playerScore > highScore2 && playerScore <= highScore1)
                {
                    System.out.println(playerInitials + " added");
                    highScore3Initial = highScore2Initial;
                    highScore2Initial = playerInitials;
                    highScore3 = highScore2;
                    highScore2 = playerScore;
                }
                else if (playerScore > highScore3 && playerScore <= highScore2) {
                    System.out.println(playerInitials + " added");
                    highScore3Initial = playerInitials;
                    highScore3 = playerScore;
                }

                try {
                    //save the updated scores to the file
                    saveHighScores(highScore1, highScore2, highScore3, highScore1Initial, highScore2Initial, highScore3Initial, fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                 System.out.println("Initial AFTER AlertDialog: " + playerInitials);

            }
        });


        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();


        FileInputStream inputStream = null;

        try {

            inputStream = openFileInput(fileName);
            InputStreamReader streamReader = new InputStreamReader(inputStream);  //create an InputStreamReader object and give it the FileInputStream object to be able to read that from binary
            BufferedReader bufferedReader = new BufferedReader(streamReader);  //create an BufferedReader object and give it the InputStreamReader object to be able to read binary lines as a String
            StringBuilder stringBuilder = new StringBuilder();

            String info = "";
            String line;
            //StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                info = info.concat(line + "\n");

                String[] playerInfo = line.split(" ");
                for (int i = 0; i < playerInfo.length; i++) {
                    System.out.println(playerInfo[i]);
                }

                if (playerInfo[0].equalsIgnoreCase("#1:")) {
                    highScore1 = Integer.parseInt(playerInfo[1].trim());
                    highScore1Initial = playerInfo[2].trim();

                }
                if (playerInfo[0].equalsIgnoreCase("#2:")) {
                    highScore2 = Integer.parseInt(playerInfo[1].trim());
                    highScore2Initial = playerInfo[2].trim();
                }
                if (playerInfo[0].equalsIgnoreCase("#3:")) {
                    highScore3 = Integer.parseInt(playerInfo[1].trim());
                    highScore3Initial = playerInfo[2].trim();
                }
            }

            //if the player score qualifies as a high score
            if (playerScore > highScore1) {

                dialog.show(); //show the AlertDialog to allow player to enter initials

            } else if (playerScore > highScore2 && playerScore <= highScore1) {

                dialog.show(); //show the AlertDialog to allow player to enter initials


            } else if (playerScore > highScore3 && playerScore <= highScore2) {

                dialog.show(); //show the AlertDialog to allow player to enter initials


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();

        }


    }

    //THIS METHOD WILL WRITE THE HIGH SCORES TO A FILE (FIX THIS!!!)
    public void saveHighScores(int high1, int high2, int high3, String initial1, String initial2, String initial3, String fileName) throws FileNotFoundException, IOException
    {
        /*
        if(initial1.contains("\n"))
        {
            initial1 = initial1.replace("\n", "");  //might need a space
        }
        else if(initial2.contains("\n"))
        {
            initial2 = initial2.replace("\n", "");  //might need a space
        }
        else if(initial3.contains("\n"))
        {
            initial3 = initial3.replace("\n", "");  //might need a space
        }
        */

        if(initial1 == null)
        {
            initial1 = "--";
        }
        if(initial2 == null)
        {
            initial2 = "--";
        }
        if(initial3 == null)
        {
            initial3 = "--";
        }

        //store the high score data in each line in its own String
        String highScore1 = "#1:" + " " + Integer.toString(high1) + " " + initial1 + "\n";
        String highScore2 = "#2:" + " " + Integer.toString(high2) + " " + initial2 + "\n";
        String highScore3 = "#3:" + " " + Integer.toString(high3) + " " + initial3 + "\n";

        String allScores = highScore1 + highScore2 + highScore3;  //combine them all into one string just for easier writing (not required)

        FileOutputStream outputStream = null;
        try
        {
            outputStream = openFileOutput(fileName, MODE_PRIVATE);  //create the file given the fileName you want and open it (might want to be private)

            outputStream.write(allScores.getBytes()); //write the scores to the file (must use getBytes() because that is what FileOutputStream works with)

            //outputStream.write(highScore1.getBytes());
            //outputStream.write(highScore2.getBytes());
            //outputStream.write(highScore3.getBytes());

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally {
            outputStream.close();
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //THESE ARE THE ALTERNATIVE ALERTDIALOG METHODS (they go with Custon_Dialog.java and layout_dialog.xml)  (NOT USED IN THIS VERSION OF THE APP/I CREATED MY OWN ALERT DIALOG)
    public void openDialog(){
        Custom_Dialog custom_dialog = new Custom_Dialog();
        custom_dialog.show(getSupportFragmentManager(), "Testing");
    }

    @Override
    public void applyText(String textOne) {
        //highScoreLabel.setText(textOne);
        playerInitials = textOne;
    }
}
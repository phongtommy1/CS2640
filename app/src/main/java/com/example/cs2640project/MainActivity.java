package com.example.cs2640project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    //VARIABLES FOR HANDLING GAME AUDIO
    static MediaPlayer gameAudio;  //for game audio using MediaPlayer (make static so that there is only one single instance of game audio)
    static ToggleButton audioButton;  //create the toggle button called audioButton (make static so there is only one instance of it that can be used)
    static Intent closingService;  //the Intent to be used for closing the app by swiping up (make static so there is only one instance of it that can be used)

    Button btnStart;
    Button btnHS;
    EditText etAmount;
    String numOfTitles;
    public static final String USER_INPUT = "user_input";
    int resultOfInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //THIS SECTION OF CODE DEALS WITH HANDLING THE GAME AUDIO/TOGGLE BUTTON FUNCTIONALITY

        //if there is no current audio instance playing
        if(gameAudio == null)
        {
            gameAudio = MediaPlayer.create(MainActivity.this, R.raw.bensound_the_jazz_piano);  //create the mediaPlayer for gameAudio using the sound file in raw folder
            System.out.println("NEW GAME AUDIO INSTANCE CREATED");
            Log.println(Log.ASSERT,"notice", "Instance of audio created"); //so we can see how many times (and when) the game audio instance is created in the "Run" tab when running the app
        }

        audioButton = (ToggleButton) this.findViewById(R.id.toggleButton);  //use findViewById to link audioButton to the toggle button in the XML file

        //for maintaining audioButton toggle state (the name key can be any String you want (make sure to keep it consistent if you want to access it again later), and MODE_PRIVATE makes sure it can't be accessed outside of this class
        SharedPreferences sharedPreferences = getSharedPreferences("saveAudioButtonState", MODE_PRIVATE);

        //initially, set the button state to false by default (so that no audio will be playing and you can toggle music ON)
        //key can be any String you want (make sure to keep it consistent if you want to access it again later)
        audioButton.setChecked(sharedPreferences.getBoolean("value", false));

        //LISTENER FOR THE AUDIO TOGGLE BUTTON
        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //first check if audioButton is checked (if user presses the toggle button)
                if(audioButton.isChecked())
                {
                    //use SharedPreferences editor to edit the state of the toggle button
                    SharedPreferences.Editor editor = getSharedPreferences("saveAudioButtonState", MODE_PRIVATE).edit();  //use the same key
                    editor.putBoolean("value", true);  //use the same key and set the toggle state to true
                    editor.apply();  //apply the edits
                    audioButton.setChecked(true);  //set the audioButton to checked(true)

                    //if no game audio is playing (meaning the button was off and then the user toggled music ON)
                    if(!gameAudio.isPlaying())
                    {
                        gameAudio.start(); //start the music
                        gameAudio.setLooping(true);  //keep the music looping so it doesn't stop after the track ends
                    }

                }
                else //otherwise, if the user toggles music OFF
                {
                    //access the SharedPreferences editor again
                    SharedPreferences.Editor editor = getSharedPreferences("saveAudioButtonState", MODE_PRIVATE).edit(); //use the same key
                    editor.putBoolean("value", false);  //use the same key and set the toggle state to false
                    editor.apply();  //apply the edits
                    audioButton.setChecked(false);  //set the audioButton to checked(false)

                    gameAudio.pause();  //pause the music
                }
            }
        });

        //initialize the static closingService Intent that was declared at the top of the class
        closingService = new Intent(MainActivity.this, ClosingService.class);
        onTaskRemoved(closingService);  //call the onTaskRemoved method for when the user closes the app by swiping up, and pass the closingService Intent as a parameter
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        btnStart = findViewById(R.id.btnStart);
        btnHS = findViewById(R.id.btnHS);
        etAmount = findViewById(R.id.etAmount);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfTitles = etAmount.getText().toString();
                resultOfInput = Integer.parseInt(numOfTitles);
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                // figure out how to pass user's input to next class
                i.putExtra(USER_INPUT, resultOfInput);
                startActivity(i);
            }
        });

        btnHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HighScorePage.class);
                startActivity(i);
            }
        });
        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String numEnter2 = etAmount.getText().toString().trim();
                int numEnter = 0;
                if (!numEnter2.isEmpty()) {
                       numEnter = Integer.parseInt(numEnter2);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Enter An Input", Toast.LENGTH_SHORT).show();
                }
                if(numEnter % 2 == 1 || numEnter > 20 || numEnter < 4) {
                    btnStart.setEnabled(false);
                    btnStart.setTextColor(Color.RED);
                    Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                }
                else{
                    btnStart.setEnabled(true);
                    btnStart.setTextColor(Color.WHITE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





    }

    @Override
    protected void onDestroy()  //for when you press the back button (onDestroy is called from that action, among others)
    {
        super.onDestroy();

        gameAudio.stop();  //stop the audio
        gameAudio.release();  //release the audio when the app is stopped so that it won't be glitchy when starting back up
        gameAudio = null;  //set audio to null

        //reuse the SharedPreferences editor to reset the toggle button state to false
        SharedPreferences.Editor editor = getSharedPreferences("saveAudioButtonState", MODE_PRIVATE).edit();
        editor.putBoolean("value", false);
        editor.apply();
        audioButton.setChecked(false);

        System.out.println("onDestroy() called");
        //audioButton.setTextOff("Toggle Music ON");

        finish();
    }

    private void onTaskRemoved(Intent i) {
        ClosingService closingService = new ClosingService(); //create object of ClosingService class to be able to call the method
        closingService.onTaskRemoved(i); //use the object to call the method and pass the intent
    }
}
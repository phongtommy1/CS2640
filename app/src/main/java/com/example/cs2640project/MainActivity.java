package com.example.cs2640project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    EditText etAmount;
    String numOfTitles;
    public static final String USER_INPUT = "user_input";
    int resultOfInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
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
}
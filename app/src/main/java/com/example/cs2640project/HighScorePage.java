package com.example.cs2640project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HighScorePage extends AppCompatActivity {
    Button btnHS4;
    Button btnHS6;
    Button btnHS8;
    Button btnHS10;
    Button btnHS12;
    Button btnHS14;
    Button btnHS16;
    Button btnHS18;
    Button btnHS20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_page);

        btnHS4 = findViewById(R.id.btnHS4);
        btnHS6 = findViewById(R.id.btnHS6);
        btnHS8 = findViewById(R.id.btnHS8);
        btnHS10 = findViewById(R.id.btnHS10);
        btnHS12 = findViewById(R.id.btnHS12);
        btnHS14 = findViewById(R.id.btnHS14);
        btnHS16 = findViewById(R.id.btnHS16);
        btnHS18 = findViewById(R.id.btnHS18);
        btnHS20 = findViewById(R.id.btnHS20);

        btnHS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore4.class);
                startActivity(i);
            }
        });

        btnHS6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore6.class);
                startActivity(i);
            }
        });

        btnHS8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore8.class);
                startActivity(i);
            }
        });

        btnHS10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore10.class);
                startActivity(i);
            }
        });

        btnHS12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore12.class);
                startActivity(i);
            }
        });

        btnHS14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore14.class);
                startActivity(i);
            }
        });

        btnHS16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore16.class);
                startActivity(i);
            }
        });

        btnHS18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore18.class);
                startActivity(i);
            }
        });

        btnHS20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HighScorePage.this, HighScore20.class);
                startActivity(i);
            }
        });

    }
}


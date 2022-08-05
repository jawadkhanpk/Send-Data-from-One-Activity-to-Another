package com.example.senddatafromoneactivitytoanother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class RecievingActivity extends AppCompatActivity {

    public static final String NAME = "NAME";   // this one
    public static final String AGE = "AGE";     // this one

    private TextView nameText, ageText;

    private String name;
    private int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieving);

        nameText  = findViewById(R.id.tvname);
        ageText = findViewById(R.id.tvage);

        Intent i = getIntent();
        name = i.getStringExtra(NAME);
        age = i.getIntExtra(AGE, 0);    // this one

        Log.d("ABC", String.valueOf(age));
        nameText.setText("HI "+name);
        ageText.setText("Your age is "+age);


    }
}
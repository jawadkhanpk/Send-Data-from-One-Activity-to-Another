package com.example.senddatafromoneactivitytoanother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText etname;
    EditText etage;
    Button btnsendData;

    // strings
    private String name;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.etname);
        etage = findViewById(R.id.etage);
        btnsendData = findViewById(R.id.btnsend);

        btnsendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendData();

            }
        });

    }

    // function
    private void sendData() {

        name = etname.getText().toString().trim();
        age = Integer.parseInt(etage.getText().toString().trim());


        Intent i = new Intent(MainActivity.this, RecievingActivity.class);
        i.putExtra(RecievingActivity.NAME,name);
        i.putExtra(RecievingActivity.AGE,age);

        startActivity(i);
    }
}
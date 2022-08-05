package com.example.senddatafromoneactivitytoanother;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.etname);
        etage = findViewById(R.id.etage);
        btnsendData = findViewById(R.id.btnsend);

        //getting data from edit text
        name = etname.getText().toString().trim();
        age = etage.getText().toString().trim();

        btnsendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // function call
                sendData();

            }
        });

    }

    // function
    private void sendData() {

        if (etname.getText().toString().equals("")) {
            etname.setError("Name is Required");
        }else if (etage.getText().toString().equals("")){
            etage.setError("Age is Required");
        }else {

            Intent i = new Intent(MainActivity.this, RecievingActivity.class);
            i.putExtra(RecievingActivity.NAME,name);
            i.putExtra(RecievingActivity.AGE,age);

            startActivity(i);
        }


    }
}
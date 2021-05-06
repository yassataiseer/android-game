package com.example.vidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    int low = 0;
    int high = 9;
    int random_guess = r.nextInt(high-low) + low;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button SubmitButton = findViewById(R.id.Submit);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View Game) {
                EditText UserInput=findViewById(R.id.UsersGuess);
                if (TextUtils.isEmpty(UserInput.getText())){
                    Context context = getApplicationContext();
                    CharSequence text = "YOU DID NOT SEND ANYTHING";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    int GuessedNumber = Integer.parseInt(UserInput.getText().toString());
                    String Answer = "";
                    if(random_guess==GuessedNumber){
                        Answer = "You Won";
                    }
                    else{
                        Answer = "Wrong...Try Again";
                    }
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, Answer, duration);
                    toast.show();
                }
            }
        });


        //Restart Button
        final Button RestartButton = findViewById(R.id.Restart);
        RestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });



    }





}
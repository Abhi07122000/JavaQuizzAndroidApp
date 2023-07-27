
package com.example.multipage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"Java is a Person?", "Java Was Introduced in 1850?", "Java Was Created using C++?", "Java Supports Interfaces?", "Java has Abstract classes?"};
    private boolean[] answers = {false, false, false, true, true};
    Button yes;
    Button no;
    private int score = 0;
    private int index = 0;
    TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questions.length - 1){
                    if(answers[index++]){
                        score++;
                    }
                    if(index <= questions.length - 1){
                        question.setText(questions[index]);
                    }else {
                        Toast.makeText(MainActivity.this, "Your Score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Restart to play again ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index <= questions.length - 1){
                    if(!answers[index++]){
                        score++;
                    }
                    if(index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }else {
                        Toast.makeText(MainActivity.this, "Your Score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Restart to play again ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
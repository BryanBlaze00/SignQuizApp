package com.example.signquizapp;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView question, total_questions;
    ImageView sign;
    Button answerA_btn, answerB_btn, answerC_btn, answerD_btn, submit_btn;

    int score = 0;
    int totalQuestion = QandA.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        total_questions = findViewById(R.id.total_questions);
        sign = findViewById(R.id.image);
        answerA_btn = findViewById(R.id.answerA_btn);
        answerB_btn = findViewById(R.id.answerB_btn);
        answerC_btn = findViewById(R.id.answerC_btn);
        answerD_btn = findViewById(R.id.answerD_btn);
        submit_btn = findViewById(R.id.submit_btn);

        answerA_btn.setOnClickListener(this);
        answerB_btn.setOnClickListener(this);
        answerC_btn.setOnClickListener(this);
        answerD_btn.setOnClickListener(this);
        submit_btn.setOnClickListener(this);

        total_questions.setText("Total Questions: " + totalQuestion);
        
        loadNewQuestion();
    }

    private void loadNewQuestion( ) {

        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        sign.setImageResource(QandA.images[currentQuestionIndex]);
        question.setText(QandA.question[currentQuestionIndex]);
        answerA_btn.setText(QandA.choices[currentQuestionIndex][0]);
        answerB_btn.setText(QandA.choices[currentQuestionIndex][1]);
        answerC_btn.setText(QandA.choices[currentQuestionIndex][2]);
        answerD_btn.setText(QandA.choices[currentQuestionIndex][3]);
    }

    private void finishQuiz( ) {
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+score+" out of "+totalQuestion)
                .setPositiveButton("Restart",((dialogInterface, i) -> restartQuiz()))
                .show();
    }

    private void restartQuiz( ) {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {

        answerA_btn.setBackgroundColor(Color.WHITE);
        answerB_btn.setBackgroundColor(Color.WHITE);
        answerC_btn.setBackgroundColor(Color.WHITE);
        answerD_btn.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) v;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QandA.answers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }
        else{
            //Choices
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);
        }
    }
}
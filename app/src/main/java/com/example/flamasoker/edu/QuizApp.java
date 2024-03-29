package com.example.flamasoker.edu;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;


import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizApp extends AppCompatActivity {
    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    static  final private  int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String quizData[][] = {
            //{"Pais", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"2*5", "10", "5", "15", "7"},
            {"25/2", "12.5", "12", "11", "15"},
            {"50/2+5", "30", "1", "10", "15"},
            {"5^2", "25", "10", "7", "100"},
            {"2^3*10", "80", "16", "11", "15"},
            {"2-5", "-3", "12", "11", "15"},
            {"15-15", "0", "12", "1", "5"},
            {"2+10/3", "4", "2", "11", "1"},
            {"5/2+0.5", "3", "12", "11", "15"},
            {"25/2", "12.5", "12", "11", "15"},
            {"5*4/2", "10", "2", "1", "15"},
            {"25/2", "12.5", "12", "11", "15"},
            {"2+1", "3", "112", "1", "35"},
            {"25/2", "12.5", "12", "11", "15"},
            {"25/2", "12.5", "12", "11", "15"},




    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);

        countLabel = (TextView) findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) findViewById(R.id.answerBtn3);
        answerBtn4 = (Button) findViewById(R.id.answerBtn4);

        int quizCategory = getIntent(). getIntExtra("QUIZ_CATEGORY", 0);
        Log.v("CATEGORY_TAG", quizCategory + "");

        for (int i = 0; i < quizData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //Country
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);
        }
        showNextQuiz();
    }
    public  void showNextQuiz(){
        countLabel.setText("Q" + quizCount);
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        ArrayList<String> quiz = quizArray.get(randomNum);
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        quizArray.remove(randomNum);



    }
    public void checkAnswer(View view){

        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;
        if (btnText.equals(rightAnswer)){
            alertTitle = "Correcto!";
            rightAnswerCount++;
        }else {
            alertTitle = "Incorrecto...";
        }
        Context context;
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Respuesta : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT){
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}

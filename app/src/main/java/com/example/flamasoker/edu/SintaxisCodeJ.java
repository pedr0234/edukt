package com.example.flamasoker.edu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SintaxisCodeJ extends AppCompatActivity implements View.OnClickListener {
     private EditText result;
    private Button validation;
    private TextView request;
    private String correct;
    private ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintaxis_code_j);

        backButton=findViewById(R.id.backButton);
        result=findViewById(R.id.result);

        validation=findViewById(R.id.validation);
        validation.setOnClickListener(this);
        backButton.setOnClickListener(this);
        request=findViewById(R.id.request);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.validation:

                correct= String.valueOf(result.getText());
                if (correct.equals("String")){
                    request.setText("Correcto");
                }else{
                    request.setText("Vuelve a intentarlo");
                }
                break;
            case R.id.backButton:
                finish();
                break;
        }
    }
}

package com.example.flamasoker.edu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SintaxisCode extends AppCompatActivity implements View.OnClickListener {
    EditText result;
    Button validation;
    TextView request;
    String correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintaxis_code);

        result=findViewById(R.id.result);
        validation=findViewById(R.id.validation);
        validation.setOnClickListener(this);
        request=findViewById(R.id.request);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.validation:

                        correct= String.valueOf(result.getText());
                    if (correct.equals("<?php")){
                        request.setText("Correcto");
                    }else{
                        request.setText("Vuelve a intentarlo");
                    }
                break;
        }
    }
}

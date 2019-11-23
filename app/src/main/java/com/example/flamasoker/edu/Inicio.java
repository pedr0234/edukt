package com.example.flamasoker.edu;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    Button ready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ready=findViewById(R.id.ready);
        ready.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ready:
                Intent i = new Intent(this, ApiRest.class);
                startActivity(i);
                break;
        }
    }
/*
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn1:
                Intent i=new Intent(this,NaviationDrawerMain.class);
                startActivity(i);
                break;
            case R.id.btn2:
                break;

        }

    }
    */

}

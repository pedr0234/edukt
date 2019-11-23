package com.example.flamasoker.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class list extends AppCompatActivity {

    ListView list;

    String [][] data={
            {"Lengua Materna","Asinatura dedicada a la comprension lectora"},
            {"Aritmetica","Asignatura dedicada al conocimiento de operaciones matematicas basicas"},
            {"Ciencias Naturales","Asignatura dedicada al estudio de la naturaleza"},
            {"Code </>","Aprende sintaxis de distintos lenguajes de programación"},

    };

    int [] dataTag={R.drawable.libros,R.drawable.calculadora,R.drawable.cn,R.drawable.images};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list=(ListView) findViewById(R.id.myList);
        list.setAdapter(new Adapter(this,data,dataTag));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        intent=new Intent(getApplicationContext(),LenguaMaterna.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(getApplicationContext(),Ejercicios.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(getApplicationContext(),CienciasNaturales.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(getApplicationContext(),SintaxisCode.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }
}

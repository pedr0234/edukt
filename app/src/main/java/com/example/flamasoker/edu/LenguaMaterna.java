package com.example.flamasoker.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LenguaMaterna extends AppCompatActivity {
    ListView ListaT;
    List<String> cuento;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lengua_materna);

        ListaT = findViewById(R.id.cuentos);
        cuento = new ArrayList<>();
        cuento.add("Pinocho");
        cuento.add("Los tres ceditos");

        ArrayAdapter<String> aTiposTareas = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, cuento);
        ListaT.setAdapter(aTiposTareas);

        ListaT.setOnItemClickListener(new AdapterView.OnItemClickListener

                () {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), ApiRest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), ApiRest2.class);
                    startActivityForResult(myIntent, 0);
                }


            }
        });
    }
}

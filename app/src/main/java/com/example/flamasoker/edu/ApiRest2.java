package com.example.flamasoker.edu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiRest2 extends AppCompatActivity {

    private TextView titulo,cuento;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_rest);

        titulo= findViewById(R.id.titulo);
        cuento=findViewById(R.id.cuento);
        mQueue = Volley.newRequestQueue(this);

     /*   buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

      */
        jsonParse();
    }
    private void jsonParse(){
        String url = "http://coffeefood.com.mx/coffeefood.com.mx/kaab/authors";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            int i =1;
                            JSONObject data = jsonArray.getJSONObject(i);
                            int id= data.getInt("id");
                            String Author = data.getString("Author");
                            String Titulo = data.getString("Titulo");
                            String Libro = data.getString("Libro");

                            //     mTextViewResult.append("texto num."+id+ " " + String.valueOf(Author) + "\n"+ Titulo +"\n" + Libro +"\n\n");

                            titulo.append(Titulo);
                            cuento.append(Libro);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}

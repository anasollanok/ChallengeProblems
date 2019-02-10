package com.example.challengeproblems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.challengeproblems.Model.Hospital;
import com.example.challengeproblems.adapters.HospitalRecycleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HospitalActivity extends AppCompatActivity {

    private final String JSON_URL = "https://datos.cdmx.gob.mx/api/records/1.0/search/?dataset=hospitales-y-centros-de-salud";
    private JsonObjectRequest request;
    private RequestQueue requestQueue;
    private List<Hospital> hospitales;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        hospitales = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleView);
        jsonRequest();
    }

    private void jsonRequest(){
        request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray hospitalesJSON = response.getJSONArray("records");
                            JSONObject jsonObject = null;
                            for(int i=0; i<hospitalesJSON.length(); i++){
                                jsonObject = hospitalesJSON.getJSONObject(i);
                                Hospital hospital = new Hospital();
                                hospital.setId(jsonObject.getString("recordid"));
                                JSONObject fieldsJSON = jsonObject.getJSONObject("fields");
                                hospital.setLatitud(fieldsJSON.getString("latitud"));
                                hospital.setTitular(fieldsJSON.getString("titular"));
                                hospital.setNombre(fieldsJSON.getString("nombre"));
                                hospital.setLongitud(fieldsJSON.getString("longitud"));
                                hospitales.add(hospital);
                            }
                        }
                        catch (JSONException jsonException){
                            jsonException.printStackTrace();
                        }
                        setRecyclerView(hospitales);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error del servidor", Toast.LENGTH_LONG).show();
            }
        });

        requestQueue = Volley.newRequestQueue(HospitalActivity.this);
        requestQueue.add(request);
    }

    private void setRecyclerView(List<Hospital> hospitales){
        HospitalRecycleAdapter hospitalRecycleAdapter = new HospitalRecycleAdapter(this, hospitales);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(hospitalRecycleAdapter);
    }
}

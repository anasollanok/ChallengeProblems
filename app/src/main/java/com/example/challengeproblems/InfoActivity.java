package com.example.challengeproblems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.challengeproblems.Model.Hospital;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Hospital hospital = (Hospital) getIntent().getSerializableExtra("hospital");
        loadInfo(hospital);
    }

    private void loadInfo(Hospital hospital){
        TextView id, nombre, titular, latitud, longitud;
        id = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        titular = findViewById(R.id.titular);
        latitud = findViewById(R.id.latitud);
        longitud = findViewById(R.id.longitud);
        id.setText(hospital.getId());
        nombre.setText(hospital.getNombre());
        titular.setText(hospital.getTitular());
        latitud.setText(hospital.getLatitud());
        longitud.setText(hospital.getLongitud());
    }
}

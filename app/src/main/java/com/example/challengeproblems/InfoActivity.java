package com.example.challengeproblems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.challengeproblems.Model.Hospital;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Hospital pokeCard = (Hospital) getIntent().getSerializableExtra("hospital");
    }

    private void loadInfo(Hospital hospital){
        TextView id, nombre, titular, latitud, longitud;
        id = findViewById(R.id.id_card);
        nombre = findViewById(R.id.card_name);
        titular = findViewById(R.id.author_card);
        latitud = findViewById(R.id.card);
        longitud = findViewById(R.id.card);
        RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
        id.setText(hospital.getId());
        nombre.setText(hospital.getNombre());
        titular.setText(hospital.getTitular());
        latitud.setText(hospital.getLatitud());
        longitud.setText(hospital.getLongitud());

        //Glide.with(this).load(pokeCard.getImageUrl()).apply(options).into(image);
    }
}

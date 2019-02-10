package com.example.challengeproblems.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.challengeproblems.Model.Hospital;

import java.util.List;

public class HospitalRecycleAdapter extends RecyclerView.Adapter<HospitalRecycleAdapter.HospitalRecordHolder>{
    private Context context;
    private List<Hospital> hospitales;
    RequestOptions options;

    public HospitalRecycleAdapter(Context context, List<Hospital> cards) {
        this.context = context;
        this.hospitales = cards;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
    }

    @NonNull
    @Override
    public HospitalRecycleAdapter.HospitalRecordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.poke_card_item, viewGroup, false);
        final HospitalRecordHolder hospitalRecordHolder = new HospitalRecordHolder(view);
        hospitalRecordHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hospital hospital = hospitales.get(hospitalRecordHolder.getAdapterPosition());
                Toast.makeText(context, hospital.getNombre(), Toast.LENGTH_SHORT).show();
                Intent it = new Intent(context, MainActivity.class);
                it.putExtra("pokemon", hospital);
                context.startActivity(it);
            }
        });
        return hospitalRecordHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalRecycleAdapter.HospitalRecordHolder hospitalRecordHolder, int i) {
        hospitalRecordHolder.id.setText(hospitales.get(i).getId());
        hospitalRecordHolder.titular.setText(hospitales.get(i).getTitular());
        hospitalRecordHolder.nombre.setText(hospitales.get(i).getNombre());
        hospitalRecordHolder.latitud.setText(hospitales.get(i).getLatitud());
        hospitalRecordHolder.longitud.setText(hospitales.get(i).getLongitud());

        //Glide.with(context).load(hospitales.get(i).getImageUrl()).apply(options).into(pokeRecordHolder.image);
    }

    @Override
    public int getItemCount() {
        return hospitales.size();
    }

    public static class HospitalRecordHolder extends RecyclerView.ViewHolder{

        private String id, titular, nombre, latitud, longitud;

        public HospitalRecordHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_card);
            titular = itemView.findViewById(R.id.card_name);
            nombre = itemView.findViewById(R.id.author_card);
            latitud = itemView.findViewById(R.id.author_card);
            longitud = itemView.findViewById(R.id.card);
        }
    }
}
package com.example.challengeproblems.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.challengeproblems.InfoActivity;
import com.example.challengeproblems.Model.Hospital;
import com.example.challengeproblems.R;

import java.util.List;

public class HospitalRecycleAdapter extends RecyclerView.Adapter<HospitalRecycleAdapter.HospitalRecordHolder>{
    private static Context context;
    private List<Hospital> hospitales;
    RequestOptions options;

    public HospitalRecycleAdapter(Context context, List<Hospital> hospitales) {
        this.context = context;
        this.hospitales = hospitales;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.load_info).error(R.drawable.load_info);
    }

    @NonNull
    @Override
    public HospitalRecycleAdapter.HospitalRecordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.info_hospital_item, viewGroup, false);
        final HospitalRecordHolder hospitalRecordHolder = new HospitalRecordHolder(view);
        hospitalRecordHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hospital hospital = hospitales.get(hospitalRecordHolder.getAdapterPosition());
                Toast.makeText(context, hospital.getNombre(), Toast.LENGTH_SHORT).show();
                Intent it = new Intent(context, InfoActivity.class);
                it.putExtra("hospital", hospital);
                context.startActivity(it);
            }
        });
        return hospitalRecordHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalRecycleAdapter.HospitalRecordHolder hospitalRecordHolder, int i) {
        String size = Integer.toString(hospitales.size());
        Log.i("size of hospitales", hospitales.get(i).getImage());
        hospitalRecordHolder.titular.setText(hospitales.get(i).getTitular());
        hospitalRecordHolder.nombre.setText(hospitales.get(i).getNombre());
        hospitalRecordHolder.latitud.setText(hospitales.get(i).getLatitud());
        hospitalRecordHolder.longitud.setText(hospitales.get(i).getLongitud());

        //Glide.with(context).load(hospitales.get(i).getImage()).apply(options).into(hospitalRecordHolder.image);
        Glide.with(context.getApplicationContext()).load("https://images.pexels.com/photos/207962/pexels-photo-207962.jpeg").into(hospitalRecordHolder.image);
    }

    @Override
    public int getItemCount() {
        return hospitales.size();
    }

    public static class HospitalRecordHolder extends RecyclerView.ViewHolder{

        TextView id, titular, nombre, latitud, longitud;
        ImageView image;

        public HospitalRecordHolder(@NonNull View itemView) {
            super(itemView);
            //id = itemView.findViewById(R.id.id);
            titular = itemView.findViewById(R.id.titular);
            nombre = itemView.findViewById(R.id.nombre);
            latitud = itemView.findViewById(R.id.latitud);
            longitud = itemView.findViewById(R.id.longitud);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
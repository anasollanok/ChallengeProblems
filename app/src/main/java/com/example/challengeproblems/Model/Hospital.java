package com.example.challengeproblems.Model;

import android.text.Html;
import android.text.Spanned;

import java.io.Serializable;

public class Hospital implements Serializable {

    private String id, titular, nombre, latitud, longitud;

    public Hospital() {
    }



    public Hospital(String id, String titular, String nombre, String latitud, String longitud) {
        this.id = id;
        this.titular = titular;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}

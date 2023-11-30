package com.example.trainingapp;

public class Entrenamiento {

    // Atributos
    private String nombre;
    private int logoResId;

    public Entrenamiento(String nombre, int logoResId) {
        this.nombre = nombre;
        this.logoResId = logoResId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLogoResId() {
        return logoResId;
    }
}

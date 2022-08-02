package com.edu.utp.corrientazo.modelo;

public class OpcionCarne {
    String nombre;
    

    public OpcionCarne(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getNombre();
    }
}

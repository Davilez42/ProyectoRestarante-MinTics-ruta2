package com.edu.utp.corrientazo.modelo;

public class OpcionJugo {
    String nombre;

    public String getNombre() {
        return nombre;
    }


    public OpcionJugo(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getNombre();
    }
    
}

package com.edu.utp.corrientazo.modelo;

public class OpcionEnsalada {
    String nombre;
    

    public OpcionEnsalada(String nombre) {
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

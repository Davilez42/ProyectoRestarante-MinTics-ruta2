package com.edu.utp.corrientazo.modelo;

public class OpcionPrincipio {
    String nombre;

    public String getNombre() {
        return nombre;
    }


    public OpcionPrincipio(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getNombre();
    }
}

package com.edu.utp.corrientazo.modelo;

public class OpcionCarne {
    private Integer id;
    private String nombre;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

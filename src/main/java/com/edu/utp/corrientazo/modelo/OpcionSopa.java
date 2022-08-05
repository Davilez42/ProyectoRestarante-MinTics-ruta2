package com.edu.utp.corrientazo.modelo;

public class OpcionSopa {
    private Integer id;
    private String nombre;

    public OpcionSopa(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
}

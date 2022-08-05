package com.edu.utp.corrientazo.modelo;

public class OpcionJugo {
    private Integer id;
    private String nombre;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
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

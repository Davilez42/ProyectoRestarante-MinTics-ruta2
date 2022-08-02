package com.edu.utp.corrientazo.modelo;

public class PedidoAdicional {
    private String nombre;
    private int precio;


    public PedidoAdicional(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
  
    public int getPrecio() {
        return precio;
    }
 
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getNombre();
    }
    

    
}

package com.edu.utp.corrientazo.modelo;

public class PedidoAdicional {
    
    private int precio;
    private Integer id;
    private String nombre;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


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

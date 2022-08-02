package com.edu.utp.corrientazo.modelo;

public class PagoExcepcion extends Exception {

    public PagoExcepcion() {
        super("El efectivo es menor al total");
    }
    
}

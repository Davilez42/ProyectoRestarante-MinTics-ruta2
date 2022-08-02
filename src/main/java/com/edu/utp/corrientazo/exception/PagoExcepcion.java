package com.edu.utp.corrientazo.exception;

public class PagoExcepcion extends Exception {

    public PagoExcepcion() {
        super("El efectivo es menor al total");
    }
    
}

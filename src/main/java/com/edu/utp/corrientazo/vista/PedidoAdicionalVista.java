package com.edu.utp.corrientazo.vista;

import java.util.Scanner;

import com.edu.utp.corrientazo.controlador.Controlador;
import com.edu.utp.corrientazo.modelo.Pedido;
import com.edu.utp.corrientazo.modelo.PedidoAdicional;

public class PedidoAdicionalVista {
    private Scanner sc;
    private Controlador c;
    public PedidoAdicionalVista(Scanner sc, Controlador c) {
        this.sc = sc;
        this.c = c;
    }

    

    public PedidoAdicional pedirInformacionPedidoAdicional( ) {
        System.out.println("----INFORMACION PEDIDO ADICIONAL----");
        System.out.println(" Ingrese el nombre:");
        var nombre = sc.nextLine();
        var adicional_ = new PedidoAdicional(nombre, 1300);
        return adicional_;

    }
    
}

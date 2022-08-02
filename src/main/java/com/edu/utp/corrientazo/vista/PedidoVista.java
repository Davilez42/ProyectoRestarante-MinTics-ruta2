package com.edu.utp.corrientazo.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.edu.utp.corrientazo.controlador.Controlador;
import com.edu.utp.corrientazo.modelo.Corrientazo;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.OpcionCarne;
import com.edu.utp.corrientazo.modelo.OpcionEnsalada;
import com.edu.utp.corrientazo.modelo.OpcionJugo;
import com.edu.utp.corrientazo.modelo.OpcionPrincipio;
import com.edu.utp.corrientazo.modelo.OpcionSopa;
import com.edu.utp.corrientazo.modelo.Pedido;

public class PedidoVista {
    /**
     *
     */
    private static final int CORRIENTAZO_PRECIO = 12_000;
    private Scanner sc;
    private Controlador c;
    
    public PedidoVista(Scanner sc,Controlador c) {
        this.sc = sc;
        this.c = c;
    }

    public Pedido pedirInformacionPedido() {
        
        System.out.print("Porfavor Ingrese el nombre:");
        var nombre = sc.nextLine();
    
        var sopa = elegirSopa();
        var carne = elegirCarne();
        var principio = elegirPrincipio();
        var jugo = elegirJugo();
        var ensalada = elegirEnsalada();

        Pedido pedido = new Pedido(nombre,new Corrientazo(CORRIENTAZO_PRECIO, sopa, carne, principio, jugo, ensalada));
        return pedido;
    }



    private OpcionSopa elegirSopa(){
        var opciones = c.getSopas();
        OpcionSopa resultado = null;
        System.out.println("ELIGA LA SOPA");
        do {
            try {

                for (int i = 0; i < opciones.size(); i++) {
                    System.out.printf("%d -> %s %n", i + 1, opciones.get(i));
                }
                System.out.println("Ingrese una opcion:");
                var opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= opciones.size()) {
                    resultado = opciones.get(opcion - 1);
                    System.out.println("Opcion Elegida:"+ opciones.get(opcion-1));
                }
                else{
                    System.err.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalidad" );
               

            }finally{
                sc.nextLine();
            }

        } while (resultado==null);

        return resultado;
    }

    private OpcionCarne elegirCarne(){
        var opciones = c.getCarnes();
        OpcionCarne resultado = null;
        System.out.println("ELIGA LA CARNE");
        do {
            try {

                for (int i = 0; i < opciones.size(); i++) {
                    System.out.printf("%d -> %s %n", i + 1, opciones.get(i));
                }
                System.out.println("Ingrese una opcion:");
                var opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= opciones.size()) {
                    resultado = opciones.get(opcion - 1);
                    System.out.println("Opcion Elegida:"+ opciones.get(opcion-1));
                }
                else{
                    System.err.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalidad" );
               

            }finally{
                sc.nextLine();
            }

        } while (resultado==null);

        return resultado;
    }
    private OpcionPrincipio elegirPrincipio(){
        var opciones = c.getPrincipios();
        OpcionPrincipio resultado = null;
        System.out.println("ELIGA EL PRINCIPIO");
        do {
            try {

                for (int i = 0; i < opciones.size(); i++) {
                    System.out.printf("%d -> %s %n", i + 1, opciones.get(i));
                }
                System.out.println("Ingrese una opcion:");
                var opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= opciones.size()) {
                    resultado = opciones.get(opcion - 1);
                    System.out.println("Opcion Elegida:"+ opciones.get(opcion-1));
                }
                else{
                    System.err.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalidad" );
               

            }finally{
                sc.nextLine();
            }

        } while (resultado==null);

        return resultado;
    }

    private OpcionJugo elegirJugo(){
        var opciones = c.getJugos();
        OpcionJugo resultado = null;
        System.out.println("ELIGA EL JUGO");
        do {
            try {

                for (int i = 0; i < opciones.size(); i++) {
                    System.out.printf("%d -> %s %n", i + 1, opciones.get(i));
                }
                System.out.println("Ingrese una opcion:");
                var opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= opciones.size()) {
                    resultado = opciones.get(opcion - 1);
                    System.out.println("Opcion Elegida:"+ opciones.get(opcion-1));
                }
                else{
                    System.err.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalidad" );
               

            }finally{
                sc.nextLine();
            }

        } while (resultado==null);

        return resultado;
    }

    private OpcionEnsalada elegirEnsalada(){
        var opciones = c.getEnsaladas();
        OpcionEnsalada resultado = null;
        System.out.println("ELIGA LA ENSALADA");
        do {
            try {
                System.out.printf("%d -> %s %n", 0,"Sin ensalada");
                for (int i = 0; i < opciones.size(); i++) {
                    System.out.printf("%d -> %s %n", i + 1, opciones.get(i));
                }
                System.out.println("Ingrese una opcion:");
                var opcion = sc.nextInt();

                if(opcion==0){
                    break;
                }

                if (opcion >= 1 && opcion <= opciones.size()) {
                    resultado = opciones.get(opcion - 1);
                    System.out.println("Opcion Elegida:"+ opciones.get(opcion-1));
                }
                else{
                    System.err.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalidad" );
               

            }finally{
                sc.nextLine();
            }

        } while (resultado==null);

        return resultado;
    }

    

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    
    
   
}

package com.edu.utp.corrientazo.vista;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.edu.utp.corrientazo.controlador.Controlador;

public class MenuPrincipal {
    private Scanner sc;
    private Controlador c;

    public MenuPrincipal(Scanner sc, Controlador c) {
        this.sc = sc;
        this.c = c;
    }

    public void iniciarAplicacion() throws SQLException {
        System.out.println("---------MENU PRINCIPAL----");
        var enMenu = true;
        do {
            try {
                System.out.println("1.Gestion de pedidos");
                System.out.println("2.pagos de mesa");
                System.out.println("3.Tablas maestras");
                System.out.println("0.salir");
                System.out.print("Ingrese una opcion:");
                var opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Hasta luego....");
                        enMenu = false;
                        break;

                    case 1:
                        abrirMenuGestionPedidos();
                        break;

                    case 2:
                        pagosMesa();
                        break;
                    case 3:
                        tablasMaestras();
                        break;

                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                System.err.println("Error, opciones invalidad");
            } 

        } while (enMenu);

    }

    private void tablasMaestras() {
        var salida = false;
        while(!salida){
            try {
                System.out.println(".: TABLAS MAESTRAS :.");
                System.out.println("1 -> Mesa");
                System.out.println("2 -> Opciones de Sopa");
                System.out.println("3 -> Opciones de Principio");
                System.out.println("4 -> Opciones de Carne");
                System.out.println("5 -> Opciones de Ensalada");
                System.out.println("6 -> Opciones de Jugo");
                System.out.println("7 -> Opciones de Adicionales");
                System.out.println("0 -> Salir al menu principal");
                System.out.print("Cual es su opcion: ");
                var opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 0:
                        salida = true;
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;

                    default:
                        System.err.println("Opción inválida, intente de nuevo");
                        break;
                }
            } catch (Exception e) {
               System.err.println("Error");
            }

        } ;

    }

    private void pagosMesa() throws SQLException {
        var mesa = c.consultarMesa();
        c.pagoDeMesa(mesa);

    }

    private void abrirMenuGestionPedidos() throws SQLException {
        var mesa = c.consultarMesa();
        var salida = false;
        while(!salida){
            try {
                System.out.println(".: GESTION DE PEDIDOS :.");
                System.out.println("1 -> Ver pedidos de mesa");
                System.out.println("2 -> Agregar pedido");
                System.out.println("3 -> Agregar adicional a pedido");
                System.out.println("4 -> Entregar pedido");
                System.out.println("0 -> Salir al menu principal");
                System.out.print("Cual es su opcion: ");
                var opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 0:
                        salida = true;
                        break;
                    case 1:
                        c.mostrarPedidos(mesa);
                        salida = true;
                        break;
                    case 2:
                        c.agregarPedido(mesa);
                        salida = true;
                        break;
                    case 3:
                        c.agregarAdicional(mesa);
                        salida = true;
                        break;

                    case 4:
                        c.entregarPedido(mesa);
                        salida = true;
                        break;

                    default:
                        System.err.println("Opción inválida, intente de nuevo");
                        break;

                }
            } catch (InputMismatchException  e) {
               System.err.println("Error");
               sc.nextLine();
            }

        } ;
    }
}

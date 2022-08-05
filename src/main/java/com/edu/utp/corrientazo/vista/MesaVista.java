package com.edu.utp.corrientazo.vista;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



import com.edu.utp.corrientazo.controlador.Controlador;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.Pedido;

public class MesaVista {
    private Scanner sc;
    private Controlador c;

    public MesaVista(Scanner sc, Controlador c) {
        this.sc = sc;
        this.c = c;
    }

    public Mesa pedirInformacionMesa() {
        System.out.println("-----INFORMACION DE LA MESA-----");
        System.out.println("Ingrese el numero de la mesa:");
        var numero = sc.nextLine();
        Mesa mesa = new Mesa(numero);
        return mesa;
    }

    public void mostrarMesas(List<Mesa> listamesas) {
        System.out.println("MESAS EN EL SISTEMAS");
        listamesas.forEach(System.out::println);
    }

    public Mesa consultarMesa() throws SQLException {
        var mesas = c.getListamesas();
        Mesa resultado = null;

        do {
            try {

                System.out.println("Las mesas existentes son:");
                for (int i = 0; i < mesas.size(); i++) {
                    System.out.printf("%d -> %s %n", i + 1, mesas.get(i));
                }
                System.out.println("Ingrese una opcion:");
                var opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= mesas.size()) {
                    resultado = mesas.get(opcion - 1);
                    System.out.println("La mesa seleccionada es:" + mesas.get(opcion - 1));
                } else {
                    System.err.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalidad");

            } finally {
                sc.nextLine();
            }

        } while (resultado == null);

        return resultado;
    }

    //para entregar un pedido
    public Pedido consultarPedidos(List<Pedido> pedidos) {
        Pedido resultado = null;
        System.out.println("ELIJA UN PEDIDO A ENTREGAR");

        do {
            try {

                System.out.println("Los pedidos existentes son:");
                for (int i = 0; i < pedidos.size(); i++) {
                    System.out.printf("%d -> %s %n", i + 1, pedidos.get(i));
                }
                System.out.println("Ingrese una opcion:");
                var opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= pedidos.size()) {
                    resultado = pedidos.get(opcion - 1);
                    System.out.println("El Pedido seleccionado es:" + pedidos.get(opcion - 1));
                } else {
                    System.err.println("Opcion incorrecta");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalidad");

            } finally {
                sc.nextLine();
            }

        } while (resultado == null);

        return resultado;
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        System.out.println("Los pedidos existentes son:");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.printf("%d -> %s %n", i + 1, pedidos.get(i));
        }

    }

    public Integer leerEfectivo() {
        Integer respuesta = null;
        while (respuesta == null) {
            try {
                System.out.print("Ingrese valor de efectivo: ");
                respuesta = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("valor inválido, intente de nuevo");
            } finally {
                sc.nextLine();
            }
        }

        return respuesta;
    }

    public void mostrarMensaje(String message) {
        System.err.println(message);
    }

}

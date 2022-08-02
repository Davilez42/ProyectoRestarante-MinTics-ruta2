package com.edu.utp.corrientazo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.edu.utp.corrientazo.exception.PagoExcepcion;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.OpcionCarne;
import com.edu.utp.corrientazo.modelo.OpcionEnsalada;
import com.edu.utp.corrientazo.modelo.OpcionJugo;
import com.edu.utp.corrientazo.modelo.OpcionPrincipio;
import com.edu.utp.corrientazo.modelo.OpcionSopa;
import com.edu.utp.corrientazo.modelo.Pedido;
import com.edu.utp.corrientazo.modelo.PedidoAdicional;
import com.edu.utp.corrientazo.vista.MenuPrincipal;
import com.edu.utp.corrientazo.vista.MesaVista;
import com.edu.utp.corrientazo.vista.PedidoAdicionalVista;
import com.edu.utp.corrientazo.vista.PedidoVista;

public class Controlador {
    private MesaVista mesavista;
    private PedidoVista pedidovista;
    private MenuPrincipal menuPrincipal;
    private PedidoAdicionalVista pedidoAdicionalVista;
    private List<Mesa> listamesas;

    /// comidas

    private List<OpcionCarne> carnes;
    private List<OpcionSopa> sopas;
    private List<OpcionJugo> jugos;
    private List<OpcionPrincipio> principios;
    private List<OpcionEnsalada> ensaladas;

    public Controlador(Scanner sc) {
        this.mesavista = new MesaVista(sc, this);
        this.pedidovista = new PedidoVista(sc, this);
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.pedidoAdicionalVista = new PedidoAdicionalVista(sc, this);

        this.listamesas = new ArrayList<>();
        this.carnes = new ArrayList<>();
        this.sopas = new ArrayList<>();
        this.jugos = new ArrayList<>();
        this.principios = new ArrayList<>();
        this.ensaladas = new ArrayList<>();

    }

    // TODO:SOLO PARA PRUEBAS
    public void cargarBaseDeDatos() {
        listamesas.add(new Mesa("01"));
        listamesas.add(new Mesa("02"));
        listamesas.add(new Mesa("03"));
        listamesas.add(new Mesa("04"));
        listamesas.add(new Mesa("05"));

        sopas.add(new OpcionSopa("Cordero"));
        sopas.add(new OpcionSopa("Pollo"));
        sopas.add(new OpcionSopa("Patacon"));
        sopas.add(new OpcionSopa("Pescado"));
        sopas.add(new OpcionSopa("Pajarilla"));

        carnes.add(new OpcionCarne("Cordero aumado"));
        carnes.add(new OpcionCarne("Lomo"));
        carnes.add(new OpcionCarne("Cerdo"));

        principios.add(new OpcionPrincipio("Lentejas"));
        principios.add(new OpcionPrincipio("Frijoles"));
        principios.add(new OpcionPrincipio("Espaguetis"));

        ensaladas.add(new OpcionEnsalada("agridulce"));
        ensaladas.add(new OpcionEnsalada("roja"));
        ensaladas.add(new OpcionEnsalada("dulce"));

        jugos.add(new OpcionJugo("lulo"));
        jugos.add(new OpcionJugo("Guayaba"));
        jugos.add(new OpcionJugo("limonada"));
        jugos.add(new OpcionJugo("Aguapanela"));

    }

    public List<OpcionCarne> getCarnes() {
        return carnes;
    }

    public List<OpcionJugo> getJugos() {
        return jugos;
    }

    public List<OpcionSopa> getSopas() {
        return sopas;
    }

    public List<OpcionEnsalada> getEnsaladas() {
        return ensaladas;
    }

    public List<OpcionPrincipio> getPrincipios() {
        return principios;
    }

    public List<Mesa> getListamesas() {
        return listamesas;
    }

    public void crearMesa() {
        // pedir informacion para crear la mesa
        Mesa mesa = mesavista.pedirInformacionMesa();
        // almacenar la mesa
        this.listamesas.add(mesa);
        // lsitar las mesas en el sistema
        mesavista.mostrarMesas(listamesas);
    }

    public void agregarPedido(Mesa mesa) {

        // pedir infomracion del pedido
        Pedido pedido = pedidovista.pedirInformacionPedido();
        // agregar pedido a la mesa
        mesa.agregarPedido(pedido);
        // mostrar confirmacion
        pedidovista.mostrarMensaje("El pedido ha sido agregado");

    }

    public Mesa consultarMesa() {
        return mesavista.consultarMesa();
    }

    public void entregarPedido(Mesa mesa) {
        var pedido = mesavista.consultarPedidos(mesa);
        pedido.entregarPedido();

    }

    public void mostrarPedidos(Mesa mesa) {
        mesavista.mostrarPedidos(mesa);
    }

    public void pagoDeMesa(Mesa mesa) {
        var efectivo = mesavista.leerEfectivo();
        try {
            var total = mesa.calcularValorMesa();
            System.out.println(total);
            if (efectivo < total) {
                throw new PagoExcepcion();
            }
            mesavista.mostrarMensaje(String.format("La devuelta son: $ %,d", (efectivo - total)));
            mesa.limpiarPedidos();
        } catch (PagoExcepcion e) {
            mesavista.mostrarMensaje(e.getMessage());
        }

    }

    public void iniciarAplicacion() {
        menuPrincipal.iniciarAplicacion();
    }

    public void agregarAdicional(Mesa mesa) {
        var pedido = mesavista.consultarPedidos(mesa);
        var adicional = pedidoAdicionalVista.pedirInformacionPedidoAdicional();
        pedido.agregaradicionales(adicional);
    }

}

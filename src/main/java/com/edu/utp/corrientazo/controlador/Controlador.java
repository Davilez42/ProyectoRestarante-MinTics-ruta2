package com.edu.utp.corrientazo.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.edu.utp.corrientazo.exception.PagoExcepcion;
import com.edu.utp.corrientazo.modelo.EstadoPedido;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.OpcionCarne;
import com.edu.utp.corrientazo.modelo.OpcionEnsalada;
import com.edu.utp.corrientazo.modelo.OpcionJugo;
import com.edu.utp.corrientazo.modelo.OpcionPrincipio;
import com.edu.utp.corrientazo.modelo.OpcionSopa;
import com.edu.utp.corrientazo.modelo.Pedido;

import com.edu.utp.corrientazo.modelo.dao.MesaDao;
import com.edu.utp.corrientazo.modelo.dao.OpcionAlimentoDao;
import com.edu.utp.corrientazo.modelo.dao.PedidoDao;
import com.edu.utp.corrientazo.vista.MenuPrincipal;
import com.edu.utp.corrientazo.vista.MesaVista;
import com.edu.utp.corrientazo.vista.PedidoAdicionalVista;
import com.edu.utp.corrientazo.vista.PedidoVista;

public class Controlador {
    private MesaVista mesavista;
    private PedidoVista pedidovista;
    private MenuPrincipal menuPrincipal;
    private PedidoAdicionalVista pedidoAdicionalVista;
    // comunicacion con base de datos
    private MesaDao mesadao;
    private OpcionAlimentoDao<OpcionSopa> sopadao;
    private OpcionAlimentoDao<OpcionCarne> carnedao;
    private OpcionAlimentoDao<OpcionJugo> jugodao;
    private OpcionAlimentoDao<OpcionPrincipio> principiodao;
    private OpcionAlimentoDao<OpcionEnsalada> ensaladadao;

    private PedidoDao pedidoDao;

    public Controlador(Scanner sc) {
        this.mesavista = new MesaVista(sc, this);
        this.pedidovista = new PedidoVista(sc, this);
        this.menuPrincipal = new MenuPrincipal(sc, this);
        this.pedidoAdicionalVista = new PedidoAdicionalVista(sc, this);

        this.mesadao = new MesaDao();
        this.sopadao = new OpcionAlimentoDao<>("opcionesSopa");
        this.carnedao = new OpcionAlimentoDao<>("opcionesCarne");
        this.jugodao = new OpcionAlimentoDao<>("opcionesJugo");
        this.principiodao = new OpcionAlimentoDao<>("opcionesPrincipio");
        this.ensaladadao = new OpcionAlimentoDao<>("opcionesEnsalada");

        this.pedidoDao = new PedidoDao();

    }

    public List<OpcionCarne> getCarnes() throws SQLException {

        return carnedao.listar(rst -> {

            try {
                var carne = new OpcionCarne(rst.getString("nombre"));
                carne.setId(rst.getInt("Id"));
                return carne;
            } catch (SQLException e) {
                return null;
            }

        });
    }

    public List<OpcionJugo> getJugos() throws SQLException {
        return jugodao.listar(rst -> {
            try {
                var jugo = new OpcionJugo(rst.getString("nombre"));
                jugo.setId(rst.getInt("id"));
                return jugo;
            } catch (SQLException e) {
                return null;
            }

        });
    }

    public List<OpcionSopa> getSopas() throws SQLException {
        return sopadao.listar(rst -> {
            try {
                var sopa = new OpcionSopa(rst.getString("nombre"));
                sopa.setId(rst.getInt("id"));
                return sopa;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public List<OpcionEnsalada> getEnsaladas() throws SQLException {
        return ensaladadao.listar(rst -> {
            try {
                var ensalada = new OpcionEnsalada(rst.getString("nombre"));
                ensalada.setId(rst.getInt("id"));
                return ensalada;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public List<OpcionPrincipio> getPrincipios() throws SQLException {
        return principiodao.listar(rst -> {
            try {
                var principio = new OpcionPrincipio(rst.getString("nombre"));
                principio.setId(rst.getInt("id"));
                return principio;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    public List<Mesa> getListamesas() throws SQLException {
        return mesadao.listar();
    }

    public void crearMesa() throws SQLException {
        // pedir informacion para crear la mesa
        Mesa mesa = mesavista.pedirInformacionMesa();
        // almacenar la mesa
        this.mesadao.guardar(mesa);
        // lsitar las mesas en el sistema
        mesavista.mostrarMesas(getListamesas());
    }

    public void agregarPedido(Mesa mesa) {

        try {
            // pedir infomracion del pedido
            Pedido pedido = pedidovista.pedirInformacionPedido();
            // agregar pedido a la mesa
            pedidoDao.guardar(mesa, pedido);
            // mostrar confirmacion
            pedidovista.mostrarMensaje("El pedido ha sido agregado");
        } catch (SQLException ex) {

        }
    }

    public Mesa consultarMesa() {
        try {
            return mesavista.consultarMesa();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void entregarPedido(Mesa mesa) {
        try {
            var pedidos = pedidoDao.listar_pedidos(mesa).stream()
                    .filter(P -> P.getEstado() == EstadoPedido.SIN_ENTREGAR).collect(Collectors.toList());
            var pedido = mesavista.consultarPedidos(pedidos);
            pedido.entregarPedido();
            pedidoDao.entregarPedido(pedido);

            pedidovista.mostrarMensaje("El pedido ha sido entregado!!");
        } catch (SQLException e) {

        }
    }

    public void mostrarPedidos(Mesa mesa) {

        try {
            var pedidos = pedidoDao.listar_pedidos(mesa);
            mesavista.mostrarPedidos(pedidos);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void pagoDeMesa(Mesa mesa) {

        try {

            var pedidos = pedidoDao.listar_pedidos(mesa);

            var total = pedidos.stream()
                    .filter(Pedido -> Pedido.getEstado() == EstadoPedido.PENDIENTE_COBRAR)
                    .map(Pedido -> Pedido.calcularValorPedido())
                    .reduce((a, b) -> a + b)
                    .orElse(0);
            mesavista.mostrarMensaje(String.format("El total de la mesa es: %d", total));

            var efectivo = mesavista.leerEfectivo();

            

            if (efectivo < total) {
                throw new PagoExcepcion();
            }
            pedidoDao.eliminarPedidos(mesa);
            mesavista.mostrarMensaje(String.format("La devuelta son: $ %,d", (efectivo - total)));
            mesa.limpiarPedidos();
        } catch (PagoExcepcion e) {
            mesavista.mostrarMensaje(e.getMessage());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void iniciarAplicacion() throws SQLException {
        menuPrincipal.iniciarAplicacion();
    }

    public void agregarAdicional(Mesa mesa) {
        // var pedido = mesavista.consultarPedidos(mesa);
        // var adicional = pedidoAdicionalVista.pedirInformacionPedidoAdicional();
        // pedido.agregaradicionales(adicional);
    }

}

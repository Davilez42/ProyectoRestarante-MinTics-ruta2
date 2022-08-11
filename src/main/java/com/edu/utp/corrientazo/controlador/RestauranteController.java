/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.corrientazo.controlador;

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
import java.sql.SQLException;
import java.util.List;

public class RestauranteController {

    //Daos
    private MesaDao mesadao;
    private PedidoDao pedidoDao;
    private OpcionAlimentoDao<OpcionSopa> sopadao;
    private OpcionAlimentoDao<OpcionCarne> carnedao;
    private OpcionAlimentoDao<OpcionJugo> jugodao;
    private OpcionAlimentoDao<OpcionPrincipio> principiodao;
    private OpcionAlimentoDao<OpcionEnsalada> ensaladadao;

    public RestauranteController() {
        this.mesadao = new MesaDao();
        this.pedidoDao = new PedidoDao();
        this.sopadao = new OpcionAlimentoDao<>("opcionesSopa");
        this.carnedao = new OpcionAlimentoDao<>("opcionesCarne");
        this.jugodao = new OpcionAlimentoDao<>("opcionesJugo");
        this.principiodao = new OpcionAlimentoDao<>("opcionesPrincipio");
        this.ensaladadao = new OpcionAlimentoDao<>("opcionesEnsalada");
    }

    public List<Mesa> listarMesas() throws SQLException {
        return mesadao.listar();
    }

    public Integer calcularValormesa(Mesa mesa) throws SQLException {
        var pedidos = pedidoDao.listar_pedidos(mesa);

        return pedidos.stream()
                .filter(Pedido -> Pedido.getEstado() == EstadoPedido.PENDIENTE_COBRAR)
                .map(Pedido -> Pedido.calcularValorPedido())
                .reduce((a, b) -> a + b)
                .orElse(0);
    }

    public List<Pedido> listarPedidos(Mesa mesa) throws SQLException {
        return pedidoDao.listar_pedidos(mesa);
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
    
    public void entregarPedido(Pedido pedido) throws SQLException{
        pedido.entregarPedido();
        pedidoDao.entregarPedido(pedido);
    }
    
    public void agregarPedido(Mesa mesa,Pedido pedido) throws SQLException{
        pedidoDao.guardar(mesa, pedido);
    }
    
    public  void pagarCuenta(Mesa mesa) throws SQLException{
        pedidoDao.eliminarPedidos(mesa);
    }

}

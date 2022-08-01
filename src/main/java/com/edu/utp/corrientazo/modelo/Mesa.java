package com.edu.utp.corrientazo.modelo;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

/**
 * Mesa
 */
public class Mesa {

    private String numero;
    private List<Pedido> pedidos;

    public Mesa(String numero, List<Pedido> pedidos) {
        this.numero = numero;
        this.pedidos = pedidos;
    }

    
    public Mesa(String numero) {
        this(numero,new ArrayList<>());
    }



    public Integer calcularValorMesa() {
        var total = 0;
        if (!pedidos.isEmpty()) {
            for (Pedido pedido : pedidos) {
                total += pedido.calcularValorPedido();
            }
            
        }
        return total;
    }

    public Integer pagar(Integer efectivo) throws PagoExcepcion {

        if (efectivo >= calcularValorMesa()) {
            var devuelta = efectivo - calcularValorMesa();
            pedidos.clear();
            return devuelta;
        }
        else{
            throw new PagoExcepcion();
        }
    }

    public void agregarPedido(Pedido p){
        pedidos.add(p);
    }

    public String getNumero() {
        return numero;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
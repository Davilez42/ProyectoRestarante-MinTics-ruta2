package com.edu.utp.corrientazo.modelo;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.edu.utp.corrientazo.exception.PagoExcepcion;

/**
 * Mesa
 */
public class Mesa {
    private Integer id;
    private String numero;
    private List<Pedido> pedidos;

    public Mesa(String numero, List<Pedido> pedidos) {
        this.numero = numero;
        this.pedidos = pedidos;
    }

    
    public Mesa(String numero) {
        this.numero = numero;
        pedidos = new ArrayList<>();
    }



    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Mesa # " + numero ;
    }


    public void limpiarPedidos() {
        pedidos.clear();
    }

   

}
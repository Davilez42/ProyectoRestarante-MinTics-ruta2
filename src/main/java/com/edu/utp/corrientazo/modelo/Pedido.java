package com.edu.utp.corrientazo.modelo;

import java.util.ArrayList;
import java.util.List;
import static com.edu.utp.corrientazo.modelo.EstadoPedido.*;


public class Pedido {
    private String Cliente;
    private Corrientazo almuerzo;
    private List<PedidoAdicional> adicionales;
    private EstadoPedido estado;


    //constructir

    public Pedido(String cliente, Corrientazo almuerzo) {
        Cliente = cliente;
        this.almuerzo = almuerzo;
        this.estado = SIN_ENTREGAR;
        this.adicionales = new ArrayList<>();
    }

    public void agregaradicionales(PedidoAdicional adicionales){
        this.adicionales.add(adicionales);
    }

    public void entregarPedido(){
        this.estado = PENDIENTE_COBRAR;
    }


    public int calcularValorPedido() {
        //stream:recorrer cada elemento de la lista
       return almuerzo.getPrecio()+ 
       adicionales.stream().map(PedidoAdicional->PedidoAdicional.getPrecio()).reduce((a,b)-> a+b).orElse(0);
    }


    public String getCliente() {
        return Cliente;
    }

   

    public Corrientazo getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(Corrientazo almuerzo) {
        this.almuerzo = almuerzo;
    }


    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pedido [Cliente=" + Cliente + ", adicionales=" + adicionales + ", almuerzo=" + almuerzo + ", estado="
                + estado + "]";
    }

    
    
}

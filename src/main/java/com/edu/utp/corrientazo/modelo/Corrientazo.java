package com.edu.utp.corrientazo.modelo;

public class Corrientazo {
    private int precio;
    OpcionSopa sopa;
    OpcionCarne carne;
    OpcionPrincipio principio;
    OpcionJugo jugo;
    OpcionEnsalada ensalada;

    public Corrientazo(int precio, OpcionSopa sopa, OpcionCarne carne, OpcionPrincipio principio, OpcionJugo jugo,
            OpcionEnsalada ensalada) {
        this.precio = precio;
        this.sopa = sopa;
        this.carne = carne;
        this.principio = principio;
        this.jugo = jugo;
        this.ensalada = ensalada;
    }

    public Corrientazo(int precio, OpcionSopa sopa, OpcionCarne carne, OpcionPrincipio principio, OpcionJugo jugo) {
        this(precio, sopa, carne, principio, jugo, null);
    }

    public int getPrecio() {
        return precio;
    }

    public OpcionSopa getSopa() {
        return sopa;
    }

    public OpcionCarne getCarne() {
        return carne;
    }

    public OpcionPrincipio getPrincipio() {
        return principio;
    }

    public OpcionJugo getJugo() {
        return jugo;
    }

    public OpcionEnsalada getEnsalada() {
        return ensalada;
    }

    public void setSopa(OpcionSopa sopa) {
        this.sopa = sopa;
    }

    public void setCarne(OpcionCarne carne) {
        this.carne = carne;
    }

    public void setPrincipio(OpcionPrincipio principio) {
        this.principio = principio;
    }

    public void setJugo(OpcionJugo jugo) {
        this.jugo = jugo;
    }

    public void setEnsalada(OpcionEnsalada ensalada) {
        this.ensalada = ensalada;
    }

}

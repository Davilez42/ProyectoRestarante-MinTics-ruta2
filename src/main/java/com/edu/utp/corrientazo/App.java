package com.edu.utp.corrientazo;

import java.util.Scanner;

import org.xml.sax.SAXException;

import com.edu.utp.corrientazo.controlador.Controlador;
import com.edu.utp.corrientazo.exception.PagoExcepcion;
import com.edu.utp.corrientazo.modelo.Corrientazo;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.OpcionCarne;
import com.edu.utp.corrientazo.modelo.OpcionEnsalada;
import com.edu.utp.corrientazo.modelo.OpcionJugo;
import com.edu.utp.corrientazo.modelo.OpcionPrincipio;
import com.edu.utp.corrientazo.modelo.OpcionSopa;
import com.edu.utp.corrientazo.modelo.Pedido;
import com.edu.utp.corrientazo.modelo.PedidoAdicional;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
    
        try (var sc = new Scanner(System.in)) {
            var contro = new Controlador(sc);
            contro.cargarBaseDeDatos();

          contro.iniciarAplicacion();

        }catch(Exception e){
            System.err.println("Ha ocurrido un error!!");
            System.err.println("\t" +e.getClass());
            }        


    }

  
}

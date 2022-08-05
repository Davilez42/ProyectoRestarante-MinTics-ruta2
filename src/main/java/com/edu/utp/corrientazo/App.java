package com.edu.utp.corrientazo;

import java.util.Scanner;


import com.edu.utp.corrientazo.controlador.Controlador;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
    
        try (var sc = new Scanner(System.in)) {
            var contro = new Controlador(sc);
          

          contro.iniciarAplicacion();

        }catch(Exception e){
            System.err.println("Ha ocurrido un error!!");
            System.err.println("\t" +e.getClass());
            }        


    }

  
}

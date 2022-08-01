package com.edu.utp.corrientazo;

import org.xml.sax.SAXException;

import com.edu.utp.corrientazo.modelo.Corrientazo;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.OpcionCarne;
import com.edu.utp.corrientazo.modelo.OpcionEnsalada;
import com.edu.utp.corrientazo.modelo.OpcionJugo;
import com.edu.utp.corrientazo.modelo.OpcionPrincipio;
import com.edu.utp.corrientazo.modelo.OpcionSopa;
import com.edu.utp.corrientazo.modelo.PagoExcepcion;
import com.edu.utp.corrientazo.modelo.Pedido;
import com.edu.utp.corrientazo.modelo.PedidoAdicional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var mesa_1 = new Mesa("01");

        var almuerzo1 = new Corrientazo(12000,new OpcionSopa("Sopa de pollo"), new OpcionCarne("Bistec"), new OpcionPrincipio("Arroz"), new OpcionJugo("mandarina"));
        var almuerzo2 = new Corrientazo(24000, new OpcionSopa("Sopa de pescado"),new OpcionCarne("Lomo de carachja"), new OpcionPrincipio("Frijoles"), new OpcionJugo("Lulo"), new OpcionEnsalada("Ensalada valluna"));
        
        var anderson = new Pedido("Jose",almuerzo1);
        var cristian = new Pedido("Cristian", almuerzo2);
        
        anderson.agregaradicionales(new PedidoAdicional("chicharron", 1000));
        cristian.agregaradicionales(new PedidoAdicional("Huevo", 500));

        mesa_1.agregarPedido(anderson);
        mesa_1.agregarPedido(cristian);

        System.out.printf("El total de la mesa es: $ %,d %n",mesa_1.calcularValorMesa());
        var efectivo = 37500;
        try {
            System.out.printf("Se paga con: $ %,d , devuelta: %d %n",efectivo,mesa_1.pagar(efectivo));
        } catch (PagoExcepcion e) {
         System.err.println( e.getMessage());
        }
       

    
    }
}

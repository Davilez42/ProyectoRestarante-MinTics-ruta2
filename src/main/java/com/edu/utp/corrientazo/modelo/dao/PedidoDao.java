package com.edu.utp.corrientazo.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.jdbc3.JDBC3Connection;

import com.edu.utp.corrientazo.modelo.Corrientazo;
import com.edu.utp.corrientazo.modelo.EstadoPedido;
import com.edu.utp.corrientazo.modelo.Mesa;
import com.edu.utp.corrientazo.modelo.OpcionCarne;
import com.edu.utp.corrientazo.modelo.OpcionEnsalada;
import com.edu.utp.corrientazo.modelo.OpcionJugo;
import com.edu.utp.corrientazo.modelo.OpcionPrincipio;
import com.edu.utp.corrientazo.modelo.OpcionSopa;
import com.edu.utp.corrientazo.modelo.Pedido;
import com.edu.utp.corrientazo.modelo.PedidoAdicional;
import com.edu.utp.corrientazo.util.JDBCutilites;

public class PedidoDao {

    public List<Pedido> listar_pedidos(Mesa mesa) throws SQLException {
        List<Pedido> respuesta = null;
        Connection connection = null;
        PreparedStatement pstament = null;//
        PreparedStatement pstament2 = null;//
        ResultSet rst = null;
        ResultSet rst2 = null;
        try {
            respuesta = new ArrayList<>();
            connection = JDBCutilites.getConnection();
            var sql = "SELECT p.id as id_pedido,p.cliente ,c.precio ,p.estado,c.id_sopa,c.id_carne,c.id_jugo,c.id_principio,c.id_ensalada,"
                    + "os.nombre as sopa ,oc.nombre as carne"
                    + ",oj.nombre as jugo ,op.nombre as principio,oe.nombre as ensalada"
                    + " FROM Pedidos p"
                    + " join Corrientazos c on(p.id=c.id_pedido)"
                    + " join opcionesSopa os on(c.id_sopa =os.id )"
                    + " join opcionesCarne oc on(c.id_carne=oc.id)"
                    + " JOIN opcionesJugo oj on(c.id_jugo=oj.id)"
                    + " JOIN opcionesPrincipio op on(c.id_principio=op.id  )"
                    + " left JOIN opcionesEnsalada oe on(c.id_ensalada=oe.id)"
                    + " where p.id_mesa = ? ;";
            pstament = connection.prepareStatement(sql);
            pstament.setInt(1, mesa.getId());

            rst = pstament.executeQuery();

            while (rst.next()) {

                var sopa = new OpcionSopa(rst.getString("sopa"));
                sopa.setId(rst.getInt("id_sopa"));
                var carne = new OpcionCarne(rst.getString("carne"));
                carne.setId(rst.getInt("id_carne"));
                var jugo = new OpcionJugo(rst.getString("jugo"));
                jugo.setId(rst.getInt("id_jugo"));
                var principio = new OpcionPrincipio(rst.getString("principio"));
                principio.setId(rst.getInt("id_principio"));

                OpcionEnsalada ensalada = null;
                if (rst.getString("ensalada") != null) {
                    ensalada = new OpcionEnsalada(rst.getString("ensalada"));
                    ensalada.setId(rst.getInt("id_ensalada"));
                }

                var almuerzo = new Corrientazo(rst.getInt("precio"), sopa, carne, principio, jugo, ensalada);

                var pedido = new Pedido(rst.getString("cliente"), almuerzo);
                pedido.setId(rst.getInt("id_pedido"));
                pedido.setEstado(EstadoPedido.valueOf(rst.getString("estado")));

                pstament2 = JDBCutilites.getConnection().prepareStatement("SELECT id_adicional , a.nombre ,a.precio"
                        + " from PedidoAdicional pa"
                        + " join Adicional a on(pa.id_adicional = a.id)"
                        + " where pa.id_pedido = ?;");
                pstament2.setInt(1, pedido.getId());
                rst2 = pstament2.executeQuery();

                while (rst2.next()) {
                    var adicional = new PedidoAdicional(rst2.getString("nombre"), rst2.getInt("precio"));
                    adicional.setId(rst2.getInt("id_adicional"));
                    pedido.agregaradicionales(adicional);
                }

                respuesta.add(pedido);
            }

        } finally {
            if (rst != null) {
                rst.close();
            }
            if (pstament != null) {
                pstament.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
        return respuesta;
    }

    public void guardar(Mesa mesa, Pedido pedido) throws SQLException {
        PreparedStatement pstatement1 = null;
        PreparedStatement pstatement2 = null;
        Connection connection = null;
        try {
            pedido.setId(generarConsecutivo("Pedidos"));// genrara id del pedido
            pstatement1 = JDBCutilites.getConnection()
                    .prepareStatement("INSERT INTO Pedidos (id,cliente,estado,id_mesa) VALUES(?,?,?,?)");
            pstatement1.setInt(1, pedido.getId());
            pstatement1.setString(2, pedido.getCliente());
            pstatement1.setString(3, pedido.getEstado().toString());
            pstatement1.setInt(4, mesa.getId());
            pstatement1.executeUpdate();

            pstatement2 = JDBCutilites.getConnection().prepareStatement(
                    "INSERT INTO Corrientazos (id_pedido,precio,id_sopa,id_carne,id_jugo,id_principio,id_ensalada) VALUES(?,?,?,?,?,?,?) ");
            pstatement2.setInt(1, pedido.getId());
            pstatement2.setInt(2, pedido.getAlmuerzo().getPrecio());
            pstatement2.setInt(3, pedido.getAlmuerzo().getSopa().getId());
            pstatement2.setInt(4, pedido.getAlmuerzo().getCarne().getId());
            pstatement2.setInt(5, pedido.getAlmuerzo().getJugo().getId());
            pstatement2.setInt(6, pedido.getAlmuerzo().getPrincipio().getId());
            if (pedido.getAlmuerzo().getEnsalada() != null) {
                pstatement2.setInt(7, pedido.getAlmuerzo().getEnsalada().getId());
            } else {
                pstatement2.setNull(7, Types.INTEGER);
            }

            pstatement2.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

        }
    }

    public Integer generarConsecutivo(String tabla) throws SQLException {
        var resultado = 0;
        Connection connection = null;
        PreparedStatement pstament = null;//
        ResultSet rst = null;
        try {

            connection = JDBCutilites.getConnection();
            pstament = connection.prepareStatement("SELECT MAX(id) as ID from " + tabla + ";");
            rst = pstament.executeQuery();

            if (rst.next()) {
                resultado = rst.getInt("ID");
            }
            return resultado + 1;
        } finally {

            if (pstament != null) {
                pstament.close();
            }

            if (connection != null) {
                connection.close();
            }

        }

    }

    public void entregarPedido(Pedido pedido) throws SQLException {
        Connection connection = null;
        PreparedStatement pstament = null;//
        try {

            connection = JDBCutilites.getConnection();
            pstament = connection.prepareStatement("UPDATE Pedidos SET estado = ? WHERE id = ?");
            pstament.setString(1, pedido.getEstado().toString());
            pstament.setInt(2, pedido.getId());
            pstament.executeUpdate();

        } finally {

            if (pstament != null) {
                pstament.close();
            }

            if (connection != null) {
                connection.close();
            }

        }

    }

    public void eliminarPedidos(Mesa mesa) throws SQLException {
        Connection connection = null;
        PreparedStatement pstament1 = null;//
        PreparedStatement pstament2 = null;//
        try {

            connection = JDBCutilites.getConnection();

            pstament1 = connection.prepareStatement("DELETE "
                    + " from Corrientazos"
                    + " where id_pedido in("
                    + " SELECT p.id"
                    + " from Pedidos p"
                    + " where p.id_mesa  = ?"
                    + ");");
            pstament1.setInt(1, mesa.getId());
            pstament1.executeUpdate();

            pstament2 = connection.prepareStatement("DELETE from Pedidos WHERE id_mesa = ?");
            pstament2.setInt(1, mesa.getId());

            pstament2.executeUpdate();

        } finally {

            if (pstament1 != null) {
                pstament1.close();
            }
            if (pstament2 != null) {
                pstament2.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    }

    public void guardarAdicionales(Mesa mesa, Pedido pedido) throws SQLException {
        PreparedStatement pstatement4 = null;
        PreparedStatement pstatement3 = null;
        try {
            var indice_ultimo = pedido.getAdicionales().size()-1;
            pstatement3 = JDBCutilites.getConnection()
                    .prepareStatement("INSERT into Adicional(id,precio,nombre) VALUES(?,?,?)");
            pedido.getAdicionales().get(indice_ultimo).setId(generarConsecutivo("Adicional"));
            
            pstatement3.setInt(1, pedido.getAdicionales().get(indice_ultimo).getId());
            pstatement3.setInt(2, pedido.getAdicionales().get(indice_ultimo).getPrecio());
            pstatement3.setString(3, pedido.getAdicionales().get(indice_ultimo).getNombre());
            pstatement3.executeUpdate();

            pstatement4 = JDBCutilites.getConnection()
                    .prepareStatement("INSERT into PedidoAdicional(id_pedido,id_adicional) VALUES(?,?)");
            pstatement4.setInt(1, pedido.getId());
            pstatement4.setInt(2, pedido.getAdicionales().get(indice_ultimo).getId());

            pstatement4.executeUpdate();

        } finally {
            if (pstatement3 != null) {
                pstatement3.close();
            }
            if (pstatement4 != null) {
                pstatement4.close();
            }
        }
    }
}

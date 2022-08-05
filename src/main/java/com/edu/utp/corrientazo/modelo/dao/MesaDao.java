package com.edu.utp.corrientazo.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.utp.corrientazo.modelo.Mesa;
import static com.edu.utp.corrientazo.util.JDBCutilites.*;

//esta clase se encargar de gestionar los datos con la base de datos 
public class MesaDao {

    public List<Mesa> listar() throws SQLException{
        List<Mesa> respuesta = null;
       Connection connection=null;
       PreparedStatement pstament=null;//
       ResultSet rst = null;
       try{
            respuesta = new ArrayList<>();
            connection = getConnection();
            pstament = connection.prepareStatement("SELECT * from Mesas");
            rst = pstament.executeQuery();
           while(rst.next()){
                var mesa = new Mesa(rst.getString("numero"));
                mesa.setId(rst.getInt("id"));
                respuesta.add(mesa);
           }
            
       }
       finally{
        if(rst!=null){
            rst.close();
        }
        if (pstament!=null) {
            pstament.close();
        }

        if(connection!=null){
            connection.close();
        }
        
       }
       return respuesta;
    }

    public void guardar(Mesa mesa) throws SQLException{
       Connection connection=null;
       PreparedStatement pstament=null;//
       try{
            connection = getConnection();
            pstament = connection.prepareStatement("INSERT INTO Mesas(id,numero) VALUES(?,?);");
            pstament.setInt(1, generarConsecutivo());
            pstament.setString(2, mesa.getNumero());
           pstament.executeUpdate();      
       }
       finally{
        
        if (pstament!=null) {
            pstament.close();
        }

        if(connection!=null){
            connection.close();
        }
        
       }
      
    }

    public Integer generarConsecutivo() throws SQLException{
        var resultado = 0;
        Connection connection=null;
       PreparedStatement pstament=null;//
       ResultSet rst = null;
       try{
        
            connection = getConnection();
            pstament = connection.prepareStatement("SELECT MAX(id) as ID from Mesas;");
            rst= pstament.executeQuery(); 
            
            if(rst.next()){
                resultado =  rst.getInt("ID");
            }
            return resultado+1;
       }
       finally{
        
        if (pstament!=null) {
            pstament.close();
        }

        if(connection!=null){
            connection.close();
        }
        
       }

    }


    
}

package com.edu.utp.corrientazo.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.edu.utp.corrientazo.util.JDBCutilites;

public class OpcionAlimentoDao<T> {
    private String tabla;

    public OpcionAlimentoDao(String tabla) {
        this.tabla = tabla;
    }

    public List<T> listar(Function<ResultSet, T> mapper) throws SQLException {
        List<T> resultado = null;

        Connection connection = null;
        PreparedStatement stament = null;
        ResultSet rst = null;

        try {

            connection = JDBCutilites.getConnection();
            stament = connection.prepareStatement("SELECT * FROM "+tabla+";");
            resultado = new ArrayList<>();
            rst = stament.executeQuery();
            while (rst.next()) {
                var opcion = mapper.apply(rst);
                resultado.add(opcion);
            }

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (stament != null) {
                stament.close();
            }
            if (rst != null) {
                rst.close();
            }
        }

        return resultado;

    }

}

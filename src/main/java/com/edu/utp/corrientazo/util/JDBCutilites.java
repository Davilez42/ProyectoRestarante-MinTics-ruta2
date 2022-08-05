package com.edu.utp.corrientazo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutilites {
    private final static String UBICACION_BD = "C:\\Users\\joses\\OneDrive\\Escritorio\\Min_tics_Ciclo2\\corrientazo\\src\\main\\resources\\corrientazo.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}

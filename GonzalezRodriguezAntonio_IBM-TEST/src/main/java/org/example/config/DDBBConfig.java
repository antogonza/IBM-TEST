package org.example.config;

import java.sql.*;

public class DDBBConfig {

    public static ResultSet executeQuery(String query) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "sa", "1");
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta");
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultSet;
    }
}

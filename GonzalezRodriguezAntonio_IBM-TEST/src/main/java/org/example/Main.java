package org.example;

import org.example.config.DDBBConfig;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        File file = new File("/output.txt");
        FileWriter fw = null;

        try {
            ResultSet resultset = DDBBConfig.executeQuery("SELECT * FROM proveedores WHERE id_cliente = " + args[0]);
            fw = new FileWriter(file);
            if (!resultset.next()) {
                System.out.println("El cliente no tiene proveedores asignados");
            }
            while (resultset.next()) {
                String line = resultset.getInt("id_proveedor") + ": " + resultset.getString("nombre") + ", " + resultset.getDate("fecha_de_alta") + ", "  + resultset.getInt("id_cliente") + "\n";
                fw.write(line);
            }
            fw.close();
        } catch (SQLException | IOException |  ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }
}

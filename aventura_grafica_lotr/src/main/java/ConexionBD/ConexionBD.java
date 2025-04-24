/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * aventura-grafica-senor-anillos
 * MR_Yeste
 */

// Datos de conexión a la base de datos Oracle: dirección, usuario y contraseña
public class ConexionBD {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "MRYS";
    private static final String CONTRASENA = "abc123";
// Este método se encarga de establecer y devolver la conexión con la base de datos
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}

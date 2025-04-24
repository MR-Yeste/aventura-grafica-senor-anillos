/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConexionBD.ConexionBD;
import modelo.Escena;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Escena;

/**
 * aventura-grafica-senor-anillos
 * MR_Yeste
 */

public class EscenaDAO {
    // Método para obtener todas las escenas (no se usa directamente en la interfaz)
    public List<Escena> obtenerTodas() {
        // Conectamos con la base de datos
        List<Escena> escenas = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM escenas");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                escenas.add(new Escena(
                    rs.getInt("id"),
                    rs.getString("texto"),
                    rs.getString("imagen")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escenas;
    }

    // Método para obtener una escena concreta por su id
    public Escena obtenerPorId(int id) {
        Escena escena = null;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM escenas WHERE id = ?")) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                escena = new Escena(
                    rs.getInt("id"),
                    rs.getString("texto"),
                    rs.getString("imagen")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escena;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConexionBD.ConexionBD;
import modelo.Opcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Opcion;

/**
 * Tarea 11 de Programación
 * María Rosario Yeste Sánchez
 */

public class OpcionDAO {
    public List<Opcion> obtenerPorEscenaOrigen(int escenaId) {
        List<Opcion> opciones = new ArrayList<>();

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT * FROM opciones WHERE escena_origen_id = ?")) {

            stmt.setInt(1, escenaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                opciones.add(new Opcion(
                    rs.getInt("id"),
                    rs.getString("texto"),
                    rs.getInt("escena_origen_id"),
                    rs.getInt("escena_destino_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return opciones;
    }
}

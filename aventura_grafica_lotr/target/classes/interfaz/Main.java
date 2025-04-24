/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.SwingUtilities;

import interfaz.VentanaPrincipal;

/**
 * Tarea 11 de Programación
 * María Rosario Yeste Sánchez
 */


public class Main {

    public static void main(String[] args) {
        // Esto hace que la ventana principal se abra de forma segura desde el hilo de interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            // Creamos una ventana de tipo VentanaPrincipal y la mostramos
            VentanaPrincipal ventana = new VentanaPrincipal(); 
            ventana.setVisible(true);
        });
    }
}
        
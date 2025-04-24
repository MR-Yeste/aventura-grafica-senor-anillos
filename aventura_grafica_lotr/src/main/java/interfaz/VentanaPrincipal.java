/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import modelo.Escena;
import modelo.Opcion;
import dao.EscenaDAO;
import dao.OpcionDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.net.URL;


/**
 * aventura-grafica-senor-anillos
 * MR_Yeste
 */

public class VentanaPrincipal extends JFrame {
    // Elementos visuales de la escena
    private JLabel textoEscena;
    private JLabel imagenEscena;
    private JPanel opcionesPanel;
    // Objetos que se encargan de leer datos de la base de datos
    private EscenaDAO escenaDAO = new EscenaDAO();
    private OpcionDAO opcionDAO = new OpcionDAO();

    public VentanaPrincipal() {
        // Configuración básica de la ventana
        setTitle("Una Aventura de Frodo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Establecer el icono de la ventana
        ImageIcon icono = new ImageIcon("src/main/resources/icono.png"); // Ruta de tu imagen
        setIconImage(icono.getImage());

        // Para poner de fondo de la ventana una imagen
        FondoPanel fondoPanel = new FondoPanel("src/main/resources/pergamino.jpg");
        fondoPanel.setLayout(new BorderLayout());
        setContentPane(fondoPanel);

        // Parte central de la ventana con texto y la imagen de la escena
        JPanel panelCentro = new JPanel();
        panelCentro.setOpaque(false);
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

        // Etiqueta para el texto de la escena
        textoEscena = new JLabel();
        textoEscena.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoEscena.setForeground(new Color(60, 30, 10));
        textoEscena.setFont(new Font("Serif", Font.BOLD, 20));
        textoEscena.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        textoEscena.setHorizontalAlignment(SwingConstants.CENTER);

        imagenEscena = new JLabel();
        imagenEscena.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagenEscena.setHorizontalAlignment(SwingConstants.CENTER);

        // Etiqueta para mostrar la imagen de la escena
        panelCentro.add(textoEscena);
        panelCentro.add(imagenEscena);

        // Los botones situados en la parte de abajo
        opcionesPanel = new JPanel();
        opcionesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        opcionesPanel.setOpaque(false);

        fondoPanel.add(panelCentro, BorderLayout.CENTER);
        fondoPanel.add(opcionesPanel, BorderLayout.SOUTH);

        // Empieza mostrando la primera escena
        mostrarEscena(1);
    }

    private void mostrarEscena(int idEscena) {
        //Carga la escena desde la base de datos
        Escena escena = escenaDAO.obtenerPorId(idEscena);
        if (escena != null) {
            // Muestra el texto de la escena en el centro
            textoEscena.setText("<html><div style='text-align: center;'>" + escena.getTexto() + "</div></html>");

            // Si hay imagen, se muestra redimensionada
            if (escena.getImagen() != null && !escena.getImagen().isEmpty()) {
                String ruta = "src/main/resources/" + escena.getImagen();
                ImageIcon icon = new ImageIcon(ruta);
                if (icon.getIconWidth() > 0) {
                    Image imgEscalada = icon.getImage().getScaledInstance(700, 250, Image.SCALE_SMOOTH);
                    imagenEscena.setIcon(new ImageIcon(imgEscalada));
                } else {
                    imagenEscena.setIcon(null);
                    System.err.println("Imagen no encontrada: " + ruta);
                }
            }
            // Borra las opciones anteriores
            opcionesPanel.removeAll();
            
            // Añade las nuevas opciones como botones
            List<Opcion> opciones = opcionDAO.obtenerPorEscenaOrigen(idEscena);
            for (Opcion opcion : opciones) {
                JButton boton = new JButton(opcion.getTexto());
                boton.setFont(new Font("Serif", Font.BOLD, 20));
                boton.setPreferredSize(new Dimension(200, 50));
                boton.setBackground(new Color(255, 215, 0)); // Dorado
                boton.setForeground(new Color(60, 30, 10));
                boton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                boton.setFocusPainted(false);
                boton.setOpaque(true);
                // Cuando el usuario pulsa, se carga la siguiente escena
                boton.addActionListener(e -> mostrarEscena(opcion.getEscenaDestinoId()));
                opcionesPanel.add(boton);
            }
            // Refresca el panel de botones
            opcionesPanel.revalidate();
            opcionesPanel.repaint();
        }
    }

    // Clase interna para poner una imagen de fondo en la ventana
    class FondoPanel extends JPanel {
        private Image fondo;

        public FondoPanel(String rutaImagen) {
            try {
                fondo = new ImageIcon(rutaImagen).getImage();
            } catch (Exception e) {
                System.err.println("❌ No se pudo cargar fondo: " + rutaImagen);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (fondo != null) {
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
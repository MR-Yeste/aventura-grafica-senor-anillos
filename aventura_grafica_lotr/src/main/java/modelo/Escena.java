/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 * aventura-grafica-senor-anillos
 * MR_Yeste
 */

public class Escena {
    private int id;
    private String texto;
    private String imagen;
    private List<Opcion> opciones;
    
    public Escena(int id, String texto, String imagen) {
        this.id = id;
        this.texto = texto;
        this.imagen = imagen;
    }

    // Métodos para acceder y cambiar los datos
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }  
}

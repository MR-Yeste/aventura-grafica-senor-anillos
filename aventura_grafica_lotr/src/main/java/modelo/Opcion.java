/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * aventura-grafica-senor-anillos
 * MR_Yeste
 */

public class Opcion {
    private int id;
    private String texto;
    private int escenaOrigenId;
    private int escenaDestinoId;

    public Opcion(int id, String texto, int escenaOrigenId, int escenaDestinoId) {
        this.id = id;
        this.texto = texto;
        this.escenaOrigenId = escenaOrigenId;
        this.escenaDestinoId = escenaDestinoId;
    }

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

    public int getEscenaOrigenId() {
        return escenaOrigenId;
    }
    public void setEscenaOrigenId(int escenaOrigenId) {
        this.escenaOrigenId = escenaOrigenId;
    }

    public int getEscenaDestinoId() {
        return escenaDestinoId;
    }
    public void setEscenaDestinoId(int escenaDestinoId) {
        this.escenaDestinoId = escenaDestinoId;
    }
    
}

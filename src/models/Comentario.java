/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author Ro
 */
public class Comentario {
     private int idComentario;
    private String comentario;
    private LocalDate fechaAvance;
    private Tarea tarea;

    public Comentario() {
    }

    public Comentario(int idComentario, String comentario, LocalDate fechaAvance, Tarea tarea) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fechaAvance = fechaAvance;
        this.tarea = tarea;
    }

    public Comentario(String comentario, LocalDate fechaAvance, Tarea tarea) {
        this.comentario = comentario;
        this.fechaAvance = fechaAvance;
        this.tarea = tarea;
    }
    

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaAvance() {
        return fechaAvance;
    }

    public void setFechaAvance(LocalDate fechaAvance) {
        this.fechaAvance = fechaAvance;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return "\n-Fecha de avance:"+ fechaAvance+" - Comentario: " + comentario ;
    }
    
}

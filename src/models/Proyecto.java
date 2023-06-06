/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author Ruben
 */
public class Proyecto {

    private int id_proyecto;
    private String nombre;
    private String descripcion;
    private LocalDate fecha_inicio;
    private int estado;

    public Proyecto() {
    }

    public Proyecto(int idproyecto, String nombre, String descripcion, LocalDate fechainicio, int estado) {
        this.id_proyecto = idproyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fechainicio;
        this.estado = estado;
    }

    public Proyecto(String nombre, String descripcion, LocalDate fechainicio, int estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fechainicio;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;

    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    @Override
    public String toString() {
        return id_proyecto + "," + nombre + "," + descripcion + "," + fecha_inicio + "," + estado;
    }

}

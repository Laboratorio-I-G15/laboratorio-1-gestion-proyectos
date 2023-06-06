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
    private  int idproyecto;
    private String nombre; 
    private String descripcion;
    private LocalDate fechainicio;
    private int estado;

    public Proyecto() {
    }

    public Proyecto(int idproyecto, String nombre, String descripcion, LocalDate fechainicio, int estado) {
        this.idproyecto = idproyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.estado=estado;
    }

    public Proyecto(String nombre, String descripcion, LocalDate fechainicio,int estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
         this.estado=estado;
    }
    public int getEstado()
    {return estado;}
    public void setEstado(int estado)
    {  this.estado=estado;
    
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
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

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "idproyecto=" + idproyecto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechainicio=" + fechainicio + ", estado=" + estado + '}';
    }

   

   
    
}

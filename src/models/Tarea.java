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
public class Tarea {
    
    
    private int idTarea;
    private String nombre;
    private LocalDate fechaCreacion;  
    private LocalDate fechaCierre;
    private int estado;
    private EquipoMiembro equipoMiembro;

    public Tarea() {
    }

    public Tarea(int idTarea, String nombre, LocalDate Creacion, LocalDate fechaCierre, int estado, EquipoMiembro equipoMiembro) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.fechaCreacion = Creacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.equipoMiembro = equipoMiembro;
    }

    public Tarea(String nombre, LocalDate Creacion, LocalDate fechaCierre, int estado, EquipoMiembro equipoMiembro) {
        this.nombre = nombre;
        this.fechaCreacion = Creacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.equipoMiembro = equipoMiembro;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate Creacion) {
        this.fechaCreacion = Creacion;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int Estado) {
        this.estado = Estado;
    }

    public EquipoMiembro getEquipoMiembro() {
        return equipoMiembro;
    }

    public void setEquipoMiembro(EquipoMiembro equipoMiembro) {
        this.equipoMiembro = equipoMiembro;
    }

    @Override
    public String toString() {
        return   nombre ;
    }

  
    
    
    
}

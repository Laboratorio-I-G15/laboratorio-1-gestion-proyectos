package models;

import java.time.LocalDate;

public class Equipo {

    private int id_equipo;
    private int id_proyecto;
    private String nombre;
    private LocalDate creacion;
    private int estado;

    public Equipo() {
    }

    public Equipo(int id_proyecto, String nombre, LocalDate creacion, int estado) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.creacion = creacion;
        this.estado = estado;
    }

    public Equipo(int id_equipo, int id_proyecto, String nombre, LocalDate creacion, int estado) {
        this.id_equipo = id_equipo;
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.creacion = creacion;
        this.estado = estado;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
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

    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id_equipo +   " - " + nombre+   " - Estado:"  + estado;
    }

}

package models;

import java.time.LocalDate;

public class Equipo {

    private int id_equipo;
    private Proyecto proyecto;
    private String nombre;
    private LocalDate creacion;
    private int estado;

    public Equipo() {
    }

    public Equipo(Proyecto proyecto, String nombre, LocalDate creacion, int estado) {
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.creacion = creacion;
        this.estado = estado;
    }

    public Equipo(int idEquipo, Proyecto proyecto, String nombre, LocalDate creacion, int estado) {
        this.id_equipo = idEquipo;
        this.proyecto = proyecto;
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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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
        return id_equipo + "," + proyecto + "," + nombre + "," + creacion + "," + estado;
    }

}

package models;

import java.time.LocalDate;

public class Equipo {

    private int idEquipo;
    private Proyecto proyecto;
    private String nombre;
    LocalDate creacion;
    private int estado;

    public Equipo() {
    }

    public Equipo(Proyecto proyecto, String nombre, LocalDate creacion, int estado) {
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.creacion = creacion;
        this.estado = estado;
    }

}

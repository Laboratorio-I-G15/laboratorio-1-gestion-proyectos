/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class EquipoMiembro {

    private int id_equipo_miembro;
    private LocalDate fecha_incorporacion;
    private Equipo equipo;
    private Miembro miembro;

    public EquipoMiembro() {
    }

    public EquipoMiembro(LocalDate fecha_incorporacion, Equipo equipo, Miembro miembro) {
        this.fecha_incorporacion = fecha_incorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
    }

    public EquipoMiembro(int id_equipo_miembro, LocalDate fecha_incorporacion, Equipo equipo, Miembro miembro) {
        this.id_equipo_miembro = id_equipo_miembro;
        this.fecha_incorporacion = fecha_incorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
    }

    public int getId_equipo_miembro() {
        return id_equipo_miembro;
    }

    public void setId_equipo_miembro(int id_equipo_miembro) {
        this.id_equipo_miembro = id_equipo_miembro;
    }

    public LocalDate getFecha_incorporacion() {
        return fecha_incorporacion;
    }

    public void setFecha_incorporacion(LocalDate fecha_incorporacion) {
        this.fecha_incorporacion = fecha_incorporacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    @Override
    public String toString() {
        return id_equipo_miembro + "," + fecha_incorporacion + "," + equipo + "," + miembro;
    }

}

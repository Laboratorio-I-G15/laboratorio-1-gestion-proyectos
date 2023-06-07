/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import models.Equipo;
import models.Proyecto;
import views.proyecto;

/**
 *
 * @author Rafael Lopez
 */
public class EquipoData {

    private String consulta;
    private Equipo equipo;
    private Proyecto proyecto;

    public EquipoData() {
    }

    public EquipoData(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     *
     * @param proyecto
     */
    public EquipoData(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * Recibe un Proyecto y devuelve todos los equipos relacionados con ese proyecto Unicamente equipos
     *
     * @return
     */
    public HashMap<Integer, ArrayList<Equipo>> selectEquipos(Proyecto proyecto) {
        // Map de equipos, uso id_equipo como key para relacionar
        HashMap<Integer, ArrayList<Equipo>> proyecto_equipos = new HashMap<>();
        // consulta
//        String consulta;
        this.consulta = "SELECT * FROM `equipo` WHERE `id_proyecto` LIKE ? ";
        PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);

        return proyecto_equipos;

    }

}

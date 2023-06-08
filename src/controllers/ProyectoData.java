/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import models.Proyecto;

/**
 *
 * @author Ruben
 */
public class ProyectoData {

    public ProyectoData() {
    }

    public void insertProyecto(Proyecto proyecto) {
        int validacion = 0;
        try {
            String sql = "INSERT INTO proyecto (nombre_proyecto, descripcion_proyecto, fecha_inicio_proyecto, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(proyecto.getFecha_inicio());
            ps.setDate(3, fechaInicioSQL);
            ps.setInt(4, proyecto.getEstado());
            System.out.println(ps.toString());
            validacion = ps.executeUpdate();
            if (validacion == 1) {
                System.out.println("Se agregó un nuevo Proyecto");
            } else {
                System.out.println("Se produjo un error al agregar un Proyecto");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al agregar un Proyecto: " + e.getMessage());
        }
    }

    public ArrayList<Proyecto> selectProyecto() {
        ArrayList<Proyecto> proyectos = new ArrayList();
        try {
            String sql = "SELECT * from proyecto WHERE estado = 1";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                System.out.println("No hay Proyecto para Mostrar");
            } else {
                while (rs.next()) {
                    Proyecto proyect = new Proyecto();
                    proyect.setId_proyecto(rs.getInt("id_proyecto"));
                    proyect.setNombre(rs.getString("nombre_proyecto"));
                    proyect.setDescripcion(rs.getString("descripcion_proyecto"));
                    java.sql.Date fechaInicioSQL = rs.getDate("fecha_inicio_proyecto");
                    java.util.Date fechaInicioUtil = new java.util.Date(fechaInicioSQL.getTime());
                    java.time.LocalDate fechaInicioLocalDate = fechaInicioUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    proyect.setFecha_inicio(fechaInicioLocalDate);
                    proyect.setEstado(rs.getInt("estado"));

                    proyectos.add(proyect);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
        return proyectos;
    }

    public void updateProyecto(Proyecto proyecto) {
        int validacion = 0;
        try {
            String sql = "UPDATE `proyecto` SET `nombre_proyecto`= ? , `descripcion_proyecto`= ? , `fecha_inicio_proyecto`= ? ,`estado`= ? WHERE `id_proyecto`=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(proyecto.getFecha_inicio());
            ps.setDate(3, fechaInicioSQL);
            ps.setInt(4, proyecto.getEstado());
            ps.setInt(5, proyecto.getId_proyecto());
            validacion = ps.executeUpdate();
            System.out.println(ps);
            if (validacion == 1) {
                System.out.println("Proyecto Actualizado");
            } else {
                System.out.println("Se produjo un error al actualizar un miembro");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al actualizar el proyecto: " + e.getMessage());
        }

    }

    /**
     * devuelve ultimo proyecto ingresado
     *
     * @return proyecto
     */
    public Proyecto selectUltimoProyecto() {
        Proyecto proyecto = new Proyecto();
        try {
            String consulta = "SELECT * from proyecto ORDER BY `id_proyecto` DESC LIMIT 1 ";
            PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                proyecto.setId_proyecto(result.getInt("id_proyecto"));
                proyecto.setNombre(result.getString("nombre_proyecto"));
                proyecto.setDescripcion(result.getString("descripcion_proyecto"));
                proyecto.setFecha_inicio(result.getDate("fecha_inicio_proyecto").toLocalDate());
                proyecto.setEstado(result.getInt("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
        return proyecto;
    }
}

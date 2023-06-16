/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.EquipoMiembro;
import models.Miembro;
import models.Tarea;

/**
 *
 * @author Ro
 */
public class TareaData {

    public TareaData() {
    }
    //Validar si ya existe una tarea con el mismo nombre, si existe devuelve true
    public boolean TareaExistente(String nombre){
        
        try {
            String sql = "SELECT * FROM `tarea` WHERE nombre_tarea LIKE \"%?\"";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs == null) {
                System.out.println("No se encontraron tareas");
            } else {
                while (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Tarea " + e.getMessage());
        }
        return false;
    }

    //asignar tarea, devuelve true si se asigno la tarea
    public boolean insertTarea(Tarea tarea) {

        int resultado;

        try {

            String sql = "INSERT INTO tarea (nombre_tarea, fecha_inicio_tarea, fecha_fin_tarea, estado_tarea, id_miembro_equipo) VALUES (?,?,?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf(tarea.getFechaCierre()));
            ps.setInt(4, tarea.getEstado());
            ps.setInt(5, tarea.getEquipoMiembro().getId_equipo_miembro());

            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se agregó la tarea");
                return true;
            } else {
                System.out.println("Se produjo un error al agregar la tarea");
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Tarea" + e.getMessage());
        }
        return false;

    }

    //Devuelve true si se actualizó la tarea
    public boolean updateTarea(Tarea tarea) {
        int resultado;

        try {
            String sql = "UPDATE tarea SET nombre_tarea=?,fecha_inicio_tarea=?,fecha_fin_tarea=?,estado_tarea=?,id_miembro_equipo=? WHERE id_tarea=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf(tarea.getFechaCierre()));
            ps.setInt(4, tarea.getEstado());
            ps.setInt(5, tarea.getEquipoMiembro().getId_equipo_miembro());
            ps.setInt(6, tarea.getIdTarea());

            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se actualizó la tarea");
                return true;
            } else {
                System.out.println("Se produjo un error al actualizar la tarea");
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Tarea " + e.getMessage());
        }
        return false;
    }
    //update estado de la tarea
    public boolean updateTareaEstado(int idTarea,int estado) {
        int resultado;

        try {
            String sql = "UPDATE tarea SET estado_tarea=? WHERE id_tarea=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, idTarea);
//
            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se actualizó la tarea");
                return true;
            } else {
                System.out.println("Se produjo un error al actualizar la tarea");
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Tarea " + e.getMessage());
        }
        return false;
    }

    /**
     * filtra las tareas por estado
     *
     * @param tarea
     * @return arrayList de tareas
     */
    public ArrayList<Tarea> selectTareasEstado(Tarea tarea) {

        ArrayList<Tarea> tareas = new ArrayList();
        EquipoMiembro equipoMiembro = new EquipoMiembro();
        try {
            String sql = "SELECT * FROM tarea WHERE estado_tarea=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, tarea.getEstado());
            ResultSet rs = ps.executeQuery();

            if (rs == null) {
                System.out.println("No se encontraron tareas");
            } else {
                while (rs.next()) {
                    Tarea aux = new Tarea();
                    int idMiembroEquipo = rs.getInt("id_miembro_equipo");
                    equipoMiembro.setId_equipo_miembro(idMiembroEquipo);//
                    tarea.setEquipoMiembro(equipoMiembro);//
                    aux.setEstado(rs.getInt("estado_tarea"));
                    aux.setFechaCierre(rs.getDate("fecha_fin_tarea").toLocalDate());
                    aux.setFechaCreacion(rs.getDate("fecha_inicio_tarea").toLocalDate());
                    aux.setNombre(rs.getString("nombre_tarea"));
                    aux.setIdTarea(rs.getInt("id_tarea"));
                    tareas.add(aux);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Tarea " + e.getMessage());
        }
        return tareas;
    }

    //filtrar tareas de un miembro
    public ArrayList<Tarea> selectTareasMiembro(EquipoMiembro equipoMiembro) {

        ArrayList<Tarea> tareas = new ArrayList();
        try {
//            String sql="SELECT * FROM tarea " +
//                        "JOIN equipo_miembro ON  tarea.id_miembro_equipo = equipo_miembro.id_miembro_eq"+
//                        "JOIN miembro ON miembro.id_miembro = equipo_miembro.id_miembro" +
//                        "WHERE miembro.id_miembro = ?";
            String sql = "SELECT * FROM tarea WHERE id_miembro_equipo=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, equipoMiembro.getId_equipo_miembro());
            ResultSet rs = ps.executeQuery();

            if (rs == null) {
                System.out.println("No se encontraron tareas asignadas al miembro");
            } else {
                while (rs.next()) {
                    Tarea aux = new Tarea();
                    aux.setEstado(rs.getInt("estado_tarea"));
                    aux.setFechaCierre(rs.getDate("fecha_fin_tarea").toLocalDate());
                    aux.setFechaCreacion(rs.getDate("fecha_inicio_tarea").toLocalDate());
                    aux.setNombre(rs.getString("nombre_tarea"));
                    aux.setIdTarea(rs.getInt("id_tarea"));
                    aux.setEquipoMiembro(equipoMiembro);
                    tareas.add(aux);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Tarea" + e.getMessage());
        }
        return tareas;
    }

    public ArrayList<Tarea> selectTareasMiembro(int equipoMiembro) {

        ArrayList<Tarea> tareas = new ArrayList();
        try {
//            String sql="SELECT * FROM tarea " +
//                        "JOIN equipo_miembro ON  tarea.id_miembro_equipo = equipo_miembro.id_miembro_eq"+
//                        "JOIN miembro ON miembro.id_miembro = equipo_miembro.id_miembro" +
//                        "WHERE miembro.id_miembro = ?";
            String sql = "SELECT * FROM tarea WHERE id_miembro_equipo = ?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, equipoMiembro);
            ResultSet rs = ps.executeQuery();

            if (rs == null) {
                System.out.println("No se encontraron tareas asignadas al miembro");
            } else {
                while (rs.next()) {
                    Tarea aux = new Tarea();
                    aux.setEstado(rs.getInt("estado_tarea"));
                    aux.setFechaCierre(rs.getDate("fecha_fin_tarea").toLocalDate());
                    aux.setFechaCreacion(rs.getDate("fecha_inicio_tarea").toLocalDate());
                    aux.setNombre(rs.getString("nombre_tarea"));
                    aux.setIdTarea(rs.getInt("id_tarea"));
                    //aux.setEquipoMiembro(equipoMiembro);
                    tareas.add(aux);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Tarea" + e.getMessage());
        }
        return tareas;
    }

}

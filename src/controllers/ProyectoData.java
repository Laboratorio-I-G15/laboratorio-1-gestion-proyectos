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
import javax.swing.JOptionPane;
import models.Equipo;
import models.Proyecto;

/**
 *
 * @author Ruben
 */
public class ProyectoData {

    public ProyectoData() {
        EquipoMiembroData equipo = new EquipoMiembroData();
    }

    public void insertProyecto(Proyecto proyecto) {
        int validacion = 0;
        try {
            // Verificar si el proyecto ya existe
            String selectSql = "SELECT COUNT(*) FROM proyecto WHERE nombre_proyecto = ?";
            PreparedStatement selectStatement = Conexion.getConexion().prepareStatement(selectSql);
            selectStatement.setString(1, proyecto.getNombre());
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Ya a sido agregado este equipo al Proyecto");
                JOptionPane.showMessageDialog(null, "El proyecto ya ha sido ingresado anteriormente.", "Proyecto Duplicado", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método sin realizar la inserción
            }

            // Insertar el nuevo proyecto
            String insertSql = "INSERT INTO proyecto (nombre_proyecto, descripcion_proyecto, fecha_inicio_proyecto, estado) VALUES (?,?,?,?)";
            PreparedStatement insertStatement = Conexion.getConexion().prepareStatement(insertSql);
            insertStatement.setString(1, proyecto.getNombre());
            insertStatement.setString(2, proyecto.getDescripcion());
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(proyecto.getFecha_inicio());
            insertStatement.setDate(3, fechaInicioSQL);
            insertStatement.setBoolean(4, proyecto.getEstado());
            validacion = insertStatement.executeUpdate();

            if (validacion == 1) {
                System.out.println("Se agregó un nuevo Proyecto");
                JOptionPane.showMessageDialog(null, "Se agregó un nuevo Proyecto");
            } else {
                System.out.println("Se produjo un error al agregar un Proyecto");
                JOptionPane.showMessageDialog(null, "No se pudo Cargar Nuevo Proyecto");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar un Proyecto: " + e.getMessage());
        }
    }

    public void insertProyectos(Proyecto proyecto) {
        int validacion = 0;
        try {
            String sql = "INSERT INTO proyecto (nombre_proyecto, descripcion_proyecto, fecha_inicio_proyecto, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(proyecto.getFecha_inicio());
            ps.setDate(3, fechaInicioSQL);
            ps.setBoolean(4, proyecto.getEstado());
            validacion = ps.executeUpdate();
            if (validacion == 1) {
                System.out.println("Se agregó un nuevo Proyecto");
                JOptionPane.showMessageDialog(null, "Se Cargo Nuevo proyecto");
            } else {
                System.out.println("Se produjo un error al agregar un Proyecto");
                JOptionPane.showMessageDialog(null, "No se pudo Cargar Nuevo Proyecto");
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
                    proyect.setEstado(rs.getBoolean("estado"));

                    proyectos.add(proyect);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
        return proyectos;

    }

    //---------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------
    public Proyecto selectProyecto(int id_proyecto) {
        Proyecto proyect = new Proyecto();

        String consulta = "SELECT * FROM `proyecto` WHERE `id_proyecto` = ?";

        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            stmt.setInt(1, id_proyecto);
            ResultSet result = stmt.executeQuery();
            System.out.println(stmt);
            if (result.next()) {
                proyect.setId_proyecto(result.getInt("id_proyecto"));
                proyect.setNombre(result.getString("nombre_proyecto"));
                proyect.setDescripcion(result.getString("descripcion_proyecto"));
                java.sql.Date fechaInicioSQL = result.getDate("fecha_inicio_proyecto");
                java.util.Date fechaInicioUtil = new java.util.Date(fechaInicioSQL.getTime());
                java.time.LocalDate fechaInicioLocalDate = fechaInicioUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                proyect.setFecha_inicio(fechaInicioLocalDate);
                proyect.setEstado(result.getBoolean("estado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);

        }
        return proyect;
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
            ps.setBoolean(4, proyecto.getEstado());
            ps.setInt(5, proyecto.getId_proyecto());
            validacion = ps.executeUpdate();

            if (validacion == 1) {
                System.out.println("Proyecto Actualizado");
                JOptionPane.showMessageDialog(null, "Peticion Confirmada");
            } else {
                JOptionPane.showMessageDialog(null, "Peticion Denegada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se accedio a la base de dato");
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
                proyecto.setEstado(result.getBoolean("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
        return proyecto;
    }

    public ArrayList<Equipo> selectEquipos(Proyecto proyect) {
        ArrayList<Equipo> equipos = new ArrayList();
        EquipoData equipo = new EquipoData();
        equipos = equipo.selectEquipos(proyect);
        return equipos;

    }

}

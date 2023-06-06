/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import models.Proyecto;

/**
 *
 * @author Ruben
 */
public class proyectoData {

    public proyectoData() {
    }
    
    public void insertProyecto(Proyecto proyecto)
   {
        int validacion = 0;
        try {
            String sql = "INSERT INTO proyecto (nombre_proyecto, descripcion_proyecto, fecha_Inicio_proyecto, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(proyecto.getFechainicio());
            ps.setDate(3,fechaInicioSQL);
            ps.setInt(4,proyecto.getEstado());
            validacion = ps.executeUpdate();
            if (validacion == 1) {
                System.out.println("Se agregó un nuevo Proyecto");   
            }else{
                System.out.println("Se produjo un error al agregar un Proyecto");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al agregar un Proyecto: "+e.getMessage());
        }
    }
    
    
    public ArrayList<Proyecto> selectProyecto()
    {   ArrayList proyectos=new ArrayList();
      
        try {

            String sql = "SELECT * from proyecto WHERE estado = 1";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                System.out.println("No hay Proyecto para Mostrar");
            } else {
                while (rs.next()) {
                    Proyecto proyect=new Proyecto();
                   proyect.setIdproyecto(rs.getInt("id_proyecto"));
                     proyect.setNombre(rs.getString("nombre_proyecto"));
                    proyect.setDescripcion(rs.getString("descripcion_proyecto"));
                    java.sql.Date fechaInicioSQL = rs.getDate("fecha_Inicio_proyecto");
                    java.util.Date fechaInicioUtil = new java.util.Date(fechaInicioSQL.getTime());
                    java.time.LocalDate fechaInicioLocalDate = fechaInicioUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                   proyect.setFechainicio(fechaInicioLocalDate);
                    proyect.setEstado(rs.getInt("estado"));
                    
                    proyectos.add(proyect);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
        return proyectos;
    }
    public void updateProyecto(Proyecto proyecto){
        int validacion = 0;
        try {
            String sql = "UPDATE `proyecto` SET `nombre_proyecto`= ? , `descripcion_proyecto`= ? , `fecha_Inicio_proyecto`= ? ,`estado`= ? WHERE `id_proyecto`=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
          
            java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(proyecto.getFechainicio());
            ps.setDate(3,fechaInicioSQL);
            ps.setInt(4, proyecto.getEstado());
            ps.setInt(5, proyecto.getIdproyecto());
            validacion = ps.executeUpdate();
              System.out.println(ps);
            if (validacion == 1) {
                System.out.println("Proyecto Actualizado");   
            }else{
                System.out.println("Se produjo un error al actualizar un miembro");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al actualizar el proyecto: "+e.getMessage());
        }
      
    }
    
}

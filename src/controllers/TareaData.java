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
import models.Miembro;
import models.Tarea;

/**
 *
 * @author Ro
 */
public class TareaData {

    public TareaData() {
    }
    
    //asignar tarea
    public void asignarTarea(Tarea tarea){
       
        int resultado;
        
        try{
            String sql="INSERT INTO tarea (nombre_tarea, fecha_inicio_tarea, fecha_fin_tarea, estado_tarea, id_miembro_equipo) VALUES (?,?,?,?,?)";
            PreparedStatement ps=Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2,Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3,Date.valueOf(tarea.getFechaCierre()));
            ps.setInt(4,tarea.getEstado());
           // ps.setInt(5, tarea.getEquipoMiembro().getIdEquipoMiembro());
            
            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se agregó la tarea");   
            }else{
                System.out.println("Se produjo un error al agregar la tarea");
            }
        
        
        }catch (SQLException e){
            System.out.println("Error al acceder a la tabla Tarea " + e.getMessage());
        }
        
    }
    
    //
    public void updateTarea(Tarea tarea){
        int resultado;
        
        try{
            String sql="UPDATE tarea SET nombre_tarea=?,fecha_inicio_tarea=?,fecha_fin_tarea=?,estado_tarea=?,id_miembro_equipo=? WHERE id_tarea=?";
            
            PreparedStatement ps=Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2,Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3,Date.valueOf(tarea.getFechaCierre()));
            ps.setInt(4,tarea.getEstado());
           // ps.setInt(5, tarea.getEquipoMiembro().getIdEquipoMiembro());
            ps.setInt(6, tarea.getIdTarea());
            
            
            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se actualizó la tarea");   
            }else{
                System.out.println("Se produjo un error al actualizar la tarea");
            }
        }catch(SQLException e){
            System.out.println("Error al acceder a la tabla Tarea " + e.getMessage());
        } 
    }
    //busca tarea por id
    public Tarea selectTarea(Tarea tarea){
        
        int resultado;
        //EquipoMiembro
        try{
            String sql="SELECT * FROM tarea WHERE id_tarea=? ";
            PreparedStatement ps=Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1,tarea.getIdTarea());
            
            if(rs==null){
                System.out.println("No se encontró la tarea");
            }else if(rs.next()){
                int idMiembroEquipo=rs.getInt("id_miembro_equipo");
                tarea.setEstado(rs.getInt("estado_tarea"));
                tarea.setFechaCierre(rs.getDate("fecha_fin_tarea").toLocalDate());
                tarea.setFechaCreacion(rs.getDate("fecha_inicio_tarea").toLocalDate());
                tarea.setNombre(rs.getString("nombre_tarea"));
                
            }
        }catch(SQLException e){
            System.out.println("Error al acceder a la tabla Tarea " + e.getMessage());
        } 
        return tarea;
    }
    //Para filtrar tareas por estado
    public ArrayList<Tarea> selectTareasEstado(Tarea tarea){
        
        ArrayList<Tarea> tareas= new ArrayList();
        //EquipoMiembro
        try{
            String sql="SELECT * FROM tarea WHERE estado_tarea=?";
            PreparedStatement ps=Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1,tarea.getEstado());
            
            if(rs==null){
                System.out.println("No se encontraron tareas");
            }else{
                while(rs.next()){
                    Tarea aux = new Tarea();
                    int idMiembroEquipo=rs.getInt("id_miembro_equipo");
                    aux.setEstado(rs.getInt("estado_tarea"));
                    aux.setFechaCierre(rs.getDate("fecha_fin_tarea").toLocalDate());
                    aux.setFechaCreacion(rs.getDate("fecha_inicio_tarea").toLocalDate());
                    aux.setNombre(rs.getString("nombre_tarea"));
                    aux.setIdTarea(rs.getInt("id_tarea"));
                    tareas.add(aux);
                }
            }
            
        }catch(SQLException e){
            System.out.println("Error al acceder a la tabla Tarea" + e.getMessage());
        } 
        return tareas;
    }
    
    //filtrar tareas por miembro
    public ArrayList<Tarea> selectTareasMiembro(Tarea tarea){
        
        ArrayList<Tarea> tareas= new ArrayList();
        //EquipoMiembro
        //int idMiembroEquipo=tarea.getEquipoMiembro().getIdEquipoMiembro();
        try{
            String sql="";
            PreparedStatement ps=Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //ps.setInt(1,idMiembroEquipo); 
            
            if(rs==null)
            {
                
            }else{
                while(rs.next()){
                     Tarea aux = new Tarea();
                    aux.setEstado(rs.getInt("estado_tarea"));
                    aux.setFechaCierre(rs.getDate("fecha_fin_tarea").toLocalDate());
                    aux.setFechaCreacion(rs.getDate("fecha_inicio_tarea").toLocalDate());
                    aux.setNombre(rs.getString("nombre_tarea"));
                    aux.setIdTarea(rs.getInt("id_tarea"));
                    tareas.add(aux);
                }
            }
                
            
        }catch(SQLException e){
            System.out.println("Error al acceder a la tabla Tarea" + e.getMessage());
        } 
        
        return tareas;
    }
    
}

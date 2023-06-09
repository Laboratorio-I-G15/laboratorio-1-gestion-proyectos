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
import models.Comentario;

/**
 *
 * @author Ro
 */
public class ComentarioData {

    public ComentarioData() {
    }
    public void insertComentario(Comentario comentario){
        
        int resultado;
        try{
            String sql="INSERT INTO comentario(comentario, fecha_avance, id_tarea) VALUES (?,?,?)";
            PreparedStatement ps=Conexion.getConexion().prepareStatement(sql);
            ps.setString(1,comentario.getComentario() );
            ps.setDate(2,Date.valueOf(comentario.getFechaAvance()));
            ps.setInt(3,comentario.getTarea().getIdTarea());
            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se agregó el comentario");   
            }else{
                System.out.println("Se produjo un error al agregar el comentario");
            }
        }catch (SQLException e){
            System.out.println("Error al acceder a la tabla Comentario" + e.getMessage());
        }
    }
}

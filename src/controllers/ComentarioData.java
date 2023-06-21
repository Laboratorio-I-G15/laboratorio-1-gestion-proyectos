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
import models.Comentario;

/**
 *
 * @author Ro
 */
public class ComentarioData {

    public ComentarioData() {
    }

    //Inserta comentarios en una tarea determinada. Devuelve true si se insertó el comentario
    public boolean insertComentario(Comentario comentario) {

        int resultado;
        try {
            String sql = "INSERT INTO comentario(comentario, fecha_avance, id_tarea) VALUES (?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, comentario.getComentario());
            ps.setDate(2, Date.valueOf(comentario.getFechaAvance()));
            ps.setInt(3, comentario.getTarea().getIdTarea());
            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se agregó el comentario");
                return true;
            } else {
                System.out.println("Se produjo un error al agregar el comentario");
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Comentario " + e.getMessage());
        }
        return false;
    }

    //Selecciona todos los comentarios de una tarea determinada
    public ArrayList<Comentario> selectComentarios(Comentario comentario) {

        ArrayList<Comentario> comentarios = new ArrayList();
        try {
            String sql = "SELECT * FROM comentario WHERE id_tarea=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, comentario.getTarea().getIdTarea());
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                System.out.println("No se encontraron comentarios para la tarea");
            } else {
                while (rs.next()) {
                    Comentario coment = new Comentario();
                    coment.setComentario(rs.getString("comentario"));
                    coment.setFechaAvance(rs.getDate("fecha_avance").toLocalDate());
                    coment.setIdComentario(rs.getInt("id_comentario"));
                    coment.setTarea(comentario.getTarea());
                    comentarios.add(coment);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Comentario " + e.getMessage());
        }
        return comentarios;
    }
    //actualizar comentario devuelve true si se logró actualizar el comentario

    public boolean updateComentario(Comentario comentario) {
        int resultado;
        try {
            String sql = "UPDATE comentario SET comentario=?,fecha_avance=? WHERE id_comentario=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, comentario.getComentario());
            ps.setDate(2, Date.valueOf(comentario.getFechaAvance()));
            ps.setInt(3, comentario.getIdComentario());

            resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se actualizó el comentario");
                return true;
            } else {
                System.out.println("Se produjo un error al actualizar el comentario");
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Comentario " + e.getMessage());
        }
        return false;
    }
}

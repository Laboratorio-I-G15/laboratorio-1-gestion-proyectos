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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import models.Equipo;
import models.Proyecto;

/**
 *
 * @author Rafael Lopez
 */
public class EquipoData {

    private Equipo equipo;
    // private Proyecto proyecto;

    public EquipoData() {
    }

    /**
     * Recibe Equipo y Proyecto , se inserta el eqipo
     *
     * @param equipo
     * @param proyecto
     * @return result
     */
    public int insertEquipo(Equipo equipo, Proyecto proyecto) {
        int result = 0;
        String consulta = "INSERT INTO `equipo`(`id_proyecto`, `nombre_equipo`, `fecha_creacion_equipo`, `estado_equipo`) VALUES ( ?, ?, ?, ?)";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setInt(1, proyecto.getId_proyecto());
            stmt.setString(2, equipo.getNombre());
            stmt.setDate(3, java.sql.Date.valueOf(equipo.getCreacion()));
            stmt.setInt(4, equipo.getEstado());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Equipo> selectEquipos() {

        ArrayList<Equipo> equipos = new ArrayList();
        String consulta = "SELECT * FROM `equipo` WHERE 1 ";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Equipo equipo = new Equipo();
                equipo.setId_equipo(result.getInt("id_equipo"));
                equipo.setNombre(result.getString("nombre_equipo"));
                equipo.setCreacion(result.getDate("fecha_creacion_equipo").toLocalDate());
                equipo.setId_proyecto(result.getInt("id_proyecto"));
                equipo.setEstado(result.getInt("estado_equipo"));

//                Equipo equi = new Equipo(result.getInt("id_equipo"), result.getString("nombre_equipo"), result.getDate("fecha_creacion_equipo").toLocalDate(), result.getInt("estado_equipo"));
                equipos.add(equipo);
                System.out.println(result.getInt("id_equipo") + " id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return equipos;
    }

    public Equipo selectEquipo(Equipo equipo, String campo) {
        String consulta = "SELECT * FROM `equipo` WHERE ` ? ` = ? ";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setString(1, campo);
            switch (campo) {
                case "id_equipo":
                    stmt.setInt(1, equipo.getId_equipo());
                    break;
                case "id_proyecto":
                    stmt.setInt(1, equipo.getId_proyecto());
                    break;
                case "nombre_equipo":
                    stmt.setString(1, equipo.getNombre());
                    break;
                case "estado":
                    stmt.setInt(1, equipo.getEstado());
                    break;
                /*
                case "fecha_creacion_equipo":
                    switch (condicion) {
                        case "mayor":
                            consulta = "SELECT * FROM `equipo` WHERE ` ? ` < ? ";
                            break;
                        case "menor":
                            consulta = "SELECT * FROM `equipo` WHERE ` ? ` > ? ";
                            break;
                        case "igual":
                            consulta = "SELECT * FROM `equipo` WHERE ` ? ` like ? ";
                            break;
                    }
                    stmt.setDate(1, Date.valueOf(equipo.getCreacion()));
                    break;
                 */
            }
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                System.out.println(result.toString());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return equipo;
    }

    /**
     * Recibe equipo y proyecto realiza actualizacion: incluey borrado logico
     *
     * @param equipo
     * @param proyecto
     * @return
     */
    public int updateEquipo(Equipo equipo, Proyecto proyecto) {
        int result = 0;
        String consulta = "UPDATE `equipo` SET `id_proyecto`='?',`nombre_equipo`='?',`fecha_creacion_equipo`='?',`estado_equipo`='?' WHERE ?";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setInt(1, proyecto.getId_proyecto());
            stmt.setString(2, equipo.getNombre());
            stmt.setDate(3, java.sql.Date.valueOf(equipo.getCreacion()));
            stmt.setInt(4, equipo.getEstado());
            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo correctamente", "EQUIPO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Recibe un Proyecto y devuelve una MAP con todos los equipos relacionados con ese proyecto Unicamente equipos
     *
     * @param proyecto
     * @return
     */
    /*    public HashMap<Integer, ArrayList<Equipo>> selectEquipos(Proyecto proyecto) {
        // Map de equipos, uso id_equipo como key para relacionar
        HashMap<Integer, ArrayList<Equipo>> proyecto_equipos = new HashMap<>();
        String consulta = "SELECT * FROM `equipo` WHERE `id_proyecto` LIKE ? ";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setInt(1, proyecto.getId_proyecto());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                // objetos para crear el  MAP
                ArrayList<Equipo> equipo_db = new ArrayList<>();
                int key = result.getInt("id_equipo");
                //instancia equipo
                Equipo equipo_1;
                equipo_1 = new Equipo(key, result.getString("nombre"), result.getDate("creacion").toLocalDate(), result.getInt("estado"));
                equipo_db.add(equipo_1);
                proyecto_equipos.put(key, equipo_db);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return proyecto_equipos;

    }
     */
}

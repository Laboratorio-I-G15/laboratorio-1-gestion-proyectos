/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Equipo;
import models.Proyecto;

/**
 *
 * @author Rafael Lopez
 */
public class EquipoData {

    public EquipoData() {
    }

    /**
     *
     */
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

    public void insertEquipos(Equipo equipo, Proyecto proyecto) {
        String consultaSelect = "SELECT COUNT(*) FROM equipo WHERE nombre_equipo = ? AND id_proyecto <> ?";
        String consultaInsert = "INSERT INTO equipo (id_proyecto, nombre_equipo, fecha_creacion_equipo, estado_equipo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmtSelect = Conexion.getConexion().prepareStatement(consultaSelect)) {
            // Verificar si el equipo ya existe en otro proyecto
            stmtSelect.setString(1, equipo.getNombre());
            stmtSelect.setInt(2, proyecto.getId_proyecto());
            ResultSet resultSet = stmtSelect.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Este equipo ya está asociado a otro proyecto.");
                return; // Salir del método sin realizar la inserción
            }

            // Insertar el nuevo equipo
            try (PreparedStatement stmtInsert = Conexion.getConexion().prepareStatement(consultaInsert)) {
                stmtInsert.setInt(1, proyecto.getId_proyecto());
                stmtInsert.setString(2, equipo.getNombre());
                stmtInsert.setDate(3, java.sql.Date.valueOf(equipo.getCreacion()));
                stmtInsert.setInt(4, equipo.getEstado());
                int result = stmtInsert.executeUpdate();

                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "Equipo agregado correctamente al proyecto.");
                } else {
                    System.out.println("Se produjo un error al insertar el equipo.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     *
     * @param estado Equipo
     * @return ArrrayList
     */
    public ArrayList<Equipo> selectEquipos(int estado) {
        ArrayList<Equipo> equipos = new ArrayList();
        if (estado == 0 || estado == 1) {
            String consulta = "SELECT * FROM `equipo` WHERE `estado_equipo` = ? ";
            try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
                stmt.setInt(1, estado);
                ResultSet result = stmt.executeQuery();
                while (result.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setId_equipo(result.getInt("id_equipo"));
                    equipo.setNombre(result.getString("nombre_equipo"));
                    equipo.setCreacion(result.getDate("fecha_creacion_equipo").toLocalDate());
                    equipo.setId_proyecto(result.getInt("id_proyecto"));
                    equipo.setEstado(result.getInt("estado_equipo"));
                    equipos.add(equipo);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: \n Dato consulta invalido", "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
        }
        return equipos;
    }

    /**
     *
     * @param proyecto
     * @return ArrayList
     */
    public ArrayList<Equipo> selectEquipos(Proyecto proyecto) {
        ArrayList<Equipo> equipos = new ArrayList();
        String consulta = "SELECT * FROM `equipo` WHERE `id_proyecto` = ? ";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            stmt.setInt(1, proyecto.getId_proyecto());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Equipo equipo = new Equipo();
                equipo.setId_equipo(result.getInt("id_equipo"));
                equipo.setNombre(result.getString("nombre_equipo"));
                equipo.setCreacion(result.getDate("fecha_creacion_equipo").toLocalDate());
                equipo.setId_proyecto(result.getInt("id_proyecto"));
                equipo.setEstado(result.getInt("estado_equipo"));
                equipos.add(equipo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return equipos;
    }

    /**
     *
     * @param id_equipo
     * @return Equipo
     */
    public Equipo selectEquipo(int id_equipo) {
        Equipo buscado = new Equipo();
        String consulta = "SELECT * FROM equipo WHERE id_equipo = ? ";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            stmt.setInt(1, id_equipo);
            ResultSet result = stmt.executeQuery();
            System.out.println(stmt);
            if (result.next()) {
                buscado.setId_equipo(result.getInt("id_equipo"));
                buscado.setNombre(result.getString("nombre_equipo"));
                buscado.setCreacion(result.getDate("fecha_creacion_equipo").toLocalDate());
                buscado.setId_proyecto(result.getInt("id_proyecto"));
                buscado.setEstado(result.getInt("estado_equipo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return buscado;
    }

    /**
     *
     * @param nombre equipo
     * @return Equipo
     */
    public Equipo selectEquipo(String nombre) {
        Equipo buscado = new Equipo();
        String consulta = "SELECT * FROM `nombre` WHERE `nombre_equipo` = ? ";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            stmt.setString(1, nombre);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                buscado.setId_equipo(result.getInt("id_equipo"));
                buscado.setNombre(result.getString("nombre_equipo"));
                buscado.setCreacion(result.getDate("fecha_creacion_equipo").toLocalDate());
                buscado.setId_proyecto(result.getInt("id_proyecto"));
                buscado.setEstado(result.getInt("estado_equipo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return buscado;
    }

    /**
     * Devuelve ULTIMO equipo insertado
     *
     * @return
     */
    public Equipo selectEquipo() {
        Equipo buscado = new Equipo();
        String consulta = "SELECT * FROM `equipo` ORDER BY  `id_equipo` DESC LIMIT 1";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                buscado.setId_equipo(result.getInt("id_equipo"));
                buscado.setNombre(result.getString("nombre_equipo"));
                buscado.setCreacion(result.getDate("fecha_creacion_equipo").toLocalDate());
                buscado.setId_proyecto(result.getInt("id_proyecto"));
                buscado.setEstado(result.getInt("estado_equipo"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return buscado;
    }

    /**
     * Recibe equipo y proyecto realiza actualizacion: incluye borrado logico
     *
     * @param equipo
     * @return result
     */
    public int updateEquipo(Equipo equipo) {
        int result = 0;
        System.out.println(equipo.getId_equipo());
        System.out.println(equipo);

        String consulta = "UPDATE `equipo` SET  `nombre_equipo`=?, `fecha_creacion_equipo`=?, `estado_equipo`=? WHERE `id_equipo` = ?";

        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {

            stmt.setString(1, equipo.getNombre());
            stmt.setDate(2, java.sql.Date.valueOf(equipo.getCreacion()));
            stmt.setInt(3, equipo.getEstado());
            stmt.setInt(4, equipo.getId_equipo());
            result = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo correctamente", "EQUIPO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return result;
    }

    public boolean verifyEquipo(String nombre_equipo) {
//        Equipo buscado = new Equipo();
        String consulta = "SELECT id_equipo FROM equipo WHERE nombre_equipo like ? ";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            stmt.setString(1, nombre_equipo);
            ResultSet result = stmt.executeQuery();
            System.out.println(stmt);
            if (result == null) {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return true;
    }

}

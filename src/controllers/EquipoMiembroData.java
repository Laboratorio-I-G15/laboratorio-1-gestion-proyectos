/*
 Clase controladora de acceso a datos del Miembro - sistema de Gestion - Laboratorio 1.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Equipo;
import models.Miembro;

/**
 *
 * @author leo_t
 */
public class EquipoMiembroData {

    private Miembro miembro = new Miembro();
    private Equipo equipo = new Equipo();

    public EquipoMiembroData() {
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Equipo setEquipo(Equipo equipo) {
        this.equipo = equipo;
        return equipo;
    }

    /**
     * devuelve ArrayList miembro de un equipo
     *
     * @param id_equipo
     * @return
     */
    public ArrayList<Miembro> selectEquipoMiembro(int id_equipo) {
        ArrayList<Miembro> miembros = new ArrayList();
        String consulta = " SELECT `miembro`.`id_miembro`, `miembro`.`nombre`"
                + " FROM `miembro` JOIN `equipo_miembro` ON `miembro`.`id_miembro`=`equipo_miembro`.`id_miembro`"
                + " JOIN `equipo` ON `equipo_miembro`.`id_equipo`=`equipo`.`id_equipo`"
                + " WHERE `equipo`.`id_equipo` = ?;";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setInt(1, id_equipo);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                while (result.next()) {
                    Miembro miembro_1 = new Miembro();
                    miembro_1.setIdMiembro(result.getInt("id_miembro"));
                    miembro_1.setDni(result.getLong("dni"));
                    miembro_1.setApellido(result.getString("apellido"));
                    miembro_1.setNombre(result.getString("nombre"));
                    miembro_1.setEstado(result.getBoolean("estado"));
                    miembros.add(miembro_1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return miembros;
    }

    /**
     * devuelve ArrayList miembros, relacionados con un
     *
     * @param equipo
     * @return
     */
    public ArrayList<Miembro> selectEquipoMiembro(Equipo equipo) {
        ArrayList<Miembro> miembros = new ArrayList();
        String consulta = " SELECT `miembro`.`id_miembro`, `miembro`.`nombre`"
                + " FROM `miembro` JOIN `equipo_miembro` ON `miembro`.`id_miembro`=`equipo_miembro`.`id_miembro`"
                + " JOIN `equipo` ON `equipo_miembro`.`id_equipo`=`equipo`.`id_equipo`"
                + " WHERE `equipo`.`id_equipo` = ?;";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setInt(1, equipo.getId_equipo());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                while (result.next()) {
                    Miembro miembro_1 = new Miembro();
                    miembro_1.setIdMiembro(result.getInt("id_miembro"));
                    miembro_1.setDni(result.getLong("dni"));
                    miembro_1.setApellido(result.getString("apellido"));
                    miembro_1.setNombre(result.getString("nombre"));
                    miembro_1.setEstado(result.getBoolean("estado"));
                    miembros.add(miembro_1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return miembros;
    }
}

/*
 Clase controladora de acceso a datos del Miembro - sistema de Gestion - Laboratorio 1.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Equipo;
import models.EquipoMiembro;
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
     * devuelve el idMiembroEquipo
     *
     * @param 
     * @return
     */
    public int selectIdEquipoMiembro(int id_miembro) {
        
        
        int id_equipo_miembro=0;
        
        String consulta = "SELECT *  FROM equipo_miembro JOIN miembro ON equipo_miembro.id_miembro = miembro.id_miembro WHERE miembro.id_miembro = 1";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            //stmt.setInt(1, 1);
            System.out.println(stmt);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
               id_equipo_miembro=result.getInt("id_miembro_equipo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return id_equipo_miembro;
    }
    
    
    
    
    
    /**
     * devuelve ArrayList miembro de un equipo
     *
     * @param id_equipo
     * @return
     */
    public ArrayList<Miembro> selectEquipoMiembro(int id_equipo) {
        ArrayList<Miembro> miembros = new ArrayList();
        String consulta = "SELECT `miembro`.*  FROM equipo_miembro JOIN miembro ON equipo_miembro.id_miembro = miembro.id_miembro JOIN equipo ON equipo_miembro.id_equipo = equipo.id_equipo WHERE equipo.id_equipo = ?;";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setInt(1, id_equipo);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Miembro miembro_1 = new Miembro();
                miembro_1.setIdMiembro(result.getInt("id_miembro"));
                miembro_1.setDni(result.getLong("dni"));
                miembro_1.setApellido(result.getString("apellido"));
                miembro_1.setNombre(result.getString("nombre"));
                miembro_1.setEstado(result.getBoolean("estado"));
                miembros.add(miembro_1);
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
    public void insertEquipoMiembro(int id_miembro, int id_equipo)
    {  
      
     int validacion = 0;
        try {
           String sql="INSERT INTO equipo_miembro( fecha_inscripcion, id_equipo, id_miembro) VALUES (?,?,?)";
           System.out.println("hola");
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
             System.out.println("hola");
           java.sql.Date fechaInicioSQL = java.sql.Date.valueOf(LocalDate.now());
            System.out.println("no paso");
            ps.setDate(1, fechaInicioSQL);
            ps.setInt(2,id_equipo);
            ps.setInt(3, id_miembro);
            
            validacion = ps.executeUpdate();
            if (validacion == 1) {
                System.out.println("Se asigno miembro al equipo");
            } else {
                System.out.println("Se produjo un error al agregar un miembro al equipo");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al agregar un Proyecto: " + e.getMessage());
        }
    }

    
    public ArrayList<Miembro> selectEquipoMiembro(Equipo equipo) {
        ArrayList<Miembro> miembros = new ArrayList();
        String consulta = " SELECT `miembro`.*"
                + " FROM `miembro` JOIN `equipo_miembro` ON `miembro`.`id_miembro`=`equipo_miembro`.`id_miembro`"
                + " JOIN `equipo` ON `equipo_miembro`.`id_equipo`=`equipo`.`id_equipo`"
                + " WHERE `equipo`.`id_equipo` = ?;";
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(consulta)) {
            // bindeo id_proyecto
            stmt.setInt(1, equipo.getId_equipo());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Miembro miembro_1 = new Miembro();
                miembro_1.setIdMiembro(result.getInt("id_miembro"));
                miembro_1.setDni(result.getLong("dni"));
                miembro_1.setApellido(result.getString("apellido"));
                miembro_1.setNombre(result.getString("nombre"));
                miembro_1.setEstado(result.getBoolean("estado"));
                miembros.add(miembro_1);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return miembros;
    }
}

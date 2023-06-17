/*
 Clase controladora de acceso a datos del Miembro - sistema de Gestion - Laboratorio 1.
 */
package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Miembro;

/**
 *
 * @author leo_t
 */
public class MiembroData {
    
    private ArrayList <Miembro>miembros = new ArrayList();
    /**
     * Metodo para listar los miembros de una bd donde el estado sea activo;
     * al listar sin recibir parametros, obtengo un array para su posterior uso
     * en un comboBox en las vistas.
     * @return ArrayList de miembros activos
     */
    public ArrayList<Miembro> selectMiembro() {
        try {

            String sql = "SELECT * from miembro WHERE estado = 1";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                System.out.println("No se encontró ningun miembro");
            } else {
                while (rs.next()) {
                    Miembro miem=new Miembro();
                    miem.setIdMiembro(rs.getInt("id_miembro"));
                    miem.setDni(rs.getLong("dni"));
                    miem.setApellido(rs.getString("apellido"));
                    miem.setNombre(rs.getString("nombre"));
                    miem.setEstado(rs.getBoolean("estado"));
                    miembros.add(miem);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
        return this.miembros;
    }
    /**
     * Metodo para insertar/agregar un miembro a la bd
     * usando una consulta parametrizada.
     * @param miembro pasado por parametro
     * @return verdadero o falso si se agrega un miembro
     */
    public boolean insertMiembro(Miembro miembro){
        int validacion = 0;
        try {
            String sql = "INSERT INTO miembro(dni, apellido, nombre, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setLong(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setBoolean(4, miembro.isEstado());
            validacion = ps.executeUpdate();
            if (validacion == 1) {
                System.out.println("Se agregó un nuevo miembro");   
                 return true;
            }else{
                System.out.println("Se produjo un error al agregar un miembro");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al agregar un miembro: "+e.getMessage());
        }
        return false;
    }
    /**
     * Metodo para actualizar un miembro en la bd
     * con este metodo se puede actualizar cuaquier campo y 
     * volver a guardar en el mismo objeto de tipo miembro
     * @param miembro
     * @
     */
    public void updateMiembro(Miembro miembro){
        int validacion = 0;
        try {
            String sql = "UPDATE `miembro` SET `dni`= ? , `apellido`= ? , `nombre`= ? ,`estado`= ? WHERE `id_miembro`=?";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setLong(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setBoolean(4, miembro.isEstado());
            ps.setInt(5, miembro.getIdMiembro());
            validacion = ps.executeUpdate();
            if (validacion == 1) {
                JOptionPane.showMessageDialog(null,"se HIcieron los cambios en miembros");
            }else{
                JOptionPane.showMessageDialog(null,"error al hacer cambio em miembros");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al actualizar un miembro: "+e.getMessage());
        }
      
    }
    /**
     * Metodo para validar si ya existe un miembro/usuario en la base de datos.
     * @param dni (long) como parametro para buscar el dni en la base de datos
     * @return devuelve un true si lo encuentra o false si no lo encuentra y permite
     * realizar un insert.
     */
    public boolean verificarMiembro(long dni){
        String sql = "SELECT count(nombre)FROM miembro WHERE dni = ?";
        try {
           PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setLong(1, dni);
           ResultSet rs = ps.executeQuery();
           if (rs.next()){
               rs.getLong(1);
            System.out.println("Se encontro un miembro con el mismo DNI");
           }else{
               System.out.println("El miembro se puede agregar a la base de datos");
           }
           return true;
        } catch (SQLException e) {
            System.out.println("ERROR: "+e);
            return false;
        }
    }
    
    
    
    
}

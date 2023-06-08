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
    }

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

//
//    private ArrayList <Miembro>miembros = new ArrayList();
//    /**
//     * Metodo para listar los miembros de una bd donde el estado sea activo;
//     * al listar sin recibir parametros, obtengo un array para su posterior uso
//     * en un comboBox en las vistas.
//     * @return ArrayList de miembros activos
//     */
//    public ArrayList<Miembro> selectMiembro() {
//        try {
//
//            String sql = "SELECT * from miembro WHERE estado = 1";
//            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            if (rs == null) {
//                System.out.println("No se encontró ningun miembro");
//            } else {
//                while (rs.next()) {
//                    Miembro miem=new Miembro();
//                    miem.setIdMiembro(rs.getInt("id_miembro"));
//                    miem.setDni(rs.getLong("dni"));
//                    miem.setApellido(rs.getString("apellido"));
//                    miem.setNombre(rs.getString("nombre"));
//                    miem.setEstado(rs.getBoolean("estado"));
//                    miembros.add(miem);
//                }
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Ocurrio un error: " + (e.getMessage()));
//        }
//        return this.miembros;
//    }
//    /**
//     * Metodo para insertar/agregar un miembro a la bd
//     * usando una consulta parametrizada.
//     * @param miembro pasado por parametro
//     */
//    public void insertMiembro(Miembro miembro){
//        int validacion = 0;
//        try {
//            String sql = "INSERT INTO miembro(dni, apellido, nombre, estado) VALUES (?,?,?,?)";
//            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
//            ps.setLong(1, miembro.getDni());
//            ps.setString(2, miembro.getApellido());
//            ps.setString(3, miembro.getNombre());
//            ps.setBoolean(4, miembro.isEstado());
//
//            validacion = ps.executeUpdate();
//            if (validacion == 1) {
//                System.out.println("Se agregó un nuevo miembro");
//            }else{
//                System.out.println("Se produjo un error al agregar un miembro");
//            }
//        } catch (SQLException e) {
//            System.out.println("Ocurrio un error al agregar un miembro: "+e.getMessage());
//        }
//    }
//    /**
//     * Metodo para actualizar un miembro en la bd
//     * con este metodo se puede actualizar cuaquier campo y
//     * volver a guardar en el mismo objeto de tipo miembro
//     * @
//     */
//    public void updateMiembro(Miembro miembro){
//        int validacion = 0;
//        try {
//            String sql = "UPDATE `miembro` SET `dni`= ? , `apellido`= ? , `nombre`= ? ,`estado`= ? WHERE `id_miembro`=?";
//            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
//            ps.setLong(1, miembro.getDni());
//            ps.setString(2, miembro.getApellido());
//            ps.setString(3, miembro.getNombre());
//            ps.setBoolean(4, miembro.isEstado());
//            ps.setInt(5, miembro.getIdMiembro());
//            validacion = ps.executeUpdate();
//              System.out.println(ps);
//            if (validacion == 1) {
//                System.out.println("Se actualizó un miembro de la base de datos");
//            }else{
//                System.out.println("Se produjo un error al actualizar un miembro");
//            }
//        } catch (SQLException e) {
//            System.out.println("Ocurrio un error al actualizar un miembro: "+e.getMessage());
//        }
//
//    }
//
//}

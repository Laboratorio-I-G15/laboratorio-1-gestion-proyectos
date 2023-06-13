/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Lopez
 */
public class Conexion {

    /**
     * metodo para conectarse a una bd en remoto.
     */
    private static Connection conectar = null;
    private static String base = "leotoloza_proyectogestion"; //nombre de la base de datos
    private static String usuario = "root"; // usuario para acceder a la base de datos, por defecto es 'root'
    private static String pass = ""; // contraseña para acceder, por defecto el usuario root, no tiene contraseña
    private static String url = "jdbc:mysql://localhost:3306/" + base; // URL es la direccion de la Conexion, por defecto en local y el puerto 3306 + el nombre de la db
//    private static String base = "leotoloza_proyectogestion"; //nombre de la base de datos
//    private static String usuario = "leotoloza"; // usuario para acceder a la base de datos, por defecto es 'root'
//    private static String pass = "LeonelSantiagoToloza113346"; // contraseña para acceder, por defecto el usuario root, no tiene contraseña
//    private static String url = "jdbc:mysql://mysql-leotoloza.alwaysdata.net/" + base; // URL es la direccion de la Conexion, por defecto en local y el puerto 3306 + el nombre de la db

    /**
     * constructor privado para usar un patron singleton para la conexion.
     */
    private Conexion() {
    }

    /**
     * metodo para conectarse a la bd en remoto, alerta con un aviso por consola si se conectó satisfactoriamente.
     *
     * @return devuelve una Conexion
     */
    public static Connection getConexion() {
        if (conectar == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conectar = DriverManager.getConnection(url, usuario, pass);

                /* descomentar  para  corroborar  que la conexion sea correcta  */
                // JOptionPane.showMessageDialog(null, "Se conecto correctamente", "BASE DATOS", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Conectado exitosamente!");
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Se ha producido un error.", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //System.out.println(" Utilizando Conexion existente! ");
        }
        return conectar;
    }
}

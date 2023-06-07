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

/**
 *
 * @author Rafael Lopez
 */
public class Conexion {

    /**
     * metodo para conectarse a una bd en local.
     */
    private static Connection conectar = null;
    private static final String BASE = "leotoloza_proyectogestion"; //nombre de la BASE de datos
    private static final String USUARIO = "leotoloza"; // USUARIO para acceder a la BASE de datos, por defecto es 'root'
    private static final String PASS = "LeonelSantiagoToloza113346"; // contraseña para acceder, por defecto el USUARIO root, no tiene contraseña
    private static final String URL = "jdbc:mysql://mysql-leotoloza.alwaysdata.net/" + BASE; // URL es la direccion de la Conexion, por defecto en local y el puerto 3306 + el nombre de la db

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
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conectar = DriverManager.getConnection(URL, USUARIO, PASS);
            /**
             * descomentar la linea 32 y corroborar en consola que la conexion sea correcta
             */
            System.out.println("Conectado exitosamente!");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conectar;
    }
}

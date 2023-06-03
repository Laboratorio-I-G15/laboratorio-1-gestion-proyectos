/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.Miembro;

/**
 *
 * @author leo_t
 */
public class NewMain {

    /** clase main para hacer prubas por consola
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        miembroData miembroData = new miembroData();
        Miembro miembroPrueba = new Miembro();
        ArrayList <Miembro> miembros;
         miembros=miembroData.selectMiembro();
        for (Miembro miembro1 : miembros) {
            System.out.println(miembro1);
        }
      
      
miembroPrueba.setDni(43690464);
miembroPrueba.setApellido("Vallejos");
miembroPrueba.setNombre("Roberta");
miembroPrueba.setEstado(true);

System.out.println("Miembro ID antes de la actualización: " + miembroPrueba.getIdMiembro());
/**
 * tengo un error con la actualizacion del miembro
 */
miembroData.updateMiembro(miembroPrueba);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import models.Equipo;
import models.Miembro;
import models.Proyecto;

/**
 *
 * @author leo_t
 */
public class NewMain {

    /**
     * clase main para hacer prubas por consola
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* test activacion */
        boolean miembro_test = false;
        boolean equipo_test = true;
        boolean proyecto_test = false;
        /* instancias test  y auxiliares */
        // miembro
        MiembroData miembroData = new MiembroData();
        Miembro miembroPrueba = new Miembro();
        Miembro miembroPrueba1 = new Miembro();
        Miembro miembr = new Miembro();
        Miembro miembraux = new Miembro();
        ArrayList<Miembro> miembros;
        // equipo

        EquipoData equipo_data = new EquipoData();
        ArrayList<Equipo> equipos = new ArrayList();

        // proyecto
        ProyectoData proyectData = new ProyectoData();
        ArrayList<Proyecto> proyectos;

        String fechaInicioString = "1989-05-22";
        java.time.LocalDate fechaInicio = java.time.LocalDate.parse(fechaInicioString);
        String fechaInicioString1 = "2000-01-15";
        java.time.LocalDate fechaInicio1 = java.time.LocalDate.parse(fechaInicioString1);
        if (proyecto_test) {
            Proyecto proyecto1 = new Proyecto("la punta", "hay que hacer un login", fechaInicio, 1);
            Proyecto proyecto2 = new Proyecto("universidad nacional", "hay que hacer el frontend", fechaInicio1, 1);
            proyectData.insertProyecto(proyecto1);
            proyectData.insertProyecto(proyecto2);
            Proyecto proyecto3 = new Proyecto("la punta", "modificado", fechaInicio, 1);
            proyectData.updateProyecto(proyecto3);
        }
        /*
        proyectos=proyectData.selectProyecto();
        Proyecto proyid=new Proyecto();
        proyid=proyectos.get(0);
        proyid.setDescripcion("vamos a hacer lavandina");
          proyectData.updateProyecto(proyid);
        for(int i=0;i<proyectos.size();i++)
        { Proyecto proyec=new Proyecto();
          proyec=proyectos.get(i);
            System.out.println(proyec.toString());
        }
         */
 /*
        miembroPrueba.setDni(43690464);
        miembroPrueba.setApellido("Vallejos");
        miembroPrueba.setNombre("Roberta");
        miembroPrueba.setEstado(true);
        miembroPrueba1.setDni(112131321);
        miembroPrueba1.setApellido("Villa");
        miembroPrueba1.setNombre("Robe");
        miembroPrueba1.setEstado(true);
        MiembroData.insertMiembro(miembroPrueba);
        MiembroData.insertMiembro(miembroPrueba1);
         */

        if (miembro_test) {
            miembros = miembroData.selectMiembro();
            miembraux = miembros.get(0);
            miembraux.setApellido("leoT");
            miembroData.updateMiembro(miembraux);
            for (int i = 0; i < miembros.size(); i++) {
                miembr = miembros.get(i);
                System.out.println(miembr.toString());
            }
        }
// test equipo
        if (equipo_test) {
            // insert equipo
//            Proyecto proyecto1 = new Proyecto(7, "la punta1", "hay que hacer un login", fechaInicio, 1);
//            Equipo equipo = new Equipo(6, "GRUPO 15", LocalDate.of(2023, 5, 15), 1);
//            equipo_data.insertEquipo(equipo, proyecto1);
//        public Equipo(int id_proyecto, String nombre, LocalDate creacion, int estado)

//    equipo_data.selectEquipo(equipo, fechaInicioString);
            equipos = equipo_data.selectEquipos();
            for (int i = 0; i < equipos.size(); i++) {
                Equipo equi = new Equipo();
                equi = equipos.get(i);
                System.out.println(equi.getId_equipo() + "id desde main");
            }
            for (Equipo equip : equipos) {
                System.out.println(equip.toString());
            }
        }

    }
}

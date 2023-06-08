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
        // Cambiar a true si quieren probar,  se recomienda  1 test x prueba usar misma metodologiapra realizar test [EIVITA COMENTAR LINEAS]

        boolean miembro_test = false;
        boolean equipo_test = true;
        boolean proyecto_test = false;
        boolean equipo_miembro_test = true;


        /* instancias test  y auxiliares */
        // miembro
        MiembroData miembroData = new MiembroData();
        Miembro miembroPrueba = new Miembro();
        Miembro miembroPrueba1 = new Miembro();
        Miembro miembr = new Miembro();
        Miembro miembraux = new Miembro();
        // meruipo miem,bro
        EquipoMiembroData equipo_miembro_data = new EquipoMiembroData();

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

// test proyecto
        if (proyecto_test) {
            // crear un proyecto
            System.out.println("Tst crear proyecto");
            Proyecto proyecto1 = new Proyecto("la punta", "hay que hacer un login", LocalDate.of(2023, 5, 15), 1);
            proyectData.insertProyecto(proyecto1);
            // verifica ultimo agregado
            ProyectoData proyecto_ultimo = new ProyectoData();
            Proyecto ultimo = proyecto_ultimo.selectUltimoProyecto();
            System.out.println("Verifica ultimo");
            System.out.println(ultimo.toString());
            // modifica ultimo agregado
            ultimo.setNombre("San Luis");
            ultimo.setDescripcion("Contruir Casa 200 m2");
            proyecto_ultimo.updateProyecto(ultimo);
            // verifica modificacion
            ultimo = proyecto_ultimo.selectUltimoProyecto();
            System.out.println("Verifica Modificado");
            System.out.println(ultimo.toString());
        }

// test miembro
        if (miembro_test) {
            boolean insert_miembro = false;
            System.out.println("Test insert miembro");
            if (insert_miembro) {
                miembroPrueba.setDni(43690464);
                miembroPrueba.setApellido("Vallejos");
                miembroPrueba.setNombre("Roberta");
                miembroPrueba.setEstado(true);
                miembroPrueba1.setDni(112131321);
                miembroPrueba1.setApellido("Villa");
                miembroPrueba1.setNombre("Robe");
                miembroPrueba1.setEstado(true);
                miembroData.insertMiembro(miembroPrueba);
                miembroData.insertMiembro(miembroPrueba1);
            }
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
            boolean insert_equipo = false;
            boolean mostrar_equipo = false;
            System.out.println("Test equipo");
            // insert equipo
            System.out.println("Test Insert equipo");
            if (insert_equipo) {
                System.out.println("linea 106");
                ProyectoData proyecto_ultimo = new ProyectoData();
                Proyecto ultimo = proyecto_ultimo.selectUltimoProyecto();
                Equipo equipo_ultimo = new Equipo();
                equipo_ultimo = equipo_data.selectEquipo();
                equipo_data.insertEquipo(equipo_ultimo, ultimo);
                Equipo buscado = new Equipo();
                buscado = equipo_data.selectEquipo();
                System.out.println("Ultimo equipo ingresado");
                System.out.println(buscado.toString());
            }
            if (mostrar_equipo) {
                equipos = equipo_data.selectEquipos(1);
                for (int i = 0; i < equipos.size(); i++) {
                    Equipo equi = new Equipo();
                    equi = equipos.get(i);
                }
                System.out.println("Listado equipos activos");
                for (Equipo equip : equipos) {
                    System.out.println(equip.toString());
                }
            }
        }

    }
}

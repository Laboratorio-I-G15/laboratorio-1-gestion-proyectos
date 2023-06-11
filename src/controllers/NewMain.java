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
import models.Tarea;

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
        /* Pruebas por consola */
        // Cambiar a true si quieres probar, se recomienda 1 test por prueba y usar la misma metodología para realizar pruebas

        boolean miembro_test = false;
        boolean equipo_test = false;
        boolean proyecto_test = false;
        boolean equipo_miembro_test = false;
        boolean tarea_test = true;
        /* Instancias de prueba y auxiliares */
        // Miembro
        MiembroData miembroData = new MiembroData();
        Miembro miembroPrueba = new Miembro();
        // Equipo Miembro
        EquipoMiembroData equipo_miembro_data = new EquipoMiembroData();

        // Equipo
        EquipoData equipo_data = new EquipoData();
        ArrayList<Equipo> equipos;

        // Proyecto
        ProyectoData proyectoData = new ProyectoData();
        // Test de proyecto
        if (proyecto_test) {
            // Crear un proyecto
            System.out.println("Test crear proyecto");
            Proyecto proyecto1 = new Proyecto("la punta", "hay que hacer un login", LocalDate.of(2023, 5, 15), 1);
            proyectoData.insertProyecto(proyecto1);

            // Verificar último agregado
            ProyectoData proyecto_ultimo = new ProyectoData();
            Proyecto ultimo = proyecto_ultimo.selectUltimoProyecto();
            System.out.println("Verificar último");
            System.out.println(ultimo.toString());

            // Modificar último agregado
            ultimo.setNombre("San Luis");
            ultimo.setDescripcion("Construir Casa 200 m2");
            proyecto_ultimo.updateProyecto(ultimo);

            // Verificar modificación
            ultimo = proyecto_ultimo.selectUltimoProyecto();
            System.out.println("Verificar Modificado");
            System.out.println(ultimo.toString());
        }

        // Test de miembro
        if (miembro_test) {
            Miembro miembraux;
            ArrayList<Miembro> miembros;
            boolean insert_miembro = true;

            // Insertar un nuevo miembro y validar si ya existe en la base de datos para evitar duplicados
            System.out.println("Test insert miembro");
            if (insert_miembro) {
                miembroPrueba.setDni(43690464);
                miembroPrueba.setApellido("Vallejos");
                miembroPrueba.setNombre("Roberta");
                miembroPrueba.setEstado(true);
                if (miembroData.verificarMiembro(miembroPrueba.getDni())) {
                    miembroData.insertMiembro(miembroPrueba);
                }
            }

            miembros = miembroData.selectMiembro();

            // Listar los miembros existentes y con estado activo
            System.out.println("Mostrando miembros existentes: ");
            for (Miembro miembro : miembros) {
                System.out.println(miembro.toString());
            }

            // Modificar el miembro insertado
            miembraux = miembros.get(1);
            miembraux.setNombre("Roberta");
            miembraux.setApellido("Vallejos");
            miembraux.setDni(43690464);
            miembroData.updateMiembro(miembraux);
        }

        // Test de equipo
        if (equipo_test) {
            boolean insert_equipo = true;
            boolean mostrar_equipo = true;

            System.out.println("Test equipo");

            // Insertar equipo
            System.out.println("Test Insert equipo");
            if (insert_equipo) {

                ProyectoData proyecto_ultimo = new ProyectoData();
                // Buscar último proyecto
                Proyecto ultimo = proyecto_ultimo.selectUltimoProyecto();
                Equipo equipo_ultimo = equipo_data.selectEquipo();
                equipo_data.insertEquipo(equipo_ultimo, ultimo);
                Equipo buscado = equipo_data.selectEquipo();
                System.out.println("Último equipo ingresado");
                System.out.println(buscado.toString());
            }

            if (mostrar_equipo) {
                equipos = equipo_data.selectEquipos(1);
                System.out.println("Listado equipos activos");
                for (Equipo equipo : equipos) {
                    System.out.println(equipo.toString());
                }
            }
        }

        // Test de equipo_miembro
        if (equipo_miembro_test) { // En proceso
            System.out.println("Test integrantes de un equipo");
            int id_equipo = 7;
            equipo_miembro_data.selectEquipoMiembro(id_equipo);
        }
/**
 * test de prueba de tareas.
 */
        if (tarea_test) {
            System.out.println("Test de tareas");
            Tarea tareaPrueba = new Tarea();
            tareaPrueba.setEstado(1);
            TareaData tareaData = new TareaData();
            ArrayList<Tarea> tareas;
            tareas = tareaData.selectTareasEstado(tareaPrueba);
            for (Tarea aux : tareas) {
                System.out.println(aux);
            }

        }
    }
}

/*
Main para pruebas por consola del TP final
Proyecto Gestion - Laboratorio 1.
 */
package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import models.Equipo;
import models.Miembro;
import models.Proyecto;
import models.Tarea;
import java.util.Scanner;

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
   /* public static void main(String[] args) {
        MiembroData miembroData = new MiembroData();
        Miembro miembroPrueba = new Miembro();
        ProyectoData proyectoData = new ProyectoData();
        EquipoMiembroData equipoMiembroData = new EquipoMiembroData();
        EquipoData equipoData = new EquipoData();
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
         System.out.println("\t\t\t *******************************************************************");
        System.out.println("\t\t\t *  LABORATORIO I                                                  *");
        System.out.println("\t\t\t *  Profesores  Luis Javier Mercado - Juan José Saez               *");
        System.out.println("\t\t\t *******************************************************************");
        System.out.println("\t\t\t *                 ~ GRUPO 15 C 1 año 2023 ~                       *");
        System.out.println("\t\t\t *******************************************************************\n\n\n");
        do {
            System.out.println("----- MENÚ PRINCIPAL -----");
            System.out.println("1. Pruebas de Miembro");
            System.out.println("2. Pruebas de Equipo");
            System.out.println("3. Pruebas de Proyecto");
            System.out.println("4. Pruebas de Equipo Miembro");
            System.out.println("5. Pruebas de Tarea");
            System.out.println("0. Salir");
            System.out.println("--------------------------");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarPruebasMiembro(miembroData, miembroPrueba);
                    break;
                case 2:
                    realizarPruebasEquipo(equipoData, proyectoData);
                    break;
                case 3:
                    realizarPruebasProyecto(proyectoData);
                    break;
                case 4:
                    
                    realizarPruebasEquipoMiembro(equipoMiembroData);
                    break;
                case 5:
                    realizarPruebasTarea();
                    break;
                
                            
                           
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    // Test de miembro
    public static void realizarPruebasMiembro(MiembroData miembroData, Miembro miembroPrueba) {
        Miembro miembraux;
        ArrayList<Miembro> miembros;
        // Insertar un nuevo miembro y validar si ya existe en la base de datos para evitar duplicados
        System.out.println("Test insert miembro");
        miembroPrueba.setDni(43690464);
        miembroPrueba.setApellido("Vallejos");
        miembroPrueba.setNombre("Roberta");
        miembroPrueba.setEstado(true);
        if (miembroData.verificarMiembro(miembroPrueba.getDni())) {
            miembroData.insertMiembro(miembroPrueba);
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

    public static void realizarPruebasEquipo(EquipoData equipoData, ProyectoData proyectoData) {
        EquipoData equipo_data = new EquipoData();
        ArrayList<Equipo> equipos;
        System.out.println("Test equipo");
        // Insertar equipo
        System.out.println("Test Insert equipo");
        ProyectoData proyecto_ultimo = new ProyectoData();
        // Buscar último proyecto
        Proyecto ultimo = proyecto_ultimo.selectUltimoProyecto();
        Equipo equipo_ultimo = equipo_data.selectEquipo();
        equipo_data.insertEquipo(equipo_ultimo, ultimo);
        Equipo buscado = equipo_data.selectEquipo();
        System.out.println("Último equipo ingresado");
        System.out.println(buscado.toString());
        equipos = equipo_data.selectEquipos(1);
        System.out.println("Listado equipos activos");
        for (Equipo equipo : equipos) {
            System.out.println(equipo.toString());
        }
    }
// Test de proyecto

    public static void realizarPruebasProyecto(ProyectoData proyectoData) {
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

    public static void realizarPruebasEquipoMiembro(EquipoMiembroData equipoMiembroData) {
        EquipoMiembroData equipoData = new EquipoMiembroData();
        

        //probando el la relacion de miembro con el equipo
          equipoData.insertEquipoMiembro(1, 16);
                  // Test de equipo_miembro
        System.out.println("Test integrantes de un equipo");
        int id_equipo = 5;
        ArrayList<Miembro> miembros = equipoData.selectEquipoMiembro(id_equipo);
        if (miembros.isEmpty()) {
            System.out.println("No se encontraron miembros para el equipo con ID " + id_equipo);
        } else {
          
            System.out.println("Miembros del equipo con ID " + id_equipo + ":");
            for (Miembro miembro : miembros) {
                System.out.println(miembro.getNombre());
            }
        }
    }

    /**
     * test de prueba de tareas.
     */
    public static void realizarPruebasTarea() {
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

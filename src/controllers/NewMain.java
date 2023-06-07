/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.Miembro;
import models.Proyecto;

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
         Miembro miembroPrueba1 = new Miembro();
         Miembro miembr=new Miembro();
         Miembro miembraux=new Miembro();
        proyectoData proyectData= new proyectoData();
        ArrayList <Miembro> miembros;
        ArrayList<Proyecto> proyectos;
       String fechaInicioString = "1989-05-22";
       java.time.LocalDate fechaInicio = java.time.LocalDate.parse(fechaInicioString);
       String fechaInicioString1 = "2000-01-15";
       java.time.LocalDate fechaInicio1 = java.time.LocalDate.parse(fechaInicioString1);
               
               
       //Proyecto proyecto1 = new Proyecto("la punta", "hay que hacer un login", fechaInicio, 1);
       //Proyecto proyecto2 = new Proyecto("universidad nacional","hay que hacer el frontend", fechaInicio1, 1);
       //proyectData.insertProyecto(proyecto1);
        //proyectData.insertProyecto(proyecto2);
        //Proyecto proyecto3 = new Proyecto("la punta", "modificado", fechaInicio, 1);
        //proyectData.updateProyecto(proyecto3);
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

miembroData.insertMiembro(miembroPrueba);
miembroData.insertMiembro(miembroPrueba1);
*/
miembros=miembroData.selectMiembro();
miembraux=miembros.get(0);
miembraux.setApellido("leotoloza");
miembroData.updateMiembro(miembraux);

for (int i=0;i<miembros.size();i++)
{
  miembr=miembros.get(i);
    System.out.println(miembr.toString());
  
}

/*
System.out.println("Miembro ID antes de la actualización: " + miembroPrueba.getIdMiembro());

miembroData.updateMiembro(miembroPrueba);

*/
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EquipoMiembroData;
import controllers.ProyectoData;
import controllers.TareaData;
import static java.awt.SystemColor.desktop;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Equipo;
import models.EquipoMiembro;
import models.Miembro;
import models.Proyecto;
import models.Tarea;



/**
 *
 * @author Ro
 */
public class ProyectoView extends javax.swing.JInternalFrame {

    private ArrayList<Proyecto> proyectos = new ArrayList();
    private ProyectoData proyectoD = new ProyectoData();
    private ArrayList<Tarea> tareas = new ArrayList();
    private Tarea tarea = new Tarea();
    private TareaData tareaD = new TareaData();
    private EquipoMiembro equipoM = new EquipoMiembro();
    private EquipoMiembroData equipoMD = new EquipoMiembroData();
    private Miembro miembro = new Miembro();
    private ArrayList<Miembro> miembros = new ArrayList();
    private Equipo equipo = new Equipo();
    
    /**
     * Creates new form ProyectoView
     */
    public ProyectoView() {
        initComponents();

        proyectos = proyectoD.selectProyecto();

        for (Proyecto proy : proyectos) {
            jComboProyecto.addItem(proy);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboEquipos = new javax.swing.JComboBox<>();
        jBuscarEquipos = new javax.swing.JButton();
        jComboProyecto = new javax.swing.JComboBox<>();
        jBuscarMiembro = new javax.swing.JButton();
        jComboMiembro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboTarea = new javax.swing.JComboBox<>();
        jBuscarTarea = new javax.swing.JButton();
        jBuscarComentario = new javax.swing.JButton();
        bAdministrarTareas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BAgregarComentario = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonMoificarP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Comentarios = new javax.swing.JTextArea();

        jComboEquipos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jBuscarEquipos.setText("Buscar Equipos");
        jBuscarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarEquiposActionPerformed(evt);
            }
        });

        jComboProyecto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProyectoActionPerformed(evt);
            }
        });

        jBuscarMiembro.setText("Buscar Miembros");
        jBuscarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarMiembroActionPerformed(evt);
            }
        });

        jComboMiembro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMiembroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu ");

        jComboTarea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTareaActionPerformed(evt);
            }
        });

        jBuscarTarea.setText("Buscar Tareas");
        jBuscarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarTareaActionPerformed(evt);
            }
        });

        jBuscarComentario.setText("Ver comentarios");
        jBuscarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarComentarioActionPerformed(evt);
            }
        });

        bAdministrarTareas.setText("Administrar Tareas");
        bAdministrarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdministrarTareasActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione un Equipo");

        jLabel3.setText("Seleccione un proyecto");

        jLabel4.setText("Seleccione un Miembro");

        jLabel5.setText("Seleccione una Tarea");

        BAgregarComentario.setText("Agregar comentarios");
        BAgregarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarComentarioActionPerformed(evt);
            }
        });

        jButton11.setText("Administrar Miembros");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Administrar Equipos");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel6.setText("Comentarios:");

        jButtonMoificarP.setText("Administracion De Proyectos");
        jButtonMoificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoificarPActionPerformed(evt);
            }
        });

        jButton1.setText("Administracion De Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Comentarios.setColumns(20);
        Comentarios.setRows(5);
        jScrollPane1.setViewportView(Comentarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBuscarEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonMoificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBuscarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jComboMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBuscarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBuscarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BAgregarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bAdministrarTareas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(38, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBuscarEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMoificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBuscarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBuscarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBuscarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bAdministrarTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAgregarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBuscarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarEquiposActionPerformed
        // TODO add your handling code here:
        jComboEquipos.removeAllItems();
        ArrayList<Equipo> equipos = new ArrayList();
        Proyecto proyecto1 = new Proyecto();
        //String nombre = (String) jComboalumno.getSelectedItem();
        proyecto1 = (Proyecto) jComboProyecto.getSelectedItem();
        // proyecto=proyectoD.selectEquipos(proyect);
        equipos = proyectoD.selectEquipos(proyecto1);
        for (Equipo Lequipo : equipos) {
            jComboEquipos.addItem(Lequipo);
        }
    }//GEN-LAST:event_jBuscarEquiposActionPerformed

    private void jBuscarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarMiembroActionPerformed
        // TODO add your handling code here:
        jComboMiembro.removeAllItems();
        ///No puede buscar miembros de un equipo si no se selecciona el equipo primero
        
        equipo = (Equipo) jComboEquipos.getSelectedItem();
        if(equipo!=null){
            miembros = equipoMD.selectEquipoMiembro(equipo.getId_equipo());
            for (Miembro miembro : miembros) {
                jComboMiembro.addItem(miembro);
            }
        }else
            JOptionPane.showMessageDialog(null,"Seleccione un equipo");
        
    }//GEN-LAST:event_jBuscarMiembroActionPerformed

    private void jComboTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTareaActionPerformed

    private void jBuscarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarComentarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBuscarComentarioActionPerformed

    private void bAdministrarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdministrarTareasActionPerformed
        // TODO add your handling code here:
          
        
     

        //////no se puede acceder a tarea si no hay miembro seleccionado:
        
        //Conseguir el Miembro para obtener el id del equipoMiembro y pasarlo al jInternalFrame de modificar Tarea
        
        miembro = (Miembro) jComboMiembro.getSelectedItem(); //obtiene el miembro seleccionado en el combo
        if(miembro!=null)
        {
              ModificarTareaView  modificarTarea = new ModificarTareaView();
              modificarTarea.setVisible(true);
              Gestion.desktop.add(modificarTarea);
              this.setVisible(false);
                       //System.out.println(miembro.toString());
           int idMiembroEquipo = equipoMD.selectIdEquipoMiembro(miembro.getIdMiembro());//busca el id del EquipoMiembro
           //Pasa el id a la ventana modificar Tarea
           modificarTarea.jidEquipoMiembro.setText(String.valueOf(idMiembroEquipo));//setea en un jLabel el id del EquipoMiembro obtenido en la ventana modifcarTarea
           //obtener una lista de las tareas
           tareas = tareaD.selectTareasMiembro(idMiembroEquipo);//Obtiene un ArrayList de Tareas segun el id MiembroEquipo obtenido
           //añadir al combo de la ventana tareaMiembro las tareas obtenidas
           for (Tarea t : tareas) {
               modificarTarea.jComboTareas.addItem(t);
           }
        }else
           JOptionPane.showMessageDialog(null,"Seleccione un miembro");
       
        
        
        
        
    }//GEN-LAST:event_bAdministrarTareasActionPerformed

    private void BAgregarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarComentarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BAgregarComentarioActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       Equipovista vista=new Equipovista();
       this.setVisible(false);
       vista.setVisible(true);
       Gestion.desktop.add(vista);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jComboProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProyectoActionPerformed

    private void jComboMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMiembroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboMiembroActionPerformed

    private void jButtonMoificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoificarPActionPerformed
         
       
       UpProyecto1 proyec=new  UpProyecto1();
        proyec.setVisible(true);
       Gestion.desktop.add(proyec);
       this.setVisible(false);
    
       proyec.setVisible(true);
       
    
             
       
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMoificarPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Enlace vista=new Enlace();
      vista.setVisible(true);
      this.setVisible(false);
       Gestion.desktop.add(vista);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jBuscarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarTareaActionPerformed
        // TODO add your handling code here:
        //       jComboMiembro.removeAllItems();
        //        ArrayList<Tarea> tareas = new ArrayList();
        //        Tarea tarea = new Tarea();
        //        TareaData tareaD = new TareaData();
        //        EquipoMiembro equipoM = new EquipoMiembro();
        //        EquipoMiembroData equipoMD = new EquipoMiembroData();
        //        Miembro miembro = new Miembro();
        int idMiembroEquipo;
        
        
        ///No puede buscar Tareas si no selecciona el miembro
        
        //conseguir el id del equipoMiembro
        miembro = (Miembro) jComboMiembro.getSelectedItem();
        if(miembro!=null)
        {
             System.out.println(miembro.toString());
            idMiembroEquipo = equipoMD.selectIdEquipoMiembro(miembro.getIdMiembro());
            //setear el id del equipo miembro
            equipoM.setId_equipo_miembro(idMiembroEquipo);

            tareas = tareaD.selectTareasMiembro(idMiembroEquipo);

            for (Tarea t : tareas) {
                jComboTarea.addItem(t);
            }
        }else 
             JOptionPane.showMessageDialog(null,"Seleccione un miembro");
       
    }//GEN-LAST:event_jBuscarTareaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAgregarComentario;
    private javax.swing.JTextArea Comentarios;
    private javax.swing.JButton bAdministrarTareas;
    private javax.swing.JButton jBuscarComentario;
    private javax.swing.JButton jBuscarEquipos;
    private javax.swing.JButton jBuscarMiembro;
    private javax.swing.JButton jBuscarTarea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButtonMoificarP;
    private javax.swing.JComboBox<Equipo> jComboEquipos;
    private javax.swing.JComboBox<Miembro> jComboMiembro;
    private javax.swing.JComboBox<Proyecto> jComboProyecto;
    private javax.swing.JComboBox<Tarea> jComboTarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

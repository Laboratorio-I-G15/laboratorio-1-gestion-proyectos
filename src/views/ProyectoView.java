/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ComentarioData;
import controllers.EquipoMiembroData;
import controllers.ProyectoData;
import controllers.TareaData;
import static java.awt.SystemColor.desktop;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Comentario;
import models.Equipo;
import models.EquipoMiembro;
import models.Miembro;
import models.Proyecto;
import models.Tarea;
import static views.Gestion.desktop;

/**
 *
 * @author Ro
 */
public class ProyectoView extends javax.swing.JInternalFrame {

    private ArrayList<Proyecto> proyectos = new ArrayList();
    private Proyecto proyecto = new Proyecto();
    private ProyectoData proyectoD = new ProyectoData();
    private ArrayList<Tarea> tareas = new ArrayList();
    private Tarea tarea = new Tarea();
    private TareaData tareaD = new TareaData();
    private EquipoMiembro equipoM = new EquipoMiembro();
    private EquipoMiembroData equipoMD = new EquipoMiembroData();
    private Miembro miembro = new Miembro();
    private ArrayList<Miembro> miembros;
    private Proyecto proyect = new Proyecto();
    private Equipo equipo = new Equipo();
    public static MiembrosViews vistaMiembro = null;
    private Comentario comentario = new Comentario();
    private ComentarioData comentarioD = new ComentarioData();
    private ArrayList<Comentario> comentarios = new ArrayList();

    /**
     * Creates new form ProyectoView
     */
    public ProyectoView() {
        initComponents();
        proyectos = proyectoD.selectProyecto();
        for (Proyecto proy : proyectos) {
            jComboProyecto.addItem(proy);
        }
        BAdministrarComentario.setEnabled(false);
        Pendiente.setEnabled(false);
        Completado.setEnabled(false);
        Progreso.setEnabled(false);
        Inactivo.setEnabled(false);
        Gestion.desktop.removeAll();
        Gestion.desktop.repaint();
        this.setVisible(true);
        Gestion.desktop.add(this);
        Gestion.desktop.moveToFront(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboEquipos = new javax.swing.JComboBox<>();
        jComboProyecto = new javax.swing.JComboBox<>();
        jComboMiembro = new javax.swing.JComboBox<>();
        jComboTarea = new javax.swing.JComboBox<>();
        bAdministrarTareas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BAdministrarComentario = new javax.swing.JButton();
        btnAdminMiembro = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButtonMoificarP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Comentarios = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        Completado = new javax.swing.JRadioButton();
        Progreso = new javax.swing.JRadioButton();
        Pendiente = new javax.swing.JRadioButton();
        Inactivo = new javax.swing.JRadioButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(854, 728));
        setMinimumSize(new java.awt.Dimension(854, 728));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(854, 729));

        jComboEquipos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEquiposActionPerformed(evt);
            }
        });

        jComboProyecto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboProyectoMouseClicked(evt);
            }
        });
        jComboProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProyectoActionPerformed(evt);
            }
        });

        jComboMiembro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMiembroActionPerformed(evt);
            }
        });

        jComboTarea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboTarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboTareaMouseClicked(evt);
            }
        });
        jComboTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTareaActionPerformed(evt);
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

        BAdministrarComentario.setText("Agregar comentarios");
        BAdministrarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAdministrarComentarioActionPerformed(evt);
            }
        });

        btnAdminMiembro.setText("Administrar Miembros");
        btnAdminMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminMiembroActionPerformed(evt);
            }
        });

        jButton12.setText("Administrar Equipos");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButtonMoificarP.setText("Administracion De Proyectos");
        jButtonMoificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoificarPActionPerformed(evt);
            }
        });

        jButton1.setText("Equipo-Miembro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Comentarios.setEditable(false);
        Comentarios.setColumns(20);
        Comentarios.setRows(5);
        jScrollPane1.setViewportView(Comentarios);

        jLabel7.setText("Filtrar tareas por estado");

        Completado.setText("Completadas");
        Completado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompletadoActionPerformed(evt);
            }
        });

        Progreso.setText("Progreso");
        Progreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgresoActionPerformed(evt);
            }
        });

        Pendiente.setText("Pendiente");
        Pendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendienteActionPerformed(evt);
            }
        });

        Inactivo.setText("Inactiva");
        Inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InactivoActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir Programa");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Menu Gestion");
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true), "Sistema de Gestion", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.BOTTOM));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(BAdministrarComentario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)
                                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboMiembro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboEquipos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboProyecto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboTarea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(69, 69, 69)
                                                .addComponent(Completado)
                                                .addGap(18, 18, 18)
                                                .addComponent(Progreso)
                                                .addGap(18, 18, 18)
                                                .addComponent(Pendiente)
                                                .addGap(18, 18, 18)
                                                .addComponent(Inactivo)))
                                        .addGap(0, 57, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bAdministrarTareas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAdminMiembro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jButtonMoificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMoificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Completado)
                    .addComponent(Progreso)
                    .addComponent(Pendiente)
                    .addComponent(Inactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAdministrarTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAdministrarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTareaActionPerformed
        // TODO add your handling code here:
         Comentarios.setText("");
        miembro = (Miembro) jComboMiembro.getSelectedItem(); //obtiene el miembro seleccionado en el combo
        if (miembro != null) {
            tarea = (Tarea) jComboTarea.getSelectedItem();
            if (tarea != null) {
                //obtener listado de comentarios
                comentario.setTarea(tarea);
                comentarios = comentarioD.selectComentarios(comentario);
                if (comentarios != null) {
                    for (Comentario c : comentarios) {
                        Comentarios.append(c.toString() + "\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay avances registrados para la tarea seleccionada");
                }
            } else {
                //        jBuscarComentario.setEnabled(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un miembro");
        }
    }//GEN-LAST:event_jComboTareaActionPerformed

    private void bAdministrarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdministrarTareasActionPerformed
        // TODO add your handling code here:

        //////no se puede acceder a tarea si no hay miembro seleccionado:
        //Conseguir el Miembro para obtener el id del equipoMiembro y pasarlo al jInternalFrame de modificar Tarea
        miembro = (Miembro) jComboMiembro.getSelectedItem(); //obtiene el miembro seleccionado en el combo
        if (miembro != null) {
            ModificarTareaView modificarTarea = new ModificarTareaView();
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
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un miembro");
        }

    }//GEN-LAST:event_bAdministrarTareasActionPerformed

    private void BAdministrarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAdministrarComentarioActionPerformed
        // TODO add your handling code here:
        ComentariosView vistaC = new ComentariosView();
        tareas = obtenerTareas();
        for (Tarea t : tareas) {
            vistaC.ComboTareas.addItem(t);
        }
        dispose();
        Gestion.desktop.removeAll();
        Gestion.desktop.repaint();
        vistaC.setVisible(true);
        Gestion.desktop.add(vistaC);
        Gestion.desktop.moveToFront(vistaC);
        this.setVisible(false);
    }//GEN-LAST:event_BAdministrarComentarioActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       equipo = (Equipo) jComboEquipos.getSelectedItem();
        proyecto = (Proyecto) jComboProyecto.getSelectedItem();
        ////////////////////////////////////NUEVO////////////////////////////////////
        if (proyecto != null) {
            Equipovista vista = new Equipovista();
            this.setVisible(false);
            vista.setVisible(true);
            if (equipo != null) {
                Gestion.desktop.add(vista);
                vista.jTexnombre.setText(equipo.getNombre());
                if (equipo.getEstado() == 1) {
                    vista.jRadioButton1.setSelected(true);
                } else {
                    vista.jRadioButton1.setSelected(false);
                }
                vista.jDateChooser1.setDate(java.sql.Date.valueOf(equipo.getCreacion()));

            }
        }else
             JOptionPane.showMessageDialog(null, "Agregue un proyecto");

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButtonMoificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoificarPActionPerformed
        AdminProyecto proyec = new AdminProyecto();
        proyec.setVisible(true);
        Gestion.desktop.add(proyec);
        dispose();
        this.setVisible(false);

    }//GEN-LAST:event_jButtonMoificarPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Enlace vista = new Enlace();
        vista.setVisible(true);
        this.setVisible(false);
        Gestion.desktop.add(vista);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdminMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminMiembroActionPerformed
        // if (vistaMiembro == null) {
        this.setVisible(false);
        vistaMiembro = new MiembrosViews();
        vistaMiembro.setVisible(true);
        Gestion.desktop.add(vistaMiembro);
        //  Miembro miembro = new Miembro();
        miembro = jComboMiembro.getItemAt(0);
        if (!vistaMiembro.txtNombreMiembro.getText().equals("")) {
            vistaMiembro.txtNombreMiembro.setText(miembro.getNombre());
            vistaMiembro.txtApellidoMiembro.setText(miembro.getApellido());
            vistaMiembro.txtDniMiembro.setText(String.valueOf(miembro.getDni()));
            vistaMiembro.radioActivar.setSelected(miembro.isEstado());
            vistaMiembro.id = miembro.getIdMiembro();
        }
        dispose();
    }//GEN-LAST:event_btnAdminMiembroActionPerformed

    public ArrayList<Tarea> obtenerTareas() {
        jComboTarea.removeAllItems();
        miembro = (Miembro) jComboMiembro.getSelectedItem();
        if (miembro != null) {  //conseguir el id del equipoMiembro
            int idMiembroEquipo = equipoMD.selectIdEquipoMiembro(miembro.getIdMiembro());
            //setear el id del equipo miembro
            equipoM.setId_equipo_miembro(idMiembroEquipo);
            tareas = tareaD.selectTareasMiembro(idMiembroEquipo);
            jComboTarea.removeAllItems();
            if (!tareas.isEmpty()) {
                return tareas;
            } else {
                return null;
            }
        } 
        return null;
    }
    private void ProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgresoActionPerformed
        // TODO add your handling code here:
        if (Progreso.isSelected()) {
            Pendiente.setSelected(false);
            Completado.setSelected(false);
            Inactivo.setSelected(false);
        }

        tareas = obtenerTareas();
        if (tareas != null) {
            for (Tarea t : tareas) {
                System.out.println("" + t.toString());
                if (t.getEstado() == 2) {
                    jComboTarea.addItem(t);
                    System.out.println("" + t.toString());
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay tareas asignadas a este miembro");
        }
    }//GEN-LAST:event_ProgresoActionPerformed

    private void PendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendienteActionPerformed
        // TODO add your handling code here:
        if (Pendiente.isSelected()) {
            Progreso.setSelected(false);
            Completado.setSelected(false);
            Inactivo.setSelected(false);
        }

        tareas = obtenerTareas();
        if (tareas != null) {
            for (Tarea t : tareas) {
                System.out.println("" + t.toString());
                if (t.getEstado() == 3) {
                    jComboTarea.addItem(t);
                    System.out.println("" + t.toString());
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay tareas asignadas a este miembro");
        }
    }//GEN-LAST:event_PendienteActionPerformed

    private void InactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactivoActionPerformed
        // TODO add your handling code here:
        if (Inactivo.isSelected()) {
            Pendiente.setSelected(false);
            Completado.setSelected(false);
            Progreso.setSelected(false);
        }

        tareas = obtenerTareas();
        if (tareas != null) {
            for (Tarea t : tareas) {
                System.out.println("" + t.toString());
                if (t.getEstado() == 4) {
                    jComboTarea.addItem(t);
                    System.out.println("" + t.toString());
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay tareas asignadas a este miembro");
        }
    }//GEN-LAST:event_InactivoActionPerformed

    private void CompletadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompletadoActionPerformed
        // TODO add your handling code here:
        if (Completado.isSelected()) {
            Pendiente.setSelected(false);
            Progreso.setSelected(false);
            Inactivo.setSelected(false);
        }

        tareas = obtenerTareas();
        if (tareas != null) {
            for (Tarea t : tareas) {
                System.out.println("" + t.toString());
                if (t.getEstado() == 1) {
                    jComboTarea.addItem(t);
                    System.out.println("" + t.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay tareas asignadas a este miembro");
        }
    }//GEN-LAST:event_CompletadoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de salir?", "Confirmación", JOptionPane.YES_NO_OPTION);

        // Verificar la opción seleccionada
        if (option == JOptionPane.YES_OPTION) {
            System.out.println("Se seleccionó 'Sí'");
            System.exit(0);
        } else if (option == JOptionPane.NO_OPTION) {
            System.out.println("Se seleccionó 'No'");
        } else if (option == JOptionPane.CANCEL_OPTION) {
            System.out.println("Se seleccionó 'Cancelar'");
        } else {
            System.out.println("Se cerró el cuadro de diálogo");
        }

    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jComboProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboProyectoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboProyectoMouseClicked

    private void jComboTareaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboTareaMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboTareaMouseClicked

    private void jComboProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProyectoActionPerformed
        // TODO add your handling code here:
       jComboEquipos.removeAllItems();
        jComboMiembro.removeAllItems();
        jComboTarea.removeAllItems();
        cargarComboTarea();
        ArrayList<Equipo> equipos = new ArrayList();
        Proyecto proyecto1 = new Proyecto();
        proyecto1 = (Proyecto) jComboProyecto.getSelectedItem();
        equipos = proyectoD.selectEquipos(proyecto1);
        for (Equipo Lequipo : equipos) {
            jComboEquipos.addItem(Lequipo);
        }
        System.out.println("linea 655");
    }//GEN-LAST:event_jComboProyectoActionPerformed

    private void jComboEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEquiposActionPerformed
        // TODO add your handling code here:

        jComboMiembro.removeAllItems();
        jComboTarea.removeAllItems();
        cargarComboTarea();
        equipo = (Equipo) jComboEquipos.getSelectedItem();
        //   System.out.println("linea 399" + equipo.toString());
        if (equipo != null) {
            miembros = equipoMD.selectEquipoMiembro(equipo.getId_equipo());
            for (Miembro miembro : miembros) {
                jComboMiembro.addItem(miembro);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un equipo");
        }
    }//GEN-LAST:event_jComboEquiposActionPerformed
 private void cargarComboTarea() {
        tareas = obtenerTareas();
        if (tareas != null) {
            Pendiente.setEnabled(true);
            Completado.setEnabled(true);
            Progreso.setEnabled(true);
            Inactivo.setEnabled(true);
            BAdministrarComentario.setEnabled(true);
          
            for (Tarea t : tareas) {
                jComboTarea.addItem(t);
            }
        } else {
            Pendiente.setEnabled(false);
            Completado.setEnabled(false);
            Progreso.setEnabled(false);
            Inactivo.setEnabled(false);
            BAdministrarComentario.setEnabled(false);
           
            miembro = (Miembro) jComboMiembro.getSelectedItem();
            if (miembro != null) {
                JOptionPane.showMessageDialog(null, "No hay tareas asignadas a este miembro");
            }
        }
    }
    private void jComboMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMiembroActionPerformed
        // TODO add your handling code here:
        Progreso.setSelected(false);
        Completado.setSelected(false);
        Inactivo.setSelected(false);
        Pendiente.setSelected(false);

        jComboTarea.removeAllItems();
 cargarComboTarea();
//        tareas = obtenerTareas();
//        if (tareas != null) {
//            Pendiente.setEnabled(true);
//            Completado.setEnabled(true);
//            Progreso.setEnabled(true);
//            Inactivo.setEnabled(true);
//            BAdministrarComentario.setEnabled(true);
//            //  jBuscarComentario.setEnabled(true);
//            for (Tarea t : tareas) {
//                jComboTarea.addItem(t);
//            }
//        } else {
//            Pendiente.setEnabled(false);
//            Completado.setEnabled(false);
//            Progreso.setEnabled(false);
//            Inactivo.setEnabled(false);
//            BAdministrarComentario.setEnabled(false);
//            //     jBuscarComentario.setEnabled(false);
//            miembro = (Miembro) jComboMiembro.getSelectedItem();
//            if (miembro != null) {
//                JOptionPane.showMessageDialog(null, "No hay tareas asignadas a este miembro");
//            }
//        }
    }//GEN-LAST:event_jComboMiembroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAdministrarComentario;
    private javax.swing.JTextArea Comentarios;
    private javax.swing.JRadioButton Completado;
    private javax.swing.JRadioButton Inactivo;
    private javax.swing.JRadioButton Pendiente;
    private javax.swing.JRadioButton Progreso;
    private javax.swing.JButton bAdministrarTareas;
    private javax.swing.JButton btnAdminMiembro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButtonMoificarP;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<Equipo> jComboEquipos;
    private javax.swing.JComboBox<Miembro> jComboMiembro;
    private javax.swing.JComboBox<Proyecto> jComboProyecto;
    private javax.swing.JComboBox<Tarea> jComboTarea;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

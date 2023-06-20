/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author leo_t
 */
public class Gestion extends javax.swing.JFrame {

    /**
     * ----------DEFINICION DE VARIABLES GLOBALES---------- Aca deberiamos definir las variables globales que va utilizar esta vista principal.
     */
    public static ProyectoView vistaProyecto = null;
    public static ProyectoView vistaProyectoso = null;
    static Object vistaMiembro;

    public Gestion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema de Gestion de Proyectos");
        vistaProyecto = new ProyectoView();

        vistaProyecto.setVisible(true);
        desktop.add(vistaProyecto);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(854, 740));
        setMinimumSize(new java.awt.Dimension(854, 740));
        setUndecorated(isEnabled());
        setPreferredSize(new java.awt.Dimension(854, 740));
        setResizable(false);

        desktop.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        desktop.setMaximumSize(new java.awt.Dimension(854, 728));
        desktop.setMinimumSize(new java.awt.Dimension(854, 728));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            //          UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                new Gestion().setVisible(true);
            });
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Libreria no soportada");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktop;
    // End of variables declaration//GEN-END:variables
}

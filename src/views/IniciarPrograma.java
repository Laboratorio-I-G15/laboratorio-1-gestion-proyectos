/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.awt.AWTUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author leo_t
 */
public class IniciarPrograma extends javax.swing.JFrame {

    Timer timer;
    ActionListener actionListener;

    /**
     * Creates new form IniciarPrograma
     */
    public IniciarPrograma() {
        actionListener = (ActionEvent ae) -> {
            if (Progreso.getValue() < 100) {
                Progreso.setValue(Progreso.getValue() + 10);
            } else {
                timer.stop();
                dispose();
                mostrarGestion();
            }
        };
        initComponents();
        this.setSize(603, 526);
        this.setLocationRelativeTo(null);
        timer = new Timer(500, actionListener);
        AWTUtilities.setWindowOpaque(this, false);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Progreso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(423, 370));
        setResizable(false);
        getContentPane().setLayout(null);

        Progreso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Progreso.setName(""); // NOI18N
        getContentPane().add(Progreso);
        Progreso.setBounds(90, 380, 460, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_proyecto/proyecto.png"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 620, 522);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new IniciarPrograma().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Progreso;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
private void mostrarGestion() {
        Gestion gestion = new Gestion();
        gestion.setVisible(true);
    }
}
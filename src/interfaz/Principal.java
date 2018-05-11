package interfaz;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import interfaz.CreaMatriz;
/**
 *
 * @author Andres
 */
public class Principal extends JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        cbXagente = new JComboBox();
        btnEjecutar = new JButton();
        btnReset = new JButton();
        tableroGUI1 = new JPanel();
        jLabel5 = new JLabel();
        cbYagente = new JComboBox();
        jLabel6 = new JLabel();
        jLabel8 = new JLabel();
        cbXninio = new JComboBox();
        jLabel9 = new JLabel();
        cbYninio = new JComboBox();
        jLabel10 = new JLabel();
        cbEstrategia = new JComboBox();

        char[][] plano = CreaMatriz.matrizDesdeArchivo("mapa-chico2.txt");
        TableroGUI tableroGUI1 = new TableroGUI(true, plano);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        Si se usa un Layout (es decir, se descomenta esto), muestra mejor las celdas, pero girado. Falta resolver eso
//        GroupLayout tableroGUI1Layout = new GroupLayout(tableroGUI1);
//        tableroGUI1.setLayout(tableroGUI1Layout);

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setBorder(BorderFactory.createTitledBorder(null, "Posici�n Agente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 13))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("X:");

        cbXagente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbXagente.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbXagente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbXagenteActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");

        btnReset.setText("Reset");

        tableroGUI1.setBorder(BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Y:");

        cbYagente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbYagente.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbYagente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbYagenteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel6.setBorder(BorderFactory.createTitledBorder(null, "Posici�n Ni�o", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 13))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setText("X:");

        cbXninio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbXninio.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbXninio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbXninioActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setText("Y:");

        cbYninio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbYninio.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbYninio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbYninioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel10.setBorder(BorderFactory.createTitledBorder(null, "Estrategia de B�squeda", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 13))); // NOI18N

        cbEstrategia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbEstrategia.setModel(new DefaultComboBoxModel(new String[] { "Amplitud", "Profunidad", "Costo Uniforme", "A *" }));
        cbEstrategia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstrategiaActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cbXagente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(cbYagente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cbXninio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(cbYninio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cbEstrategia, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnEjecutar)))
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(tableroGUI1, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbXagente, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbYagente, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbXninio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbYninio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cbEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset)
                    .addComponent(btnEjecutar)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tableroGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void cbXagenteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void cbYagenteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void cbXninioActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void cbYninioActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void cbEstrategiaActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton btnEjecutar;
    private JButton btnReset;
    private JComboBox cbEstrategia;
    private JComboBox cbXagente;
    private JComboBox cbXninio;
    private JComboBox cbYagente;
    private JComboBox cbYninio;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel tableroGUI1;
    private JSeparator jSeparator1;
    // End of variables declaration                   
}

package interfaz;

import model.Celda;
import interfaz.CreaMatriz;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;

public class Main extends JFrame {
    
    public Main() {
        initComponents();
    }
                          
    private void initComponents() {

		char[][] plano = CreaMatriz.matrizDesdeArchivo("mapa-chico2.txt");
//    	CreaMatriz.imprimirMatriz(plano);
    	
        tableroGUI1 = new TableroGUI(true, plano);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GroupLayout tableroGUI1Layout = new GroupLayout(tableroGUI1);
        tableroGUI1.setLayout(tableroGUI1Layout);
        tableroGUI1Layout.setHorizontalGroup(
            tableroGUI1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        tableroGUI1Layout.setVerticalGroup(
            tableroGUI1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableroGUI1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableroGUI1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        pack();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
                        
    private TableroGUI tableroGUI1;                
    
}
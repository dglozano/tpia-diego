package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CasillasGUI extends javax.swing.JPanel implements MouseListener {
    
    private TableroGUI tablero;
    private PrincipalNueva pantallaPrincipal;
    private ImageIcon fondo;
    private boolean accesible;
    
//    public CasillasGUI() {      
//    }
    
    public CasillasGUI(TableroGUI t, PrincipalNueva principalNueva) {
        initComponents();        
        this.tablero = t;
        this.pantallaPrincipal = principalNueva;
        this.addMouseListener(this);
    }
    
    public void setFondo(ImageIcon fondo){
        this.fondo = fondo;
    }
    
    public ImageIcon getFondo(){        
        return this.fondo;
    }
    
                          
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
    }                       
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0,0,this.getWidth(),this.getHeight(),this);
    }
    
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

	public void mousePressed(MouseEvent e) {
		if (this.getAccesible()) {
			pantallaPrincipal.setearPosicion(tablero.getCoordenadas((CasillasGUI) e.getComponent()));
		} else {
			pantallaPrincipal.mensajeCasillaInaccesible(tablero.getCoordenadas((CasillasGUI) e.getComponent()));
		}
	}
    public void mouseReleased(MouseEvent e){}
    
    public boolean getAccesible() {
        return accesible;
    }
    public void setAccesible(boolean bool) {
        accesible = bool;
    }                     
    
}
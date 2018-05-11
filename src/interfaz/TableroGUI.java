package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Celda;
import model.TipoSuelo;
import utils.Matriz;

public class TableroGUI extends javax.swing.JPanel {
    private static ImageIcon comun, pared, obstaculo, pasto, puerta_abierta, puerta_cerrada, alfombra, agua, arena, basura, ropa, escalera_n, escalera_s, escalera_e, escalera_o, agente, ninio;
//	private ImageIcon agua, tocado;
    private boolean tipoTablero;
    private CasillasGUI [][] casillas ;
    
//    public TableroGUI() {
//        initComponents(cantFilas, cantCol);
//    }
    public TableroGUI(boolean tipo, char [][] plano) {
        int cantFilas = plano.length;
        int cantCol = plano[0].length;
    	
        initComponents(cantFilas, cantCol);
        int x,y;
        setLayout(new java.awt.GridLayout(cantFilas, cantCol));
        this.tipoTablero = false;//tipo;
        cargarImagenes();
        casillas = new CasillasGUI[cantFilas][cantCol];
        for (int i = 0; i < cantFilas; i++){
            for (int j = 0; j < cantCol; j++){
                casillas[i][j] = new CasillasGUI(this);
                casillas[i][j].setFondo(seleccionarFondo(plano[i][j]));                
                x = (i * 35)+1;
                y = (j * 35)+1;
                casillas[i][j].setBounds(x, y, 34, 34);
                this.add(casillas[i][j]);
            }
        }
    }
    
    private static ImageIcon seleccionarFondo (char caracter){

		ImageIcon imagen = null;
		
		switch (caracter) {
		case '_':
			imagen=comun;
			break;
		case '#':
			imagen=pared;
			break;
		case '$':
			imagen=obstaculo;
			break;
		case '~':
			imagen=pasto;
			break;
		case 'a':
			imagen=puerta_abierta;
			break;
		case 'c':
			imagen=puerta_cerrada;
			break;
		case '\'':
			imagen=alfombra;
			break;
		case '!':
			imagen=agua;
			break;
		case '%':
			imagen=arena;
			break;
		case '*':
			imagen=basura;
			break;
		case '&':
			imagen=ropa;
			break;
		case 'N':
			imagen=escalera_n;
			break;
		case 'S':
			imagen=escalera_s;
			break;
		case 'E':
			imagen=escalera_e;
			break;
		case 'O':
			imagen=escalera_o;
			break;
		case 'A':
			imagen=agente;
			break;
		case 'B':
			imagen=ninio;
			break;

		default:
			break;
		}

		return imagen;
	}
    
    public boolean getTipoTablero(){
        return this.isTipoTablero();
    }
    
//    public void pintar(int x, int y){
//        this.casillas[x][y].setFondo(tocado);
//        this.repaint();
//    }
    
    private void cargarImagenes() {
      this.comun = this.cargarFondo("comun.gif");
      this.pared = this.cargarFondo("pared.gif");
      this.obstaculo = this.cargarFondo("obstaculo.gif");
      this.pasto = this.cargarFondo("pasto.gif");
      this.puerta_abierta = this.cargarFondo("puerta_abierta.gif");
      this.puerta_cerrada = this.cargarFondo("puerta_cerrada.gif");
      this.alfombra = this.cargarFondo("alfombra.gif");
      this.agua = this.cargarFondo("agua.gif");
      this.arena = this.cargarFondo("arena.gif");
      this.basura = this.cargarFondo("basura.gif");
      this.ropa = this.cargarFondo("ropa.gif");
      this.escalera_n = this.cargarFondo("escalera_n.gif");
      this.escalera_s = this.cargarFondo("escalera_s.gif");
      this.escalera_e = this.cargarFondo("escalera_e.gif");
      this.escalera_o = this.cargarFondo("escalera_o.gif");
      this.agente = this.cargarFondo("agente.gif");
      this.ninio = this.cargarFondo("ninio.gif");
    }

    protected static ImageIcon cargarFondo(String ruta) {
        java.net.URL localizacion = TableroGUI.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.err.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }
    
    public int[] getCoordenadas(CasillasGUI casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < this.casillas.length; i++) {
            for (int j=0; j < this.casillas.length; j++) {
                if (this.casillas[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
    
    public CasillasGUI[][] getCasillas() {
        return casillas;
    }
    
    public void setCasillas(CasillasGUI[][] casillas) {
        this.casillas = casillas;
    }
    
    public boolean isTipoTablero() {
        return tipoTablero;
    }    
    public void setTipoTablero(boolean tipoTablero) {
        this.tipoTablero = tipoTablero;
    }
                              
    private void initComponents(int cantFilas, int cantCol) {
        setLayout(null);
        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(cantFilas*35, cantCol*35)); //(351, 351)); //35 cada una
    }                      
                     
}
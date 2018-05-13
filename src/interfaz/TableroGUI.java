package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Celda;
import model.TipoSuelo;
import utils.Matriz;

public class TableroGUI extends javax.swing.JPanel {
    private static ImageIcon comun, pared, obstaculo, pasto, puerta_abierta, puerta_cerrada, alfombra, agua, arena, basura, ropa, escalera_n, escalera_s, escalera_e, escalera_o, agente, ninio, oculto;
    private CasillasGUI [][] casillas ;
    private int anchoCasilla;
    private char [] pisosAccesibles = {'_', '~','a', '\'', '!', '%', '*', '&', 'N', 'S', 'E', 'O', 'A', 'B'};
    
//    public TableroGUI() {
//        initComponents(cantFilas, cantCol);
//    }
    public TableroGUI(char [][] plano, PrincipalNueva principalNueva, int anchoPanel, int altoPanel) {
        int cantFilas = plano.length;
        int cantCol = plano[0].length;
        anchoCasilla = Math.min(anchoPanel/cantCol, altoPanel/cantFilas);
    	
        initComponents(cantFilas, cantCol);
        setLayout(new GridLayout(cantFilas, cantCol));
        cargarImagenes();
        generarCasillas(cantFilas, cantCol, plano, principalNueva);
    }
    
    private void generarCasillas(int cantFilas, int cantCol, char[][] plano, PrincipalNueva principalNueva){
        int x,y;
    	casillas = new CasillasGUI[cantFilas][cantCol];
        for (int i = 0; i < cantFilas; i++){
            for (int j = 0; j < cantCol; j++){
                casillas[i][j] = new CasillasGUI(this, principalNueva);
                casillas[i][j].setFondo(seleccionarFondo(plano[i][j]));
                casillas[i][j].setAccesible(esAccesible(plano[i][j]));
                y = (i * (anchoCasilla+1))+1;
                x = (j * (anchoCasilla+1))+1;
                casillas[i][j].setBounds(x, y, anchoCasilla, anchoCasilla);
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
		case 'X':
			imagen=oculto;
			break;

		default:
			break;
		}

		return imagen;
	}
	
    private boolean esAccesible(char c) {
    	for (int i = 0; i < pisosAccesibles.length; i++) {
			if (c == pisosAccesibles[i]){
				return true;
			}
		}
    	return false;
    }
    
    
    public void pintar(int x, int y, int i){
    	ImageIcon fondo = null;
    	if (i==1){
    		fondo=agente;
    	} else if (i==2){
    		fondo=ninio;
    	}
        this.casillas[x][y].setFondo(fondo);
        this.repaint();
    }
    
    public ImageIcon obtenerFondo(int x, int y){

    	return casillas[x][y].getFondo();
    }
    
    public void setearFondo(int x, int y, ImageIcon fondoBackUp){

    	casillas[x][y].setFondo(fondoBackUp);
    }   
    
    public void setearAccesible(int x, int y, Boolean bool){

    	casillas[x][y].setAccesible(bool);
    }
    
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
      this.oculto = this.cargarFondo("oculto.gif");
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
        for (int y=0; y < this.casillas.length; y++) {
            for (int x=0; x < this.casillas[0].length; x++) {
                if (this.casillas[y][x] == casilla) {
                    coordenadas[0] = x;
                    coordenadas[1] = y;
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
                              
    private void initComponents(int cantFilas, int cantCol) {
        setLayout(null);
        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(cantCol*(anchoCasilla+1), cantFilas*(anchoCasilla+1))); //(351, 351)); //35 cada una
    }                      
                     
}
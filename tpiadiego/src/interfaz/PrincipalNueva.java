/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileReader;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Casa;
import model.Celda;
import frsf.cidisi.exercise.modelocartoy.search.AmbienteCarToy;
import frsf.cidisi.exercise.modelocartoy.search.CarToy;
import frsf.cidisi.exercise.modelocartoy.search.CarToyMain;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

/**
 *
 * @author Andres
 */
public class PrincipalNueva extends javax.swing.JFrame {
	
	private TableroGUI tablero;
	public char[][] plano;
	public int posXagente = -1;
	public int posYagente = -1;
	public int posXninio = -1;
	public int posYninio = -1;
	public int posXevento1 = -1;
	public int posYevento1 = -1;
	public int posXevento2 = -1;
	public int posYevento2 = -1;
	public int posXevento3 = -1;
	public int posYevento3 = -1;
	private int exPosXagente = -1;
	private int exPosYagente = -1;
	private int exPosXninio = -1;
	private int exPosYninio = -1;
	private int exPosXevento1 = -1;
	private int exPosYevento1 = -1;
	private int exPosXevento2 = -1;
	private int exPosYevento2 = -1;
	private int exPosXevento3 = -1;
	private int exPosYevento3 = -1;
	private ImageIcon fondoBackUpAgente;
	private ImageIcon fondoBackUpNinio;
	private ImageIcon fondoBackUpEvento1;
	private ImageIcon fondoBackUpEvento2;
	private ImageIcon fondoBackUpEvento3;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu opciones = new JMenu();
    private JMenuItem itemCargarTab = new JMenuItem();
    private JMenuItem itemSalir = new JMenuItem();
    JFileChooser f = new JFileChooser(); 
        
    private static PrincipalNueva instancia;
    
	public static void setInstancia(PrincipalNueva instancia) {
		PrincipalNueva.instancia = instancia;
	}

	private PrincipalNueva() {
        initComponents();
        this.addWindowListener(new EscuchaVentana());
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public static PrincipalNueva getInstancia() {
    	if(instancia == null) {
    		instancia = new PrincipalNueva();
    	}
    	return instancia;
    }
    
    public int getEstrategia() {
    	return this.cbEstrategia.getSelectedIndex();
    }
    
    public void actualizarTablero(char[][] nuevoPlano){
    	jPanelMapa.removeAll();
    	int anchoPanel = jPanelMapa.getWidth();
    	int altoPanel =jPanelMapa.getHeight();
    	TableroGUI tableroGUI = new TableroGUI(nuevoPlano, this, anchoPanel, altoPanel-40);
        tablero = tableroGUI;
        GroupLayout tableroGUI1Layout = new GroupLayout(tableroGUI);
        tableroGUI.setLayout(tableroGUI1Layout);
        jPanelMapa.add(tablero);
        jPanelMapa.updateUI();
    }
    
    private void crearTablero(){
    	jPanelMapa.removeAll();
    	int anchoPanel = jPanelMapa.getWidth();
    	int altoPanel =jPanelMapa.getHeight();
    	TableroGUI tableroGUI = new TableroGUI(plano, this, anchoPanel, altoPanel-40);
        tablero = tableroGUI;
        GroupLayout tableroGUI1Layout = new GroupLayout(tableroGUI);
        tableroGUI.setLayout(tableroGUI1Layout);
        jPanelMapa.add(tablero);
        jPanelMapa.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        btnEjecutar = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanelMapa = new javax.swing.JPanel();
        jPanelPosiciones = new javax.swing.JPanel();
        jRbAgente = new javax.swing.JRadioButton();
        jRbNinio = new javax.swing.JRadioButton();
        jLabelPosAgente = new javax.swing.JLabel();
        jLabelPosNinio = new javax.swing.JLabel();
        jPanelEstrategia = new javax.swing.JPanel();
        cbEstrategia = new javax.swing.JComboBox();
        jPanelEventos = new javax.swing.JPanel();
        rbEvento1 = new javax.swing.JRadioButton();
        labelEvento1 = new javax.swing.JLabel();
        btnLimpiar1 = new javax.swing.JButton();
        rbEvento2 = new javax.swing.JRadioButton();
        labelEvento2 = new javax.swing.JLabel();
        btnLimpiar2 = new javax.swing.JButton();
        rbEvento3 = new javax.swing.JRadioButton();
        labelEvento3 = new javax.swing.JLabel();
        btnLimpiar3 = new javax.swing.JButton();

        f.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        
        this.setJMenuBar(menuBar);
        this.setTitle("Principal");

        opciones.setText("Opciones");
        itemCargarTab.setText("Cargar Tablero");
        itemCargarTab.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	itemCargarTab_actionPerformed(e);
                    }
                });

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                    	itemSalir_ActionPerformed(ae);
                    }
                });
        opciones.add(itemCargarTab);
        opciones.add(itemSalir);
        menuBar.add(opciones);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jPanelMapa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelPosiciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Posiciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12))); // NOI18N

        buttonGroup1.add(jRbAgente);
        jRbAgente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jRbAgente.setText("Agente");
        jRbAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbAgenteActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRbNinio);
        jRbNinio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jRbNinio.setText("Niño   ");
        jRbNinio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbNinioActionPerformed(evt);
            }
        });

        jLabelPosAgente.setText("(-- ; --)");

        jLabelPosNinio.setText("(-- ; --)");

        javax.swing.GroupLayout jPanelPosicionesLayout = new javax.swing.GroupLayout(jPanelPosiciones);
        jPanelPosiciones.setLayout(jPanelPosicionesLayout);
        jPanelPosicionesLayout.setHorizontalGroup(
            jPanelPosicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPosicionesLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelPosicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPosicionesLayout.createSequentialGroup()
                        .addComponent(jRbNinio)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelPosNinio))
                    .addGroup(jPanelPosicionesLayout.createSequentialGroup()
                        .addComponent(jRbAgente)
                        .addGap(27, 27, 27)
                        .addComponent(jLabelPosAgente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPosicionesLayout.setVerticalGroup(
            jPanelPosicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPosicionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPosicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRbAgente)
                    .addComponent(jLabelPosAgente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPosicionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRbNinio)
                    .addComponent(jLabelPosNinio))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelEstrategia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Estrategia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12))); // NOI18N

        cbEstrategia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbEstrategia.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
        		"Estrategia de Búsqueda", "Amplitud", "Profunidad", "Costo Uniforme", "A *" }));
        cbEstrategia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbEstrategia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estrategia de Búsqueda", "Amplitud", "Profunidad", "Costo Uniforme", "A *" }));
        cbEstrategia.setToolTipText("");
        cbEstrategia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbEstrategia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstrategiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEstrategiaLayout = new javax.swing.GroupLayout(jPanelEstrategia);
        jPanelEstrategia.setLayout(jPanelEstrategiaLayout);
        jPanelEstrategiaLayout.setHorizontalGroup(
            jPanelEstrategiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstrategiaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(cbEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEstrategiaLayout.setVerticalGroup(
            jPanelEstrategiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstrategiaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cbEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        cbEstrategia.getAccessibleContext().setAccessibleName("");

        jPanelEventos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eventos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12))); // NOI18N

        buttonGroup1.add(rbEvento1);
        rbEvento1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbEvento1.setText("Evento 1");
        rbEvento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEvento1ActionPerformed(evt);
            }
        });

        labelEvento1.setText("Sin Definir  ");

        btnLimpiar1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnLimpiar1.setForeground(java.awt.Color.red);
        btnLimpiar1.setText("X");
        btnLimpiar1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbEvento2);
        rbEvento2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbEvento2.setText("Evento 2");
        rbEvento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEvento2ActionPerformed(evt);
            }
        });

        labelEvento2.setText("Sin Definir  ");

        btnLimpiar2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnLimpiar2.setForeground(java.awt.Color.red);
        btnLimpiar2.setText("X");
        btnLimpiar2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbEvento3);
        rbEvento3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rbEvento3.setText("Evento 3");
        rbEvento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEvento3ActionPerformed(evt);
            }
        });

        labelEvento3.setText("Sin Definir  ");

        btnLimpiar3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        btnLimpiar3.setForeground(java.awt.Color.red);
        btnLimpiar3.setText("X");
        btnLimpiar3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEventosLayout = new javax.swing.GroupLayout(jPanelEventos);
        jPanelEventos.setLayout(jPanelEventosLayout);
        jPanelEventosLayout.setHorizontalGroup(
            jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEventosLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEventosLayout.createSequentialGroup()
                        .addComponent(rbEvento1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEvento1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEventosLayout.createSequentialGroup()
                        .addComponent(rbEvento3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEvento3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEventosLayout.createSequentialGroup()
                        .addComponent(rbEvento2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEvento2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelEventosLayout.setVerticalGroup(
            jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEventosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEvento1)
                    .addComponent(labelEvento1)
                    .addComponent(btnLimpiar1))
                .addGap(18, 18, 18)
                .addGroup(jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEvento2)
                    .addComponent(labelEvento2)
                    .addComponent(btnLimpiar2))
                .addGap(18, 18, 18)
                .addGroup(jPanelEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEvento3)
                    .addComponent(labelEvento3)
                    .addComponent(btnLimpiar3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelEstrategia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelEventos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelPosiciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnEjecutar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelPosiciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jPanelEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanelEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset)
                            .addComponent(btnEjecutar))
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>       

    private void cbEstrategiaActionPerformed(java.awt.event.ActionEvent evt) {
        
    }                                            

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {
    	if (jLabelPosAgente.getText()=="Inaccesible" || jLabelPosAgente.getText()=="(-- ; --)" || jLabelPosNinio.getText()=="Inaccesible" || jLabelPosNinio.getText()=="(-- ; --)"){
    		JOptionPane.showMessageDialog(null, "Seleccione posiciones validas para el juguete y el niño.", "Error", JOptionPane.WARNING_MESSAGE);
    	} else if (cbEstrategia.getSelectedIndex()==0){
    		JOptionPane.showMessageDialog(null, "Seleccione una estrategia de búsqueda.", "Error", JOptionPane.WARNING_MESSAGE);
    	} else{
    		 // Runs outside of the Swing UI thread
    	    new Thread(new Runnable() {
    	      public void run() {
    	    		CarToy agent = new CarToy();
    	            AmbienteCarToy environment = new AmbienteCarToy();
    	            SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
    	            simulator.start();	
    	        }
    	      }).start();
    	}
    }                                           

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
    	jPanelMapa.removeAll();
    	jPanelMapa.updateUI();
    	buttonGroup1.clearSelection();
    	cbEstrategia.setSelectedIndex(0);
        jLabelPosAgente.setText("(-- ; --)");
        jLabelPosNinio.setText("(-- ; --)");
        labelEvento1.setText("Sin Definir  ");
        labelEvento2.setText("Sin Definir  ");
        labelEvento3.setText("Sin Definir  ");
    	exPosXagente = -1;
    	exPosYagente = -1;
    	exPosXninio = -1;
    	exPosYninio = -1;
    	exPosXevento1 = -1;
    	exPosYevento1 = -1;
    	exPosXevento2 = -1;
    	exPosYevento2 = -1;
    	exPosXevento3 = -1;
    	exPosYevento3 = -1;
    }                                        

    private void jRbNinioActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        

    private void jRbAgenteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    }                                         

    private void rbEvento1ActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }                                         

    private void rbEvento2ActionPerformed(java.awt.event.ActionEvent evt) {                                          

    }                                         

    private void rbEvento3ActionPerformed(java.awt.event.ActionEvent evt) {     

    }                                         

	private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {
		if ((exPosXevento1 != -1) && (exPosYevento1 != -1)) {
			tablero.setearFondo(posYevento1, posXevento1, fondoBackUpEvento1);
			tablero.setearAccesible(posYevento1, posXevento1, true);
			tablero.actualizaCelda(posYevento1, posXevento1);
		}
		labelEvento1.setText("Sin Definir  ");
		labelEvento1.setForeground(Color.black);
		posXevento1 = -1;
		posYevento1 = -1;
		exPosXevento1 = -1;
		exPosYevento1 = -1;
	}                                     

	private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {
		if ((exPosXevento2 != -1) && (exPosYevento2 != -1)) {
			tablero.setearFondo(posYevento2, posXevento2, fondoBackUpEvento2);
			tablero.setearAccesible(posYevento2, posXevento2, true);
			tablero.actualizaCelda(posYevento2, posXevento2);
		}
		labelEvento2.setText("Sin Definir  ");
		labelEvento2.setForeground(Color.black);
		posXevento2 = -1;
		posYevento2 = -1;
		exPosXevento2 = -1;
		exPosYevento2 = -1;
    }                                           

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {
		if ((exPosXevento3 != -1) && (exPosYevento3 != -1)) {
			tablero.setearFondo(posYevento3, posXevento3, fondoBackUpEvento3);
			tablero.setearAccesible(posYevento3, posXevento3, true);
			tablero.actualizaCelda(posYevento3, posXevento3);
		}
		labelEvento3.setText("Sin Definir  ");
		labelEvento3.setForeground(Color.black);
		posXevento3 = -1;
		posYevento3 = -1;
		exPosXevento3 = -1;
		exPosYevento3 = -1;
    }  
    
    public void setearPosicion(int [] coordenadas){
    	if (jRbAgente.isSelected()){
    		posXagente=coordenadas[0];
    		posYagente=coordenadas[1];
    		if ((exPosXagente  != -1) && (exPosYagente != -1)){
        		tablero.setearFondo(exPosYagente, exPosXagente, fondoBackUpAgente);
        		tablero.setearAccesible(exPosYagente, exPosXagente, true);
    		}
    		fondoBackUpAgente = tablero.obtenerFondo(posYagente, posXagente);
    		exPosXagente=posXagente;
    		exPosYagente=posYagente;
    		jLabelPosAgente.setText("("+(posXagente+1)+";"+(posYagente+1)+")");
			jLabelPosAgente.setForeground(Color.black);
    		tablero.pintar(posYagente, posXagente, 1);
    		tablero.setearAccesible(posYagente, posXagente, false);
    	} else if (jRbNinio.isSelected()){
    		posXninio=coordenadas[0];
    		posYninio=coordenadas[1];
    		if ((exPosXninio  != -1) && (exPosYninio != -1)){
        		tablero.setearFondo(exPosYninio, exPosXninio, fondoBackUpNinio);
        		tablero.setearAccesible(exPosYninio, exPosXninio, true);
    		}
    		fondoBackUpNinio = tablero.obtenerFondo(posYninio, posXninio);
    		exPosXninio=posXninio;
    		exPosYninio=posYninio;
    		jLabelPosNinio.setText("("+(posXninio+1)+";"+(posYninio+1)+")");
			jLabelPosNinio.setForeground(Color.black);
    		tablero.pintar(posYninio, posXninio, 2);
    		tablero.setearAccesible(posYninio, posXninio, false);
    	} else if (rbEvento1.isSelected()){
    		posXevento1=coordenadas[0];
    		posYevento1=coordenadas[1];
    		if ((exPosXevento1  != -1) && (exPosYevento1 != -1)){
        		tablero.setearFondo(exPosYevento1, exPosXevento1, fondoBackUpEvento1);
        		tablero.setearAccesible(exPosYevento1, exPosXevento1, true);
    		}
    		fondoBackUpEvento1 = tablero.obtenerFondo(posYevento1, posXevento1);
    		exPosXevento1=posXevento1;
    		exPosYevento1=posYevento1;
    		labelEvento1.setText("    ("+(posXevento1+1)+";"+(posYevento1+1)+")    ");
    		labelEvento1.setForeground(Color.black);
    		tablero.pintar(posYevento1, posXevento1, 3);
    		tablero.setearAccesible(posYevento1, posXevento1, false);
    	} else if (rbEvento2.isSelected()){
    		posXevento2=coordenadas[0];
    		posYevento2=coordenadas[1];
    		if ((exPosXevento2  != -1) && (exPosYevento2 != -1)){
        		tablero.setearFondo(exPosYevento2, exPosXevento2, fondoBackUpEvento2);
        		tablero.setearAccesible(exPosYevento2, exPosXevento2, true);
    		}
    		fondoBackUpEvento2 = tablero.obtenerFondo(posYevento2, posXevento2);
    		exPosXevento2=posXevento2;
    		exPosYevento2=posYevento2;
    		labelEvento2.setText("    ("+(posXevento2+1)+";"+(posYevento2+1)+")    ");
    		labelEvento2.setForeground(Color.black);
    		tablero.pintar(posYevento2, posXevento2, 4);
    		tablero.setearAccesible(posYevento2, posXevento2, false);
    	} else if (rbEvento3.isSelected()){
    		posXevento3=coordenadas[0];
    		posYevento3=coordenadas[1];
    		if ((exPosXevento3  != -1) && (exPosYevento3 != -1)){
        		tablero.setearFondo(exPosYevento3, exPosXevento3, fondoBackUpEvento3);
        		tablero.setearAccesible(exPosYevento3, exPosXevento3, true);
    		}
    		fondoBackUpEvento3 = tablero.obtenerFondo(posYevento3, posXevento3);
    		exPosXevento3=posXevento3;
    		exPosYevento3=posYevento3;
    		labelEvento3.setText("    ("+(posXevento3+1)+";"+(posYevento3+1)+")    ");
    		labelEvento3.setForeground(Color.black);
    		tablero.pintar(posYevento3, posXevento3, 5);
    		tablero.setearAccesible(posYevento3, posXevento3, false);
    	}
    	
    }

	public void mensajeCasillaInaccesible(int[] coordenadas) {
		if (jRbAgente.isSelected()) {
			if (!(posXagente == coordenadas[0] && posYagente == coordenadas[1])) {
				jLabelPosAgente.setText("Inaccesible");
				jLabelPosAgente.setForeground(Color.red);
			}
		} else if (jRbNinio.isSelected()) {
			if (!(posXninio == coordenadas[0] && posYninio == coordenadas[1])) {
				jLabelPosNinio.setText("Inaccesible");
				jLabelPosNinio.setForeground(Color.red);
			}
		} else if (rbEvento1.isSelected()) {
			if (!(posXevento1 == coordenadas[0] && posYevento1 == coordenadas[1])) {
				labelEvento1.setText("Inaccesible");
				labelEvento1.setForeground(Color.red);
			}
		} else if (rbEvento2.isSelected()) {
			if (!(posXevento2 == coordenadas[0] && posYevento2 == coordenadas[1])) {
				labelEvento2.setText("Inaccesible");
				labelEvento2.setForeground(Color.red);
			}
		} else if (rbEvento3.isSelected()) {
			if (!(posXevento3 == coordenadas[0] && posYevento3 == coordenadas[1])) {
				labelEvento3.setText("Inaccesible");
				labelEvento3.setForeground(Color.red);
			}
		}
	}

    private void itemCargarTab_actionPerformed(ActionEvent e) {
        if (f.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (f.getSelectedFile().exists() == true) {
            	
                try {
                	plano = CreaMatriz.matrizDesdeArchivo(f.getSelectedFile());
                	crearTablero();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Archivo no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }        
    }
    
    public void exito(){
    	JOptionPane.showMessageDialog(null, "El agente alcanzó la meta!", "Éxito", JOptionPane.NO_OPTION);
    }
    
    void itemSalir_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
    class EscuchaVentana implements WindowListener{
        public void windowActivated(WindowEvent e){
        }
 
        public void windowClosed(WindowEvent e){
        }
 
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
 
        public void windowDeactivated(WindowEvent e){
        }
 
        public void windowDeiconified(WindowEvent e){
        }
 
        public void windowIconified(WindowEvent e){
        }
 
        public void windowOpened(WindowEvent e){
        }
 
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrincipalNueva.getInstancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbEstrategia;
    private javax.swing.JLabel jLabelPosAgente;
    private javax.swing.JLabel jLabelPosNinio;
    private javax.swing.JPanel jPanelEstrategia;
    private javax.swing.JPanel jPanelMapa;
    private javax.swing.JPanel jPanelPosiciones;
    private javax.swing.JPanel jPanelEventos;
    private javax.swing.JRadioButton jRbAgente;
    private javax.swing.JRadioButton jRbNinio;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelEvento1;
    private javax.swing.JLabel labelEvento2;
    private javax.swing.JLabel labelEvento3;
    private javax.swing.JRadioButton rbEvento1;
    private javax.swing.JRadioButton rbEvento2;
    private javax.swing.JRadioButton rbEvento3;
    // End of variables declaration                   
}
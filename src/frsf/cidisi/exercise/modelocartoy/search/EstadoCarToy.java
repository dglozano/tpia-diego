package frsf.cidisi.exercise.modelocartoy.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;

import model.Celda;
import model.Casa;
import model.TipoSuelo;
import utils.Matriz;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import interfaz.PrincipalNueva;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoCarToy extends SearchBasedAgentState {
	
    private Casa casa;
    
    private Celda posicionCarToy;
	private Celda posicionBoy;
	
	//Primero va a la llamada. Si no lo encuentra antes y no esta alli, sigue yendo
	//a la posicion de cada evento. Si no lo encontro en ninguno de ellos, falla.
	private List<Celda> eventosCercanos;
    
    private double costo;
	
    public EstadoCarToy() {
    
        this.casa = new Casa(Matriz.crearMatrizDesdeArchivo("mapa-chico-sin-descubrir.txt"));
        this.eventosCercanos = new ArrayList<Celda>();
        this.initState();
    }
    
    /**
     * This method is optional, and sets the initial state of the agent.
     */
    /* (non-Javadoc)
     * @see frsf.cidisi.faia.state.State#initState()
     */
    @Override
    public void initState() {
    	int x_boy = 13, y_boy = 1;
    	int x_agente = 14, y_agente = 9;
    	this.posicionBoy = null;
    	this.posicionCarToy = this.casa.getCelda(x_agente,y_agente);
    	this.casa.getPlano()[x_agente][y_agente].setDescubierta(true);
    	this.casa.getPlano()[x_agente][y_agente].incrementarVisitas();
    	
    	//El primer evento es el de la llamada, porque debe ir primero ahi
    	this.eventosCercanos.add(this.casa.getCelda(1, 1).clone());
    	this.eventosCercanos.add(this.casa.getCelda(13, 1).clone());
    	
        this.costo = 0.0;
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	EstadoCarToy estadoClone = new EstadoCarToy();
    	
        estadoClone.setCasa(this.casa.clone());
        estadoClone.setPosicionCarToy(this.posicionCarToy.clone());
 
    	if(this.posicionBoy !=null)
    		estadoClone.setPosicionBoy(this.posicionBoy.clone());
    	
    	List<Celda> eventosClone = new ArrayList<Celda>();
    	for(Celda evento: this.eventosCercanos) {
    		eventosClone.add(evento.clone());
    	}
    	estadoClone.setEventosCercanos(eventosClone);
        	
    	estadoClone.costo = this.costo;
    	
        return estadoClone;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
    	CarToyPerception carToyPerception = (CarToyPerception) p;
    	for(Celda celdaVecinaPercibida: carToyPerception.getCeldasVecinas()){
    		int x = celdaVecinaPercibida.getX();
    		int y = celdaVecinaPercibida.getY();
    		Celda celdaVecinaActual = this.casa.getCelda(x, y);
    		celdaVecinaActual.setDescubierta(true);
    		celdaVecinaActual.setTipoSuelo(celdaVecinaPercibida.getTipoSuelo());
    	}
    	
    	List<Celda> eventosVecinosDescubiertos = carToyPerception.getEventosCercanosDescubiertos();
    	if(eventosVecinosDescubiertos != null) {
        	for(Celda e: eventosVecinosDescubiertos) {
        		this.remove(e);
        	}
    	}
    	if(carToyPerception.getPosicionBoy() != null) {
    		this.posicionBoy = carToyPerception.getPosicionBoy();
    	}
    	
    	final EstadoCarToy  agState = this;
    	
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	int x_ag = agState.getPosicionCarToy().getX();
		    	int y_ag = agState.getPosicionCarToy().getY();
		    	char[][] casaDisplay = agState.getCasa().getPlanoChars();
		    	casaDisplay[x_ag][y_ag] = 'A';
		    	if(agState.getPosicionBoy() !=null) {
			    	int x_ch = agState.getPosicionBoy().getX();
			    	int y_ch = agState.getPosicionBoy().getY();
			    	casaDisplay[x_ch][y_ch] = 'B';
		    	}

				PrincipalNueva.getInstancia().actualizarTablero(casaDisplay);
		    }
		});
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
       
        str.append("\n");
		for(int i = 0; i < this.casa.X_CELLS ; i++){
			str.append("|");
			for (int j = 0; j < this.casa.Y_CELLS; j++){
				if(this.posicionCarToy != null && this.posicionCarToy.getX() == i && this.posicionCarToy.getY() == j)
					str.append("A|");
				else if(this.casa.getCelda(i, j).isDescubierta()){
					if(this.posicionBoy != null && this.posicionBoy.getX() == i && this.posicionBoy.getY() == j) 
						str.append("B|");
					else 
						str.append(this.casa.getCelda(i, j).getChar() + "|");
				} else {
					str.append("x|");
				}
				
			}
			str.append("\n");
		}
		str.append("Costo: " + this.getCosto());
        return str.toString();
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       EstadoCarToy estadoComparado = (EstadoCarToy) obj;
       
       // Comparo que esten en la misma posicion
       boolean mismaPosicion;
       mismaPosicion = estadoComparado.getPosicionCarToy().getX() == this.getPosicionCarToy().getX() &&
       estadoComparado.getPosicionCarToy().getY() == this.getPosicionCarToy().getY();
       
       
       boolean mismasDescubiertas = true;
       boolean mismasVisitas = true;

       for(int i=0 ; i<this.casa.X_CELLS; i++) {
    	   for(int j=0; j<this.casa.Y_CELLS; j++) {
    		   if(this.casa.getCelda(i, j).isDescubierta() != estadoComparado.getCasa().getCelda(i, j).isDescubierta()) {
    			   mismasDescubiertas = false;
    			   break;
    		   }
    		   if(this.casa.getCelda(i, j).getVisitas() != estadoComparado.getCasa().getCelda(i, j).getVisitas()) {
    			   mismasVisitas = false;
    			   break;
    		   }
    	   }
       }
     
       return mismaPosicion && mismasDescubiertas && mismasVisitas; 
    }

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setPosicionCarToy(Celda posicionCarToy) {
		this.posicionCarToy = posicionCarToy;
	}

	public Celda getPosicionCarToy() {
		return posicionCarToy;
	}

	public Celda getPosicionBoy() {
		return posicionBoy;
	}

	public void setPosicionBoy(Celda posicionBoy) {
		this.posicionBoy = posicionBoy;
	}
	
	public double getCosto(){

		return this.costo;
	}

	public void incrementarCosto(double costo){

		this.costo += costo;
	}

	public List<Celda> getEventosCercanos() {
		return eventosCercanos;
	}

	public void setEventosCercanos(List<Celda> eventosCercanos) {
		this.eventosCercanos = eventosCercanos;
	}
	
	public void addEvento(Celda e) {
		this.eventosCercanos.add(e);
	}
	
	public void remove(Celda e) {
		if(this.eventosCercanos.contains(e)) {
			this.eventosCercanos.remove(e);
		}
	}
	
	public Celda getProximoObjetivo() {
		if(this.posicionBoy != null) {
			return this.posicionBoy;
		} else if (!this.eventosCercanos.isEmpty()) {
			return this.eventosCercanos.get(0);
		}
		return null;
	}
}


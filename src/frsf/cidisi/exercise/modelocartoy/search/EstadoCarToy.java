package frsf.cidisi.exercise.modelocartoy.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Celda;
import model.Casa;
import model.TipoSuelo;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoCarToy extends SearchBasedAgentState {
	
    private Casa casa;
    
    private Celda posicionCarToy;
	private Celda posicionBoy;

    private List<Celda> celdasDescubiertas;
    private List<Celda> celdasVisitadas;
    
    private double costo;
	
    public EstadoCarToy(Casa casa) {
    
    	this.casa = casa;
    	this.posicionCarToy = new Celda();
    	this.posicionBoy = new Celda();
    	this.celdasDescubiertas = new ArrayList<Celda>();
        this.celdasVisitadas = new ArrayList<Celda>();
        this.costo = 0.0;
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
        this.posicionCarToy = this.casa.getPosicionAgente();
        this.posicionBoy = this.casa.getPosicionBoy();
        this.celdasDescubiertas.add(this.posicionCarToy);
        this.celdasVisitadas.add(this.posicionCarToy);
        this.costo = 0.0;
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	EstadoCarToy estadoClone = new EstadoCarToy(this.casa);
    	
    	estadoClone.setPosicionCarToy(this.posicionCarToy.clone());
    	estadoClone.setPosicionBoy(this.posicionBoy.clone());
        	
    	List<Celda> newCeldasDescubiertas = new ArrayList<Celda>();
    	for(Celda c:this.getCeldasDescubiertas()){
    		newCeldasDescubiertas.add(c.clone());
    	}
    	
    	List<Celda> newCeldasVisitadas = new ArrayList<Celda>();
    	for(Celda c:this.getCeldasVisitadas()){
    		newCeldasVisitadas.add(c.clone());
    	}
    	
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
    	
    	for(Celda celdaVecina: carToyPerception.getCeldasVecinas()){
    		if(!this.celdasDescubiertas.contains(celdaVecina))
    			this.celdasDescubiertas.add(celdaVecina);
    	}
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("\n");
		for(int i = 0; i < Casa.X_CELLS ; i++){
			str.append("|");
			for (int j = 0; j < Casa.Y_CELLS; j++){
				if(this.celdasDescubiertas.contains(this.casa.getCelda(i, j))){
					if(this.posicionCarToy != null && this.posicionCarToy.getX() == i && this.posicionCarToy.getY() == j)
						str.append("A|");
					else if(this.posicionBoy != null && this.posicionBoy.getX() == i && this.posicionBoy.getY() == j) 
						str.append("B|");
					else 
						str.append(this.casa.getCelda(i, j).getChar() + "|");
				} else {
					str.append("x|");
				}
				
			}
			str.append("\n");
		}
		str.append("\n\n");
		str.append("Descubiertas : " + this.celdasDescubiertas);
		str.append("\n\n");
		str.append("Visitadas : " + this.celdasVisitadas);
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
       boolean mismaPosicion = estadoComparado.getPosicionCarToy().equals(this.getPosicionCarToy());

       /*
       // Comparo que tengan las mismas visitadas y descubiertas
       boolean mismasCeldasVisitadas = true;
       boolean mismasCeldasDescubiertas = true;
       
       // Primero me fijo si la cantidad de visistadas y de descubiertas son iguales en ambos estados
       mismasCeldasVisitadas = this.getCeldasVisitadas().size() == estadoComparado.getCeldasVisitadas().size();
       mismasCeldasDescubiertas = this.getCeldasDescubiertas().size() == estadoComparado.getCeldasDescubiertas().size();
       
       // Si visito la misma cantidad de celdas, valido que sean las mismas
       if(mismasCeldasVisitadas){
    	   Object[] actuales = this.getCeldasVisitadas().toArray();
    	   Object[] comparadas = estadoComparado.getCeldasVisitadas().toArray();
    	   
    	   Arrays.sort(actuales);
    	   Arrays.sort(comparadas);
    	   for(int i=0; i<actuales.length;i++)
    		   if(! ((Celda)actuales[i]).equals(comparadas[i])){
    			   mismasCeldasVisitadas = false;
    			   break;
    		   }
       }
       
       // Si descubrio la misma cantidad de celdas, valido que sean las mismas
       if(mismasCeldasDescubiertas){
    	   Object[] actuales = this.getCeldasDescubiertas().toArray();
    	   Object[] comparadas = estadoComparado.getCeldasDescubiertas().toArray();
    	   
    	   Arrays.sort(actuales);
    	   Arrays.sort(comparadas);
    	   for(int i=0; i<actuales.length;i++)
    		   if(! ((Celda)actuales[i]).equals(comparadas[i])){
    			   mismasCeldasDescubiertas = false;
    			   break;
    		   }
       }*/
       return mismaPosicion; //&& mismasCeldasDescubiertas && mismasCeldasVisitadas;
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

	public List<Celda> getCeldasDescubiertas() {
		return celdasDescubiertas;
	}

	public void setCeldasDescubiertas(List<Celda> celdasDescubiertas) {
		this.celdasDescubiertas = celdasDescubiertas;
	}

	public List<Celda> getCeldasVisitadas() {
		return celdasVisitadas;
	}

	public void setCeldasVisitadas(List<Celda> celdasVisitadas) {
		this.celdasVisitadas = celdasVisitadas;
	}
	
	public void addCeldaVisitada(Celda c){
		this.celdasVisitadas.add(c);
	}
	
	public void addCeldaDescubierta(Celda c){
		this.celdasDescubiertas.add(c);
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
}


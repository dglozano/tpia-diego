package frsf.cidisi.exercise.modelocartoy.search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoCarToy extends SearchBasedAgentState {
	
	//TODO: Setup Variables
    private int[][] planoCasaDescubierto;
    private int[] posicionAgente;
    //private Other listaEventos;
    //private Other habitacionBoy;
    //private Other habitacionAgente;
	

    public EstadoCarToy() {
    
    	//TODO: Complete Method
    	/*
			// planoCasaDescubierto = initData0;
			// posicionAgente = initData1;
			// listaEventos = initData2;
			// habitacionBoy = initData3;
			// habitacionAgente = initData4;
        */
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
		
        return null;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
     public int[][] getplanoCasaDescubierto(){
        return planoCasaDescubierto;
     }
     public void setplanoCasaDescubierto(int[][] arg){
        planoCasaDescubierto = arg;
     }
     public int[] getposicionAgente(){
        return posicionAgente;
     }
     public void setposicionAgente(int[] arg){
        posicionAgente = arg;
     }
//     public Other getlistaEventos(){
//        return listaEventos;
//     }
//     public void setlistaEventos(Other arg){
//        listaEventos = arg;
//     }
//     public Other gethabitacionBoy(){
//        return habitacionBoy;
//     }
//     public void sethabitacionBoy(Other arg){
//        habitacionBoy = arg;
//     }
//     public Other gethabitacionAgente(){
//        return habitacionAgente;
//     }
//     public void sethabitacionAgente(Other arg){
//        habitacionAgente = arg;
//     }
	
}


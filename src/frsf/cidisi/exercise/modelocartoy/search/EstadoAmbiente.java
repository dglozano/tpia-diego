package frsf.cidisi.exercise.modelocartoy.search;

import java.util.ArrayList;
import java.util.List;

import model.Celda;
import model.Evento;
import model.PlanoCasa;
import model.PosicionBoy;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private PlanoCasa planoCasa;
    private Celda posicionCarToy;
    private List<Evento> listaEventos;
    private PosicionBoy posicionBoy;
	
    public EstadoAmbiente() {
        
        planoCasa = new PlanoCasa();
        posicionCarToy = new Celda();
        listaEventos = new ArrayList<Evento>();
        posicionBoy = new PosicionBoy();
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

    	// TODO: Cargar Plano Casa con funcion martinez
    	// TODO: generar obstaculos
    	// TODO: generar posicion al azar de agente
    	// TODO: generar posicion al azar de boy
    	// TODO: generar lista de ventos al azar en la misma habitacion que boy
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str += "Estado del ambiente: \n";
        
        str += "Plano Casa \n \n";
        
        //TODO: print planoCasa;
        	
        	

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public int[][] getplanoCasa(){
        return planoCasa;
     }
     public void setplanoCasa(int[][] arg){
        planoCasa = arg;
     }
//     public Other getBoy(){
//        return Boy;
//     }
//     public void setBoy(Other arg){
//        Boy = arg;
//     }
//     public Other getlistaEventos(){
//        return listaEventos;
//     }
//     public void setlistaEventos(Other arg){
//        listaEventos = arg;
//     }
     public int getposicionAgente(){
        return posicionAgente;
     }
     public void setposicionAgente(int arg){
        posicionAgente = arg;
     }
	

}


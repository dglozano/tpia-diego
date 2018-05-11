package frsf.cidisi.exercise.modelocartoy.search.actions;

import model.Casa;
import model.Celda;
import frsf.cidisi.exercise.modelocartoy.search.EstadoAmbiente;
import frsf.cidisi.exercise.modelocartoy.search.EstadoCarToy;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrNorte extends SearchAction {

	private double costo = 1.0;
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoCarToy agState = (EstadoCarToy) s;
		
		Celda posAgente = agState.getPosicionCarToy();
		int x_next = posAgente.getX() - 1;
		int y_next = posAgente.getY();

		//si la siguiente celda no se va del mapa
		if (agState.getCasa().isBetweenLimits(x_next, y_next)){
			Celda siguiente = agState.getCasa().getCelda(x_next, y_next);
			//si la siguiente celda es accesible y no hay vecinas con menos visitas que la siguiente
			if(siguiente.esAccisble() && !agState.getCasa().hayCeldaVecinaConMenosVisitas(posAgente, siguiente)) {
				agState.setPosicionCarToy(siguiente);
				siguiente.incrementarVisitas();
				this.costo = posAgente.getCosto() * 0.5 + siguiente.getCosto() * 0.5;
				agState.incrementarCosto(this.costo);
				return agState;	
			}
		}
		
		return null;
	}

	@Override
	public Double getCost() {
		return this.costo;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		EstadoAmbiente environmentState = (EstadoAmbiente) est;
		EstadoCarToy agState = (EstadoCarToy) ast;
		
		Celda posAgente = agState.getPosicionCarToy();
		int x_next = posAgente.getX() - 1;
		int y_next = posAgente.getY();

		//si la siguiente celda no se va del mapa
		if (agState.getCasa().isBetweenLimits(x_next, y_next)){
			Celda siguiente = agState.getCasa().getCelda(x_next, y_next);
			//si la siguiente celda es accesible y no hay vecinas con menos visitas que la siguiente
			if(siguiente.esAccisble() && !agState.getCasa().hayCeldaVecinaConMenosVisitas(posAgente, siguiente)) {
				agState.setPosicionCarToy(siguiente);
				siguiente.incrementarVisitas();
				environmentState.setPosicionAgente(x_next,y_next);
				return environmentState;
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "-> Ir Norte";
	}
}

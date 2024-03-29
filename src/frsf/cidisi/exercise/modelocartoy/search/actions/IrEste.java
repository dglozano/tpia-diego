package frsf.cidisi.exercise.modelocartoy.search.actions;

import model.Casa;
import model.Celda;
import model.TipoSuelo;

import javax.swing.SwingUtilities;

import frsf.cidisi.exercise.modelocartoy.search.EstadoAmbiente;
import frsf.cidisi.exercise.modelocartoy.search.EstadoCarToy;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrEste extends SearchAction {
	
	private double costo = 1.0;

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoCarToy agState = (EstadoCarToy) s;
		
		Celda posAgente = agState.getPosicionCarToy();
		int x_next = posAgente.getX();
		int y_next = posAgente.getY() + 1;
		
		//si la siguiente celda no se va del mapa
		if (agState.getCasa().isBetweenLimits(x_next, y_next)){
			Celda siguiente = agState.getCasa().getCelda(x_next, y_next);
			//si la siguiente celda es accesible y no hay vecinas con menos visitas que la siguiente
			if(siguiente.esAccisble() && siguiente.getVisitas() < 3 && !agState.getCasa().hayCeldaVecinaConMenosVisitas(posAgente, siguiente)) {
				agState.setPosicionCarToy(siguiente);
				siguiente.incrementarVisitas();
				
				double costoCeldaActual = posAgente.getCosto();
				if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_E)
					costoCeldaActual /= 2.0;
				else if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_O)
					costoCeldaActual *= 2.0;
				double costoCeldaSig = siguiente.getCosto();
				if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_E)
					costoCeldaSig /= 2.0;
				else if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_O)
					costoCeldaSig *= 2.0;
				this.costo = costoCeldaActual * 0.5 + costoCeldaSig * 0.5;
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

		EstadoAmbiente environmentState = (EstadoAmbiente) est;
		final EstadoCarToy agState = (EstadoCarToy) ast;
		
		Celda posAgente = agState.getPosicionCarToy();
		int x_next = posAgente.getX();
		int y_next = posAgente.getY() + 1;
		
		//si la siguiente celda no se va del mapa
		if (agState.getCasa().isBetweenLimits(x_next, y_next)){
			Celda siguiente = agState.getCasa().getCelda(x_next, y_next);
			//si la siguiente celda es accesible y no hay vecinas con menos visitas que la siguiente
			if(siguiente.esAccisble()  && siguiente.getVisitas() < 3 && !agState.getCasa().hayCeldaVecinaConMenosVisitas(posAgente, siguiente)) {
				agState.setPosicionCarToy(siguiente);
				siguiente.incrementarVisitas();
				double costoCeldaActual = posAgente.getCosto();
				if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_E)
					costoCeldaActual /= 2.0;
				else if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_O)
					costoCeldaActual *= 2.0;
				double costoCeldaSig = siguiente.getCosto();
				if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_E)
					costoCeldaSig /= 2.0;
				else if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_O)
					costoCeldaSig *= 2.0;
				this.costo = costoCeldaActual * 0.5 + costoCeldaSig * 0.5;
				agState.incrementarCosto(this.costo);
				
				agState.remove(siguiente);
				environmentState.setEventosCercanos(agState.getEventosCercanos());
				
				environmentState.setPosicionAgente(x_next,y_next);
				
				return environmentState;
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "-> Ir Este";
	}

}

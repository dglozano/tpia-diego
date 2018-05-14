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

public class ResponderEventoDescubierto extends SearchAction {
	
	private double costo = 1.0;

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoCarToy agState = (EstadoCarToy) s;
		
		Celda posAgente = agState.getPosicionCarToy();


		if(agState.getPosicionBoy() != null) {
			agState.setPosicionCarToy(agState.getPosicionBoy());
			agState.getPosicionBoy().incrementarVisitas();
			Celda siguiente = agState.getPosicionBoy();
			double costoCeldaActual = posAgente.getCosto();
			if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_S)
				costoCeldaActual /= 2.0;
			else if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_N)
				costoCeldaActual *= 2.0;
			double costoCeldaSig = siguiente.getCosto();
			if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_S)
				costoCeldaSig /= 2.0;
			else if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_N)
				costoCeldaSig *= 2.0;
			this.costo = costoCeldaActual * 0.5 + costoCeldaSig * 0.5;
			agState.incrementarCosto(costo);
			return agState;
		}
		
		for(Celda ev: agState.getEventosCercanos()) {
			if(agState.getCasa().getCeldasVecinas(posAgente).contains(ev)) {
				agState.remove(ev);
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
		
		if(agState.getPosicionBoy() != null) {
			agState.setPosicionCarToy(agState.getPosicionBoy());
			agState.getPosicionBoy().incrementarVisitas();
			Celda siguiente = agState.getPosicionBoy();
			double costoCeldaActual = posAgente.getCosto();
			if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_S)
				costoCeldaActual /= 2.0;
			else if(posAgente.getTipoSuelo() == TipoSuelo.ESCALERA_N)
				costoCeldaActual *= 2.0;
			double costoCeldaSig = siguiente.getCosto();
			if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_S)
				costoCeldaSig /= 2.0;
			else if(siguiente.getTipoSuelo() == TipoSuelo.ESCALERA_N)
				costoCeldaSig *= 2.0;
			this.costo = costoCeldaActual * 0.5 + costoCeldaSig * 0.5;
			agState.incrementarCosto(this.costo);
						
			environmentState.setPosicionAgente(agState.getPosicionBoy());
			
			return environmentState;
		}

		//si alguna celda alrededor es un evento o el ninio
		for(Celda ev: agState.getEventosCercanos()) {
			if(agState.getCasa().getCeldasVecinas(posAgente).contains(ev)) {
				agState.remove(ev);
				environmentState.remove(ev);
				return environmentState;
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "-> Actuar Ante Evento Descubierto";
	}

}
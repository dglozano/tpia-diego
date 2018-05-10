package frsf.cidisi.exercise.modelocartoy.search.actions;

import model.Casa;
import model.Celda;
import frsf.cidisi.exercise.modelocartoy.search.EstadoAmbiente;
import frsf.cidisi.exercise.modelocartoy.search.EstadoCarToy;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrNoreste extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoCarToy agState = (EstadoCarToy) s;
		
		Celda posAgente = agState.getPosicionCarToy();
		int x_next = posAgente.getX() - 1;
		int y_next = posAgente.getY() + 1;
				
		if(Casa.isBetweenLimits(x_next, y_next) && agState.getCasa().getCelda(x_next, y_next).esAccisble()) {
			//agState.setPosicionCarToy(agState.getCasa().getCelda(x_next, y_next));
			if(!agState.getCeldasVisitadas().contains(agState.getCasa().getCelda(x_next, y_next))){
				agState.setPosicionCarToy(agState.getCasa().getCelda(x_next, y_next));
				agState.addCeldaVisitada(agState.getCasa().getCelda(x_next, y_next));
				return agState;	
			}
		}
		
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		EstadoAmbiente environmentState = (EstadoAmbiente) est;
		EstadoCarToy agState = (EstadoCarToy) ast;
		
		Celda posAgente = agState.getPosicionCarToy();
		int x_next = posAgente.getX() - 1;
		int y_next = posAgente.getY() + 1;
				
		if(Casa.isBetweenLimits(x_next, y_next) && agState.getCasa().getCelda(x_next, y_next).esAccisble()) {
			//agState.setPosicionCarToy(agState.getCasa().getCelda(x_next, y_next));
			if(!agState.getCeldasVisitadas().contains(agState.getCasa().getCelda(x_next, y_next))){
				agState.setPosicionCarToy(agState.getCasa().getCelda(x_next, y_next));
				agState.addCeldaVisitada(agState.getCasa().getCelda(x_next, y_next));
				environmentState.setPosicionAgente(x_next,y_next);
				return environmentState;
			}
		}
		
		
		return null;
	}

	@Override
	public String toString() {
		return "-> Ir NorEste";
	}

}

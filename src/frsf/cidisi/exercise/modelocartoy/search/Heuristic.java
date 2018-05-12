package frsf.cidisi.exercise.modelocartoy.search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoCarToy agState = (EstadoCarToy) node.getAgentState();
	
		int distancia = 0;
		
		int posCarX = agState.getPosicionCarToy().getX();
		int posCarY = agState.getPosicionCarToy().getY();
		int posNinioX = agState.getPosicionBoy().getX();
		int posNinioY = agState.getPosicionBoy().getY();
		
		int difX = Math.abs(posCarX-posNinioX);
		int difY = Math.abs(posCarY-posNinioY);
		
		distancia =(int) Math.sqrt((difX^2)+(difY^2));
		
        return distancia;
    }
}

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
        
        double xDestino = (double) agState.getPosicionBoy().getX();
        double yDestino = (double) agState.getPosicionBoy().getY();
        double xActual = (double) agState.getPosicionCarToy().getX();
        double yActual = (double) agState.getPosicionCarToy().getY();
        
        return Math.sqrt(Math.pow(xDestino-xActual, 2) + Math.pow(yDestino-yActual, 2));
    }
}

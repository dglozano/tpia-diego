package frsf.cidisi.exercise.modelocartoy.search;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class can be used in any search strategy like
 * Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {

    /**
     * This method calculates the cost of the given NTree node.
     */
    @Override
    public double calculateCost(NTree node) {
        //node posee como atributo el estado, el cuál tiene el costo asociado
    	//el costo del agente se va incrementando en cada acción que ejecuta   
        return ((EstadoCarToy)node.getAgentState()).getCosto();
    }
}

package model;

import java.util.List;


public class PlanoCasa {
       
	public static final int X_CELLS = 50;
	public static final int Y_CELLS = 82;
	
	/*private int xPrueba = 0;
	private int yPrueba = 0;*/
	
    private Celda[][] unPlano = new Celda[X_CELLS][Y_CELLS];
    private List<Habitacion> listaHabitaciones;
    private List<Puerta>  listaPuertas;
    private List<Obstaculo> listaObstaculos;
    
	public PlanoCasa() {
		for (int a = 0; a < X_CELLS; a++)
			for (int b= 0; b < Y_CELLS; b++) 
				unPlano[a][b]= new Celda();
	}
	
	// FIXME: Plano casa ejemplo, borrar luego
	public PlanoCasa(int x, int y) {
		xPrueba = x;
		yPrueba = y;
		for (int a = 0; a < x; a++)
			for (int b= 0; b < y; b++){
				Celda celda = new Celda();
				if(a == 0 || a == x-1 || b == 0 || b == y-1 || (b == y/2 && a != x/2)){
					celda.setCosto(9999.0);
					celda.setTipoSuelo(TipoSuelo.PARED);				
				} else if (b == y/2 && a == x/2){
					celda.setCosto(1.0);
					celda.setTipoSuelo(TipoSuelo.PUERTA_ABIERTA);
				} else {
					celda.setCosto(1.0);
					celda.setTipoSuelo(TipoSuelo.COMUN);
				}
				unPlano[a][b]= new Celda();
			}
	}

	public Celda[][] getUnPlano() {
		return unPlano;
	}

	public void setUnPlano(Celda[][] unPlano) {
		this.unPlano = unPlano;
	}

	public List<Habitacion> getHabitaciones() {
		return listaHabitaciones;
	}
	   
	public void setHabitaciones(List<Habitacion> listaHab) {
		this.listaHabitaciones = listaHab;
	}

	public void setListaPuertas(List<Puerta> listaPuertas) {
		this.listaPuertas = listaPuertas;
	}

	public List<Puerta> getListaPuertas() {
		return listaPuertas;
	}

	public void setListaObstaculos(List<Obstaculo> listaObstaculos) {
		this.listaObstaculos = listaObstaculos;
	}

	public List<Obstaculo> getListaObstaculos() {
		return listaObstaculos;
	}
	
	@Override
	public String toString(){
		String output = "|";
		for(int i = 0; i < xPrueba ; i++){
			for (int j = 0; j < yPrueba; j++){
				switch(this.unPlano[i][j].getTipoSuelo()){
					
				}
			}
			output += "\n";
		}
		return output;
	}
}


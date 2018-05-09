package model;

import java.util.List;

public class Puerta {
	
	private List<Celda> celdasPuerta;
	private boolean abierta;
	
	public Puerta(){}
	
	public Puerta(List<Celda> celdasPuerta, boolean abierta) {
		super();
		this.celdasPuerta = celdasPuerta;
		this.abierta = abierta;
	}

	public List<Celda> getCeldasPuerta() {
		return celdasPuerta;
	}

	public void setCeldasPuerta(List<Celda> celdasPuerta) {
		this.celdasPuerta = celdasPuerta;
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}
	
	
	
}

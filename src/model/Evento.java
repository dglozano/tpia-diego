package model;

public class Evento {
	
	private Celda posicionEvento;
	private String nombreEvento;
	
	public void setPosicionEvento(Celda posicionEvento) {
		this.posicionEvento = posicionEvento;
	}
	
	public Celda getPosicionEvento() {
		return posicionEvento;
	}
	
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	
	public String getNombreEvento() {
		return nombreEvento;
	}
}

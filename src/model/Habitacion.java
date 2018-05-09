package model;

import java.util.List;

public class Habitacion {
	
	private List<Celda> celdasHabitacion;
	private String nombre;
	
	public Habitacion(List<Celda> celdasHabitacion) {
		super();
		this.celdasHabitacion = celdasHabitacion;
	}

	public void setCeldasHabitacion(List<Celda> celdasHabitacion) {
		this.celdasHabitacion = celdasHabitacion;
	}

	public List<Celda> getCeldasHabitacion() {
		return celdasHabitacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
}

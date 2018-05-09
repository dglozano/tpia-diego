package model;

public class Celda {

    private TipoSuelo tipoSuelo;
    private Double costo;
    private boolean descubierta;
    
    public Celda(){
    	
    }
    
    public Celda(TipoSuelo tipoSuelo, Double costo){
    	this.tipoSuelo = tipoSuelo;
    	this.costo = costo;
    	this.descubierta = false;
    }
    
	public TipoSuelo getTipoSuelo() {
		return tipoSuelo;
	}

	public void setTipoSuelo(TipoSuelo tipoSuelo) {
		this.tipoSuelo = tipoSuelo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Double getCosto() {
		return costo;
	}

	public void setDescubierta(boolean descubierta) {
		this.descubierta = descubierta;
	}

	public boolean isDescubierta() {
		return descubierta;
	}
	
	@Override
	public String toString(){
		String str = "";
		switch(this.tipoSuelo){
			case COMUN:
				str = "_";
				break;
			case PARED:
				str = "#";
				break;
			case PUERTA_ABIERTA:
				str = "o";
				break;
			case PUERTA_CERRADA:
				str = "c";
				break;
			case OBSTACULO:
				str = "$";
				break;
			case PASTO:
				str = "~";
				break;
			case ALFOMBRA:
				str = "\\";
				break;
			default:
				str = "?";
		}
		return str;
	}
}

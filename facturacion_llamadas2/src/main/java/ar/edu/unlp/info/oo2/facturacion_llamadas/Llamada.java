package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Llamada {
	protected String emisor;
	protected String remitente;
	protected int dur;


	public abstract double costoLlamada(); 
	
	public void setEmisor(String q) {
		emisor = q;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	
	
	
	
}

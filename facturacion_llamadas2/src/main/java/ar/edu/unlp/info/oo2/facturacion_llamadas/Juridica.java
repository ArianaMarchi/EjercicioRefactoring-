package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Juridica extends Persoona {

	public Juridica(String nomYape, String data) {
		this.nya = nomYape;
		this.doc = data;
	}
	public double getDescuento() {
		return 0.15;
	}
	
}

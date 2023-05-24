package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Nacional extends Llamada {

	public Nacional(Persoona q, Persoona q2, int d) {
		this.emisor= q.getTel();
		this.remitente= q2.getTel();
		this.dur = dur;
	}
	public double costoLlamada() {
		return this.dur *3 * 1.21;
	}
}

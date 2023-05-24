package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Persoona {
	protected List<Llamada> lista1 = new ArrayList<Llamada>();
	public String t;
	public String nya;
	public String tel;
	public String cuit;
	public String doc;
	
	public List<Llamada> getLista1() {
		return lista1;
	}
	public void setLista1(List<Llamada> lista1) {
		this.lista1 = lista1;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getNya() {
		return nya;
	}
	public void setNya(String nya) {
		this.nya = nya;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	public Llamada registrarLlamadaNacional(Persoona q, int d) {
		Nacional l = new Nacional(this, q, d);
		this.lista1.add(l);
		return l;
	}
	public Llamada registrarLlamadaInternacional(Persoona q, int d) {
		Internacional l = new Internacional(this, q, d);
		this.lista1.add(l);
		return l;
	}
	
	public double montoTotalLlamadas() {
		double total =this.getLista1().stream().mapToDouble(l -> l.costoLlamada())
						.sum();
		return total - total*this.getDescuento();
	}
	public abstract double getDescuento();
	

	
}

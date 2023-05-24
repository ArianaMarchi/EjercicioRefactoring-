package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Persoonal {
	List<Persoona> lista1 = new ArrayList<Persoona>();
	SortedSet<String> guia = new TreeSet<String>();
	
	public boolean agregarTelefono(String str) {
		boolean encontre = guia.contains(str);
		if (!encontre) {
			guia.add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
	public Fisica registrarFisica(String doc, String nomyape) {
		Fisica p = new Fisica(doc, nomyape);
		p.setTel(this.asignarNumero());
		lista1.add(p);
		return p;
	}
	public Juridica registrarJuridica(String doc, String nomyape) {
		Juridica p = new Juridica(doc, nomyape);
		p.setTel(this.asignarNumero());
		lista1.add(p);
		return p;
	}
	
	public String asignarNumero() {
		String tel = guia.last();
		guia.remove(tel);
		return tel;
	}
	
	public boolean eliminarUsuario(Persoona p) {
		List<Persoona> l = lista1.stream().filter(persona -> persona != p).collect(Collectors.toList());
		boolean borre = false;
		if (l.size() < lista1.size()) {
			this.lista1 = l;
			this.guia.add(p.getTel());
			borre = true;
		}
		return borre;
		
	}
	
	public double calcularMontoTotalLlamadas(Persoona p) {
		if (this.existeUsuario(p)) {
			return p.montoTotalLlamadas();
		}
		return 0;
	}

	public int cantidadDeUsuarios() {
		return lista1.size();
	}

	public boolean existeUsuario(Persoona persona) {
		return lista1.contains(persona);
	}
	
}

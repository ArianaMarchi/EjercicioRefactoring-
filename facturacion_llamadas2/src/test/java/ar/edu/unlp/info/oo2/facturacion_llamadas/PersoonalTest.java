package ar.edu.unlp.info.oo2.facturacion_llamadas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersoonalTest {
	
	Persoonal sistema;
	Persoona emisorPersonaFisca, remitentePersonaFisica, emisorPersonaJuridica, remitentePersonaJuridica;
	
	@BeforeEach
	public void setUp() {
		this.sistema = new Persoonal();
		this.sistema.agregarTelefono("2214444554");
		this.sistema.agregarTelefono("2214444555");
		this.sistema.agregarTelefono("2214444556");
		this.sistema.agregarTelefono("2214444557");
		
		this.emisorPersonaFisca = sistema.registrarFisica("11555666", "Marcelo Tinelli");
		this.remitentePersonaFisica = sistema.registrarFisica("00000001", "Mirtha Legrand");
		this.emisorPersonaJuridica = sistema.registrarFisica("17555222", "Felfort");
		this.remitentePersonaJuridica = sistema.registrarJuridica("25765432", "Moovistar");
		
		this.emisorPersonaJuridica.registrarLlamadaNacional( remitentePersonaFisica, 10);
		this.emisorPersonaJuridica.registrarLlamadaInternacional( remitentePersonaFisica, 8);
		this.emisorPersonaJuridica.registrarLlamadaNacional( remitentePersonaJuridica, 5);
		this.emisorPersonaJuridica.registrarLlamadaInternacional(remitentePersonaJuridica, 7);
		this.emisorPersonaFisca.registrarLlamadaNacional(remitentePersonaFisica, 15);
		this.emisorPersonaFisca.registrarLlamadaInternacional(remitentePersonaFisica, 45);
		this.emisorPersonaFisca.registrarLlamadaNacional( remitentePersonaJuridica, 13);
		this.emisorPersonaFisca.registrarLlamadaInternacional(remitentePersonaJuridica, 17);
		
	}

	@Test
	void testcalcularMontoTotalLlamadas() {
		assertEquals(this.sistema.calcularMontoTotalLlamadas(emisorPersonaFisca), 15105.640000000001);
		assertEquals(this.sistema.calcularMontoTotalLlamadas(emisorPersonaJuridica), 3131.7825000000003);
		assertEquals(this.sistema.calcularMontoTotalLlamadas(remitentePersonaFisica), 0);
		assertEquals(this.sistema.calcularMontoTotalLlamadas(remitentePersonaJuridica), 0);
	}
	
	@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeUsuarios(), 4);
		this.sistema.agregarTelefono("2214444558"); 
		Persoona nuevaPersona = this.sistema.registrarFisica("2444555","Chiche Gelblung");
		
		assertEquals(this.sistema.cantidadDeUsuarios(), 5);
		assertTrue(this.sistema.existeUsuario(nuevaPersona));
		
	}
	
	@Test
	void testEliminarUsuario() {
		assertEquals(this.sistema.cantidadDeUsuarios(), 4);
		assertTrue(this.sistema.existeUsuario(emisorPersonaFisca));
		this.sistema.eliminarUsuario(emisorPersonaFisca);
		assertEquals(this.sistema.cantidadDeUsuarios(), 3);
		assertFalse(this.sistema.existeUsuario(emisorPersonaFisca));
	}

}

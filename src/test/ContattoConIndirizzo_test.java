package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import upo.rubriche.Contatto;
import upo.rubriche.ContattoConIndirizzo;

class ContattoConIndirizzo_test {
	
	private ContattoConIndirizzo t1;
	private ContattoConIndirizzo t2;
	private ContattoConIndirizzo t3;
	private ContattoConIndirizzo t4;
	private ContattoConIndirizzo t5;
	private ContattoConIndirizzo t6;
	private Object t7;
	private ContattoConIndirizzo Equals;

	@BeforeEach
	void setUp() throws Exception {
		t1 = new ContattoConIndirizzo("Emilio","Pizzuto","3347570099","Via Giovanni dalle bande nere");
		t2 = new ContattoConIndirizzo("Marco","Ascia","3336793322","Via Fogna");
		t3 = new ContattoConIndirizzo("Stefano","Crotti","3420820604","Via diqui");
		t4 = new ContattoConIndirizzo("Andrea","Crisci","3477324151","Piazza LaBomb Escappa");
		t5 = new ContattoConIndirizzo("Ricardo","Ascia","0110341195","Via Palme Fucsia");
		t6 = new ContattoConIndirizzo(t3,"03213731","Casa dei Soviet");
		Equals = new ContattoConIndirizzo("Andrea","Crisci","3477324151","Piazza LaBomb Escappa");
	}

	@Test
	@DisplayName ("Test che controlla che il risultato sia di tipo 'String' ")
	void testToString() {
		assertNotNull(t1.toString());
		assertTrue(t1.toString() instanceof String);
		assertEquals("Emilio	Pizzuto	3347570099	Via Giovanni dalle bande nere", t1.toString());
	}

	@Test
	@DisplayName ("Test per confronto del tipo degli oggetti e dei valori in essi contenuti")
	void testEqualsObject() {
		assertFalse(t4.equals(t7));
		assertTrue(t4.equals(Equals));
		assertFalse(t4.equals(t3));
	}

	@Test
	@DisplayName ("Test che verifica il primo costruttore di ContattoConIndirizzo")
	void testContattoConIndirizzoStringStringStringString() {
		//asserEquals (Object expected, Object actual);
		assertNotNull(t1);
		assertTrue(t1 instanceof Contatto);
		assertEquals("Emilio", t1.getNome());
		assertEquals("Pizzuto",t1.getCognome());
		assertEquals("3347570099",t1.getNumeroTelefonico());
		assertEquals("Via Giovanni dalle bande nere",t1.getIndirizzo());
	}

	@Test
	@DisplayName ("Test che verifica il secondo costruttore di ContattoConIndirizzo")
	void testContattoConIndirizzoContattoStringString() {
		assertNotNull(t6);
		assertTrue(t6 instanceof Contatto);
		assertEquals(t3.getNome(), t6.getNome());
		assertEquals(t3.getCognome(), t6.getCognome());
		assertEquals("03213731",t6.getNumeroTelefonico());
		assertEquals("Casa dei Soviet",t6.getIndirizzo());
	}

	@Test
	@DisplayName ("Test che verifica il primo costruttore di Contatto")
	void testContattoStringStringString() {
		assertNotNull(t1);
		assertTrue(t1 instanceof Contatto);
		assertEquals("Emilio", t1.getNome());
		assertEquals("Pizzuto",t1.getCognome());
		assertEquals("3347570099",t1.getNumeroTelefonico());
	}

	@Test
	@DisplayName ("Test che verifica il secondo costruttore di Contatto")
	void testContattoContattoString() {
		assertNotNull(t6);
		assertTrue(t6 instanceof Contatto);
		assertEquals(t3.getNome(), t6.getNome());
		assertEquals(t3.getCognome(), t6.getCognome());
		assertEquals("03213731",t6.getNumeroTelefonico());
	}

	@Test
	@DisplayName ("Test che verifica il nome")
	void testGetNome() {
		assertNotNull(t1.getNome());
		assertTrue(t1.getNome() instanceof String);
		assertEquals("Emilio",t1.getNome());
	}

	@Test
	@DisplayName ("Test che verifica il cognome")
	void testGetCognome() {
		assertNotNull(t2.getCognome());
		assertTrue(t2.getCognome() instanceof String);
		assertEquals("Ascia",t2.getCognome());
	}

	@Test
	@DisplayName ("Test che verifica il numeroTelefonico")
	void testGetNumeroTelefonico() {
		assertNotNull(t3.getNumeroTelefonico());
		assertTrue(t3.getNumeroTelefonico() instanceof String);
		assertEquals("3420820604",t3.getNumeroTelefonico());
	}
	
	@Test
	@DisplayName ("Test che verifica l'indirizzo")
	void testGetIndirizzo() {
		assertNotNull(t1.getIndirizzo());
		assertTrue(t1.getIndirizzo() instanceof String);
		assertEquals("Via Giovanni dalle bande nere",t1.getIndirizzo());
	}
	

	@Test
	@DisplayName ("Test per l'inserimento di un ContattoConIndirizzo in rubrica")
	void testCompareTo() {
		assertNotNull(t1.compareTo(t2));
		assertEquals(1,t1.compareTo(t4)); // Emilio Pizzuto > Andrea Crisci = 1
		assertEquals(-1,t4.compareTo(t1)); // Andrea Crisci < Emilio Pizzuto = -1
		assertEquals(1,t5.compareTo(t2)); // Riccardo Ascia > Marco Ascia = 1
		assertEquals(-1,t2.compareTo(t5)); // Marco Ascia <  Riccardo Ascia = -1
		assertEquals(0,t2.compareTo(t2)); // Marco Ascia = Marco Ascia = 0
	}

}
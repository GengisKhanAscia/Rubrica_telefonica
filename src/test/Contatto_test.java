package test;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upo.rubriche.Contatto;

class Contatto_test {
	
	private Contatto t1;
	private Contatto t2;
	private Contatto t3;
	private Contatto t4;
	private Contatto t5;
	private Contatto t6;
	private Object t7;
	private Contatto Equals;
	
	static int numTest;
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("Questo codice viene eseguito UNA SOLA VOLTA all'inizio dei test");
		numTest = 0;
		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Questo codice viene eseguito UNA SOLA VOLTA alla fine dei test");
		System.out.println("Abbiamo eseguito " + numTest + " test in totale");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Contatto("Emilio","Pizzuto","3347570099");
		t2 = new Contatto("Marco","Ascia","3336793322");
		t3 = new Contatto("Stefano","Crotti","3420820604");
		t4 = new Contatto("Andrea","Crisci","3477324151");
		t5 = new Contatto("Ricardo","Ascia","0110341195");
		t6 = new Contatto(t3,"03213731");
		Equals = new Contatto("Andrea","Crisci","3477324151");
		
	}

	@Test
	@DisplayName ("Test che verifica il primo costruttore di Contatto")
	void testContattoStringStringString() {
		//asserEquals (Object expected, Object actual);
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
	@DisplayName ("Test che controlla che il risultato sia di tipo 'String' ")
	void testToString() {
		assertNotNull(t1.toString());
		assertTrue(t1.toString() instanceof String);
		assertEquals("Emilio	Pizzuto	3347570099", t1.toString()); // Bisogna fare tab per dimostrare l'equals
	}

	@Test
	@DisplayName ("Test per confronto del tipo degli oggetti e dei valori in essi contenuti")
	void testEqualsObject() {
		assertFalse(t4.equals(t7));
		assertTrue(t4.equals(Equals));
		assertFalse(t4.equals(t3));
		
	}

	@Test
	@DisplayName ("Test per l'inserimento di un Contatto in rubrica")
	void testCompareTo() {
		assertNotNull(t1.compareTo(t2));
		assertEquals(1,t1.compareTo(t4)); // Emilio Pizzuto > Andrea Crisci = 1
		assertEquals(-1,t4.compareTo(t1)); // Andrea Crisci < Emilio Pizzuto = -1
		assertEquals(1,t5.compareTo(t2)); // Riccardo Ascia > Marco Ascia = 1
		assertEquals(-1,t2.compareTo(t5)); // Marco Ascia <  Riccardo Ascia = -1
		assertEquals(0,t2.compareTo(t2)); // Marco Ascia = Marco Ascia = 0
	}
	
	@Test
	@DisplayName ("Fake Test per provare @Disable")
	@Disabled
	void soCheNonFunziona() {
		// Non ho ancora implementato questo test, con @Disabled evito che venga eseguito (causando errori che so esserci).
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName ("Fake Test per provare l'assume ")
	void assumeTest () {
		// Un assumption mi permete di disabiitare un metodo in caso si verifichino determinate condizioni.
		assumeTrue(false);
		// Senza l'assunzione il test fallirebbe
		fail("Not yet implemented");
	}

}
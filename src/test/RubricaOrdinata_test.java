package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import upo.rubriche.Contatto;
import upo.rubriche.Rubrica;
import upo.rubriche.RubricaOrdinata;
import upo.rubriche.ContattoConIndirizzo;

class RubricaOrdinata_test {
	private RubricaOrdinata contatti;
	private RubricaOrdinata contatti2;
	private Contatto t1;
	private Contatto t2;
	private Contatto t3ind;
	private Contatto t4;
	String stringContatti = ""; //senza l'inizializzazione stringContatti = NULL 
	static int numTest;
	String parteCognome;
	
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
		contatti = new RubricaOrdinata();
		contatti2 = new RubricaOrdinata();
		t1 = new Contatto("Emilio","Pizzuto","3347570099");
		t2 = new Contatto("Marco","Ascia","3336793322");
		t3ind = new ContattoConIndirizzo("Stefano","Crotti","3420820604","Via Soviet");
		contatti2.add(t1);
		contatti2.add(t2);
		contatti2.add(t3ind);
		stringContatti += t2.toString() + "\n" + t3ind.toString() + "\n" + t1.toString() + "\n";
		parteCognome = "t";
	}

	@Test
	void testAdd() {
		assertEquals(0, contatti.dim());
		contatti.add(t1);
		contatti.add(t2);
		contatti.add(t3ind);
		assertTrue(contatti.presence(t3ind));
		assertEquals(t2.toString() + "\n" + t3ind.toString() + "\n" + t1.toString() + "\n", contatti.toString());
		
	}

	@Test
	void testRubricaOrdinata() {
		assertTrue(contatti instanceof Rubrica);
		assertNotNull(contatti);
		assertEquals(0, contatti.dim());
	}

	@Test
	void testRubricaOrdinataCollectionOfContatto() {
		assertTrue(contatti2 instanceof Rubrica);
		assertNotNull(contatti2);
		assertEquals(3, contatti2.dim());
		assertFalse(contatti2.dim() == 0);
		assertTrue(contatti2.presence(t1));
		assertFalse(contatti2.presence(t4));
	}
	
	// UNICO TEST ERRATO
	@Test
	void testCerca() {
		contatti.add(t1);
		contatti.add(t3ind);
		assertEquals("[Stefano Crotti 3420820604 Via Soviet, Emilio Pizzuto 3347570099]", contatti2.cerca(parteCognome));	// UNICO ERRORE
	}

	@Test
	void testToString() {
		assertNotNull(contatti2.toString());
		assertNotNull(contatti.toString());
		assertEquals("" , contatti.toString());	//Verifico che la rubrica sia effettivamente vuota
		assertEquals(stringContatti, contatti2.toString());
	}

}
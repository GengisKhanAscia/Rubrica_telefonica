package test;

import static org.junit.jupiter.api.Assertions.*;

// import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import upo.rubriche.Contatto;
import upo.rubriche.Rubrica;
import upo.rubriche.ContattoConIndirizzo;

class Rubrica_test {

	private Rubrica contatti;
	private Rubrica contatti2;
	private Contatto t1;
	private Contatto t2;
	private Contatto t3;
	private Contatto t4;
	String stringContatti = ""; //senza l'inizializzazione stringContatti = NULL 
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
		contatti = new Rubrica();
		contatti2 = new Rubrica();
		t1 = new Contatto("Emilio","Pizzuto","3347570099");
		t2 = new Contatto("Marco","Ascia","3336793322");
		t3 = new ContattoConIndirizzo("Stefano","Crotti","3420820604","Via Soviet");
		contatti2.add(t1);
		contatti2.add(t2);
		contatti2.add(t3);
		stringContatti += t1.toString() + "\n" + t2.toString() + "\n" + t3.toString() + "\n";
		
		
		
	}

	@Test
	void testRubrica() {
		assertTrue(contatti instanceof Rubrica);
		assertNotNull(contatti);
		assertEquals(0, contatti.dim());
	}

	@Test
	void testRubricaCollectionOfContatto() {
		assertTrue(contatti2 instanceof Rubrica);
		assertNotNull(contatti2);
		assertEquals(3, contatti2.dim());
		assertFalse(contatti2.dim() == 0);
		assertTrue(contatti2.presence(t1));
		assertFalse(contatti2.presence(t4));
	}

	@Test
	void testToString() {
		assertNotNull(contatti2.toString());
		assertNotNull(contatti.toString());
		assertEquals("" , contatti.toString());	//Verifico che la rubrica sia effettivamente vuota
		assertEquals(stringContatti, contatti2.toString());
	}

	@Test
	void testAdd() {
		assertEquals(0, contatti.dim());
		contatti.add(t1);
		assertEquals(1, contatti.dim());
		assertTrue(contatti.presence(t1));
		assertFalse(contatti.presence(t2));
	}

	@Test
	void testDelete() {
		assertEquals(3, contatti2.dim());
		contatti2.delete("Emilio", "Pizzuto");
		assertEquals(2, contatti2.dim());
		assertFalse(contatti2.presence(t1));
		
		}

	/* @Test	
	 void testDeleteAll() {
		assertEquals(3, contatti2.dim());
		contatti2.deleteAll(contEliminatiFalse);
		assertEquals(2, contatti2.dim());
		contatti2.deleteAll(contEliminatiTrue);
		assertEquals(1, contatti2.dim());
	}
	*/
	

}
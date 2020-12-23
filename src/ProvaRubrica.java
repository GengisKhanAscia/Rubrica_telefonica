import java.util.ArrayList;

import jbook.util.*;
import upo.rubriche.*;

public class ProvaRubrica {
	public static void main(String[] args) {
		int opzione;
		String nome ,cognome, numeroTelefonico, indirizzo, parteCognome, str;
		ArrayList<Contatto> arrayFiltrato = new ArrayList<Contatto>();
		
		// Creazione Rubrica
		Rubrica contatti = new RubricaOrdinata();		
		do {
			System.out.println("\n0 - Esci dal menų\n1 - Aggiungi contatto\n2 - Aggiungi contatto con indirizzo\n3 - Elimina singolo contatto\n4 - Elimina gruppo di contatti\n5 - Filtra parte di cognome\n6 - Stampa rubrica\n\nInserisci l'opzione preferita:");
			 opzione = Input.readInt();
			switch(opzione) {
				case(0):
						System.out.println("Sei uscito correttamente dal menu'.\n");
						break;
				case(1):
						System.out.println("\nInserire il nome del contatto:\n");
						nome = Input.readString();
						System.out.println("\nInserire il cognome del contatto:\n");
						cognome = Input.readString();
						System.out.println("\nInserire il cellulare del contatto:\n");
						numeroTelefonico = Input.readString();
						Contatto cont = new Contatto(nome,cognome,numeroTelefonico);
						
						// Aggiungi contatto
						contatti.add(cont);
						break;
				 case(2):
						System.out.println("\nInserire il nome del contatto:\n");
						nome = Input.readString();
						System.out.println("\nInserire il cognome del contatto:\n");
						cognome = Input.readString();
						System.out.println("\nInserire il cellulare del contatto:\n");
						numeroTelefonico = Input.readString();
						System.out.println("\nInserire l'indirizzo del contatto:\n");
						indirizzo = Input.readString();
						Contatto contIndirizzo = new ContattoConIndirizzo(nome,cognome,numeroTelefonico,indirizzo);
						
						// Aggiungi contatto con indirizzo
						contatti.add(contIndirizzo);
						break;
				case(3):
						System.out.println("\nInserire il nome del contatto:\n");
						nome = Input.readString();
						System.out.println("\nInserire il cognome del contatto:\n");
						cognome = Input.readString();
												
						// Elimina singolo contatto
						contatti.delete(nome,cognome);
						break;
				case(4):
						if(contatti.dim() != 0) {
							System.out.println("\nInserire il numero di contatti da eliminare: \n");
							int num = Input.readInt();
							String[] element = new String[num*2];
							int j = 1;
							for(int i = 0; i < num*2; i += 2) {
								System.out.println("\nInserire il nome del contatto: " + j + "\n");
								nome = Input.readString();
								element[i] = nome;
								System.out.println("\nInserire il cognome del contatto: " + j + "\n");
								cognome = Input.readString();
								element[i+1] = cognome;
								j++;
							}
							// Elimina gruppo di contatti
							contatti.deleteAll(element);
						}
						else{
							System.out.println("\nLa rubrica è vuota : impossibile eliminare ulteriormente\n");
						}
						break;
				case(5):
						System.out.println("\nInserire la parte di cognome da filtrare(NB: caseSensitive!):\n");
						parteCognome = Input.readString();
						arrayFiltrato = ((RubricaOrdinata) contatti).cerca(parteCognome);	// Alternativa senza cast: Rubrica contatti = new RubricaOrdinata();
						if(arrayFiltrato.size() == 0)
							System.out.println("Errore. Nessun contatto contenente " + parteCognome + " trovato.");
						else{
							System.out.println(arrayFiltrato.toString());
						}
						break;
				case(6):
						// Stampa rubrica
						str = contatti.toString();
						System.out.println(str);
						break;
				default:
						System.out.println("\nInserire un'opzione valida !\n");
				}
		} while(opzione != 0);	
	}
}
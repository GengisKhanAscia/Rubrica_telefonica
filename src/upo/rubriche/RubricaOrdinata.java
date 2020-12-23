/**
 * Package che gestisce la <strong> RubricaOrdinata </strong>.
 * 
 * @author Marco Ascia
 * @author Emilio Pizzuto
 */
package upo.rubriche;

/**
 * Package che ci permette di eseguire diverse operazioni con i dati.
 * 
 * @author Marco Ascia
 * @author Emilio Pizzuto
 */
import java.util.*;

/**
 * Package che ci permette di eseguire operazioni sugli ArrayList.
 * 
 * @author Marco Ascia
 * @author Emilio Pizzuto
 */
import java.util.ArrayList;

/**
 * 
 * Classe <strong> RubricaOrdinata </strong> che estende la classe <em> Rubrica </em>, 
 * dalla quale eredita gli oggetti: <em> contatti e MAXDIM </em>.
 * <p>
 * Sovrascrive il  <em> metodo add di Rubrica </em> in modo da mantenere i contatti ordinati lessicograficamente per cognome e, nel caso fossero uguali, per nome.
 *
 * @author Marco Ascia
 * @author Emilio Pizzuto
 */
public class RubricaOrdinata extends Rubrica {
	
	/**
	 * Costruttore <strong> RubricaOrdinata </strong> che eredita gli oggetti della superclasse <em> Rubrica </em>.
	 * 
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public RubricaOrdinata() {	// Potrei lasciare questo metodo vuoto, ma poi RubricaOrdinata dovrei renderla classe astratta
		super();
	}

	/**
	 * Costruttore <strong> RubricaOrdinata </strong> che eredita gli oggetti della superclasse <em> Rubrica </em>.
	 * 
	 * @param contatti Parametro di tipo Collection<Contatto> che serve a salvare al suo interno i vari contatti ordinati lessicograficamente
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public RubricaOrdinata(Collection<Contatto> contatti) {
		super(contatti);
	}

	// Metodi pubblici
	/**
	 * Metodo <strong> add </strong> che aggiunge i contatti inseriti dall'utente nell'oggetto <em> cont </em> di tipo <em> Contatto </em>
	 * 
	 * @param cont Parametro di tipo Contatto che serve a salvare al suo interno i vari contatti
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public void add(Contatto cont) {
		if(this.contatti.size() == MAXDIM) {
			System.out.println("\nLa rubrica è piena!\n");
			return;
		}
		else {
				if(this.contatti.contains(cont)){
					System.out.println("\nIl contatto " + cont.nome + " " + cont.cognome + " è già presente!\n");
					return;
				}
			}
			for(int i = 0;i < this.contatti.size();i++){
				if(this.contatti.get(i).compareTo(cont) > 0){
					this.contatti.add(i, cont);
					System.out.println("\nContatto " + cont.nome + " " + cont.cognome + " inserito correttamente!\n");
					return;	// NON break perché altrimenti esegue anche inserimento in coda!
				}	
			}
			// Inserimento in coda
			this.contatti.add(cont);
			System.out.println("\nContatto " + cont.nome + " " + cont.cognome + " inserito correttamente in coda!\n");
			return;
	}
	
	/**
	 * Metodo <strong> cerca </strong> che filtra i contatti in base a una stringa <em> parteCognome </em> inserita dall'utente
	 * 
	 * @param parteCognome Parametro di tipo <em> String </em> che serve a filtrare i contatti in base al loro cognome 
	 * @return Torna un ArrayList<Contatto> contenente i contatti aventi <em> parteCognome </em> all'interno del loro cognome
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public ArrayList<Contatto> cerca(String parteCognome){
		ArrayList<Contatto> arrayFiltrato = new ArrayList<Contatto>(MAXDIM);
		for(Contatto c: contatti) {
			if(c.getCognome().contains(parteCognome))
				arrayFiltrato.add(c);
		}
		return arrayFiltrato;
	}
}
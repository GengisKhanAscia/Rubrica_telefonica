/**
 * Package che gestisce la <strong> RubricaOrdinata </strong>
 * 
 * @author Marco Ascia
 * @author Emilio Pizzuto
 */
package upo.rubriche;

/**
 * Classe <strong> ContattoConIndirizzo </strong> che estende la classe <em> Contatto </em>, 
 * dalla quale eredita gli oggetti: <em> nome, cognome e numeroTelefonico </em>
 * e permette di specificare un campo (stringa) <em> indirizzo </em>.
 * 
 * @author Marco Ascia
 * @author Emilio Pizzuto
 */
public class ContattoConIndirizzo extends Contatto {
	protected String indirizzo;
	
	// Costruttori
	/**
	 * Costruttore <strong> ContattoConIndirizzo </strong> che eredita gli oggetti della superclasse <em> Contatto </em>.
	 * 
	 * @param nome Parametro di tipo String che identifica il nome del contatto
	 * @param cognome Parametro di tipo String che identifica il cognome del contatto
	 * @param numeroTelefonico Parametro di tipo String che identifica il cellulare del contatto
	 * @param indirizzo Parametro di tipo String che identifica l'indirizzo del contatto
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public ContattoConIndirizzo(String nome, String cognome, String numeroTelefonico, String indirizzo) {
		super(nome, cognome, numeroTelefonico);
		this.indirizzo = indirizzo;
	}
	
	/**
	 * Costruttore <strong> ContattoConIndirizzo </strong> che eredita gli oggetti della superclasse <em> Contatto </em>.
	 * 
	 * @param contatto Parametro di tipo Contatto che identifica <em> nome e cognome </em> del contatto 
	 * @param numeroTelefonico Parametro di tipo String che identifica il cellulare del contatto
	 * @param indirizzo Parametro di tipo String che identifica l'indirizzo del contatto
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public ContattoConIndirizzo(Contatto contatto, String numeroTelefonico, String indirizzo) {
		super(contatto, numeroTelefonico);
		this.indirizzo = indirizzo;
	}
	
	// Getters
	/**
	 * Metodo <strong> getIndirizzo </strong> che ritorna l'indirizzo del <em> Contatto </em>.
	 * 
	 * @return Torna l'indirizzo del <em> Contatto </em>
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	// Metodi pubblici
	@Override
	/**
	 * Metodo <strong> toString </strong> che converte un contatto da tipo <em> Contatto </em> a tipo <em> String </em>
	 * 
	 * @return Torna <em> nome, cognome, numeroTelefonico e indirizzo </em> del contatto convertito a stringa
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	public String toString(){
		return this.nome + "\t" + this.cognome + "\t" + this.numeroTelefonico + "\t" + this.indirizzo;
	}
	
	/**
	 * Metodo <strong> equals </strong> che confronta l'uguaglianza del contatto corrente e quello passato come argomento 
	 * 
	 * @param o Parametro di tipo <em> Object </em> che contiene il contatto da confrontare con il corrente
	 * @return Torna un valore <em> booleano </em> che potrà essere: <br>true - I due contatti sono uguali <br>false - I contatti sono difforme 
	 * @author Marco Ascia
	 * @author Emilio Pizzuto
	 */
	 public boolean equals(Object o){
		if(o instanceof ContattoConIndirizzo){
			if(this.nome.equals(((ContattoConIndirizzo)o).nome) && this.cognome.equals(((ContattoConIndirizzo)o).cognome) && this.numeroTelefonico.equals(((ContattoConIndirizzo)o).numeroTelefonico) && this.indirizzo.contentEquals(((ContattoConIndirizzo)o).indirizzo))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
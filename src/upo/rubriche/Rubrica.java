package upo.rubriche;
import java.util.ArrayList;
import java.util.Collection;

public class Rubrica{
	 protected ArrayList<Contatto> contatti;
	 protected static final int MAXDIM = 5;
	
	//Costruttori
	public Rubrica(){
		this.contatti = new ArrayList<Contatto>(MAXDIM);
	}
	
	public Rubrica(Collection<Contatto> contatti){
		for(Contatto c : contatti)
			this.contatti.add(c);
	}
	
	// Metodi pubblici
	public String toString(){
		String str = new String();
		if(this.contatti.isEmpty()){
			System.out.println("\nLa rubrica è vuota!\n");
			return str;
		}
		for(Contatto c : contatti){
			str += c.toString() + "\n";
		}
		return str;
	}
	
	public void add(Contatto cont) {
		if(this.contatti.size() == MAXDIM) {
			System.out.println("\nLa rubrica è piena!\n");
			return;
		}
		else {
				if(this.contatti.contains(cont)) {
					System.out.println("\nIl contatto è già presente!\n");
					return;
				}
			}
			// Non essendo if a cascata, preferiamo mantenere le return per evitare errori
			this.contatti.add(cont);
			System.out.println("\nContatto inserito correttamente\n");
			return;
	}
	
	public Contatto delete(String nome, String cognome){
		for(Contatto c : contatti){
			if(c.nome.equals(nome) && c.cognome.equals(cognome)){
				this.contatti.remove(c);
				System.out.println("\nIl contatto " + c.nome + " " + c.cognome + " " + c.numeroTelefonico + " " + "è stato eliminato !\n");
				return c;
			}
		}
		System.out.println("\nIl contatto non è presente nella rubrica!\n");
		return null;	
	}
	
 	public Contatto[] deleteAll(String ... elementi) {
 		int flag = 0;
		if(elementi.length == 0){
			System.out.println("\nPassare un contatto da eliminare!\n");
			return null;
		}
		if(elementi.length % 2 != 0){
			System.out.println("\nPassare un numero pari di contatti da eliminare !\n");
			return null;
		}
		else{
			int i = 0;
			while(i < elementi.length) {
				flag = 0;
				for(Contatto c : contatti) {
					if(c.cognome.equals(elementi[i+1]) && c.nome.equals(elementi[i])){
						this.contatti.remove(c);
						flag++;
						System.out.println("\nContatto " + elementi[i] + " " + elementi [i+1] + " eliminato correttamente");
						break;
					}
				}
				if(flag == 0)
					System.out.println("\nContatto " + elementi[i] + " " + elementi [i+1] + " non presente in rubrica!\n");
				i += 2;
			}
		}
		// Mi deve tornare qualcosa di tipo "Array di tipo Contatto", che contiene la rubrica aggiornata
		Contatto [] arrRet = new Contatto[this.contatti.size()];
		arrRet = this.contatti.toArray(arrRet);
		return arrRet;
	}
 	
 	/* Non è necessario implementare un Iterator in questo caso perché Rubrica
 	 ha già una Collection<Contatto> che espone i metodi richiesti da Iterable.	*/ 
 	
 	public int dim()
 	{
 		return this.contatti.size();
 	}
 	
 	public boolean presence(Contatto cont)
 	{
 		return this.contatti.contains(cont) ? true : false;
 	}
 	
}
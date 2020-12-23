package upo.rubriche;

	public class Contatto implements Comparable<Contatto>{
		protected String nome;
		protected String cognome;
		protected String numeroTelefonico;
		
		// Costruttori
		public Contatto(String nome, String cognome, String numeroTelefonico){
			this.nome = nome;
			this.cognome = cognome;
			this.numeroTelefonico = numeroTelefonico;
		}
		
		public Contatto(Contatto contatto, String numeroTelefonico){
			this.nome = contatto.nome;
			this.cognome = contatto.cognome;
			this.numeroTelefonico = numeroTelefonico;		
		}
		
		// Getters
		public String getNome() {
			return nome;
		}

		public String getCognome() {
			return cognome;
		}

		public String getNumeroTelefonico() {
			return numeroTelefonico;
		}

		// Metodi pubblici	
		public String toString(){
			return this.nome + "\t" + this.cognome + "\t" + this.numeroTelefonico;
		}
		
		public boolean equals(Object o){
			if(o instanceof Contatto){
				if(this.nome.equals(((Contatto)o).nome) && this.cognome.equals(((Contatto)o).cognome) && this.numeroTelefonico.equals(((Contatto)o).numeroTelefonico))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		
		// Implementazine metodo astratto dell'interfaccia Comparable<T>
		@Override
		public int compareTo(Contatto o) {
			if(cognome.compareTo(o.cognome) > 0)
				return 1;
			else
			{
				if(cognome.compareTo(o.cognome) < 0)
					return -1;
				else {
					if(nome.compareTo(o.nome) > 0)
						return 1;
					else {
						if(nome.compareTo(o.nome) < 0)
							return -1;
					}
				}
			}
			return 0;
		}
	}
	
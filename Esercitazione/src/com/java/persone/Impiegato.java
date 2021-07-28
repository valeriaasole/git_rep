package com.java.persone;

public class Impiegato extends Persona {
	private String codiceTesserino;
	private int annoAssunzione;
	
	private String nomeUtente;
	private String password;
	
	public Impiegato(String nome, String cognome, char sesso, String indirizzo, String codiceTesserino,
			int annoAssunzione, String nomeUtente, String password) {
		super(nome, cognome, sesso, indirizzo);
		
		this.codiceTesserino = codiceTesserino;
		this.annoAssunzione = annoAssunzione;
		this.nomeUtente = nomeUtente;
		this.password = password;
	}

	public String getCodiceTesserino() {
		return codiceTesserino;
	}

	public int getAnnoAssunzione() {
		return annoAssunzione;
	}
	
	public int modificaCredenziali() {
		if(accesso()) {
			System.out.print("Inserisci un nuovo nome utente: ");
			String s1 = in.next();
			System.out.print("Inserisci nuova password: ");
			String s2 = in.next();
			System.out.print("Conferma Password: ");
			String s3 = in.next();
			
			if(s1.equals("") || s2.equals(""))
				return -2;
			
			if(s1.equals(" ") || s2.equals(" "))
				return -3;
			
			if(!s2.equals(s3))
				return -4;
			
			if(s2.length() < 6)
				return -5;
			
			nomeUtente = s1;
			password = s2;
			return 0;
		}
		else {
			System.out.println("CREDENZIALI ERRATE");
			return -1;
		}
		
	}
	
	private boolean accesso() {
		System.out.print("Inserisci il nome utente: ");
		String user = in.next();
		System.out.print("Inserisci la password: ");
		String pass = in.next();
		
		return (nomeUtente.equals(user) && password.equals(pass)) 
				? true : false;
	}
	
	public boolean stampaCredenziali() {
		if(accesso()) {
			System.out.println("Nome Utente: " +nomeUtente);
			System.out.println("Password : " +password);
			return true;
		}
		else {
			System.out.println("CREDENZIALI ERRATE");
			return false;
		}
		
	}
	
	private String generaCodiceTesserino() {
		return "CP" + Math.round(Math.random()*Math.pow(10, 6));
	}
	
	private int generaAnnoAssunzione() {
		return 2021;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + annoAssunzione;
		result = prime * result + ((codiceTesserino == null) ? 0 : codiceTesserino.hashCode());
		result = prime * result + ((nomeUtente == null) ? 0 : nomeUtente.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Impiegato other = (Impiegato) obj;
		if (annoAssunzione != other.annoAssunzione)
			return false;
		if (codiceTesserino == null) {
			if (other.codiceTesserino != null)
				return false;
		} else if (!codiceTesserino.equals(other.codiceTesserino))
			return false;
		if (nomeUtente == null) {
			if (other.nomeUtente != null)
				return false;
		} else if (!nomeUtente.equals(other.nomeUtente))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = super.toString();
		return s + "Impiegato [codiceTesserino=" + codiceTesserino + ", annoAssunzione=" + annoAssunzione + "]";
	}
	
	

}

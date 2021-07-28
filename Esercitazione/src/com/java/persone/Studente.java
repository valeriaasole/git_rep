package com.java.persone;

public class Studente extends Persona {
	
	private String facolta;
	private final int matricola;
	private int anno;
	
	private static int ultimaMatricola = 10432;
	
	// public Studente() {} NON HA SENSO
	
	public Studente(String nome, String cognome, char sesso, 
			String indirizzo, String facolta) {
		//RICHIAMA DELLA SUPERCLASSE
		// SCEGLIE QUELLO CORRETTO IN BASE ALLA FIRMA
		
		super(nome, cognome, sesso, indirizzo);

		this.facolta = facolta;
		
		matricola = ultimaMatricola++;
		anno = 1;
	}

	public int getMatricola() {
		return matricola;
	}

	public int getAnno() {
		return anno;
	}
	

	public String getFacolta() {
		return facolta;
	}

	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}

	private void setAnno(int anno) {
		this.anno = anno;
	}
	
	public boolean isFuoriCorso() {
		return (anno > 5) ? true : false;
	}
	
	/*
	 VARIABILI DI PERSONA EREDITATE, MA NON VISIBILI PERCHE' PRIVATE
	 
	 MODO 1 -> USO I GETTER (EREDITATI E PUBBLICI)
	 
	public void visualizza() {
		System.out.println("     NOME: " +getNome());
		System.out.println("  COGNOME: " +getCognome());
		System.out.println("    SESSO: " +getSesso());
		System.out.println("INDIRIZZO: " +getIndirizzo());
		System.out.println("MATRICOLA: " +matricola);
		System.out.println("     ANNO: " +anno);
		if(isFuoriCorso())
			System.out.println("(STUDENTE FUORICORSO)");
		else
			System.out.println("(STUDENTE IN CORSO)");
	}
	*/
	
	/*
	 MODO 2 -> PROVO A FREGARLO
	           Uso super come scappatoia accedendo al padre
	           FALLISCO MISERAMENTE
	 
	public void visualizza() {
		System.out.println("     NOME: " +super.getNome());
		System.out.println("  COGNOME: " +super.getCognome());
		System.out.println("    SESSO: " +super.getSesso());
		System.out.println("INDIRIZZO: " +super.getIndirizzo());
		System.out.println("MATRICOLA: " +matricola);
		System.out.println("     ANNO: " +anno);
		if(isFuoriCorso())
			System.out.println("(STUDENTE FUORICORSO)");
		else
			System.out.println("(STUDENTE IN CORSO)");
	}
	
	PROPRIETA - OVERRIDING
	
	public void visualizza() {
		System.out.println("     NOME: " +nome);
		System.out.println("  COGNOME: " +super.nome);
		System.out.println("    SESSO: " +sesso);
		System.out.println("INDIRIZZO: " +indirizzo);
		System.out.println("MATRICOLA: " +matricola);
		System.out.println("     ANNO: " +anno);
		if(isFuoriCorso())
			System.out.println("(STUDENTE FUORICORSO)");
		else
			System.out.println("(STUDENTE IN CORSO)");
	}
	
	*/
	
	public void visualizza() {
		super.visualizza();
		System.out.println("MATRICOLA: " +matricola);
		System.out.println("     ANNO: " +anno);
		if(isFuoriCorso())
			System.out.println("(STUDENTE FUORICORSO)");
		else
			System.out.println("(STUDENTE IN CORSO)");
	}
}

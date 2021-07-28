package com.java.persone;

import java.util.Scanner;

public class Persona {
	protected static Scanner in = new Scanner(System.in);
	
	protected String nome;
	protected String cognome;
	protected char sesso;
	protected String indirizzo;
	
	// public Persona() {}
	
	public Persona(String nome, String cognome, char sesso, 
			String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public char getSesso() {
		return sesso;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public void visualizza() {
		System.out.println("     NOME: " +nome);
		System.out.println("  COGNOME: " +cognome);
		System.out.println("    SESSO: " +sesso);
		System.out.println("INDIRIZZO: " +indirizzo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + sesso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sesso != other.sesso)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", sesso=" + sesso + ", indirizzo=" + indirizzo + "] - ";
	}
	
}


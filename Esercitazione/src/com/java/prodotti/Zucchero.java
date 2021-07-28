package com.java.prodotti;

import com.java.prodotti.categorie.*;
import com.java.prodotti.prodottiprezzati.*;

public class Zucchero extends Prodotto implements ProdottoPrezzato {
	private String iDProdotto;
	private final String sigla;
	
	private double prezzoAlKg;
	private double peso;
	
	private String tipo;

	public Zucchero(CategoriaProdotti categoria, String descrizione, String sigla, double prezzoAlKg,
			double peso, String tipo) {
		super(categoria, descrizione);
		
		this.sigla = sigla;
		this.prezzoAlKg = prezzoAlKg;
		this.peso = peso;
		this.tipo = tipo;
		this.iDProdotto = generaIDProdotto(sigla);
	}
	
	public String getIDProdotto() {
		return iDProdotto;
	}

	public String getSigla() {
		return sigla;
	}

	public double getPrezzoAlKg() {
		return prezzoAlKg;
	}

	public double getPeso() {
		return peso;
	}
	
	public double getPrezzo() {
		return prezzoAlKg * peso;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setPrezzoAlKg(double prezzoAlKg) {
		this.prezzoAlKg = prezzoAlKg;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	private String generaIDProdotto(String sigla) {
		return sigla + Math.round(Math.random()*Math.pow(10, 6));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((iDProdotto == null) ? 0 : iDProdotto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prezzoAlKg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Zucchero other = (Zucchero) obj;
		if (iDProdotto == null) {
			if (other.iDProdotto != null)
				return false;
		} else if (!iDProdotto.equals(other.iDProdotto))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(prezzoAlKg) != Double.doubleToLongBits(other.prezzoAlKg))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zucchero [iDProdotto=" + iDProdotto + ", sigla=" + sigla + ", prezzoAlKg=" + prezzoAlKg + ", peso="
				+ peso + ", tipo=" + tipo + "]";
	}
	
	
}

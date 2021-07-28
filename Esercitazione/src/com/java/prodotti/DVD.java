package com.java.prodotti;

import com.java.prodotti.categorie.*;
import com.java.prodotti.prodottiprezzati.*;

public class DVD extends Prodotto implements ProdottoPrezzato{
	private String iDProdotto;
	private final String sigla;
	
	private double prezzo;
	
	private String titoloFilm;
	private String regista;
	
	public DVD(CategoriaProdotti categoria, String descrizione, String sigla, double prezzo,
			String titoloFilm, String regista) {
		super(categoria, descrizione);
		
		this.sigla = sigla;
		this.prezzo = prezzo;
		this.titoloFilm = titoloFilm;
		this.regista = regista;
		this.iDProdotto = generaIDProdotto(sigla);
	}

	public String getIDProdotto() {
		return iDProdotto;
	}

	public String getSigla() {
		return sigla;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public String getTitoloFilm() {
		return titoloFilm;
	}

	public String getRegista() {
		return regista;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public void setTitoloFilm(String titoloFilm) {
		this.titoloFilm = titoloFilm;
	}
	
	public void setRegsita(String nomeRegista) {
		this.regista = regista;
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
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((regista == null) ? 0 : regista.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((titoloFilm == null) ? 0 : titoloFilm.hashCode());
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
		DVD other = (DVD) obj;
		if (iDProdotto == null) {
			if (other.iDProdotto != null)
				return false;
		} else if (!iDProdotto.equals(other.iDProdotto))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (regista == null) {
			if (other.regista != null)
				return false;
		} else if (!regista.equals(other.regista))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (titoloFilm == null) {
			if (other.titoloFilm != null)
				return false;
		} else if (!titoloFilm.equals(other.titoloFilm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DVD [iDProdotto=" + iDProdotto + ", sigla=" + sigla + ", prezzo=" + prezzo + ", titoloFilm="
				+ titoloFilm + ", regista=" + regista + "]";
	}
	
	

}

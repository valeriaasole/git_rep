package com.java.prodotti;

import java.util.Arrays;

import com.java.prodotti.categorie.*;
import com.java.prodotti.prodottiprezzati.*;

public class CD extends Prodotto implements ProdottoPrezzato {
	private String iDProdotto;
	private final String sigla;
	
	private double prezzo;
	
	private String titoloAlbum;
	private String nomeArtista;
	private String[] elencoCanzoni;
	
	public CD(CategoriaProdotti categoria, String descrizione, String sigla, double prezzo,
			String titoloAlbum, String nomeArtista, String[] elencoCanzoni) {
		super(categoria, descrizione);
		
		this.sigla = sigla;
		this.prezzo = prezzo;
		this.titoloAlbum = titoloAlbum;
		this.nomeArtista = nomeArtista;
		this.elencoCanzoni = elencoCanzoni;
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

	public String getTitoloAlbum() {
		return titoloAlbum;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public String[] getElencoCanzoni() {
		return elencoCanzoni;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public void setTitoloAlbum(String titoloAlbum) {
		this.titoloAlbum = titoloAlbum;
	}
	
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	
	public void setElencoCanzoni(String[] elencoCanzoni) {
		this.elencoCanzoni = elencoCanzoni;
	}

	private String generaIDProdotto(String sigla) {
		return sigla + Math.round(Math.random()*Math.pow(10, 6));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(elencoCanzoni);
		result = prime * result + ((iDProdotto == null) ? 0 : iDProdotto.hashCode());
		result = prime * result + ((nomeArtista == null) ? 0 : nomeArtista.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((titoloAlbum == null) ? 0 : titoloAlbum.hashCode());
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
		CD other = (CD) obj;
		if (!Arrays.equals(elencoCanzoni, other.elencoCanzoni))
			return false;
		if (iDProdotto == null) {
			if (other.iDProdotto != null)
				return false;
		} else if (!iDProdotto.equals(other.iDProdotto))
			return false;
		if (nomeArtista == null) {
			if (other.nomeArtista != null)
				return false;
		} else if (!nomeArtista.equals(other.nomeArtista))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (titoloAlbum == null) {
			if (other.titoloAlbum != null)
				return false;
		} else if (!titoloAlbum.equals(other.titoloAlbum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CD [iDProdotto=" + iDProdotto + ", sigla=" + sigla + ", prezzo=" + prezzo + ", titoloAlbum="
				+ titoloAlbum + ", nomeArtista=" + nomeArtista + ", elencoCanzoni=" + Arrays.toString(elencoCanzoni)
				+ "]";
	}
	
	
}

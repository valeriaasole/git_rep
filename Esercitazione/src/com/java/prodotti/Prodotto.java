package com.java.prodotti;

import com.java.prodotti.categorie.CategoriaProdotti;

public abstract class Prodotto {
	protected final CategoriaProdotti categoria;
	protected String descrizione;
	
	public Prodotto(CategoriaProdotti categoria, String descrizione) {
		this.categoria = categoria;
		this.descrizione = descrizione;
	}

	public CategoriaProdotti getCategoria() {
		return categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
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
		Prodotto other = (Prodotto) obj;
		if (categoria != other.categoria)
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prodotto [categoria=" + categoria + ", descrizione=" + descrizione + "]";
	}
	
	
	
	
	
}

package com.java.supermercato;

import java.util.Arrays;

import com.java.prodotti.prodottiprezzati.*;

public class Carrello {
	private ProdottoPrezzato[] prodottiPrezzati;
	
	private static int capienzaCarrello = 100;
	
	public Carrello() {
		prodottiPrezzati = new ProdottoPrezzato[100];
		// TUTTE GLI ELEMENTI PUNTANO A NULL
	}
	
	public static int getCapienzaCarrello() {
		return capienzaCarrello;
	}

	public boolean aggiungiProdotto(ProdottoPrezzato prodotto){
		for(int i = 0; i<prodottiPrezzati.length; ++i)
			if(prodottiPrezzati[i] == null) {
				prodottiPrezzati[i] = prodotto;
				return true;
			}
		
		return false;
	}
	
	public boolean rimuoviProdotto(String IDProdotto) {
		for(int i = 0; i<prodottiPrezzati.length; ++i)
			if(prodottiPrezzati[i].getIDProdotto().equals(IDProdotto)) {
				prodottiPrezzati[i] = null;
				return true;
			}
		
		return false;
	}
	
	public ProdottoPrezzato prendiProdotto(int posizione) {
		return (posizione < 0 || posizione >= capienzaCarrello) ?
			null : prodottiPrezzati[posizione];
		
		/* if(posizione < 0 || posizione >= capienzaCarrello)
		      return null;
		   else
		      return prodottiPrezzati[posizione];
		 */
	}

	@Override
	public String toString() {
		return "Carrello [prodottiPrezzati=" + Arrays.toString(prodottiPrezzati) + "]";
	}
	
}

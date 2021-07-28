package com.java.test;

import com.java.prodotti.*;
import com.java.prodotti.categorie.*;
import com.java.prodotti.prodottiprezzati.*;
import com.java.supermercato.*;

import com.java.persone.*;

public class Test {
	public static void main(String[] args) {
		ProdottoPrezzato p1 = new Acqua(CategoriaProdotti.BEVANDE, "Acqua", "ACQ",
				0.50, 6, "Acqua Leggermente Frizzante", TipoUnita.BOTTIGLIA, 1.5);
		
		ProdottoPrezzato p2 = new CocaCola(CategoriaProdotti.BEVANDE, "CocaCola", 
				"CCLA", 0.75, 6, "Coca Cola Zero", 
				TipoUnita.BOTTIGLIA, 1.5);
		
		ProdottoPrezzato p3 = new Birra(CategoriaProdotti.BEVANDE, "Birra", 
				"BRR", 0.60, 12, "Birra Moretti", 
				TipoUnita.LATTINA, 0.33);
		
		ProdottoPrezzato p4 = new DVD(CategoriaProdotti.MULTIMEDIA, "DVD", 
				"DVD", 9.90, "Il mondo perduto", "Steven Spielberg");
		
		ProdottoPrezzato p5 = new CD(CategoriaProdotti.MULTIMEDIA, "CD", "CD", 
				7.90, "Album", "Artista", new String[9]);
		
		Carrello c = new Carrello();
		
		Cassa cassa = new Cassa("IPERCOOP", "VIA TALDEI TALI", "MILANO", 4);
		
		Persona dip1 = new Dipendente("Mario", "Rossi",'M', "VIA ....", 
				"user1", "user1Pass");
		
		c.aggiungiProdotto(p1);
		c.aggiungiProdotto(p2);
		c.aggiungiProdotto(p3);
		c.aggiungiProdotto(p4);
		c.aggiungiProdotto(p5);
		
		if(!cassa.statoCassa())
			cassa.accendiCassa(dip1);
		
		Scontrino scontrino = cassa.emettiScontrino(c);
		
		System.out.println(scontrino.stampaScontrino());

		System.out.println("CIAO");
	}

}

package com.java.supermercato;

import java.util.Arrays;

import com.java.persone.*;
import com.java.prodotti.prodottiprezzati.ProdottoPrezzato;

public class Cassa {
	private String nomeNegozio;
	private String indirizzoNegozio;
	private String cittaNegozio;
	
	private String[] usernameCassa = {"admin", "user1", "user2"};
	private String[] password = {"adminPass", "user1Pass", "user2Pass"} ;
	
	private int numeroCassa;
	
	private boolean cassaAccesa = false;
	
	public Cassa(String nomeNegozio, String indirizzoNegozio, String cittaNegozio,
			int numeroCassa) {
		this.nomeNegozio = nomeNegozio;
		this.indirizzoNegozio = indirizzoNegozio;
		this.cittaNegozio = cittaNegozio;
		this.numeroCassa = numeroCassa;
	}

	public String getNomeNegozio() {
		return nomeNegozio;
	}

	public String getIndirizzoNegozio() {
		return indirizzoNegozio;
	}

	public String getCittaNegozio() {
		return cittaNegozio;
	}

	public int getNumeroCassa() {
		return numeroCassa;
	}

	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}

	public void setIndirizzoNegozio(String indirizzoNegozio) {
		this.indirizzoNegozio = indirizzoNegozio;
	}

	public void setCittaNegozio(String cittaNegozio) {
		this.cittaNegozio = cittaNegozio;
	}

	public void setNumeroCassa(int numeroCassa) {
		this.numeroCassa = numeroCassa;
	}
	
	public boolean statoCassa() {
		return cassaAccesa;
	}
	
	public boolean accendiCassa(Persona p) {
		if(p == null)
			return false;
		
		if(!(p instanceof Dipendente))
			return false;
		
		Dipendente dip = (Dipendente) p;
		
		String[] credenziali = dip.getCredenziali();
		
		for(int i = 0; i<usernameCassa.length; ++i) {
			if(credenziali[0].equals(usernameCassa[i]) &&
					credenziali[1].equals(password[i])) {
				cassaAccesa = true;
				return true;
			}
		}
		
		return false;
	}
	
	public void spegniCassa() {
		if(cassaAccesa) 
			cassaAccesa = false;
	}
	
	public Scontrino emettiScontrino(Carrello carrello) {
		if(!cassaAccesa)
			return null;
		
		if(carrello == null)
			return null;
		
		boolean almenoUnProdotto = false;
		int capienzaCarrello = carrello.getCapienzaCarrello();
		
		for(int i = 0; i<capienzaCarrello && !almenoUnProdotto; ++i)
			if(carrello.prendiProdotto(i) != null)
				almenoUnProdotto = true;
		
		if(!almenoUnProdotto)
			return null;
		
		Scontrino s = new Scontrino();
		
		s.aggiungiRiga(nomeNegozio + "\n");
		s.aggiungiRiga(indirizzoNegozio + "\n");
		s.aggiungiRiga(cittaNegozio + "\n");
		s.aggiungiRiga(".................... \n" );
		
		double somma = 0.0;
		
		for(int i = 0; i<capienzaCarrello; ++i) {
			ProdottoPrezzato p = carrello.prendiProdotto(i);
			if(p != null) {
				s.aggiungiRiga(generaRiga(p));
				somma += p.getPrezzo();
			}
		}
		
		s.aggiungiRiga("TOTALE: .................... " +somma +"€ \n");
		s.setScontrinoTerminato(true);
		
		return s;
		
	}
	
	
	private String generaRiga(ProdottoPrezzato p) {
		return p.getIDProdotto() + "...................." + p.getPrezzo() + "€ \n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cassaAccesa ? 1231 : 1237);
		result = prime * result + ((cittaNegozio == null) ? 0 : cittaNegozio.hashCode());
		result = prime * result + ((indirizzoNegozio == null) ? 0 : indirizzoNegozio.hashCode());
		result = prime * result + ((nomeNegozio == null) ? 0 : nomeNegozio.hashCode());
		result = prime * result + numeroCassa;
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + Arrays.hashCode(usernameCassa);
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
		Cassa other = (Cassa) obj;
		if (cassaAccesa != other.cassaAccesa)
			return false;
		if (cittaNegozio == null) {
			if (other.cittaNegozio != null)
				return false;
		} else if (!cittaNegozio.equals(other.cittaNegozio))
			return false;
		if (indirizzoNegozio == null) {
			if (other.indirizzoNegozio != null)
				return false;
		} else if (!indirizzoNegozio.equals(other.indirizzoNegozio))
			return false;
		if (nomeNegozio == null) {
			if (other.nomeNegozio != null)
				return false;
		} else if (!nomeNegozio.equals(other.nomeNegozio))
			return false;
		if (numeroCassa != other.numeroCassa)
			return false;
		if (!Arrays.equals(password, other.password))
			return false;
		if (!Arrays.equals(usernameCassa, other.usernameCassa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cassa [nomeNegozio=" + nomeNegozio + ", indirizzoNegozio=" + indirizzoNegozio + ", cittaNegozio="
				+ cittaNegozio + ", usernameCassa=" + Arrays.toString(usernameCassa) + ", password="
				+ Arrays.toString(password) + ", numeroCassa=" + numeroCassa + ", cassaAccesa=" + cassaAccesa + "]";
	}
	
	
	
}

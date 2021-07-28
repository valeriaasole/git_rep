package com.java.supermercato;

public class Scontrino {
	private String scontrinoStampato = "";
	private boolean scontrinoTerminato;
	
	public Scontrino() {}
		
	public boolean isScontrinoTerminato() {
		return scontrinoTerminato;
	}

	public void setScontrinoTerminato(boolean scontrinoTerminato) {
		this.scontrinoTerminato = scontrinoTerminato;
	}

	public boolean aggiungiRiga(String riga) {
		if(riga == null || riga.isEmpty())
			return false;
		
		scontrinoStampato += riga;
		return true;
	}
	
	public String stampaScontrino() {
		if(!scontrinoTerminato)
			return null;
		
		return scontrinoStampato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scontrinoStampato == null) ? 0 : scontrinoStampato.hashCode());
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
		Scontrino other = (Scontrino) obj;
		if (scontrinoStampato == null) {
			if (other.scontrinoStampato != null)
				return false;
		} else if (!scontrinoStampato.equals(other.scontrinoStampato))
			return false;
		return true;
	}
	
	
	
	
}

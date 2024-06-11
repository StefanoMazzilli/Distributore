package org.generation.italy.model;

public class Bevanda extends Prodotto{
	private boolean zuccherata;
	
	public Bevanda (String nome, double costo, int qnt, boolean zuccherata) {
		super (nome, costo, qnt);
		this.zuccherata=zuccherata;
	}

	public boolean isZuccherata() {
		return zuccherata;
	}

	public void setZuccherata(boolean zuccherata) {
		this.zuccherata = zuccherata;
	}
	
}

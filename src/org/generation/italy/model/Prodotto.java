package org.generation.italy.model;

public class Prodotto {
	protected String nome;
	protected double costo;
	protected int qnt;
	
	public Prodotto (String nome, double costo, int qnt) {
		this.nome = nome;
		this.costo = costo;
		this.qnt = qnt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
}

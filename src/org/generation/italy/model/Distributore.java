package org.generation.italy.model;

import java.util.ArrayList;

public class Distributore {
	private double credito;
	private ArrayList<Prodotto> elencoProdotti = new ArrayList<Prodotto>();
	
	public Distributore () {
		credito=0;
		elencoProdotti.add(new Bevanda ("Coca Cola", 2.50, 20, true));
		elencoProdotti.add(new Bevanda ("Fanta", 2.00, 2, true));
		elencoProdotti.add(new Bevanda ("Caffè", 1.20, 40, false));
		elencoProdotti.add(new Snack ("Kinder Bueno", 1.80, 25, 50));
		elencoProdotti.add(new Snack ("Oreo", 2.00, 25, 50));
		elencoProdotti.add(new Snack ("Kinder Cereali", 0.80, 25, 40));
	}
	
	public void inserisciMoneta(double moneta) {
		//controllo che la moneta inserita sia accettabile
		if (moneta==0.10||moneta==0.20||moneta==0.50||moneta==1||moneta==2) {
			//aggiorno il credito
			credito=credito+moneta;
		} else {
			//caso in cui la moneta non va bene
			System.out.println("Moneta non valida");
		}
	}
	
	public void erogaProdotto(int nrProdotto) {
		Prodotto prodotto;
		
		//controllo che abbia inserito un numero valido
		if (nrProdotto<0||nrProdotto>=elencoProdotti.size()) {
			System.out.println("Inserimento prodotto da erogare non valido!");
		} else {
			//estraggo il prodotto selezionato dalla lista prodotti
			prodotto=elencoProdotti.get(nrProdotto);
			
			//controllo che il credito sia sufficiente
			if (credito>=prodotto.getCosto()) {
				//controllo che la quantità sia maggiore di zero
				if (prodotto.qnt == 0) {
					System.out.println("Il prodotto inserito non è più disponibile!");
				} else {
					//il prodotto è presente nel distributore
					//ora controllo cosa è il prodotto inserito dall'utente

					if (prodotto instanceof Bevanda) {

						//il prodotto è una bevanda
						String messaggio = "Bevanda " + prodotto.getNome() + " erogata correttamente - tipologia: "
								+ (((Bevanda) prodotto).isZuccherata() ? "zuccherata" : "non zuccherata");
						System.out.println(messaggio);
						//aggiorno il credito del distributore
						credito = credito - prodotto.getCosto();
						//aggiorno la quantità
						int qnt = prodotto.getQnt()-1;
						prodotto.setQnt(qnt);
						elencoProdotti.set(nrProdotto, prodotto);
					} else {
						
						//il prodotto è uno snack
						String messaggio = "Snack " + prodotto.nome + " erogato correttamente - grammi: "+((Snack)prodotto).getGrammi();
						System.out.println(messaggio);
						//aggiorno il credito del distributore
						credito = credito - prodotto.getCosto();
						//aggiorno la quantità
						int qnt = prodotto.getQnt()-1;
						prodotto.setQnt(qnt);
						elencoProdotti.set(nrProdotto, prodotto);
					}
				}
			} else {
				System.out.println("Credito insufficiente!");
			}
		}
	}
	
	public void visualizzaProdotti() {
		double prezzo;
		//scorro tutti i prodotti nell'elenco con un ciclo for
		for (int i = 0; i < elencoProdotti.size(); i++) {
			//estraggo il prodotto i-esimo
			Prodotto p=elencoProdotti.get(i);
			prezzo=p.getCosto();
			//controllo se il prodotto è una bevanda o uno snack
			if (p instanceof Bevanda) {
				System.out.println("[("+i+") Bevanda: "+p.getNome()+" - Costo: "+String.format("%.2f", prezzo)+
						"€ - Quantità: "+p.getQnt()+" - Tipologia: "+(((Bevanda)p).isZuccherata()?"zuccherata":"non zuccherata")+"]");
			} else {
				System.out.println("[("+i+") Snack: "+p.getNome()+" - Costo: "+String.format("%.2f", prezzo)+
						"€ - Quantità: "+p.getQnt()+" - Grammi: "+((Snack)p).getGrammi()+"]");
			}
		}
	}
	
	public void erogaResto () {
		System.out.println("Resto erogato: "+String.format("%.2f", credito)+"€");
		credito=0;
	}

	public double getCredito() {
		return credito;
	}
	
	
}

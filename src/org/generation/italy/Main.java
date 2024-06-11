package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Distributore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variabili
		String scelta = new String();
		double credito;
		double moneta;
		int nrProdotto;
		Distributore d = new Distributore();
		Scanner sc= new Scanner(System.in);
		
		do {
			d.visualizzaProdotti();
			credito=d.getCredito();
			System.out.println("Credito: "+String.format("%.2f", credito)+"€");
			System.out.println("\n\n  --- SELEZIONARE L'AZIONE DA SVOLGERE ---");
			System.out.println("1) Inserire moneta\n2) Selezione prodotto da erogare\n3) Erogazione resto\n4) Esci");
			scelta=sc.nextLine();
			
			//svolgo tutte le opzioni
			switch (scelta) {
			case "1":
				System.out.println("Il distributore accetta solo monete da: 10 cent; 20 cent; 50 cent; 1 euro; 2 euro");
				
				//controllo l'inserimento della moneta
				do {
					moneta = 0;
					System.out.print("\nInserire la moneta: ");
					try {
						moneta = Double.parseDouble(sc.nextLine());
					} catch (Exception e) {
						System.err.println("Inserimento non valido!");
					}
				} while (moneta<=0);
				//inserisco la moneta nel distributore
				d.inserisciMoneta(moneta);
				break;
			case "2":
				System.out.print("Selezionare il prodotto da erogare: ");
				
				//controllo l'inserimento del prodotto da erogare
				try {
					nrProdotto=Integer.parseInt(sc.nextLine());
					d.erogaProdotto(nrProdotto);
				} catch (Exception e) {
					System.err.println("ERRORE! Inserimento non valido!");
				}
				break;
			case "3":
				d.erogaResto();
				break;
			case "4":
				String risposta=new String();
				//prima che vada via controllo se ha ritirato il resto
				if (d.getCredito()>0) {
					//gli ricordo di ritirare il resto
					System.out.println("ATTENZIONE! Il resto non è stato ancora ritirato."
							+ "\nDesisderi ritirarlo ora?");
					risposta=sc.nextLine().toLowerCase();
					//controllo che la risposta abbia senso
					while (!risposta.equals("si")&&!(risposta.equals("sì"))&&!(risposta.equals("no"))) {
						System.out.println("Scusa, non ho capito. Puoi ripetere?");
						risposta=sc.nextLine();
					}
					if (risposta.subSequence(0, 1).equals("s")) 
						d.erogaResto();
				}
				System.out.println("\nArrivederci!");
				break;
			default:
				System.out.println("Inserimento non valido!");
			}
			System.out.println("\nPremere INVIO per continuare");
			sc.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n");
		} while (!scelta.equals("4"));
		
		sc.close();
	}//fine Main

}//fine classe

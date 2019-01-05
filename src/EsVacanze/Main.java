package EsVacanze;

import java.util.Scanner;
import java.io.*;

public class Main {

	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Metodi mio = new Metodi();
		int menu = 0;
		String nomeGiocatore;

		System.out.println("Nome giocatore: ");
		nomeGiocatore = sc.nextLine();
		
		do {
			System.out.println("0. Termina programma");
			System.out.println("1. Visualizza classifica giocatori");
			System.out.println("2. Inizia nuova partita");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 0:
				System.out.println("Programma terminato con successo");
				System.exit(0);
				break;
				
			case 1:
				try {
					FileReader file = new FileReader("classifica.txt");
					int next;
					
					do {
						next = file.read();
						
						if (next != -1) {
							char nextc = (char) next;
							System.out.print(nextc);
						}
					}while(next != -1);
					
					file.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("");
				break;
				
			case 2:
				mio.generaCampoDiGioco(nomeGiocatore);
				break;
			}
		} while (menu != 0);
	}

}

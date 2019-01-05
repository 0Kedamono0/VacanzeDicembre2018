package NormalEsVacanze;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Archivio {

	Scanner sc = new Scanner(System.in);

	public void zigZag() {
		int[] valori = new int[10];

		System.out.print("Ecco l'array iniziale: ");
		for (int q = 0; q < valori.length; q++) {
			valori[q] = ThreadLocalRandom.current().nextInt(20);
			System.out.print(valori[q] + " ");
		}
		System.out.println("");
		System.out.print("Ecco l'array finale: ");
		for (int i = 0; i < 5; i++) {
			int j = 9 - i;
			System.out.print(valori[i] + " " + valori[j] + " ");
		}
	}

	public void doppioUnoDellAltro() {

		int[] valori = new int[10];
		int cont = 0;

		System.out.print("Ecco l'array iniziale: ");
		for (int q = 0; q < valori.length; q++) {
			valori[q] = ThreadLocalRandom.current().nextInt(14);
			System.out.print(valori[q] + " ");
		}
		System.out.println("");
		for (int i = 0; i < valori.length; i++) {
			for (int j = i + 1; j < valori.length - 1; j++) {
				if (valori[i] == (valori[j] / 2)) {
					cont++;
				} else if (valori[i] == (valori[j] * 2)) {
					cont++;
				} else if ((valori[i] * 2) == valori[j]) {
					cont++;
				} else if ((valori[i] / 2) == valori[j]) {
					cont++;
				}
			}
		}
		if (cont > 0) {
			System.out.println("Doppio uno dell'altro presente");
		} else {
			System.out.println("No.");
		}
	}

	public void esRettangolo() {
		System.out.print("Inserisci base: ");
		int base = sc.nextInt();
		sc.nextLine();
		System.out.print("Inserisci altezza: ");
		int altezza = sc.nextInt();
		sc.nextLine();
		Rettangolo r = new Rettangolo(base, altezza);
		// System.out.println("Perimetro: " + r.perimetro(base, altezza));
		// System.out.println("Area: " + r.area(base, altezza));
		System.out.println("");

		System.out.print("Inserisci base: ");
		int base2 = sc.nextInt();
		sc.nextLine();
		System.out.print("Inserisci altezza: ");
		int altezza2 = sc.nextInt();
		sc.nextLine();
		Rettangolo r1 = new Rettangolo(base2, altezza2);
		// System.out.println("Perimetro: " + r1.perimetro(base2, altezza2));
		// System.out.println("Area: " + r1.area(base2, altezza2));
		System.out.println("");

		System.out.print("Inserisci base: ");
		int base3 = sc.nextInt();
		sc.nextLine();
		System.out.print("Inserisci altezza: ");
		int altezza3 = sc.nextInt();
		sc.nextLine();
		Rettangolo r2 = new Rettangolo(base3, altezza3);
		// System.out.println("Perimetro: " + r2.perimetro(base3, altezza3));
		// System.out.println("Area: " + r2.area(base3, altezza3));
		System.out.println("");

		int ris1 = r.area(base, altezza) + r1.area(base2, altezza2) + r2.area(base3, altezza3);
		System.out.println("Area totale: " + ris1);
		int ris2 = r.perimetro(base, altezza) + r1.perimetro(base2, altezza2) + r2.perimetro(base3, altezza3);
		System.out.println("Perimetro totale: " + ris2);
		System.out.println("");

		System.out.println("Vuoi cambiare valori di un rettangolo? (s/n)");
		if (sc.nextLine().equalsIgnoreCase("s")) {
			System.out.print("Inserisci base: ");
			base2 = sc.nextInt();
			sc.nextLine();
			System.out.print("Inserisci altezza: ");
			altezza2 = sc.nextInt();
			sc.nextLine();
			r1.ridimensiona(base2, altezza2);
			System.out.println("Perimetro: " + r1.perimetro(base2, altezza2));
			System.out.println("Area: " + r1.area(base2, altezza2));
			System.out.println("");
			int ris3 = r.area(base, altezza) + r1.area(base2, altezza2) + r2.area(base3, altezza3);
			System.out.println("Area totale: " + ris3);
			int ris4 = r.perimetro(base, altezza) + r1.perimetro(base2, altezza2) + r2.perimetro(base3, altezza3);
			System.out.println("Perimetro totale: " + ris4);
		} else {
			System.out.println("Ok. ");
		}
	}

	public void esLampadina() {

		System.out.print("Inserisci numero di rottura (1-6): ");
		int nRottura = sc.nextInt();

		Lampadina l = new Lampadina(nRottura);

		int scelta = 0;
		do {
			System.out.println("0. Termina esecuzione");
			System.out.println("1. Visualizza stato");
			System.out.println("2. Accendi-Spegni");
			scelta = sc.nextInt();
			sc.nextLine();

			switch (scelta) {

			case 0:
				
				break;
			
			case 1:
				System.out.println(l.getStatus());
				System.out.println("");
				break;

			case 2:
				l.switchOnOff();
				break;
			}
		} while (scelta != 0);
		System.out.println("");
		/*
		 * System.out.println("-----------------");
		 * System.out.println("Situazione iniziale: " + l.getStatus()); l.switchOnOff();
		 * System.out.println("Situazione 1: " + l.getStatus()); l.switchOnOff();
		 * System.out.println("Situazione 2: " + l.getStatus()); l.switchOnOff();
		 * System.out.println("Situazione 3: " + l.getStatus()); l.switchOnOff();
		 * System.out.println("Situazione 4: " + l.getStatus()); l.switchOnOff();
		 * System.out.println("Situazione 5: " + l.getStatus()); l.switchOnOff();
		 * System.out.println("Situazione 6: " + l.getStatus());
		 * System.out.println("-----------------");
		 */
	}
	
	public void esInterruttore() {
		
		System.out.println("Vuoi che il primo interruttore spenga e il secondo accenda?");
		String risposta = sc.nextLine();
		if (risposta.equalsIgnoreCase("s")) {
			Interruttore a = new Interruttore();
			Interruttore b = new Interruttore(risposta);
			Lampadina l = new Lampadina(a, b);
			
			int scelta = 0;
			do {
				System.out.println("0. Termina esecuzione");
				System.out.println("1. Visualizza stato");
				System.out.println("2. Spegni");
				System.out.println("3. Accendi");
				scelta = sc.nextInt();
				sc.nextLine();

				switch (scelta) {

				case 0:
					
					break;
				
				case 1:
					System.out.println(l.getStatus());
					System.out.println("");
					break;
					
				case 2:
					l.switchOnOff2(a, b, scelta);
					break;
					
				case 3:
					l.switchOnOff2(a, b, scelta);
					break;
				}
			} while (scelta != 0);
		}
	}
	
	public void esLibro() {
		int nPagine = ThreadLocalRandom.current().nextInt(100, 600);
		
		Libro b = new Libro(nPagine);
		System.out.println(b.toString());
		System.out.println("");
		Libro v = new Vocabolario(nPagine);
		v.definitionMessage();
		System.out.println("");
		
	}
}

package NormalEsVacanze;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Archivio obj = new Archivio();
		int menu = 0;

		do {
			System.out.println("0. Termina programma");
			System.out.println("1. Stampa array a zig zag");
			System.out.println("2. Dice se un numero è doppio dell'altro in array");
			System.out.println("3. Rettangolo");
			System.out.println("4. Lampadina");
			System.out.println("5. Interruttore");
			System.out.println("6. Libro");

			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 0:
				System.out.println("Programma terminato con successo!");
				System.exit(0);
				break;

			case 1:
				obj.zigZag();
				System.out.println("");
				System.out.println("");
				break;

			case 2:
				obj.doppioUnoDellAltro();
				System.out.println("");
				break;

			case 3:
				obj.esRettangolo();
				System.out.println("");
				break;

			case 4:
				obj.esLampadina();
				break;

			case 5:
				obj.esInterruttore();
				break;

			case 6:
				obj.esLibro();
				break;

			}

		} while (menu != 0);
	}

}

package EsVacanze;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Metodi {

	Scanner sc = new Scanner(System.in);
	static int counter = 0;
	static int counter2 = 0;

	public void showMat(String campoDiGioco[][]) {

		for (int i = 0; i < campoDiGioco.length; i++) {
			for (int k = 0; k < campoDiGioco.length; k++) {
				if (campoDiGioco[i][k] == null) {
					campoDiGioco[i][k] = " ";
				}
				System.out.print(campoDiGioco[i][k] + "|");

			}
			System.out.println("");
		}
	}

	public void generaCampoDiGioco(String nomeGiocatore) {

		String campoDiGioco[][] = new String[15][15];
		int riga;
		int colonna;
		int indice = 1;
		int indice2 = 10;
		boolean test = true;

		System.out.println("Adesso posiziona le 10 navi.");

		for (int j = 0; j < 10; j++) {
			do {
				System.out.println("Nave " + indice);
				try {
					do {
						System.out.print("Inserisci riga (da 1 a 15): ");
						riga = sc.nextInt();
						sc.nextLine();
					} while (riga < 1 || riga > 15);
				} catch (Exception e) {
					System.out.println("Errore: " + e);
					return;
				}
				try {
					do {
						System.out.print("Inserisci colonna (da 1 a 15): ");
						colonna = sc.nextInt();
						sc.nextLine();
					} while (colonna < 1 || colonna > 15);
				} catch (Exception e) {
					System.out.println("Errore: " + e);
					return;
				}
				riga--;
				colonna--;

				checkNavi(campoDiGioco, riga, colonna);

				if (!checkNavi(campoDiGioco, riga, colonna)) {
					System.out.println("La nave tocca uno spigolo o è affiancata da un'altra nave. Ritenta.");
				} else if (campoDiGioco[riga][colonna] == "N") {
					System.out.println("Non puoi sovrascrivere la posizione della nave! Ritenta.");
				} else {
					System.out.println("Nave aggiunta! ");
				}

			} while (!checkNavi(campoDiGioco, riga, colonna) || campoDiGioco[riga][colonna] == "N");

			campoDiGioco[riga][colonna] = "N";

			indice++;
		}

		System.out.println("");

		showMat(campoDiGioco);

		System.out.println("");
		System.out.println("Calcolatore - posizionando navi...");
		System.out.println("");
		for (int q = 0; q < 10; q++) {
			int riga2;
			int colonna2;
			do {
				riga2 = ThreadLocalRandom.current().nextInt(0, 14);
				colonna2 = ThreadLocalRandom.current().nextInt(0, 14);

				checkNavi2(campoDiGioco, riga2, colonna2);

			} while (!checkNavi2(campoDiGioco, riga2, colonna2) || campoDiGioco[riga2][colonna2] == "N"
					|| campoDiGioco[riga2][colonna2] == "C");

			campoDiGioco[riga2][colonna2] = "C";
		}
		indice = 10;
		showMat(campoDiGioco);

		System.out.println("");

		do {
			System.out.println("Turno " + nomeGiocatore + " - ");
			try {
				do {
					System.out.print("Inserisci riga (da 1 a 15): ");
					riga = sc.nextInt();
					sc.nextLine();
				} while (riga < 1 || riga > 15);
			} catch (Exception e) {
				System.out.println("Errore: " + e);
				return;
			}

			try {
				do {
					System.out.print("Inserisci colonna (da 1 a 15): ");
					colonna = sc.nextInt();
					sc.nextLine();
				} while (colonna < 1 || colonna > 15);
			} catch (Exception e) {
				System.out.println("Errore: " + e);
				return;
			}
			riga--;
			colonna--;

			if (campoDiGioco[riga][colonna] == " ") {
				campoDiGioco[riga][colonna] = "O";
				System.out.println("Mancato! ");
				System.out.println("");
			} else if (campoDiGioco[riga][colonna] == "C") {
				campoDiGioco[riga][colonna] = "X";
				System.out.println("Colpito e affondato! ");
				indice2--;
				System.out.println("");
			} else if (campoDiGioco[riga][colonna] == "O") {
				System.out.println("Mancato ancora! ");
				System.out.println("");
			}

			int riga3 = ThreadLocalRandom.current().nextInt(0, 14);
			int colonna3 = ThreadLocalRandom.current().nextInt(0, 14);

			System.out.println("");
			System.out.println("Turno Calcolatore - Mossa (" + riga3 + ", " + colonna3 + ")");

			if (campoDiGioco[riga3][colonna3] == "N") {
				campoDiGioco[riga3][colonna3] = "X";
				System.out.println("Colpito e affondato! ");
				indice--;
			} else if (campoDiGioco[riga3][colonna3] == " ") {
				campoDiGioco[riga3][colonna3] = "O";
				System.out.println("Mancato! ");
			} else if (campoDiGioco[riga3][colonna3] == "O") {
				System.out.println("Mancato ancora! ");
			}

			System.out.println("");
			showMat(campoDiGioco);
			System.out.println("");
			System.out.println("Il giocatore ha ancora " + indice + " navi/e");
			System.out.println("Il calcolatore ha ancora " + indice2 + " navi/e");
			System.out.println("");

			if (indice == 0) {
				System.out.println("Il calcolatore ha vinto!");
				test = false;
				System.out.println("");
				try {
					FileWriter vinci1 = new FileWriter("classifica.txt");
					String vinc1 = "Calcolatore";
					String vincc1 = nomeGiocatore;
					counter++;
					
					for (int i = 0; i < vinc1.length(); i++) {
						vinci1.write(vinc1.charAt(i));
					}
					vinci1.write(": " + counter);
					
					for (int i = 0; i < vincc1.length(); i++) {
						vinci1.write(vincc1.charAt(i));
					}
					vinci1.write(": " + counter2);
					
					vinci1.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (indice2 == 0) {
				System.out.println(nomeGiocatore + " ha vinto!");
				test = false;
				System.out.println("");
				try {
					FileWriter vinci2 = new FileWriter("classifica.txt");
					String vinc2 = nomeGiocatore;
					String vincc2 = "Calcolatore";
					counter2++;
					
					for (int i = 0; i < vinc2.length(); i++) {
						vinci2.write(vinc2.charAt(i));
					}
					vinci2.write(": " + counter2);
					vinci2.write('\n');
					for (int i = 0; i < vincc2.length(); i++) {
						vinci2.write(vincc2.charAt(i));
					}
					vinci2.write(": " + counter);
					
					vinci2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} while (test);
	}

	public boolean checkNavi(String campoDiGioco[][], int riga, int colonna) {
		try {
			if (campoDiGioco[riga - 1][colonna - 1] == "N") {
				return false;
			} else if (campoDiGioco[riga + 1][colonna + 1] == "N") {
				return false;
			} else if (campoDiGioco[riga][colonna + 1] == "N") {
				return false;
			} else if (campoDiGioco[riga + 1][colonna] == "N") {
				return false;
			} else if (campoDiGioco[riga - 1][colonna] == "N") {
				return false;
			} else if (campoDiGioco[riga][colonna - 1] == "N") {
				return false;
			} else if (campoDiGioco[riga - 1][colonna + 1] == "N") {
				return false;
			} else if (campoDiGioco[riga + 1][colonna - 1] == "N") {
				return false;
			}
		} catch (Exception e) {

		}
		return true;
	}

	public boolean checkNavi2(String campoDiGioco[][], int riga, int colonna) {
		try {
			if (campoDiGioco[riga - 1][colonna - 1] == "N" || campoDiGioco[riga - 1][colonna - 1] == "C") {
				return false;
			} else if (campoDiGioco[riga + 1][colonna + 1] == "N" || campoDiGioco[riga + 1][colonna + 1] == "C") {
				return false;
			} else if (campoDiGioco[riga][colonna + 1] == "N" || campoDiGioco[riga][colonna + 1] == "C") {
				return false;
			} else if (campoDiGioco[riga + 1][colonna] == "N" || campoDiGioco[riga + 1][colonna] == "C") {
				return false;
			} else if (campoDiGioco[riga - 1][colonna] == "N" || campoDiGioco[riga - 1][colonna] == "N") {
				return false;
			} else if (campoDiGioco[riga][colonna - 1] == "N" || campoDiGioco[riga][colonna - 1] == "C") {
				return false;
			} else if (campoDiGioco[riga - 1][colonna + 1] == "N" || campoDiGioco[riga - 1][colonna + 1] == "C") {
				return false;
			} else if (campoDiGioco[riga + 1][colonna - 1] == "N" || campoDiGioco[riga + 1][colonna - 1] == "C") {
				return false;
			}
		} catch (Exception e) {

		}
		return true;
	}
}

package NormalEsVacanze;

import java.util.concurrent.ThreadLocalRandom;

public class Vocabolario extends Libro {

	private int nDefinizioni;
	
	public Vocabolario(int nPagine) {
		super(nPagine);
		this.nDefinizioni = ThreadLocalRandom.current().nextInt(5000, 10000);
		// TODO Auto-generated constructor stub
	}

	public int getnDefinizioni() {
		return nDefinizioni;
	}

	public void setnDefinizioni(int nDefinizioni) {
		this.nDefinizioni = nDefinizioni;
	}
	
	@Override
	public void definitionMessage() {
		int ris = nDefinizioni / super.getnPagine();
		System.out.println( "Vocabolario - " + super.toString() + ", numero di definizioni: " + nDefinizioni + "\nNumero medio di definizioni per pagina: " + ris);
	}
}

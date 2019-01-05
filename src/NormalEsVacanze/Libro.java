package NormalEsVacanze;

public class Libro {

	private int nPagine;
	
	public Libro(int nPagine) {
		this.nPagine = nPagine;
	}

	public int getnPagine() {
		return nPagine;
	}

	public void setnPagine(int nPagine) {
		this.nPagine = nPagine;
	}

	@Override
	public String toString() {
		return "Libro con numero di pagine: " + nPagine;
	}
	
	public void definitionMessage() {
		
	}
}

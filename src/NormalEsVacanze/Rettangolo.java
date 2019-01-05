package NormalEsVacanze;

public class Rettangolo {
	
	private int base;
	private int altezza;
	
	public Rettangolo(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}

	public int getBase() {
		return base;
	}

	public int getAltezza() {
		return altezza;
	}
	
	public void ridimensiona(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	public int perimetro(int base, int altezza) {
		int p = (base * 2) + (altezza * 2);
		return p;
	}
	
	public int area(int base, int altezza) {
		int a = base * altezza;
		return a;
	}
}

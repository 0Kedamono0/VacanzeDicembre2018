package NormalEsVacanze;

public class Interruttore {
	
	private boolean verifica;
	
	public Interruttore() {
		this.verifica = false;
	}
	
	public Interruttore(String risposta) {
		this.verifica = true;
	}

	public boolean getVerifica() {
		return verifica;
	}

	public void setScegliStato(boolean verifica) {
		this.verifica = verifica;
	}
	
}

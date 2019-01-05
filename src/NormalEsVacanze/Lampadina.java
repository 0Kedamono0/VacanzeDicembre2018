package NormalEsVacanze;

public class Lampadina {

	private enum Status {
		acceso, spento, rotto
	}
	private int nRottura;
	private Status status;

	public Lampadina(int nRottura) {
		this.status = Status.spento;
		this.nRottura = nRottura;
	}
	
	public Lampadina(Interruttore inter1, Interruttore inter2) {
		this.status = Status.spento;
	}

	public int getnRottura() {
		return nRottura;
	}

	public void setnRottura(int nRottura) {
		this.nRottura = nRottura;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void switchOnOff() {
		switch (status) {
		case acceso: 
			if (--this.nRottura < 0) {
						status = Status.rotto;
			} else {
				status = Status.spento;
			}
			break;		
		case spento: 
			if (--this.nRottura < 0) {
					status = Status.rotto;
			} else {
				status = Status.acceso;
			}
			break;
		case rotto:
			break;
		}
	}
	
	public void switchOnOff2(Interruttore a, Interruttore b, int scelta) {
		
		/*if (b.getScegliStato().equals(Lampadina.Status.spento) && scelta == 3) {
			status = Status.acceso;
		}
		/*else {
			status = Status.spento;
		}
		
		if (a.getScegliStato().equals(Status.acceso) && scelta == 2) {
			status = Status.spento;
		}
		else {
			status = Status.acceso;
		}*/
		
		if (b.getVerifica() == true && scelta == 3) {
			status = Status.acceso;
		}
		
		if (a.getVerifica() == false && scelta == 2) {
			status = Status.spento;
		}
		
		/*switch (status) {
		case acceso:
			if (scelta == 2) {
				status = Status.spento;
			}
			else {
				status = Status.acceso;
			}
			break;
			
		case spento:
			if (scelta == 3) {
				status = Status.acceso;
			}
			else {
				status = Status.spento;
			}
			break;
		}*/
	}
}

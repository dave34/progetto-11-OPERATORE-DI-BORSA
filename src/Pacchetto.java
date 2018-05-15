import java.time.LocalDate;

import java.util.Date;

public class Pacchetto {

	//atrributi
	private int codiceIdentificativo;
	private int valoreEuroAcquisto;
	private LocalDate dAcquisto;
	private int valoreEuroVendita=0;
	private LocalDate dVendita=null;
	
	//costruttori
	public Pacchetto(int codice, int valoreIniziale, LocalDate dataIniziale, int valoreFinale,LocalDate dataFinale) {
		this.codiceIdentificativo=codice;
		this.valoreEuroAcquisto=valoreIniziale;
		this.dAcquisto=dataIniziale;
		this.valoreEuroVendita=valoreFinale;
		this.dVendita=dataFinale;
	}
	public Pacchetto (Pacchetto p) {
		setCodiceIdentificativo(p.getCodiceIdentificativo());
		setValoreEuroAcquisto(p.getValoreEuroAcquisto());
		setdAcquisto(p.getdAcquisto());
		setValoreEuroVendita(p.getValoreEuroVendita());
		setdVendita(p.getdVendita());
	}
	//getter e setter
	public int getCodiceIdentificativo() {
		return codiceIdentificativo;
	}
	public void setCodiceIdentificativo(int codiceIdentificativo) {
		this.codiceIdentificativo = codiceIdentificativo;
	}
	public int getValoreEuroAcquisto() {
		return valoreEuroAcquisto;
	}
	public void setValoreEuroAcquisto(int valoreEuroAcquisto) {
		this.valoreEuroAcquisto = valoreEuroAcquisto;
	}
	
	
	public int getValoreEuroVendita() {
		return valoreEuroVendita;
	}
	
	public void setValoreEuroVendita(int valoreEuroVendita) {
		this.valoreEuroVendita = valoreEuroVendita;
	}
	
	public LocalDate getdAcquisto() {
		return dAcquisto;
	}
	
	public void setdAcquisto(LocalDate dAcquisto) {
		this.dAcquisto = dAcquisto;
	}
	
	public LocalDate getdVendita() {
		return dVendita;
	}
	
	public void setdVendita(LocalDate dVendita) {
		this.dVendita = dVendita;
	}
	//altri metodi
	/**to string che verifica se il pacchetto è stato venduto o meno e restituisce la stringa con i vari attributi */
	public String toString() {
		String risultato;
		if (getdVendita()!=null) {
			return risultato="codice: "+getCodiceIdentificativo()+" pagato: "+getValoreEuroAcquisto()+" il: "+getdAcquisto()+" venduto: "+getValoreEuroVendita()+" il: "+getdVendita();
		}	
		else {
		return risultato="codice: "+getCodiceIdentificativo()+" pagato: "+getValoreEuroAcquisto()+" il: "+getdAcquisto();
		}
	}
	
	
	
}

import java.io.Serializable;
import java.time.LocalDate;

public class Pacchetto implements Serializable {

	//atrributi
	private int codiceIdentificativo;
	private int valoreEuroAcquisto;
	private LocalDate dAcquisto;
	private int valoreEuroVendita=0;
	private LocalDate dVendita=null;
	
	//costruttori
	/** fa inserire i dati in un nuovo pacchetto*/
	public Pacchetto(int codice, int valoreIniziale, LocalDate dataIniziale, int valoreFinale,LocalDate dataFinale) {
		this.codiceIdentificativo=codice;
		this.valoreEuroAcquisto=valoreIniziale;
		this.dAcquisto=dataIniziale;
		this.valoreEuroVendita=valoreFinale;
		this.dVendita=dataFinale;
	}
	/**inserisci un pacchetto e ne crea uno nuovo uguale*/
	public Pacchetto (Pacchetto p) {
		setCodiceIdentificativo(p.getCodiceIdentificativo());
		setValoreEuroAcquisto(p.getValoreEuroAcquisto());
		setdAcquisto(p.getdAcquisto());
		setValoreEuroVendita(p.getValoreEuroVendita());
		setdVendita(p.getdVendita());
	}
	public Pacchetto()
	{
		setCodiceIdentificativo(0);
		setValoreEuroAcquisto(0);
		setdAcquisto(null);
		setValoreEuroVendita(0);
		setdVendita(null);
	}
	
	//getter e setter
	/**ritorna il codice identificativo del pacchetto*/
	public int getCodiceIdentificativo() {
		return codiceIdentificativo;
	}
	/**setta il codice identificativo del pacchetto*/
	public void setCodiceIdentificativo(int codiceIdentificativo) {
		this.codiceIdentificativo = codiceIdentificativo;
	}
	/**ritorna il prezzo d acquisto del pacchetto*/
	public int getValoreEuroAcquisto() {
		return valoreEuroAcquisto;
	}
	/**setta il prezzo d acquisto del pacchetto*/
	public void setValoreEuroAcquisto(int valoreEuroAcquisto) {
		this.valoreEuroAcquisto = valoreEuroAcquisto;
	}
	
	/**ritorna il prezzo di vendita del pacchetto*/
	public int getValoreEuroVendita() {
		return valoreEuroVendita;
	}
	/**setta il prezzo di vendita del pacchetto*/
	public void setValoreEuroVendita(int valoreEuroVendita) {
		this.valoreEuroVendita = valoreEuroVendita;
	}
	/**ritorna la data di acquisto del pacchetto*/
	public LocalDate getdAcquisto() {
		return dAcquisto;
	}
	/**setta la data di acquisto del pacchetto*/
	public void setdAcquisto(LocalDate dAcquisto) {
		this.dAcquisto = dAcquisto;
	}
	/**ritorna la data di vendita del pacchetto*/
	public LocalDate getdVendita() {
		return dVendita;
	}
	/**setta la data di vendita del pacchetto*/
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
	/**
		mostra come output solo il codice identificativo
	 */
	public String toStringh() {
		String risultato="codice:"+getCodiceIdentificativo();
		return risultato;
	}
	
}

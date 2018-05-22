import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.synth.SynthSeparatorUI;
/**
 * La classe Ordinatore rappresenta un ordinatore. Serve per ordinare una serie di elementi in ordine crescente o decrescente
 * 
 * @author Davide Carizzoni
 * @version 1.0
 */
public class Ordinatore 
{	

//	<--------------------------------------------------------------NODI-------------------------------------------------------------------->
	/**
	 * Metodo che consente di scambiare due accessi del laboratorio rispettivamente in posizione 1 e posizione 2
	 * @param laboratorio rappresenta il Laboratorio sul quale si desidera effettuare lo scambio
	 * @param pos1 rappresenta la posizione del primo Accesso da scambiare
	 * @param pos2 rappresenta la posizione del secondo Acesso da scambiare
	 * @throws LaboratorioException eccezione che si verifica quando le posizioni inserite non sono valide
	 */
	//funziona quando non deve fare elimina in testa o elimina in coda
	public static void scambia(Pacchetti p, int pos1, int pos2) throws PacchettiException 
	{
		if(pos1<=0 || pos1>p.getElementi() || pos2<=0 ||pos2>p.getElementi())
			throw new PacchettiException("Posizioni non valide");
		Pacchetto p1,p2;
		p1=new Pacchetto(p.getPacchetto(pos1));
		p2=new Pacchetto(p.getPacchetto(pos1));
	
		p.acquistoPacchetto(p1, pos2);
		p.acquistoPacchetto(p2, pos1);
		
		p.eliminaInPosizione(pos2+2);
		p.eliminaInPosizione(pos1+1);
	}
	
	/**
	 * Metodo che consente di copiare un oggetto Laboratorio.
	 * @param laboratorio rappresenta il Laboratorio di cui si desidera creare una copia
	 * @return la copia del Laboratorio passato come parametro
	 * @throws IOException eccezione che si verifica per errori in fase di lettura o scrittura
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 */
	private static Pacchetti copia(Pacchetti p) throws IOException, ClassNotFoundException 
	{
		Pacchetti p2=new Pacchetti();
		p.salvaPaccchetti("copia.bin");
		p2=p2.caricaPacchetti("copia.bin");
		return p2;
	}
	
	/**
	 * Metodo che permette di ordinare gli accessi di un Laboratorio in ordine crescente, quindi dal meno recente al più recente
	 * @param laboratorio rappresenta il Laboratorio da ordinare in maniera crescente
	 * @return il laboratorio ordinato 
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 * @throws IOException eccezione che si verifica per errori in fase di lettura e scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 * @throws LaboratorioException eccezione che si verifica quando le posizioni non sono valide
	 */
	public static Pacchetti selectionSortCrescenteNodi(Pacchetti p) throws ClassNotFoundException, IOException, PacchettiException
	{
		Pacchetti pcopia=copia(p);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < pcopia.getElementi(); i++) 
			{
				if( pcopia.getPacchetto(i).getdAcquisto().isAfter( pcopia.getPacchetto(i+1).getdAcquisto()))
				{
					scambia( pcopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} while (scambioOK==true);
		return  pcopia;
	}
	
	/**
	 * Metodo che permette di ordinare gli accessi di un Laboratorio in ordine decrescente, quindi dal più recente al meno recente
	 * in realtà questo non è necessario dato che gli accessi vengono registrati l'orario attuale e essendo inseriti sempre in testa,
	 * rendendoli, di conseguenza, già ordinati in maniera decrescente.
	 * @param laboratorio rappresenta il Laboratorio da ordinare in maniera crescente
	 * @return il laboratorio ordinato 
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 * @throws IOException eccezione che si verifica per errori in fase di lettura e scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 * @throws LaboratorioException eccezione che si verifica quando le posizioni non sono valide
	 */
	public static Pacchetti selectionSortDecrescenteNodi(Pacchetti p) throws ClassNotFoundException, IOException,PacchettiException
	{
		Pacchetti pcopia=copia(p);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < pcopia.getElementi(); i++) 
			{
				if(pcopia.getPacchetto(i).getdAcquisto().isBefore(pcopia.getPacchetto(i+1).getdAcquisto()))
				{
					scambia(pcopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} while (scambioOK==true);
		return pcopia;
	}
	
//	<--------------------------------------------------------------NODI USANDO ARRAY-------------------------------------------------------------------->
	
	public static Pacchetto[] copiaInArray(Pacchetti p) throws PacchettiException
	{
		Pacchetto[] arrayCopia=new Pacchetto[p.getElementi()];
		for (int i = 1; i < p.getElementi()+1; i++) 
		{
			arrayCopia[i-1]=p.getPacchetto(i);	
		}
		
		return arrayCopia;
	}
	
	public static Pacchetto[] copia(Pacchetto[] array)
	{
		Pacchetto[] arrayCopia=new Pacchetto[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
		arrayCopia[i]=array[i];	
		}
		
		return arrayCopia;
	}
	public static Pacchetti creaLista(Pacchetto[] array)
	{
		Pacchetti p1=new Pacchetti();
		for (int i = 0; i < array.length; i++) 
		{
			p1.inserisciInTesta(array[i]);
		}
		
		return p1;
	}
	
	public static int scambia(Pacchetto[] array, int pos1, int pos2)
	{
		Pacchetto p;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		p=new Pacchetto(array[pos1]);
		array[pos1]=new Pacchetto(array[pos2]);
		array[pos2]=new Pacchetto(p);
		return 0;
	}
	
	public static Pacchetti selectionSortCrescente(Pacchetti p) throws PacchettiException
	{
		Pacchetto[] array=copiaInArray(p);
		Pacchetto[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getdAcquisto().isAfter(arrayOrdinato[i].getdAcquisto()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		Pacchetti pInOrdine=creaLista(arrayOrdinato);
		return pInOrdine;
	}
	
	public static Pacchetti selectionSortDecrescente(Pacchetti p) throws PacchettiException
	{
		Pacchetto[] array=copiaInArray(p);
		Pacchetto[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getdAcquisto().isBefore(arrayOrdinato[i].getdAcquisto()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		Pacchetti pInOrdine=creaLista(arrayOrdinato);
		return pInOrdine;
	}
	public static Pacchetti selectionSortDecrescentesoldi(Pacchetti p) throws PacchettiException
	{
		Pacchetto[] array=copiaInArray(p);
		Pacchetto[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getValoreEuroAcquisto()>(arrayOrdinato[i].getValoreEuroAcquisto()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		Pacchetti pInOrdine=creaLista(arrayOrdinato);
		return pInOrdine;
	}

}

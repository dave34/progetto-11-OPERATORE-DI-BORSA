import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pacchetti	implements Serializable {

	

		private Nodo head;
		private int elementi;
		//costruttore
		/**crea una lista vuota*/
		public Pacchetti()
		{
			head=null;
			elementi=0;
		}
		/** ritorna il numero di elementi che è composta la lista*/
		public int getElementi()
		{
			return elementi;
		}
		/** ritorna l head della lista*/
		public Nodo getHead()
		{
			return head;
		}
		/**crea un nuovo nodo della lista che punta al nodo "link"*/
		private Nodo creaNodo(Pacchetto p, Nodo link)
		{
			Nodo nodo=new Nodo(p);
			nodo.setLink(link);
			return nodo;
		}
		/** restituisce il pacchetto passandogli la posiizone*/
		 public Pacchetto getPacchetto (int posizione) throws PacchettiException 
		 {
			 if(elementi==0)
				 throw new PacchettiException("lista vuota");
			 if(posizione<=0||posizione>elementi)
				 throw new PacchettiException("Posizione non valida");
			 Nodo p=getLinkPosizione(posizione);
			 return p.getInfo();
					 
		 }
		 
		 /**	restituisce il link per puntare al link successivo */
		private Nodo getLinkPosizione(int posizione) throws PacchettiException
		{
			
			if (elementi==0)
				throw new PacchettiException("Lista vuota");
			if (posizione<=0 || posizione>elementi)
				throw new PacchettiException("Posizione non valida");
			
			Nodo p=head;
			int n=1;
			while(p.getLink()!=null && n<posizione)
			{
				p=p.getLink();
				n++;
			}
			return p;
		}
		/** mostra come output tutta la lista */
		public String toString()
		{
			String risultato="Pacchetti: ";
			if (elementi==0)
				return risultato="Non ci sono pacchetti presenti";
			Nodo p=head;
			while(p!=null)
			{
				risultato+=" --> "+p.getInfo().toString();
				p=p.getLink();
			}
			
			return risultato;
			
		}
		
		
		/** 	inserisce un pacchetto in testa (head punta a lui)  */
		public void inserisciInTesta(Pacchetto pak)	{
			Nodo p=creaNodo(pak, head);
			head=p;
			elementi++;
		}
		/** inserisce un pacchetto come ultimo */
		public void inserisciInCoda(Pacchetto pak) throws PacchettiException {
			if (elementi==0) 
				inserisciInTesta(pak);
			Nodo pn=creaNodo(pak, null);
			Nodo p=getLinkPosizione(elementi);
			p.setLink(pn);
			elementi++;
		}
		/**  inserisce un pacchetto in posizione*/
		public void acquistoPacchetto(Pacchetto pak, int posizione) throws PacchettiException {
			
			
				if (posizione==1) {
					
					inserisciInTesta(pak);
					
					return;
				}
				if (posizione<=0 || posizione>elementi+1) 
					
					throw new PacchettiException("Error 404");
				
				if (posizione==elementi+1) {
					
					inserisciInCoda(pak);
					
					return;
				}
			Nodo pn=creaNodo(pak, getLinkPosizione(posizione));
			Nodo precedente=getLinkPosizione(posizione-1);
			
			precedente.setLink(pn);
		}
		/**  elimina il primo nodo quello che punta l' head*/
		public void eliminaInTesta() throws PacchettiException {
			if (elementi==0) 
				throw new PacchettiException("Error 404");
			
			head=head.getLink();
			elementi--;
		
	}
		/**  elimina l ultimo elemento*/
		public void eliminaInCoda() throws PacchettiException{
			
			if (elementi==0)
				throw new PacchettiException("Lista vuota");
			if(elementi==1)
			{
				eliminaInTesta();
				return;
			}
			
			Nodo penultimo=getLinkPosizione(elementi-1);
			penultimo.setLink(null);
			elementi--;
		}
		/** elimina un elemento passandogli la posizione */
		public void eliminaInPosizione(int posizione) throws PacchettiException{
		
			if (elementi==0)
				throw new PacchettiException("Lista vuota");
			if (posizione<=0 || posizione>elementi)
				throw new PacchettiException("Posizione non valida");
			
			if (posizione==1)
			{
				eliminaInTesta();
				return;
			}
			
			if (posizione==elementi)
			{
				eliminaInCoda();
				return;
			}
			Nodo p=getLinkPosizione(posizione);
			Nodo precedente=getLinkPosizione(posizione-1);
			precedente.setLink(p.getLink());
			elementi--;
		}
		/**  elimina il pacchetto in posizione*/
		public void venditaPacchetto(int posizione) throws PacchettiException {
			
			eliminaInPosizione(posizione);
			return;
				
		}
		/** passandogli la posizione restituisce il pacchetto */
		private Pacchetto getPosizionePacchetto (int posizione) throws PacchettiException  
		{
			if (elementi == 0)
				throw new PacchettiException("Lista vuolta");
			if (posizione <= 0 || posizione>elementi)
				throw new PacchettiException("Posizione non valida");
			Nodo p = getLinkPosizione(posizione);
			return p.getInfo();
		}
		/**  esporta l informazione in un file CSV*/
		public void esportaCSV (String nameFile) throws IOException, PacchettiException 
		{
			TextFile file = new TextFile(nameFile, 'W');
			String pacchettoCSV;
			Pacchetto pak;
			for (int i = 1; i <= getElementi(); i++)
			{
				pak = getPosizionePacchetto(i);
				pacchettoCSV =pak.getCodiceIdentificativo() + "; "+ pak.getValoreEuroAcquisto() + "; " + pak.getdAcquisto() + "; " + pak.getValoreEuroVendita() + ";"+pak.getdVendita()+".";
				file.toFile(pacchettoCSV);
			}
			file.closeFile();
		}
		/**  carica su un file binario */
		public void salvaPaccchetti(String nomeFile) throws IOException
		{
			FileOutputStream file =new FileOutputStream(nomeFile);
			ObjectOutputStream writer=new ObjectOutputStream(file);
			writer.writeObject(this);
			writer.flush();
			file.close();
		}
		/** scarica da un file binario */
		public Pacchetti caricaPacchetti (String nomeFile) throws IOException, ClassNotFoundException
		{
			FileInputStream file=new FileInputStream(nomeFile);
			ObjectInputStream reader= new ObjectInputStream(file);
			
			Pacchetti pacchetti;
			
			pacchetti=(Pacchetti)(reader.readObject());
			file.close();
			return pacchetti;
		}

}

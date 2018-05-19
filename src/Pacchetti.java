import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pacchetti	implements Serializable {

	

		private Nodo head;
		private int elementi;
		
		public Pacchetti()
		{
			head=null;
			elementi=0;
		}
		
		public int getElementi()
		{
			return elementi;
		}
		/**crea un nuovo nodo della lista che punta al nodo "link"*/
		private Nodo creaNodo(Pacchetto p, Nodo link)
		{
			Nodo nodo=new Nodo(p);
			nodo.setLink(link);
			return nodo;
		}
		/** 	*/
		 public Pacchetto getPacchetto (int posizione) throws PacchettiException 
		 {
			 if(elementi==0)
				 throw new PacchettiException("lista vuota");
			 if(posizione<=0||posizione>elementi)
				 throw new PacchettiException("Posizione non valida");
			 Nodo p=getLinkPosizione(posizione);
			 return p.getInfo();
					 
		 }
		 
		 /** */
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
		/**  */
		public String toString()
		{
			String risultato="Head";
			if (elementi==0)
				return risultato;
			Nodo p=head;
			while(p!=null)
			{
				risultato+=" --> "+p.getInfo().toString();
				p=p.getLink();
			}
			
			return risultato;
			
		}
		
		
		/**  */
		public void inserisciInTesta(Pacchetto pak)	{
			Nodo p=creaNodo(pak, head);
			head=p;
			elementi++;
		}
		/**  */
		public void inserisciInCoda(Pacchetto pak) throws PacchettiException {
			if (elementi==0) 
				inserisciInTesta(pak);
			Nodo pn=creaNodo(pak, null);
			Nodo p=getLinkPosizione(elementi);
			p.setLink(pn);
			elementi++;
		}
		/**  */
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
		/**  */
		public void eliminaInTesta() throws PacchettiException {
			if (elementi==0) 
				throw new PacchettiException("Error 404");
			
			head=head.getLink();
			elementi--;
		
	}
		/**  */
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
		/**  */
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
		/**  */
		public void venditaPacchetto(int posizione, Pacchetto p) throws PacchettiException {
			if (posizione==elementi-1) {
				eliminaInCoda();
				
				return;
			}
			else throw new PacchettiException("Posizione non valida");
				
		}
		/**  */
		private Pacchetto getPosizionePacchetto (int posizione) throws PacchettiException  
		{
			if (elementi == 0)
				throw new PacchettiException("Lista vuolta");
			if (posizione <= 0 || posizione>elementi)
				throw new PacchettiException("Posizione non valida");
			Nodo p = getLinkPosizione(posizione);
			return p.getInfo();
		}
		/**  */
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
		public void salvaPaccchetti(String nomeFile) throws IOException
		{
			FileOutputStream file =new FileOutputStream(nomeFile);
			ObjectOutputStream writer=new ObjectOutputStream(file);
			writer.writeObject(this);
			writer.flush();
			file.close();
		}
		/**  */
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

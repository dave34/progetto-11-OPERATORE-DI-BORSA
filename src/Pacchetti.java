
public class Pacchetti {

	

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
		//crea un nuovo nodo della lista che punta al nodo "link"
		private Nodo creaNodo(Pacchetto p, Nodo link)
		{
			Nodo nodo=new Nodo(p);
			nodo.setLink(link);
			return nodo;
		}
		
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
		
		public String toString()
		{
			String risultato="Head";
			if (elementi==0)
				return risultato;
			Nodo p=head;
			while(p!=null)
			{
				risultato+=" -- "+p.getPacchetto().getCodiceIdentificativo();
				p=p.getLink();
			}
			
			return risultato;
			
		}
		
		
		public void inserisciInTesta(Pacchetto pak)	{
			Nodo p=creaNodo(pak, head);
			head=p;
			elementi++;
		}
		
		public void inserisciInCoda(Pacchetto pak) throws PacchettiException {
			if (elementi==0) 
				inserisciInTesta(pak);
			Nodo pn=creaNodo(pak, null);
			Nodo p=getLinkPosizione(elementi);
			p.setLink(pn);
			elementi++;
		}
		public void acquistoPacchetto(Pacchetto pak, int codice) throws PacchettiException {
			
			
				if (codice==1) {
					
					inserisciInTesta(pak);
					
					return;
				}
				if (codice<=0 || codice>elementi+1) 
					
					throw new PacchettiException("Error 404");
				
				if (codice==elementi+1) {
					
					inserisciInCoda(pak);
					
					return;
				}
			Nodo pn=creaNodo(pak, getLinkPosizione(codice));
			Nodo precedente=getLinkPosizione(codice-1);
			
			precedente.setLink(pn);
		}
	
		public void eliminaInTesta() throws PacchettiException {
			if (elementi==0) 
				throw new PacchettiException("Error 404");
			
			head=head.getLink();
			elementi--;
		
	}
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
		public void eliminaInPosizione(int codice) throws PacchettiException{
		
			if (elementi==0)
				throw new PacchettiException("Lista vuota");
			if (codice<=0 || codice>elementi)
				throw new PacchettiException("Posizione non valida");
			
			if (codice==1)
			{
				eliminaInTesta();
				return;
			}
			
			if (codice==elementi)
			{
				eliminaInCoda();
				return;
			}
			Nodo p=getLinkPosizione(codice);
			Nodo precedente=getLinkPosizione(codice-1);
			precedente.setLink(p.getLink());
			elementi--;
		}
		public void venditaPacchetto(int codice, Pacchetto p) throws PacchettiException {
			if (codice==p.getCodiceIdentificativo()) {
				eliminaInCoda();
				
				return;
			}
			else throw new PacchettiException("Posizione non valida");
				
		}

}

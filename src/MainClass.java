import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MainClass {

	public static void main(String[] args) {
		
		//--------------<<prove classi specifiche>>-----------\\
		
		LocalDate date = LocalDate.of(2018, 3, 11);
		LocalDate date2= LocalDate.now();
		ConsoleInput tastiera1=new ConsoleInput();
		Pacchetto pak1=new Pacchetto(12,33333, date, 4444, date2);
		Pacchetto pak2=new Pacchetto(3,33333, date, 56778, date2);
		Pacchetto pak3=new Pacchetto(44, 90, date, 0, null);
		Pacchetti p=new Pacchetti();

		p.inserisciInTesta(pak1);
		System.out.println(p.toString()+pak1.toString());
		
		
		//---------------<<prove main menu>>-----------------\\
		
		int scelta = 0;
		String[] vociMenu= {"1-->Registrare acquisto nuove di nuovo pacchetto di azioni",
							"2-->Vendi di un pacchetto di azioni",
							"3-->Rimuovere un pacchetto di azioni",
							"4-->Visualizza tutti i pacchetti presenti(ordine di data d' acquisto)",
							"5-->Visualizza tutti i pacchetti presenti(ordine di prezzo d' acquisto)"};
		Menu menu=new Menu("OPZIONI APPLICAZIONE 11: OPERATORE DI BORSA...",vociMenu);
		LocalDate d = LocalDate.of(2018, 3, 11);
		LocalDate d2= LocalDate.now();
		ConsoleInput tastiera=new ConsoleInput();
		/*Pacchetto p1=new Pacchetto(12,33333, d, 4444, d2);
		Pacchetto p2=new Pacchetto(3,33333, d, 56778, d2);
		Pacchetto p3=new Pacchetto(44, 90, d, 0, null);
		
		
		p.inserisciInTesta(p1);
		System.out.println(p.toString()+p1.toString());*/
		LocalDate data;
		LocalDate dataf = null;
		int giorno = 0, mese = 0,anno = 0;
		int codice = 0;
		int valoreIniziale = 0;
		int valorefinale=0;
		int posizione=0;
		
		Pacchetto p1 =new Pacchetto(12,33333, d, 0, null); 
		Pacchetto p2=new Pacchetto(3,33333, d, 0, null);
		Pacchetto pz=new Pacchetto(4,1233,d,0,null);;
		Pacchetti paki= new Pacchetti();
		try {
			paki.salvaPaccchetti("fileBinario.bin");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			paki.acquistoPacchetto(p1, 1);
			
		} catch (PacchettiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		do {
			
			scelta=menu.scelta();
			switch (scelta) 
			{
			case 1:
				
				
				
				
					
				try {
					System.out.println("Inserire il codice identificativo...");
					 codice = tastiera.readInt();
					 System.out.println("Inserire il prezzo d' acquisto...");
					valoreIniziale=tastiera.readInt();
					System.out.println("Inserire la data...");
					System.out.println("Inserire il giorno...");
					giorno=tastiera.readInt();
					System.out.println("Inserire il mese...");
					 mese=tastiera.readInt();
					 System.out.println("Inserire l' anno...");
					 anno=tastiera.readInt();
					System.out.println("Inserire la posizione...");
					 posizione= tastiera.readInt();
				
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				data= LocalDate.of(anno,mese,giorno);
				
				
				try {
					p.getPacchetto(posizione).setdAcquisto(data);
				} catch (PacchettiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					p.acquistoPacchetto(p1,posizione );
				} catch (PacchettiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Pacchetto acquistato: "+p.toString());
				
				break;

			default:
				break;
				
			
			
			case 2:
				
				
				try {
					System.out.println("Inserire la posizione...");
					 posizione= tastiera.readInt();
					
					 codice = pz.getCodiceIdentificativo();
				
					valoreIniziale=pz.getValoreEuroAcquisto();
					
					data=pz.getdAcquisto();
					
					 System.out.println("Inserire il prezzo di vendita...");
					 valorefinale=tastiera.readInt();
					 dataf=LocalDate.now();
					
				
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				data=pz.getdAcquisto();
				
				
				pz=new Pacchetto(codice,valoreIniziale,data,valorefinale,dataf);
				
				
				try {
					p.inserisciInTesta(pz);;
					try {
						p.salvaPaccchetti("pacchettiVenduti.txt");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					p.eliminaInPosizione(posizione);
					
				} catch (PacchettiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					System.out.println(p.toString());
				
				break;
			
			case 3:
				int pop;
				System.out.println("ci sono "+paki.getElementi()+" pacchetti");
				System.out.println("Che pacchetto si vuole rimuovere??");
				try {
					pop=tastiera.readInt();
					if (pop==1) {
						try {
						paki.esportaCSV("fileEliminati.txt");
							
							paki.eliminaInPosizione(pop);
						
							System.out.println("Pacchetto eliminato");
						} catch (PacchettiException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
						System.out.println("Posiizione non valida");
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println(Ordinatore.selectionSortCrescente(p));
				} catch (PacchettiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					System.out.println(Ordinatore.selectionSortDecrescentesoldi(p));
				} catch (PacchettiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			}
		} while (scelta>0 && scelta<vociMenu.length);
		
			
		
		}

}

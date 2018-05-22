import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

public class PacchettiTest {

	@Test
	public void testCostruttorePacchetti() 
	{
		Pacchetti  lista=new Pacchetti() ;
		assertTrue("Costruttore Laboratorio",lista.getHead()==null && laboratorio.getElementi()==0);
	}
	
/**	//test commentato perchè metodo creaNodo è privato
	@Test
	public void testCreaNodo() 
	{
		Laboratorio laboratorio=new Laboratorio();
		Accesso accesso1=new Accesso();
		Accesso accesso2=new Accesso();
		Nodo nodo1=new Nodo(accesso1);
		Nodo nodo2=laboratorio.creaNodo(accesso2, nodo1);
		assertTrue("Crea Nodo",nodo2.getInfo().equals(accesso2) && nodo2.getLink()==nodo1);
	}
	*/
	
	@Test	public void testAcquistaPacchetto() 
	{
		Pacchetti  lista=new Pacchetti() ;
		Pacchetto pak=new Pacchetto;
		int posizione=1;
		lista.acquistoPacchetto(pak, posizione);
		assertTrue("registraAccesso",lista.getElementi()==1);
	}
	
	@Test 
	public void testToString() throws PacchettiException 
	{
		Pacchetti  lista=new Pacchetti() ;
		int years=2000,mont=11,day=4;
		LocalDate dataA=LocalDate.of(years, month, day);
		int prezzoAx=12000;
		int codice=1234;
		int posizione=1;
		Pacchetto pak=new Pacchetto(codice,prezzoAx,dataA,0,null);
		lista.acquistoPacchetto(pak,posiizone );
		System.out.println(lista.getPacchetto(posizione));
		System.out.println(lista.toString());
		assertTrue(lista.getPacchetto(posizione).toString().compareToIgnoreCase("-->"+pak.toString())+"\n")==0);
		
	}
	
	@Test 
	public void testToStringVuoto() 
	{
		Pacchetti  lista=new Pacchetti() ;
		assertTrue("toString ",lista.toString().compareToIgnoreCase("")==0);
		
	}
	
	@Test 
	public void testGetPacchetto() throws PacchettiException
	{
		Pacchetti  lista=new Pacchetti() ;
		int years=2000,mont=11,day=4;
		int posizione=1;
		LocalDate dataOra=LocalDate.of(years, month, dayOfMonth);
		Pacchetto pak=new Pacchetto();
		lista.getPacchetto(posizione);
		assertEquals("getPacchetto", pak, lista.getPacchetto(posizione)));
		/*assertTrue("getAccesso",laboratorio.getAccesso(1)==accesso);*/
	}
	
	
	@Test 
	public void testEliminaInTesta() throws PacchettiException
	{
		Pacchetti lista=new Pacchetti();
		Pacchetto pak=new Pacchetto();
		int posizione=1;
		lista.acquistoPacchetto(pak, posizione);
		laboratorio.eliminaInTesta();
		assertTrue("EliminaInTesta",lista.getHead()==null);
	}
	
	
	@Test 
	public void testEliminaInCoda() throws PacchettiException 
	{
		Pacchetti lista=new Pacchetti();
		Pacchetto pak=new Pacchetto();
		int posizione=elementi;
		lista.acquistoPacchetto(pak, posizione);
		lista.eliminaInCoda();
		assertTrue("EliminaInCoda", lista.getHead()==null);
	}
	
	
	@Test
	public void testSalvaCaricaLaboratorio() throws IOException, ClassNotFoundException 
	{
		Pacchetti lista=new Pacchetti();
		int codice=123;
		int prezzoA=12333,prezzoV=12345
		int year=2010,month=11,day=21;
		LocalDate dataA=LocalDate.of(year, month, day);
		LocalDate dataV=LocalDate.now();
		Pacchetto pak=new Pacchetto(codice,prezzoA,dataA,prezzoV,dataV);
		lista.acquistoPacchetto(pak, posizione);
		lista.salvaPaccchetti(nomeFile);
		Laboratorio listacopia=lista.caricaLaboratorio(nomeFile);
		assertTrue("Serializzazione e Deserializzzazione",lista.toString().compareTo(listacopia.toString())==0);
	}
	
	
	 
	@Test 
	public void testEsportaLaboratorioCSV() throws IOException, PacchettiException,  
	 { 
	 	Pacchetti lista=new Pacchetti(); 
	 	int codice=224;
	 	int prezzoA=133,prezzoV=244;
	 	int year=2000,month=11,day=12;
	 	LocalDate dataA=LocalDate.of(year, month, day)
	 	LocalDate dataV=LocalDate.now(); 
	 	Pacchetto pak=new Pacchetto(codice,prezzoA,dataA,prezzoV,dataV); 
	 	lista.acquistoPacchetto(pak, posizione); 
	 	lista.esportaLaboratorioCSV(nameFile); 
	 	String nomeFile="C:\\Users\\Davide Carizzoni\\Desktop\\Davide\\SCUOLA QUARTA SUPERIORE\\INFORMATICA\\JAVA\\Workspace-carizzoni\\ACCESSO LABORATORIO\\fileTXT\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+".txt"; 
	 	TextFile file=new TextFile(nomeFile,'R'); 
	 	String StringaLetta=file.fromFile(); 
	 	String accessoCSV=accesso.getMatricola()+";"+accesso.getDataOra()+";"+accesso.getIdAccesso()+";"; 
	 	assertTrue("EsportaLaboratorioCSV",StringaLetta.compareTo(accessoCSV)==0); 
	 	 
	 }	 
	 	 
	 @Test 
	 public void testVerificaPresenza() throws LaboratorioException, AccessoMatricolaNotFoundException 
	 { 
	 	Laboratorio l=new Laboratorio(); 
	 	LocalDateTime dataOra=LocalDateTime.now(); 
	 	Accesso accesso=new Accesso(1,dataOra); 
	 	l.registraAccesso(accesso); 
	 	assertEquals("VerificaPresenza",l.getAccesso(1).getMatricola(),1); 
	 }	 
	 	 
	 @Test(expected=AccessoMatricolaNotFoundException.class) 
	 public void testVerificaPresenzaEccezione() throws LaboratorioException, AccessoMatricolaNotFoundException 
	 { 
	 	Laboratorio l=new Laboratorio(); 
	 	LocalDateTime dataOra=LocalDateTime.now(); 
	 	Accesso accesso=new Accesso(1,dataOra); 
	 	l.registraAccesso(accesso); 
	 	l.verificaPresenza(2); 
	 }	 
	
	
	

}
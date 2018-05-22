import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime; 
 
 import org.junit.Test; 
 
 
 public class AccessoTest  
 { 
 
 
 	@Test 
 	public void testCostruttorePacchetto()  
 	{ 
 		int codice=224;
	 	int prezzoA=133,prezzoV=244;
	 	int year=2000,month=11,day=12;
	 	LocalDate dataA=LocalDate.of(year, month, day)
	 	LocalDate dataV=LocalDate.now();  
		Pacchetto pak=new Pacchetto(codice,prezzoA,dataA,prezzoV,dataV); 
 		assertTrue("Costruttore Pacchetto",pak.getCodiceIdentificativo()==224 && pak.getValoreEuroAcquisto()==133 && pak.getdAcquisto()==dataA &&  pak.getValoreEuroVendita()==244 && pak.getdVendita()==dataV); 
 	} 
 	 
 	@Test 
 	public void testCostruttorePacchettoDefault()  
 	{ 
 		Accesso accesso=new Accesso(); 
 		assertTrue("Costruttore di default Accesso",,pak.getCodiceIdentificativo()==0 && pak.getValoreEuroAcquisto()==0 && pak.getdAcquisto()==null &&  pak.getValoreEuroVendita()==0 && pak.getdVendita()==null); 
 	} 
 

 	@Test 
 	public void testSetCodiceIdentificativo()  
 	{ 
		Pacchetto pak=new Pacchetto();
 		pak.setCodiceIdentificativo(1); 
 		assertTrue("setCodiceIdentificativo",pak.getCodiceIdentificativo()==1); 
 	} 
 	 
 	@Test 
 	public void testSetValoreEuroAcquisto()  
 	{ 
 		Pacchetto pak=new Pacchetto();
 		pak.setValoreEuroAcquisto(1); 
 		assertTrue("setPrezzoAcquisto",pak.getValoreEuroAcquisto()==1);
 	} 
 	 
 	@Test 
 	public void testSetdAcquisto())  
 	{ 
 		Pacchetto pak=new Pacchetto();
 		int yea=2018,month=2,day=12;
 		LocalDate dataA=new LocalDate.of(year,month,day);
 		pak.setdAcquisto(dataA); 
 		assertTrue("setDataAcquisto",pak.getdAcquisto()==dataA);
 	} 
	 
 	@Test 
 	public void testSetValoreEuroVedita()  
 	{ 
 		Pacchetto pak=new Pacchetto();
 		pak.setValoreEuroVendita(1); 
 		assertTrue("setPrezzoVendita",pak.getValoreEuroVendita()==1);
 	} 
 	
 	@Test 
 	public void testSetdVendita())  
 	{ 
 		Pacchetto pak=new Pacchetto();
 		
 		LocalDate dataA=new LocalDate.now;
 		pak.setdAcquisto(dataA); 
 		assertTrue("setDataVendita",pak.getdAcquisto()==dataA);
 	} 
 	 
 	
	@Test 
	public void testToString()  
	{
		
		int years=2000,mont=11,day=4;
		LocalDate dataA=LocalDate.of(years, month, day);
		int prezzoAx=12000;
		int codice=1234;
		Pacchetto pak=new Pacchetto(codice,prezzoAx,dataA,0,null);
		
		
		System.out.println(pak.toString());
		assertTrue(lista.getPacchetto(posizione).toString().compareToIgnoreCase("-->"+pak.toString())+"\n")==0);
		
	}
	
	@Test 
	public void testToStringVuoto() 
	{
		Pacchetto pak=new Pacchetto()
		assertTrue("toString ",lista.toString().compareToIgnoreCase("")==0);
		
	}
 
 } 

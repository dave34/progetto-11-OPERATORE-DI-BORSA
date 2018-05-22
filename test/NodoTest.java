import static org.junit.Assert.*;

import org.junit.Test;

public class NodoTest 
{

	@Test
	public void testCostruttoreNodo() 
	{
		Accesso accesso=new Accesso();
		Nodo n=new Nodo(accesso);
		assertTrue("Costruttore nodo", n.getInfo().equals(accesso) && n.getLink()==null);
	}

	@Test
	public void testSetInfo() 
	{
		Accesso a=new Accesso();
		Accesso a1=new Accesso();
		Nodo n=new Nodo(a);
		n.setInfo(a1);
		assertTrue("setInfo",n.getInfo().equals(a1) && n.getLink()==null);
	}
	
	@Test
	public void testSetLink() 
	{
		Accesso a=new Accesso();
		Accesso a1=new Accesso();
		Nodo nodo1=new Nodo(a);
		Nodo nodo2=new Nodo(a1);
		nodo1.setLink(nodo2);
		assertTrue("setLink",nodo1.getInfo().equals(a1)&&nodo1.getLink()==nodo2);
	}
}
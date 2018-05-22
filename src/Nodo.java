


public class Nodo
{

	private Pacchetto packet;
	private Nodo link;
	
	//costruttori
	/** crea un Nodo passandogli un pacchetto*/
	public Nodo (Pacchetto p)
	{
		setInfo(p);
		link=null;
	}
	/** crea un Nodo in posizione n*/
	public Nodo (Pacchetto p, Nodo n) {
		setInfo(p);
		link=n;
	}
	//getter e setter
	/** ritorna l info*/
	public Pacchetto getInfo() {
		return packet;
	}
	/** setta l info*/
	public void setInfo(Pacchetto p) 
	{
		this.packet = new Pacchetto(p);
	}
	/** ritorna il link*/
	public Nodo getLink() {
		return link;
	}
	/** setta il link*/
	public void setLink(Nodo link) {
		this.link = link;
	}
	
}



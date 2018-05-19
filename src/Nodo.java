


public class Nodo
{

	private Pacchetto packet;
	private Nodo link;
	
	//costruttori
	public Nodo (Pacchetto p)
	{
		setInfo(p);
		link=null;
	}
	public Nodo (Pacchetto p, Nodo n) {
		setInfo(p);
		link=n;
	}
	//getter e setter
	public Pacchetto getInfo() {
		return packet;
	}

	public void setInfo(Pacchetto p) 
	{
		this.packet = new Pacchetto(p);
	}

	public Nodo getLink() {
		return link;
	}

	public void setLink(Nodo link) {
		this.link = link;
	}
	
}



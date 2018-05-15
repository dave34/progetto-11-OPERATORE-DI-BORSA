


public class Nodo
{

	private Pacchetto packet;
	private Nodo link;
	
	//costruttori
	public Nodo (Pacchetto p)
	{
		setPacchetto(p);
		link=null;
	}
	//getter e setter
	public Pacchetto getPacchetto() {
		return packet;
	}

	public void setPacchetto(Pacchetto p) 
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



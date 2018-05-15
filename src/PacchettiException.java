
public class PacchettiException extends Exception {

	
private String messaggio;
	
	public PacchettiException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
	
}
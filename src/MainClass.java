import java.time.LocalDate;

public class MainClass {

	public static void main(String[] args) {
		
		LocalDate d = LocalDate.of(2018, 3, 11);
		LocalDate d2= LocalDate.of(2018, 5, 6);
		Pacchetto p1=new Pacchetto(1,33333, d, 4444, d2);
		Pacchetto p2=new Pacchetto(3,33333, d, 56778, d2);
		
		Pacchetti p= new Pacchetti();
		p.inserisciInTesta(p1);
		try {
			p.venditaPacchetto(1, p1);
		} catch (PacchettiException e) {
			
			e.printStackTrace();
		}
	}

}

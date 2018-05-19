import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile
{
	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public TextFile (String fileName, char mode) throws IOException
	{
		this.mode = 'R';
		if(mode == 'W' || mode == 'w')
		{
			FileWriter f1 = new FileWriter(fileName, true);
			writer = new BufferedWriter(f1);
			this.mode = 'W';
		}
		else
		{
			FileReader f1 = new FileReader(fileName);
			reader = new BufferedReader(f1);
			this.mode = 'R';
		}
	}
	public void toFile (String pacchettoCSV) throws PacchettiException, IOException
	{
		if (mode == 'R')
			throw new PacchettiException ("File aperto in lettura");
		writer.write(pacchettoCSV);
		writer.newLine();
	}
	public String fromFile () throws PacchettiException, IOException
	{
		String rigaLetta;
		if (mode == 'W')
			throw new PacchettiException ("File aperto in scrittura");
		rigaLetta = reader.readLine();
		if (rigaLetta == null)
			throw new PacchettiException("End of file");
		return rigaLetta;
	}
	public void closeFile () throws IOException
	{
		if (mode == 'R')
			reader.close();
		else
			writer.close();
	}
}


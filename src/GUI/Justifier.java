package GUI;

import java.io.IOException;
import java.io.PrintWriter;

import GUI.Formatter.FormatterOutput;

public class Justifier {
	
	
	public static FormatterOutput leftJustified(String inputName, String outputName, int lineLength, boolean doubleSpace)
	{
		try {
			PrintWriter writer = new PrintWriter(outputName, "utf-8");
			FormatterOutput formatTest = new FormatterOutput();
		
			formatTest = Formatter.formatInput(inputName, lineLength);
			
			for(int x = 0; x < formatTest.inputList.size(); x++)
			{
				writer.print(formatTest.inputList.get(x).lineReturn());
				if(x >= (formatTest.inputList.size() - 1))
				{
					break;
				}
				if(doubleSpace)
				{
					writer.println();
				}
				writer.println();
			}
			
			
			writer.close();
			
			return formatTest;
		
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}

package GUI;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;

import GUI.Formatter.FormatterOutput;

public class RJustifier {

	public static FormatterOutput rightJustified(String inputName, String outputName, int lineLength, boolean doubleSpace) {
		try {

			PrintWriter writer = new PrintWriter(outputName, "utf-8");
			FormatterOutput formatTest = new FormatterOutput();

			formatTest = Formatter.formatInput(inputName, lineLength);

			for (int x = 0; x < formatTest.inputList.size(); x++) {
				
				int lineLen = formatTest.inputList.get(x).getSize();
				if (lineLen < lineLength)
				{
					int numSpaces = lineLength - lineLen;
					for(int y = 0; y < numSpaces; y++)
					{
						writer.print(" ");
					}
				}
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

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public static FormatterOutput fullJustified(String inputName, String outputName, int lineLength, boolean doubleSpace) {
		try {
			int numSpacesPerWord = 0;
			PrintWriter writer = new PrintWriter(outputName, "utf-8");
			FormatterOutput formatTest = new FormatterOutput();

			formatTest = Formatter.formatInput(inputName, lineLength);
			int numLines = formatTest.inputList.size();
			for (int x = 0; x < numLines; x++) {
				
				int lineLen = formatTest.inputList.get(x).getSize();
				int lineWords = formatTest.inputList.get(x).getWordsInLine();
				if (lineLen < lineLength)
				{
					int numSpaces = lineLength - lineLen;
					if(lineWords < numSpaces)
					{
						if(!(lineWords <= 1))
						{
							numSpacesPerWord = Math.round((float)numSpaces / (float)(lineWords - 1));
						}
						else
						{
							numSpacesPerWord = 0;
						}
					}
					else
					{
						numSpacesPerWord = lineWords / numSpaces;
					}
					for(int y = 0; y < lineWords; y++)
					{
						writer.print(formatTest.inputList.get(x).wordReturn(y));
						if (numSpaces > 0)
						{
							for(int z = 0; z < numSpacesPerWord; z++)
							{
								writer.print(" ");
								numSpaces--;
							}
						}
						if(y >= (lineWords - 1))
						{
							break;
						}
						writer.print(" ");
						
					}
				}
				else
				{
					writer.print(formatTest.inputList.get(x).lineReturn());
				}
				
				if(x >= (numLines - 1))
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

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

}

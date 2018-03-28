package GUI;

import GUI.Formatter.FormatterOutput;

public class Statistics {

	public static double averageLineLength(FormatterOutput file, boolean doubleSpaced)
	{
		int n = 0;
		int lineSize = 0;
		
		while(n < file.inputList.size())
		{
			lineSize = lineSize + file.inputList.get(n).getSize();
			n++;
		}
		
		Double ls = new Double(lineSize);
		Double lc = new Double(file.inputList.size());
		if (doubleSpaced)
		{
			for(int x = 0; x < (file.inputList.size() - 1); x++)
			{
				lc += 1;
			}
		}
		
		double x = ls/lc;
		
		return x;
	}
	
	public static int totalAddedSpaces(FormatterOutput file, boolean rightJustified, boolean fullJustified, int lineLength)
	{
		int tempNum = 0;
		int numLines = 0;
		numLines = file.inputList.size();
		for(int x = 0; x < numLines; x++)
		{
			if (fullJustified)
			{
				if (lineLength < file.inputList.get(x).getNonSpaceSize())
				{
					//Add nothing
				}
				else if (file.inputList.get(x).getWordsInLine() > 1)
				{
					tempNum += (lineLength - file.inputList.get(x).getNonSpaceSize());
				}
				else
				{
					//Add nothing since if only one word, no spaces will be added.
				}
			}
			else if (rightJustified)
			{
				if (lineLength < file.inputList.get(x).getNonSpaceSize())
				{
					//Add nothing
				}
				else
				{
					tempNum += (lineLength - file.inputList.get(x).getNonSpaceSize());
				}
				System.out.println("Spaces Added: " + tempNum);
			}
			else
			{
				if (lineLength < file.inputList.get(x).getNonSpaceSize())
				{
					//Add nothing
				}
				else
				{
				tempNum += (file.inputList.get(x).getSize() - file.inputList.get(x).getNonSpaceSize());
				}
			}
		}
		
		return tempNum;
	}
	
	public static double averageWordPerLine(FormatterOutput file, boolean doubleSpaced)
	{	
		int n = 0;
		int totalWords = 0;
		
		while(n < file.inputList.size())
		{
			totalWords = totalWords + file.inputList.get(n).getWordsInLine();
			n++;
		}
		
		Double tw = new Double(totalWords);
		Double lc = new Double(file.inputList.size());
		
		if(doubleSpaced)
		{
			for(int x = 0; x < (file.inputList.size() - 1); x++)
			{
				lc += 1;
			}
		}
		
		double x = tw/lc;
		
		return x;
	}
	
	public static int blankLinesRemoved(FormatterOutput file)
	{
		return file.linesRem;
	}
	
	
	public static int lineCount(FormatterOutput file, boolean doubleSpaced)
	{
		if(doubleSpaced)
		{
			return (2 * (file.inputList.size() - 1)) + 1;
		}
		else
		{
			return file.inputList.size();
		}
	}
	
	public static int wordCount(FormatterOutput file)
	{
		int n = 0;
		int totalWords = 0;
		
		while(n < file.inputList.size())
		{
			totalWords = totalWords + file.inputList.get(n).getWordsInLine();
			n++;
		}
		
		return totalWords;
	}
	
}

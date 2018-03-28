package GUI;

import java.util.LinkedList;

//Name: Richard Simpson
//Student ID: 1211882799
//Description: Format sub-class to handle each line


public class Helper 
{
	private class LineWord
	{
		public String wordStr;
		@SuppressWarnings("unused")
		public int wordSize;
	}
	
	private int lineSize;
	private LinkedList<LineWord> lineStr;
	private int wordsInLine;
	private int lineLength;
	private int nonSpaceCharacters;
	
	
	
	//constructor sets vars to empty
	public Helper(int lineLength)
	{
		lineSize = 0;
		lineStr = new LinkedList<LineWord>();
		this.lineLength = lineLength;
	}
	
	//getters
	public String lineReturn()
	{
		String temp = new String();
		
		temp += lineStr.get(0).wordStr;
		
		for(int x = 1; x < lineStr.size(); x++)
		{
			temp += " ";
			temp += lineStr.get(x).wordStr;
		}
		
		return temp;
	}
	
	public String wordReturn(int index)
	{
		if(index < lineStr.size())
		{
			return lineStr.get(index).wordStr;
		}
		else
		{
			return " Out of Bounds. ";
		}
	}
	
	public int getSize()
	{
		return lineSize;
	}
	
	public int getNonSpaceSize()
	{
		return nonSpaceCharacters;
	}
	
	public int getWordsInLine()
	{
		return wordsInLine;
	}
	
	public String printAll()
	{
		String temp = new String();
		temp += "Line Size: " + lineSize + " Number of Words: " + wordsInLine + lineReturn();
		
		return temp;
	}
	
	//setters
	public boolean addWord(String newStr)
	{
		if((lineSize + newStr.length()) <= lineLength)
		{
			if(lineSize > 0)
			{
				lineSize++;
			}
			
			LineWord temp = new LineWord();
			temp.wordStr = newStr;
			temp.wordSize = newStr.length();
			
			lineStr.add(temp);
			lineSize += newStr.length();
			nonSpaceCharacters += newStr.length();
			wordsInLine++;
			
			return true;
		}
		
		else if(lineSize == 0)
		{
			LineWord temp = new LineWord();
			temp.wordStr = newStr;
			temp.wordSize = newStr.length();
			
			lineStr.add(temp);
			lineSize += newStr.length();
			nonSpaceCharacters += newStr.length();
			wordsInLine++;
			
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
}

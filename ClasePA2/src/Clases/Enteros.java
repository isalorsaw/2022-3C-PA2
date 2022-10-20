package Clases;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Enteros extends PlainDocument 
{

private int limit;

	public Enteros(int limite) 
	{
		super();
		this.limit=limite;
	}
	public void insertString(int offset,String string, AttributeSet attributes)throws BadLocationException
	{
			String acceptedChars = "0123456789";
			int fieldLength = limit;
			if (string == null)
				return;
			if (offset >= fieldLength) {
				return;
			}
			// does the insertion exceed the max length
			if (string.length() > fieldLength) {
				string = string.substring(0, fieldLength);
			}
			if (acceptedChars == null) {
				System.out.println("No filter selected.");
				super.insertString(offset, string, attributes);
				return;
			}
			for (int i = 0; i < string.length(); i++) {
				if (acceptedChars.indexOf(string.valueOf(string.charAt(i))) == -1)
					return;
			}
			super.insertString(offset, string, attributes);
	}
}

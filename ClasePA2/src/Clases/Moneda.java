package Clases;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Moneda extends PlainDocument 
{

private int limit;
private StringBuffer __scratchBuffer = new StringBuffer();

	public Moneda(int limite) {
		super();
		this.limit=limite;
	}

    public void insertString(int offset, String text, AttributeSet aset)
      throws BadLocationException 
    {
    	String acceptedChars = "0123456789.";
      if(text == null||offset>=limit)
        return;

	  	for (int i = 0; i < text.length(); i++) {
			if (acceptedChars.indexOf(text.valueOf(text.charAt(i))) == -1)
			return;
		}
			
      __scratchBuffer.setLength(0);

      // Reject all strings that cause the contents of the field not
      // to be a valid number (i.e., string representation of a double)
      try {
        __scratchBuffer.append(getText(0, getLength()));
        __scratchBuffer.insert(offset, text);
        // Kludge: Append a 0 so that leading decimal points
        // and signs will be accepted
        __scratchBuffer.append('0');
      } catch(BadLocationException ble) {
        ble.printStackTrace();
        return;
      } catch(StringIndexOutOfBoundsException sioobe) {
        sioobe.printStackTrace();
        return;
      }

      try {
        Double.parseDouble(__scratchBuffer.toString());
      } catch(NumberFormatException nfe) {
        // Resulting string will not be number, so reject it
        return;
      }

      super.insertString(offset, text, aset);
  }
}

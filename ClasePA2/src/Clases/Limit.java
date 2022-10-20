package Clases;
import javax.swing.text.*;
public class Limit extends PlainDocument 
{
  private int limit;
  private boolean toUppercase = false;
  
 	public Limit(int limit) 
 	{
   		super();
   		this.limit = limit;
  	}
   
  	public Limit(int limit, boolean upper) 
  	{
   		super();
   		this.limit = limit;
   		toUppercase = upper;
   	}
  	public void insertString(int offset, String  str, AttributeSet attr)throws BadLocationException 
  	{
   		if (str == null) return;
   		if(str.charAt(str.length()-1)=='\'')return ;
		if ((getLength() + str.length()) <= limit) {
     		if (toUppercase) str = str.toUpperCase();
     		super.insertString(offset, str, attr);
     	}
   	}
}
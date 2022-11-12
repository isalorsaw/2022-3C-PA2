package Clases;
import javax.swing.JOptionPane;
public class Dialogo 
{
	public static void mensaje(String m)
	{
		JOptionPane.showMessageDialog(null, m);
	}
	public static String pedirLista(String msg,String lista[])
	{
		String sel=""; 
		do
		{
			sel=(String)javax.swing.JOptionPane.showInputDialog(null,
			msg, 
			"seleccionado",
			javax.swing.JOptionPane.QUESTION_MESSAGE,
			null,//null para icono por defecto.
			lista,
			lista[0]);
		}while(sel==null);
		return sel;
	}
}

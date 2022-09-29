package Clases;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
public class Archivo 
{
	String nomarchivo;
	public static void main(String args[])
	{
		Archivo a=new Archivo("src/Archivos/config.txt");
		String info=a.traeString();
		JOptionPane.showMessageDialog(null,info);
		String l=a.traeLinea(1);
	}
	public Archivo(String na)
	{
		nomarchivo=na;
		if(!siExiste())JOptionPane.showMessageDialog(null,"Error el Archivo No Existe");
		else System.out.print("Archivo si Existe");
	}
	public boolean siExiste()
	{
		File f=new File(nomarchivo);
		return (f.exists()?true:false);
	}
	public String traeString()
	{
		String cadena="";
		FileReader entrada=null;
		try
		{
			entrada=new FileReader(nomarchivo);
			int c;
			while((c=entrada.read())!=-1)
			{
				cadena+=(char)c;
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error Al Cargar "+exp);
		}
		return cadena;
	}
	public String traeLinea(int i)
	{
		String arr[]=traeString().split("\n");
		if(i>0&&i<=arr.length)return arr[i-1];
		else return null;
	}
}

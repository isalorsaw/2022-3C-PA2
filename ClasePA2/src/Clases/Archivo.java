package Clases;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
public class Archivo 
{
	String nomarchivo;
	public static void main(String args[])
	{
		
		Archivo a=new Archivo("src/Archivos/config.txt");
		String info=a.traeString();
		String l=a.traeLinea(2);
		JOptionPane.showMessageDialog(null,l);
		/*
		try {
			a.guardarEnPos("localhost;colinsoft;root;olimpia3;",2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	public Archivo()
	{
		String n=DatosSesion.ruta;
		JOptionPane.showMessageDialog(null,n);
		new Archivo(n);
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
	public void guardarString(String ultima)throws IOException
	{
		String lineas[]=traeString().split("\n");
		PrintWriter g=new PrintWriter(nomarchivo);
		g.flush();
		for(int i=0;i<=lineas.length-1;i++)
		{
			g.write(lineas[i]);
			g.println();
		}
		g.write(ultima);
		g.println();
		g.close();
	}
	public void guardarArr(String lineas[])throws IOException
	{
		PrintWriter g=new PrintWriter(nomarchivo);
		g.flush();
		for(int i=0;i<=lineas.length-1;i++)
		{
			g.write(lineas[i].trim());
			g.println();
		}
		//g.println();
		g.close();
	}
	public void guardarEnPos(String cadena, int p)throws IOException
	{
		String l[]=traeString().split("\n");
		l[p-1]=cadena;
		guardarArr(l);
	}
}

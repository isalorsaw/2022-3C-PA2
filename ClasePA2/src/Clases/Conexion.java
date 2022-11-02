package Clases;
import java.sql.*;
import javax.swing.*;
public class Conexion
{
	static String ruta="src/Archivos/config.txt";
	static String url;
	static String user;
	static String pass;
	static String db;
	static String localizacion;
	public static void main(String args[])
	{
		Conexion c=new Conexion();
		boolean b=c.getConexionState();
		String str=c.getConexionStateMensaje();
		JOptionPane.showMessageDialog(null,""+str);
		//String linea=new Archivo(ruta).traeString();
		//String l=new Archivo(ruta).traeLinea(2);
		//JOptionPane.showMessageDialog(null,""+l);
	}
	public Conexion(String l,String d,String us,String p)
	{
		localizacion=l;
		db=d;
		user=us;
		pass=p;
		url = "jdbc:mysql://"+localizacion+"/"+db;
	}
	public Conexion()
	{
		String linea=new Archivo(ruta).traeLinea(2);
		//JOptionPane.showMessageDialog(null,"Linea "+linea);
	    String arc[]=linea.split("\n");
    	localizacion = arc[0].split(";")[0]+":3306";
 		user = arc[0].split(";")[2];
 		pass = arc[0].split(";")[3];
 		db = arc[0].split(";")[1];
 		url = "jdbc:mysql://"+localizacion+"/"+db;
	}
  	public Connection getConexion()
  	{
		try
		{
			Connection con=null;	
			try
			{ 
	      		String driver = "com.mysql.jdbc.Driver";
	      		Class.forName( driver );
	      		con = DriverManager.getConnection( url , user , pass );
	      		return con;
		    }
	      	catch(Exception e)
	      	{
	      		JOptionPane.showMessageDialog(null," "+e);
	      		System.exit(0);
	      	}
    	}
    	catch(Exception e)
    	{
      		JOptionPane.showMessageDialog(null,"ERROR EN CONEXION DE RED A BASE DE DATOS\n"+e.getMessage(),
      		"Conexion a Base de Datos Incorrecta",0);
      		System.exit(0);
      	}
        return null;
    }
    public boolean getConexionState()
    {
		try
		{
			Connection con=null;	
			try 
			{ 
	      		String driver = "com.mysql.jdbc.Driver";
	      		Class.forName( driver );
	      		con = DriverManager.getConnection( url , user , pass );
	      		return true;
		    }
	      	catch(Exception e)
	      	{
	      		
	      	}
    	}
    	catch(Exception e)
    	{

      	}
        return false;
    }
    String getConexion(String ubicacion, String db, String dbuser, String dbpass)
    {
		try
		{
			Connection con=null;	
			try
			{      	  
      			String driver = "com.mysql.jdbc.Driver";
      			Class.forName( driver );  
       			con = DriverManager.getConnection("jdbc:mysql://"+ubicacion+"/"+db,dbuser,dbpass );
      			return "Conexion Satisfactoria";
	    	}
      		catch(Exception e)
      		{
      			return e.getMessage();
      		}
    	}
    	catch(Exception e)
    	{
      		return e.getMessage();
      	}
    }
    String getConexionStateMensaje()
    {
		try
		{
			Connection con=null;	
			try
			{      	  
      			String driver = "com.mysql.jdbc.Driver";
      			Class.forName( driver );  
       			con = DriverManager.getConnection("jdbc:mysql://"+localizacion+"/"+db,user,pass );
      			return "Conexion Satisfactoria";
	    	}
      		catch(Exception e)
      		{
      			return e.getMessage();
      		}
    	}
    	catch(Exception e)
    	{
      		return e.getMessage();
      	}
    }
}
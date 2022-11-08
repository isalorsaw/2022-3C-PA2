package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class BaseDatos {
	public boolean siExiste(String sql)
	{
		boolean siexiste=false;
		try
		{
			Connection con=new Conexion().getConexion();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				siexiste=true;
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp+" "+sql);
		}
		return siexiste;
	}
	public void llenarComboBox(JComboBox cmbid, JComboBox cmbnombre, String sql, String plinea)
	{
		cmbid.removeAllItems();
		cmbnombre.removeAllItems();
		
		cmbid.addItem("");
		cmbnombre.addItem(plinea);
		
		try
		{
			Connection con=new Conexion().getConexion();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				int codigo=rs.getInt(1);
				String nombre=rs.getString(2);
				cmbid.addItem(codigo);
				cmbnombre.addItem(nombre);
			}
			con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error "+sql+" "+exp);
		}
		cmbid.setSelectedIndex(0);
		cmbnombre.setSelectedIndex(0);
	}
	public void llenarComboBox2(JComboBox cmbid, JComboBox cmbnombre, String sql, String plinea)
	{
		cmbid.removeAllItems();
		cmbnombre.removeAllItems();
		
		cmbid.addItem("");
		cmbnombre.addItem(plinea);
		
		try
		{
			Connection con=new Conexion().getConexion();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String codigo=rs.getString(1);
				String nombre=rs.getString(2);
				cmbid.addItem(codigo);
				cmbnombre.addItem(nombre);
			}
			con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error "+sql+" "+exp);
		}
		cmbid.setSelectedIndex(0);
		cmbnombre.setSelectedIndex(0);
	}
	public void ingresar(String sql)
	{
		try
		{
			Connection con=new Conexion().getConexion();
			Statement stmt=con.createStatement();
			stmt.execute(sql);
			con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error "+sql+" "+exp);
		}
	}
	public boolean getAcceso(String usuario, int modulocodigo)
	{
		String sql="SELECT ifnull(um.user_modulo_estado,'INACTIVO')AS estado,"+
		"m.modulo_codigo FROM tbl_modulo m LEFT OUTER JOIN tbl_user_modulo um ON "+
		"um.user_usuario='"+usuario+"' AND um.modulo_codigo=m.modulo_codigo"
		+ " WHERE m.modulo_codigo="+modulocodigo;
		System.out.println(sql);
		String estado="";
		
		try
		{
			Connection con=new Conexion().getConexion();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				estado=rs.getString("estado");
			}
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,exp+" "+sql);
		}
		//return (estado.equals("ACTIVO")?true:false);
		if(estado.equals("ACTIVO"))return true;
		else return false;
	}
}

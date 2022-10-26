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
}

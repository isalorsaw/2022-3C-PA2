package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class BaseDatos {
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
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error "+sql+" "+exp);
		}
		cmbid.setSelectedIndex(0);
		cmbnombre.setSelectedIndex(0);
	}
}

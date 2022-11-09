import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.BaseDatos;
import Clases.Conexion;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class frmAccesos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox cmbempleado,cmbempleadoi;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAccesos frame = new frmAccesos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmAccesos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 49, 368, 278);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Estado", "SiExiste"
			}
		));
		scrollPane.setViewportView(table);
		model=(DefaultTableModel)table.getModel();
		
		cmbempleadoi = new JComboBox();
		cmbempleado = new JComboBox();
		cmbempleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbempleado.getSelectedIndex()>0)llenarCampos();
			}
		});
		cmbempleado.setBounds(230, 11, 368, 22);
		contentPane.add(cmbempleado);
		
		llenarCombo();
	}
	public void llenarCampos()
	{
		model.setRowCount(0);
		String codemp=cmbempleadoi.getItemAt(cmbempleado.getSelectedIndex())+"";
		JOptionPane.showMessageDialog(null, codemp);
		String sql="SELECT\r\n"
				+ "m.modulo_codigo,\r\n"
				+ "m.modulo_nombre,\r\n"
				+ "ifnull(um.user_modulo_estado,'INACTIVO')AS estado,\r\n"
				+ "ifnull(um.user_usuario,'')AS siexiste\r\n"
				+ "FROM\r\n"
				+ "tbl_modulo m \r\n"
				+ "LEFT outer \r\n"
				+ "join tbl_user_modulo um ON um.modulo_codigo=m.modulo_codigo "+
				"AND um.user_usuario='"+codemp+"'";
		try
		{
			Connection con=new Conexion().getConexion();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Object fila[]=new Object[4];
				fila[0]=rs.getInt(1);
				fila[1]=rs.getString(2);
				fila[2]=rs.getString(3);
				fila[3]=rs.getString(4);
				model.addRow(fila);
			}
			con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error "+sql+" "+exp);
		}
	}
	public void llenarAccesos()
	{
		
		
	}
	public void llenarCombo()
	{
		String sql="SELECT\r\n"
				+ "u.user_usuario,\r\n"
				+ "concat(e.emp_nombre,'-',ifnull(u.user_usuario,''))AS nombreu\r\n"
				+ "FROM\r\n"
				+ "tbl_empleado e \r\n"
				+ "LEFT outer JOIN tbl_user u ON u.emp_codigo=e.emp_codigo\r\n"
				+ "ORDER BY\r\n"
				+ "e.emp_nombre";
		new BaseDatos().llenarComboBox2(cmbempleadoi,cmbempleado,sql,"[Seleccione un Empleado]");
	}
}

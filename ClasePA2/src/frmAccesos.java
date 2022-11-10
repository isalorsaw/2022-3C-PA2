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
import Clases.Dialogo;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		scrollPane.setBounds(231, 84, 368, 278);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int f=table.getSelectedRow();
				int c=table.getSelectedColumn();
				//Dialogo.mensaje("Fila Seleccionado es "+f+" Columna Seleccionada es "+c);
				String a[]= {"[NINGUNO]","ACTIVO","INACTIVO"};
				String est=Dialogo.pedirLista("Seleccione el Estado",a);
				//Dialogo.mensaje(est);
				
				String sql="";
				String siexiste=model.getValueAt(f,3)+"";
				int modulocodigo=Integer.parseInt(model.getValueAt(f,0)+"");
				String codemp=cmbempleadoi.getItemAt(cmbempleado.getSelectedIndex())+"";
				//Dialogo.mensaje("Siexiste "+siexiste+" ModuloC "+modulocodigo+" usuario"+codemp);
				
				if(!est.equals("[NINGUNO]"))
				{
					if(siexiste.equals(""))
					{
						sql="insert into tbl_user_modulo values('"+codemp+"',"+modulocodigo+
						",'"+est+"')";
					}
					else 
					{
						sql="update tbl_user_modulo set user_modulo_estado='"+est+
						"' where user_usuario='"+codemp+"' and modulo_codigo="+modulocodigo;
					}
					new BaseDatos().ingresar(sql);
					Dialogo.mensaje("Acceso Modificado Satisfactoriamente");
					llenarCampos();
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Estado", "SiExiste"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		model=(DefaultTableModel)table.getModel();
		
		cmbempleadoi = new JComboBox();
		cmbempleado = new JComboBox();
		cmbempleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbempleado.getSelectedIndex()>0)llenarCampos();
			}
		});
		cmbempleado.setBounds(231, 46, 368, 22);
		contentPane.add(cmbempleado);
		
		JLabel lblNewLabel = new JLabel("Empleado-Usuario");
		lblNewLabel.setBounds(77, 50, 144, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mantenimiento de Accesos para Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 615, 14);
		contentPane.add(lblNewLabel_1);
		
		llenarCombo();
	}
	public void llenarCampos()
	{
		model.setRowCount(0);
		String codemp=cmbempleadoi.getItemAt(cmbempleado.getSelectedIndex())+"";
		//JOptionPane.showMessageDialog(null, codemp);
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

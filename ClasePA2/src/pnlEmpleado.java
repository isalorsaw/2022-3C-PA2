import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Clases.BaseDatos;
import Clases.Conexion;
import Clases.Limit;
import Clases.Moneda;
import Clases.Reporte;
import Clases.Enteros;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;

public class pnlEmpleado extends JPanel{
	private JTextField txtidentidad;
	private JTextField txtnombre, txtmovil, txtotro;
	private JComboBox cmbdepto,cmbgenero,cmbdeptoi;
	private JTextField txtdireccion;
	private JTextField txtcorreoe;
	private JComboBox cmbestadoc;
	private JComboBox cmbestado;
	private JTextField txtdate;
	private JTextField txtdate2;
	private JDateChooser dfechan;
	private JDateChooser dfechai;
	private JButton btnGuardar;
	private JLabel lblempleado;
	private JComboBox cmbempleado,cmbempleadoi;
	/**
	 * Create the panel.
	 */
	public pnlEmpleado() {
		setSize(607, 406);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento de Empleado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 11, 546, 32);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnGuardar.setText("GUARDAR");
				mostrarListado(false);
			}
		});
		btnNewButton.setBounds(44, 42, 89, 23);
		add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnGuardar.setText("MODIFICAR");
				mostrarListado(true);
				mostrarEmpleados(1);
			}
		});
		btnModificar.setBounds(172, 42, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Deshabilitar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnGuardar.setText("DAR DE BAJA");
				mostrarListado(true);
				mostrarEmpleados(1);
			}
		});
		btnEliminar.setBounds(311, 42, 89, 23);
		add(btnEliminar);
		
		JButton btnRestaurar = new JButton("Habilitar");
		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnGuardar.setText("RESTAURAR");
				mostrarListado(true);
				mostrarEmpleados(2);
			}
		});
		btnRestaurar.setBounds(446, 42, 89, 23);
		add(btnRestaurar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventoguardar();
			}
		});
		btnGuardar.setBounds(262, 372, 140, 23);
		add(btnGuardar);
		btnGuardar.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Identidad");
		lblNewLabel_1.setBounds(26, 111, 109, 14);
		add(lblNewLabel_1);
		
		txtidentidad = new JTextField();
		txtidentidad.setBounds(145, 108, 274, 20);
		add(txtidentidad);
		txtidentidad.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre ");
		lblNewLabel_1_1.setBounds(26, 139, 109, 14);
		add(lblNewLabel_1_1);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(145, 136, 274, 20);
		add(txtnombre);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Departamento");
		lblNewLabel_1_1_1.setBounds(26, 164, 109, 14);
		add(lblNewLabel_1_1_1);
		
		cmbdeptoi=new JComboBox();
		cmbdepto = new JComboBox();
		cmbdepto.setBounds(145, 161, 274, 20);
		add(cmbdepto);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Fecha Ingreso");
		lblNewLabel_1_1_1_1.setBounds(293, 189, 109, 14);
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Fecha Nacimiento");
		lblNewLabel_1_1_1_1_1.setBounds(26, 189, 129, 14);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direccion");
		lblNewLabel_1_2.setBounds(26, 237, 109, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Correo Electronico");
		lblNewLabel_1_1_2.setBounds(26, 265, 109, 14);
		add(lblNewLabel_1_1_2);
		
		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(145, 234, 274, 20);
		add(txtdireccion);
		
		txtcorreoe = new JTextField();
		txtcorreoe.setColumns(10);
		txtcorreoe.setBounds(145, 262, 274, 20);
		add(txtcorreoe);
		
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Genero");
		lblNewLabel_1_1_1_1_1_1.setBounds(26, 212, 118, 14);
		add(lblNewLabel_1_1_1_1_1_1);
		
		String d[]= {"[Seleccione un Estado Civil]","Casado(a)","Soltero(a)","Union Libre","Viudo(a)","Divorciado(a)"};
		cmbestadoc = new JComboBox(d);
		cmbestadoc.setBounds(399, 209, 134, 20);
		add(cmbestadoc);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Estado Civil");
		lblNewLabel_1_1_1_1_2.setBounds(293, 214, 109, 14);
		add(lblNewLabel_1_1_1_1_2);
		
		String e[]= {"[Seleccione un Genero]","Masculino","Femenino"};
		cmbgenero = new JComboBox(e);
		cmbgenero.setBounds(145, 209, 134, 20);
		add(cmbgenero);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Movil");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(26, 293, 118, 14);
		add(lblNewLabel_1_1_1_1_1_1_1);
		
		txtmovil = new JTextField();
		txtmovil.setBounds(145, 290, 134, 20);
		add(txtmovil);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Otro");
		lblNewLabel_1_1_1_1_2_1.setBounds(293, 295, 109, 14);
		add(lblNewLabel_1_1_1_1_2_1);
		
		txtotro = new JTextField();
		txtotro.setBounds(399, 293, 134, 20);
		add(txtotro);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Estado");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(26, 321, 118, 14);
		add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		String f[]= {"[Seleccione un Estado]","ACTIVO","INACTIVO"};
		cmbestado = new JComboBox(f);
		cmbestado.setBounds(145, 318, 134, 20);
		add(cmbestado);
		
		dfechan = new JDateChooser();
		dfechan.setBounds(145, 186, 138, 20);
		add(dfechan);
		
		dfechai = new JDateChooser();
		dfechai.setBounds(399, 186, 138, 20);
		add(dfechai);
		
		lblempleado = new JLabel("Listado de Empleados");
		lblempleado.setBounds(93, 76, 207, 14);
		add(lblempleado);
		
		cmbempleadoi=new JComboBox();
		cmbempleado = new JComboBox();
		cmbempleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,""+cmbempleado.getSelectedIndex());
				int indice=cmbempleado.getSelectedIndex();
				
				if(indice!=0)
				{
					String cedula=""+cmbempleadoi.getItemAt(indice);
					//JOptionPane.showMessageDialog(null,cedula);
					llenarCampos(cedula);
				}
			}
		});
		/*cmbempleado.addItemListener(new ItemListener() {
			  public void itemStateChanged(ItemEvent itemEvent) {
			    JOptionPane.showMessageDialog(null,""+cmbempleado.getSelectedIndex());
			  }
			});*/
		cmbempleado.setBounds(235, 75, 233, 22);
		add(cmbempleado);
		
		JButton btnPerfil = new JButton("Ver Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map parameters=new HashMap();
				parameters.put("empleado_codigo",txtidentidad.getText());
				Reporte r=new Reporte(parameters,"src/Reportes/Rep_PerfilEmpleado.jasper");
			}
		});
		btnPerfil.setBounds(409, 372, 89, 23);
		add(btnPerfil);
		
		setLimit();
		mostrarListado(false);
	}
	public void llenarCampos(String cedula)
	{
		String sql="SELECT * FROM tbl_empleado WHERE emp_codigo="+cedula;
		try
		{
			Connection con=new Conexion().getConexion();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				txtidentidad.setText(rs.getString("emp_codigo"));
				txtnombre.setText(rs.getString("emp_nombre"));
				
				//Llenar ComboB por Codigo
				cmbdeptoi.setSelectedItem(rs.getInt("depto_codigo"));
				cmbdepto.setSelectedIndex(cmbdeptoi.getSelectedIndex());
				
				//Llenar ComboB por Indice
				cmbestado.setSelectedIndex(rs.getInt("estado_codigo"));
				
				//Llenar DateChooser desde BD
				String fechan=rs.getString("emp_fechanac");
				Date date=new SimpleDateFormat("yyyy-MM-dd").parse(fechan);
				dfechan.setDate(date);
				fechan=rs.getString("emp_fechaing");
				date=new SimpleDateFormat("yyyy-MM-dd").parse(fechan);
				dfechai.setDate(date);
				
				if(btnGuardar.getText().equals("DAR DE BAJA"))cmbestado.setSelectedIndex(2);
				else if(btnGuardar.getText().equals("RESTAURAR"))cmbestado.setSelectedIndex(1);
			}
			con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null,"Error "+sql+" "+exp);
		}
	}
	public void mostrarEmpleados(int estado)
	{
		String sql="SELECT emp_codigo,emp_nombre FROM tbl_empleado where estado_codigo="+estado+" ORDER BY emp_nombre";
		new BaseDatos().llenarComboBox2(cmbempleadoi,cmbempleado,sql,
				"[Seleccione un Empleado]");
	}
	public void mostrarListado(boolean b)
	{
		cmbempleado.setVisible(b);
		lblempleado.setVisible(b);
	}
	public void limpiar()
	{
		txtidentidad.setText("");
		txtnombre.setText("");
		
		java.util.Date date = new java.util.Date();
		dfechan.setDate(date);
		dfechai.setDate(date);
		
		txtdireccion.setText("");
		txtcorreoe.setText("");
		cmbestadoc.setSelectedIndex(0);
		cmbgenero.setSelectedIndex(0);
		txtmovil.setText("");
		txtotro.setText("");
		cmbestado.setSelectedIndex(0);
		new BaseDatos().llenarComboBox(cmbdeptoi,cmbdepto,
		"SELECT depto_codigo,depto_nombre FROM tbl_departamento ORDER BY depto_nombre",
		"[Seleccione un Departamento]");
		btnGuardar.setVisible(true);
	}
	public void setLimit()
	{
		txtidentidad.setDocument(new Limit(50,false));
		//txtidentidad.setDocument(new Enteros(14));
		//txtidentidad.setDocument(new Moneda(14));
		txtnombre.setDocument(new Limit(250,true));
		txtdireccion.setDocument(new Limit(1000,false));
		txtcorreoe.setDocument(new Limit(300,false));
		txtmovil.setDocument(new Enteros(10));
		txtotro.setDocument(new Enteros(10));
		
	}
	public boolean validarCampos()
	{
		if(txtidentidad.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Favor INgrese una Identidad","Invalido",
					JOptionPane.ERROR_MESSAGE);
			txtidentidad.requestFocus();
			return false;
		}
		else if(txtnombre.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Favor INgrese un NOmbre ","Invalido",
					JOptionPane.ERROR_MESSAGE);
			txtnombre.requestFocus();
			return false;
		}
		else if(cmbdepto.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(null,"Seleccione un Departamento ","Invalido",
					JOptionPane.ERROR_MESSAGE);
			cmbdepto.requestFocus();
			return false;
		}
		return true;
	}
	public void eventoguardar()
	{
		if(btnGuardar.getText().equals("DAR DE BAJA"))
		{
			boolean b=validarCampos();
			if(b)
			{
				int r=JOptionPane.showConfirmDialog(null,"Seguro que desea dar de baja a este empleado?");
				if(r==0)
					{
						modificar();
						JOptionPane.showMessageDialog(null,"Se Retiro Satisfactoriamente");
						limpiar();
						mostrarListado(true);
						mostrarEmpleados(1);
					}
			}
		}
		if(btnGuardar.getText().equals("RESTAURAR"))
		{
			boolean b=validarCampos();
			if(b)
			{
				int r=JOptionPane.showConfirmDialog(null,"Seguro que desea habilitar a este empleado?");
				if(r==0)
					{
						modificar();
						JOptionPane.showMessageDialog(null,"Se Habilito Satisfactoriamente");
						limpiar();
						mostrarListado(true);
						mostrarEmpleados(2);
					}
			}
		}
		if(btnGuardar.getText().equals("MODIFICAR"))
		{
			boolean b=validarCampos();
			if(b)
			{
				int r=JOptionPane.showConfirmDialog(null,"Seguro que desea modificar este empleado?");
				if(r==0)
					{
						modificar();
						JOptionPane.showMessageDialog(null,"Se Modifico Satisfactoriamente");
						limpiar();
						mostrarListado(true);
						mostrarEmpleados(1);
					}
			}
		}
		if(btnGuardar.getText().equals("GUARDAR"))
		{
			if(txtidentidad.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Favor INgrese una Identidad","Invalido",
						JOptionPane.ERROR_MESSAGE);
				txtidentidad.requestFocus();
			}
			else if(txtnombre.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Favor INgrese un NOmbre ","Invalido",
						JOptionPane.ERROR_MESSAGE);
				txtnombre.requestFocus();
			}
			else if(cmbdepto.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Seleccione un Departamento ","Invalido",
						JOptionPane.ERROR_MESSAGE);
				cmbdepto.requestFocus();
			}
			else
			{
				int r=JOptionPane.showConfirmDialog(null,"Seguro que desea guardar este empleado?");
				if(r==0)
					{
						guardar();
						JOptionPane.showMessageDialog(null,"Se Guardo Satisfactoriamente");
						limpiar();
					}
			}
			
		}
	}
	public void guardar()
	{
		int deptoi=Integer.parseInt(cmbdeptoi.getItemAt(cmbdepto.getSelectedIndex()).toString());
		int generoi=cmbgenero.getSelectedIndex();
		int estadoc=cmbestadoc.getSelectedIndex();
		int estadoi=cmbestado.getSelectedIndex();
		
		int anio = dfechai.getCalendar().get(Calendar.YEAR);
		int mes = dfechai.getCalendar().get(Calendar.MONTH)+1;
		int dia = dfechai.getCalendar().get(Calendar.DAY_OF_MONTH);
		String fechai=anio+"-"+mes+"-"+dia;
		
		anio = dfechai.getCalendar().get(Calendar.YEAR);
		mes = dfechai.getCalendar().get(Calendar.MONTH)+1;
		dia = dfechai.getCalendar().get(Calendar.DAY_OF_MONTH);
		String fechan=anio+"-"+mes+"-"+dia;
		
		String sql="insert into tbl_empleado(emp_codigo,emp_nombre,depto_codigo,"
				+ "emp_fechanac,emp_fechaing,genero_codigo,estciv_codigo,emp_direccion,"
				+ "emp_correoe,emp_celular,emp_otro,estado_codigo) "
				+ "values('"+txtidentidad.getText()+"','"+txtnombre.getText()+
				"',"+deptoi+",'"+fechan+"','"+fechai+"',"+generoi+","+estadoc+",'"+txtdireccion.getText()+
				"','"+txtcorreoe.getText()+"','"+txtmovil.getText()+"','"+txtotro.getText()
				+"',"+estadoi+")";
		//System.out.println(sql);
		new BaseDatos().ingresar(sql);
	}
	public void modificar()
	{
		int deptoi=Integer.parseInt(cmbdeptoi.getItemAt(cmbdepto.getSelectedIndex()).toString());
		int generoi=cmbgenero.getSelectedIndex();
		int estadoc=cmbestadoc.getSelectedIndex();
		int estadoi=cmbestado.getSelectedIndex();
		
		int anio = dfechai.getCalendar().get(Calendar.YEAR);
		int mes = dfechai.getCalendar().get(Calendar.MONTH)+1;
		int dia = dfechai.getCalendar().get(Calendar.DAY_OF_MONTH);
		String fechai=anio+"-"+mes+"-"+dia;
		
		anio = dfechai.getCalendar().get(Calendar.YEAR);
		mes = dfechai.getCalendar().get(Calendar.MONTH)+1;
		dia = dfechai.getCalendar().get(Calendar.DAY_OF_MONTH);
		String fechan=anio+"-"+mes+"-"+dia;
		
		/*String sql="insert into tbl_empleado(emp_codigo,emp_nombre,depto_codigo,"
				+ "emp_fechanac,emp_fechaing,genero_codigo,estciv_codigo,emp_direccion,"
				+ "emp_correoe,emp_celular,emp_otro,estado_codigo) "
				+ "values('"+txtidentidad.getText()+"','"+txtnombre.getText()+
				"',"+deptoi+",'"+fechan+"','"+fechai+"',"+generoi+","+estadoc+",'"+txtdireccion.getText()+
				"','"+txtcorreoe.getText()+"','"+txtmovil.getText()+"','"+txtotro.getText()
				+"',"+estadoi+")";*/
		String sql="update tbl_empleado set emp_nombre='"+txtnombre.getText()+
		"',emp_nombre='"+txtnombre.getText()+"', depto_codigo="+deptoi+
		", emp_fechanac='"+fechan+"', emp_fechaing='"+fechai+"', genero_codigo="+generoi+
		",estciv_codigo="+estadoc+",emp_direccion='"+txtdireccion.getText()+
		"', emp_correoe='"+txtcorreoe.getText()+"',emp_celular='"+txtmovil.getText()+
		"',emp_otro='"+txtotro.getText()+"', estado_codigo="+estadoi+
		" where emp_codigo='"+txtidentidad.getText()+"'";
		new BaseDatos().ingresar(sql);
	}
}

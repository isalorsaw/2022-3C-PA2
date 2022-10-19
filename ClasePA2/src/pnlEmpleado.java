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

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class pnlEmpleado extends JPanel {
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
			}
		});
		btnNewButton.setBounds(46, 65, 89, 23);
		add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnGuardar.setText("MODIFICAR");
			}
		});
		btnModificar.setBounds(174, 65, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Deshabilitar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnGuardar.setText("DAR DE BAJA");
			}
		});
		btnEliminar.setBounds(313, 65, 89, 23);
		add(btnEliminar);
		
		JButton btnRestaurar = new JButton("Habilitar");
		btnRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				btnGuardar.setText("RESTAURAR");
			}
		});
		btnRestaurar.setBounds(448, 65, 89, 23);
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
	public void eventoguardar()
	{
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
		int mes = dfechai.getCalendar().get(Calendar.MARCH);
		int dia = dfechai.getCalendar().get(Calendar.DAY_OF_MONTH);
		String fechai=anio+"-"+mes+"-"+dia;
		
		anio = dfechai.getCalendar().get(Calendar.YEAR);
		mes = dfechai.getCalendar().get(Calendar.MARCH);
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
}

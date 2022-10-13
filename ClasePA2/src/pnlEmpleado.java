import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlEmpleado extends JPanel {
	private JTextField txtidentidad;
	private JTextField txtnombre, txtmovil, txtotro;
	private JComboBox cmbdepto,cmbgenero;
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
		btnGuardar.setBounds(262, 372, 140, 23);
		add(btnGuardar);
		
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
		
		cmbestadoc = new JComboBox();
		cmbestadoc.setBounds(399, 209, 134, 20);
		add(cmbestadoc);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Estado Civil");
		lblNewLabel_1_1_1_1_2.setBounds(293, 214, 109, 14);
		add(lblNewLabel_1_1_1_1_2);
		
		cmbgenero = new JComboBox();
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
		
		cmbestado = new JComboBox();
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
		//cmbdepto.setSelectedIndex(0);
		//dfechan.
		//dfechai.
		txtdireccion.setText("");
		txtcorreoe.setText("");
		//cmbestadoc.setSelectedIndex(0);
		//cmbgenero.setSelectedIndex(0);
		txtmovil.setText("");
		txtotro.setText("");
		//cmbestado.setSelectedIndex(0);
	}
}

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class pnlEmpleado extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox textField_5;
	private JComboBox textField_6;
	private JTextField txtdate;
	private JTextField txtdate2;
	private JDateChooser dfechan;
	private JDateChooser dfechai;

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
		btnNewButton.setBounds(46, 65, 89, 23);
		add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(174, 65, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Deshabilitar");
		btnEliminar.setBounds(313, 65, 89, 23);
		add(btnEliminar);
		
		JButton btnRestaurar = new JButton("Habilitar");
		btnRestaurar.setBounds(448, 65, 89, 23);
		add(btnRestaurar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(262, 372, 89, 23);
		add(btnGuardar);
		
		JLabel lblNewLabel_1 = new JLabel("Identidad");
		lblNewLabel_1.setBounds(26, 111, 109, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(145, 108, 274, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre ");
		lblNewLabel_1_1.setBounds(26, 139, 109, 14);
		add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 136, 274, 20);
		add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Departamento");
		lblNewLabel_1_1_1.setBounds(26, 164, 109, 14);
		add(lblNewLabel_1_1_1);
		
		textField_2 = new JComboBox();
		textField_2.setBounds(145, 161, 274, 20);
		add(textField_2);
		
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 234, 274, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(145, 262, 274, 20);
		add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Genero");
		lblNewLabel_1_1_1_1_1_1.setBounds(26, 212, 118, 14);
		add(lblNewLabel_1_1_1_1_1_1);
		
		textField_5 = new JComboBox();
		textField_5.setBounds(399, 209, 134, 20);
		add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Estado Civil");
		lblNewLabel_1_1_1_1_2.setBounds(293, 214, 109, 14);
		add(lblNewLabel_1_1_1_1_2);
		
		JComboBox textField_5_1 = new JComboBox();
		textField_5_1.setBounds(145, 209, 134, 20);
		add(textField_5_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Movil");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(26, 293, 118, 14);
		add(lblNewLabel_1_1_1_1_1_1_1);
		
		JTextField textField_5_1_1 = new JTextField();
		textField_5_1_1.setBounds(145, 290, 134, 20);
		add(textField_5_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Otro");
		lblNewLabel_1_1_1_1_2_1.setBounds(293, 295, 109, 14);
		add(lblNewLabel_1_1_1_1_2_1);
		
		JComboBox textField_5_2 = new JComboBox();
		textField_5_2.setBounds(399, 293, 134, 20);
		add(textField_5_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Estado");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(26, 321, 118, 14);
		add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		textField_6 = new JComboBox();
		textField_6.setBounds(145, 318, 134, 20);
		add(textField_6);
		
		dfechan = new JDateChooser();
		dfechan.setBounds(145, 186, 138, 20);
		add(dfechan);
		
		dfechai = new JDateChooser();
		dfechai.setBounds(399, 186, 138, 20);
		add(dfechai);
	}
}

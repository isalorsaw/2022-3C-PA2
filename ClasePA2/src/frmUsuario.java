import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class frmUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private JComboBox textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUsuario frame = new frmUsuario();
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
	public frmUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento de Usuarios");
		lblNewLabel.setBounds(110, 10, 214, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Empleados");
		lblNewLabel_1.setBounds(23, 59, 155, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 55, 183, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1.setBounds(23, 100, 155, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Clave");
		lblNewLabel_1_1_1.setBounds(23, 134, 155, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Confirmacion");
		lblNewLabel_1_1_1_1.setBounds(23, 170, 155, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Estado");
		lblNewLabel_1_1_1_1_1.setBounds(23, 208, 155, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(163, 238, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(130, 97, 183, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 131, 183, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 167, 183, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JComboBox();
		textField_3.setBounds(130, 205, 183, 20);
		contentPane.add(textField_3);
	}
}

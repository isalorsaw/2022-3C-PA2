import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class frmDepto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDepto frame = new frmDepto();
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
	public frmDepto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setBounds(33, 30, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnModificaer = new JButton("Modificar");
		btnModificaer.setBounds(33, 81, 89, 23);
		contentPane.add(btnModificaer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(238, 30, 164, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Datos del Departamento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(151, 64, 251, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Listado");
		lblNewLabel_1.setBounds(153, 34, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(238, 95, 164, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre ");
		lblNewLabel_1_1.setBounds(164, 98, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("ACCION");
		btnNewButton_1.setBounds(151, 169, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mantenimiento de Departamentos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(33, 0, 369, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Estado");
		lblNewLabel_1_1_1.setBounds(164, 129, 46, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_1 = new JComboBox();
		textField_1.setBounds(238, 126, 164, 20);
		contentPane.add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(132, 81, 284, 77);
		contentPane.add(panel);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PtoVenta2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PtoVenta2 frame = new PtoVenta2();
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
	public PtoVenta2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Silla # 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(29, 50, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSilla = new JButton("Silla # 2");
		btnSilla.setBounds(29, 76, 89, 23);
		contentPane.add(btnSilla);
		
		JButton btnNewButton_1_1 = new JButton("Silla # 3");
		btnNewButton_1_1.setBounds(29, 104, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Silla # 4");
		btnNewButton_1_1_1.setBounds(29, 130, 89, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Silla # 5");
		btnNewButton_1_1_1_1.setBounds(29, 157, 89, 23);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Venta de Boleteria");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 11, 378, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mostrar el Numero de Silla seleccionada");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(138, 54, 250, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vendedor");
		lblNewLabel_2.setBounds(148, 80, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pelicula");
		lblNewLabel_2_1.setBounds(148, 108, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("# Boletos");
		lblNewLabel_2_1_1.setBounds(148, 134, 46, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(232, 76, 169, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(232, 104, 169, 22);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(232, 131, 169, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBounds(213, 162, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

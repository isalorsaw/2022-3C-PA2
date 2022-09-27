import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Archivo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class frmConfigBD extends JFrame {

	private JPanel contentPane;
	private JTextField txtubicacion;
	private JTextField txtbd;
	private JTextField txtusuario;
	private JPasswordField txtclave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConfigBD frame = new frmConfigBD();
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
	public frmConfigBD() {
		setTitle("Configuracion Base de Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configuracion Credenciales para Base de Datos");
		lblNewLabel.setBounds(10, 11, 403, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ubicacion");
		lblNewLabel_1.setBounds(10, 47, 403, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Base de Datos");
		lblNewLabel_2.setBounds(10, 107, 414, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setBounds(10, 160, 403, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Clave");
		lblNewLabel_4.setBounds(10, 223, 389, 14);
		contentPane.add(lblNewLabel_4);
		
		txtubicacion = new JTextField();
		txtubicacion.setBounds(10, 76, 414, 20);
		contentPane.add(txtubicacion);
		txtubicacion.setColumns(10);
		
		txtbd = new JTextField();
		txtbd.setBounds(10, 129, 414, 20);
		contentPane.add(txtbd);
		txtbd.setColumns(10);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(10, 185, 414, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtclave = new JPasswordField();
		txtclave.setBounds(10, 248, 414, 20);
		contentPane.add(txtclave);
		
		JButton btnNewButton = new JButton("Conectar");
		btnNewButton.setBounds(169, 292, 89, 23);
		contentPane.add(btnNewButton);
		
		cargarDatos();
	}
	public void cargarDatos()
	{
		Archivo a=new Archivo("src/Archivos/config.txt");
		String info=a.traeLinea(2);
		
		String arr[]=info.split(";");
		txtubicacion.setText(arr[0]);
		txtbd.setText(arr[1]);
		txtusuario.setText(arr[2]);
		txtclave.setText(arr[3]);
		
	}
}

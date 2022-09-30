import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Archivo;
import Clases.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConfigBD extends JFrame {

	private JPanel contentPane;
	private JTextField txtubicacion;
	private JTextField txtbd;
	private JTextField txtusuario;
	private JPasswordField txtclave;
	Conexion con=new Conexion();
	Archivo arc=new Archivo("src/Archivos/config.txt");
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conectar();
			}
		});
		btnNewButton.setBounds(169, 292, 89, 23);
		contentPane.add(btnNewButton);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarDatos();
			}
		});
		//cargarDatos();
	}
	public void conectar()
	{
		boolean v=validar();
		if(v)
		{
			Conexion con2=new Conexion(txtubicacion.getText(),txtbd.getText(),txtusuario.getText(),String.valueOf(txtclave.getPassword()));
			if(!con2.getConexionState())
			JOptionPane.showMessageDialog(null,"Error de Conexion","Error de Conexion",JOptionPane.ERROR_MESSAGE);
			
			else
			{
				int r=JOptionPane.showConfirmDialog(this,"Seguro Desea Modificar los Datos de la BD");
				if(r==0)
				{
					String i=txtubicacion.getText()+";"+txtbd.getText()+";"+
					txtusuario.getText()+";"+String.valueOf(txtclave.getPassword())+";";
					try {
						arc.guardarEnPos(i,2);
						JOptionPane.showMessageDialog(null,"Guardado Satisfactoriamente");
						dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public boolean validar()
	{
		if(txtubicacion.getText().isEmpty())
		JOptionPane.showMessageDialog(null,"Llenar Ubicacion","Invalido",JOptionPane.ERROR_MESSAGE);
	
		else if(txtbd.getText().isEmpty())
		JOptionPane.showMessageDialog(null,"Ingrese Base de Datos","Invalido",JOptionPane.ERROR_MESSAGE);
		
		else if(txtusuario.getText().isEmpty())
		JOptionPane.showMessageDialog(null,"Ingrese Usuario","Invalido",JOptionPane.ERROR_MESSAGE);
		
		else if(String.valueOf(txtclave.getPassword()).isEmpty())
		JOptionPane.showMessageDialog(null,"Ingrese Clave","Invalido",JOptionPane.ERROR_MESSAGE);
		
		else return true;
		return false;
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

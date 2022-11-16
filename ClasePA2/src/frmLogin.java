import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.BaseDatos;
import Clases.Sesion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	int contador=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);//Centrar el Frame
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entrada de Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 22, 362, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblusuario = new JLabel("Usuario");
		lblusuario.setBounds(64, 63, 109, 14);
		contentPane.add(lblusuario);
		
		JLabel lblpass = new JLabel("Clave");
		lblpass.setBounds(64, 94, 109, 14);
		contentPane.add(lblpass);
		
		txtUser = new JTextField();
		txtUser.setText("admin");
		txtUser.setBounds(127, 60, 178, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setText("12345");
		txtPass.setBounds(127, 88, 178, 20);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		btnNewButton.setBounds(150, 137, 89, 23);
		contentPane.add(btnNewButton);
	}
	public void validar()
	{
		if(txtUser.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Favor ingrese un usuario");
			txtUser.requestFocus();
		}
		else if(String.valueOf(txtPass.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Favor ingrese una clave");
			txtPass.requestFocus();
		}
		else
		{
			String sql="SELECT * FROM tbl_user WHERE user_usuario='"+txtUser.getText()+
				"' AND user_clave='"+String.valueOf(txtPass.getPassword())+
				"' AND user_estado='ACTIVO'";
			boolean s=new BaseDatos().siExiste(sql);
			if(s)
			{
				Sesion.user=txtUser.getText();
				abrirPrincipal();
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Usuario y Clave Incorrecta");
				contador++;
				if(contador==3)
				{
					//Inactivar el Usuario
					sql="UPDATE tbl_user SET user_estado='BLOQUEADO' WHERE "+
					"user_usuario='"+txtUser.getText()+"'";
					new BaseDatos().ingresar(sql);
					JOptionPane.showMessageDialog(null,"El Usuario ha sido Bloqueado");
				}
			}
		}
	}
	public void abrirPrincipal()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.BaseDatos;
import Clases.Sesion;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	private pnlEmpleado panelemp;
	private pnlCliente panelcli;
	private pnlProducto panelprod;
	private pnlPedido panelped;
	private pnlFacturacion panelfac;
	private pnlReporte panelrep;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setTitle("Pantalla Principal Sistema de Inventario Usuario: "+Sesion.user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBackground(new Color(64, 224, 208));
		pnlTitulo.setBounds(0, 0, 831, 104);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pantalla Principal Sistema de Inventario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(166, 27, 655, 34);
		pnlTitulo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/logo.png")));
		lblNewLabel_1.setBounds(33, 11, 123, 82);
		pnlTitulo.add(lblNewLabel_1);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(224, 255, 255));
		pnlMenu.setBounds(0, 105, 223, 406);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				panelemp.setVisible(true);
			}
		});
		btnEmpleado.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEmpleado.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpleado.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnEmpleado.setBounds(10, 23, 95, 59);
		pnlMenu.add(btnEmpleado);
		btnEmpleado.setVisible(new BaseDatos().getAcceso(Sesion.user,1));
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				panelcli.setVisible(true);
			}
		});
		btnCliente.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCliente.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnCliente.setBounds(115, 23, 95, 59);
		pnlMenu.add(btnCliente);
		btnCliente.setVisible(new BaseDatos().getAcceso(Sesion.user,2));
		
		JButton btnProducto = new JButton("Producto");
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				panelprod.setVisible(true);
			}
		});
		btnProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProducto.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnProducto.setBounds(10, 92, 95, 59);
		pnlMenu.add(btnProducto);
		btnProducto.setVisible(new BaseDatos().getAcceso(Sesion.user,3));
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				panelped.setVisible(true);
			}
		});
		btnPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPedido.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnPedido.setBounds(115, 92, 95, 59);
		pnlMenu.add(btnPedido);
		btnPedido.setVisible(new BaseDatos().getAcceso(Sesion.user,4));
		
		JButton btnFactura = new JButton("Factura");
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				panelfac.setVisible(true);
			}
		});
		btnFactura.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFactura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFactura.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnFactura.setBounds(10, 168, 95, 59);
		pnlMenu.add(btnFactura);
		btnFactura.setVisible(new BaseDatos().getAcceso(Sesion.user,5));
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				panelrep.setVisible(true);
			}
		});
		btnReportes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReportes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReportes.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnReportes.setBounds(115, 168, 95, 59);
		pnlMenu.add(btnReportes);
		btnReportes.setVisible(new BaseDatos().getAcceso(Sesion.user,6));
		
		JButton btnAccesos = new JButton("Accesos");
		btnAccesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new frmAccesos().setVisible(true);
			}
		});
		btnAccesos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAccesos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAccesos.setBounds(10, 248, 95, 59);
		pnlMenu.add(btnAccesos);
		
		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new frmUsuario().setVisible(true);
			}
		});
		btnNewButton.setBounds(121, 248, 89, 59);
		pnlMenu.add(btnNewButton);
		btnAccesos.setVisible(new BaseDatos().getAcceso(Sesion.user,8));
		btnNewButton.setVisible(new BaseDatos().getAcceso(Sesion.user,7));
		
		/*JPanel pnlCentral = new JPanel();
		pnlCentral.setBounds(224, 105, 607, 406);
		contentPane.add(pnlCentral);*/
		
		panelemp = new pnlEmpleado();
		panelemp.setBounds(224, 105, 607, 406);
		contentPane.add(panelemp);
		
		panelcli = new pnlCliente();
		panelcli.setBounds(224, 105, 607, 406);
		contentPane.add(panelcli);
		
		panelprod = new pnlProducto();
		panelprod.setBounds(224, 105, 607, 406);
		contentPane.add(panelprod);
		
		panelfac = new pnlFacturacion();
		panelfac.setBounds(224, 105, 607, 406);
		contentPane.add(panelfac);
		
		panelped = new pnlPedido();
		panelped.setBounds(224, 105, 607, 406);
		contentPane.add(panelped);
		
		panelrep = new pnlReporte();
		panelrep.setBounds(224, 105, 607, 406);
		contentPane.add(panelrep);
		
		limpiar();
	}
	public void limpiar()
	{
		panelemp.setVisible(false);
		panelcli.setVisible(false);
		panelprod.setVisible(false);
		panelfac.setVisible(false);
		panelped.setVisible(false);
		panelrep.setVisible(false);
	}
}

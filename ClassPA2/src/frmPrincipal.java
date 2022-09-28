import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;

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
		setTitle("Pantalla Principal Sistema de Inventario");
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
		btnEmpleado.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEmpleado.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpleado.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnEmpleado.setBounds(10, 23, 95, 59);
		pnlMenu.add(btnEmpleado);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCliente.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnCliente.setBounds(115, 23, 95, 59);
		pnlMenu.add(btnCliente);
		
		JButton btnProducto = new JButton("Producto");
		btnProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProducto.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnProducto.setBounds(10, 92, 95, 59);
		pnlMenu.add(btnProducto);
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPedido.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnPedido.setBounds(115, 92, 95, 59);
		pnlMenu.add(btnPedido);
		
		JButton btnFactura = new JButton("Factura");
		btnFactura.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFactura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFactura.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnFactura.setBounds(10, 168, 95, 59);
		pnlMenu.add(btnFactura);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReportes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReportes.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Imagenes/boton.png")));
		btnReportes.setBounds(115, 168, 95, 59);
		pnlMenu.add(btnReportes);
		
		JPanel pnlCentral = new JPanel();
		pnlCentral.setBounds(224, 105, 607, 406);
		contentPane.add(pnlCentral);
	}
}

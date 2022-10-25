import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.BaseDatos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PtoVenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JButton btnGuardar;
	private JComboBox cmbProducto;
	private JComboBox cmbProductoi;
	private int numesa=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PtoVenta frame = new PtoVenta();
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
	public PtoVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Mesa 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				numesa=1;
			}
		});
		btnNewButton.setBounds(10, 30, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnMesa = new JButton("Mesa 2 ");
		btnMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				numesa=2;
			}
		});
		btnMesa.setBounds(10, 61, 89, 23);
		contentPane.add(btnMesa);
		
		JButton btnNewButton_1_1 = new JButton("Mesa 3");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				numesa=3;
			}
		});
		btnNewButton_1_1.setBounds(10, 95, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Mesa 4");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
				numesa=4;
			}
		});
		btnNewButton_1_1_1.setBounds(10, 129, 89, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setBounds(125, 34, 115, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(125, 65, 115, 14);
		contentPane.add(lblCantidad);
		
		cmbProductoi = new JComboBox();
		cmbProducto = new JComboBox();
		cmbProducto.setBounds(240, 30, 145, 22);
		contentPane.add(cmbProducto);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(240, 62, 145, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		btnGuardar.setBounds(171, 116, 89, 23);
		contentPane.add(btnGuardar);
		btnGuardar.setVisible(false);
	}
	public void validar()
	{
		if(cmbProducto.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(null, "Seleccione Un producto de la lista");
			cmbProducto.requestFocus();
		}
		else if(txtCantidad.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Favor INgrese la Cantidad");
			txtCantidad.requestFocus();
		}
		else
		{
			int r=JOptionPane.showConfirmDialog(null,"Seguro que desea guardar");
			if(r==0)
			{
				int prodi=Integer.parseInt(cmbProductoi.getItemAt(cmbProducto.getSelectedIndex()).toString());
				int cantidad=Integer.parseInt(txtCantidad.getText());
				String sql="INSERT INTO tbl_pedido(mesa_num,prod_codigo,pedido_cant,pedido_total,pedido_estado)\r\n"
						+ "VALUES("+numesa+","+prodi+","+cantidad+",0,'PENDIENTE')";
				new BaseDatos().ingresar(sql);
				JOptionPane.showMessageDialog(null,"Se guardo satisfactoriamente");
				limpiar();
			}
			//JOptionPane.showMessageDialog(null,""+r);
		}
	}
	public void limpiar()
	{
		txtCantidad.setText("");
		new BaseDatos().llenarComboBox(cmbProductoi,cmbProducto,"SELECT prod_codigo,prod_nombre FROM tbl_producto","");
		btnGuardar.setVisible(true);
	}
}

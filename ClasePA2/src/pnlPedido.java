import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.BaseDatos;
import Clases.Dialogo;
import Clases.Enteros;
import Clases.Limit;
import Clases.Moneda;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlPedido extends JPanel {
	private JTable table;
	private JTextField txtcodigo;
	private JTextField txtcantidad;
	private JTextField txtprecio;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox cmbproductoi,cmbproducto;
	private double impuesto;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public pnlPedido() {
		setSize(607, 408);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pedidos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 11, 546, 32);
		add(lblNewLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(216, 374, 89, 23);
		add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 99, 546, 180);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Descripcion", "Cantidad", "Precio Unitario", "Impuesto", "Total", "New column"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		scrollPane.setViewportView(table);
		model=(DefaultTableModel)table.getModel();
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setBounds(34, 48, 46, 14);
		add(lblNewLabel_1);
		
		txtcodigo = new JTextField();
		txtcodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarProductos();
			}
		});
		txtcodigo.setBounds(82, 42, 171, 20);
		add(txtcodigo);
		txtcodigo.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
		lblNewLabel_1_1.setBounds(269, 48, 46, 14);
		add(lblNewLabel_1_1);
		
		txtcantidad = new JTextField();
		txtcantidad.setColumns(10);
		txtcantidad.setBounds(325, 42, 51, 20);
		add(txtcantidad);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Precio Unit");
		lblNewLabel_1_1_1.setBounds(386, 48, 63, 14);
		add(lblNewLabel_1_1_1);
		
		txtprecio = new JTextField();
		txtprecio.setEditable(false);
		txtprecio.setColumns(10);
		txtprecio.setBounds(459, 42, 51, 20);
		add(txtprecio);
		
		JButton btnagregar = new JButton("Agregar");
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEnTabla();
			}
		});
		btnagregar.setBounds(518, 39, 79, 23);
		add(btnagregar);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre del Producto");
		lblNewLabel_1_2.setBounds(34, 73, 148, 14);
		add(lblNewLabel_1_2);
		
		cmbproductoi = new JComboBox();
		cmbproducto = new JComboBox();
		cmbproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbproducto.getSelectedIndex()>0)buscarPrecio();
			}
		});
		cmbproducto.setBounds(152, 66, 343, 22);
		add(cmbproducto);
		
		JLabel lblNewLabel_2 = new JLabel("Sub-Total");
		lblNewLabel_2.setBounds(325, 290, 81, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Impuesto");
		lblNewLabel_2_1.setBounds(325, 312, 81, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Descuento");
		lblNewLabel_2_1_1.setBounds(325, 332, 81, 14);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Total Pagar");
		lblNewLabel_2_1_1_1.setBounds(315, 361, 81, 14);
		add(lblNewLabel_2_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(416, 290, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(416, 312, 86, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(416, 335, 86, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(416, 358, 86, 20);
		add(textField_6);
		limitar();
	}
	public void agregarEnTabla()
	{
		if(cmbproducto.getSelectedIndex()<=0)
		{
			Dialogo.mensaje("Favor Seleccione un Producto");
		}
		else if(txtcantidad.getText().equals(""))
		{
			Dialogo.mensaje("Debe de Ingresar una Cantidad");
		}
		else if(txtprecio.getText().equals(""))
		{
			Dialogo.mensaje("Debe de Buscar un Producto");
		}
		else
		{
			double preciou=Double.parseDouble(txtprecio.getText());
			double impu=preciou*(impuesto/100);
			double cant=Double.parseDouble(txtcantidad.getText());
			String fila[]=new String[7];
			fila[0]=txtcodigo.getText();
			fila[1]=cmbproducto.getSelectedItem()+"";
			fila[2]=txtcantidad.getText();
			fila[3]=txtprecio.getText();
			fila[4]=impu+"";
			fila[5]=""+((preciou+impu)*cant);
			model.addRow(fila);
		}
	}
	public void buscarPrecio()
	{
		String codprod=cmbproductoi.getItemAt(cmbproducto.getSelectedIndex())+"";
		String sql="SELECT \r\n"
				+ "CONCAT(round(p.prod_precio,2),';',i.impuesto_valor)AS info,\r\n"
				+ "p.prod_precio,\r\n"
				+ "i.impuesto_valor \r\n"
				+ "from tbl_producto p\r\n"
				+ "INNER JOIN tbl_impuesto i ON i.impuesto_codigo=p.impuesto_codigo\r\n"
				+ "WHERE p.prod_codigo='"+txtcodigo.getText()+"'";
		String dato=new BaseDatos().getDato(sql);
		String s[]=dato.split(";");
		impuesto=Double.parseDouble(s[1]);
		txtprecio.setText(s[0]);
	}
	public void cargarProductos()
	{
		if(txtcodigo.getText().equals(""))
		{
			
		}
		else
		{
			//Dialogo.mensaje("Cargando");
			new BaseDatos().llenarComboBox(cmbproductoi,cmbproducto,
			"select prod_codigo,prod_nombre from tbl_producto where prod_codigo "+
			"LIKE '%"+txtcodigo.getText()+"%' OR prod_nombre LIKE '%"+txtcodigo.getText()+
			"%' and prod_estado='ACTIVO'","[Seleccione un Producto]");
		
			if(cmbproducto.getItemCount()==2)cmbproducto.setSelectedIndex(1);
		}
	}
	public void limitar()
	{
		txtcodigo.setDocument(new Limit(50,true));
		txtcantidad.setDocument(new Moneda(11));
	}
}

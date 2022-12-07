import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Clases.Reporte;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class pnlProducto extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlProducto() {
		setSize(607, 406);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento de Producto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 11, 546, 32);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(46, 65, 89, 23);
		add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(174, 65, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Deshabilitar");
		btnEliminar.setBounds(313, 65, 89, 23);
		add(btnEliminar);
		
		JButton btnRestaurar = new JButton("Habilitar");
		btnRestaurar.setBounds(448, 65, 89, 23);
		add(btnRestaurar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(262, 372, 89, 23);
		add(btnGuardar);
		
		JButton btnNewButton_1 = new JButton("Reporte");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map parameters=new HashMap();
				//parameters.put("empleado_codigo",txtidentidad.getText());
				Reporte r=new Reporte(parameters,"src/Reportes/rep_productos.jasper");
			}
		});
		btnNewButton_1.setBounds(364, 372, 89, 23);
		add(btnNewButton_1);
	}
}

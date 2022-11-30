package Clases;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.net.*;
import java.util.*;
import java.util.List;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.base.JRBaseQuery;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperRunManager;
import java.io.*;
import javax.naming.InitialContext;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Reporte 
{
	public Reporte(Map parameters, String n)
	{
		System.out.println(n);
		try
		{
			URL urlMaestro = getClass().getResource(n);
			JasperReport masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
            masterReport.setWhenNoDataType(masterReport.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
            Connection con=new Conexion().getConexion();
			JasperPrint jasperPrint = null;
			jasperPrint= JasperFillManager.fillReport(masterReport,parameters,con);
			
			JRViewer jrv = new JRViewer(jasperPrint);
			jrv.setZoomRatio(new Float(0.99));
			
			if(jasperPrint.getPages().isEmpty()==false)
			{
				new Visor_Reportes(jrv,"Vista de Reporte");
      		}
      		else
      		{
      			
      		}

      		try
      		{
				con.close();
			}catch(Exception exp){}   		
    	} 
    	catch (Exception j) { 
    		JOptionPane.showMessageDialog(null,"Mensaje de Error:"+j.getMessage(),"Error en Reporte",0);
      		j.printStackTrace(); 
    	}
	}
}
class Visor_Reportes extends JDialog
{

    public Visor_Reportes(JRViewer jrv, String str)
    {
        super(new JFrame(), str, true);
        con = new Container();
        java.awt.Image icon = Toolkit.getDefaultToolkit().getImage("Images/food.gif");
        setIconImage(icon);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.white);
        setModal(true);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        jrv.setPreferredSize(new Dimension(pantalla.width - 120, pantalla.height - 150));
        JScrollPane reportScroll = new JScrollPane(jrv);
        JPanel viewer = new JPanel();
        viewer.add(jrv);
        addWindowListener(new WindowAdapter() {

            public void windowOpened(WindowEvent windowevent)
            {
            }

            public void windowClosing(WindowEvent e)
            {
                dispose();
            }

            final Visor_Reportes this$0;

            
            {
                this$0 = Visor_Reportes.this;
            }
        }
);
        viewer.setBounds(10, 10, pantalla.width - 100, pantalla.height);
        getContentPane().add(viewer);
        setSize(new Dimension(pantalla.width - 50, pantalla.height - 50));
        setJMenuBar(menu());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JMenuBar menu()
    {
        JMenu menuArchivo = new JMenu("ARCHIVO");
        menuArchivo.setMnemonic('A');
        menuArchivo.setBackground(Color.WHITE);
        JMenuItem exit = new JMenuItem("Salir", new ImageIcon("Imagenes/exit.jpg"));
        exit.setMnemonic('S');
        exit.setAccelerator(KeyStroke.getKeyStroke(115, 8));
        exit.setAccelerator(KeyStroke.getKeyStroke(27, 0));
        exit.setBackground(Color.WHITE);
        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }

            final Visor_Reportes this$0;

            
            {
                this$0 = Visor_Reportes.this;
            }
        }
);
        menuArchivo.add(exit);
        JMenuBar barra = new JMenuBar();
        barra.setBackground(Color.WHITE);
        barra.add(menuArchivo);
        return barra;
    }

    JLabel muestra;
    JButton Ok;
    Dimension cuadro;
    Container con;
}
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class MainFrame extends JFrame{
	public MainFrame()
	{
		setTitle("Bienvenido");
		setSize(500,500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String args[])
	{
		MainFrame mf=new MainFrame();
	}
}

package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal2 {

	private JFrame frame;
	
	private AgregarInstitucion agregarInstitutoInternalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 window = new Principal2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal2() {
		initialize();
		
		Fabrica fabrica = Fabrica.getInstancia();
        IControlador icon = fabrica.getIControlador();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		agregarInstitutoInternalFrame = new AgregarInstitucion(icon);
		jInternalFrameSize = agregarInstitutoInternalFrame.getSize();
		agregarInstitutoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		agregarInstitutoInternalFrame.setVisible(false);
		frame.getContentPane().add(agregarInstitutoInternalFrame);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		frame.setJMenuBar(menuBar_1);
		
		JMenu mnAlta = new JMenu("Alta");
		menuBar_1.add(mnAlta);
		
		JMenuItem mntmInstitucionDeportiva = new JMenuItem("Institucion Deportiva");
		mntmInstitucionDeportiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInstitutoInternalFrame.setVisible(true);
			}
		});
		mnAlta.add(mntmInstitucionDeportiva);
		
		JMenu mnInformacion = new JMenu("Informacion");
		menuBar_1.add(mnInformacion);
	}
}

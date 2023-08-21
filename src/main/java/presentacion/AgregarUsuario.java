package presentacion;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

import interfaces.IControlador;

public class AgregarUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarUsuario frame = new AgregarUsuario();
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
	public AgregarUsuario(IControlador icon, JDialog dialogoPadre) {
		setBounds(100, 100, 450, 300);

	}

}
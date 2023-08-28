package presentacion;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

import interfaces.IControlador;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ConsultaUsuario extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JDialog dialogoPadre;
	private JComboBox<String> comboBoxNickname;
	
	public ConsultaUsuario(IControlador icon, JDialog dialogoPadre) {
		// Título de la ventata
				setTitle("Consulta Usuario");
				this.dialogoPadre = dialogoPadre;
				this.icon = icon;
				setBounds(100, 100, 377, 443);
				getContentPane().setBackground(new Color(54, 61, 75));
				getContentPane().setLayout(null);
				
				JLabel lblUsuario = new JLabel("Usuario ");
				lblUsuario.setForeground(new Color(255, 255, 255));
				lblUsuario.setBounds(23, 18, 83, 20);
				getContentPane().add(lblUsuario);
				
				comboBoxNickname = new JComboBox<String>();
				comboBoxNickname.setBackground(new Color(54, 61, 75));
				comboBoxNickname.setForeground(new Color(255, 255, 255));
				comboBoxNickname.setBounds(104, 16, 115, 24);
				getContentPane().add(comboBoxNickname);
	}
	
	public void inciarComboBoxUsuario() {
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>(icon.listarUsuarios());
		comboBoxNickname.setModel(modelUsuarios);
	}
	
}

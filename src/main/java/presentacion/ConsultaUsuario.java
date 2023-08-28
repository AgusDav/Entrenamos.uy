package presentacion;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

import interfaces.IControlador;
import javax.swing.JLabel;

import datatypes.DtClase;
import datatypes.DtEntrenamiento;
import datatypes.DtSpinning;
import datatypes.DtUsuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	private IControlador icon;
	private JDialog dialogoPadre;
	private JComboBox<String> comboBoxNickname;
	private JLabel datoFecNac;
	private JLabel datoNombre;
	private JLabel datoApellido;
	private JLabel datoEmail;
	
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
				comboBoxNickname.addActionListener(this::comboBoxNicknameActionPerformed);
				getContentPane().add(comboBoxNickname);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setForeground(new Color(255, 255, 255));
				lblNombre.setBackground(new Color(255, 255, 255));
				lblNombre.setBounds(23, 61, 70, 15);
				getContentPane().add(lblNombre);
				
				JLabel lblApellido = new JLabel("Apellido:");
				lblApellido.setForeground(Color.WHITE);
				lblApellido.setBackground(Color.WHITE);
				lblApellido.setBounds(23, 88, 70, 15);
				getContentPane().add(lblApellido);
				
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setForeground(Color.WHITE);
				lblEmail.setBackground(Color.WHITE);
				lblEmail.setBounds(23, 115, 70, 15);
				getContentPane().add(lblEmail);
				
				JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
				lblFechaDeNacimiento.setFont(new Font("Dialog", Font.BOLD, 10));
				lblFechaDeNacimiento.setForeground(Color.WHITE);
				lblFechaDeNacimiento.setBackground(Color.WHITE);
				lblFechaDeNacimiento.setBounds(23, 142, 161, 15);
				getContentPane().add(lblFechaDeNacimiento);
				
				datoNombre = new JLabel("");
				datoNombre.setForeground(new Color(255, 255, 255));
				datoNombre.setBounds(174, 61, 115, 15);
				getContentPane().add(datoNombre);
				
				datoApellido = new JLabel("");
				datoApellido.setForeground(Color.WHITE);
				datoApellido.setBounds(174, 88, 115, 15);
				getContentPane().add(datoApellido);
				
				datoEmail = new JLabel("");
				datoEmail.setForeground(Color.WHITE);
				datoEmail.setBounds(174, 115, 115, 15);
				getContentPane().add(datoEmail);
				
				datoFecNac = new JLabel("");
				datoFecNac.setForeground(Color.WHITE);
				datoFecNac.setBounds(174, 141, 115, 15);
				getContentPane().add(datoFecNac);
	}
	
	private void comboBoxNicknameActionPerformed(ActionEvent evt) {
	    String nick = (String) comboBoxNickname.getSelectedItem();
	    
	    if (nick != null) {
	        DtUsuario dtu = icon.obtenerUsuario(nick);
	        datoNombre.setText(dtu.getNombre());
	        datoApellido.setText(dtu.getApellido());
	        datoEmail.setText(dtu.getEmail());
	        datoFecNac.setText(dtu.getFecNac().toString());
	    }
	}
	
	public void inciarComboBoxUsuario() {
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>(icon.listarUsuarios());
		comboBoxNickname.setModel(modelUsuarios);
		comboBoxNicknameActionPerformed(null);
	}
}

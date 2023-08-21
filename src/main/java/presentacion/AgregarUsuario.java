package presentacion;

import java.time.LocalDate;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import interfaces.IControlador;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AgregarUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControlador icon;
	private JDialog dialogoPadre;
	private JTextField nickname;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField email;
	private JDateChooser fecNac;
	
	public AgregarUsuario(IControlador icon, JDialog dialogoPadre) {
		setTitle("Agregar Usuario");
		this.dialogoPadre = dialogoPadre;
		this.icon = icon;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(12, 22, 70, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 49, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 76, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 103, 70, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(12, 130, 139, 15);
		getContentPane().add(lblFechaNacimiento);
		fecNac = new JDateChooser();
        fecNac.setBounds(160, 128, 150, 19);
        getContentPane().add(fechaNacimiento);
		

	}
}
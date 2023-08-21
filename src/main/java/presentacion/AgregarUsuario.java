package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import interfaces.IControlador;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

public class AgregarUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControlador icon;
	private JDialog dialogoPadre;
	private JDateChooser fecNac;
	private JTextField textFieldNick;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDescripcion;
	private JTextField textFieldWeb;
	private JTextField textFieldBio;
	
	public AgregarUsuario(IControlador icon, JDialog dialogoPadre) {
		setTitle("Agregar Usuario");
		this.dialogoPadre = dialogoPadre;
		this.icon = icon;
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(54, 61, 75));;
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(new Color(255, 255, 255));
		lblNickname.setBounds(12, 22, 70, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(12, 49, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(12, 76, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setBounds(12, 103, 70, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setForeground(new Color(255, 255, 255));
		lblFechaNacimiento.setBounds(12, 130, 139, 15);
		getContentPane().add(lblFechaNacimiento);
		fecNac = new JDateChooser();
        fecNac.setBounds(160, 128, 150, 19);
        getContentPane().add(fecNac);
        
        textFieldNick = new JTextField();
        textFieldNick.setBounds(160, 20, 114, 19);
        getContentPane().add(textFieldNick);
        textFieldNick.setColumns(10);
        
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(160, 47, 114, 19);
        getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);
        
        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(160, 74, 114, 19);
        getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);
        
        textFieldApellido = new JTextField();
        textFieldApellido.setBounds(160, 101, 114, 19);
        getContentPane().add(textFieldApellido);
        textFieldApellido.setColumns(10);
        
        JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//agregarInstitucionAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(102, 314, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//agregarInstitutoCancelar(e);
			}
		});
		btnCancelar.setBounds(231, 314, 117, 25);
		getContentPane().add(btnCancelar);
		
		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setForeground(new Color(255, 255, 255));
		lblTipoUsuario.setBounds(12, 166, 102, 15);
		getContentPane().add(lblTipoUsuario);
		
		JComboBox seleccionarTipoUser = new JComboBox();
		seleccionarTipoUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedItem = (String) seleccionarTipoUser.getSelectedItem();
                if ("Socio".equals(selectedItem)) {
                    textFieldDescripcion.setEnabled(false); // Deshabilitar el JTextField
                    textFieldWeb.setEnabled(false);
                    textFieldBio.setEnabled(false);
                }
			}
		});
		seleccionarTipoUser.setModel(new DefaultComboBoxModel(new String[] {"Profesor", "Socio"}));
		seleccionarTipoUser.setBounds(160, 161, 117, 24);
		getContentPane().add(seleccionarTipoUser);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(new Color(255, 255, 255));
		lblDescripcion.setBounds(12, 199, 102, 15);
		getContentPane().add(lblDescripcion);
		
		JLabel lblWeb = new JLabel("Web");
		lblWeb.setForeground(new Color(255, 255, 255));
		lblWeb.setBounds(12, 226, 70, 15);
		getContentPane().add(lblWeb);
		
		JLabel lblBiografia = new JLabel("Biografia");
		lblBiografia.setForeground(new Color(255, 255, 255));
		lblBiografia.setBounds(12, 253, 70, 15);
		getContentPane().add(lblBiografia);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(160, 197, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldWeb = new JTextField();
		textFieldWeb.setText("");
		textFieldWeb.setBounds(160, 224, 114, 19);
		getContentPane().add(textFieldWeb);
		textFieldWeb.setColumns(10);
		
		textFieldBio = new JTextField();
		textFieldBio.setText("");
		textFieldBio.setBounds(160, 251, 114, 19);
		getContentPane().add(textFieldBio);
		textFieldBio.setColumns(10);
		

	}
}
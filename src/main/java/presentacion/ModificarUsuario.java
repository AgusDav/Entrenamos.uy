package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoException;
import interfaces.IControlador;

public class ModificarUsuario extends JInternalFrame {
	private IControlador icon;
	private JDialog dialogoPadre;
	private JComboBox<String> comboBoxUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JDateChooser fecNac;
	private static final long serialVersionUID = 1L;
	
	
	public ModificarUsuario(IControlador icon, JDialog dialogoPadre) {
		// Título de la ventata
				setTitle("Consulta Usuario");
				this.icon = icon;
				this.dialogoPadre = dialogoPadre;
				setBounds(100, 100, 716, 400);
				getContentPane().setBackground(new Color(54, 61, 75));
				getContentPane().setLayout(null);
				
				JLabel lblUsuario = new JLabel("Usuario ");
				lblUsuario.setForeground(new Color(255, 255, 255));
				lblUsuario.setBounds(23, 18, 83, 20);
				getContentPane().add(lblUsuario);
				
				comboBoxUsuario = new JComboBox<String>();
				comboBoxUsuario.setBackground(new Color(54, 61, 75));
				comboBoxUsuario.setForeground(new Color(255, 255, 255));
				comboBoxUsuario.setBounds(174, 16, 135, 24);
				getContentPane().add(comboBoxUsuario);
				
				// Campo nombre
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setForeground(new Color(255, 255, 255));
				lblNombre.setBounds(12, 76, 70, 15);
				getContentPane().add(lblNombre);
				
				textFieldNombre = new JTextField();
		        textFieldNombre.setBounds(160, 74, 150, 19);
		        getContentPane().add(textFieldNombre);
		        textFieldNombre.setColumns(10);
				
		        // Campo apellido
				JLabel lblApellido = new JLabel("Apellido");
				lblApellido.setForeground(new Color(255, 255, 255));
				lblApellido.setBounds(12, 103, 70, 15);
				getContentPane().add(lblApellido);
				
				textFieldApellido = new JTextField();
		        textFieldApellido.setBounds(160, 101, 150, 19);
		        getContentPane().add(textFieldApellido);
		        textFieldApellido.setColumns(10);
		        
				// Campo fecha nacimiento
				JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
				lblFechaNacimiento.setForeground(new Color(255, 255, 255));
				lblFechaNacimiento.setBounds(12, 130, 139, 15);
				getContentPane().add(lblFechaNacimiento);
				
				fecNac = new JDateChooser();
		        fecNac.setBounds(160, 128, 150, 19);
		        getContentPane().add(fecNac);
		        
		     // Botón aceptar
		        JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						agregarUsuarioAceptarActionPerformed(e);
					}
				});
				btnAceptar.setForeground(Color.WHITE);
				btnAceptar.setBackground(new Color(54, 61, 75));
				btnAceptar.setBorder(new LineBorder(new Color(33, 37, 43), 3, true));
				btnAceptar.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	btnAceptar.setBackground(new Color(69, 78, 95)); // Lighter blue when hovering
		            }
		            @Override
		            public void mouseExited(MouseEvent e) {
		            	btnAceptar.setBackground(new Color(54, 61, 75)); // Original color when not hovering
		            }
		        });
				btnAceptar.setBounds(12, 319, 124, 37);
				getContentPane().add(btnAceptar);
				
				// Botón cancelar
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						agregarUsuarioCancelar(e);
					}
				});
				btnCancelar.setForeground(Color.WHITE);
				btnCancelar.setBackground(new Color(54, 61, 75));
				btnCancelar.setBorder(new LineBorder(new Color(33, 37, 43), 3, true));
				btnCancelar.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	btnCancelar.setBackground(new Color(69, 78, 95)); // Lighter blue when hovering
		            }
		            @Override
		            public void mouseExited(MouseEvent e) {
		            	btnCancelar.setBackground(new Color(54, 61, 75)); // Original color when not hovering
		            }
		        });
				btnCancelar.setBounds(193, 319, 117, 37);
				getContentPane().add(btnCancelar);
	}
	
	public void inciarComboBoxUsuario() {
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>(icon.listarUsuarios());
		comboBoxUsuario.setModel(modelUsuarios);
	}
	
	protected void agregarUsuarioAceptarActionPerformed(ActionEvent arg0) {
		String nick = this.comboBoxUsuario.getSelectedItem().toString();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		Date fecha = fecNac.getDate();
		if(nombre.isEmpty() || apellido.isEmpty() || fecha == null){
        	JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Usuario", JOptionPane.ERROR_MESSAGE);
		}else {
    		icon.ModificarUsuario(nick, nombre, apellido, fecha);
    		JOptionPane.showMessageDialog(this, "El usuario se ha modificado con éxito", "Modificar Usuario ", JOptionPane.INFORMATION_MESSAGE);
            dialogoPadre.dispose();
    	}
	}
    
	
	// Cancela el caso de uso
	protected void agregarUsuarioCancelar(ActionEvent arg0) {
		dialogoPadre.dispose();
	}
	
}

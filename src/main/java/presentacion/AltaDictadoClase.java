package presentacion;

import interfaces.IControlador;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioRepetidoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JProgressBar;


public class AltaDictadoClase extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IControlador icon;
	private JDialog dialogoPadre;
	private JComboBox<String> comboBoxNombreInstitucion;
	private JComboBox<String> comboBoxActividadesDeportivas;
	private JTextField textFieldNombreClase;
	private JDateChooser fecClase;
	private JTextField textFieldUrlClase;
	private JDateChooser fecAlta;

	public AltaDictadoClase(IControlador icon, JDialog dialogoPadre) {
		// Título de la ventata
		setTitle("Alta Dictado clase");
		this.dialogoPadre = dialogoPadre;
		this.icon = icon;
		setBounds(100, 100, 377, 443);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(54, 61, 75));
		
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setForeground(Color.WHITE);
		lblInstitucion.setBackground(Color.WHITE);
		lblInstitucion.setBounds(12, 30, 95, 15);
		getContentPane().add(lblInstitucion);

		comboBoxNombreInstitucion = new JComboBox<String>();
		comboBoxNombreInstitucion.setBounds(210, 28, 114, 19);
		getContentPane().add(comboBoxNombreInstitucion);
		
		JLabel lblActividades = new JLabel("Actividad Deportiva");
		lblActividades.setForeground(Color.WHITE);
		lblActividades.setBackground(Color.WHITE);
		lblActividades.setBounds(12, 61, 180, 15);
		getContentPane().add(lblActividades);
		
		comboBoxActividadesDeportivas = new JComboBox<String>();
		comboBoxActividadesDeportivas.setBounds(210, 59, 114, 19);
		getContentPane().add(comboBoxActividadesDeportivas);

		JLabel lblNombreClase = new JLabel("Nombre Clase");
		lblNombreClase.setForeground(new Color(255, 255, 255));
		lblNombreClase.setBounds(12, 88, 108, 15);
		getContentPane().add(lblNombreClase);
		
		textFieldNombreClase = new JTextField();
		textFieldNombreClase.setBounds(210, 90, 114, 19);
		getContentPane().add(textFieldNombreClase);
		textFieldNombreClase.setColumns(10);
		
		JLabel lblFechaClase = new JLabel("Fecha Clase");
		lblFechaClase.setForeground(new Color(255, 255, 255));
		lblFechaClase.setBounds(12, 130, 139, 15);
		getContentPane().add(lblFechaClase);
		
		fecClase = new JDateChooser();
		fecClase.setBounds(210, 126, 114, 19);
        getContentPane().add(fecClase);  
        
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
        spinnerDateModel.setCalendarField(Calendar.MINUTE);
        
        JSpinner timeSpinnerHoraClase = new JSpinner(spinnerDateModel);
        timeSpinnerHoraClase.setBounds(210, 162, 67, 28);
        getContentPane().add(timeSpinnerHoraClase);
        JSpinner.DateEditor de_timeSpinnerHoraClase = new JSpinner.DateEditor(timeSpinnerHoraClase, "HH:mm");
        timeSpinnerHoraClase.setEditor(de_timeSpinnerHoraClase);
        
        JLabel lblHoraClase = new JLabel("Hora Clase");
        lblHoraClase.setForeground(Color.WHITE);
        lblHoraClase.setBounds(12, 164, 139, 15);
        getContentPane().add(lblHoraClase);
        
        JComboBox<String> comboBoxProfesores = new JComboBox<String>();
        comboBoxProfesores.setBounds(210, 202, 114, 19);
        getContentPane().add(comboBoxProfesores);
        
        JLabel lblProfesores = new JLabel("Profesor");
        lblProfesores.setForeground(Color.WHITE);
        lblProfesores.setBackground(Color.WHITE);
        lblProfesores.setBounds(12, 204, 95, 15);
        getContentPane().add(lblProfesores);
        
        JLabel lblUrlClase = new JLabel("Url Clase");
        lblUrlClase.setForeground(Color.WHITE);
        lblUrlClase.setBounds(12, 231, 108, 15);
        getContentPane().add(lblUrlClase);
        
        textFieldUrlClase = new JTextField();
        textFieldUrlClase.setColumns(10);
        textFieldUrlClase.setBounds(210, 233, 114, 19);
        getContentPane().add(textFieldUrlClase);
        
        fecAlta = new JDateChooser();
        fecAlta.setBounds(210, 277, 114, 19);
        getContentPane().add(fecAlta); 
        
        JLabel lblFechaAlta = new JLabel("Fecha Alta");
        lblFechaAlta.setForeground(Color.WHITE);
        lblFechaAlta.setBounds(12, 277, 139, 15);
        getContentPane().add(lblFechaAlta);
        
    
     // Botón aceptar
        JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaDictadoClaseAceptarActionPerformed(e);
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
		btnAceptar.setBounds(12, 308, 124, 37);
		getContentPane().add(btnAceptar);
		
		// Botón cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaDictadoClaseCancelar(e);
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
		btnCancelar.setBounds(210, 308, 117, 37);
		getContentPane().add(btnCancelar);
	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(icon.listarInstitutos());
		comboBoxNombreInstitucion.setModel(modelInstitutos);
		/*DefaultComboBoxModel<String> modelProfesores = new DefaultComboBoxModel<String>(icon.listarProfesores(this.comboBoxNombreInstitucion.getSelectedItem().toString()));
		comboBoxNombreInstitucion.setModel(modelProfesores);*/
		DefaultComboBoxModel<String> modelActDepor = new DefaultComboBoxModel<String>(icon.listarActividadesDeportivas(this.comboBoxNombreInstitucion.getSelectedItem().toString()));
		comboBoxActividadesDeportivas.setModel(modelActDepor);
	}
	
	protected void altaDictadoClaseAceptarActionPerformed(ActionEvent arg0) {
		/*String nick = this.textFieldNick.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		String web = this.textFieldWeb.getText();
		String bio = this.textFieldBio.getText();
		String desc = this.textFieldDescripcion.getText();
		Date selectedDate = fecNac.getDate();
		String tipoUser = (String) this.seleccionarTipoUser.getSelectedItem();
		DtUsuario dtU = null;
		if (nombre.isEmpty() || nick.isEmpty() || apellido.isEmpty() || selectedDate == null){
        	JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
            	LocalDate fecha = selectedDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            	if(tipoUser.equals("Profesor")) {
        			dtU = new DtProfesor(nick, nombre, apellido, email, fecha, desc, bio, web);
        		}else if(tipoUser.equals("Socio")){
        			dtU = new DtSocio(nick, nombre, apellido, email, fecha);
        		}
                this.icon.agregarUsuario(dtU);
                JOptionPane.showMessageDialog(this, "El usuario se ha creado con éxito", "Agregar Usuario ", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                dialogoPadre.dispose();
            } catch (UsuarioRepetidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
            }
        }*/
	}
	
	// Cancela el caso de uso
		protected void altaDictadoClaseCancelar(ActionEvent arg0) {
			limpiar();
			dialogoPadre.dispose();
		}
	
	private void limpiar() {
		textFieldNombreClase.setText("");
		textFieldUrlClase.setText("");
		fecClase.setDate(null);
		fecAlta.setDate(null);
	}
}

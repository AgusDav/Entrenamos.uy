package presentacion;

import interfaces.IControlador;
import logica.ActividadDeportiva;
import logica.Profesor;

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

import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.DictadoRepetidoException;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioRepetidoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
	private JComboBox<String> comboBoxProfesores;
	private JTextField textFieldNombreClase;
	private JDateChooser fecClase;
	private JTextField textFieldUrlClase;
	private JDateChooser fecAlta;
	private JSpinner timeSpinnerHoraClase;

	public AltaDictadoClase(IControlador icon, JDialog dialogoPadre) {
		// Título de la ventata
		setTitle("Alta Dictado clase");
		this.dialogoPadre = dialogoPadre;
		this.icon = icon;
		setBounds(100, 100, 377, 443);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(54, 61, 75));
		
		// Campo institucion
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setForeground(Color.WHITE);
		lblInstitucion.setBackground(Color.WHITE);
		lblInstitucion.setBounds(12, 30, 95, 15);
		getContentPane().add(lblInstitucion);

		comboBoxNombreInstitucion = new JComboBox<String>();
		comboBoxNombreInstitucion.setBounds(210, 28, 114, 19);
		getContentPane().add(comboBoxNombreInstitucion);
		
		// Campo actividades deportivas
		JLabel lblActividades = new JLabel("Actividad Deportiva");
		lblActividades.setForeground(Color.WHITE);
		lblActividades.setBackground(Color.WHITE);
		lblActividades.setBounds(12, 61, 180, 15);
		getContentPane().add(lblActividades);
		
		comboBoxActividadesDeportivas = new JComboBox<String>();
		comboBoxActividadesDeportivas.setBounds(210, 59, 114, 19);
		getContentPane().add(comboBoxActividadesDeportivas);

		// Campo nombre clase
		JLabel lblNombreClase = new JLabel("Nombre Clase");
		lblNombreClase.setForeground(new Color(255, 255, 255));
		lblNombreClase.setBounds(12, 88, 108, 15);
		getContentPane().add(lblNombreClase);
		
		textFieldNombreClase = new JTextField();
		textFieldNombreClase.setBounds(210, 90, 114, 19);
		getContentPane().add(textFieldNombreClase);
		textFieldNombreClase.setColumns(10);
		
		// Campo fecha clase
		JLabel lblFechaClase = new JLabel("Fecha Clase");
		lblFechaClase.setForeground(new Color(255, 255, 255));
		lblFechaClase.setBounds(12, 130, 139, 15);
		getContentPane().add(lblFechaClase);
		
		fecClase = new JDateChooser();
		fecClase.setBounds(210, 126, 114, 19);
        getContentPane().add(fecClase);  
        
        // Campo hora clase
        JLabel lblHoraClase = new JLabel("Hora Clase");
        lblHoraClase.setForeground(Color.WHITE);
        lblHoraClase.setBounds(12, 164, 139, 15);
        getContentPane().add(lblHoraClase);
        
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
        spinnerDateModel.setCalendarField(Calendar.MINUTE);
        
        JSpinner timeSpinnerHoraClase = new JSpinner(spinnerDateModel);
        timeSpinnerHoraClase.setBounds(210, 162, 67, 28);
        getContentPane().add(timeSpinnerHoraClase);
        JSpinner.DateEditor de_timeSpinnerHoraClase = new JSpinner.DateEditor(timeSpinnerHoraClase, "HH:mm");
        timeSpinnerHoraClase.setEditor(de_timeSpinnerHoraClase);
        
        // Campo profesor
        JLabel lblProfesores = new JLabel("Profesor");
        lblProfesores.setForeground(Color.WHITE);
        lblProfesores.setBackground(Color.WHITE);
        lblProfesores.setBounds(12, 204, 95, 15);
        getContentPane().add(lblProfesores);
        
        comboBoxProfesores = new JComboBox<String>();
        comboBoxProfesores.setBounds(210, 202, 114, 19);
        getContentPane().add(comboBoxProfesores);
        
        // Campo url clase
        JLabel lblUrlClase = new JLabel("Url Clase");
        lblUrlClase.setForeground(Color.WHITE);
        lblUrlClase.setBounds(12, 231, 108, 15);
        getContentPane().add(lblUrlClase);
        
        textFieldUrlClase = new JTextField();
        textFieldUrlClase.setColumns(10);
        textFieldUrlClase.setBounds(210, 233, 114, 19);
        getContentPane().add(textFieldUrlClase);

        // Campo fecha de alta
        JLabel lblFechaAlta = new JLabel("Fecha Alta");
        lblFechaAlta.setForeground(Color.WHITE);
        lblFechaAlta.setBounds(12, 277, 139, 15);
        getContentPane().add(lblFechaAlta);
        
        fecAlta = new JDateChooser();
        fecAlta.setBounds(210, 277, 114, 19);
        getContentPane().add(fecAlta); 
        
    
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
//		DefaultComboBoxModel<String> modelProfesores = new DefaultComboBoxModel<String>(icon.listarProfesores(this.comboBoxNombreInstitucion.getSelectedItem().toString()));
//		comboBoxProfesores.setModel(modelProfesores);
//		DefaultComboBoxModel<String> modelActDepor = new DefaultComboBoxModel<String>(icon.listarActividadesDeportivas(this.comboBoxNombreInstitucion.getSelectedItem().toString()));
//		comboBoxActividadesDeportivas.setModel(modelActDepor);
	}
	
	protected void altaDictadoClaseAceptarActionPerformed(ActionEvent arg0) {
		String nomInstitucion = this.comboBoxNombreInstitucion.getSelectedItem().toString();
		ActividadDeportiva actDepor = (ActividadDeportiva) this.comboBoxActividadesDeportivas.getSelectedItem();
		String nomClase = this.textFieldNombreClase.getText();
		Date fechaClase = this.fecClase.getDate();
		Time horaClase = (Time) this.timeSpinnerHoraClase.getValue();
		Profesor profe = (Profesor) this.comboBoxProfesores.getSelectedItem();
		String urlClase = this.textFieldUrlClase.getText();
		Date fechaReg = this.fecAlta.getDate();
		if(nomInstitucion.isEmpty() || fechaClase == null || urlClase.isEmpty() || fechaReg == null || profe == null || actDepor == null || horaClase == null) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Dictado de Clase", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				LocalDate fecha = fechaClase.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
				LocalTime hora = horaClase.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime();;
				DtClase dtC = new DtClase(nomClase, fecha, hora, urlClase, fecha);
				this.icon.altaDictadoClase(dtC);
				JOptionPane.showMessageDialog(this, "Se ha registrado con éxito el dictado de la clase", "Alta Dictado Clase", JOptionPane.INFORMATION_MESSAGE);
				limpiar();
				dialogoPadre.dispose();
			} catch(DictadoRepetidoException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Dictado Clase", JOptionPane.ERROR_MESSAGE);
			}
		}
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
	
	public Boolean checkearComboBoxes() {
		if(comboBoxNombreInstitucion == null) {
			JOptionPane.showMessageDialog(this, "Debe haber institutos registrados", "Alta Dictado de Clase", JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		if(comboBoxProfesores == null) {
			JOptionPane.showMessageDialog(this, "Debe haber profesores registrados", "Alta Dictado de Clase", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(comboBoxActividadesDeportivas == null) {
			JOptionPane.showMessageDialog(this, "Debe haber actividades deportivas registradas", "Alta Dictado de Clase", JOptionPane.ERROR_MESSAGE);	
			return false;
		}
		return true;
	}
}
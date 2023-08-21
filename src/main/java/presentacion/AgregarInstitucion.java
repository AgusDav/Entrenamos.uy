package presentacion;



import interfaces.IControlador;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import excepciones.InstitucionDeportivaRepetidaException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarInstitucion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IControlador icon;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldUrl;

	
	public AgregarInstitucion(IControlador icon) {
		this.icon = icon;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblAltaInstitucionDeportiva = new JLabel("ALTA INSTITUCION DEPORTIVA");
		lblAltaInstitucionDeportiva.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAltaInstitucionDeportiva.setBounds(93, 12, 264, 15);
		getContentPane().add(lblAltaInstitucionDeportiva);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 61, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Descripcion:");
		lblNewLabel.setBounds(34, 101, 94, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUrl = new JLabel("Url:");
		lblUrl.setBounds(34, 143, 70, 15);
		getContentPane().add(lblUrl);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(107, 59, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setText("");
		textFieldDescripcion.setBounds(132, 99, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldUrl = new JTextField();
		textFieldUrl.setText("");
		textFieldUrl.setBounds(71, 141, 114, 19);
		getContentPane().add(textFieldUrl);
		textFieldUrl.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInstitucionAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(104, 210, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(240, 210, 117, 25);
		getContentPane().add(btnCancelar);

	}
	
	protected void agregarInstitucionAceptarActionPerformed(ActionEvent arg0) {
		String nombre = this.textFieldNombre.getText();
        String ci = this.textFieldDescripcion.getText();
        String url = this.textFieldUrl.getText();
  
            try {
                this.icon.altaInstitucion(nombre, ci, url);
                JOptionPane.showMessageDialog(this, "La Institucion se ha creado con éxito", "Agregar ",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (InstitucionDeportivaRepetidaException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Institucion", JOptionPane.ERROR_MESSAGE);
            }
 
            setVisible(false);
        
		
	} 
}

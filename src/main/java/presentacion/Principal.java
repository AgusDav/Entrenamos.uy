package presentacion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import interfaces.Fabrica;
import interfaces.IControlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Principal {
    private JFrame frame;
    private JPanel panelDeTarjetas;
    private CardLayout cardLayout;
    private AgregarInstitucion agregarInstitutoInternalFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal ventana = new Principal();
                    ventana.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        iniciar();
        
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
		agregarInstitutoInternalFrame.getContentPane().setLayout(null);
    }

    public void iniciar() {
        frame = new JFrame();
        frame.setTitle("Entrenamos.uy");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imagen = new ImageIcon(getClass().getResource("Icon.jpg"));
        frame.setIconImage(imagen.getImage());

        cardLayout = new CardLayout();
        panelDeTarjetas = new JPanel(cardLayout);

        // Crear Panel de Bienvenida con GIF y Botón "Entrar"
        JPanel panelBienvenida = crearPanelBienvenida();
        panelDeTarjetas.add(panelBienvenida, "bienvenida");

        // Crear Panel de Otro Menú
        JPanel panelPrincipal = crearpanelPrincipal();
        panelDeTarjetas.add(panelPrincipal, "otroMenu");

        // Establecer la vista inicial en la pantalla de bienvenida
        cardLayout.show(panelDeTarjetas, "bienvenida");

        // Agregar el panelDeTarjetas al frame
        frame.getContentPane().add(panelDeTarjetas);

        frame.setVisible(true);
    }

    private JPanel crearPanelBienvenida() {
        JPanel panelBienvenida = new JPanel(null); // Usar layout nulo para controlar la posición manualmente

        // Cargar el GIF y crear un JLabel para mostrarlo
        ImageIcon iconoGif = new ImageIcon(getClass().getResource("Presentacion.gif"));
        JLabel gif = new JLabel(iconoGif);
        gif.setText("Bienvenido a Entrenamos.uy");
        gif.setHorizontalTextPosition(JLabel.CENTER);
        gif.setVerticalTextPosition(JLabel.TOP);
        gif.setForeground(Color.WHITE);
        gif.setFont(new Font("MV Boli", Font.PLAIN, 40));
        gif.setIconTextGap(-100);

        // Crear botones "Entrar" y "Salir"
        final JButton botonEntrar = new JButton("Entrar");
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setBackground(new Color(54, 61, 75));
        botonEntrar.setBorder(new LineBorder(new Color(33, 37, 43), 3, true));
        botonEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonEntrar.setBackground(new Color(69, 78, 95)); // Lighter blue when hovering
            }
            @Override
            public void mouseExited(MouseEvent e) {
                botonEntrar.setBackground(new Color(54, 61, 75)); // Original color when not hovering
            }
        });

        // Agregar ActionListener para cambiar a otro menú con animación
        botonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAnimacion(panelDeTarjetas, -800, "otroMenu");
            }
        });

        final JButton botonSalir = new JButton("Salir");
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setBackground(new Color(54, 61, 75));
        botonSalir.setBorder(new LineBorder(new Color(33, 37, 43), 3, true));
        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonSalir.setBackground(new Color(69, 78, 95)); // Lighter blue when hovering
            }
            @Override
            public void mouseExited(MouseEvent e) {
                botonSalir.setBackground(new Color(54, 61, 75)); // Original color when not hovering
            }
        });

        // Agregar ActionListener para cerrar el programa
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Establecer tamaño preferido para los botones
        Dimension tamanioBoton = new Dimension(120, 40);
        botonEntrar.setPreferredSize(tamanioBoton);
        botonSalir.setPreferredSize(tamanioBoton);

        // Crear un JPanel para los botones con FlowLayout
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 80));
        panelBotones.setBorder(null);
        panelBotones.setBackground(new Color(54, 61, 75));
        panelBotones.add(botonEntrar);
        panelBotones.add(botonSalir);

        // Configurar posiciones y tamaños de componentes manualmente
        gif.setBounds(0, 0, 800, 600);
        panelBotones.setBounds(0, 600, 800, 200);

        // Agregar componentes al panelBienvenida
        panelBienvenida.setBackground(new Color(54, 61, 75));
        panelBienvenida.add(gif);
        panelBienvenida.add(panelBotones);

        return panelBienvenida;
    }
    
 // Método para realizar la animación de deslizamiento
    private void realizarAnimacion(final JPanel panel, final int destino, final String proximoPanel) {
        final int velocidad = 10; // Velocidad de la animación
        final Timer timer = new Timer(10, null);
        timer.addActionListener(new ActionListener() {
            int posicionY = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (posicionY > destino) {
                    panel.setBounds(0, posicionY, 800, 800);
                    posicionY -= velocidad;
                } else {
                    timer.stop();
                    cardLayout.show(panelDeTarjetas, proximoPanel);
                    panel.setBounds(0, 0, 800, 800); // Restaurar la posición
                }
            }
        });
        timer.start();
    }

    private JPanel crearpanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(54, 61, 75));
        panelPrincipal.setLayout(null);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnSalir.setBounds(618, 625, 117, 25);
        panelPrincipal.add(btnSalir);
        
        JButton btnAlta = new JButton("Alta");
        btnAlta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		agregarInstitutoInternalFrame.setVisible(true);
        	}
        });
        btnAlta.setBounds(185, 144, 117, 25);
        panelPrincipal.add(btnAlta);
        
        JButton btnInformacion = new JButton("Informacion");
        btnInformacion.setBounds(185, 204, 117, 25);
        panelPrincipal.add(btnInformacion);
        // Crear el contenido para el panel de otro menú aquí

        return panelPrincipal;
    } 
}






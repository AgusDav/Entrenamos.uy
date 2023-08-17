package presentacion;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal {
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal window = new Principal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        iniciar();
    }

	public void iniciar() {
        frame = new JFrame();
        frame.setTitle("Entrenamos.uy");
        frame.setSize(1000, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon(getClass().getResource("Icon.jpg"));
        frame.setIconImage(image.getImage());

        // Crear un JPanel con FlowLayout
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout);
        frame.getContentPane().setBackground(new Color(54,61,75));

        // Cargar el GIF y crear un JLabel para mostrarlo
        ImageIcon gifIcon = new ImageIcon(getClass().getResource("Presentacion.gif"));
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setText("Bienvenido a Entrenamos.uy");
        gifLabel.setHorizontalTextPosition(JLabel.CENTER);
        gifLabel.setVerticalTextPosition(JLabel.TOP);
        gifLabel.setForeground(Color.WHITE);
        gifLabel.setFont(new Font("MV Boli",Font.PLAIN,40));
        gifLabel.setIconTextGap(-100);

        // Agregar el JLabel al panel de contenido del JFrame
        frame.add(gifLabel);
        frame.revalidate();
        frame.repaint();

        frame.setVisible(true);
    }
}


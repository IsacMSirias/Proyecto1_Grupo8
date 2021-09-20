package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal implements ActionListener {



    JFrame ventanap = new JFrame();

    JLabel NombreJugador = new JLabel();
    JLabel Titulo = new JLabel();

    JTextField Usertxtbox = new JTextField();

    public static String Nombre = "";



    JButton BotonJugar = new JButton("J U G A R");
    JButton BotonAbout = new JButton("Creditos");
    JButton BotonInstrucciones = new JButton("Instrucciones");

    ImageIcon imageIcon = new ImageIcon("src/Sprites/IconMath.png");

    public VentanaPrincipal() {

        ventanap.setIconImage(imageIcon.getImage());

        ventanap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanap.setTitle("S O C K E T   M A T H");
        ventanap.setResizable(false);

        Titulo.setText("SOCKET MATH");
        Titulo.setBounds(80, 10, 350, 100);
        Titulo.setFont(new Font("cooper black", 0, 40));

        NombreJugador.setText("Ingrese un nombre de usuario");
        NombreJugador.setBounds(45, 100, 250, 50);
        NombreJugador.setFont(new Font("cooper black", 0, 15));

        Usertxtbox.setBounds(290, 112, 150, 25);
        Usertxtbox.setFont(new Font("cooper black", 0, 15));
        Nombre = Usertxtbox.getText();

        BotonJugar.setFocusable(false);
        BotonJugar.addActionListener(this);
        BotonJugar.setBounds(140, 300, 200, 40);

        BotonAbout.setFocusable(false);
        BotonAbout.addActionListener(this);
        BotonAbout.setBounds(85, 450, 150, 40);

        BotonInstrucciones.setFocusable(false);
        BotonInstrucciones.addActionListener(this);
        BotonInstrucciones.setBounds(245, 450, 150, 40);

        ventanap.setSize(500, 600);
        ventanap.setLayout(null);
        ventanap.setVisible(true);
        ventanap.add(BotonJugar);
        ventanap.add(BotonAbout);
        ventanap.add(BotonInstrucciones);
        ventanap.add(NombreJugador);
        ventanap.add(Titulo);
        ventanap.add(Usertxtbox);
        ventanap.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BotonJugar) {
            ventanap.dispose();
            VentanaJuego ventanaJuego = new VentanaJuego();

        }
        if (e.getSource() == BotonAbout){
            ventanap.dispose();
            VentanaAbout ventanaAb = new VentanaAbout();
        }
        if (e.getSource() == BotonInstrucciones){
            ventanap.dispose();
            VentanaInstrucciones ventanaInstrucciones = new VentanaInstrucciones();
        }

    }
}


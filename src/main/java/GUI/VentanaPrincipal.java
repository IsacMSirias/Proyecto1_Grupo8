package GUI;
import javax.swing.*;

import Sockets.Cliente;
import Sockets.Servidor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase de la Pantalla principal, está tendrá los parametros que necesitará el constructor.
 */

public class VentanaPrincipal implements ActionListener {

    JFrame ventanap = new JFrame();

    JLabel NombreJugador = new JLabel();
    JLabel Titulo = new JLabel();

    JTextField Usertxtbox = new JTextField();

    /**
     * Esta variable guarda la el nombre del jugador1, el codigo entero tiene acceso a esta variable.
     */
    public static String Nombre = "";
    /**
     * Esta variable guarda la el nombre del jugador2, el codigo entero tiene acceso a esta variable.
     */
    public static String Nombre2 = "";

    /**
     * Esta es la conexion que define si se estan ejecutando acciones en el cliente
     * o en el servidor, el codigo entero tiene acceso a esta variable.
     */
    public static String conexion = "";

    /**
     * Esta variable boleana es un flag, el cual sirve para ejecutar instrcciones sin que otras interfieran en ella.
     */
    public static Boolean running = false;



    JButton BotonJugar = new JButton("J U G A R");
    JButton BotonAbout = new JButton("Creditos");
    JButton BotonInstrucciones = new JButton("Instrucciones");
    JButton BotonUnirse  = new JButton("Unirse a partida");
    JButton BotonCrear = new JButton("Crear partida");

    ImageIcon imageIcon = new ImageIcon("src/Sprites/IconMath.png");

    /**
     * Metodo el cual tendrá todos los objetos visibles dentro de la pantalla
     */

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


        BotonJugar.setFocusable(false);
        BotonJugar.addActionListener(this);
        BotonJugar.setBounds(140, 400, 200, 40);

        BotonUnirse.setFocusable(false);
        BotonUnirse.addActionListener(this);
        BotonUnirse.setBounds(85, 250, 150, 40);

        BotonCrear.setFocusable(false);
        BotonCrear.addActionListener(this);
        BotonCrear.setBounds(245, 250, 150, 40);


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
        //ventanap.add(BotonAbout);
        //ventanap.add(BotonInstrucciones);
        ventanap.add(BotonCrear);
        ventanap.add(BotonUnirse);
        ventanap.add(NombreJugador);
        ventanap.add(Titulo);
        ventanap.add(Usertxtbox);
        ventanap.setLocationRelativeTo(null);

    }

    /**
     * Metodo que hace que los botones de la pantalla principal sean funcionales.
     * @param e Corresponde a la escucha de los drivers del clickeo del mouse.
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BotonJugar) {
            ventanap.dispose();
            running = true;
            VentanaJuego ventanaJuego = new VentanaJuego();
        }
        if (e.getSource() == BotonCrear) {
            conexion = "servidor";
            Nombre = Usertxtbox.getText();
            Servidor servidor = new Servidor();
            new Thread(servidor).start();

        }
        if (e.getSource() == BotonUnirse) {
            conexion = "cliente";
            Nombre2 = Usertxtbox.getText();
            Cliente cliente = new Cliente();
            new Thread(cliente).start();
        }
    }
}

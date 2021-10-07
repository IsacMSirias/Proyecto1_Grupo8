package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana tunel, esta es una clase que hace que cuando el jugador caiga en esta tunel se despliegue una pantalla emergente
 * que notifica cuantas posiciones en el tablero se ha movido el jugador
 */
public class VenTrampa implements ActionListener {

    JFrame VentanaTrampa = new JFrame();
    /**
     * Label que contendra el numero de espacions que se mueve el jugador en el tablero
     */
    public static JLabel Mensaje1 = new JLabel();
    JLabel Mensaje2 = new JLabel();
    JButton Confirmar = new JButton();


    ImageIcon imageIcon = new ImageIcon("src/Sprites/IconMath.png");

    /**
     * Este metodo contendra y desplegara todos los objetos presentes en la ventana emergente cada vez que el jugador
     * caiga en una casilla de trampa
     */

    public VenTrampa() {

        VentanaTrampa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaTrampa.setSize(250, 200);
        VentanaTrampa.setLayout(null);
        VentanaTrampa.setVisible(true);
        VentanaTrampa.setLocationRelativeTo(null);
        VentanaTrampa.setResizable(false);
        VentanaTrampa.setTitle(" T R A M P A");

        Mensaje1.setText("El jugador se ha movido  " + "var :v");
        Mensaje1.setBounds(35, 20, 200, 20);
        Mensaje1.setFont(new Font("cooper black", 0, 10));

        Mensaje2.setText("posiciones en el tablero de juego");
        Mensaje2.setBounds(35, 50, 200, 20);
        Mensaje2.setFont(new Font("cooper black", 0, 10));

        Confirmar.setFocusable(false);
        Confirmar.addActionListener(this);
        Confirmar.setBounds(76, 100, 90, 20);
        Confirmar.setFont(new Font("cooper black", 0, 10));
        Confirmar.setText("Confirmar");


        VentanaTrampa.add(Mensaje1);
        VentanaTrampa.add(Mensaje2);
        VentanaTrampa.add(Confirmar);


        VentanaTrampa.setIconImage(imageIcon.getImage());

    }

    /**
     * Este metodo hace que que al presionar el boton de confirmar la ventana se cierra.
     * @param e  Corresponde a la escucha de los drivers del clickeo del mouse.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Confirmar) {
            VentanaTrampa.dispose();
        }
    }
}
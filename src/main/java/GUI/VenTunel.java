package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana tunel, esta es una clase que hace que cuando el jugador caiga en esta trampa se despliegue una pantalla emergente
 * que notifica cuantas posiciones en el tablero se ha movido el jugador
 */

public class VenTunel implements ActionListener {

    JFrame VentanaTunel = new JFrame();
    /**
     * Label que contendra el numero de espacions que se mueve el jugador en el tablero
     */
    public static JLabel TMensaje1 = new JLabel();
    JLabel TMensaje2 = new JLabel();
    JButton Confirmar  = new JButton();

    ImageIcon imageIcon = new ImageIcon("src/Sprites/IconMath.png");

    /**
     *  Metodo que contiene todos los objetos e instancias que estan presentes en la ventana de tunel
     */
    public VenTunel() {

        VentanaTunel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaTunel.setSize(250, 200);
        VentanaTunel.setLayout(null);
        VentanaTunel.setVisible(true);
        VentanaTunel.setLocationRelativeTo(null);
        VentanaTunel.setResizable(false);
        VentanaTunel.setTitle(" T U N E L ");

        TMensaje1.setText("El jugador se ha movido  " + "var :v");
        TMensaje1.setBounds(35, 20, 200, 20);
        TMensaje1.setFont(new Font("cooper black", 0, 10));

        TMensaje2.setText("posiciones en el tablero de juego");
        TMensaje2.setBounds(35, 50, 200, 20);
        TMensaje2.setFont(new Font("cooper black", 0, 10));

        Confirmar.setFocusable(false);
        Confirmar.addActionListener(this);
        Confirmar.setBounds(76, 100, 90, 20);
        Confirmar.setFont(new Font("cooper black", 0, 10));
        Confirmar.setText("Confirmar");

        VentanaTunel.add(TMensaje1);
        VentanaTunel.add(TMensaje2);
        VentanaTunel.add(Confirmar);


        VentanaTunel.setIconImage(imageIcon.getImage());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Confirmar) {
            VentanaTunel.dispose();
        }

    }
}

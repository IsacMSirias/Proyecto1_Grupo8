package GUI;
import javax.swing.*;

import DoubleLinked.DoubleNode;
import Sockets.Logica;
import Sockets.Servidor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReto implements ActionListener {

    JFrame ventanaReto = new JFrame();
    public static JLabel operacion = new JLabel();
    JTextField respuestaJugador = new JTextField();
    JButton enviar = new JButton();

    public static String Operacion = "";
    public static String respuesta;

    public VentanaReto() {

        ventanaReto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaReto.setSize(250, 200);
        ventanaReto.setLayout(null);
        ventanaReto.setVisible(true);
        ventanaReto.setLocationRelativeTo(null);
        ventanaReto.setResizable(false);
        ventanaReto.setTitle("R e t o ");

        operacion.setText(Operacion);
        operacion.setBounds(77, 10, 100, 25);
        operacion.setFont(new Font("cooper black", 0, 15));

        respuestaJugador.setBounds(42, 50, 150, 25);
        respuestaJugador.setFont(new Font("cooper black", 0, 15));

        enviar.setFocusable(false);
        enviar.addActionListener(this);
        enviar.setBounds(76, 100, 75, 20);
        enviar.setFont(new Font("cooper black", 0, 10));
        enviar.setText("Enviar");

        ventanaReto.add(operacion);
        ventanaReto.add(respuestaJugador);
        ventanaReto.add(enviar);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == enviar) {

            if (respuesta.equals(respuestaJugador.getText())) {

                JOptionPane.showMessageDialog(null, "Respuesta correcta");
                ventanaReto.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
                ventanaReto.dispose();

            }

        }


    }
}

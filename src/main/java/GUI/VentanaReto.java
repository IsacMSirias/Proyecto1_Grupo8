package GUI;
import javax.swing.*;

import DoubleLinked.DoubleNode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReto implements ActionListener {

    JFrame ventanaReto = new JFrame();
    JLabel operacion = new JLabel();
    JTextField Respuesta = new JTextField();
    JButton enviar = new JButton();

    String respuesta = "";

    public VentanaReto() {

        ventanaReto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaReto.setSize(250, 200);
        ventanaReto.setLayout(null);
        ventanaReto.setVisible(true);
        ventanaReto.setLocationRelativeTo(null);
        ventanaReto.setResizable(false);
        ventanaReto.setTitle("R e t o ");

        operacion.setText("Daniel papi");
        operacion.setBounds(77, 10, 100, 25);
        operacion.setFont(new Font("cooper black", 0, 15));

        Respuesta.setBounds(42, 50, 150, 25);
        Respuesta.setFont(new Font("cooper black", 0, 15));

        enviar.setFocusable(false);
        enviar.addActionListener(this);
        enviar.setBounds(76, 100, 75, 20);
        enviar.setFont(new Font("cooper black", 0, 10));
        enviar.setText("Enviar");

        ventanaReto.add(operacion);
        ventanaReto.add(Respuesta);
        ventanaReto.add(enviar);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        respuesta = Respuesta.getText();
    }
}

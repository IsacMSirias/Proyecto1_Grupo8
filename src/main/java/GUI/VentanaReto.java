package GUI;
import javax.swing.*;

import DoubleLinked.DoubleNode;
import Sockets.Cliente;
import Sockets.Servidor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta es la ventana que contendra los respectivos objetos y metodos que haran que la
 * ventana de reto funcionen.
 */

public class VentanaReto implements ActionListener {

    JFrame ventanaReto = new JFrame();
    /**
     * Esta es ina istancia de la biblioteca Jlabel, la cual contendra
     * la operacion que se escribe en la pantalla de reto
     */
    public static JLabel operacion = new JLabel();
    /**
     * Instancia de la biblioteca TextFlield
     * en donde el jugador ingresara su respuesta al problema de la ventana reto
     */
    JTextField respuestaJugador = new JTextField();
    JButton enviar = new JButton();

    /**
     * En esta variable se guardara la respuesta que escribe el jugador en el txtbox de la ventana de reto
     */
    public static String Operacion = "";
    /**
     *  Variable que almacena la respuesta del jugador
     */
    public static String respuesta;

    /**
     *  Metodo de la ventana de reto, la cual estaran presentes todos aquellos objetos que se
     *  se veran reflejados en la pantalla emergente de reto.
     */

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

    /**
     *  Metodo que envía la respuesta del reto hacia otra clase, la cual verifica que la respuesta del jugador
     *  en el caso de que este correcta, esta notificara al usuario y si esta incorrecta tambien
     * @param e Corresponde a la escucha de los drivers del clickeo del mouse.
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == enviar) {

            if (respuesta.equals(respuestaJugador.getText())) {

                JOptionPane.showMessageDialog(null, "Respuesta correcta");
                ventanaReto.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
                ventanaReto.dispose();
                if (VentanaPrincipal.conexion.equals("servidor")){

                    Servidor.varPos1 --;

                    if(Servidor.varPos1 < 0){

                        Servidor.varPos1 = 0;
                    }


                } else if (VentanaPrincipal.conexion.equals("cliente")){

                    Cliente.varPos2 --;

                    if(Cliente.varPos2 < 0){

                        Cliente.varPos2 = 0;
                    }

                }
            }



        }


    }
}

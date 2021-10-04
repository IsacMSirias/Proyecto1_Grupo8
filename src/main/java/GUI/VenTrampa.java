package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VenTrampa implements ActionListener {

    JFrame VentanaTrampa = new JFrame();
    public static JLabel Mensaje1 = new JLabel();
    JLabel Mensaje2 = new JLabel();
    JButton Confirmar = new JButton();


    ImageIcon imageIcon = new ImageIcon("src/Sprites/IconMath.png");

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Confirmar) {
            VentanaTrampa.dispose();
        }
    }
}
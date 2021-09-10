import javax.swing.*;
import java.awt.*;

public class VentanaJuego {

    JFrame ventanaj = new JFrame();
    JLabel label = new JLabel("Gel");


    VentanaJuego(){

        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN,25));

        ventanaj.add(label);
        ventanaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaj.setLocationRelativeTo(null);
        ventanaj.setSize(500,600);
        ventanaj.setLayout(null);
        ventanaj.setVisible(true);

    }
}

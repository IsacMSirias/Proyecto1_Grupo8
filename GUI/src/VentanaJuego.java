import javax.swing.*;
import java.awt.*;

public class VentanaJuego {

    JFrame ventanaj = new JFrame();
    JLabel label = new JLabel("Gel");

    ImageIcon imageIcon = new ImageIcon("Sprites/IconMath.png");

    VentanaJuego(){
        ventanaj.setIconImage(imageIcon.getImage());
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN,25));

        ventanaj.add(label);
        ventanaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaj.setSize(500,600);
        ventanaj.setLayout(null);
        ventanaj.setVisible(true);
        ventanaj.setLocationRelativeTo(null);

    }
}

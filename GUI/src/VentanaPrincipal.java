import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal implements ActionListener {

    JFrame ventanap = new JFrame();
    JButton myButton = new JButton("J U G A R");

    VentanaPrincipal(){

        myButton.setBounds(100,160,200,40);
        ventanap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanap.setLocationRelativeTo(null);
        ventanap.setResizable(false);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        ventanap.setSize(500,600);
        ventanap.setLayout(null);
        ventanap.setVisible(true);
        ventanap.add(myButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == myButton){
            ventanap.dispose();
            VentanaJuego ventanaj = new VentanaJuego();

        }

    }
}


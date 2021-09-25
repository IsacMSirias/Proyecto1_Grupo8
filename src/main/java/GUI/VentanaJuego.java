package GUI;
import javax.management.RuntimeMBeanException;
import javax.swing.*;

import Sockets.Cliente;
import Sockets.Servidor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class VentanaJuego implements ActionListener {

    String Nombrejugador1;
    String Nombrejugador2;

     int varPocision1;
     int varPocision2;



    public static int varNumDado = 0;

    public static String varCasilla1 = "";

    public static String varCasilla2 = "";

    JFrame ventanaj = new JFrame();

    JLabel Titulo = new JLabel();

    JLabel Espacio = new JLabel();

    JLabel Jugador1 = new JLabel();
    JLabel Jugador2 = new JLabel();

    JLabel Posicion1 = new JLabel();
    JLabel Posicion2 = new JLabel();

    JLabel CasillaTipo1 = new JLabel();
    JLabel CasillaTipo2 = new JLabel();

    JButton BotonMenu = new JButton("MENU");
    JButton BLanzarDado = new JButton("Lanzar");

    ImageIcon imageIcon = new ImageIcon("src/Sprites/IconMath.png");
    JLabel Tablero = new JLabel(new ImageIcon("src/Sprites/Tablero.png"));
    JLabel Dado = new JLabel(new ImageIcon("src/Sprites/Dado.png"));

    public VentanaJuego() {
        if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
            Nombrejugador1 = Servidor.Nombrejugador1;
            Nombrejugador2 = Servidor.Nombrejugador2;
        } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
            Nombrejugador1 = Cliente.Nombrejugador1;
            Nombrejugador2 = Cliente.Nombrejugador2;
        }
        ventanaj.setIconImage(imageIcon.getImage());

        ventanaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaj.setTitle("S O C K E T   M A T H");
        ventanaj.setResizable(false);

        Titulo.setText("SOCKET MATH");
        Titulo.setBounds(600/2 - 250/2, 0, 250, 100);
        Titulo.setFont(new Font("cooper black", 0, 30));

        Espacio.setText(":");
        Espacio.setBounds(300, 499, 50,30);
        Espacio.setFont(new Font("cooper black", 0, 20));

        Jugador1.setText("Jugador 1: "+Nombrejugador1);
        Jugador1.setBounds(200-50, 400, 200, 20);
        Jugador1.setFont(new Font("cooper black", 0, 15));

        Jugador2.setText("Jugador 2:"+Nombrejugador2);
        Jugador2.setBounds(300+50, 400, 200, 20);
        Jugador2.setFont(new Font("cooper black", 0, 15));

        Posicion1.setText("Pocisión:" );
        Posicion1.setBounds(200-50, 425, 200, 20);
        Posicion1.setFont(new Font("cooper black", 0, 15));

        Posicion2.setText("Pocisión:");
        Posicion2.setBounds(300+50, 425, 200, 20);
        Posicion2.setFont(new Font("cooper black", 0, 15));

        CasillaTipo1.setText("Casilla");
        CasillaTipo1.setBounds(200-50, 450, 200, 15);
        CasillaTipo1.setFont(new Font("cooper black", 0, 15));

        CasillaTipo2.setText("Casilla");
        CasillaTipo2.setBounds(300+50, 450, 200, 15);
        CasillaTipo2.setFont(new Font("cooper black", 0, 15));

        Tablero.setBounds(137, 75,300, 299);

        Dado.setBounds(250, 498, 50,50);


        BotonMenu.setFocusable(false);
        BotonMenu.addActionListener(this);
        BotonMenu.setBounds(250, 600, 75, 40);

        BLanzarDado.setFocusable(false);
        BLanzarDado.addActionListener(this);
        BLanzarDado.setBounds(150, 500, 75, 40);


        ventanaj.setSize(600, 700);
        ventanaj.setLayout(null);
        ventanaj.setVisible(true);
        ventanaj.add(BotonMenu);
        ventanaj.add(BLanzarDado);
        ventanaj.add(Titulo);
        ventanaj.add(Espacio);
        ventanaj.add(Tablero);
        ventanaj.add(Jugador1);
        ventanaj.add(Jugador2);
        ventanaj.add(Posicion1);
        ventanaj.add(Posicion2);
        ventanaj.add(CasillaTipo1);
        ventanaj.add(CasillaTipo2);
        ventanaj.add(Dado);

        ventanaj.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BotonMenu) {
            ventanaj.dispose();
            VentanaPrincipal.running = false;
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        }

        int NumRandom = (int) (Math.random() * 3 + 1);
        if(e.getSource() == BLanzarDado & NumRandom == 1 & varNumDado <= 16){
            varNumDado = 1;
            Servidor.varPos1 += 1;
            Servidor.varPos2 += 1;
            Posicion1.setText("Posicion: "+ Servidor.varPos1);
            Posicion2.setText("Posicion: "+ Servidor.varPos2);
            Espacio.setText(": 1");

        }

        else if(e.getSource() == BLanzarDado & NumRandom == 2 & varNumDado <= 16){
            varNumDado = 2;
            Servidor.varPos1 += 2;
            Servidor.varPos2 += 2;
            Posicion1.setText("Posicion: "+ Servidor.varPos1);
            Posicion2.setText("Posicion: "+ Servidor.varPos2);
            Espacio.setText(": 2");

        }


        else if(e.getSource() == BLanzarDado & NumRandom == 3 & varNumDado <= 16){
            varNumDado = 3;
            Servidor.varPos1 += 3;
            Servidor.varPos2 += 3;

            Espacio.setText(": 3");
            Posicion1.setText("Posicion: "+ Servidor.varPos1);
            Posicion2.setText("Posicion: "+ Servidor.varPos2);


        }

        if (varPocision1 >= 16 || varPocision2 >= 16){


            ventanaj.dispose();
            VentanaPrincipal.running = false;

        }

        varNumDado = 0;





    }

}

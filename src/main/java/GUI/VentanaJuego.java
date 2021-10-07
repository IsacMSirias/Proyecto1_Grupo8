package GUI;
import javax.management.RuntimeMBeanException;
import javax.swing.*;

import DoubleLinked.DoubleNode;
import DoubleLinked.DoublyLinkedList;
import Sockets.Cliente;
import Sockets.Logica;
import Sockets.Servidor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;


/**
 * Esta es la ventana de juego, en donde se encuentra el trablero
 */
public class VentanaJuego implements ActionListener {

    String Nombrejugador1;
    String Nombrejugador2;

    String[] ArrayTablero;

    JLabel TableroFila1 = new JLabel();
    JLabel TableroFila2 = new JLabel();
    JLabel TableroFila3 = new JLabel();
    JLabel TableroFila4 = new JLabel();

    /**
     * Esta variable corresponde a al nombre de la casilla actual en el tablero de juego del jugador 1
     */
    public static String varCasilla1 = "";
    /**
     * Esta variable corresponde a al nombre de la casilla actual en el tablero de juego del jugador 2
     */
    public static String varCasilla2 = "";

    /**
     * Esta variable corresponde en donde se va a guardar los numeros que tire el dado
     */
    public static int varNumDado = 0;

    /**
     * Instancia de la biblioteca JFrame que crea la ventana de juego.
     */
    public static JFrame ventanaj = new JFrame();

    JLabel Titulo = new JLabel();

    JLabel Espacio = new JLabel();

    JLabel Jugador1 = new JLabel();
    JLabel Jugador2 = new JLabel();

    /**
     * Corresponde a la instancia de la biblioteca JLabel, para poder manejar la posicion del jugador 1 en el resto de
     * las clases
     */
    public static JLabel Posicion1 = new JLabel();
    /**
     * Corresponde a la instancia de la biblioteca JLabel, para poder manejar la posicion del jugador 2 en el resto de
     * las clases
     */
    public static JLabel Posicion2 = new JLabel();


    /**
     * Corresponde a la instancia de la biblioteca JLabel, para poder manejar la casilla del jugador 1 en el resto de
     * las clases
     */
    public static JLabel CasillaTipo1 = new JLabel();
    /**
     * Corresponde a la instancia de la biblioteca JLabel, para poder manejar la casilla del jugador 2 en el resto de
     * las clases
     */
    public static JLabel CasillaTipo2 = new JLabel();

    JButton BotonMenu = new JButton("MENU");
    JButton BLanzarDado = new JButton("Lanzar");

    ImageIcon imageIcon = new ImageIcon("src/Sprites/IconMath.png");
    JLabel Tablero = new JLabel(new ImageIcon("src/Sprites/Tablero.png"));
    JLabel Dado = new JLabel(new ImageIcon("src/Sprites/Dado.png"));

    /**
     * Corresponde al metodo de la clase ventana juego, en ella estan presentes todos aquellos objetos que se
     * se veran reflejados en la pantalla de juego.
     */

    public VentanaJuego() {
        if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
            Nombrejugador1 = Servidor.Nombrejugador1;
            Nombrejugador2 = Servidor.Nombrejugador2;
            ArrayTablero = Servidor.board.displayGrphics();
            System.out.println(Arrays.toString(ArrayTablero));


        } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
            Nombrejugador1 = Cliente.Nombrejugador1;
            Nombrejugador2 = Cliente.Nombrejugador2;
            ArrayTablero = Cliente.board.displayGrphics();
            System.out.println(Arrays.toString(ArrayTablero));
        }
        ventanaj.setIconImage(imageIcon.getImage());

        ventanaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaj.setTitle("S O C K E T   M A T H");
        ventanaj.setResizable(false);

        Titulo.setText("SOCKET MATH");
        Titulo.setBounds(600 / 2 - 250 / 2, 0, 250, 100);
        Titulo.setFont(new Font("cooper black", 0, 30));

        Espacio.setText(":");
        Espacio.setBounds(300, 499, 50, 30);
        Espacio.setFont(new Font("cooper black", 0, 20));

        Jugador1.setText("Jugador 1: " + Nombrejugador1);
        Jugador1.setBounds(200 - 50, 400, 200, 20);
        Jugador1.setFont(new Font("cooper black", 0, 15));

        Jugador2.setText("Jugador 2:" + Nombrejugador2);
        Jugador2.setBounds(300 + 50, 400, 200, 20);
        Jugador2.setFont(new Font("cooper black", 0, 15));

        Posicion1.setText("Pocisión:");
        Posicion1.setBounds(200 - 50, 425, 200, 20);
        Posicion1.setFont(new Font("cooper black", 0, 15));

        Posicion2.setText("Pocisión:");
        Posicion2.setBounds(300 + 50, 425, 200, 20);
        Posicion2.setFont(new Font("cooper black", 0, 15));

        CasillaTipo1.setText("Casilla");
        CasillaTipo1.setBounds(200 - 50, 450, 200, 15);
        CasillaTipo1.setFont(new Font("cooper black", 0, 15));

        CasillaTipo2.setText("Casilla");
        CasillaTipo2.setBounds(300 + 50, 450, 200, 15);
        CasillaTipo2.setFont(new Font("cooper black", 0, 15));


        TableroFila1.setText(ArrayTablero[0] + ", " + ArrayTablero[1] + ", " + ArrayTablero[2] + ", " + ArrayTablero[3] + ", " + ArrayTablero[4]);
        TableroFila1.setBounds(15, 550, 200, 15);
        TableroFila1.setFont(new Font("cooper black", 0, 10));

        TableroFila2.setText(ArrayTablero[5] + ", " + ArrayTablero[6] + ", " + ArrayTablero[7] + ", " + ArrayTablero[8]);
        TableroFila2.setBounds(15, 575, 200, 15);
        TableroFila2.setFont(new Font("cooper black", 0, 10));

        TableroFila3.setText(ArrayTablero[9] + ", " + ArrayTablero[10] + ", " + ArrayTablero[11] + ", " + ArrayTablero[12]);
        TableroFila3.setBounds(15, 600, 200, 15);
        TableroFila3.setFont(new Font("cooper black", 0, 10));

        TableroFila4.setText(ArrayTablero[13] + ", " + ArrayTablero[14] + ", " + ArrayTablero[15] + ", " + ArrayTablero[16] + ", " + ArrayTablero[17]);
        TableroFila4.setBounds(15, 625, 200, 15);
        TableroFila4.setFont(new Font("cooper black", 0, 10));

        Tablero.setBounds(137, 75, 300, 299);

        Dado.setBounds(250, 498, 50, 50);


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
        ventanaj.add(TableroFila1);
        ventanaj.add(TableroFila2);
        ventanaj.add(TableroFila3);
        ventanaj.add(TableroFila4);
        ventanaj.add(Dado);


        ventanaj.setLocationRelativeTo(null);

    }

    /**
     * Metodo que hace que los botones de la Ventana de juego sean funcionales.
     * @param e Corresponde a la escucha de los drivers del clickeo del mouse.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BotonMenu) {
            ventanaj.dispose();
            VentanaPrincipal.running = false;
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        }

        int NumRandom = (int) (Math.random() * 3 + 1);
        if (e.getSource() == BLanzarDado & NumRandom == 1) {
            varNumDado = 1;
            Espacio.setText(": 1");
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 += 1;
                Logica.turno(Servidor.varPos1, Servidor.board.head);
                Servidor.CasillaServidor = Logica.recorrerCasillas(Servidor.varPos1,
                        Servidor.board.head).getField();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 += 1;
                Logica.turno(Cliente.varPos2, Cliente.board.head);
                Cliente.CasillaCliente = Logica.recorrerCasillas(Cliente.varPos2,
                        Cliente.board.head).getField();
            }

        } else if (e.getSource() == BLanzarDado & NumRandom == 2) {
            varNumDado = 2;
            Espacio.setText(": 2");
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 += 2;
                Logica.turno(Servidor.varPos1, Servidor.board.head);
                Servidor.CasillaServidor = Logica.recorrerCasillas(Servidor.varPos1,
                        Servidor.board.head).getField();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 += 2;
                Logica.turno(Cliente.varPos2, Cliente.board.head);
                Cliente.CasillaCliente = Logica.recorrerCasillas(Cliente.varPos2,
                        Cliente.board.head).getField();
            }
        } else if (e.getSource() == BLanzarDado & NumRandom == 3) {
            varNumDado = 3;
            Espacio.setText(": 3");
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 += 3;
                Logica.turno(Servidor.varPos1, Servidor.board.head);
                Servidor.CasillaServidor = Logica.recorrerCasillas(Servidor.varPos1,
                        Servidor.board.head).getField();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 += 3;
                Logica.turno(Cliente.varPos2, Cliente.board.head);
                Cliente.CasillaCliente = Logica.recorrerCasillas(Cliente.varPos2,
                        Cliente.board.head).getField();
            }
        }

        varNumDado = 0;


    }

}

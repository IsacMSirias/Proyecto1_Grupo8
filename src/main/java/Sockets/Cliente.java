package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

import DoubleLinked.DoubleNode;
import DoubleLinked.DoublyLinkedList;
import GUI.VentanaJuego;
import GUI.VentanaPrincipal;


import javax.swing.*;

/**
 * Esta clase maneja la generación del cliente
 */

public class Cliente implements Runnable {

    //Host del servidor
    String HOST = "Localhost";
    //PORT del servidor
    int PORT = 5000;
    DataOutputStream output;
    DataInputStream input;
    /**
     * almacena el nombre del jugador 1
     */
    public static String Nombrejugador1;
    /**
     * almacena el nombre del jugador 2
     */
    public static String Nombrejugador2 = VentanaPrincipal.Nombre2;
    /**
     * almacena el tablero
     */
    public static DoublyLinkedList board = new DoublyLinkedList();
    /**
     * almacena la posición del jugador 1
     */
    public static int varPos1;
    /**
     * almacena la posición del jugador 2
     */
    public static int varPos2 = 0;
    /**
     * almacena el tipo de casilla del cliente
     */
    public static String CasillaCliente = "";
    /**
     * almacena el tipo de casilla del servidor
     */
    public static String CasillaServidor = "";
    /**
     * se utiliza para verificar si ya se salió de la lista el turno
     */
    private boolean casillaterminada = true;

    /**
     * Este metodo corre el cliente
     */
    public void run() {
        try {
            //Creo el socket para conectarme con el cliente

            Socket socket = new Socket(HOST, PORT);

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            //Envio un mensaje al servidor
            output.writeUTF(Nombrejugador2);

            //Recibo el mensaje del servidor
            Nombrejugador1 = input.readUTF();

            System.out.println(Nombrejugador1);

            ListFileRead.ReadValues();

            while (true){

                output.writeInt(varPos2);
                varPos1 = input.readInt();

                output.writeUTF(CasillaCliente);
                CasillaServidor = input.readUTF();


                VentanaJuego.Posicion1.setText("Posicion: "+ varPos1);
                VentanaJuego.Posicion2.setText("Posicion: "+ varPos2);

                VentanaJuego.CasillaTipo1.setText("Casilla " + CasillaServidor);
                VentanaJuego.CasillaTipo2.setText("Casilla " + CasillaCliente);

                if (Objects.equals(Logica.recorrerCasillas(varPos1, board.head).getField(), "Reto")){
                    Logica.MandarReto(Logica.recorrerCasillas(varPos1, board.head));
                }

                if (casillaterminada) {
                    if (varPos2 >= 16) {
                        varPos2 = 16;
                        VentanaJuego.Posicion2.setText("Posicion: "+ varPos2);
                        JOptionPane.showMessageDialog(null, "¡Ganaste!");
                        VentanaJuego.ventanaj.dispose();
                        VentanaPrincipal.running = false;
                        casillaterminada = false;

                    } else if (varPos1 >= 16) {
                        varPos1 = 16;
                        VentanaJuego.Posicion1.setText("Posicion: "+ varPos1);
                        JOptionPane.showMessageDialog(null, "¡Perdiste!");
                        VentanaJuego.ventanaj.dispose();
                        VentanaPrincipal.running = false;
                        casillaterminada = false;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

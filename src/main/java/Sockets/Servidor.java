package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;


import BoardGeneration.ListGeneration;
import DoubleLinked.DoubleNode;
import DoubleLinked.DoublyLinkedList;
import GUI.VentanaJuego;
import GUI.VentanaPrincipal;
import GUI.VentanaReto;

import javax.swing.*;

/**
 * Esta clase maneja la generación del servidor
 */
public class Servidor implements Runnable {

    ServerSocket servidor = null;
    /**
     * Instancia de la comunicacion entre el server y el cliente
     */
    public static Socket socket = null;
    DataOutputStream output;
    DataInputStream input;
    //PORT de nuestro servidor
    int PORT = 5000;
    /**
     * almacena el nombre del jugador 1
     */
    public static String Nombrejugador1 = VentanaPrincipal.Nombre;
    /**
     * almacena el nombre del jugador 2
     */
    public static String Nombrejugador2;
    /**
     * almacena la posición del jugador 1
     */
    public static int varPos1 = 0;
    /**
     * almacena la posición de la del jugador 2
     */
    public static int varPos2;
    /**
     * almacena el tipo de casilla del servidor
     */
    public static String CasillaServidor = "";
    /**
     * almacena el tipo de casilla del cliente
     */
    public static String CasillaCliente =  "";
    /**
     * almacena el tablero
     */
    public static DoublyLinkedList board;
    /**
     * almacena la cabeza del tablero
     */
    public static DoubleNode Node;
    /**
     * se utiliza para setear el key del Json
     */
    public static int contador = 0;
    /**
     * se utiliza para verificar si ya se salió de la lista el turno
     */
    private boolean casillaterminada = true;
    /**
     * Este método corre el servidor
     */
    public void run() {
        //Creamos el socket del servidor
        try {
            this.servidor = new ServerSocket(PORT);
            System.out.println("<<<<<<< SERVIDOR INICIADO >>>>>>");

            //genero la lista para el tablero
            ListGeneration list = new ListGeneration();
            board = list.random();

            //Espero a que un cliente se conecte
            socket = servidor.accept();
            System.out.println("-----> ¡CLIENTE CONECTADO! <-----");
            //Genero los canales de  entrada y salida
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            //Leo el mensaje que me envia el cliente
            Nombrejugador2 = input.readUTF();
            System.out.println(Nombrejugador2);

            //Le envio un mensaje
            output.writeUTF(Nombrejugador1);

            Node = board.head;

            ListFileWrite.WriteValues();

            while (true) {

                // Recibimos y enviamos la posición
                varPos2 = input.readInt();
                output.writeInt(varPos1);

                CasillaCliente = input.readUTF();
                output.writeUTF(CasillaServidor);

                // se setea la posicion del los jugadores
                VentanaJuego.Posicion1.setText("Posicion: "+ varPos1);
                VentanaJuego.Posicion2.setText("Posicion: "+ varPos2);


                // se setea la el tipo de casilla actual
                VentanaJuego.CasillaTipo1.setText("Casilla " + CasillaServidor);
                VentanaJuego.CasillaTipo2.setText("Casilla " + CasillaCliente);

                if (Objects.equals(Logica.recorrerCasillas(varPos2,board.head).getField(), "Reto")){
                    Logica.MandarReto(Logica.recorrerCasillas(varPos2,board.head));
                }

                if (casillaterminada) {
                    if (varPos1 >= 18) {
                        varPos1 = 18;
                        VentanaJuego.Posicion1.setText("Posicion: "+ varPos1);
                        JOptionPane.showMessageDialog(null, "¡GANASTE!");
                        VentanaJuego.ventanaj.dispose();
                        VentanaPrincipal.running = false;
                        casillaterminada = false;

                    } else if (varPos2 >= 18) {
                        varPos2 = 18;
                        VentanaJuego.Posicion2.setText("Posicion: "+ varPos2);
                        JOptionPane.showMessageDialog(null, "¡PERDISTE!");
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


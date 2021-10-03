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

/**
 * Esta clase maneja la generación del servidor
 */
public class Servidor implements Runnable {

    ServerSocket servidor = null;
    Socket socket = null;
    DataOutputStream output;
    DataInputStream input;
    //PORT de nuestro servidor
    int PORT = 5000;
    public static String Nombrejugador1 = VentanaPrincipal.Nombre;
    public static String Nombrejugador2;
    public static int varPos1 = 0;
    public static int varPos2;
    public static DoublyLinkedList board;
    public static DoubleNode Node;
    public static int contador = 1;

    /**
     * Este método corre el servidor
     */
    public void run() {
        //Creamos el socket del servidor
        try {
            this.servidor = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");

            //genero la lista para el tablero
            ListGeneration list = new ListGeneration();
            board = list.random();
            //Siempre estara escuchando peticiones

            //Espero a que un cliente se conecte
            socket = servidor.accept();
            System.out.println("Cliente conectado");
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

                VentanaJuego.Posicion1.setText("Posicion: "+ varPos1);
                VentanaJuego.Posicion2.setText("Posicion: "+ varPos2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


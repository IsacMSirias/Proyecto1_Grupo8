package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



import BoardGeneration.ListGeneration;
import DoubleLinked.DoubleNode;
import DoubleLinked.DoublyLinkedList;
import GUI.VentanaJuego;
import GUI.VentanaPrincipal;

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
    public static int varPos1;
    public static int varPos2;

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
            DoublyLinkedList board = list.random();
            DoubleNode node = new DoubleNode(null, "Reto", "+", 50, 50, 0, null);
            //Siempre estara escuchando peticiones
            while (true) {
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

                while (true) {
                   // Leo el mensaje que envia el cliente
                    varPos2 = input.readInt();
                    //System.out.println("Mensaje desde cliente" + varPos2);
                    // Envio un mensaje al cliente
                    output.writeInt(varPos1);

                }
                // output.writeUTF(Json.generateString(Json.toJson(board), false));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


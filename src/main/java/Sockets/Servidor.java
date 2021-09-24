package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



import BoardGeneration.ListGeneration;
import DoubleLinked.DoublyLinkedList;
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
            //Siempre estara escuchando peticiones
            while (true) {
                //Espero a que un cliente se conecte
                socket = servidor.accept();
                System.out.println("Cliente conectado");
                //Genero los canales de  entrada y salida
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());

                //Leo el mensaje que me envia
                Nombrejugador2 = input.readUTF();
                System.out.println(Nombrejugador2);

                //Le envio un mensaje
                output.writeUTF(Nombrejugador1);

                output.writeUTF(Json.generateString(Json.toJson(socket), true));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


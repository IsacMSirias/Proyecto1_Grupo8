package Sockets;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;



import BoardGeneration.ListGeneration;
import DoubleLinked.DoubleNode;
import DoubleLinked.DoublyLinkedList;
import GUI.VentanaPrincipal;

public class Servidor implements Runnable {

    Thread thread;
    ServerSocket servidor = null;
    Socket socket = null;

    DataOutputStream output;
    DataInputStream input;

    //PORT de nuestro servidor
    int PORT = 5000;
    public static String Nombrejugador1 = VentanaPrincipal.Nombre;
    public static String Nombrejugador2;


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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


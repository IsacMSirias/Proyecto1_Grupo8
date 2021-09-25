package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import DoubleLinked.DoubleNode;
import GUI.VentanaPrincipal;

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
    public static String Nombrejugador1;
    public static String Nombrejugador2 = VentanaPrincipal.Nombre2;
    public static int varPos1;
    public static int varPos2;

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

            while (true){
                // Envio de mensaje al server
                output.writeInt(varPos2);;
                //Recibo el mensaje
                varPos1 = input.readInt();

            }

            //String head = input.readUTF();
            //System.out.println(head);





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

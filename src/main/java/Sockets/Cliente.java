package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import DoubleLinked.DoubleNode;
import DoubleLinked.DoublyLinkedList;
import GUI.VentanaJuego;
import GUI.VentanaPrincipal;
import GUI.VentanaReto;

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
    public static DoublyLinkedList board = new DoublyLinkedList();;
    public static int varPos1;
    public static int varPos2 = 0;
    public static String CasillaCliente = "";
    public static String CasillaServidor = "";
    public static DoubleNode Node;
    private String respuesta;


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

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

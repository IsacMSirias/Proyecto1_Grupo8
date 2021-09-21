package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.VentanaPrincipal;

public class Cliente implements Runnable {

    //Host del servidor
    String HOST = "Localhost";
    //PORT del servidor
    int PORT = 5000;
    DataInputStream input;
    DataOutputStream output;
    public static String Nombrejugador1 = VentanaPrincipal.Nombre;
    public static String Nombrejugador2;

    public void run() {
        try {
            //Creo el socket para conectarme con el cliente
            Socket socket = new Socket(HOST, PORT);

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            //Envio un mensaje al servidor
            output.writeUTF(Nombrejugador1);

            //Recibo el mensaje del servidor
            String Nombrejugador2 = input.readUTF();

            System.out.println(Nombrejugador2);

            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

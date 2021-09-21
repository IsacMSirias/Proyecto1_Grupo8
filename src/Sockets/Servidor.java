package Sockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import BoardGeneration.ListGeneration;
import GUI.VentanaPrincipal;

public class Servidor implements Runnable {
    
    Thread thread;
    ServerSocket servidor = null;
    Socket socket = null;
    DataInputStream input;
    DataOutputStream output;
    //PORT de nuestro servidor
    int PORT = 5000;
    public static String Nombrejugador1;
    public static String Nombrejugador2 = VentanaPrincipal.Nombre2;

    public void run() {
        //Creamos el socket del servidor
        try {
            this.servidor = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");
            ListGeneration list = new ListGeneration();
            list.random();
            //Siempre estara escuchando peticiones
            while (true) {
                //Espero a que un cliente se conecte
                socket = servidor.accept();
                System.out.println("Cliente conectado");
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());

                //Leo el mensaje que me envia
                String Nombrejugador1 = input.readUTF();

                System.out.println(Nombrejugador1);

                //Le envio un mensaje
                output.writeUTF(Nombrejugador2);

                //Cierro el socket
                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
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

import GUI.VentanaPrincipal;

public class Cliente implements Runnable {

    //Host del servidor
    String HOST = "Localhost";
    //PORT del servidor
    int PORT = 5000;
    ObjectInputStream inputobject;
    ObjectOutputStream outputobject;
    DataOutputStream outputdata;
    DataInputStream inputdata;
    public static String Nombrejugador1;
    public static String Nombrejugador2 = VentanaPrincipal.Nombre2;

    public void run() {
        try {
            //Creo el socket para conectarme con el cliente
            Socket socket = new Socket(HOST, PORT);

            inputobject = new ObjectInputStream(socket.getInputStream());
            outputobject = new ObjectOutputStream(socket.getOutputStream());
            outputdata = new DataOutputStream(socket.getOutputStream());
            inputdata = new DataInputStream(socket.getInputStream());

            //Envio un mensaje al servidor
            outputdata.writeUTF(Nombrejugador2);

            //Recibo el mensaje del servidor
            Nombrejugador1 = inputdata.readUTF();
            System.out.println(Nombrejugador1);
            
            Paquetes CasillasRecibidas = new Paquetes();
            CasillasRecibidas = (Paquetes) inputobject.readObject();
            String Casilla1 = CasillasRecibidas.getCasilla1();
            String Casilla2 = CasillasRecibidas.getCasilla1();
            String Casilla3 = CasillasRecibidas.getCasilla1();
            String Casilla4 = CasillasRecibidas.getCasilla1();
            String Casilla5 = CasillasRecibidas.getCasilla1();
            String Casilla6 = CasillasRecibidas.getCasilla1();
            String Casilla7 = CasillasRecibidas.getCasilla1();
            String Casilla8 = CasillasRecibidas.getCasilla1();
            String Casilla9 = CasillasRecibidas.getCasilla1();
            String Casilla10 = CasillasRecibidas.getCasilla1();
            String Casilla11 = CasillasRecibidas.getCasilla1();
            String Casilla12 = CasillasRecibidas.getCasilla1();
            String Casilla13 = CasillasRecibidas.getCasilla1();
            String Casilla14 = CasillasRecibidas.getCasilla1();
            String Casilla15 = CasillasRecibidas.getCasilla1();
            

            socket.close();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

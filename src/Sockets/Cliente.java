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

            outputdata = new DataOutputStream(socket.getOutputStream());
            inputdata = new DataInputStream(socket.getInputStream());
            
            //Envio un mensaje al servidor
            outputdata.writeUTF(Nombrejugador2);
            
            //Recibo el mensaje del servidor
            Nombrejugador1 = inputdata.readUTF();
            System.out.println(Nombrejugador1);
            
            inputobject = new ObjectInputStream(socket.getInputStream());
            outputobject = new ObjectOutputStream(socket.getOutputStream());

            Paquetes CasillasRecibidas = new Paquetes();
            CasillasRecibidas = (Paquetes) inputobject.readObject();
            String Casilla1 = CasillasRecibidas.getCasilla1();
            String Casilla2 = CasillasRecibidas.getCasilla2();
            String Casilla3 = CasillasRecibidas.getCasilla3();
            String Casilla4 = CasillasRecibidas.getCasilla4();
            String Casilla5 = CasillasRecibidas.getCasilla5();
            String Casilla6 = CasillasRecibidas.getCasilla6();
            String Casilla7 = CasillasRecibidas.getCasilla7();
            String Casilla8 = CasillasRecibidas.getCasilla8();
            String Casilla9 = CasillasRecibidas.getCasilla9();
            String Casilla10 = CasillasRecibidas.getCasilla10();
            String Casilla11 = CasillasRecibidas.getCasilla11();
            String Casilla12 = CasillasRecibidas.getCasilla12();
            String Casilla13 = CasillasRecibidas.getCasilla13();
            String Casilla14 = CasillasRecibidas.getCasilla14();
            String Casilla15 = CasillasRecibidas.getCasilla15();
            String Casilla16 = CasillasRecibidas.getCasilla16();
            
            System.out.println(Casilla1);
            
            socket.close();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

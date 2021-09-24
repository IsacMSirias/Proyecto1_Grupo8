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

import org.json.simple.JSONArray;

import BoardGeneration.ListGeneration;
import DoubleLinked.DoubleNode;
import DoubleLinked.DoublyLinkedList;
import GUI.VentanaPrincipal;

public class Servidor implements Runnable {
    
    Thread thread;
    ServerSocket servidor = null;
    Socket socket = null;
    ObjectInputStream inputobject;
    ObjectOutputStream outputobject;
    //DataOutputStream outputdata;
    //DataInputStream inputdata;
    
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
            list.random();
            //Siempre estara escuchando peticiones
            while (true) {
                //Espero a que un cliente se conecte
                socket = servidor.accept();
                System.out.println("Cliente conectado");
<<<<<<< HEAD
                    
=======
                //Genero los canales de  entrada y salida 
                inputobject = new ObjectInputStream(socket.getInputStream());
                outputobject = new ObjectOutputStream(socket.getOutputStream());
                inputdata = new DataInputStream(socket.getInputStream());
                outputdata = new DataOutputStream(socket.getOutputStream()); 
                
                //Leo el mensaje que me envia
                Nombrejugador2 = inputdata.readUTF();
                System.out.println(Nombrejugador2);

                //Le envio un mensaje
                outputdata.writeUTF(Nombrejugador1);
  
>>>>>>> parent of 4984e33 (Cuarta versión)
                //Seteo las casillas
                Paquetes DatosCasillas = new Paquetes();
                DatosCasillas.setCasilla1(DoublyLinkedList.Casilla1);
                DatosCasillas.setCasilla2(DoublyLinkedList.Casilla2);
                DatosCasillas.setCasilla3(DoublyLinkedList.Casilla3);
                DatosCasillas.setCasilla4(DoublyLinkedList.Casilla4);
                DatosCasillas.setCasilla5(DoublyLinkedList.Casilla5);
                DatosCasillas.setCasilla6(DoublyLinkedList.Casilla6);
                DatosCasillas.setCasilla7(DoublyLinkedList.Casilla7);
                DatosCasillas.setCasilla8(DoublyLinkedList.Casilla8);
                DatosCasillas.setCasilla9(DoublyLinkedList.Casilla9);
                DatosCasillas.setCasilla10(DoublyLinkedList.Casilla10);
                DatosCasillas.setCasilla11(DoublyLinkedList.Casilla11);
                DatosCasillas.setCasilla12(DoublyLinkedList.Casilla12);
                DatosCasillas.setCasilla13(DoublyLinkedList.Casilla13);
                DatosCasillas.setCasilla14(DoublyLinkedList.Casilla14);
                DatosCasillas.setCasilla15(DoublyLinkedList.Casilla15);
                DatosCasillas.setCasilla16(DoublyLinkedList.Casilla16);
<<<<<<< HEAD
                DatosCasillas.setNombrejugador1(Nombrejugador1);
                
                
                
                System.out.println(DatosCasillas.getCasilla1()); 
                
                outputobject = new ObjectOutputStream(socket.getOutputStream()); // Eso tilín acércate
                
=======

>>>>>>> parent of 4984e33 (Cuarta versión)
                //envio los datos de las casillas a modo de lista(objeto) "DatosCasillas"
                outputobject.writeObject(DatosCasillas);
                
                //Cierro el socket
                inputobject = new ObjectInputStream(socket.getInputStream());
                Paquetes PaqueteRecibidodelcliente = new Paquetes();

                PaqueteRecibidodelcliente = (Paquetes) inputobject.readObject();
                Nombrejugador2 = PaqueteRecibidodelcliente.getNombrejugador2();
                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Paquetes implements Serializable {
<<<<<<< HEAD
    private DoubleNode casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7, casilla8, casilla9, 
    casilla10, casilla11, casilla12, casilla13, casilla14, Casilla15, casilla16;
    private String nombrejugador1, nombrejugador2;
=======
    private String casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7, casilla8, casilla9, 
    casilla10, casilla11, casilla12, casilla13, casilla14, Casilla15, casilla16, nombrejugador1, nombrejugador2;

    public String getNombrejugador1() {
        return nombrejugador1;
    }

    public void setNombrejugador1(String nombrejugador1) {
        this.nombrejugador1 = nombrejugador1;
    }

    public String getNombrejugador2() {
        return nombrejugador2;
    }

    public void setNombrejugador2(String nombrejugador2) {
        this.nombrejugador2 = nombrejugador2;
    }
>>>>>>> parent of 4984e33 (Cuarta versión)

    public DoubleNode getCasilla1() {
        return casilla1;
    }

    public void setCasilla1(DoubleNode casilla1) {
        this.casilla1 = casilla1;
    }

    public DoubleNode getCasilla2() {
        return casilla2;
    }

    public void setCasilla2(DoubleNode casilla2) {
        this.casilla2 = casilla2;
    }

    public DoubleNode getCasilla3() {
        return casilla3;
    }

    public void setCasilla3(DoubleNode casilla3) {
        this.casilla3 = casilla3;
    }

    public DoubleNode getCasilla4() {
        return casilla4;
    }

    public void setCasilla4(DoubleNode casilla4) {
        this.casilla4 = casilla4;
    }

    public DoubleNode getCasilla5() {
        return casilla5;
    }

    public void setCasilla5(DoubleNode casilla5) {
        this.casilla5 = casilla5;
    }

    public DoubleNode getCasilla6() {
        return casilla6;
    }

    public void setCasilla6(DoubleNode casilla6) {
        this.casilla6 = casilla6;
    }

    public DoubleNode getCasilla7() {
        return casilla7;
    }

    public void setCasilla7(DoubleNode casilla7) {
        this.casilla7 = casilla7;
    }

    public DoubleNode getCasilla8() {
        return casilla8;
    }

    public void setCasilla8(DoubleNode casilla8) {
        this.casilla8 = casilla8;
    }

    public DoubleNode getCasilla9() {
        return casilla9;
    }

    public void setCasilla9(DoubleNode casilla9) {
        this.casilla9 = casilla9;
    }

    public DoubleNode getCasilla10() {
        return casilla10;
    }

    public void setCasilla10(DoubleNode casilla10) {
        this.casilla10 = casilla10;
    }

    public DoubleNode getCasilla11() {
        return casilla11;
    }

    public void setCasilla11(DoubleNode casilla11) {
        this.casilla11 = casilla11;
    }

    public DoubleNode getCasilla12() {
        return casilla12;
    }

    public void setCasilla12(DoubleNode casilla12) {
        this.casilla12 = casilla12;
    }

    public DoubleNode getCasilla13() {
        return casilla13;
    }

    public void setCasilla13(DoubleNode casilla13) {
        this.casilla13 = casilla13;
    }

    public DoubleNode getCasilla14() {
        return casilla14;
    }

    public void setCasilla14(DoubleNode casilla14) {
        this.casilla14 = casilla14;
    }

    public DoubleNode getCasilla15() {
        return Casilla15;
    }

    public void setCasilla15(DoubleNode casilla15) {
        Casilla15 = casilla15;
    }

    public DoubleNode getCasilla16() {
        return casilla16;
    }

    public void setCasilla16(DoubleNode casilla16) {
        this.casilla16 = casilla16;
    }

    public String getNombrejugador1() {
        return nombrejugador1;
    }

    public void setNombrejugador1(String nombrejugador1) {
        this.nombrejugador1 = nombrejugador1;
    }

    public String getNombrejugador2() {
        return nombrejugador2;
    }

    public void setNombrejugador2(String nombrejugador2) {
        this.nombrejugador2 = nombrejugador2;
    }
    

}
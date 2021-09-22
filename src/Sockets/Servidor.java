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
import DoubleLinked.DoublyLinkedList;
import GUI.VentanaPrincipal;

public class Servidor implements Runnable {
    
    Thread thread;
    ServerSocket servidor = null;
    Socket socket = null;
    ObjectInputStream inputobject;
    ObjectOutputStream outputobject;
    DataOutputStream outputdata;
    DataInputStream inputdata;
    
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
                inputdata = new DataInputStream(socket.getInputStream());
                outputdata = new DataOutputStream(socket.getOutputStream()); 
                
                //Leo el mensaje que me envia
                Nombrejugador2 = inputdata.readUTF();
                System.out.println(Nombrejugador2);
                
                //Le envio un mensaje
                outputdata.writeUTF(Nombrejugador1);
                
                
                inputobject = new ObjectInputStream(socket.getInputStream());
                outputobject = new ObjectOutputStream(socket.getOutputStream()); // cuidao tilin no ti acerques
                
                System.out.println(board.Casilla1);
                
                //Seteo las casillas
                Paquetes DatosCasillas = new Paquetes();
                DatosCasillas.setCasilla1(board.Casilla1);
                DatosCasillas.setCasilla2(board.Casilla2);
                DatosCasillas.setCasilla3(board.Casilla3);
                DatosCasillas.setCasilla4(board.Casilla4);
                DatosCasillas.setCasilla5(board.Casilla5);
                DatosCasillas.setCasilla6(board.Casilla6);
                DatosCasillas.setCasilla7(board.Casilla7);
                DatosCasillas.setCasilla8(board.Casilla8);
                DatosCasillas.setCasilla9(board.Casilla9);
                DatosCasillas.setCasilla10(board.Casilla10);
                DatosCasillas.setCasilla11(board.Casilla11);
                DatosCasillas.setCasilla12(board.Casilla12);
                DatosCasillas.setCasilla13(board.Casilla13);
                DatosCasillas.setCasilla14(board.Casilla14);
                DatosCasillas.setCasilla15(board.Casilla15);
                DatosCasillas.setCasilla16(board.Casilla16);

                //envio los datos de las casillas a modo de lista(objeto) "DatosCasillas"
                outputobject.writeObject(DatosCasillas);
                

                //Cierro el socket
                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Paquetes implements Serializable {
    private String casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7, casilla8, casilla9, 
    casilla10, casilla11, casilla12, casilla13, casilla14, Casilla15, casilla16;

    public String getCasilla1() {
        return casilla1;
    }

    public void setCasilla1(String casilla1) {
        this.casilla1 = casilla1;
    }

    public String getCasilla2() {
        return casilla2;
    }

    public void setCasilla2(String casilla2) {
        this.casilla2 = casilla2;
    }

    public String getCasilla3() {
        return casilla3;
    }

    public void setCasilla3(String casilla3) {
        this.casilla3 = casilla3;
    }

    public String getCasilla4() {
        return casilla4;
    }

    public void setCasilla4(String casilla4) {
        this.casilla4 = casilla4;
    }

    public String getCasilla5() {
        return casilla5;
    }

    public void setCasilla5(String casilla5) {
        this.casilla5 = casilla5;
    }

    public String getCasilla6() {
        return casilla6;
    }

    public void setCasilla6(String casilla6) {
        this.casilla6 = casilla6;
    }

    public String getCasilla7() {
        return casilla7;
    }

    public void setCasilla7(String casilla7) {
        this.casilla7 = casilla7;
    }

    public String getCasilla8() {
        return casilla8;
    }

    public void setCasilla8(String casilla8) {
        this.casilla8 = casilla8;
    }

    public String getCasilla9() {
        return casilla9;
    }

    public void setCasilla9(String casilla9) {
        this.casilla9 = casilla9;
    }

    public String getCasilla10() {
        return casilla10;
    }

    public void setCasilla10(String casilla10) {
        this.casilla10 = casilla10;
    }

    public String getCasilla11() {
        return casilla11;
    }

    public void setCasilla11(String casilla11) {
        this.casilla11 = casilla11;
    }

    public String getCasilla12() {
        return casilla12;
    }

    public void setCasilla12(String casilla12) {
        this.casilla12 = casilla12;
    }

    public String getCasilla13() {
        return casilla13;
    }

    public void setCasilla13(String casilla13) {
        this.casilla13 = casilla13;
    }

    public String getCasilla14() {
        return casilla14;
    }

    public void setCasilla14(String casilla14) {
        this.casilla14 = casilla14;
    }

    public String getCasilla15() {
        return Casilla15;
    }

    public void setCasilla15(String casilla15) {
        Casilla15 = casilla15;
    }

    public String getCasilla16() {
        return casilla16;
    }

    public void setCasilla16(String casilla16) {
        this.casilla16 = casilla16;
    }
}
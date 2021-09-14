package sockets;
import java.net.*;
import java.io.*;
/**
 *
 * @author Albert Vega Camacho
 */
public class Servidor {
    /**
     * Attributes of server
     */
    ServerSocket server;
    Socket socket;
    int port = 9000;
    PrintWriter output; 
    BufferedReader input;
    boolean conectando = true;
    
    public void run(){
        try{
            server = new ServerSocket(port);
            socket = new Socket();
            while(conectando == true){
                socket = server.accept();
                this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.output = new PrintWriter(socket.getOutputStream(), true);
                String message = input.readLine();
                System.out.println(message);
                if(message == "Conectado!"){ // esta condición no se cumple (averiguar por qué)
                    this.conectando = false;
                }
                output.println("Partida iniciada");
                output.close();
            }
        }catch(Exception e){};
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.run();
    }
}

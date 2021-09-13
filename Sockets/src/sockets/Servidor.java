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
    DataOutputStream output; 
    BufferedReader input;
    boolean conectando = true;
    
    public void run(){
        while(conectando == true){
            try{
                server = new ServerSocket(port);
                socket = new Socket();
                socket = server.accept();
                this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = input.readLine();
                System.out.println(message);
                this.output = new DataOutputStream(socket.getOutputStream());
                if(message == "Conectado!"){
                    this.conectando = false;
                }
            }catch(Exception e){};
        }
        try {
            output.writeUTF("Partida iniciada");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.run();
    }
}

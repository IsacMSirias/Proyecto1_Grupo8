/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void run(){
        while(true){
            try{
                server = new ServerSocket(port);
                socket = new Socket();
                socket = server.accept();
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = input.readLine();
                System.out.println(message);
                output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Desconectado...");
                output.close();
            }catch(Exception e){};
        }
    }
}

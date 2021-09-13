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
public class Cliente {
    /**
     * Attributes of client
     */
    Socket socket;
    int port = 9000;
    String ipAddress = "192.168.0.16";
    BufferedReader input;
    DataOutputStream output;
    
    public void start(String ipAddress, int port) throws IOException {
        socket = new Socket(ipAddress, port);
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = input.readLine();
        System.out.println(message);
        this.output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF("Conectado!");
        output.close();
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            cliente.start("192.168.0.16", 9000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
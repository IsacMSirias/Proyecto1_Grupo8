import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        //Host del servidor
        String HOST = "Localhost";
        //PORT del servidor
        int PORT = 5000;
        DataInputStream input;
        DataOutputStream output;

        try {
            //Creo el socket para conectarme con el cliente
            Socket socket = new Socket(HOST, PORT);

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            //Envio un mensaje al servidor
            Scanner keyboard = new Scanner(System.in);
            String MensajeParaServidor = keyboard.nextLine();
            output.writeUTF(MensajeParaServidor);

            //Recibo el mensaje del servidor
            String mensaje = input.readUTF();

            System.out.println(mensaje);

            socket.close();
            keyboard.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

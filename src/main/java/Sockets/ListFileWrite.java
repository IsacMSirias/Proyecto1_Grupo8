package Sockets;

import DoubleLinked.DoubleNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class ListFileWrite {


    @SuppressWarnings("unchecked")
    public static void WriteValues() {
        JSONObject obj = new JSONObject();
        JSONArray listadatos;
        while(Servidor.Node != null) {
            listadatos = new JSONArray();
            listadatos.add(Servidor.Node.getField());
            listadatos.add(Servidor.Node.getMovement());
            listadatos.add(Servidor.Node.getOperation());
            listadatos.add(Servidor.Node.getA());
            listadatos.add(Servidor.Node.getB());
            obj.put("Casilla "+Servidor.contador, listadatos);
            Servidor.Node = Servidor.Node.getNext();
            Servidor.contador++;
        }

        try (FileWriter file = new FileWriter("src/main/java/Sockets/Jsontxt.txt")){

            file.write(obj.toJSONString());
            file.flush();
            System.out.println(obj);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

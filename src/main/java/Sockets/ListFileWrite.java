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
        while(Servidor.campo != null) {
            listadatos = new JSONArray();
            listadatos.add(Servidor.campo.getField());
            listadatos.add(Servidor.campo.getMovement());
            listadatos.add(Servidor.campo.getOperation());
            listadatos.add(Servidor.campo.getA());
            listadatos.add(Servidor.campo.getB());
            obj.put("Casilla "+Servidor.contador, listadatos);
            Servidor.campo = Servidor.campo.getNext();
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

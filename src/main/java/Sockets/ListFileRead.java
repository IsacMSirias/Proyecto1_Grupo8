package Sockets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

import static Sockets.Cliente.board;

/**
 * Esta clase se encarga de leer el Json
 */
public class ListFileRead {
    /**
     * esta variable almacena la información de cada casilla
     */
    public static JSONArray casilla;

    /**
     * Este metodo lee el Json
     */
    public static void ReadValues() {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("src/main/java/Sockets/Jsontxt.txt"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            for (int i = 0; i < 18; i++) {
                casilla = (JSONArray) jsonObject.get("Casilla " + i);
                Cliente.board.addFieldAtEnd(String.valueOf(casilla.get(0)), String.valueOf(casilla.get(2)), Integer.parseInt(String.valueOf(casilla.get(3))), Integer.parseInt(String.valueOf(casilla.get(4))), Integer.parseInt(String.valueOf(casilla.get(1))));
            }
            board.display();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}

package Sockets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class ListFileRead {
    public static JSONArray casilla1;
    public static JSONArray casilla2;
    public static JSONArray casilla3;
    public static JSONArray casilla4;
    public static JSONArray casilla5;
    public static JSONArray casilla6;
    public static JSONArray casilla7;
    public static JSONArray casilla8;
    public static JSONArray casilla9;
    public static JSONArray casilla10;
    public static JSONArray casilla11;
    public static JSONArray casilla12;
    public static JSONArray casilla13;
    public static JSONArray casilla14;
    public static JSONArray casilla15;
    public static JSONArray casilla16;

    public static void ReadValues() {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("src/main/java/Sockets/Jsontxt.txt"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            casilla1 = (JSONArray) jsonObject.get("Casilla 1");
            casilla2 = (JSONArray) jsonObject.get("Casilla 2");
            casilla3 = (JSONArray) jsonObject.get("Casilla 3");
            casilla4 = (JSONArray) jsonObject.get("Casilla 4");
            casilla5 = (JSONArray) jsonObject.get("Casilla 5");
            casilla6 = (JSONArray) jsonObject.get("Casilla 6");
            casilla7 = (JSONArray) jsonObject.get("Casilla 7");
            casilla8 = (JSONArray) jsonObject.get("Casilla 8");
            casilla9 = (JSONArray) jsonObject.get("Casilla 9");
            casilla10 = (JSONArray) jsonObject.get("Casilla 10");
            casilla11 = (JSONArray) jsonObject.get("Casilla 11");
            casilla12 = (JSONArray) jsonObject.get("Casilla 12");
            casilla13 = (JSONArray) jsonObject.get("Casilla 13");
            casilla14 = (JSONArray) jsonObject.get("Casilla 14");
            casilla15 = (JSONArray) jsonObject.get("Casilla 15");
            casilla16 = (JSONArray) jsonObject.get("Casilla 16");

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}

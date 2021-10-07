package Sockets;
import DoubleLinked.DoublyLinkedList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Clase para le manejo de json
 */

public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }

    /**
     * De String a Jsonnode
     * @param jsonSource JsonSource
     * @return Jsonnode
     * @throws JsonProcessingException JsonProcessingException
     */

    public static JsonNode parse(String jsonSource) throws JsonProcessingException{
        return objectMapper.readTree(jsonSource);
    }

    /**
     * De Json nodo a objeto
     * @param node node
     * @param clazz clazz
     * @param <A> A
     * @return objeto
     * @throws JsonProcessingException JsonProcessingExceptions
     */

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException{
        //De JsonNode a Objeto
        return objectMapper.treeToValue(node,clazz);
    }

    /**
     * De objeto a json
     * @param o o
     * @return JsonNode
     */

    public static JsonNode toJson(Object o) throws JsonProcessingException {
        //De objeto a JsonNode
        System.out.println(objectMapper.canSerialize(DoublyLinkedList.class));
        return objectMapper.valueToTree(o);
    }

    /**
     * De jsonnode a String
     * @param node node
     * @param pretty pretty
     * @return String
     * @throws JsonProcessingException JsonProcessingExceptions
     */

    public static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException{
        //De Json node a string
        ObjectWriter objectWriter = objectMapper.writer();
        if(pretty){
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(node);
    }

    /**
     * Metodo para leer en .json
     * @param file file
     * @return String
     */

    public static String ReadJson(String file) {
        //Lee el archivo.json
        String json = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));

            try{
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null){
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                json = sb.toString();

            } finally {
                br.close();
            }

            return json;

        }catch (Exception e){
            e.printStackTrace();
        }

        return json;
    }
}
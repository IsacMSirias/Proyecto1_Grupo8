package Sockets;

import DoubleLinked.DoubleNode;
import GUI.VentanaJuego;
import GUI.VentanaReto;
import org.w3c.dom.Node;

public class Logica {

    // imprimir casillas
    // mandar reto

    public DoubleNode recorrerCasillas(int pos, DoubleNode head) {
        DoubleNode node = head;
        for (int i = 0; i <= pos; i++) {
            node.getNext();
        }
        return node;
    }

    public static void MandarReto(DoubleNode Node) {

            int a = Node.getA();
            int b = Node.getB();

            String respuesta = VentanaReto.respuesta;

            switch (Node.getOperation()) {
                case "+" -> respuesta = Integer.toString(a + b);
                case "-" -> respuesta = Integer.toString(a - b);
                case "*" -> respuesta = Integer.toString(a * b);
                case "/" -> respuesta = Integer.toString(a / b);
            }
            VentanaReto.Operacion = a + Node.getOperation() +b;

            }


}
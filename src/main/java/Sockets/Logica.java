package Sockets;

import DoubleLinked.DoubleNode;
import GUI.VentanaJuego;
import GUI.VentanaPrincipal;
import GUI.VentanaReto;
import org.w3c.dom.Node;

import java.util.Objects;

public class Logica {

    public static DoubleNode recorrerCasillas(int pos, DoubleNode head) {
        DoubleNode node = head;
        System.out.println(node);
        return node.getNext();
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
        VentanaReto.Operacion = a + Node.getOperation() + b;
    }

    public static void turno(int num, DoubleNode head) {
        DoubleNode node = recorrerCasillas(num, head);
        if(Objects.equals(node.getField(), "Reto")) {
            MandarReto(node);
        } else if (Objects.equals(node.getField(), "Trampa")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 -= node.getMovement();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 -= node.getMovement();
            }
        } else if (Objects.equals(node.getField(), "Tunel")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 += node.getMovement();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 += node.getMovement();
            }
        }
    }

}
package Sockets;

import DoubleLinked.DoubleNode;
import GUI.VentanaJuego;
import GUI.VentanaPrincipal;
import GUI.VentanaReto;
import org.w3c.dom.Node;

import java.util.Objects;

public class Logica {
    public static String respuesta;
    public static boolean esperando = true;

    public static DoubleNode recorrerCasillas(int pos, DoubleNode head) {
        DoubleNode node = head;
        for(int i = 0; i <= pos; i++) {
            node = node.getNext();
            System.out.println(node.getField());
        }
        return node;
    }

    public static void MandarReto(DoubleNode Node) {
        if (esperando) {
            esperando = false;
            System.out.println("Tamo activo papi");
            int a = Node.getA();
            int b = Node.getB();

            switch (Node.getOperation()) {
                case "+" -> respuesta = Integer.toString(a + b);
                case "-" -> respuesta = Integer.toString(a - b);
                case "*" -> respuesta = Integer.toString(a * b);
                case "/" -> respuesta = Integer.toString(a / b);
                default -> throw new IllegalStateException("Unexpected value: " + Node.getOperation());
            }
            VentanaReto.respuesta = respuesta;
            VentanaReto.Operacion = a + Node.getOperation() + b;
            VentanaReto reto = new VentanaReto();
        }
    }

    public static void turno(int num, DoubleNode head) {
        Logica.esperando = true;
        DoubleNode node = recorrerCasillas(num, head);
        if(Objects.equals(node.getField(), "Reto")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1++;
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2++;
            }
        } else if (Objects.equals(node.getField(), "Trampa")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 -= node.getMovement();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 -= node.getMovement();
            }
            System.out.println("Trampa " + node.getMovement());
        } else if (Objects.equals(node.getField(), "Tunel")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 += node.getMovement();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 += node.getMovement();
            }
            System.out.println("Tunel" + node.getMovement());
        }
    }

}
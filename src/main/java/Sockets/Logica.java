package Sockets;

import DoubleLinked.DoubleNode;
import GUI.*;
import org.w3c.dom.Node;

import java.util.Objects;

public class Logica {
    public static String respuesta;
    public static Boolean esperando = true;
    public static DoubleNode recorrerCasillas(int pos, DoubleNode head) {
        DoubleNode node = head;
        for(int i = 0; i < pos; i++) {
            node = node.getNext();
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
        DoubleNode node = recorrerCasillas(num, head);
        esperando = true;
        if(Objects.equals(node.getField(), "Reto")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1++;
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2++;
            }

        } else if (Objects.equals(node.getField(), "Trampa")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 -= node.getMovement();
                VenTrampa trampa = new VenTrampa();
                if (Servidor.varPos1 < 0){
                    Servidor.varPos1 = 0;
                }
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 -= node.getMovement();
                VenTrampa trampa = new VenTrampa();
                if (Cliente.varPos2 < 0){
                    Cliente.varPos2 = 0;
                }
            }

            System.out.println("Trampa " + node.getMovement());

        } else if (Objects.equals(node.getField(), "Tunel")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 += node.getMovement();
                VenTunel tunel = new VenTunel();
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 += node.getMovement();
                VenTunel tunel = new VenTunel();
            }
            System.out.println("Tunel " + node.getMovement());
        }
    }

}
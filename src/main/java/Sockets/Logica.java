package Sockets;

import DoubleLinked.DoubleNode;
import GUI.VenTrampa;
import GUI.VenTunel;
import GUI.VentanaPrincipal;
import GUI.VentanaReto;
import java.util.Objects;
import static java.lang.Thread.sleep;

/**
 * Esta clase se encarga de ejecutar las funciones básicas del juego.
 */
public class Logica {
    public static String respuesta;
    public static Boolean esperando = true;
    private static DoubleNode tmp_node;

    /**
     * Este método recorre las casillas de principio a fin.
     * @param pos Posición del jugador
     * @param head Cabeza de la lista doblemente enlazada
     * @return Retorna el nodo que se ubica en la posición del jugador
     */
    public static DoubleNode recorrerCasillas(int pos, DoubleNode head) {
        DoubleNode node = head;
        for(int i = 0; i < pos; i++) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Este método se encarga de abrir la ventana juego y guardar la respueste del problema.
     * @param Node Nodo de la casilla reto
     */

    public static void MandarReto(DoubleNode Node) {
        if (esperando && Node != tmp_node) {
            esperando = false;
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

    /**
     * Se encarga de recorrer las casillas y leer el nodo en el que termina.
     * @param num Posición del jugador
     * @param head Cabeza de la lista doblemente enlazada
     */
    public static void turno(int num, DoubleNode head) {
        DoubleNode node = recorrerCasillas(num, head);
        if(Objects.equals(node.getField(), "Reto")) {
            esperando = true;
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Servidor.varPos1++;
            }
            if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Cliente.varPos2++;
            }


        }else if (Objects.equals(node.getField(), "Trampa")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 -= node.getMovement();
                VenTrampa trampa = new VenTrampa();
                VenTrampa.Mensaje1.setText("El jugador se ha movido  " +"-"+ node.getMovement());
                if (Servidor.varPos1 < 0){
                    Servidor.varPos1 = 0;
                }
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 -= node.getMovement();
                VenTrampa trampa = new VenTrampa();
                VenTrampa.Mensaje1.setText("El jugador se ha movido  " +"-"+ node.getMovement());
                if (Cliente.varPos2 < 0){
                    Cliente.varPos2 = 0;
                }
            }

            System.out.println("Trampa " + node.getMovement());

        } else if (Objects.equals(node.getField(), "Tunel")) {
            if (Objects.equals(VentanaPrincipal.conexion, "servidor")) {
                Servidor.varPos1 += node.getMovement();
                VenTunel tunel = new VenTunel();
                VenTunel.TMensaje1.setText("El jugador se ha movido  " + node.getMovement());
            } else if (Objects.equals(VentanaPrincipal.conexion, "cliente")) {
                Cliente.varPos2 += node.getMovement();
                VenTunel tunel = new VenTunel();
                VenTunel.TMensaje1.setText("El jugador se ha movido  " + node.getMovement());
            }
            System.out.println("Tunel " + node.getMovement());
        }
    }

}
package Sockets;

import DoubleLinked.DoubleNode;

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


}

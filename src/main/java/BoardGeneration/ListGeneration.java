package BoardGeneration;

import java.util.Random;

import DoubleLinked.DoublyLinkedList;

/**
 * Esta clase genera una lista para el tablero con las proporciones respectivas de cada tipo de casilla.
 */
public class ListGeneration {
    /**
     * Instancia de la lista doblemente enlazada
     */
    public DoublyLinkedList board = new DoublyLinkedList();
    /**
     *  Posicion de la casilla de reto
     */
    public int casillas_reto = 0;
    /**
     * Posicion de la casilla de trampa
     */
    public int casillas_trampa = 0;
    /**
     * Posicionnde la casilla de tunel
     */
    public int casillas_tunel = 0;

    /**
     * Este método genera una lista aleatoria con las especificaciones del proyecto.
     * @return la lista generada
     */
    public DoublyLinkedList random() {
        Random random = new Random();
        board.addFieldAtFront("Inicio", "", 0, 0, 0);
        for (int i = 0; i < 18; i++) {
            int num = random.nextInt(3);
            System.out.println(num);
            if (num == 0 && this.casillas_reto < 8) {
                int num_opt = random.nextInt(4);
                String opt = "";
                if (num_opt == 0) {
                    opt = "+";
                } else if (num_opt == 1) {
                    opt = "-";
                } else if (num_opt == 2) {
                    opt = "*";
                } else if (num_opt == 3) {
                    opt = "/";
                }
                board.addFieldAtEnd("Reto", opt, random.nextInt(49)+1, random.nextInt(49)+1, 0);
                this.casillas_reto++;
            } else if (num == 1 && casillas_trampa < 4) {
                board.addFieldAtEnd("Trampa", "", 0, 0, random.nextInt(3)+1);
                this.casillas_trampa++;
            } else if (num == 2 && casillas_tunel < 4) {
                board.addFieldAtEnd("Tunel", "", 0, 0, random.nextInt(3)+1);
                this.casillas_tunel++;
            } else {
                if (this.casillas_reto < 8) {
                    int num_opt = random.nextInt(4);
                    String opt = "";
                    if (num_opt == 0) {
                        opt = "+";
                    } else if (num_opt == 1) {
                        opt = "-";
                    } else if (num_opt == 2) {
                        opt = "*";
                    } else if (num_opt == 3) {
                        opt = "/";
                    }
                    board.addFieldAtEnd("Reto", opt, random.nextInt(49)+1, random.nextInt(49)+1, 0);
                    this.casillas_reto++;
                } else if (casillas_trampa < 4) {
                    board.addFieldAtEnd("Trampa", "", 0, 0, random.nextInt(3)+1);
                    this.casillas_trampa++;
                } else if (casillas_tunel < 4) {
                    board.addFieldAtEnd("Tunel", "", 0, 0, random.nextInt(3)+1);
                    this.casillas_tunel++;
                }
            }
        }
        board.addFieldAtEnd("Final", "", 0, 0, 0);
        System.out.println(board.countBNodes());
        board.display();
        return board;
    }
}

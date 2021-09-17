import java.util.Random;

public class ListGeneration {
    public DoublyLinkedList board = new DoublyLinkedList();
    public int casillas_reto = 0;
    public int casillas_trampa = 0;
    public int casillas_tunel = 0;

    public DoublyLinkedList random() {
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int num = random.nextInt(3);
            System.out.println(num);
            if (num == 0 && this.casillas_reto < 8) {
                board.addFieldAtEnd("Reto");
                this.casillas_reto++;
            } else if (num == 1 && casillas_trampa < 4) {
                board.addFieldAtEnd("Trampa");
                this.casillas_trampa++;
            } else if (num == 2 && casillas_tunel < 4) {
                board.addFieldAtEnd("Tunel");
                this.casillas_tunel++;
            } else {
                if (this.casillas_reto < 8) {
                    board.addFieldAtEnd("Reto");
                    this.casillas_reto++;
                } else if (casillas_trampa < 4) {
                    board.addFieldAtEnd("Trampa");
                    this.casillas_trampa++;
                } else if (casillas_tunel < 4) {
                    board.addFieldAtEnd("Tunel");
                    this.casillas_tunel++;
                }
            }
        }
        board.display();
        return board;
    }

    public static void main(String[] args) {
        ListGeneration list = new ListGeneration();
        list.random();
    }
}

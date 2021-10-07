package DoubleLinked;

/**
 *
 */
public class DoublyLinkedList {

    public DoubleNode head;
    public DoubleNode tail;

    /**
     * Construye un nuevo objeto DoublyLinkedList con el head y el tail como null.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;

    }

    /**
     * Retorna true si la lista está vacía y falso si no.
     *
     * @return true si la lista está vacía y falso si no
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Añade un BNode al final de la lista.
     *
     * @param str  Nombre del BNode
     * @param opt  Operador
     * @param num1 A
     * @param num2 B
     * @param mvt  Movimientos
     */
    public void addFieldAtEnd(String str, String opt, int num1, int num2, int mvt) {
        DoubleNode n = new DoubleNode(tail, str, opt, num1, num2, mvt, null);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    /**
     * Añade un BNode al principio de la lista.
     *
     * @param str  Nombre del BNode
     * @param opt  Operador
     * @param num1 A
     * @param num2 B
     * @param mvt  Movimientos
     */
    public void addFieldAtFront(String str, String opt, int num1, int num2, int mvt) {
        DoubleNode n = new DoubleNode(null, str, opt, num1, num2, mvt, head);
        if (isEmpty()) {
            head = tail = n;
        } else {
            head.setPrev(n);
            head = n;
        }
    }

    /**
     * Elimina y retorna el nombre del BNode al principio de la lista.
     *
     * @return el nombre del BNode al principio de la lista
     */
    public String removeFieldFromFront() {
        String str = head.getField();
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
        }
        return str;
    }

    /**
     * Elimina y retorna el nombre del BNode al final de la lista.
     *
     * @return el nombre del BNode al final de la lista
     */
    public String removeFieldAtEnd() {
        String str = tail.getField();

        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.getPrev();
                tail.setNext(null);
            }
        }

        return str;
    }

    /**
     * Cuenta la cantidad de BNodes en la lista.
     *
     * @return la cantidad de BNodes en la lista entre head y tail (inclusivo)
     */
    public int countBNodes() {
        DoubleNode cn = head;
        int count = 0;
        while (cn != null) {
            count++;
            cn = cn.getNext();
        }
        return count;
    }

    /**
     * Muestra los nombres de todos los BNodes en un print.
     */
    public void display() {
        //Node current will point to head
        DoubleNode cn = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (cn != null) {
            //Prints each node by incrementing the pointer.
            System.out.print(cn.getField() + " ");
            cn = cn.getNext();
        }


    }

    /**
     * Este metodo genera un array con los nombres de las posiciones del tablero generado
     * @return este metodo retorna un array actualizada con el tablero actual generado
     */
    public String[] displayGrphics() {
        String TableroEscrito[] = new String[18];
        DoubleNode cn = head;
        int i = 0;
        while (cn != null){
            TableroEscrito[i] = cn.getField();
            cn = cn.getNext();
            i ++;
        }
        return TableroEscrito;
    }

}

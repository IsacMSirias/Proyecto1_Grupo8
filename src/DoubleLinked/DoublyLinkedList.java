package DoubleLinked;

public class DoublyLinkedList {
    public static String Casilla1;
    public static String Casilla2;
    public static String Casilla3;
    public static String Casilla4;
    public static String Casilla5;
    public static String Casilla6;
    public static String Casilla7;
    public static String Casilla8;
    public static String Casilla9;
    public static String Casilla10;
    public static String Casilla11;
    public static String Casilla12;
    public static String Casilla13;
    public static String Casilla14;
    public static String Casilla15;
    public static String Casilla16;

    private DoubleNode head;
    private DoubleNode tail;

    /**
     * Constructs a new DoublyLinkedList object with head and tail as null.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        
    }

    /**
     * Returns true if the list is empty false otherwise
     * @return true if the list empty false otherwise
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Add a character BNode containing the character c to the end of the linked list. This routine does not require a search.
     * @param c a single character
     */
    public void addFieldAtEnd(String str, String opt, int num1, int num2, int mvt){
        DoubleNode n = new DoubleNode(tail, str, opt, num1, num1, mvt, null);
        if(isEmpty()){
            head = tail = n;
        }else{
            tail.setNext(n);
            tail = n;
        }
    }

    /**
     * Add a character BNode containing the character c to the front of the linked list. No search is required.
     * @param c a single character
     */
    public void addFieldAtFront(String str, String opt, int num1, int num2, int mvt){
        DoubleNode n = new DoubleNode(null, str, opt, num1, num1, mvt, head);
        if(isEmpty()){
            head = tail = n;
        }else{
            head.setPrev(n);
            head = n;
        }
    }

    /**
     * Remove and return the character at the front of the doubly linked list.
     * @return the character at the front precondition: the list is not empty
     */
    public String removeFieldFromFront(){
        String str = head.getField();
        if(!isEmpty()){
            if(head == tail){
                head = tail = null;
            }else{
                head = head.getNext();
                head.setPrev(null);
            }
        }
        return str;
    }

    /**
     * Remove and return the character at the end of the doubly linked list. No searching is required.
     * @return the character at the end precondition: the list is not empty
     */
    public String removeFieldAtEnd(){
        String str = tail.getField();

        if(!isEmpty()){
            if(head == tail){
                head = tail = null;
            }else{
                tail = tail.getPrev();
                tail.setNext(null);
            }
        }

        return str;
    }

    /**
     * Counts the number of BNodes in the list. We are not maintaining a counter so a search is required.
     * @return the number of BNodes in the doubly linked list between head and tail inclusive
     */
    public int countBNodes(){
        DoubleNode cn = head;
        int count = 0;
        while(cn != null){
            count++;
            cn = cn.getNext();
        }
        return count;
    }
    
    public void display() {  
        //Node current will point to head  
        DoubleNode cn = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(cn != null) {  
            int i = 0;
            //Prints each node by incrementing the pointer.  
            if (i == 0){
                Casilla1 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 1){
                Casilla2 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 2){
                Casilla3 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 3){
                Casilla4 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 4){
                Casilla5 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 5){
                Casilla6 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 6){
                Casilla7 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 7){
                Casilla8 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 8){
                Casilla9 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 9){
                Casilla10 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 10){
                Casilla11 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 11){
                Casilla12 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 12){
                Casilla13 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 13){
                Casilla14 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 14){
                Casilla15 = cn.getField();
                cn = cn.getNext();
                i++;
            }
            else if (i == 15){
                Casilla16 = cn.getField();
                cn = cn.getNext();
                i++;
            }
        }  
    }  
}
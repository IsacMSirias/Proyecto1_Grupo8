public class DoublyLinkedList {

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
            //Prints each node by incrementing the pointer.  
            System.out.print(cn.getField() + " ");  
            cn = cn.getNext();  
        }  
    }  
}
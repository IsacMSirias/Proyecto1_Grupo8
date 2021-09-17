public class DoubleNode {

    private DoubleNode prev;
    private DoubleNode next;
    private String field;

    /**
     * Constructor with no arguments.
     */
    public DoubleNode(){
        this( null, null, null );
    }

    /**
     * Constructor with a character
     * @param ch is a character for this BNode.
     */
    public DoubleNode(String str){
        this(null, str, null);
    }

    /**
     * Constructor with three arguments
     * @param p is a pointer to a previous BNode.
     * @param ch is a character for this BNode.
     * @param n is a pointer to a next BNode.
     */
    public DoubleNode(DoubleNode p, String str, DoubleNode n){
        prev = p;
        next = n;
        field = str;
    }

    /**
     * @return c a character for this BNode.
     */
    public String getField(){
        return field;
    }

    /**
     * @return a pointer to the next BNode or null if none exists
     */
    public DoubleNode getNext(){
        return next;
    }

    /**
     * @return a pointer to the previous BNode or null if none exists
     */
    public DoubleNode getPrev(){
        return prev;
    }

    /**
     * @param ch is assigned to this BNode
     */
    public void setField(String str){
        field = str;
    }

    /**
     * @param n
     */
    public void setNext(DoubleNode n){
        next = n;
    }

    /**
     * @param p
     */
    public void setPrev(DoubleNode p){
        prev = p;
    }
}
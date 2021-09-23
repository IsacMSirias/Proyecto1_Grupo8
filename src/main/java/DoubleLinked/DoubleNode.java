package DoubleLinked;

public class DoubleNode {

    private DoubleNode prev;
    private DoubleNode next;
    private String field;
    private String operation;
    private int movement;
    private int a;
    private int b;

    /**
     * Constructor with three arguments
     * @param p is a pointer to a previous BNode.
     * @param str is a string for this BNode.
     * @param n is a pointer to a next BNode.
     */
    public DoubleNode(DoubleNode p, String str, String opt, int num1, int num2, int mvt, DoubleNode n){
        prev = p;
        next = n;
        field = str;
        operation = opt;
        a = num1;
        b = num2;
        movement = mvt;

    }

    /**
     * @return a string for this BNode.
     */
    public String getField(){
        return field;
    }

    /**
     */
    public int getMovement(){
        return movement;
    }

    /**
     */
    public String getOperation(){
        return operation;
    }

    /**
     */
    public int getA(){
        return a;
    }

    /**
     * @param num is assigned to this BNode
     */
    public int getB(){
        return b;
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
     * @param str is assigned to this BNode
     */
    public void setField(String str){
        field = str;
    }

    /**
     * @param num is assigned to this BNode
     */
    public void setMovement(int num){
        movement = num;
    }

    /**
     * @param str is assigned to this BNode
     */
    public void setOperation(String str){
        operation = str;
    }

    /**
     * @param num is assigned to this BNode
     */
    public void setA(int num){
        a = num;
    }

    /**
     * @param num is assigned to this BNode
     */
    public void setB(int num){
        b = num;
    }

    /**
     * @param n a pointer to the next BNode
     */
    public void setNext(DoubleNode n){
        next = n;
    }

    /**
     * @param p a pointer to the previous BNode
     */
    public void setPrev(DoubleNode p){
        prev = p;
    }
}
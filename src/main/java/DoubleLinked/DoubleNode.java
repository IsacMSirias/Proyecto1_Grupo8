package DoubleLinked;

public class DoubleNode {

    DoubleNode prev;
    DoubleNode next;
    String field;
    String operation;
    int movement;
    int a;
    int b;

    /**
     * Constructor con siete argumentos.
     * @param p es un puntero al BNode previo
     * @param str Nombre del BNode
     * @param opt Operador
     * @param num1 A
     * @param num2 B
     * @param mvt Movimientos
     * @param n es un puntero al siguiente BNode
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

    public String getField(){
        return field;
    }

    public int getMovement(){
        return movement;
    }

    public String getOperation(){
        return operation;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    /**
     * @return el puntero al siguiente BNode o nulo si no existe
     */
    public DoubleNode getNext(){
        return next;
    }

    /**
     * @return el puntero al BNode previo o nulo si no existe
     */
    public DoubleNode getPrev(){
        return prev;
    }

    /**
     * @param str Nombre del BNode
     */
    public void setField(String str){
        field = str;
    }

    /**
     * @param num es asignado al BNode
     */
    public void setMovement(int num){
        movement = num;
    }

    /**
     * @param str es asignado al BNode
     */
    public void setOperation(String str){
        operation = str;
    }

    /**
     * @param num es asignado al BNode
     */
    public void setA(int num){
        a = num;
    }

    /**
     * @param num es asignado al BNode
     */
    public void setB(int num){
        b = num;
    }

    /**
     * @param n un puntero al siguiente BNode
     */
    public void setNext(DoubleNode n){
        next = n;
    }

    /**
     * @param p un puntero al BNode previo
     */
    public void setPrev(DoubleNode p){
        prev = p;
    }
}
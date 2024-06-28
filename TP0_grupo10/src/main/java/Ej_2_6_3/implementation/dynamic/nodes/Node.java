package Ej_2_6_3.implementation.dynamic.nodes;

public class Node {
    private int value;
    private Node next;
    private Node previous;

    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
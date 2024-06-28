package Ej_2_6_3.implementation.nodes;

public class Nodo {
    private int value;
    private Nodo next;
    private Nodo previous;

    public Nodo(int value, Nodo next, Nodo previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
}
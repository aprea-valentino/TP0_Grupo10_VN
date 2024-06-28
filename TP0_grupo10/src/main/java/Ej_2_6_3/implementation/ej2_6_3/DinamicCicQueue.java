package Ej_2_6_3.implementation.ej2_6_3;

import Ej_2_6_3.definition.Queue;
import Ej_2_6_3.implementation.dynamic.nodes.Node;

public class DinamicCicQueue implements Queue {
    private Node last;
    private int size;

    public DinamicCicQueue() {
        this.last = null;
        this.size = 0;
    }

    @Override
    public void enqueue(int element) {
        Node newNode = new Node(element, null, null);
        if (this.isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        } else {
            newNode.setNext(this.last.getNext());
            newNode.setPrevious(this.last);
            this.last.setNext(newNode);
            newNode.getNext().setPrevious(newNode);
        }
        this.last = newNode;
        this.size++;
    }

    @Override
    public int dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }

        Node frontNode = this.last.getNext();
        int element = frontNode.getValue();

        if (this.size == 1) {
            this.last = null;
        } else {
            this.last.setNext(frontNode.getNext());
            frontNode.getNext().setPrevious(this.last);
        }

        this.size--;
        return element;
    }

    @Override
    public int front() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }

        return this.last.getNext().getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.last == null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
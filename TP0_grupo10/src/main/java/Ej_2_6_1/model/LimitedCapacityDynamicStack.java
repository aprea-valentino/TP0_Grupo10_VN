package Ej_2_6_1.model;

import java.util.Objects;

public class LimitedCapacityDynamicStack implements Stack {

    private Node first;
    private int count;
    private final int capacity;

    public LimitedCapacityDynamicStack(int capacity) {
        this.first = null;
        this.count = 0;
        this.capacity = capacity;
    }

    @Override
    public void add(int a) {
        if (count >= capacity) {
            throw new RuntimeException("La capacidad de la pila ha sido alcanzada");
        }
        this.first = new Node(a, this.first);
        this.count++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía");
        }
        this.first = this.first.getNext();
        this.count--;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.count;
    }
}

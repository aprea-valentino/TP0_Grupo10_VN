package Ej_2_6_3.implementation.ej2_6_3;

import Ej_2_6_3.definition.Queue;
import Ej_2_6_3.implementation.nodes.Nodo;

public class DinamicCicQueue implements Queue {
    private Nodo ult; // Último nodo en la queue
    private int count;  // Tamaño de la cola

    public DinamicCicQueue() {
        this.ult = null;
        this.count = 0;
    }

    // Añade un elemento al final de la Queue

    @Override
    public void anadir(int element) {
        Nodo newNodo = new Nodo(element, null, null);
        if (this.vacio()) {
            newNodo.setNext(newNodo);
            newNodo.setPrevious(newNodo);
        } else {
            newNodo.setNext(this.ult.getNext());
            newNodo.setPrevious(this.ult);
            this.ult.setNext(newNodo);
            newNodo.getNext().setPrevious(newNodo);
        }
        this.ult = newNodo;
        this.count++;
    }

    // Elimina y devuelve el elemento al frente de la Queue
    @Override
    public int eliminar() {
        if (this.vacio()) {
            throw new RuntimeException("La cola está vacía");
        }

        Nodo nodoFront = this.ult.getNext();
        int element = nodoFront.getValue();

        if (this.count == 1) {
            this.ult = null;
        } else {
            this.ult.setNext(nodoFront.getNext());
            nodoFront.getNext().setPrevious(this.ult);
        }

        this.count--;
        return element;
    }

    // Devuelve el elemento al frente de la Queue
    @Override
    public int front() {
        if (this.vacio()) {
            throw new RuntimeException("La cola está vacía");
        }

        return this.ult.getNext().getValue();
    }

    // Verifica si la cola está vacía
    @Override
    public boolean vacio() {
        return this.ult == null;
    }

    // Devuelve el tamaño de la cola
    @Override
    public int size() {
        return this.count;
    }
}


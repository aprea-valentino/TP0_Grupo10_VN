package Ej_2_6_3;

import Ej_2_6_3.definition.Queue;
import Ej_2_6_3.implementation.ej2_6_3.DinamicCicQueue;

public class Main {
    public static void main(String[] args) {
        Queue cola = new DinamicCicQueue();

        cola.enqueue(2);
        cola.enqueue(3);

        System.out.println(cola.front());
        cola.dequeue();
        System.out.println(cola.front());


    }
}

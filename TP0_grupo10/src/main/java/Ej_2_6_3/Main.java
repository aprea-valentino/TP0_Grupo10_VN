package Ej_2_6_3;

import Ej_2_6_3.definition.Queue;
import Ej_2_6_3.implementation.ej2_6_3.DinamicCicQueue;

public class Main {
    public static void main(String[] args) {
        Queue cola = new DinamicCicQueue();

        cola.anadir(2);
        cola.anadir(3);

        System.out.println(cola.front());
        cola.eliminar();
        System.out.println(cola.front());


    }
}

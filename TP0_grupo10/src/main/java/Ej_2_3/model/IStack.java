package Ej_2_3.model;

public interface IStack<E> {


    void add(E item);

    void remove();

    boolean isEmpty();

    E getTop();
}

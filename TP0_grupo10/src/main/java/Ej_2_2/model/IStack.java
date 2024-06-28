package Ej_2_2.model;

public interface IStack<E> {


    void add(E item);

    void remove();

    boolean isEmpty();

    E getTop();
    
}

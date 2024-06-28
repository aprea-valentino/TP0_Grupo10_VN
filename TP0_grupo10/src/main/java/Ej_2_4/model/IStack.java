package Ej_2_4.model;

public interface IStack<E> {


    void add(E item);

    void remove();

    boolean isEmpty();

    E getTop();
    
}

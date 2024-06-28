package Ej_2_2.model;

public interface IQueve<E> {

    void add(E item);

    void remove();

    boolean isEmpty();

    E getFirts();
}

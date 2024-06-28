package Ej_2_4.model;

public interface IQueve<E> {
    void add(E item);

    void remove();

    boolean isEmpty();

    E getFirts();
}

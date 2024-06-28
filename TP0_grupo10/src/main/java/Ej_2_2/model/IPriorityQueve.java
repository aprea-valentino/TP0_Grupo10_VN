package Ej_2_2.model;

public interface IPriorityQueve<E> {

    void add(E e, int priority);

    void remove();

    boolean isEmpty();

    E getFirts();

    int getPriority();

}

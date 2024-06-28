package Ej_2_4.model;

public interface ISet<E> {
    E choose();
    void add(E a);
    void remove(E a);
    boolean isEmpty();

}

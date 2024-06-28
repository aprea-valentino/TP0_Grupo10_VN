package Ej_2_2.model;

public interface ISet<E> {
    E choose();
    void add(E a);
    void remove(E a);
    boolean isEmpty();

}

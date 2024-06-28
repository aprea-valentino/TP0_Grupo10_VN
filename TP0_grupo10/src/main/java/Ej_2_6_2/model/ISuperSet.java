package Ej_2_6_2.model;

public interface ISuperSet {
    void add(int a);

    void remove(int a);
    boolean isEmpty();
    int choose();

    boolean esSubconjunto(Set conjunto);

    Set Complemento(Set conjunto);
}

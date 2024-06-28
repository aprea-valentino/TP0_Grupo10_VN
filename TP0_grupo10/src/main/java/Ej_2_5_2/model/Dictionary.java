package Ej_2_5_2.model;

public interface Dictionary {

    void add(int key, int value);

    void remove(int key, int value);

    Set getKeys();

    int get(int key);

}
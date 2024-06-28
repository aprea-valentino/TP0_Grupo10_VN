package Ej_2_6_3.definition;

public interface Queue {
    void enqueue(int element);
    int dequeue();
    int front();
    boolean isEmpty();
    int size();
}
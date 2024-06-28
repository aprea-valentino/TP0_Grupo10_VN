package Ej_2_5_1.model;

public class StackGenerico<E> implements IStack<E> {


    private final Object[] elementos;
    private int count;
    private int MAX = 10000;

    public StackGenerico() {
        this.elementos = new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(E item) {
        if(this.count == MAX){
            throw new RuntimeException("Muchos elementos");
        }

        this.elementos[count] = item;

        this.count++;
    }

    @Override
    public void remove() {
        if(count == 0) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public E getTop() {
        if(count == 0) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }

        return (E) this.elementos[count - 1];
    }
}

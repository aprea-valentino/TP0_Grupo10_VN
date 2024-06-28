package Ej_2_2.model;

public class QueveGenerico<E> implements IQueve<E>{


    private Object[] elementos;
    private int count;
    private int MAX = 10000;

    public QueveGenerico(){
        elementos = new Object[MAX];
        count = 0;

    }

    public void add(E item) {
        if(this.count == MAX){
            throw new RuntimeException("Muchos elementos");
        }
        elementos[count] = item;
        count++;
    }

    @Override
    public void remove() {
        if(count == 0) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }else{
            for(int i = 0; i < this.elementos.length - 1; i++) {
                this.elementos[i] = this.elementos[i+1];
            }
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public E getFirts() {
        return (E) this.elementos[0];
    }
}

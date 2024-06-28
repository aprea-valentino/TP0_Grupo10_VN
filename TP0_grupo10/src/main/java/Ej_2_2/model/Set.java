package Ej_2_2.model;
import java.util.Random;

public class Set<E> implements ISet<E> {

    private Object[] elementos;
    private int count;
    private int MAX = 10000;

    public Set() {
        elementos = new Object[MAX];
        count = 0;
    }


    @Override
    public E choose() {
        if (this.count == 0) {
            return null;
        }
        int randomIndex = new Random().nextInt(this.count);
        return (E) elementos[randomIndex];
    }

    @Override
    public void add(E a) {
        if(this.count == MAX) { // C
            return;
        }
        for (int i = 0; i < count; i++) {
            if(elementos[i] == a) {
                return;
            }
        }
        this.elementos[count] = a;
        this.count++;
    }

    @Override
    public void remove(E a) {
        for (int i = 0; i < count; i++) {
            if(elementos[i] == a) {
                if(i == count - 1) {
                    this.count--;
                    return;
                }
                this.elementos[i] = elementos[this.count-1];
                this.count--;
            }

        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}

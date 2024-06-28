package Ej_2_6_4.model;

import java.util.Random;

public class StaticSet implements Set {
    
    private static final int MAX = 10000;
    
    public int[] array;
    public int[] cant;
    public int count;
    
    public StaticSet() {
        this.array = new int[MAX];
        this.cant = new int[MAX];
        this.count = 0;
    }
    
    @Override
    public void add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for(int i = 0; i < count; i++) {
            if(this.array[i] == a) {
                this.cant[i] += 1;
                return;
            }
        }
        this.array[count] = a;
        this.cant[count] = 1;
        this.count++;
    }

    @Override
    public void remove(int a) {
        for(int i = 0; i < count; i++) {
            if(this.array[i] == a) {

                this.array[i] = this.array[count - 1];
                this.cant[i] = this.cant[count - 1];
                count--;
                return;
            }
        }

    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if(this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        return this.array[new Random().nextInt(this.count)];
    }

    public int getCant(int x){
        if(this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        for(int i = 0; i < count; i++) {
            if(this.array[i] == x) {
                return this.cant[i];
            }
        }
        throw new RuntimeException("No se puede elegir un valor que no existe");

    }
}

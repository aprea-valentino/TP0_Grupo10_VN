package Ej_2_2.model;

public class PriorityQueveGenerico<E> implements IPriorityQueve<E>{

    private Object[] values;
    private int[] priorities;
    private int count;
    private int max = 10000;

    public PriorityQueveGenerico() {
        values = new Object[max];
        priorities = new int[max];
        count = 0;
    }

    @Override
    public void add(E item, int priority) {
        if(this.isEmpty() || this.priorities[count-1] <= priority){
            this.values[count] = item;
            this.priorities[count] = priority;
            count++;
            return;
        }

        if(this.priorities[0] > priority){
            for(int i = count-1; i >= 0; i--){
                this.values[i+1] = this.values[i];
                this.priorities[i+1] = priority;
            }
            this.values[0] = item;
            this.priorities[0] = priority;
            count++;
            return;
        }

        int index = -1;
        for(int i = 0; i < count; i++){
            if (this.priorities[i] > priority){
                index = i;
                break;
            }

        }
        for(int i = count-1; i >= index; i--){
            this.values[i+1] = this.values[i];
            this.priorities[i+1] = priority;
        }
        this.values[index] = item;
        this.priorities[index] = priority;
        count++;
    }

    @Override
    public void remove() {
        if(count == 0) {
            throw new RuntimeException("No se puede remover un elemento de una cola vacia");
        }else{
            for(int i = 0; i < this.values.length - 1; i++) {
                this.values[i] = this.values[i+1];
                this.priorities[i] = this.priorities[i+1];
            }
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public E getFirts() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento");
        }else{
            return (E) this.values[0];
        }
    }

    @Override
    public int getPriority() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede tener la prioridad del primer elemento");
        }else{
            return this.priorities[0];
        }
    }
}


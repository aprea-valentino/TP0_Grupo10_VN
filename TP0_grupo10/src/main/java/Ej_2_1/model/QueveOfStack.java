package Ej_2_1.model;

public class QueveOfStack implements IQueveOfStacks{


    private IStack[] queve;
    private int count;
    private int  MAX = 10000;


    public QueveOfStack(){
        this.queve = new IStack[MAX];
        this.count = 0;
    }

    @Override
    public void add(IStack stack) {
        if(count == MAX) {
            throw new RuntimeException("Muchos elementos");
        }
        this.queve[count] = stack;
        this.count++;
    }

    @Override
    public void remove() {
        if(count == 0) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }else{
            for(int i = 0; i < this.queve.length - 1; i++) {
                this.queve[i] = this.queve[i+1];
            }
        }
        this.count--;
    }

    @Override
    public IStack getFirtsCol() {
        return this.queve[0];
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


}

package Ej_2_3.util;
import Ej_2_3.model.*;

public class Utils {
    public static void print(IQoQ QoQ){

        IQoQ colacola = copyQOQ(QoQ);
        while(!colacola.isEmpty()){
            System.out.print("[");
            while(!colacola.getFirts().isEmpty()){
                System.out.print(colacola.getFirts().getFirts()+",");
                colacola.getFirts().remove();
            }
            System.out.print("]");
            colacola.remove();
        }
        System.out.println();



    }
    public static IQoQ copyQOQ(IQoQ queve){
        IQoQ aux = new QueueOfQueue();
        IQoQ copy = new QueueOfQueue();

        while(!queve.isEmpty()){
            aux.add(copyQ(queve.getFirts()));
            copy.add(copyQ(queve.getFirts()));
            queve.remove();
        }
        while(!aux.isEmpty()){
            queve.add(aux.getFirts());
            aux.remove();
        }
        return copy;
    }


    public static IQueve copyQ(IQueve queve){
        IQueve<Object> aux = new QueveGenerico<>();
        IQueve<Object> copy = new QueveGenerico<>();

        while(!queve.isEmpty()){
            aux.add(queve.getFirts());
            copy.add(queve.getFirts());
            queve.remove();
        }
        while(!aux.isEmpty()){
            queve.add(aux.getFirts());
            aux.remove();
        }
        return copy;
    }

    public static int getSizeQueve(IQueve queve){
        IQueve<Object> aux = copyQ(queve);
        int size = 0;
        while (!aux.isEmpty()) {
            aux.remove();
            size++;

        }
        return size;
    }

    public static IQueve eveuq(IQueve queve) {
        IStack<Object> aux = new Stack<>();
        while (!queve.isEmpty()) {
            aux.add(queve.getFirts());
            queve.remove();
        }
        while (!aux.isEmpty()) {
            queve.add(aux.getTop());
            aux.remove();
        }
        return queve;
    }



}

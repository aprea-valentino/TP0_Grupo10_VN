package Ej_2_3;


import Ej_2_3.model.IQoQ;
import Ej_2_3.model.IQueve;
import Ej_2_3.model.QueueOfQueue;
import Ej_2_3.model.QueveGenerico;
import Ej_2_3.util.Utils;

public class Main {
    public static void main(String[] args) {
        IQueve<Object> queve = new QueveGenerico<>();
        queve.add(1);
        queve.add(2);
        queve.add(3);
        IQoQ colacola = new QueueOfQueue();
        colacola.add(queve);
        IQueve<Object> queve1 = new QueveGenerico<>();
        queve1.add(4);
        queve1.add(5);
        queve1.add(6);
        IQoQ colacola1 = new QueueOfQueue();
        colacola1.add(queve1);
        colacola1.add(queve);
        colacola.concatenate(colacola1);
        Utils.print(colacola);
        colacola.reverseWithDepth();
        Utils.print(colacola);

    }
}

package Ej_2_4;

import Ej_2_4.model.IQueve;
import Ej_2_4.model.QueveGenerico;
import Ej_2_4.model.Set;
import Ej_2_4.model.StackGenerico;
import Ej_2_4.model.IStack;
import Ej_2_4.model.ISet;

public class Main {
    //Autor: Adriel Bergantino
    public static void main(String[] args) {
        Set.SetBuilder<Integer> setBuilder = new Set.SetBuilder<>();
        ISet<Integer> set = setBuilder.add(1).add(2).add(3).build();
        while (!set.isEmpty()){
            Object aux = set.choose();
            System.out.print(aux + " ");
            set.remove((Integer) aux);
        }

        System.out.println("");

        ISet<Integer> otherSet = new Set<>();
        otherSet.add(4);
        otherSet.add(5);
        setBuilder = new Set.SetBuilder<>();
        set = setBuilder.addAll(otherSet).add(6).build();
        while (!set.isEmpty()){
            Object aux = set.choose();
            System.out.print(aux+ " ");
            set.remove((Integer) aux);
        }

        System.out.println(" ");

        StackGenerico.StackBuilder<Integer> stackBuilder = new StackGenerico.StackBuilder<>();
        IStack<Integer> stack = stackBuilder.add(1).add(2).add(3).build();
        while(!stack.isEmpty()){
            System.out.print(stack.getTop() + " ");
            stack.remove();
        }

        System.out.println("");

        IQueve<Integer> cola = new QueveGenerico<>(3,4);
        cola.add(1);
        cola.add(2);
        while(!cola.isEmpty()){
            System.out.print(cola.getFirts()+" ");
            cola.remove();
        }
    }
}

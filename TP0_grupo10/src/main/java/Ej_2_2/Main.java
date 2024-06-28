package Ej_2_2;

import Ej_2_2.model.*;


public class Main {
    public static void main(String[] args) {
        IStack<Object> stackGen = new StackGenerico<>();
        stackGen.add("inicio");
        stackGen.add(10);
        stackGen.add("a");
        stackGen.add("b");
        stackGen.add(210);
        stackGen.add("fin");
        System.out.println(stackGen.getTop());

        stackGen = invertir(stackGen);
        System.out.println(stackGen.getTop());

    }
    // invertir stack generico ej 2_2_1 Autor: Valentino Aprea
    public static IStack<Object> invertir(IStack<Object> stack){
        IStack<Object> aux = new StackGenerico<>();
        while(!stack.isEmpty()){
            aux.add(stack.getTop());
            stack.remove();
        }

        return aux;
    }
    // Ejercicio 2_2_2 Autor: Adriel Bergantino
    public static ISet<Object> copySet(ISet<Object> set){
        ISet<Object> aux = new Set<>();
        ISet<Object> aux2 = new Set<>();


        while(!set.isEmpty()) {
            Object n = set.choose();
            aux.add(n);
            aux2.add(n);
            set.remove(n);
        }

        while(!aux.isEmpty()) {
            Object n = aux.choose();
            set.add(n);
            aux.remove(n);
        }

        return aux2;
    }

}


package Ej_2_1;

import Ej_2_1.model.IQueveOfStacks;
import Ej_2_1.model.IStack;
import Ej_2_1.model.QueveOfStack;
import Ej_2_1.model.Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Ingrese numero de filas de la matriz: ");
        int n = Integer.parseInt(myObj.nextLine());
        IQueveOfStacks queveOfStacks = genQOS(n);
        printQOS(queveOfStacks);

        System.out.println(calcularTraza(queveOfStacks));


        queveOfStacks = traspuesta(queveOfStacks);
        System.out.println("La traspuesta de la matriz es: " );
        printQOS(queveOfStacks);



    }

    public static long gen_random(int max, int min){
        double random = (Math.random() * (max-min) + min);
        long n = (long) Math.floor(random);
        return n;
    }

    public static IQueveOfStacks genQOS(int n){
        IQueveOfStacks queveOfStacks = new QueveOfStack();
        for (int i = 0; i < n; i++) {
            IStack stack = new Stack();
            for (int j = 0; j < n; j++) {
                int x = (int) gen_random(10, 1);
                stack.add(x);
            }

            queveOfStacks.add(stack);
        }
        return queveOfStacks;
    }


    /**
     *
     *  Funcion para mostrar una QueveOfStacks
     *  Lo que dice columna se leeria {a
     *                                 b
     *                                 c
     *                                 etc}
     *
     */
    public static void printQOS(IQueveOfStacks queveOfStacks){
        IQueveOfStacks copy = copyQOS(queveOfStacks);
        while(!copy.isEmpty()){
            IStack aux = copy.getFirtsCol();
            System.out.print("Columna = ");
            while(!aux.isEmpty()){
                System.out.print(aux.getTop()+" ");
                aux.remove();
            }
            System.out.println(" ");
            copy.remove();
        }

    }
    /**
     *
     *  Funcion para copiar una QueveOfStacks
     */
    public static IQueveOfStacks copyQOS(IQueveOfStacks queveOfStacks){
        IQueveOfStacks aux = new QueveOfStack();
        IQueveOfStacks copy = new QueveOfStack();

        while(!queveOfStacks.isEmpty()){
            aux.add(copyStack(queveOfStacks.getFirtsCol()));
            copy.add(copyStack(queveOfStacks.getFirtsCol()));
            queveOfStacks.remove();
        }
        while(!aux.isEmpty()){
            queveOfStacks.add(aux.getFirtsCol());
            aux.remove();
        }
        return copy;
    }

    public static IStack copyStack(IStack stack) {
        IStack stack1 = new Stack();
        IStack stack2 = new Stack();

        while (!stack.isEmpty()) {
            stack1.add(stack.getTop());
            stack2.add(stack.getTop());
            stack.remove();
        }

        while (!stack1.isEmpty()) {
            stack.add(stack1.getTop());
            stack1.remove();
        }

        while (!stack2.isEmpty()) {
            stack1.add(stack2.getTop());
            stack2.remove();
        }
        return stack1;
    }

    public static int getSizeQOS(IQueveOfStacks queveOfStacks){
        int size = 0;
        IQueveOfStacks aux = copyQOS(queveOfStacks);
        while (!aux.isEmpty()){
            aux.remove();
            size++;
        }
        return size;
    }

    /**
     *
     *  Funcion para invertir una QueveOfStack
     */
    public static IQueveOfStacks stackofqueve(IQueveOfStacks queve){
        IQueveOfStacks queve1 = new QueveOfStack();
        IQueveOfStacks queve2 = new QueveOfStack();

        while(getSizeQOS(queve) != 1){
            queve1.add(queve.getFirtsCol());
            queve.remove();
        }
        while(getSizeQOS(queve1) != 0){
            if (getSizeQOS(queve1) == 1){
                queve.add(queve1.getFirtsCol());
                queve1 = copyQOS(queve2);
                queve2 = new QueveOfStack();
            }else {
                queve2.add(queve1.getFirtsCol());
                queve1.remove();
            }
        }
        return queve;
    }

    public static IStack kcatS(IStack stack1){
        IStack res = new Stack();
        while (!stack1.isEmpty()){
            res.add(stack1.getTop());
            stack1.remove();
        }
        return res;
    }



    // Ejercicio 2_1_1 Autor: Adriel Bergantino
    public static int calcularTraza(IQueveOfStacks queveOfStacks) {
        int traza = 0;
        int index = 0;

        IQueveOfStacks aux = copyQOS(queveOfStacks);

        while (!aux.isEmpty()) {
            IStack col = aux.getFirtsCol();
            for(int i = 0; i < index; i++){
                col.remove();
            }
            traza += col.getTop();
            index++;
            aux.remove();
        }

        return traza;
    }
    // Ejercicio 2_1_2 Autor: Aprea Valentino
    public static IQueveOfStacks traspuesta(IQueveOfStacks queveOfStacks){
        int size = getSizeQOS(queveOfStacks);
        IQueveOfStacks res = new QueveOfStack();
        queveOfStacks = stackofqueve(queveOfStacks);
        IQueveOfStacks aux = copyQOS(queveOfStacks);

        int n = 0;
        while(n != size){
            IQueveOfStacks aux2 = new QueveOfStack();
            while (!aux.isEmpty()){
                IStack stack1 = new Stack();
                IStack stack2 = new Stack();
                for (int i = 0; i< size; i++){
                    int x = aux.getFirtsCol().getTop();

                    stack1.add(x);
                    stack2 = aux.getFirtsCol();
                    stack2.remove();
                    aux2.add(stack2);
                    aux.remove();
                }
                res.add(stack1);
            }
            aux = copyQOS(aux2);
            n++;
        }
        return res;
    }
     // Ejercicio 2_1_3 Autor: Mauricio Antolin
    public static IQueveOfStacks sumaMatricial(IQueveOfStacks qos1, IQueveOfStacks qos2){
        IQueveOfStacks res = new QueveOfStack();
        IQueveOfStacks copy1 = copyQOS(qos1);
        IQueveOfStacks copy2 = copyQOS(qos2);

        while(!copy1.isEmpty() && !copy2.isEmpty()){
            IStack stack3 = new Stack();
            IStack stack1 = copy1.getFirtsCol();
            IStack stack2 = copy2.getFirtsCol();

            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int n = stack1.getTop() + stack2.getTop();
                stack3.add(n);

                stack1.remove();
                stack2.remove();
            }

            stack3 = kcatS(stack3);
            res.add(stack3);
            copy1.remove();
            copy2.remove();
        }

        return res;
    }
}


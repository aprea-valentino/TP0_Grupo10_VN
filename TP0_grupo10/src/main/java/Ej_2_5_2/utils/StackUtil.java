package Ej_2_5_2.utils;

import Ej_2_5_2.model.IStack;
import Ej_2_5_2.model.StackGenerico;

public class StackUtil {

    public static IStack<Object> copy(IStack<Object> stack) {
        IStack<Object> stack1 = new StackGenerico<>();
        IStack<Object> stack2 = new StackGenerico<>();

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

    public static void print(IStack<Object> stack) {
        IStack<Object> copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.print(copy.getTop()  + ", ");
            copy.remove();
        }
        System.out.println("");
    }

    public static IStack<Object> stackOrd_NoRepe(IStack<Object> stack) {
        IStack<Object> stack2 = new StackGenerico<>();
        // no repetidos
        while (!stack.isEmpty()) {
            int aux = (int) stack.getTop();
            if(stack2.isEmpty()){
                stack2.add(aux);

            }else{
                IStack<Object> stackaux = new StackGenerico<>();
                while(!stack2.isEmpty()){
                    int b = (int) stack2.getTop();
                    if(aux != b){
                        stackaux.add(b);
                    }
                    stack2.remove();
                }
                stackaux.add(aux);
                while(!stackaux.isEmpty()){
                    stack2.add(stackaux.getTop());
                    stackaux.remove();
                }
            }
            stack.remove();
        }
        //ordeno
        IStack<Object> aux = new StackGenerico<>();
        while(!stack2.isEmpty()){
            int b = (int) stack2.getTop();
            stack2.remove();
            while(!aux.isEmpty() && b > (int) aux.getTop()){
                int a = (int) aux.getTop();
                aux.remove();
                stack2.add(a);
            }
            aux.add(b);
        }


        return aux;
    }

}

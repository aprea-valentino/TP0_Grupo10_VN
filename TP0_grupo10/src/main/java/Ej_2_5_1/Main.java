package Ej_2_5_1;


import Ej_2_5_1.model.IStack;
import Ej_2_5_1.model.StackGenerico;
import Ej_2_5_1.utils.StackUtil;

import java.util.Random;


//Autor: Valentino Apera
public class Main {
    public static void main(String[] args) {

        IStack<Object> stack = new StackGenerico<>();
        for (int i = 0; i < 20; i++) {
            int a = new Random().nextInt(10);
            stack.add(a);
        }
        StackUtil.print(stack);

        IStack<Object> stackOrdNoRep = StackUtil.stackOrd_NoRepe(stack);
        StackUtil.print(stackOrdNoRep);
    }
}

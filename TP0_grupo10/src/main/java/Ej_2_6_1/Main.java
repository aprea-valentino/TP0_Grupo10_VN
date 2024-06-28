package Ej_2_6_1;

import Ej_2_6_1.model.LimitedCapacityDynamicStack;
import Ej_2_6_1.model.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new LimitedCapacityDynamicStack(2);
        stack.add(1);
        stack.add(2);
        stack.add(3);
    }
}

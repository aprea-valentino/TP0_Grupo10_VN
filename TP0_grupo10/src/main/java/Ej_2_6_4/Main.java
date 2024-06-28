package Ej_2_6_4;

import Ej_2_6_4.model.Set;
import Ej_2_6_4.model.StaticSet;

public class Main {
    //Autor: Valentino Aprea
    public static void main(String[] args) {
        Set set = new StaticSet();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);

        System.out.println(set.getCant(1));
        System.out.println(set.getCant(2));

    }
}

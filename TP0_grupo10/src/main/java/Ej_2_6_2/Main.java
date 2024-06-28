package Ej_2_6_2;

import Ej_2_6_2.model.ISuperSet;
import Ej_2_6_2.model.Set;
import Ej_2_6_2.model.StaticSet;
import Ej_2_6_2.model.SuperSet;

public class Main {
    public static void main(String[] args) {
        ISuperSet superSet = new SuperSet();
        for (int i = 1; i <= 10; i++) {
            superSet.add(i);
        }
        Set set = new StaticSet();
        set.add(5);
        set.add(6);
        set.add(7);
        System.out.println(superSet.esSubconjunto(set));

        Set Complemento = superSet.Complemento(set);
        while(!Complemento.isEmpty()) {
            int aux = Complemento.choose();
            System.out.println(aux);
            Complemento.remove(aux);
        }


    }
}

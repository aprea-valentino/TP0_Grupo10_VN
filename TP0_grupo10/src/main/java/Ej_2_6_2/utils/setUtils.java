package Ej_2_6_2.utils;

import Ej_2_6_2.model.Set;
import Ej_2_6_2.model.StaticSet;
public class setUtils {
    public static Set copy(Set set) { // O(n^2)
        Set aux = new StaticSet(); // C
        Set aux2 = new StaticSet(); // C

        // O(N)
        while(!set.isEmpty()) { // C
            int n = set.choose(); // N
            aux.add(n); // N
            aux2.add(n); // N
            set.remove(n); // N
        }

        while(!aux.isEmpty()) {
            int n = aux.choose();
            set.add(n);
            aux.remove(n);
        }

        return aux2;
    }
    public static boolean in(int a, Set set) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int n = copy.choose();
            if(n == a) {
                return true;
            }
            copy.remove(n);
        }
        return false;
    }
}

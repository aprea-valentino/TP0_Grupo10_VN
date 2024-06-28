package Ej_2_7_1;

import Ej_2_7_1.model.PriorityQueue;
import Ej_2_7_1.model.StaticPriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue cola = new StaticPriorityQueue();

        cola.add(1,1);
        cola.add(1,2);
        cola.add(2,3);
        cola.add(1,3);
        cola = cambiarPrioridad(cola,2,1);
        while(!cola.isEmpty()) {
            System.out.println(cola.getFirst()+ " , " + cola.getPriority());
            cola.remove();

        }
        System.out.println("");
        PriorityQueue cola2 = new StaticPriorityQueue();

        cola2.add(1,1);
        cola2.add(1,2);
        cola2.add(2,3);
        cola2.add(1,3);
        cola2 = cambiarPrioridad(cola2,2,3);
        while(!cola2.isEmpty()) {
            System.out.println(cola2.getFirst()+ " , " + cola2.getPriority());
            cola2.remove();
        }
    }

    public static PriorityQueue cambiarPrioridad(PriorityQueue cola, int prioridadvieja, int nuevaprioridad){
        PriorityQueue resultado = new StaticPriorityQueue();
        if(prioridadvieja < nuevaprioridad){
            while(!cola.isEmpty()){
                int k = cola.getPriority();
                if (k<prioridadvieja){
                    resultado.add(cola.getFirst(),k);
                }else if(k == prioridadvieja){
                    resultado.add(cola.getFirst(), nuevaprioridad);
                }else{
                    resultado.add(cola.getFirst(), k+(nuevaprioridad - prioridadvieja));
                }
                cola.remove();
            }
            return resultado;
        }else if(prioridadvieja > nuevaprioridad){
            while(!cola.isEmpty()){
                int k = cola.getPriority();
                if(k>prioridadvieja){
                    resultado.add(cola.getFirst(),k);
                }else if(k==prioridadvieja){
                    resultado.add(cola.getFirst(), nuevaprioridad);
                }else{
                    resultado.add(cola.getFirst(), k-(prioridadvieja - nuevaprioridad));
                }
                cola.remove();
            }
            return resultado;
        }else{
            return cola;
        }

    }
}

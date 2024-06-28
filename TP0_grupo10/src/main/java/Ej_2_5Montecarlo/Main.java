package Ej_2_5Montecarlo;

import Ej_2_5Montecarlo.model.Coordenada;
import Ej_2_5Montecarlo.model.Montecarlo;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Montecarlo montecarlo = new Montecarlo();
        Random random = new Random();
        // generamos 1000 coordenadas dentro de la region (0,0) (1,1)
        int cantidadCoordenadas = 1000;
        while (montecarlo.getCoordenadas().size() < cantidadCoordenadas) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            Coordenada coord = new Coordenada(x, y);
            montecarlo.agregarCoordenada(coord);
        }
        double piAprox = montecarlo.aproximarPi();
        System.out.println("π Aproximado" + piAprox);

    }
}

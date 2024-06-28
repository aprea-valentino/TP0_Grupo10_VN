package Ej_2_5Montecarlo.model;

import java.util.ArrayList;
import java.util.List;

public class Montecarlo {
    private List<Coordenada> coordenadas;

    public Montecarlo() {
        this.coordenadas = new ArrayList<>();
    }

    public void agregarCoordenada(Coordenada coord) {
        // Verificar que la coordenada está dentro del cuadrado unitario
        if (coord.getX() >= 0 && coord.getX() <= 1 && coord.getY() >= 0 && coord.getY() <= 1) {
            coordenadas.add(coord);
        }
    }
    public List<Coordenada> getCoordenadas() {
        return coordenadas;
    }
    public double aproximarPi() {
        int dentroDelCirculo = 0;
        for (Coordenada coord : coordenadas) {
            double x = coord.getX();
            double y = coord.getY();
            // Verificar si la coordenada está dentro del círculo de radio 1
            if (x * x + y * y <= 1) {
                dentroDelCirculo++;
            }
        }
        // Usar la proporción de puntos dentro del círculo para aproximar π
        return 4.0 * dentroDelCirculo / coordenadas.size();
    }

}

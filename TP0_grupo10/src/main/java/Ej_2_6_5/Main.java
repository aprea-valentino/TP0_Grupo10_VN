package Ej_2_6_5;

import Ej_2_6_5.model.RandomDictionary;

public class Main {
    //Autor: Mauricio Antolin
    public static void main(String[] args) {
        RandomDictionary randomDict = new RandomDictionary();

        randomDict.add(1, 100);
        randomDict.add(1, 200);
        randomDict.add(1, 300);
        randomDict.add(2, 400);
        randomDict.add(2, 500);

        System.out.println(randomDict.getRandomValue(1));
        System.out.println(randomDict.getRandomValue(2));

        System.out.println(randomDict.get(1));
        System.out.println(randomDict.get(2));
    }
}

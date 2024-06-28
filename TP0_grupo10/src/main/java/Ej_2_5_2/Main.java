package Ej_2_5_2;


import static Ej_2_5_2.utils.DictUtil.desencriptar;
import static Ej_2_5_2.utils.DictUtil.encriptar;

//Autor: Mauricio Antolin
public class Main {
    public static void main(String[] args) {
        String original = "Cree un diccionario que tenga como clave cada letra del alfabeto español, y como valor cada frecuencia asociada. Cree una String en español de mas de 500 caracteres, y que tenga aplicado un cifrado César. Desarrolle un algoritmo que desencripte la String en base a la frecuencia de sus caracteres";

        // Aplicar cifrado César con un desplazamiento de 3
        String encrypted = encriptar(original, 3);
        System.out.println("Cadena cifrada: " + encrypted);

        // Desencriptar la cadena usando análisis de frecuencias
        String decrypted = desencriptar(encrypted);
        System.out.println("Cadena desencriptada: " + decrypted);
    }
}

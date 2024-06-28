package Ej_2_5_2.utils;

import Ej_2_5_2.model.Dictionary;
import Ej_2_5_2.model.StaticDictionary;

public class DictUtil {

    private static final String alfabeto = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        // Cadena original con más de 500 caracteres
        String original = "Esta es una cadena de texto en español que tiene más de 500 caracteres. Debemos asegurarnos de que sea lo suficientemente larga para cumplir con los requisitos del problema. Vamos a agregar más texto para asegurarnos de que tenemos suficiente contenido. Este es un texto adicional para cumplir con la longitud requerida. Ahora agregamos más contenido para asegurarnos que superamos los 500 caracteres. Este texto es para probar el cifrado y descifrado de la cadena utilizando el análisis de frecuencia de caracteres.";

        // Aplicar cifrado César con un desplazamiento de 3
        String encriptado = encriptar(original, 3);
        System.out.println("Cadena cifrada: " + encriptado);

        // Desencriptar la cadena usando análisis de frecuencias
        String decrypted = desencriptar(encriptado);
        System.out.println("Cadena desencriptada: " + decrypted);
    }

    // Función para cifrar una cadena usando el cifrado César
    public static String encriptar(String text, int shift) {
        StringBuilder result = new StringBuilder(); // Crea un StringBuilder para construir la cadena cifrada
        for (char c : text.toLowerCase().toCharArray()) { // Conviertre el texto a minúsculas y recorrer cada carácter
            if (alfabeto.indexOf(c) != -1) { // Verifica la posición original del carácter en el alfabeto
                int originalPosition = alfabeto.indexOf(c);
                int newPosition = (originalPosition + shift) % alfabeto.length(); // Calcula la nueva posición aplicando el desplazamiento
                result.append(alfabeto.charAt(newPosition)); // Agrega el carácter cifrado al resultado
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Función para desencriptar una cadena usando análisis de frecuencias
    public static String desencriptar(String text) {
        Dictionary dictFrecuen = new StaticDictionary();
        for (char c : alfabeto.toCharArray()) {
            dictFrecuen.add(c, 0);
        }

        // Contar las frecuencias de cada letra en el texto cifrado
        for (char c : text.toLowerCase().toCharArray()) {
            if (alfabeto.indexOf(c) != -1) {
                int cant = dictFrecuen.get(c);
                dictFrecuen.add(c, cant + 1);
            }
        }

        // Encontrar la letra más frecuente en el texto cifrado
        char frecChar = ' ';
        int maxFrec = 0;
        for (char c : alfabeto.toCharArray()) {
            int frequency = dictFrecuen.get(c);
            if (frequency > maxFrec) {
                frecChar = c;
                maxFrec = frequency;
            }
        }

        // Suponemos que la letra más frecuente en español es 'e'
        int shift = (alfabeto.indexOf(frecChar) - alfabeto.indexOf('e') + alfabeto.length()) % alfabeto.length();

        // Desencriptamos usando el desplazamiento encontrado
        return encriptar(text, alfabeto.length() - shift);
    }
}
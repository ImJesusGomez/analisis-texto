import java.util.Objects;
import java.util.Scanner;
import java.io.*;

public class Main {
    // Importamos la clase scanner para pedir por teclado el texto al usario
    public static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        
        // Le pedimos el texto al usuario
        System.out.println("Ingresa un texto, por favor: ");
        String texto = teclado.readLine();

        // 1. Contar el número de palabras en el texto.
        String[] arrTexto = texto.split(" ");
        int cantPalabras = arrTexto.length;

        // 2. Identificar la palabra más larga y la palabra más corta.
        String palabraMasLarga = arrTexto[0];
        String palabraMasCorta = arrTexto[0];

        for (String palabra : arrTexto) {
            if (palabra.length() > palabraMasLarga.length()) {
                palabraMasLarga = palabra;
            }
            if (palabra.length() < palabraMasCorta.length()) {
                palabraMasCorta = palabra;
            }
        }

        // 3. Contar el número de veces que aparece cada letra en el texto.

        // 4. Convertir el texto a minúsculas y mayúsculas.
        String textoMayusculas = texto.toUpperCase();
        String textoMinusculas = texto.toLowerCase();

        // 5. Eliminar los espacios en blanco al principio y al final del texto.
        String textoSinEspacios = texto.trim();
        
        // Analisis del Texto
        System.out.println("\n------ Análisis del Texto: -------");
        System.out.println("- Cantidad de Palabras = " + cantPalabras);
        System.out.println("- Palabra más larga = " + palabraMasLarga);
        System.out.println("- Palabra más corta = " + palabraMasCorta);
        System.out.println("- Veces que aparece cada letra en el texto: ");
        String[] letras = texto.split("");
        char[] caracteres = texto.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            char actual = caracteres[i];

            // Si el caracter es un espacio, no lo contamos
            if (actual == ' ') {
                continue;
            }

            // Verificar si ya se ha contado este caracter
            boolean yaContado = false;
            for (int j = 0; j < i; j++) {
                if (caracteres[j] == actual) {
                    yaContado = true;
                    break;
                }
            }

            // Si el caracter ya ha sido contado, saltamos al siguiente
            if (yaContado) {
                continue;
            }

            // Contar repeticiones del caracter actual
            int contador = 0;
            for (char c : caracteres) {
                if (c == actual) {
                    contador++;
                }
            }
            System.out.println("Letra " + actual + " se repite " + contador + " veces");
        }
        System.out.println("- Texto en mayúsculas: \n" + textoMayusculas);
        System.out.println("- Texto en minúsculas: \n" + textoMinusculas);
        System.out.println("- Eliminar los espacios en blanco al principio y al final del texto: \n" + textoSinEspacios);
        System.out.println("- Validar si el texto contiene una palabra o frase específica.");
        System.out.println("Ingresa una palabra o frase a validar");
        String validarTexto = teclado.readLine();
        if(texto.contains(validarTexto)){
            System.out.println("El texto SI contiene '" + validarTexto + "'");
        } else{
            System.out.println("El texto NO contiene '" + validarTexto + "'");
        }
    }
}
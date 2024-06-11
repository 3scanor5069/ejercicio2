package org.ejercicio5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EstadisticasTexto {
    public static void main(String[] args) {
        String nombreArchivo = "texto.txt"; // Nombre del archivo a leer
        File archivo = new File(nombreArchivo);
        System.out.println("Ruta absoluta del archivo: " + archivo.getAbsolutePath());

        try {
            // Lee el archivo y procesa el texto
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            StringBuilder texto = new StringBuilder();
            while ((linea = lector.readLine()) != null) {
                texto.append(linea).append("\n");
            }
            lector.close();

            // Calcula las estadísticas
            String contenido = texto.toString();
            int totalPalabras = contarPalabras(contenido);
            int totalOraciones = contarOraciones(contenido);
            String palabraMasFrecuente = encontrarPalabraMasFrecuente(contenido);
            double longitudPromedio = calcularLongitudPromedio(contenido);

            // Muestra los resultados
            System.out.println("Estadísticas del texto:");
            System.out.println("Número total de palabras: " + totalPalabras);
            System.out.println("Número total de oraciones: " + totalOraciones);
            System.out.println("Palabra más frecuente: " + palabraMasFrecuente);
            System.out.println("Longitud promedio de las palabras: " + longitudPromedio);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para contar el número total de palabras en el texto
    private static int contarPalabras(String texto) {
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }

    // Método para contar el número total de oraciones en el texto
    private static int contarOraciones(String texto) {
        String[] oraciones = texto.split("[.!?]");
        return oraciones.length;
    }

    // Método para encontrar la palabra más frecuente en el texto
    private static String encontrarPalabraMasFrecuente(String texto) {
        String[] palabras = texto.split("\\s+");
        // Implementación de la lógica para encontrar la palabra más frecuente
        return "implementación pendiente";
    }

    // Método para calcular la longitud promedio de las palabras en el texto
    private static double calcularLongitudPromedio(String texto) {
        String[] palabras = texto.split("\\s+");
        int totalCaracteres = 0;
        for (String palabra : palabras) {
            totalCaracteres += palabra.length();
        }
        return (double) totalCaracteres / palabras.length;
    }
}


package Tema2_Hilos.CompruebaTuAprendizaje.Ejercicio10;

import java.io.*;

// Productor que lee caracteres del fichero
public class Productor extends Thread {
    private Cola cola;
    private String nombreFichero;

    public Productor(Cola cola, String nombreFichero) {
        this.cola = cola;
        this.nombreFichero = nombreFichero;
    }

    @Override
    public void run() {
        try (FileReader fr = new FileReader(nombreFichero);
             BufferedReader br = new BufferedReader(fr)) {

            int caracter;
            // Leer caracteres del fichero uno a uno
            while ((caracter = br.read()) != -1) {
                cola.put((char) caracter);
            }

            // Indicar que se terminó de leer el fichero
            cola.setFinalizado(true);
            System.out.println("Productor ha finalizado");

        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado: " + nombreFichero);
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}